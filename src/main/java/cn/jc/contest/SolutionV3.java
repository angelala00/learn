package cn.jc.contest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * V3
 * 通用版本
 */
public class SolutionV3 {
    private Map<String, Integer> setIndex = new HashMap<>(10000);
    private Map<Integer, Set<String>> mappppp = new HashMap<>(100000);

    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
    }

    public void process(String inputPath) throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
        String line = br.readLine();
        int idx = 0;
        while (line != null && line.length() > 0) {
            String[] lineArray = line.split(",");
            if (lineArray != null && lineArray.length == 2) {
                String ida = lineArray[0].trim();
                String idb = lineArray[1].trim();
                int indexa = getSetIndex(ida);
                int indexb = getSetIndex(idb);
                if (indexa > -1 && indexb == -1) {
                    mappppp.get(indexa).add(idb);
                    updateSetIndex(idb, indexa);
                }
                if (indexa == -1 && indexb > -1) {
                    mappppp.get(indexb).add(ida);
                    updateSetIndex(ida, indexb);
                }
                if (indexa > -1 && indexb > -1) {
                    if (indexa != indexb) {
                        Set<String> ss = mappppp.get(indexb);
                        for (String s : ss) {
                            mappppp.get(indexa).add(s);
                            updateSetIndex(s, indexa);
                        }
                        mappppp.remove(indexb);
                    }
                }
                if (indexa == -1 && indexb == -1) {
                    Set<String> s = new HashSet<>();
                    s.add(ida);
                    s.add(idb);
                    mappppp.put(idx, s);
                    updateSetIndex(ida, idx);
                    updateSetIndex(idb, idx);
                    idx++;
                }
            }
            line = br.readLine();
        }

        for (Map.Entry<Integer, Set<String>> s : mappppp.entrySet()) {
            Set<String> result = s.getValue();
            MainFrame.addSet(result.toArray(new String[result.size()]));
        }
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
