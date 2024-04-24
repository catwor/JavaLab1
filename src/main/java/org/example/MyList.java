package org.example;

/**
 * @author Тетюхин Иван
 * Односвязный список
 */
public class MyList {

  private Node head;
  private Integer size;

  /**
   * Конструктор по умолчанию
   */
  public MyList(){
    head = null;
    size = 0;
  }

  /**
   * @return размер списка
   */
  public Integer getSize(){
    return size;
  }

  /**
   * Добавление элемента. ind = 0 для вставки в начало спискаx
   * @param num элемент для вставки
   * @param ind позиция для вставки
   */
  public void addElem(int num, int ind) {
    if(size == 0)
      head = new Node(num, null);
    else if(ind == 0)
      head = new Node(num, head);
    else {
      Node ptr = head;
      for(int i = 0; i < Math.min(size, ind) - 1; i++)
        ptr = ptr.getNext();
      ptr.setNext(new Node(num, ptr.getNext()));
    }
    size++;
  }

  /**
   * Удаление элемента
   * @param index индекс удаляемого элемента
   * @return флаг о выполнении операции
   * @throws ArrayIndexOutOfBoundsException попытка получить доступ к несуществующему элементу
   */
  public boolean delElem(Integer index){
    if(index>=size || index<0){
      throw new ArrayIndexOutOfBoundsException();
    }
    else{
      if(index == 0){
        head = head.getNext();
      }
      else{
        Node ptr = head;

        for(int i = 0; i < index-1; i++){
          ptr = ptr.getNext();
        }

        ptr.setNext(ptr.getNext().getNext());
      }
      --size;
      return true;
    }
  }
  /**
   * Редактирование элемента
   * @param elem число, на которое меняется элемент
   * @param index индес элемента для замены
   * @return флаг о выполнении операции
   * @throw ArrayIndexOutOfBoundsException попытка получить доступ к несуществующему элементу
   */
  public boolean editElem(Integer elem, Integer index){
    if(index>=size || index<0){
      throw new ArrayIndexOutOfBoundsException();
    }
    else{
      if(index == 0){
        head = head.getNext();
      }
      else{
        Node ptr = head;
        for(int i = 0; i < index; i++){
          ptr = ptr.getNext();
        }
        ptr.setData(elem);
      }
      return true;
    }
  }
  /**
   * Получение значения элемента
   * @param index индекс элемента
   * @return значение элемента с данным индексом
   * @throws ArrayIndexOutOfBoundsException попытка получить доступ к несуществующему элементу
   */
  public int getElem(int index){
    if(index >= size || index<0) {
      throw new ArrayIndexOutOfBoundsException();
    }
    else{
      Node ptr = head;
      for(int i = 0; i < index; i++){
        ptr = ptr.getNext();
      }
      return ptr.data;
    }
  }

  /**
   * преобразование списка в строку
   * @return строка состоящая из элементов списка
   */
  @Override
  public String toString(){
    String listString = "";
    Node ptr = head;

    for(int i=0;i<size;++i){
      listString +=ptr.getData() + " ";
      ptr = ptr.getNext();
    }

    return listString;
  }
  /**
   * @author Тетюхин Иван
   * Узел односвязного списка
   */
  private class Node{
    private Integer data;
    private Node next;
    /**
     * конструктор по умолчанию
     * @param num значение, которое хранится в узле
     * @param next следующий узел
     */
    public Node(Integer num, Node next) {
      this.data = num;
      this.next = next;
    }

    public Node getNext() {
      return next;
    }
    public void setNext(Node next){
      this.next = next;
    }
    public Integer getData(){
      return data;
    }
    public void setData(Integer data){
      this.data = data;
    }
  }
}
