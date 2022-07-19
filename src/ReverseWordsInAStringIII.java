public class ReverseWordsInAStringIII {

    public String reverseWords(String s){
        if (s == null || s.length() == 0)
            return s;

        StringBuilder result = new StringBuilder();
        // split by white spece
        String[] splittedWords = s.split(" ");

        for (String word: splittedWords
             ) {
            StringBuilder wordSp = new StringBuilder();

            wordSp.append(word);
            wordSp.reverse();
            result.append(wordSp.toString() + " ");
            System.out.println(result.length());

        }
        System.out.println(result.length());
        // remove the last empty string
        result.setLength(result.length() - 1);

        return result.toString();
    }

    public static void main(String[] args) {
        String test = "Hello world this is wani";
        ReverseWordsInAStringIII a = new ReverseWordsInAStringIII();
        System.out.println(a.reverseWords(test));
    }
}
