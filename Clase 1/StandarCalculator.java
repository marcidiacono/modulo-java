public abstract class StandarCalculator implements ICalculator {

    @Override
    public void add(int a, int b) {
        System.out.println("a + b = " + (a + b));
        
    }

    @Override
    public void multiply(int a, int b) {
        System.out.println("a * b = " + (a * b));
        
    }

    @Override
    public abstract void substract(int a, int b);

    
    public void circleArea(double r) {
        System.out.println(PI * r * r);
    }

    public abstract void circlePerimeter(double r);

}
