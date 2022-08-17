@FunctionalInterface
public interface ICalculator {

    public double PI = 3.14;
    
    public static Calculator getInstance() {
        return new Calculator();
    }
    
    public void add(int a, int b);

    public default void multiply(int a, int b) {
        
    }

    public default void substract(int a, int b) {
        System.out.println("a - b = " + (a - b));
    }

}
