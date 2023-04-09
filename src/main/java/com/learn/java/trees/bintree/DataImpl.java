package com.learn.java.trees.bintree;
/*
 * Create By @author bhegde
 * Create On @date 8/7/2022
 *
 */

public class DataImpl extends Data {
    private float value;

    public DataImpl(float value) {
        this.value = value;
    }

    @Override
    public Float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    void printValue() {
        System.out.println(value);
    }

    @Override
    public int compareTo(Data o) {
        return this.getValue().compareTo(((DataImpl) o).getValue());
    }
}
