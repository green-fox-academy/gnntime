public class DiagonalMatrix {
    public static void main(String[] args) {
        int [] [] dimMatrix = new int[4][4];

        for (int i = 0; i < dimMatrix.length ; i++) {
            for (int j = 0; j < dimMatrix[i].length ; j++) {
                dimMatrix[i][j]= 0;
                if (dimMatrix[i] == dimMatrix[j]) { dimMatrix[i][j] = 1;}
                System.out.print( " | " + dimMatrix[i][j] + " | " );
            }
            System.out.println();
        }
    }
}
