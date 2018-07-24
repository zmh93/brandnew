package readwrite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringRW {
    public static void main(String[] args) throws IOException {
        String s = readStringByFilePath("jdkstudy/src/readwrite/str.txt");
        System.out.println(s.split("abc").length-1);

    }

    private static String readStringByFilePath(String path) {
        BufferedReader br;
        StringBuilder  sb;
        String         s = "";
        try {
            sb = new StringBuilder();
            br = new BufferedReader(new FileReader(path));
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
            return new String(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
