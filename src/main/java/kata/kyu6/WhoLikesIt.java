package kata.kyu6;

public class WhoLikesIt {

    public static final String AND = " and ";

    private WhoLikesIt() {}

    public static String whoLikesIt(String... names) {
        int length = names.length;
        return switch (names.length) {
            case 0 -> "no one likes this";
            case 1 -> names[0] + " likes this";
            case 2 -> names[0] + AND + names[1] + " like this";
            case 3 -> names[0] + ", " + names[1] + AND + names[2] + " like this";
            default -> names[0] + ", " + names[1] + AND + (length - 2) + " others like this";
        };
    }
}
