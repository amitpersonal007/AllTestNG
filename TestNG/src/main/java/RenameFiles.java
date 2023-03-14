import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class RenameFiles {

    @Test
    public void rename(){
        String path = "/Users/amits/Downloads"; // replace with actual path
        File dir = new File(path);
        File[] files = dir.listFiles();

        // sort files by last modified time and select the latest file
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        File latestFile = files[0];

        // generate new file name and rename the file
        String newFileName = "new_file_n.csv"; // replace with actual new file name
        File newFile = new File(latestFile.getParent(), newFileName);
        boolean success = latestFile.renameTo(newFile);

        // handle renaming success or failure
        if (success) {
            System.out.println("File renamed successfully!");
        } else {
            System.out.println("File renaming failed.");
        }

    }
}
