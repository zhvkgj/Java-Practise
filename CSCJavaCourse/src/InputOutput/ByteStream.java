package InputOutput;

import java.io.IOException;
import java.io.InputStream;

public class ByteStream {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        byte[] buf = new byte[1024];
        int sum = 0;
        int blockSize;
        while ((blockSize = inputStream.read(buf)) > 0) {
            for (int i = 0; i < blockSize; i++) {
                sum = Integer.rotateLeft(sum, 1) ^ Byte.toUnsignedInt(buf[i]);
            }
        }
        return sum;
    }
}
