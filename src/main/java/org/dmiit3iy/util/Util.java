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
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(originalFile.getAbsolutePath()))) {
                while (bufferedReader.ready()) {
                    if (stringBuilder.length() < fileSize * (1024 * 1024)) {
                        stringBuilder.append(bufferedReader.readLine());
                        stringBuilder.append("\n");
                    } else {
                        try (BufferedWriter bufferedWriter = new BufferedWriter(
                                new FileWriter(originalFile.getParent() + "\\" + fileCount + "." + ext))) {
                            bufferedWriter.write(stringBuilder.toString());
                            //очистка стринг билдера
                            stringBuilder.setLength(0);
                            fileCount++;
                        }
                    }
                }
                if (stringBuilder.length() != 0) {
                    try (BufferedWriter bufferedWriter = new BufferedWriter(
                            new FileWriter(originalFile.getParent() + "\\" + fileCount + "." + ext))) {
                        bufferedWriter.write(stringBuilder.toString());
                        //очистка стринг билдера
                        stringBuilder.setLength(0);
                    }
                }
            }
            return true;
        }
        return false;
    }


}
