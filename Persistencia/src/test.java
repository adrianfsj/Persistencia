import org.junit.Assert;
import org.junit.Test;

public class test {

    @Test
    public void testMultiplicarMatrices() {
        int[][] matriz1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matriz2 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };

        int[][] resultadoEsperado = {
                {12, 12, 12},
                {30, 30, 30},
                {48, 48, 48}
        };

        int[][] resultado = main.multiplicarMatrices(matriz1, matriz2);

        Assert.assertArrayEquals(resultadoEsperado, resultado);
    }
}
