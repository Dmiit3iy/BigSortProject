package org.dmiit3iy;

import org.dmiit3iy.util.Util;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Util.fileSplitter("C:\\Users\\JavaUser\\Desktop\\test\\ss.txt", 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}