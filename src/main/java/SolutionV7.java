import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * V7
 * 递归id关联，失败
 */
public class SolutionV7 {

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

        subSolution.outData();
    }

    class SubSolution {
        private SubSolution subSolution = null;

        private int idx = 0;
        private Map<String, String> mappppp1 = new HashMap<>();

        private Map<String, String[]> mappppp2 = new HashMap<>();

        private Map<String, Set<String>> resultMapTmp = null;

        public void addData(String[] arr) {
            String idxStr = String.valueOf(idx);
            String arr0idx = mappppp1.get(arr[0]);
            String arr1idx = mappppp1.get(arr[1]);
            if (arr0idx == null && arr1idx == null) {

            }
            if (arr0idx != null && arr1idx == null) {
                putSubSolution(arr0idx, idxStr);
            }
            if (arr0idx == null && arr1idx != null) {
                putSubSolution(arr1idx, idxStr);
            }
            if (arr0idx != null && arr1idx != null) {
                putSubSolution(arr1idx, idxStr);
                if (!arr0idx.equals(arr1idx)) {
                    putSubSolution(arr0idx, idxStr);
                }
            }
            mappppp1.put(arr[0], idxStr);
            mappppp1.put(arr[1], idxStr);
            mappppp2.put(idxStr, arr);
            idx++;
        }

        public void outData() throws Exception {
            Map<String, Set<String>> mappppp = getResult();
            for (Map.Entry<String, Set<String>> s : mappppp.entrySet()) {
                Set<String> result = s.getValue();
                MainFrame.addSet(result.toArray(new String[result.size()]));
            }
        }

        private void putSubSolution(String arr0, String arr1) {
            if (subSolution == null) {
                subSolution = new SubSolution();
            }
            subSolution.addData(new String[]{arr0, arr1});
        }

        private String getIdSetIdx(String id) {
            return mappppp1.get(id);
        }


        private Map<String, Set<String>> getResult() {
            if (resultMapTmp != null) {
                return resultMapTmp;
            }
            System.out.println("==========================");
            for (Map.Entry<String, String[]> mp2 : mappppp2.entrySet()) {
                System.out.println("mp2.key:" + mp2.getKey() + " mp2.value:" + mp2.getValue()[0] + "," + mp2.getValue()[1]);
            }
            Set<String> ignoreIds = new HashSet<>();
            Map<String, Set<String>> newMap = new HashMap<>();
            int idx1 = 0;
            for (Map.Entry<String, String[]> entry : mappppp2.entrySet()) {
                if (ignoreIds.contains(entry.getKey())) {
                    continue;
                }
                if (subSolution != null) {
                    Map<String, Set<String>> restmp = subSolution.getResult();
                    String idSetIdx = subSolution.getIdSetIdx(entry.getKey());
                    if (idSetIdx != null) {
                        String aasdfas = subSolution.getIdSetIdx(idSetIdx);
                        Set<String> idSett = restmp.get(aasdfas);
                        Set<String> sssss = new HashSet<>();
                        for (String idIcxx : idSett) {
                            sssss.add(mappppp2.get(idIcxx)[0]);
                            mappppp1.put(mappppp2.get(idIcxx)[0], String.valueOf(idx1));
                            sssss.add(mappppp2.get(idIcxx)[1]);
                            mappppp1.put(mappppp2.get(idIcxx)[1], String.valueOf(idx1));
                            ignoreIds.add(idIcxx);
                            //拼成一行
                        }
                        //输出刚拼成的一行
                        newMap.put(String.valueOf(idx1), sssss);
                        idx1++;
                    } else {
                        //输出一行
                        Set<String> sssss = new HashSet<>();
                        sssss.add(entry.getValue()[0]);
                        mappppp1.put(entry.getValue()[0], String.valueOf(idx1));
                        sssss.add(entry.getValue()[1]);
                        mappppp1.put(entry.getValue()[1], String.valueOf(idx1));
                        newMap.put(String.valueOf(idx1), sssss);
                        idx1++;
                    }
                } else {
                    //输出一行
                    Set<String> sssss = new HashSet<>();
                    sssss.add(entry.getValue()[0]);
                    mappppp1.put(entry.getValue()[0], String.valueOf(idx1));
                    sssss.add(entry.getValue()[1]);
                    mappppp1.put(entry.getValue()[1], String.valueOf(idx1));
                    newMap.put(String.valueOf(idx1), sssss);
                    idx1++;
                }
            }
            resultMapTmp = newMap;
            System.out.println(resultMapTmp);
            System.out.println("--------------------------");
            return resultMapTmp;
        }
    }
}
