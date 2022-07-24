
    /**
     * Input: s = "5F3Z-2e-9-w", k = 4
     * Output: "5F3Z-2E9W"
     * Explanation: The string s has been split into two parts, each part has 4 characters.
     * Note that the two extra dashes are not needed and can be removed.
     */

    /**
     * Input: s = "2-5g-3-J", k = 2
     * Output: "2-5G-3J"
     * Explanation: The string s has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
     *
     */

    import java.util.Locale;

    /**
     * Constraints:
     *
     * 1 <= s.length <= 105
     * s consists of English letters, digits, and dashes '-'.
     * 1 <= k <= 104
     */
    public class LicenseKeyFormatting {

        // solution 1. simplify S, then insert '-'
        public String solution1(String s, int k) {
            s = s.replace("-", "").toUpperCase(); // ideally O(2n) -- remove all dashes in the original string and make all uppercase
            StringBuilder sb = new StringBuilder(s); // O(n)
            int len = s.length();
            //inserting '-' from the back at every k position
            // n/k * n = 1/k * n^2
            for (int i = len - k; i > 0  ; i = i - k) {
                sb.insert(i, '-');
            }
            return sb.toString(); //O(n)

        }

        // solution2: Iterate S back to front
        public String solution2(String s, int k) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int i = s.length() - 1; i >= 0 ; i--) {
                char c = s.charAt(i);
                if (c != '-') {
                    sb.append(Character.toUpperCase(c));
                    if (++count == k) {
                        sb.append('-');
                    }
                    count = count % k;
                }
            }
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '-') {
                sb.deleteCharAt(sb.length()-1);
            }
            return sb.reverse().toString();
        }

        public static void main(String[] args) {
            LicenseKeyFormatting test = new LicenseKeyFormatting();
            String s = "5F3Z-2e-9-w";
            int k = 4;
            System.out.println(test.solution2(s,k));
        }


    }
