package com.cque.mall.bean;

import com.cque.mall.utils.RandomNum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:16:11:13
 */
@Data
@AllArgsConstructor
public class AppError {
    Integer error_code;

    String msg;

    public static  AppError build(){
        int errorCode = RandomNum.getRandInt(1001, 4001);
        String msg=" Exception in thread \\  java.net.SocketTimeoutException\\n \\tat com.cque.mall.bean.AppError.main(AppError.java:xxxxxx)";
        return new AppError(errorCode,msg);

    }
}
