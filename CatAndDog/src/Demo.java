import java.io.*;
import java.nio.charset.Charset;

public class Demo {
    public static void main(String[] args) throws IOException  {
        copyFileUsingStream(new File("src/win1251.txt"),
                Charset.forName("windows-1251"),
                new File("src/utf8.txt"),
                Charset.forName("utf-8"));
    }

    private static void copyFileUsingStream(File source, Charset sourceEnc, File dest, Charset descEnc) throws IOException {
        Reader fis = new FileReader(String.valueOf(sourceEnc));
        Writer fos = new FileWriter(String.valueOf(descEnc));
        char[] buffer = new char[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, length);
        }
        fis.close();
        fos.close();
    }
}