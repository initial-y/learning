package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author initial.y
 * @className FileTest
 * @description
 * @date 2021/08/18
 */
public class FileTest {

    public static void fileCopy(String sourcePath, String targetPath) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourcePath);
        FileOutputStream outputStream = new FileOutputStream(targetPath);

        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1) {
            outputStream.write(bytes, 0, bytes.length);
            System.out.print(new String(bytes));
        }
//        int b ;
//        while ((b = inputStream.read()) != -1) {
//            System.out.println((char) b);
//        }

        inputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        String sourcePath = "C:\\Users\\ouiyuio\\Desktop\\test.txt";
        String targetPath = "C:\\Users\\ouiyuio\\Desktop\\iotest\\test.txt";
        fileCopy(sourcePath, targetPath);
    }

}
