import java.util.Arrays;

public class ReorderDataInLogFiles {

    public String[] solution(String[] logs) {
        Arrays.sort(logs, (log1, log2)->{
            String[] arr1 = splitStr(log1);
            String[] arr2 = splitStr(log2);

            boolean isNum1 = isNumber(arr1[1].charAt(0));
            boolean isNum2 = isNumber(arr2[1].charAt(0));
            if (isNum1 && isNum2)
                return 0;
            else if (isNum1)
                return 1;
            else if (isNum2)
                return -1;
            boolean isSameContent = arr1[1].equals(arr2[1]);
            if (isSameContent)
                return arr1[0].compareTo(arr2[0]);
            return arr1[1].compareTo(arr2[1]);
        });
        return logs;
    }

    // split id and content
    private String[] splitStr(String log) {
        return log.split(" ", 2);
    }

    private boolean isNumber(char curChar) {
        return '0' <= curChar && curChar <= '9';
    }


    public static void main(String[] args) {
        ReorderDataInLogFiles test = new ReorderDataInLogFiles();
        String[] input = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(test.solution(input));
    }
}
