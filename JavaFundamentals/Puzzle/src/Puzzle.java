import java.util.*;
import java.util.stream.Collectors;

public class Puzzle {

    public ArrayList<Integer> printSumAndFilterGreaterThan10(ArrayList<Integer> numbersArray) {
        int sum=0;
        ArrayList<Integer> filteredArray = new ArrayList<>();
        for (int num : numbersArray) {
            sum += num;
            if (num > 10) {
                filteredArray.add(num);
            }
        }
        System.out.println(String.format("The sum was %s", sum));
        return filteredArray;
    }

    public ArrayList<String> shuffleArrayAndPrintNameAndFilterGreaterThan5Characters(ArrayList<String> namesArrayList) {
        Collections.shuffle(namesArrayList);
        System.out.println(namesArrayList);
        ArrayList<String> filteredArrayList = new ArrayList<>();
        for (String name : namesArrayList) {
            if (name.length() > 5) {
                filteredArrayList.add(name);
            }
        }
        return filteredArrayList;
    }

    public void shuffleAlphabetAndPrintStuff(ArrayList<String> alphabet) {
        ArrayList<String> vowels = createStringArray("a", "e", "i", "o", "u");
        Collections.shuffle(alphabet);
        System.out.println("last " + alphabet.get(alphabet.size() -1));
        String first = alphabet.get(0);
        System.out.println("first " + first);
        if (vowels.contains(first)) {
            System.out.println("Bunnies are cute... also this is a vowel");
        }

    }

    public ArrayList<Integer> generate10RandomNumbers() {
        ArrayList<Integer> randomList = new ArrayList<>();
        Random rando = new Random();
        for (int i = 0; i < 10; i++) {
           randomList.add(rando.nextInt(46) + 55);
        }
        return randomList;
    }

    public ArrayList<Integer> generate10SortedRandomNumbers() {
        ArrayList<Integer> sortedArray = generate10RandomNumbers();
        Collections.sort(sortedArray);
        return sortedArray;
    }

    public String random5Chars() {
        return randomStringHelper();
    }

    // static helper function
    public static String randomStringHelper() {
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> listAlphabet = new ArrayList<String>(Arrays.asList(alphabet));

        Random randomGenerator = new Random();
        String randomString = "";

        for(int i = 0; i < 5; i++) {
            randomString = randomString.concat(listAlphabet.get(randomGenerator.nextInt(listAlphabet.size())));
        }

        return randomString;
    }

    public List<String> random10Strings() {
        ArrayList<String> random10Strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            random10Strings.add(random5Chars());
        }
        return random10Strings;
    }

    private static ArrayList<String> createStringArray(String... varArgsStrings) {
        ArrayList<String> allStrings = new ArrayList<>();
        for (String s: varArgsStrings) {
            allStrings.add(s);
        }
        return allStrings;
    }
}

