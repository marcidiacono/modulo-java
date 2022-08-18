import java.util.ArrayList;

public class Box<T extends Util> {
    
    private ArrayList<T> obj;

    public Box() {
        obj = new ArrayList<T>();
    }

    public void add(T obj) {
        this.obj.add(obj);
    }

    public T get(int i) {
        return obj.get(i);
    }

    public static <T extends Pen> void addInBox(T t, Box<T> box) {
        box.add(t);
    }

}
