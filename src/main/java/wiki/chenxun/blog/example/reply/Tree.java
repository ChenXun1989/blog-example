/* Copyright © 2020 Yuech and/or its affiliates. All rights reserved. */
package wiki.chenxun.blog.example.reply;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author 陈勋
 * @version 1.0
 * @date 2021-06-18 6:37 下午
 */
public class Tree {

    private String treeId;

    private List<Node> nodeList = new ArrayList<>();

    private Node rootNote;

    public Tree(String treeId) {
        this.treeId = treeId;
        this.rootNote = Node.rootNote(UUID.randomUUID().toString(), treeId);
        nodeList.add(rootNote);
    }


}
