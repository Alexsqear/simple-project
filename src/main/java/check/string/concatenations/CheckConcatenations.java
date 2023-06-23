package check.string.concatenations;

public class CheckConcatenations {
    public static void main(String[] args) {
        long start = System.nanoTime();
        concatenateWithPlus();
        long end = System.nanoTime();
        System.out.println("concatenateWithPlus time = " + (end - start));

        start = System.nanoTime();
        concatenateWithBuilder();
        end = System.nanoTime();
        System.out.println("concatenateWithBuilder Time = " + (end - start));
//
        start = System.nanoTime();
        concatenateWithStringFormatter();
        end = System.nanoTime();
        System.out.println("concatenateWithStringFormatter time = " + (end - start));
    }

    public static String concatenateWithPlus() {
        String result = "aoaoao";
        result = result + "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd"+ "dfdkfd";

        return result;
    }

    public static String concatenateWithBuilder() {
        StringBuilder result = new StringBuilder("asasasa");
        result.append("asasas").append("asasas").append("asasas").append("asasas").append("asasas").append("asasas").append("asasas").append("asasas").append("asasas").append("asasas");
        return result.toString();
    }
//
    public static String concatenateWithStringFormatter() {
        String result = "session1";
        String.format("session1 %s",result);

        return result;
    }


}