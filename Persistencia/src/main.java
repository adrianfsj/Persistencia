import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        int[][] matriz1 = leerMatriz("matriz1.txt");
        int[][] matriz2 = leerMatriz("matriz2.txt");

        int[][] resultado = multiplicarMatrices(matriz1, matriz2);

        escribirMatriz(resultado, "resultado.txt");
    }

    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int[][] resultado = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    public static int[][] leerMatriz(String archivo) {
        int[][] matriz = new int[3][3];

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int fila = 0;

            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(",");
                for (int i = 0; i < elementos.length; i++) {
                    matriz[fila][i] = Integer.parseInt(elementos[i]);
                }
                fila++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return matriz;
    }

    public static void escribirMatriz(int[][] matriz, String archivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    bw.write(String.valueOf(matriz[i][j]));
                    if (j != matriz[i].length - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
