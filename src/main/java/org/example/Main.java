package org.example;

public class Main {

  public static void main(String[] args) {
    IMenuForMyList menu = new MenuForMyList(new MyList());
    boolean flag = true;

    while(flag){
      try{
        switch (menu.startMenu()){
          case 1:{
            menu.add();
            break;
          }
          case 2:{
            menu.del();
            break;
          }
          case 3:{
            menu.edit();
            break;
          }
          case 4:{
            menu.get();
            break;
          }
          case 5:{
            menu.show();
            break;
          }
          case 6:{
            flag = false;
            break;
          }
        }
      }catch (Exception ex){
        System.out.println("log: " + ex.getMessage());
      }
    }
  }
}