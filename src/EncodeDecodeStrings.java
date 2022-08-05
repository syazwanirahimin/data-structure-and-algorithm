import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * decode_input = "5#Hello5#World"
 * numOfChar = 5
 * res["Hello"]
 * Step 1: find number of characters
 * Step 2: iterate number of characters and added on to res list
 * decode_output - ["Hello", "World"]
 */

public class EncodeDecodeStrings {
    final char DELIMETER = '#';

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str: strs) {
            sb.append(str.length());
            sb.append(DELIMETER);
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            // Find the number of characters
            StringBuilder sb = new StringBuilder();
            while (arr[i] != DELIMETER) {
                sb.append(arr[i++]);
            }
            i++;

            // Iteration the enter string to add to res list
            int numOfChars = Integer.valueOf(sb.toString());
            int end = i + numOfChars;
            sb = new StringBuilder();
            while (i < end) {
                sb.append(arr[i++]);
            }
            i--;
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        EncodeDecodeStrings test = new EncodeDecodeStrings();
        List<String> input = new ArrayList<>();
        input.add("Hello");
        input.add("World");
//        System.out.println(test.encode(input));
        System.out.println(test.decode(test.encode(input)));

        // input = ["Hello", "World"]
        // encode_output = "HelloWorld"
        // decode_input = "HelloWorld" iterate the length of the first world
        // decode_output = ["Hello", "World"]

    }
}


/**
 * List is an interface, you cannot instantiate an interface, because
 * interface is a convention, what methods should have your classes.
 * in order to instantiate, you need some realisations (implementation of that
 * interface.
 * List<String> supplierNames = new ArrayList<String>();
 * List<String> supplierNames = new LinkedList<String>(
 */