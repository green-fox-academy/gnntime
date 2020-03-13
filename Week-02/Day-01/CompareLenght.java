public class CompareLenght {

    public static void main(String[] args) {
        int [] firstArrayOfNumbers = {1, 2, 3};
        int [] secondArrayOfNumbers = {4, 5};

        if (secondArrayOfNumbers.length > firstArrayOfNumbers.length) {

            System.out.println("secondArrayOfNumbers is longer");
        } else {
            System.out.println("firstArrayOfNumbers is longer");
        }
    }
}
