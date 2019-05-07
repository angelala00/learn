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
public class SolutionV2 {

    /**
     * 初始化
     *
     * @param tempDir 可读写的临时目录
     */
    public void init(String tempDir) throws Exception {
        // 此部分不计入执行用时，提供了临时目录用于暂存数据，请合理发挥。
    }

    /**
     * 用到了list，效率低，结果正确，服务器运行超时
     * 主体逻辑实现demo，实现代码时请注意逻辑严谨性，涉及到操作文件时，保证文件有开有闭等。
     *
     * @param inputPath 输入文件路径，请不要hack它-_-。
     */
    public void process(String inputPath) throws Exception {
        List<Set<String>> list = new ArrayList<>();
        BufferedReader br = Files.newBufferedReader(Paths.get(inputPath));
        String line = br.readLine();
        while (line != null && line.length() > 0) {
            String[] lineArray = line.split(",");
            if (lineArray != null && lineArray.length == 2) {
                String ida = lineArray[0].trim();
                String idb = lineArray[1].trim();
                int setindex = -1;
                int removeindex = -1;
                for (int i = 0; i < list.size(); i++) {
                    Set<String> set = list.get(i);
                    if (set.contains(ida) || set.contains(idb)) {
                        if (setindex > -1) {
                            list.get(setindex).addAll(set);
                            removeindex = i;
                            break;
                        } else {
                            set.add(ida);
                            set.add(idb);
                            setindex = i;
                        }
                    }
                }
                if (setindex == -1) {
                    Set<String> s = new HashSet<>();
                    s.add(ida);
                    s.add(idb);
                    list.add(s);
                }
                if (removeindex > -1) {
                    list.remove(removeindex);
                }
            } else {
                System.out.println("====");
            }
            line = br.readLine();
        }

        for (Set<String> s : list) {
            MainFrame.addSet(s.toArray(new String[s.size()]));
        }
    }
}
