/* Copyright © 2020 Yuech and/or its affiliates. All rights reserved. */
package wiki.chenxun.blog.example.reply;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author 陈勋
 * @version 1.0
 * @date 2021-06-18 6:37 下午
 */
public class Tree {

    private String treeId;

    private List<Node> nodeList = new ArrayList<>();

    private Node rootNode;

    public Tree(String treeId,String data) {
        this.treeId = treeId;
        this.rootNode = Node.rootNote(UUID.randomUUID().toString(), treeId,data);
        nodeList.add(rootNode);
    }

    public String addNode(String data, String parentNodeId) {

        Node parentNode;
        if (parentNodeId != null) {
            parentNode = nodeList.stream()
                .filter(i -> parentNodeId.equals(i.getId()))
                .findFirst().orElse(null);
        } else {
            parentNode = rootNode;
        }
        if (parentNode == null) {
            throw new IllegalArgumentException("parent Node not exist");
        }

        final Integer parentRight = parentNode.getRight();
        // 本次新增node在树里面的编号
        final Integer nodeIndex = parentNode.getIndex() + (parentNode.getRight() - parentNode.getLeft() + 1) / 2;
        // 数深
        final Integer nodeDepth = parentNode.getDepth() + 1;

        // 构建子节点
        Node node = new Node(UUID.randomUUID().toString(), this.treeId,
            parentNode.getRight(), parentNode.getRight() + 1,
            nodeDepth, nodeIndex,
            parentNodeId, data);

        // 跟新其他节点左值
        nodeList.stream().filter(i -> i.getLeft() >= parentRight)
            .forEach(Node::incrementLeft);

        // 更新其他节点右值
        nodeList.stream().filter(i -> i.getRight() >= parentRight)
            .forEach(Node::incrementRight);

        // 更新其他节点编号，大于等于index都往后挪一个位置
        nodeList.stream().filter(i -> i.getIndex() >= nodeIndex)
            .forEach(Node::incrementIndex);
        //添加新节点
        nodeList.add(node);

        return node.getId();

    }

    /**
     * 测试打印，左序遍历
     */
    public void print() {
        nodeList.sort(Comparator.comparing(Node::getIndex));
        String s=String.join(",", nodeList.stream()
            .map(Node::getData).collect(Collectors.toList()));

        System.out.println(s);

    }

}
