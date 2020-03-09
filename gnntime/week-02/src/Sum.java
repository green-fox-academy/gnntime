public class Sum {
    public static void main(String[] args) {
        int example = 10;
        System.out.println(sum(example));
    }
    public static int sum(int a){
        int calculated = 0;
        for (int i = 0; i <= a ; i++) {
            calculated = calculated + i;
        }
        return calculated;

    }

}
