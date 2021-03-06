package cn.jc.contest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * V6
 * V3优化版本
 */
public class SolutionV6 {
    private Map<String, String> setIndex = new HashMap<String, String>(100000);
    private Map<String, Set<String>> mappppp = new HashMap<String, Set<String>>(1000000);

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
                String indexa = setIndex.get(ida);
                String indexb = setIndex.get(idb);
                if (indexa != null && indexb == null) {
                    mappppp.get(indexa).add(idb);
                    setIndex.put(idb, indexa);
                }
                if (indexa == null && indexb != null) {
                    mappppp.get(indexb).add(ida);
                    setIndex.put(ida, indexb);
                }
                if (indexa != null && indexb != null) {
                    if (indexa != indexb) {

                        int sa = mappppp.get(indexa).size();
                        int sb = mappppp.get(indexb).size();
                        if (sa > sb) {
                            Set<String> ss = mappppp.get(indexb);
                            for (String s : ss) {
                                mappppp.get(indexa).add(s);
                                setIndex.put(s, indexa);
                            }
                            mappppp.remove(indexb);
                        } else {
                            Set<String> ss = mappppp.get(indexa);
                            for (String s : ss) {
                                mappppp.get(indexb).add(s);
                                setIndex.put(s, indexb);
                            }
                            mappppp.remove(indexa);
                        }

                    }
                }
                if (indexa == null && indexb == null) {
                    Set<String> s = new HashSet<>();
                    s.add(ida);
                    s.add(idb);
                    String idxStr = String.valueOf(idx);
                    mappppp.put(idxStr, s);
                    setIndex.put(ida, idxStr);
                    setIndex.put(idb, idxStr);
                    idx++;
                }
            }
            line = br.readLine();
        }

        for (Map.Entry<String, Set<String>> s : mappppp.entrySet()) {
            Set<String> result = s.getValue();
            MainFrame.addSet(result.toArray(new String[result.size()]));
        }
    }
}
