package cn.jc.other;

public class ParseDoubleLearn {

    public static void main(String[] args) throws Exception {
        System.out.println(parseDouble("19.088238"));
        System.out.println(parseDouble(".19088238"));
        System.out.println(parseDouble("-.19088238"));
        System.out.println(parseDouble("-190.88238"));
        System.out.println(parseDouble("--.19088238"));
    }
    public static Double parseDouble(String str) throws Exception {
        double d = 0;
        int l = str.length();
        int s = 1;
        int f = 0;
        int x = 1;
        for (int i = 0; i < l; i++) {
            char c = str.charAt(i);
            if ('+' == c || '-' == c) {
                if (i == 0) {
                    if ('-' == c) {
                        s = -1;
                    }
                } else {
                    throw new Exception("不能有多个正负号");
                }
            } else if ('.' == c) {
                if (f == 1) {
                    throw new Exception("不能有多个点");
                } else {
                    f = 1;
                }
            } else {
                int num = c - '0';
                if (num >= 0 && num <= 9) {
                    d = d * 10 + num;
                    if (f == 1) {
                        x = x * 10;
                    }
                } else {
                    throw new Exception("必须是数字，-，+，.才行");
                }
            }
        }
        return d * s / x;
    }
}







