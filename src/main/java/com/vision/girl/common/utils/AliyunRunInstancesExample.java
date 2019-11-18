package com.vision.girl.common.utils;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.AcsRequest;
import com.aliyuncs.AcsResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.ecs.model.v20140526.RunInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.RunInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.List;

public class AliyunRunInstancesExample {

    private String accessKeyId = "<AccessKey>";
    private String accessSecret = "<AccessSecret>";

    private static final String INSTANCE_STATUS_RUNNING = "Running";
    private static final int INSTANCE_STATUS_CHECK_INTERVAL_MILLISECOND = 3000;
    private static final long INSTANCE_STATUS_TOTAL_CHECK_TIME_ELAPSE_MILLISECOND = 60000 * 3;

    /**
     * 是否只预检此次请求。true：发送检查请求，不会创建实例，也不会产生费用；false：发送正常请求，通过检查后直接创建实例，并直接产生费用
     */
    private static final boolean dryRun = false;
    /**
     * 实例所属的地域ID
     */
    private String regionId = "ap-northeast-1";
    /**
     * 实例的资源规格
     */
    private String instanceType = "ecs.t5-lc2m1.nano";
    /**
     * 实例的计费方式
     */
    private String instanceChargeType = "PrePaid";
    /**
     * 镜像ID
     */
    private String imageId = "centos_7_06_64_20G_alibase_20190711.vhd";
    /**
     * 指定新创建实例所属于的安全组ID
     */
    private String securityGroupId = "sg-6we1vilxiwpph0alvr9l";
    /**
     * 预付费实例到期后是否自动续费
     */
    private boolean autoRenew = true;
    /**
     * 购买资源的时长
     */
    private Integer period = 1;
    /**
     * 购买资源的时长单位
     */
    private String periodUnit = "Month";
    /**
     * 实例所属的可用区编号
     */
    private String zoneId = "random";
    /**
     * 网络计费类型
     */
    private String internetChargeType = "PayByTraffic";
    /**
     * 虚拟交换机ID
     */
    private String vSwitchId = "vsw-6wernobi6h9pokd6j2czi";
    /**
     * 实例名称
     */
    private String instanceName = "launch-advisor-20191112";
    /**
     * 指定创建ECS实例的数量
     */
    private Integer amount = 1;
    /**
     * 公网出带宽最大值
     */
    private Integer internetMaxBandwidthOut = 100;
    /**
     * 是否为I/O优化实例
     */
    private String ioOptimized = "optimized";
    /**
     * 是否开启安全加固
     */
    private String securityEnhancementStrategy = "Active";
    /**
     * 系统盘大小
     */
    private String systemDiskSize = "20";
    /**
     * 系统盘的磁盘种类
     */
    private String systemDiskCategory = "cloud_efficiency";

    public static void main(String[] args) {
        /**
         * 使用须知： 调用 OpenAPI 创建实例会自动扣费，请谨慎调用 您的账号必须支持账号余额支付或信用支付，请确保金额充足
         *
         * 调用创建实例API后会查询实例的状态，直到变成Running为止
         *
         * 由于实例的密码为敏感信息，故不在这里显示，您可调用setPassword自行设置密码
         */
        new AliyunRunInstancesExample().callToRunInstances();
    }

    /**
     * 调用创建实例的API，得到实例ID后继续查询实例状态
     */
    public void callToRunInstances() {
        AcsResponse response = callOpenApi(composeRunInstancesRequest());
        if (response == null) {
            return;
        }
        logInfo(String.format("Success. Instance creation succeed. InstanceIds: %s",
            JSON.toJSONString(((RunInstancesResponse)response).getInstanceIdSets())));
        callToDescribeInstances(((RunInstancesResponse)response).getInstanceIdSets());
    }

