package cn.jc.distributed.consensus;

public class RedisLock1 {
    private static long expireTime = 20000;

    public static boolean getLock(String key) {
        String lock = RedisUtil.get(key);
        if (!"1".equals(lock)) {
            RedisUtil.set(key, "1");
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
