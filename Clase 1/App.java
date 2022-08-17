import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) throws Exception {
       
        ICalculator calc1 = new StandarCalculatorMini();

        ICalculator calc2 = new ScientificCalculator();

        ICalculator[] calculators = new ICalculator[2];
        calculators[0] = calc1;
        calculators[1] = calc2;
        for(int i = 0; i < calculators.length; i++) {
            calculators[i].add(4, 5);
            calculators[i].multiply(4, 5);
        }

        System.out.println(ICalculator.PI);

        ICalculator stdMini = new StandarCalculatorMini();
        stdMini.add(7,8 );
        

        ICalculator calculator = ICalculator.getInstance();
        calculator.add(2, 3);

        IFunctionalCalculator iAdd = (a, b) -> {
            System.out.println("La suma es: " + ( a + b));
        };

        IFunctionalCalculator iMultiply = (a, b) -> {
            System.out.println("El producto es: " + ( a * b));
        };

        IFunctionalCalculator iStringify = (a, b) -> {
            System.out.println("{ \"a\": " + a + ", \"b\": " + b + " }");
        };

        iAdd.operate(20, 5);
        iMultiply.operate(20, 5);
        iStringify.operate(20, 5);

        // Analicemos el paquete stream
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(5);
        lista.add(9);
        lista.add(2);
        lista.add(9);

        Stream<Integer> st = lista.stream();
        System.out.println(
            st.filter(Predicate.isEqual(9)).count()
        );

    }
}
