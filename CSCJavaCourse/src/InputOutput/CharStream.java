package InputOutput;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class CharStream {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder str = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream, charset);
        int buffer;
        while ((buffer = reader.read()) != -1) {
            str.append((char) buffer);
        }
        return str.toString();
    }

    public static void parseDoubleSum() {
        Scanner scan = new Scanner(System.in).useLocale(Locale.ENGLISH);
        double sum = 0;
        while (scan.hasNext()) {
            if (scan.hasNextDouble()) {
                sum += scan.nextDouble();
            } else {
                scan.next();
            }
        }
        System.out.printf("%.6f", sum);
    }
}
