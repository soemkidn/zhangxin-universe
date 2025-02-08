package com.zhangxin.zhangxinuniverse.utils;

import com.zhangxin.zhangxinuniverse.common.BaseResponse;
import com.zhangxin.zhangxinuniverse.common.StatusCode;

/**
 * 返回工具类
 */
public class ResultUtils {

    /**
     * 成功
     *
     * @param data 返回的数据
     * @param <T> 返回数据的类型
     * @return 返回表示成功的封装信息类
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(0, data, "ok");
    }

    /**
     * 失败（使用错误码内部原生的消息和详情）
     *
     * @param statusCode 错误码
     * @return 表示错误的封装类
     */
    public static BaseResponse error(StatusCode statusCode) {
        return new BaseResponse<>(statusCode);
    }

    /**
     * 失败（为了支持甩出异常时像前端发送错误消息）
     *
     * @param code 错误码
     * @param message 返回的报错信息
     * @param description 报错信息详情
     * @return 返回包含报错信息的封装类
     */
    public static BaseResponse error(int code, String message, String description) {
        return new BaseResponse(code, null, message, description);
    }

    /**
     * 失败（在运行时错误时像前端发送错误信息）
     *
     * @param statusCode 错误码
     * @param message 返回的报错信息
     * @param description 报错信息详情
     * @return 含有错误信息的封装类
     */
    public static BaseResponse error(StatusCode statusCode, String message, String description) {
        return new BaseResponse(statusCode.getCode(), null, message, description);
    }


}
