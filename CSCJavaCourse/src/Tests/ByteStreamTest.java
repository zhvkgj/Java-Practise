package Tests;

import static InputOutput.ByteStream.*;
import static InputOutput.ConvertFormat.*;
import static InputOutput.CharStream.*;

import java.io.*;

import java.nio.charset.StandardCharsets;

public class ByteStreamTest {
    public static void main(String[] args) throws IOException {
        InputStream stream;
        int result;
        stream = getStream(new byte[]{48, 49, 10, 50, 51, 10});
        // Test 1
        result = checkSumOfStream(stream);
        System.out.print(result);
        // Test 2
        System.setIn(getStream(new byte[]{65, 66, 13, 13, 10, 10, 13, 67, 13, 13}));
        convertToUnix(System.in);
        // Test 3
        Writer writer = new OutputStreamWriter(System.out, StandardCharsets.US_ASCII);
        writer.write("Карась");
        writer.flush();
        // Test 4
        System.out.print(readAsString(stream, StandardCharsets.US_ASCII));
        // Test 5
        parseDoubleSum();
    }

    public static InputStream getStream(byte[] data) {
        return new ByteArrayInputStream(data);
    }
}
