package cn.jc.contest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * V5
 * 递归合并版本
 */
public class SolutionV5 {

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
                String ida = lineArray[0].trim();
                String idb = lineArray[1].trim();
                subSolution.inputData(ida, idb);
            }
            line = br.readLine();
        }
        Map<Integer, Set<String>> list = subSolution.getOutputDataMap();
        for (Map.Entry<Integer, Set<String>> s : list.entrySet()) {
            MainFrame.addSet(s.getValue().toArray(new String[s.getValue().size()]));
        }
    }

    class SubSolution1 {
        SubSolution1 ss1 = null;
        private Map<Integer, Integer> setIndex = new HashMap<>(10000);
        private Map<Integer, Set<Integer>> list = new HashMap<>(10000);
        private int idx = 0;

        public void inputData(Integer ida, Integer idb) {
            int indexa = getSetIndex(ida);
            int indexb = getSetIndex(idb);
            if (indexa > -1 && indexb == -1) {
                list.get(indexa).add(idb);
                updateSetIndex(idb, indexa);
            }
            if (indexa == -1 && indexb > -1) {
                list.get(indexb).add(ida);
                updateSetIndex(ida, indexb);
            }
            if (indexa > -1 && indexb > -1) {
                if (indexa != indexb) {
                    if (ss1 == null) {
                        ss1 = new SubSolution1();
                    }
                    ss1.inputData(indexa, indexb);
                }
            }
            if (indexa == -1 && indexb == -1) {
                Set<Integer> s = new HashSet<>();
                s.add(ida);
                s.add(idb);
                list.put(idx, s);
                updateSetIndex(ida, idx);
                updateSetIndex(idb, idx);
                idx++;
            }
        }

        public Map<Integer, Set<Integer>> getOutputDataMap() {
            if (ss1 != null) {
                Map<Integer, Set<Integer>> ssssss = ss1.getOutputDataMap();
                Set<Integer> removeset = new HashSet<>();
                for (Map.Entry<Integer, Set<Integer>> entry : list.entrySet()) {
                    Integer idkey = entry.getKey();
                    if (removeset.contains(idkey)) {
                        continue;
                    }
                    Set<Integer> value = entry.getValue();
                    int idx = ss1.getSetIndex(idkey);
                    if (idx > -1) {
                        Set<Integer> indexset = ssssss.get(idx);
                        if (indexset != null) {
                            for (Integer i : indexset) {
                                if (!i.equals(idkey)) {
                                    for (Integer tmp : list.get(i)) {
                                        value.add(tmp);
                                    }
                                    removeset.add(i);
                                }
                            }
                        }
                    }
                }
                for (Integer removeIndx : removeset) {
                    list.remove(removeIndx);
                }
            }
            return list;
        }

        private void updateSetIndex(Integer id, int i) {
            setIndex.put(id, i);
        }

        private int getSetIndex(Integer id) {
            if (setIndex.containsKey(id)) {
                return setIndex.get(id);
            } else {
                return -1;
            }
        }
    }

    class SubSolution {
        SubSolution1 ss1 = new SubSolution1();
        private Map<String, Integer> setIndex = new HashMap<>(10000);
        private Map<Integer, Set<String>> list = new HashMap<>(10000);
        private int idx = 0;

        public void inputData(String ida, String idb) {
            int indexa = getSetIndex(ida);
            int indexb = getSetIndex(idb);
            if (indexa > -1 && indexb == -1) {
                list.get(indexa).add(idb);
                updateSetIndex(idb, indexa);
            }
            if (indexa == -1 && indexb > -1) {
                list.get(indexb).add(ida);
                updateSetIndex(ida, indexb);
            }
            if (indexa > -1 && indexb > -1) {
                if (indexa != indexb) {
                    ss1.inputData(indexa, indexb);
                }
            }
            if (indexa == -1 && indexb == -1) {
                Set<String> s = new HashSet<>();
                s.add(ida);
                s.add(idb);
                list.put(idx, s);
                updateSetIndex(ida, idx);
                updateSetIndex(idb, idx);
                idx++;
            }
        }

        public Map<Integer, Set<String>> getOutputDataMap() {
            Map<Integer, Set<Integer>> ssssss = ss1.getOutputDataMap();
            Set<Integer> removeset = new HashSet<>();
            for (Map.Entry<Integer, Set<String>> entry : list.entrySet()) {
                Integer idkey = entry.getKey();
                if (removeset.contains(idkey)) {
                    continue;
                }
                Set<String> value = entry.getValue();
                int idx = ss1.getSetIndex(idkey);
                if (idx > -1) {
                    Set<Integer> indexset = ssssss.get(idx);
                    if (indexset != null) {
                        for (Integer i : indexset) {
                            if (!i.equals(idkey)) {
                                for (String tmp : list.get(i)) {
                                    value.add(tmp);
                                }
                                removeset.add(i);
                            }
                        }
                    }
                }
            }
            for (Integer removeIndx : removeset) {
                list.remove(removeIndx);
            }
            return list;
        }

        private void updateSetIndex(String id, int i) {
            setIndex.put(id, i);
        }

        private int getSetIndex(String id) {
            if (setIndex.containsKey(id)) {
                return setIndex.get(id);
            } else {
                return -1;
            }
        }
    }
}
