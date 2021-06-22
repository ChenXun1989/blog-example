/* Copyright © 2020 Yuech and/or its affiliates. All rights reserved. */
package wiki.chenxun.blog.example.reply;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 陈勋
 * @version 1.0
 * @date 2021-05-19 3:43 下午
 */
@Getter
@AllArgsConstructor
public class Node {

    /**
     * 节点id
     */
    private String id;

    /**
     * 树id，一般是文章id
     */
    private String treeId;

    /**
     * 　左值
     */
    private Integer left;

    /**
     * 右值
     */
    private Integer right;

    /**
     * 树深
     */
    private Integer depth;

    /**
     * 编号
     */
    private Integer index;

    /**
     * 商城节点id
     */
    private String parentId;

    /**
     * 数据
     */
    private String data;

    public static Node rootNote(String id, String treeId,String data) {
        Node node = new Node(id, treeId, 1, 2, 0, 1, null, data);
        return node;
    }

    public void incrementLeft() {
        this.left += 2;
    }

    public void incrementRight() {
        this.right += 2;
    }

    public void incrementIndex() {
        this.index += 1;
    }

}
