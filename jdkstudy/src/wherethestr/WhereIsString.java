package wherethestr;

public class WhereIsString {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        String s1 = "hello";
        String s2 = "he" + "llo";
        System.out.println(s1 == s2);
        String s3 = "he";
        String s4 = "llo";
        String s5 = s3 + s4;
        System.out.println(s1 == s5);

    }
}
