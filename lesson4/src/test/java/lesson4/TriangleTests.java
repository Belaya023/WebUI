package lesson4;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class TriangleTests {
    Triangle triangle;

    @Test
    @DisplayName("Проверка создания треугольника")
    public void creatingTriangleTest(){
        triangle = new Triangle(5,2,4);
    }

    @Nested
    class NewTriangle {

        @BeforeEach
        void createNewTriangle() {
            triangle = new Triangle(12,13,14);
        }

        @Test
        @DisplayName("Это точно треугольник?")
        void isTriangleTest () {
            assertTrue(triangle.isTriangle());
        }

        @Test
        @DisplayName("Отрицательные значения")
        void negativeIntTest(){
            //for (Triangle triangle : Triangle.getSquare()){
                if (triangle.getA() < 0 && triangle.getB() < 0 && triangle.getC() < 0){
                    Assert.fail("Введено отрицательное значение");
                }
        }

        /*@Test
        @DisplayName("Вычисление площади с разными значениями")
        @ParameterizedTest
        @ValueSource(doubles = {13, 1, 6}, {1, 2, 3}, {-10, 2, 55})
        void getSquare_withDifferentValues_Test(double) {
            Triangle.getSquare()
        }*/
    }

}
