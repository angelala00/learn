package cn.jc.contest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * V10->V7版本优化
 * 根据刘鑫思路优化
 */
public class Solution10 {

    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
    }

    public void process(String inputPath) throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
        String line = br.readLine();
        SubSolution subSolution = new SubSolution();
        while (line != null && line.length() > 0) {
            String[] lineArray = line.split(",");
            if (lineArray != null && lineArray.length == 2) {
                subSolution.addData(lineArray);
            }
            line = br.readLine();
        }
        subSolution.merge();
        subSolution.outData();
    }

    class SubSolution {
        private SubSolution subSolution = null;

        private int idx = 0;
        private Map<String, String> mappppp1 = new HashMap<>();

        private Map<String, List<String>> mappppp2 = new HashMap<>();

        private Set<String> temppp = new HashSet<>();

        public void addData(String[] arr) {
            String idxStr = String.valueOf(idx);
            String arr0idx = mappppp1.get(arr[0]);
            String arr1idx = mappppp1.get(arr[1]);
            if (arr0idx == null && arr1idx == null) {
                mappppp1.put(arr[0], idxStr);
                mappppp1.put(arr[1], idxStr);
                List<String> list = new ArrayList<>();
                list.add(arr[0]);
                list.add(arr[1]);
                mappppp2.put(idxStr, list);
                idx++;
            }
            if (arr0idx != null && arr1idx == null) {
                mappppp1.put(arr[1], arr0idx);
                mappppp2.get(arr0idx).add(arr[1]);
            }
            if (arr0idx == null && arr1idx != null) {
                mappppp1.put(arr[0], arr1idx);
                mappppp2.get(arr1idx).add(arr[0]);
            }
            if (arr0idx != null && arr1idx != null && !arr0idx.equals(arr1idx)) {
                putSubSolution(arr0idx, arr1idx);
            }
        }

        public void outData() throws Exception {
            for (Map.Entry<String, List<String>> s : mappppp2.entrySet()) {
                MainFrame.addSet(s.getValue());
            }
        }

        public void merge() {
            if (subSolution != null) {
                subSolution.merge();
                for (Map.Entry<String, List<String>> en : mappppp2.entrySet()) {
                    String key = en.getKey();
                    if (temppp.contains(key)) {
                        continue;
                    }
                    List resultline = en.getValue();
                    if (subSolution != null) {
                        List<String> list = subSolution.getList(key);
                        if (list != null) {
                            for (String k : list) {
                                if (key.equals(k)) {
                                    continue;
                                }
                                List tmp = mappppp2.get(k);
                                resultline.addAll(tmp);
                                temppp.add(k);
                            }
                        }
                    }
                }
                for (String ingoreKey : temppp) {
                    mappppp2.remove(ingoreKey);
                }
            }
        }

        private List<String> getList(String key) {
            return mappppp2.get(mappppp1.get(key));
        }

        private void putSubSolution(String arr0, String arr1) {
            if (subSolution == null) {
                subSolution = new SubSolution();
            }
            subSolution.addData(new String[]{arr0, arr1});
        }
    }
}
