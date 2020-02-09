package cn.jc.contest;

import java.io.BufferedReader;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用缓存目录
 * V9
 */
public class Solution {
    private String map1dir;
    private String map2dir;
    private Map<String, String> setIndex = new HashMap<String, String>(100000);

    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
        map1dir = tempDir + "/map1";
        map2dir = tempDir + "/map2";
        new File(map1dir).mkdirs();
        new File(map2dir).mkdirs();
    }

    public void process(String inputPath) throws Exception {
//        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
//        String line = br.readLine();
//        int idx = 0;
//        while (line != null && line.length() > 0) {
//            String[] lineArray = line.split(",");
//            if (lineArray != null && lineArray.length == 2) {
//                String ida = lineArray[0].trim();
//                String idb = lineArray[1].trim();
//                String indexa = setIndex.get(ida);
//                String indexb = setIndex.get(idb);
//                if (indexa != null && indexb == null) {
//                    addOneToLine(indexa, idb);
//                    setIndex.put(idb, indexa);
//                }
//                if (indexa == null && indexb != null) {
//                    addOneToLine(indexb, ida);
//                    setIndex.put(ida, indexb);
//                }
//                if (indexa != null && indexb != null) {
//                    if (indexa != indexb) {
//                        mergeTowLine(indexa, indexb);
//                    }
//                }
//                if (indexa == null && indexb == null) {
//                    String idxStr = String.valueOf(idx);
//                    addNewLine(idxStr, lineArray);
//                    setIndex.put(ida, idxStr);
//                    setIndex.put(idb, idxStr);
//                    idx++;
//                }
//            }
//            line = br.readLine();
//        }
//
//        for (Map.Entry<String, List<String>> s : mappppp2.entrySet()) {
//            List<String> result = s.getValue();
//            cn.jc.contest.MainFrame.addSet(result.toArray(new String[result.size()]));
//        }
    }
////    private Map<String, List<String>> mappppp2 = new HashMap<>(1000000);
//    private void addNewLine(String index, String[] arr) {
//        List<String> list = new ArrayList<>();
//        list.add(arr[0]);
//        list.add(arr[1]);
//        mappppp2.put(index, list);
//    }
//
//    private void mergeTowLine(String indexa, String indexb) {
//        int sa = mappppp2.get(indexa).size();
//        int sb = mappppp2.get(indexb).size();
//        if (sa > sb) {
//            List<String> ss = mappppp2.get(indexb);
//            for (String s : ss) {
//                mappppp2.get(indexa).add(s);
//                setIndex.put(s, indexa);
//            }
//            mappppp2.remove(indexb);
//        } else {
//            List<String> ss = mappppp2.get(indexa);
//            for (String s : ss) {
//                mappppp2.get(indexb).add(s);
//                setIndex.put(s, indexb);
//            }
//            mappppp2.remove(indexa);
//        }
//    }
//
//    private void addOneToLine(String indexa, String idb) {
//        mappppp2.get(indexa).add(idb);
//    }
}
