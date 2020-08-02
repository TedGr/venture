import java.io.UnsupportedEncodingException;

/**
 * 编码相关
 *
 * @Author: gongran
 * @Date: 2020 2020/8/2 3:51 下午
 */
public class Encoded {

    public static String HexToString(String str) throws UnsupportedEncodingException {
        char[] chars = str.toCharArray();
        byte[] bytes = new byte[chars.length / 2];
        for (int i = 0; i < chars.length; i = i + 2) {
            int first = chars[i];
            int second = chars[i + 1];
            int numChar = '0';
            int wordNum = 'a';
            if (first >= wordNum) {
                first = first - wordNum + 10;
            } else if (first >= numChar) {
                first = first - numChar;
            }
            first = first << 4;
            if (second >= wordNum) {
                second = second - wordNum + 10;
            } else if (second >= numChar) {
                second = second - numChar;
            }
            bytes[i / 2] = (byte) (first + second);
        }
        for (int i = 0; i < bytes.length; i++) {
            System.out.printf(bytes[i] + ",");
        }
        return new String(bytes, "utf-8");
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "7b2264617461223a2274657374e5ad97e7aca6227d";
        System.out.println("解码前：");
        System.out.println(str);
        System.out.println("解码后：");
        System.out.println(HexToString(str));
    }
}
