public class Factorio {
    public static void main(String[] args) {
        int example = 5;
        System.out.println(factorio(example));
    }
    public  static int factorio(int a){
        int fact = 1;
        for (int i = 1; i <= a ; i++) {
            fact = fact * i;

        }
        return fact;
    }
}
