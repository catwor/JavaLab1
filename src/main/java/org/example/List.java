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

  public boolean delElem(Integer index){
    if(index>=size){
      return false;
    }
    else{
      if(index == 0){
        head = head.next;
      }
      else{
        Node ptr = head;

        for(int i = 0; i < index-1; i++){
          ptr = ptr.next;
        }

        ptr.next = ptr.next.next;
      }
      --size;
      return true;
    }
  }

  public boolean editElem(Integer elem, Integer index){
    if(index>=size){
      return false;
    }
    else{
      if(index == 0){
        head = head.next;
      }
      else{
        Node ptr = head;
        for(int i = 0; i < index; i++){
          ptr = ptr.next;
        }
        ptr.data = elem;
      }
      return true;
    }
  }

  public int getElem(int index){
    if(index >= size){
      throw new ArrayIndexOutOfBoundsException();
    }
    else{
      Node ptr = head;
      for(int i = 0; i < index; i++){
        ptr = ptr.next;
      }
      return ptr.data;
    }
  }

  @Override
  public String toString(){
    String listString = "";
    Node ptr = head;

    for(int i=0;i<size;++i){
      listString +=ptr.data + " ";
      ptr = ptr.next;
    }

    return listString;
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
