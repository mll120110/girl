package com.vision.girl.common;

import lombok.Data;

import java.util.Collection;
import java.util.Map;

/**
 *
 */
@Data
public class ResultBean<T> {
    private int code;
    private String message;
    private T data;

    /**
     * 无参构造函数
     */
    public ResultBean() {}

    /**
     * 错误返回信息Bean
     * 
     * @param code
     * @param message
     * @return
     */
    public static ResultBean error(int code, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(code);
        resultBean.setMessage(message);
        return resultBean;
    }

    /**
     * 成功返回信息Bean的信息
     * 
     * @return
     */
    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    /**
     * 成功返回Object信息Bean的信息
     * 
     * @param object
     * @return
     */
    public static ResultBean success(Object object) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setData(object);
        resultBean.setMessage("success");
        return resultBean;
    }

    /**
     * Java集合由两类数据结构构成Collection、Map，构建2大类的数据返回Bean
     */

    /**
     * 成功返回信息Collection泛型Bean的信息
     * 
     * @param data
     * @return
     */
    public static <V> ResultBean<V> success(Collection<V> data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

    /**
     * 成功返回信息Map泛型Bean的信息
     * 
     * @param map
     * @return
     */
    public static <V> ResultBean<V> success(Map<V, V> map) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(map);
        return resultBean;
    }
}
