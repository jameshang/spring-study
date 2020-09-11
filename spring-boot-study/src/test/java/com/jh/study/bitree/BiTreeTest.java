package com.jh.study.bitree;

import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BiTreeTest {

    @Test
    public void testBiTree() {
        BiTreeNode nodeA = new BiTreeNode("A");
        BiTreeNode nodeB = new BiTreeNode("B");
        BiTreeNode nodeC = new BiTreeNode("C");
        BiTreeNode nodeD = new BiTreeNode("D");
        BiTreeNode nodeE = new BiTreeNode("E");
        BiTreeNode nodeF = new BiTreeNode("F");
        BiTreeNode nodeG = new BiTreeNode("G");
        BiTreeNode nodeH = new BiTreeNode("H");
        BiTreeNode nodeI = new BiTreeNode("I");
        BiTreeNode nodeJ = new BiTreeNode("J");

        nodeA.setLeftChild(nodeB);
        nodeA.setRightChild(nodeC);
        nodeB.setLeftChild(nodeD);
        nodeB.setRightChild(nodeE);
        nodeC.setLeftChild(nodeF);
        nodeC.setRightChild(nodeG);
        nodeD.setLeftChild(nodeH);
        nodeD.setRightChild(nodeI);
        nodeE.setLeftChild(nodeJ);

        List<BiTreeNode> list;
        BiTree biTree = BiTree.create(nodeA);
        list = biTree.preOrderTraverse();
        log.info("{}", list);
        list = biTree.inOrderTraverse();
        log.info("{}", list);
        list = biTree.postOrderTraverse();
        log.info("{}", list);
        list = biTree.levelOrderTraverse();
        log.info("{}", list);
    }

}
