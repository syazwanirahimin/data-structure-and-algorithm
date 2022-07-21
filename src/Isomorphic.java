import java.util.HashMap;

/**
 * never memorize solutions
 * think about what is your goal, and what data structure or algorithm can help you to achieve that
 */
/**
 * dictionary, the key of dictionary is in order
 * hash ada 127 index ascII of  characters,
 *
 * time complexity O(1)
 *
 */
public class Isomorphic {

    public boolean arraySolution(String s, String t){
        if (s.length() != t.length()) return false;
        int[] arr1 = new int[128];
        int[] arr2 = new int[128];
        for (int i = 0; i < s.length() ; i++) {
            if (arr1[s.charAt(i)] != arr2[t.charAt(i)])
                return false;
            arr1[s.charAt(i)] = i + 1;
            arr2[t.charAt(i)] = i + 1;

        }
        return true;
    }

    public boolean solution(String s, String t){
        // Hash Table - find the mapping between key and value
        // key 'e' is not exist, val 'a' not exist -> (e -> a)
        // key 'g' is not exist, val 'd' not exist -> add (g-> d)
        // key 'g' exists, map.get('g') == 'd' YES skip

        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.containsKey(si)){
                if (map.get(si) != ti) return false;
            } else {
                if (map.containsValue(ti)) return false;
                map.put(si, ti);
            }

        }
        return true;
    }
    public static void main(String[] args) {
        Isomorphic test = new Isomorphic();
        String s = "foo", t = "bar";
        System.out.println(test.solution(s, t));
    }
}


