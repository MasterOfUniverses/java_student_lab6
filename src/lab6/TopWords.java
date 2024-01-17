package lab6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.*;
public class TopWords {
    public static void task1() {
        String inputfilePath = "input1.txt";
        File inFile=new File(inputfilePath);
        Scanner input = null;
        try{
            input=new Scanner(inFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        String outputFileName = "output1.txt";
        PrintWriter output = null;
        try{
            output = new PrintWriter(outputFileName);
        }catch (Exception e){
            e.printStackTrace();
        }
        Map<String,Integer> data = new HashMap<>();
        while(input.hasNext()){
            String newWord = input.next();
            if(data.containsKey(newWord)){
                data.put(newWord,data.get(newWord)+1);
            }else{
                data.put(newWord,1);
            }
        }
        input.close();
        ArrayList<Map.Entry<String,Integer>> listData = new ArrayList<>(data.size());
        int index =0;
        for(Map.Entry<String,Integer> row:data.entrySet()){
            listData.add(index,row);
            index++;
        }
        Collections.sort(listData, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        for(int i=0;(i<10)&&(i<listData.size());i++){
            output.println(listData.get(i).getKey());
        }
        output.close();
    }
}
