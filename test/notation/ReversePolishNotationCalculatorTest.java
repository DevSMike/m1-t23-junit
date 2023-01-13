package notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.NoSuchElementException;

public class ReversePolishNotationCalculatorTest {

    private final ReversePolishNotationCalculator calculator = new ReversePolishNotationCalculator();
    @Test
    public void shouldCalculateAddition() {
        Assertions.assertEquals(7, calculator.calculatePolishNotation("4 3 +"));
    }

    @Test
    public void shouldCalculateSubtraction() {
        Assertions.assertEquals(0, calculator.calculatePolishNotation("1 1 -"));
    }

    @Test
    public void shouldCalculateMultiplication() {
        Assertions.assertEquals(30, calculator.calculatePolishNotation("2 3 5 * *"));
    }

    @Test
    public void shouldCalculateNegativeNumbers() {
        Assertions.assertEquals(-2, calculator.calculatePolishNotation("-1 -1 +"));
    }
    @Test
    public void shouldNotCalculateNumbersNotSplitBySpace() {
        Assertions.assertThrows(NoSuchElementException.class, getExecutableForCalculator("1011 *"));
    }

    @Test
    public void shouldNotCalculateUnknownOperation() {
        Assertions.assertThrows(NumberFormatException.class, getExecutableForCalculator("-1 10 /"));
    }

    private Executable getExecutableForCalculator(String str) {
        return () -> calculator.calculatePolishNotation(str);
    }
}