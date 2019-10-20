package InputOutput;

import java.io.IOException;
import java.io.InputStream;

public class ConvertFormat {
    public static void convertToUnix(InputStream inputStream) throws IOException {
        int curr;
        boolean prevIsThirteen = false;
        while ((curr = inputStream.read()) != -1) {
            if (prevIsThirteen) {
                prevIsThirteen = false;
                if ((byte) curr == 10) {
                    System.out.write(curr);
                    continue;
                }
                System.out.write(13);
            }
            if ((byte) curr == 13) {
                prevIsThirteen = true;
                continue;
            }
            System.out.write(curr);
        }
        System.out.flush();
    }
}
