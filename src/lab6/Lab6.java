package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args){
        TopWords.task1();
        Lab6.task2();
        Lab6.task3();
    }
    public static void task2(){
        /*
        String inputfilePath = "input2.txt";
        File inFile=new File(inputfilePath);
        Scanner input = null;
        try{
            input=new Scanner(inFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }*/
        String outputFileName = "output2.txt";
        PrintWriter output = null;
        try{
            output = new PrintWriter(outputFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        MyStack<Integer> data = new MyStack<>(10);
        data.push(1);
        data.push(2);
        data.push(3);
        output.println(data.pop());
        output.println(data.peek());
        data.push(4);
        output.println(data.pop());
        output.println(data.pop());
        output.close();
    }
    public static void task3(){
        String outputFileName = "output3.txt";
        PrintWriter output = null;
        try{
            output = new PrintWriter(outputFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        shopStat someStats = new shopStat();
        Item i1 = new Item("pencil",1);
        Item i2 = new Item("pen",3);
        Item i3 = new Item("notebook",10);
        Item i4 = new Item("workbook",20);
        Item i5 = new Item("studentbook",50);
        Item i6 = new Item("book",100);
        for(int i=0;i<30;i++){
            if(i<2){
                someStats.addItem(i6,1);
            }
            if(i<3){
                someStats.addItem(i5,1);
            }
            if(i<6){
                someStats.addItem(i4,1);
            }
            if(i<10){
                someStats.addItem(i3,1);
            }
            if(i<20){
                someStats.addItem(i1,1);
            }
            someStats.addItem(i2,1);
        }
        String[] itemsTotal = someStats.getItemNameList();
        for(String currItem:itemsTotal){
            output.println(currItem);
        }
        output.println(someStats.totalCost());
        itemsTotal = someStats.getTopPopularNames(3);
        for(String currItem:itemsTotal){
            output.println(currItem);
        }
        itemsTotal = someStats.getTopPopularNames(5);
        for(String currItem:itemsTotal){
            output.println(currItem);
        }
        itemsTotal = someStats.getTopPopularNames(10);
        for(String currItem:itemsTotal){
            output.println(currItem);
        }
        output.close();
    }
}
