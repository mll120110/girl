package com.vision.girl.user.service.impl;

import com.vision.girl.user.entity.BdDevice;
import com.vision.girl.user.mapper.BdDeviceMapper;
import com.vision.girl.user.service.IBdDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Jack Road
 * @since 2019-08-29
 */
@Service(value = "bdDeviceServiceImpl")
public class BdDeviceServiceImpl extends ServiceImpl<BdDeviceMapper, BdDevice> implements IBdDeviceService {

    @Autowired
    BdDeviceMapper bdDeviceMapper;

    /**
     * 创建设备信息
     *
     * @param bdDevice
     * @return
     */
    @Override
    public int createDevice(BdDevice bdDevice) {
        return bdDeviceMapper.insert(bdDevice);
    }
}
