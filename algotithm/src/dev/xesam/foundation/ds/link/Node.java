package dev.xesam.foundation.ds.link;

/**
 * 数据节点
 * <p/>
 * Created by xe xesamguo@gmail.com on 15-8-19.
 */
public class Node {
    int iData;
    Node previous;
    Node next;

    public Node(int iData) {
        this.iData = iData;
    }

    @Override
    public String toString() {
        return "Link{" +
                "iData=" + iData +
                '}';
    }
}
