import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        int[] numbers = {3, 1, 4, 8, 2};
        Sorter.sort(numbers);
        for(int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        
    //    Box<Util> box = new Box<Util>();
    //    box.add(new Pencil());
    //    box.add(new Pen());
    //    for(int i = 0; i < 2; i++) {
    //         System.out.println(box.get(i).toString());
    //         if(box.get(i) instanceof Pencil) {
    //             System.out.println(((Pencil)box.get(i)).sharpener());
    //         }
    //    } 
    //    Util firstUtil = box.get(0);
    //    System.out.println(firstUtil.toString());

        // List<Util> list = new ArrayList<Util>();
        // list.add(new Pencil());
        // list.add(new Pen());
        // Util firstUtil = list.get(0);
        // System.out.println(firstUtil.toString());

        // Box<Util> box = new Box<Util>();
        // box.add(new Pencil());
        // box.add(new Pen());
        // box.add(new RedPen());
        // box.add(new BluePen());

        // Box<Pen> penBox = new Box<Pen>();
        // Box.addInBox(new RedPen(), penBox);

        
    }
}
