package org.example;

import java.util.Scanner;

public class MenuForMyList implements IMenuForMyList {

  MyList myList;

  public MenuForMyList(MyList list){
    myList = list;
  }

  private Integer enterNumber() throws Exception {
    Scanner scanner = new Scanner(System.in);
    Integer result = 0;

    try{
      result = scanner.nextInt();
    }catch (Exception e){
      throw new Exception("ERROR: некорректный ввод");
    }

    return result;
  }

  @Override
  public Integer startMenu() throws Exception {
    System.out.println("1. Добавить элемент");
    System.out.println("2. Удалить элемент");
    System.out.println("3. Редактировать элемент");
    System.out.println("4. Получить элемент");
    System.out.println("5. Вывести все элементы");
    System.out.println("6. Завершить программу");

    Integer vb =0;
    do{
      vb = enterNumber();
    }while(vb<1 || vb>6);

    return vb;
  }

  @Override
  public void add() throws Exception {
    System.out.print("Введите число, которое хотите добавить: ");
    Integer elem = enterNumber();
    System.out.print("Введите индекс, после которого хотите добавить: ");
    Integer number = enterNumber();

    myList.addElem(number, elem);
  }

  @Override
  public void del() throws Exception {
    System.out.print("Введите индекс: ");
    Integer index = enterNumber();

    myList.delElem(index);
  }

  @Override
  public void edit() throws Exception {
    System.out.print("Введите индекс элемента, который желаете изменить: ");
    Integer index = enterNumber();
    System.out.print("Введите новое значение: ");
    Integer elem = enterNumber();

    myList.editElem(elem,index);
  }

  @Override
  public void get() throws Exception {
    System.out.println("Введите индекс элемента, который желаете получить: ");
    Integer index = enterNumber();

    Integer elem = myList.getElem(index);
    System.out.println("Значение, которое лежит по введенному индексу: " + elem.toString());
  }

  @Override
  public void show() {
    if(myList.getSize()>0)
      System.out.println("Элементы списка: " + myList.toString());
    else
      System.out.println("Список пуст");
  }
}
