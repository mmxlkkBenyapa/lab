import java.util.Scanner;
import java.sql.SQLOutput;
import java.util.InputMismatchException;

public class XO_lab1 {
    static String [][] arr = new String[3][3];
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = "-";
            }
        }
        int score_X =0;
        int score_O =0;
        int score_DRAW =0;
        int t=0;
        boolean check = true;
        try {
            while(true) {
                output();
                if (check == true) {
                    System.out.print("X (col): ");
                    int col = kb.nextInt();
                    System.out.print("X (Row): ");
                    int row = kb.nextInt();
                    if (col < 3 && row < 3)
                        if (arr[row][col].equals("-")) {
                            arr[row][col] = "X";
                            check = false;
                            t++;
                            if (checkSocre().equals("X")) {
                                score_X++;
                                System.out.println("X WIN " + score_X);
                                System.out.println("O WIN " + score_O);
                                System.out.println("DRAW " + score_DRAW);
                                System.out.println("_______________________");
                                break;
                            }
                        }

                } else if (check == false) {
                    System.out.print("O (col): ");
                    int col = kb.nextInt();
                    System.out.print("O (Row): ");
                    int row = kb.nextInt();
                    if (col < 3 && row < 3)
                        if (arr[row][col].equals("-")) {
                            arr[row][col] = "O";
                            check = true;
                            t++;
                            if (checkSocre().equals("O")) {
                                score_O++;
                                System.out.println("X WIN " + score_X);
                                System.out.println("O WIN " + score_O);
                                System.out.println("DRAW " + score_DRAW);
                                System.out.println("_______________________");
                                break;
                            }
                        }
                }
                if (t == 9) {
                    output();
                    score_DRAW++;
                    System.out.println("X WIN " + score_X);
                    System.out.println("O WIN " + score_O);
                    System.out.println("DRAW " + score_DRAW);
                    System.out.println("_______________________");
                    break;
                }
            }
        }catch(InputMismatchException e){
            System.out.println("not int");
        }
    }

    public static void output(){
        System.out.println("  0 1 2");
        for(int k=0;k<3;k++){
            System.out.print(k+" ");
            for(int q=0;q<3;q++){
                System.out.print(arr[k][q]+" ");
            }
            System.out.println();
        }
    }
    public static String checkSocre() {
        int num =0;
        if(!arr[1][1].equals("-")) {
            if (arr[1][1].equals(arr[0][0]) && arr[1][1].equals(arr[2][2])) {
                return arr[1][1];
            } else if (arr[1][1].equals(arr[0][2]) && arr[1][1].equals(arr[2][0])) {
                return arr[1][1];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][0].equals(arr[i][j]) && !arr[i][0].equals("-")) {
                    num++;
                }
                if (num == 3) {
                    return arr[i][0];
                }
            }
            num = 0;
        }
        for (int n = 0; n < 3; n++) {
            for (int m = 0; m < 3; m++) {
                if (arr[0][n].equals(arr[m][n]) && !arr[0][n].equals("-")) {
                    num++;
                }
                if (num == 3) {
                    return arr[0][n];
                }
            }
            num = 0;
        }
        return "";
    }
}
