package IO;

import java.io.File;

public class IOExample {

    public static double getFolderSize(String folderPath) {

        double totalSize = 0.0;
        File file = new File(folderPath);

        if (file.isFile()) {
            return file.length() / (1024.0 * 1024.0 * 1024.0); // size in Giga Bytes
        }

        File[] files = file.listFiles();

        if (files == null) {
            return 0.0;
        }

        for (File subFolderFile : files) {
            totalSize += getFolderSize(subFolderFile.getAbsolutePath());
        }

        return totalSize;
    }

}
