package com.jh.study.bitree;

import lombok.Data;

@Data
public class BiTreeNode {

    private String     data;
    private int        value;
    private BiTreeNode leftChild;
    private BiTreeNode rightChild;

    public BiTreeNode(String data, int value) {
        this.data = data;
        this.value = value;
    }

    public BiTreeNode(String data) {
        this(data, -1);
    }

    @Override
    public String toString() {
        return "" + data + "(" + value + ")";
    }
}
