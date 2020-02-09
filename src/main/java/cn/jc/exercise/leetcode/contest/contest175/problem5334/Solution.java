package cn.jc.exercise.leetcode.contest.contest175.problem5334;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TweetCounts {

    List<TC> tcs = new ArrayList<>();
    Comparator<? super TC> comp = new Comparator<TC>() {
        @Override
        public int compare(TC o1, TC o2) {
            return o1.time - o2.time;
        }
    };

    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {
        tcs.add(new TC(tweetName, time));
        Collections.sort(tcs, comp);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int freqtime = 0;
        if ("minute".equals(freq)) {
            freqtime = 60;
        } else if ("hour".equals(freq)) {
            freqtime = 3600;
        } else if ("day".equals(freq)) {
            freqtime = 86400;
        } else {
            return null;
        }
        int s = (endTime - startTime + 1) / freqtime;
        if ((endTime - startTime + 1) % freqtime != 0) {
            s += 1;
        }
        List<Integer> result = new ArrayList<Integer>(s);
        for (int i = 0; i < s; i++) {
            result.add(0);
        }
        int count = 0;
        for (TC tc : tcs) {
            int idx = getIdx(tc.time, freqtime, s, startTime, endTime);
            if (idx < 0 || idx >= s) {
                continue;
            }
            if (tweetName.equals(tc.tweetName)) {
                result.set(idx, result.get(idx) + 1);
            }
        }
        return result;
    }

    public int getIdx(int time, int freq, int s, int start, int end) {
        //System.out.println(time + ":" + freq + ":" + s + ":" + start + ":" + end);
        if (time < start) {
            return -1;
        }
        if (time > end) {
            return s;
        }

        int ss = (time - start + 1) / freq;
        if ((time - start + 1) % freq != 0) {
            ss += 1;
        }
        return ss - 1;
    }

    class TC {
        String tweetName;
        int time;

        public TC(String tweetName, int time) {
            this.tweetName = tweetName;
            this.time = time;
        }
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
