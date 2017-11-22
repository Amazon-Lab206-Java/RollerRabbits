import java.util.ArrayList;

public class PuzzleTest {

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();

        ArrayList<Integer> testArray = createIntegerArray(3, 5, 1, 2, 7, 9, 8, 13, 25, 32);

        ArrayList<Integer> resultFromFilter = puzzle.printSumAndFilterGreaterThan10(testArray);
        System.out.println("result from filter: " + resultFromFilter);

        ArrayList<String> namesArrayList = createStringArray("Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa");
        ArrayList<String> stringResultsFromFilter = puzzle.shuffleArrayAndPrintNameAndFilterGreaterThan5Characters(namesArrayList);
        System.out.println("result from filter: " + stringResultsFromFilter);

        ArrayList<String> alphabet = createStringArray("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

        puzzle.shuffleAlphabetAndPrintStuff(alphabet);

        System.out.println(puzzle.generate10RandomNumbers());
        System.out.println(puzzle.generate10SortedRandomNumbers());

        System.out.println(puzzle.random5Chars());
    }

    private static ArrayList<Integer> createIntegerArray(int... numbers) {
        ArrayList<Integer> allNumbers = new ArrayList<>();
        for (int num: numbers) {
            allNumbers.add(num);
        }
        return allNumbers;
    }

    private static ArrayList<String> createStringArray(String... varArgsStrings) {
        ArrayList<String> allStrings = new ArrayList<>();
        for (String s: varArgsStrings) {
            allStrings.add(s);
        }
        return allStrings;
    }
}
