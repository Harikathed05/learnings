package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

class TreeNode {
    public int val;
    public List<TreeNode> children;

    public TreeNode() {}

    public TreeNode(int _val) {
        val = _val;
    }
    // Utility function to create a new tree node
    public TreeNode(int _val, List<TreeNode> _children) {
        val = _val;
        children = _children;
    }
};
public class NAryLevelOrder {

    public HashMap<Integer, List<Integer>> levelNodeMap = new HashMap<>();
    public void levelOrderNode(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (levelNodeMap.containsKey(level)) {
            List<Integer> levelNodeList = levelNodeMap.get(level);
            levelNodeList.add(node.val);
            levelNodeMap.put(level, levelNodeList);
        } else {
            List<Integer> newlevelNodeList = new ArrayList<>();
            newlevelNodeList.add(node.val);
            levelNodeMap.put(level, newlevelNodeList);
        }
        if (!Objects.isNull(node.children)) {
            for (TreeNode child : node.children) {
                levelOrderNode(child, level + 1);
            }
        }

    }

    public static void main(String[] args)
    {
        NAryLevelOrder nAryLevelOrder = new NAryLevelOrder();
        TreeNode root = new TreeNode(1);
        List<TreeNode> childsOfRoot = new ArrayList<>();
        childsOfRoot.add(new TreeNode(3));
        childsOfRoot.add(new TreeNode(2));
        childsOfRoot.add(new TreeNode(4));
        root.children = childsOfRoot;
        List<TreeNode> childsOfOneLevel = new ArrayList<>();
        childsOfOneLevel.add(new TreeNode(5));
        childsOfOneLevel.add(new TreeNode(6));
        root.children.get(0).children = childsOfOneLevel;
        nAryLevelOrder.levelOrderNode(root, 0);

        nAryLevelOrder.levelNodeMap.forEach((key, value) -> System.out.println("key " + key + " values " + value.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",")
                )));
    }
}
