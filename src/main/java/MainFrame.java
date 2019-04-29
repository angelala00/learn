import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 框架主函数
 *
 * @author zhangyue
 * @date 2019年3月4日 下午5:32:34
 */
public class MainFrame {

    private static BufferedWriter bw = null;
    private static OutputStream fos = null;
    private static final char DOT = ',';
    private static final char NEWLINE = '\n';

    public static void main(String[] args) throws Exception {
        if (!argsCheck(args)) {
            System.out.println("params not match: " + Arrays.toString(args)
                    + ", need inputfile outputfile tempdir!");
            System.exit(0);
        }

        final String inputFile = args[0];// 输入文件
        final String outputFile = args[1];// 输出文件
        final String useTimeFile = args[2];// 运行用时
        final String tempDir = args[3];// 计算用临时目录

        long totalTime = 0;

        try {

            fos = new FileOutputStream(outputFile, false);
            bw = Files.newBufferedWriter(Paths.get(outputFile), StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);


            Solution solution = new Solution();

            // 初始化
            solution.init(tempDir);

            // 执行主体
            long startTime = System.nanoTime();
            solution.process(inputFile);
            long endTime = System.nanoTime();

            // 计时
            totalTime = (endTime - startTime) / 1000;
            Files.write(Paths.get(useTimeFile), String.valueOf(totalTime).getBytes(),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

        } finally {
            close(bw);
            close(fos);
        }

        System.exit(0);

    }

    private static boolean argsCheck(String[] str) {
        return str == null || str.length == 4;
    }

    public static void addSet(final String[] result) throws Exception {
        int size = result.length;
        bw.write(result[0]);
        for (int i = 1; i < size; i++) {
            bw.write(DOT);
            bw.write(result[i]);
        }
        bw.write(NEWLINE);
    }

    public static void addSet(final List<String> result) throws Exception {
        int size = result.size();
        bw.write(result.get(0));
        for (int i = 1; i < size; i++) {
            bw.write(DOT);
            bw.write(result.get(i));
        }
        bw.write(NEWLINE);
    }

    public static void addSet(final Set<String> result) throws Exception {
        Iterator<String> it = result.iterator();
        bw.write(it.next());
        while (it.hasNext()) {
            bw.write(DOT);
            bw.write(it.next());
        }
        bw.write(NEWLINE);
    }

    public static void addSet(final Iterator<String> it) throws Exception {
        bw.write(it.next());
        while (it.hasNext()) {
            bw.write(DOT);
            bw.write(it.next());
        }
        bw.write(NEWLINE);
    }

    public static void addSet(final byte[] buffer) throws Exception {
        fos.write(buffer);
    }

    private static void close(Closeable closeable) throws IOException {
        if (closeable != null) {
            closeable.close();
        }
    }

}