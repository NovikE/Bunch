package matrix;
import java.util.Scanner;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Please, enter number of strings:");
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        System.out.println("Please, enter number of columns:");
        int c = in.nextInt();

        int[][] array = new int[s][c];

        Random ran = new Random();

        int r = ran.nextInt();
        System.out.println("Initial matrix:");

        for (int i = 0; i < s; i++) {
            for (int j = 0; j < c; j++) {
                r = ran.nextInt(160);
                array[i][j] = r;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Transposed matrix:");
        int[][] tr_array = new int[c][s];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < s; j++) {
                tr_array[i][j] = array[j][i];
                System.out.print(tr_array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
