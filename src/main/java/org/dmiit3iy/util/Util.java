package org.dmiit3iy.util;

import java.io.*;
import java.nio.file.Files;

public class Util {

    /**
     * Метод для разделения текстового файла на части
     *
     * @param path     - путь к исходному файлу
     * @param fileSize - размер частей на который следует "нарезать" исходный файл в мегабайтах
     * @return
     */
    public static boolean fileSplitter(String path, long fileSize) throws IOException {
        long fileCount = 0;
        String ext = null;
        File originalFile = new File(path);
        if (originalFile.exists()) {
            int i = path.lastIndexOf('.');
            if (i > 0) {
                ext = path.substring(i + 1);
            }
            double originalFileSize = originalFile.length() / (1024 * 1024);
            System.out.println("Размер файла: " + originalFileSize + "mb");
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(originalFile.getAbsolutePath()))) {
                while (true) {
                    File partFile = new File(originalFile.getParent() + "\\" + fileCount + "." + ext);
                    try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(partFile, true))) {
                        while ((partFile.length()) < (fileSize * 1048576)) {
                            if (bufferedReader.ready()) {
                                bufferedWriter.write(bufferedReader.readLine());
                                bufferedWriter.newLine();
                            } else {
                                return true;
                            }
                        }
                        fileCount++;
                    }
                }
            }
        }
        return false;
    }
}


