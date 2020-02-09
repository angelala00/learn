package cn.jc.contest;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 请在此类中完成解决方案，需要实现init完成数据初始化，实现process完成数据的处理逻辑。
 *
 * @author zhangyue
 * @date 2019年3月4日 下午3:38:00
 */
public class SolutionV1 {

    /**
     * 初始化
     *
     * @param tempDir 可读写的临时目录
     */
    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
    }

    /**
     * 未成功版本
     * 结果不正确
     * 主体逻辑实现demo，实现代码时请注意逻辑严谨性，涉及到操作文件时，保证文件有开有闭等。
     *
     * @param inputPath 输入文件路径，请不要hack它-_-。
     */
    public void processv(String inputPath) throws Exception {
        List<Set<String>> list = new ArrayList<Set<String>>();
        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
        String line = br.readLine();
        while (line != null && line.length() > 0) {
            String[] lineArray = line.split(",");
            if (lineArray != null && lineArray.length == 2) {
                String ida = lineArray[0].trim();
                String idb = lineArray[1].trim();
                boolean contain = false;
                for (Set<String> set : list) {
                    if (set.contains(ida)) {
                        if (!set.contains(idb)) {
                            set.add(idb);
                            contain = true;
                        }
                    } else if (set.contains(idb)) {
                        set.add(ida);
                        contain = true;
                    }
                }

                if (!contain) {
                    Set<String> s = new HashSet<String>();
                    s.add(lineArray[0].trim());
                    s.add(lineArray[1].trim());
                    list.add(s);
                }
            }
            line = br.readLine();
        }

        for (Set<String> s : list) {
            MainFrame.addSet(s.toArray(new String[s.size()]));
        }
    }
}
