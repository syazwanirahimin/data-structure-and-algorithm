import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FileNameFilterLambda {
    public static void main(String[] args) {

        File file=new File("/home");
        String extension=".txt";

        //Converting String Array to list using asList()
        List<String> listOfFoldersAndFiles= Arrays.asList(file.list());

        Predicate<String> predicate=(element)->element.contains(extension);

        //Printing the file having .txt extension
        listOfFoldersAndFiles.stream().filter(predicate).forEach(System.out::println);
    }
}
