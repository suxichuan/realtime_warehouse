package com.cque.mall.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:14:59:33
 */
public class RandomNumString {
    public static final  String getRandNumString(int fromNum,int toNum,int count,String delimiter,boolean canRepeat){
        String numString ="";
        if(canRepeat){
            ArrayList<Integer> numList = new ArrayList<>();
            while (numList.size()<count){
                numList.add(fromNum+ new Random().nextInt(toNum-fromNum+1));
            }
            numString = StringUtils.join(numList, delimiter);
        }else{
            HashSet<Integer> numSet = new HashSet<>();
            if(count <= (toNum-fromNum+1)/2 ){
                while (numSet.size()<count){
                    numSet.add(fromNum+ new Random().nextInt(toNum-fromNum+1));
                }
            }else {
                HashSet<Integer> exNumSet = new HashSet<>();
                while (exNumSet.size() < ( (toNum-fromNum+1) -count)){
                    exNumSet.add(fromNum+ new Random().nextInt(toNum-fromNum+1));
                }

                for(int i=fromNum ;i<=toNum;i++ ){
                    if( !exNumSet.contains(i)){
                        numSet.add(i);
                    }
                }
            }
            numString = StringUtils.join(numSet, delimiter);
        }
        return  numString;
    }

    public static final  String getRandNumString(int fromNum,int toNum,int count,String delimiter){
        return  getRandNumString(  fromNum,  toNum,  count,  delimiter,true);
    }

    public static void main(String[] args) {
        System.out.println(getRandNumString(1, 3, 4, ",",false));
    }
}
