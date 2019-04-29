package cn.jc.distributed.consensus;

public class RedisLock3 {
    private static long expireTime = 20000;

    public static boolean getLock(String key) {
        long lock = RedisUtil.setNX(key, "" + System.currentTimeMillis() + expireTime);
        if (lock == 1) {
            return true;
        } else {
            String check = RedisUtil.get(key);
            if (check != null && System.currentTimeMillis() < Long.valueOf(check)) {
                //key还没有过期
                return false;
            } else {
                //key过期或者已经不存在了
                String old = RedisUtil.getSET(key, "" + System.currentTimeMillis() + expireTime);
                if (old == null) {
                    //说明此时已经key已经不存在，获取锁成功
                    return true;
                } else {
                    // TODO 疑问点1，这里同事用的是否过期的判断，会不会存在风险？
                    if (check.equals(old)) {
                        //获取锁成功
                        return true;
                    } else {
                        //在getSET之  前已经被别的线程获取了锁，获取锁失败
                        return false;
                    }
                }
            }
        }
    }

    public static void releaseLock(String key) {
        String check = RedisUtil.get(key);
        if (check != null) {
            if (System.currentTimeMillis() < Long.valueOf(check)) {
                // TODO 疑问点2，有没有可能删除别的线程设置的key
                RedisUtil.del(key);
            } else {
                // TODO 疑问点3，过期了是否需要删除
            }
        } else {
        }
    }

    // TODO 疑问点4，expire正常来说是需要设置成一个业务一定在此时间内能执行完成的时间，那么，业务如果万一没有执行完成的时候，redis锁还安全么？
    // TODO 疑问点5，redis锁真的安全吗，多个线程错综复杂的执行顺序，如何能比较好的理解呢？
    // TODO 疑问点6，这里还有个疑问，是不是理论上每两行代码之间都可能会中断，比如宕机，比如卡死过了很长时间之后继续执行？这个疑问明显的体现出了基础的薄弱

}
