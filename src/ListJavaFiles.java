import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class ListJavaFiles {

    public static void main(String[] args) {
        String dir = "/home";
        String ext = ".txt";
        findFiles(dir,ext);

//        String[] names = dir.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File directory, String fileName) {
//                return fileName.endsWith(".java");
//            }
//        });
//        System.out.println(Arrays.asList(names));
    }

    private static void findFiles(String dir, String ext) {
        File file = new File(dir);
        if (!file.exists())
            System.out.println(dir + "Directory doesn't exists");
        File[] listFiles = file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith(ext);
//            }

            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(ext);
            }
        });

        if (listFiles.length == 0) {
            System.out.println(dir + " doesn't have any file with extension " + ext);
        } else {
            for (File f : listFiles)
                System.out.println("File: " + dir + File.separator + f.getName());
        }
    }
}
