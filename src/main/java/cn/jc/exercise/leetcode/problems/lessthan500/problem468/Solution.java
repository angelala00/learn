package cn.jc.exercise.leetcode.problems.lessthan500.problem468;

/**
 * 想不用split，代码写起来有点繁杂，暂停
 */
class Solution {

    public String validIPAddress(String IP) {
        if (IP != null) {
            char[] chars = IP.toCharArray();
            if (isIPv4(chars)) {
                return "IPv4";
            }
            if (isIPv6(chars)) {
                return "IPv6";
            }
        }
        return "Neither";
    }
    private boolean isIPv4(char[] ipstr){
        if (ipstr.length < 7) {
            return false;
        }
        if (ipstr.length > 15) {
            return false;
        }
        int nums = 0;
        int dots = 0;
        int numtmp = 0;
        for (int i = 0; i < ipstr.length; i++) {
            if (notokchar(ipstr[i])) {
                return false;
            }
            if (i == 0 && '.' == ipstr[i]) {
                return false;
            }
            if (i == ipstr.length - 1 && '.' == ipstr[i]) {
                return false;
            }
            if ('.' == ipstr[i]) {
                // TODO
                nums++;
                numtmp = 0;
                dots++;
            } else {
                if (ipstr[i] == '0' && i != ipstr.length - 1 && ipstr[i + 1] != '.') {
                    return false;
                }
                numtmp = numtmp * 10 + (ipstr[i] - '0');
                if (numtmp > 255) {
                    return false;
                }
            }
        }
        return nums == 4 && dots == 3;
    }

    private boolean notokchar(char c) {
        return !((c >= '0' && c <= '9') || c == '.');
    }

    /**
     * TODO
     * @param ipstr
     * @return
     */
    private boolean isIPv6(char[] ipstr){
        if (ipstr.length < 7) {
            return false;
        }
        if (ipstr.length > 15) {
            return false;
        }
        int nums = 0;
        int dots = 0;
        int numtmp = 0;
        for (int i = 0; i < ipstr.length; i++) {
            if (notokchar(ipstr[i])) {
                return false;
            }
            if (i == 0 && '.' == ipstr[i]) {
                return false;
            }
            if (i == ipstr.length - 1 && '.' == ipstr[i]) {
                return false;
            }
            if ('.' == ipstr[i]) {
                dots++;
            } else {
                if (ipstr[i] == '0' && i != ipstr.length - 1 && ipstr[i + 1] == '.') {
                    return false;
                }
                numtmp = numtmp * 10 + (ipstr[i] - '0');
                if (numtmp > 255) {
                    return false;
                }
            }
        }
        return nums == 4 && dots == 3;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validIPAddress("192.0.0.1"));
        System.out.println(new Solution().validIPAddress("172.16.254.1."));
        System.out.println(new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println("2001:0db8:85a3:0:0:8A2E:0370:7334:".split(":").length);
    }
}
