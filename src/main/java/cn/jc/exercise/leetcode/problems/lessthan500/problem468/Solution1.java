package cn.jc.exercise.leetcode.problems.lessthan500.problem468;

class Solution1 {

    public String validIPAddress(String IP) {
        if (isIPv4(IP)) {
            return "IPv4";
        }
        if (isIPv6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPv4(String ipstr) {
        if (ipstr == null || ipstr.length() > 15 || ipstr.endsWith(".")) {
            return false;
        }
        String[] arr1s = ipstr.split("\\.");
        if (arr1s.length == 4) {
            for (int i = 0; i < 4; i++) {
                if (!isIPv4Number(arr1s[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isIPv4Number(String ipnumber) {
        if (ipnumber.length() < 1 || (ipnumber.length() > 1 && ipnumber.startsWith("0"))) {
            return false;
        }
        char[] chars = ipnumber.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!(chars[i] <= '9' && chars[i] >= '0')) {
                return false;
            }
        }
        int v = Integer.valueOf(ipnumber);
        if (v < 0 || v > 255) {
            return false;
        }
        return true;
    }

    private boolean isIPv6(String ipstr) {
        if (ipstr == null || ipstr.length() > 39 || ipstr.endsWith(":")) {
            return false;
        }
        String[] arr1s = ipstr.split("\\:");
        if (arr1s.length == 8) {
            for (int i = 0; i < 8; i++) {
                if (!isIPv6Number(arr1s[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean isIPv6Number(String ipnumber) {
        if (ipnumber.length() > 4 || ipnumber.length() < 1) {
            return false;
        }
        char[] chars = ipnumber.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!((chars[i] <= 'f' && chars[i] >= 'a') || (chars[i] <= '9' && chars[i] >= '0') || (chars[i] <= 'F' && chars[i] >= 'A'))) {
                return false;
            }
        }
        return true;
    }

}
