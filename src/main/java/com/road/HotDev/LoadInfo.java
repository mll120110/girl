package com.road.HotDev;

/**
 * 封装加载类的信息
 */
public class LoadInfo {
    //自定义类加载器
    private MyClassLoader myClassLoader;
    //记录加载类的时间戳--》加载的时间
    private Long loadTime;
    private BaseManager baseManager;

    public LoadInfo(MyClassLoader myClassLoader, long loadTime) {
        super();
        this.myClassLoader = myClassLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClassLoader() {
        return myClassLoader;
    }

    public void setMyClassLoader(MyClassLoader myClassLoader) {
        this.myClassLoader = myClassLoader;
    }

    public Long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getBaseManager() {
        return baseManager;
    }

    public void setBaseManager(BaseManager baseManager) {
        this.baseManager = baseManager;
    }
}
