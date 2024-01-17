package lab6;

public class MyStack<T> {
    private T[] data;
    private int currSize=0;
    private int maxSize=64;
    public MyStack(){
        this.maxSize=64;
        this.data =(T[])new Object[this.maxSize];
        this.currSize=0;
    }
    public MyStack(int capacity){
        if(capacity<=0){
            throw new ArrayIndexOutOfBoundsException("My Stack: non-positive stack size");
        }
        this.maxSize=capacity;
        this.data =(T[])new Object[this.maxSize];
        this.currSize=0;
    }
    public MyStack(T[] indata){
        this.maxSize=indata.length;
        this.data =(T[])new Object[this.maxSize];
        for(this.currSize=0;this.currSize<indata.length;this.currSize++){
            this.data[this.currSize]=indata[this.currSize];
        }
    }
    private void resize(int newCapacity){
        if(newCapacity*7/8 < this.currSize){
            this.resize(newCapacity*2);
            return;
        }
        this.maxSize=newCapacity;
        T[] newData = (T[]) new Object[this.maxSize];
        for(int i=0;i<this.currSize;i++){
            newData[i]=this.data[i];
        }
        this.data=newData;
    }
    public void push(T newElem){
        if(this.maxSize*7/8<currSize+1){
            this.resize(this.maxSize*2);
        }
        this.data[this.currSize++]=newElem;
    }
    public T peek(){
        return this.data[this.currSize-1];
    }
    public T pop(){
        if(this.currSize<1){
            throw new ArrayIndexOutOfBoundsException("Empty stack");
        }
        if(this.maxSize/2>currSize){
            this.resize(this.maxSize*2/3);
        }
        return this.data[--this.currSize];
    }
    public int size(){
        return this.currSize;
    }
    @Override
    public boolean equals(Object other){

        if (other == this) {
            return true;
        }
        if (other == null || other.getClass() != this.getClass()) {
            return false;
        }
        if(other instanceof MyStack){
            MyStack<T> otherStack = (MyStack<T>) other;
            boolean flag=true;
            if(this.currSize!=otherStack.currSize){
                return false;
            }
            for(int i=0;i<this.currSize;i++){
                if(! this.data[i].equals(otherStack.data[i])){
                    return false;
                }
            }
            return flag;
        }
        return false;
    }
    @Override
    public int hashCode(){
        Integer controllSum=0;
        for(int i=0;i<this.currSize;i++){
            controllSum+=this.data[i].hashCode();
            controllSum=controllSum.hashCode();
        }
        return controllSum;
    }
}
