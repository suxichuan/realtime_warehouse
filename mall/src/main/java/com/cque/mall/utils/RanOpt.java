package com.cque.mall.utils;

/**
 * @school:cque
 * @author:suxichuan
 * @create： 2022/11/15:15:01:05
 */
public class RanOpt<T> {
    T value ;
    int weight;

    public RanOpt ( T value, int weight ){
        this.value=value ;
        this.weight=weight;
    }

    public T getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "RanOpt{" +
              "value=" + value +
              ", weight=" + weight +
              '}';
    }
}
