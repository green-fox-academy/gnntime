public class Cuboid {
    public static void main(String[] args) {
        double a = 5.0;
        double b = 5.0;
        double c = 5.0;

        // Computation
        double area = (a + b + c);
        double vol = (a * b * c);

        //Typecasting double to integer
        int valueA = (int)area;
        int valueB = (int)vol;

        //Printing Results
        System.out.println(valueA);
        System.out.println(valueB);


    }
}