    private RunInstancesRequest composeRunInstancesRequest() {
        RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
        runInstancesRequest.setDryRun(dryRun);
        runInstancesRequest.setRegionId(regionId);
        runInstancesRequest.setInstanceType(instanceType);
        runInstancesRequest.setInstanceChargeType(instanceChargeType);
        runInstancesRequest.setImageId(imageId);
        runInstancesRequest.setSecurityGroupId(securityGroupId);
        runInstancesRequest.setAutoRenew(autoRenew);
        runInstancesRequest.setPeriod(period);
        runInstancesRequest.setPeriodUnit(periodUnit);
        runInstancesRequest.setZoneId(zoneId);
        runInstancesRequest.setInternetChargeType(internetChargeType);
        runInstancesRequest.setVSwitchId(vSwitchId);
        runInstancesRequest.setInstanceName(instanceName);
        runInstancesRequest.setAmount(amount);
        runInstancesRequest.setInternetMaxBandwidthOut(internetMaxBandwidthOut);
        runInstancesRequest.setIoOptimized(ioOptimized);
        runInstancesRequest.setSecurityEnhancementStrategy(securityEnhancementStrategy);
        runInstancesRequest.setSystemDiskSize(systemDiskSize);
        runInstancesRequest.setSystemDiskCategory(systemDiskCategory);

        return runInstancesRequest;
    }

    /**
     * 每3秒中检查一次实例的状态，超时时间设为3分钟.
     * 
     * @param instanceIds
     *            需要检查的实例ID
     */
    private void callToDescribeInstances(List<String> instanceIds) {
        Long startTime = System.currentTimeMillis();
        for (;;) {
            sleepSomeTime(INSTANCE_STATUS_CHECK_INTERVAL_MILLISECOND);
            DescribeInstancesRequest describeInstancesRequest = new DescribeInstancesRequest();
            describeInstancesRequest.setRegionId(regionId);
            describeInstancesRequest.setInstanceIds(JSON.toJSONString(instanceIds));
            DescribeInstancesResponse describeInstancesResponse = callOpenApi(describeInstancesRequest);
            Long timeStamp = System.currentTimeMillis();
            if (describeInstancesResponse == null) {
                continue;
            } else {
                for (DescribeInstancesResponse.Instance instance : describeInstancesResponse.getInstances()) {
                    if (INSTANCE_STATUS_RUNNING.equals(instance.getStatus())) {
                        instanceIds.remove(instance.getInstanceId());
                        logInfo(String.format("Instance boot successfully: %s", instance.getInstanceId()));
                    }
                }
            }
            if (instanceIds.size() == 0) {
                logInfo("Instances all boot successfully.");
                return;
            }
            if (timeStamp - startTime > INSTANCE_STATUS_TOTAL_CHECK_TIME_ELAPSE_MILLISECOND) {
                if (instanceIds.size() > 0) {
                    logInfo(String.format("Instances boot failed within %s mins: %s",
                        INSTANCE_STATUS_TOTAL_CHECK_TIME_ELAPSE_MILLISECOND / 60000, JSON.toJSONString(instanceIds)));
                } else {
                    logInfo("Instances all boot successfully.");
                }
                return;
            }
        }
    }

    /**
     * 调用OpenAPI的方法，这里进行了错误处理
     *
     * @param request
     *            AcsRequest, Open API的请求
     * @param <T>
     *            AcsResponse 请求所对应返回值
     * @return 返回OpenAPI的调用结果. 如果调用失败，则会返回null
     */
    private <T extends AcsResponse> T callOpenApi(AcsRequest<T> request) {
        IAcsClient client = initClient();
        try {
            T response = client.getAcsResponse(request, false, 0);
            logInfo(String.format("Success. OpenAPI Action: %s call successfully.", request.getActionName()));
            return response;
        } catch (ServerException e) {
            logInfo(String.format("Fail. Something with your connection with Aliyun go incorrect. ErrorCode: %s",
                e.getErrCode()));
        } catch (ClientException e) {
            logInfo(
                String.format("Fail. Business error. ErrorCode: %s, RequestId: %s", e.getErrCode(), e.getRequestId()));
        }
        return null;
    }

    /**
     * 需要填充账号的AccessKey ID，以及账号的Access Key Secret
     */
    private IAcsClient initClient() {
        IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        return new DefaultAcsClient(profile);
    }

    private static void sleepSomeTime(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void logInfo(String message) {
        System.out.println(message);
    }
}