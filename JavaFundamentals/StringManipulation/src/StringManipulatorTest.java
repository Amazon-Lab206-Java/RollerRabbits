public class StringManipulatorTest {
    public static void main(String[] arg) {
        System.out.println("test 1:");
        test1();
        System.out.println("test 2:");
        test2();
        System.out.println("test 3:");
        test3();
        System.out.println("test 4:");
        test4();
    }

    public static void test1() {
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("    Hello     ", "     World    ");
        System.out.println(str); // HelloWorld

    }

    public static void test2() {
        StringManipulator manipulator = new StringManipulator();
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a); // 1
        System.out.println(b); // 4
        System.out.println(c); // null

    }

    public static void test3() {
        StringManipulator manipulator = new StringManipulator();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer a = manipulator.getIndexOrNull(word, subString);
        Integer b = manipulator.getIndexOrNull(word, notSubString);
        System.out.println(a); // 2
        System.out.println(b); // null

    }

    public static void test4() {
        StringManipulator manipulator = new StringManipulator();
        String word = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word); // eworld

    }
}
