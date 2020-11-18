package com.road.lock;

import java.util.concurrent.locks.StampedLock;

/**
 * 读写锁：StampedLock
 */
public class StampedLockDemo {
    private double x, y;
    private final StampedLock stampedLock = new StampedLock();

    void move(double deltaX, double deltaY) {
        // 独占式写入
        long stamp = stampedLock.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    double distanceFromOrigin() {
        // 乐观读
        long stamp = stampedLock.tryOptimisticRead();
        // 读内容到副本
        double currentX = x, currentY = y;
        // 调用validate来验证（如果被其他线程修改过了那么stamp就变了将返回false）
        if (!stampedLock.validate(stamp)) {
            // 验证失败了就用读锁（将阻塞写操作）
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                // 释放读锁
                stampedLock.unlockRead(stamp);
            }
        }
        // 验证成功直接使用变量值
        return Math.sqrt(currentX * currentX + currentY * currentY);
    }

    void moveIfAtOrigin(double newX, double newY) {
        // 获取读锁
        long stamp = stampedLock.readLock();
        try {
            // 判断某种条件，需要进行写的操作
            while (x == 0.0 && y == 0.0) {
                // 升级为写锁
                long ws = stampedLock.tryConvertToWriteLock(stamp);
                // 如果ws不为零表示升级成功并获取到写锁
                if (ws != 0L) {
                    stamp = ws;
                    x = newX;
                    y = newY;
                    break;
                }
                // 升级失败释放读锁并直接使用写锁
                else {
                    stampedLock.unlockRead(stamp);
                    stamp = stampedLock.writeLock();
                }
            }
        } finally {
            // 释放
            stampedLock.unlock(stamp);
        }
    }
}
