package lab6;

public class Item {
    public String name;
    public Integer cost;
    private Item(){
        this.name="default name";
        this.cost = 0;
    }
    public Item(String name,Integer cost){
        this.name=name;
        this.cost=cost;
    }
    @Override
    public boolean equals(Object other){
        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        if(other instanceof Item){
            Item otherItem = (Item) other;
            boolean flag=true;
            if(!otherItem.name.equals(this.name)){
                return false;
            }
            if(!otherItem.cost.equals(this.cost)){
                return false;
            }
            return flag;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return ((Integer)(this.name.hashCode() + this.cost.hashCode())).hashCode();
    }
}
