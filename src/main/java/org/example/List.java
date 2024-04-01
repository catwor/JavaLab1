package org.example;

public class List {

  private static class Node{
    private Integer data;
    private Node next;

    public Node(Integer num, Node next) {
      this.data = num;
      this.next = next;
    }

    public void setData(Integer data) {
      this.data = data;
    }

    public int getData() {
      return data;
    }

    public Node getNextElem() {
      return next;
    }

    public void setNextElem(Node nextElem) {
      this.next = nextElem;
    }
  }
}
