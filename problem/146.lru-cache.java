import java.util.HashMap;

/*

运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

进阶:

你是否可以在 O(1) 时间复杂度内完成这两种操作？

示例:

LRUCache cache = new LRUCache( 2 ); // 缓存容量

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4

 */

class LRUCache {

  class Node {
    public Node pre;
    public Node next;
    public Integer key;
    public Integer value;

    public Node(Integer key, Integer value) {
      this.key = key;
      this.value = value;
    }
  }

  public int capacity;
  public HashMap<Integer, Node> nodes;
  public Node head;
  public Node tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    nodes = new HashMap<Integer, Node>();
    head = new Node(null, null);
    tail = new Node(null, null);
    head.next = tail;
    tail.pre = head;
  }

  public int get(int key) {
    if(nodes.containsKey(key)) {
      Node node = nodes.get(key);
      appendTail(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if(nodes.containsKey(key)) {
      Node node = nodes.get(key);
      node.value = value;
      nodes.put(key, node);
      appendTail(node);
    } else {
      if(nodes.size() == capacity) {
        removeOld();
      }
      Node node = new Node(key, value);
      appendTail(node);
      nodes.put(key, node);
    }
  }

  private void removeOld() {
    Node temp = head.next;
    head.next = temp.next;
    temp.next.pre = head;
    nodes.remove(temp.key);
  }

  private void appendTail(Node node) {
    if(node.pre != null && node.next != null) {
      node.pre.next = node.next;
      node.next.pre = node.pre;
    }
    node.next = tail;
    node.pre = tail.pre;
    tail.pre.next = node;
    tail.pre = node;
  }
}