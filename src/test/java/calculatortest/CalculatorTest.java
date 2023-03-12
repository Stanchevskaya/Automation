package calculatortest;

import org.calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private static Calculator calculator;

    @BeforeAll
    public static void init(){
        calculator = new Calculator();
        System.out.println("Before all");
    }

    @Test
    @DisplayName("Test divide 15 / 3")
    public void testDivide() {
        System.out.println("Test 1");
        int result = calculator.divide(15, 3);
        assertEquals(5, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test add 15 + 3")
    public void testAdd() {
        System.out.println("Test 2");
        int result = calculator.add(15, 3);
        Assertions.assertTrue(result == 18, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test subtract 15 - 3")
    public void testSubtract() {
        System.out.println("Test 3");
        int result = calculator.subtract(15, 3);
        assertEquals(12, result, "Result is wrong: " + result);
    }

    @Test
    @DisplayName("Test multiply 15 * 3")
    public void testMultiply() {
        System.out.println("Test 4");
        int result = calculator.multiply(15, 3);
        assertEquals(45, result, "Result is wrong: " + result);
    }

    @ParameterizedTest
    @MethodSource("integerStreamProvider")
    @DisplayName("Parameterized divide")
    public void testDivide(int a, int b, int expected) {
        System.out.println("Test 5");
        int result = calculator.divide(a, b);
        assertEquals(result, expected, "Result is wrong: " + result);
    }
    public static Stream<Arguments> integerStreamProvider() {
        return Stream.of(
                Arguments.arguments(15,3,5),
                Arguments.arguments(16,2,8));

    }

    @Test
    @DisplayName("Test exception / by zero")
    void exceptionTesting () {
        System.out.println("Test 6");
        ArithmeticException exception = assertThrows(ArithmeticException.class, () ->  calculator.divide(5, 0));
        assertEquals("/ by zero", exception.getMessage());
    }

    @ParameterizedTest
    @MethodSource("integerStreamProvider2")
    @DisplayName("Parameterized multiply")
    public void testMultiply(int a, int b, int expected) {
        System.out.println("Test 7");
        int result = calculator.multiply(a, b);
        assertEquals(result, expected, "Result is wrong: " + result);
    }
    public static Stream<Arguments> integerStreamProvider2() {
        return Stream.of(
                Arguments.arguments(3,3,9),
                Arguments.arguments(5,2,10));

    }

}
