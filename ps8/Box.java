package ps8;

import java.util.ArrayList;
import java.util.Random;

public class Box<T> {

    public Box(ArrayList<T> items){
        this.Items = items;
    }

    public Box(){
        this.Items = new ArrayList<>();
    }

    public Box(Box<T> other){
        this(other.Items);
    }

    private ArrayList<T> Items;

    public ArrayList<T> getItems() {
        return Items;
    }

    public boolean isEmpty(){
        return Items.isEmpty();
    }

    public int size(){
        return Items.size();
    }

    public void add(T item){
        Items.add(item);
    }

    public T drawItem(){
        if(isEmpty()){
            return null;
        } else{
            Random random = new Random();
            int index = random.nextInt(size());
            T ret = Items.get(index);
            Items.remove(ret);
            return ret;
        }
    }

    public boolean equals(Object other){
        if(!(other instanceof Box)) return false;
        if(this == other) return true;
        @SuppressWarnings("unchecked")
        Box<T> box = (Box<T>) other;
        if(size() != ((Box<T>) other).size()) return false;
        for(int i = 0; i < size(); i++){
            T this_item = Items.get(i);
            T other_item = box.Items.get(i);
            if(!this_item.equals(other_item)) return false;
        }
        return true;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size(); i++){
            sb.append(Items.get(i));
            if(i > 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}
