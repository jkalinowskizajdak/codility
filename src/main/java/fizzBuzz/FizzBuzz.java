package fizzBuzz;

public class FizzBuzz {

    private static void fizzBuzz() {
        for (int i = 1; i < 101; i++) {
            String result = "";
            if (i % 3 == 0) {
                result = result + "fizz";
            }
            if (i % 5 == 0) {
                result = result + "buzz";
            }
            if (result.isEmpty()) {
                result = result + i;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        fizzBuzz();
    }
}
