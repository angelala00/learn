package cn.jc.distributed.consensus;

public class RedisLock {

    private static int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    private static int timeoutMsecs = 10000;
    private static int expireMsecs = 20000;


    private static int setNX(String key, String value) {
//        return RedisCacheUtils.setnx(key, value);
        return 0;
    }

    private static String getSET(String key, String value) {
//        return RedisCacheUtils.getset(key, value);
        return null;
    }

    private static String get(String key) {
//        return RedisCacheUtils.get(key);
        return null;
    }

    private static void del(String key) {
//        RedisCacheUtils.del(key);
    }

    private static String getKey(int bid) {
        //lock.product.update
        return "LOCK:PD:UD" + bid;
    }

    public static void releaseLock(int bid) {
        String key = getKey(bid);
        String check = get(key);
        if (check != null && System.currentTimeMillis() < Long.valueOf(check)) {
            //key不为空 && 还没有过期
            del(key);
        } else {
            //key为空，或者，已经过期了，就不需要再删除了
        }
    }

    public static boolean getLock(int bid) {
        String key = getKey(bid);
        String expiresStr = String.valueOf(System.currentTimeMillis() + expireMsecs + 1);

        int lock = setNX(key, expiresStr);
        if (lock == 1) {
            //获取锁成功
            return true;
        } else {
            String check = get(key);
            if (check != null && System.currentTimeMillis() > Long.valueOf(check)) {
                //key不为空 && 已经过期
                String old = getSET(key, expiresStr);
                if (old == null) {
                    //说明此时已经key已经不存在，获取锁成功，这里和网上讲的不太一样
                    return true;
                } else {
                    if (check.equals(old)) {
                        //获取锁成功
                        return true;
                    } else {
                        //在getSET之前已经被别的线程获取了锁，获取锁失败
                        return false;
                    }
                }
            } else {
                //key已经不存在了，或者，还没有过期，重试，在我们的场景里，这里先直接获取失败
                return false;
            }
        }
    }
}







