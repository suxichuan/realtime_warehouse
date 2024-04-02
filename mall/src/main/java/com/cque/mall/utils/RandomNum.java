package com.cque.mall.utils;

import java.util.Random;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:59:04
 */
public class RandomNum {
    public static final  int getRandInt(int fromNum,int toNum){

        return   fromNum+ new Random().nextInt(toNum-fromNum+1);
    }



    public static final  int getRandInt(int fromNum,int toNum,Long seed){

        return   fromNum+ new Random(seed).nextInt(toNum-fromNum+1);
    }
}
