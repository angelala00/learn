package cn.jc.distributed.consensus;

public class RedisLock2 {
    private static long expireTime = 20000;

    public static boolean getLock(String key) {
        long lock = RedisUtil.setNX(key, "1");
        if (lock == 1) {
            RedisUtil.expire(key, expireTime);
            return true;
        } else {
            return false;
        }
    }

    public static void releaseLock(String key) {
        String check = RedisUtil.get(key);
        if (check != null) {
            RedisUtil.del(key);
        }
    }


}
