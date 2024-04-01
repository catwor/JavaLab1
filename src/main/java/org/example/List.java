package org.example;

public class List {

  private Node head;
  private Integer size;

  public List(){
    head = null;
    size = 0;
  }

  public void addElem(Integer elem, Integer index){
    if(size == 0){
      head = new Node(elem,null);
    }else{
      if(index == 0)
        head = new Node(elem,head);
      else{
        Node ptr = head;
        for(int i =0;i<Math.min(size,index)-1;++i)
          ptr = ptr.next;
      }
    }
  }


  private class Node{
    private Integer data;
    private Node next;

    public Node(Integer num, Node next) {
      this.data = num;
      this.next = next;
    }
  }
}
