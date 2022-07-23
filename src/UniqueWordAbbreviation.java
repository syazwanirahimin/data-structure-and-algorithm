
import java.util.ArrayList;
import java.util.HashMap;

public class UniqueWordAbbreviation {


    HashMap<String, String> map;

    /**
     * Input: ["deer", "door", "cake", "card"] --> [ d2r, d2r, c2e, c2d]
     * @param dictionary
     */
    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String word : dictionary) {
            String key = getAbbreviation(word);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(word)){
                    map.put(key, "");
                }
            }
            else {
                map.put(key, word);
            }
        }
    }

    /**
     * return true: "cart" np words in the dictionary have the same abbr "c2t"
     * return false:
     * dear --> d2r but d2r is exist in dictionary, word "deer" and word "dear" have the same abbr "d2r" but are not the same
     * @param word
     * @return
     */
    public boolean isUnique(String word) {
        String key = getAbbreviation(word);
        if (!map.containsKey(key)){
            return true;
        } else {
            return map.get(key).equals(word);
        }

    }

    private String getAbbreviation(String word) {
        int length = word.length();
        if (length <= 2) return word;
        return "" + word.charAt(0) + String.valueOf(length-2) + word.charAt(length -1);
    }

    // dog --> d1g because there is one letter between the first letter d and last letter
    // internationalization --> i18n
    // it -> abbreviation
    public static void main(String[] args) {
        String[] dictionary = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation obj = new UniqueWordAbbreviation(dictionary);
        System.out.println(obj.isUnique("dear"));
        System.out.println(obj.isUnique("cart"));
    }
}
