package com.jh.study.bitree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class BiTree {

    private BiTreeNode root;

    protected BiTree() {
    }

    public static BiTree create(BiTreeNode root) {
        BiTree biTree = new BiTree();
        biTree.root = root;
        return biTree;
    }

    private void preOrderTraversePriv(BiTreeNode parent, List<BiTreeNode> list) {
        if (parent == null) {
            return;
        }
        list.add(parent);
        preOrderTraversePriv(parent.getLeftChild(), list);
        preOrderTraversePriv(parent.getRightChild(), list);
    }

    public List<BiTreeNode> preOrderTraverse() {
        List<BiTreeNode> list = new ArrayList<>();
        preOrderTraversePriv(root, list);
        return list;
    }

    private void inOrderTraversePriv(BiTreeNode parent, List<BiTreeNode> list) {
        if (parent == null) {
            return;
        }
        inOrderTraversePriv(parent.getLeftChild(), list);
        list.add(parent);
        inOrderTraversePriv(parent.getRightChild(), list);
    }

    public List<BiTreeNode> inOrderTraverse() {
        List<BiTreeNode> list = new ArrayList<>();
        inOrderTraversePriv(root, list);
        return list;
    }

    private void postOrderTraversePriv(BiTreeNode parent, List<BiTreeNode> list) {
        if (parent == null) {
            return;
        }
        postOrderTraversePriv(parent.getLeftChild(), list);
        postOrderTraversePriv(parent.getRightChild(), list);
        list.add(parent);
    }

    public List<BiTreeNode> postOrderTraverse() {
        List<BiTreeNode> list = new ArrayList<>();
        postOrderTraversePriv(root, list);
        return list;
    }

    private void levelOrderTraversePriv(List<BiTreeNode> nodes, List<BiTreeNode> list) {
        List<BiTreeNode> nodes1 = new ArrayList<>();
        nodes.forEach(node -> {
            if (node != null) {
                list.add(node);
                BiTreeNode leftChild = node.getLeftChild();
                BiTreeNode rightChild = node.getRightChild();
                if (leftChild != null) {
                    nodes1.add(leftChild);
                }
                if (rightChild != null) {
                    nodes1.add(rightChild);
                }
            }
        });
        if (CollectionUtils.isEmpty(nodes1)) {
            return;
        }
        levelOrderTraversePriv(nodes1, list);
    }

    public List<BiTreeNode> levelOrderTraverse() {
        List<BiTreeNode> list = new ArrayList<>();
        List<BiTreeNode> nodes = new ArrayList<>();
        if (root != null) {
            nodes.add(root);
            levelOrderTraversePriv(nodes, list);
        }
        return list;
    }

}
