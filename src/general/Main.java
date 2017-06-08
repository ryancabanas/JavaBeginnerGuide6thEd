/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
//import chapter01.*;
//import chapter02.*;
//import chapter03.*;
//import chapter05.*;
//import chapter06.*;
//import chapter07.*;
//import chapter08.*;
//import chapter09.*;

//import java.util.Arrays;

public class Main {
  
  public static void main(String[] args) {

    List myObjList = new ArrayList();
    GenericContainer rawContainer = new GenericContainer(5);
    System.out.println(rawContainer.getObj());

    // Store instances of ObjectContainer
    for(int x=0; x <=10; x++){
        ObjectContainer myObj = new ObjectContainer();
        myObj.setObj("Test" + x);
        myObjList.add(myObj);
    }
    // Get the objects we need to cast
    for(int x=0; x <= myObjList.size()-1; x++){
        ObjectContainer obj = (ObjectContainer) myObjList.get(x); 
        System.out.println("Object Value: " + obj.getObj());
    }

    List<GenericContainer> genericList = new ArrayList<>();

    // Store instances of GenericContainer
    for(int x=0; x <=10; x++){
        GenericContainer<String> myGeneric = new GenericContainer<>();
        myGeneric.setObj(" Generic Test" + x);
        genericList.add(myGeneric);
    }

    // Get the objects; no need to cast to String
    for(GenericContainer<String> obj:genericList){
        String objectString = obj.getObj();
        // Do something with the string...here we will print it
        System.out.println(objectString);
    }
    
  }
}

class ObjectContainer {
    private Object obj;

    /**
     * @return the obj
     */
    public Object getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(Object obj) {
        this.obj = obj;
    }
    
}

class GenericContainer<T> {
    private T obj;

    public GenericContainer(){
    }
    
    // Pass type in as parameter to constructor
    public GenericContainer(T t){
        obj = t;
    }

    /**
     * @return the obj
     */
    public T getObj() {
        return obj;
    }

    /**
     * @param obj the obj to set
     */
    public void setObj(T t) {
        obj = t;
    }
}