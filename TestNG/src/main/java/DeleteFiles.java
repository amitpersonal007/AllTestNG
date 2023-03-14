import org.testng.annotations.Test;

import java.io.File;

public class DeleteFiles {


    @Test
    public void test(){

        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        File downloadsFolder = new File(downloadsPath);

        if (downloadsFolder.exists() && downloadsFolder.isDirectory()) {
            File[] files = downloadsFolder.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            System.out.println("All files in Downloads folder deleted successfully!");
        } else {
            System.out.println("Downloads folder does not exist or is not a directory!");
        }

    }
}
