import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * V4
 * 一个Map作为中间变量版本
 * 服务器耗时600ms左右
 */
public class SolutionV4 {
    private Map<String, Set<String>> setMap = new HashMap<>();
    private Set<Set<String>> tmpSet = new HashSet<>();

    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
    }

    public void process(String inputPath) throws Exception {
        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
        String line = br.readLine();
        while (line != null && line.length() > 0) {
            String[] lineArray = line.split(",");
            if (lineArray != null && lineArray.length == 2) {
                String ida = lineArray[0].trim();
                String idb = lineArray[1].trim();

                Set<String> seta = setMap.get(ida);
                Set<String> setb = setMap.get(idb);
                if (seta != null && setb == null) {
                    seta.add(idb);
                    setMap.put(idb, seta);
                }
                if (seta == null && setb != null) {
                    setb.add(ida);
                    setMap.put(ida, setb);
                }
                if (seta != null && setb != null) {
                    if (seta != setb) {
                        for (String tmpb : setb) {
                            seta.add(tmpb);
                            setMap.put(tmpb, seta);
                        }
                    }
                }
                if (seta == null && setb == null) {
                    Set<String> s = new HashSet<>();
                    s.add(ida);
                    s.add(idb);
                    setMap.put(ida, s);
                    setMap.put(idb, s);
                }
            } else {
                System.out.println("====");
            }
            line = br.readLine();
        }
        for (Set<String> sets : setMap.values()) {
            if (!tmpSet.contains(sets)) {
                MainFrame.addSet(sets.toArray(new String[sets.size()]));
                tmpSet.add(sets);
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
