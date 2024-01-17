package lab6;

import java.util.*;

public class shopStat {
    private HashMap<Item,Integer> data;
    public shopStat(){
        this.data = new HashMap<>();
    }
    public void addItem(Item newItem, Integer count){
        if(this.data.containsKey(newItem)){
            this.data.put(newItem,this.data.get(newItem)+count);
        }else{
            this.data.put(newItem,count);
        }
    }
    public Item[] getItemList(){
        return this.data.keySet().toArray(new Item[data.size()]);
    }
    public String[] getItemNameList(){
        String[] res = new String[this.data.size()];
        int count=0;
        for(Item currItem:this.data.keySet()){
            res[count]= currItem.name;
            count++;
        }
        return res;
    }
    public Integer getItemsNumber (Item askedItem){
        return this.data.getOrDefault(askedItem,0);
    }
    public Integer totalCost(){
        int res=0;
        for(Item currItem:this.data.keySet()){
            res+= currItem.cost*this.data.get(currItem);
        }
        return res;
    }
    public Item[] getTopPopular (int topCount){
        ArrayList<Map.Entry<Item,Integer>> sortedData = new ArrayList<Map.Entry<Item, Integer>>();

        int index =0;
        for(Map.Entry<Item,Integer> row:this.data.entrySet()){
            sortedData.add(index,row);
            index++;
        }
        Collections.sort(sortedData, new Comparator<Map.Entry<Item, Integer>>() {
            @Override
            public int compare(Map.Entry<Item, Integer> o1, Map.Entry<Item, Integer> o2) {
                return -o1.getValue().compareTo(o2.getValue());
            }
        });
        Item[] res = new Item[topCount< sortedData.size()?topCount: sortedData.size()];
        for(int i=0;i<res.length;i++){
            res[i] = sortedData.get(i).getKey();
        }
        return res;
    }
    public String[] getTopPopularNames(int topCount){
        Item[] topItems = this.getTopPopular(topCount);
        String[] names = new String[topItems.length];
        for(int i=0;i<topItems.length;i++){
            names[i]=topItems[i].name;
        }
        return names;
    }
}
