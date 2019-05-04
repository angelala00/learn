package cn.jc.datastructure.sort;

import cn.jc.util.Util;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author zys59三仙半（QQ：597882752）<br>
 * 创建时间：2015年7月13日 上午7:59:59
 */
public class RectWithInt extends JFrame {
    private static final long serialVersionUID = 3456314340308050741L;

    private JPanel contentPane;


    private int title_hight = 22;
    private int canvas_width = 500;
    private int canvas_hight = 100;

    private Color canvas_background_color = new Color(135, 178, 142);
    private Color canvas_item_color = new Color(91, 95, 97);
    private int[] inputArr = new int[]{1, 4, 2, 6};
    private int item_max = 6;
    // var inputArr = [1, 17, 6, 9, 2, 4, 100, 38, 94, 29, 46, 3, 57, 65, 19, 5];
    // var item_max = 100;
    private int item_jianju = 10;
    private int item_width_common = canvas_width / inputArr.length - item_jianju;
    private int item_hight_max = (int) (canvas_hight * 0.9);


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    RectWithInt frame = new RectWithInt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RectWithInt() throws InterruptedException {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, canvas_width, canvas_hight * 2 + title_hight);
        setTitle("冒泡排序演示");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        contentPane.setLayout(null);
        contentPane.setBackground(canvas_background_color);
        setContentPane(contentPane);


        RectCanvas[] carr = initarr(inputArr);

        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    System.out.println("====");
                    sort(carr);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private RectCanvas[] initarr(int[] arr) {
        RectCanvas[] carr = new RectCanvas[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int item_hight = item_hight_max * inputArr[i] / item_max;
            RectCanvas canvas = new RectCanvas(item_width_common, item_hight, inputArr[i]);
            canvas.setBackground(canvas_item_color);
            canvas.setLocation(i * (item_width_common + item_jianju), canvas_hight - item_hight);
            getContentPane().add(canvas);
            carr[i] = canvas;
        }
        return carr;
    }


    public void sort(RectCanvas[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                showcomparecolor(arr, j, j + 1);
                if (arr[j].getData() > arr[j + 1].getData()) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void swap(RectCanvas[] arr, int j, int i) throws InterruptedException {
        RectCanvas tmp = tmpI(arr, i);
        transferJtoI(arr,j,i);
        restoreTmpToJ(arr,j,tmp);
    }

    private void restoreTmpToJ(RectCanvas[] arr, int j, RectCanvas tmp) throws InterruptedException {
        Thread.sleep(1000);
        arr[j] = tmp;
        getContentPane().remove(arr[j]);
        arr[j].setLocation(j * (item_width_common + item_jianju), canvas_hight - arr[j].getHeight());
        getContentPane().add(arr[j]);
        getContentPane().repaint();
    }

    private void transferJtoI(RectCanvas[] arr, int j, int i) throws InterruptedException {
        Thread.sleep(1000);
        arr[i] = arr[j];
        getContentPane().remove(arr[j]);
        arr[j].setLocation(i * (item_width_common + item_jianju), canvas_hight - arr[i].getHeight());
        getContentPane().add(arr[j]);
        getContentPane().repaint();
    }

    private RectCanvas tmpI(RectCanvas[] arr, int i) throws InterruptedException {
        Thread.sleep(1000);
        RectCanvas tmp = arr[i];
        getContentPane().remove(arr[i]);
        arr[i].setLocation(arr[i].getX(), arr[i].getY() + canvas_hight);
        getContentPane().add(arr[i]);
        arr[i].repaint();
        contentPane.updateUI();
        return tmp;
    }

    private void showcomparecolor(RectCanvas[] arr, int x, int y) {

    }

    public class RectCanvas extends Canvas {
        private static final long serialVersionUID = 5070517776553228277L;
//        private int idx;
        private int data;

        public RectCanvas(int w, int h, int data) {
            this.setSize(w, h);
//            this.idx = idx;
            this.data = data;
        }

//        public int getIdx() {
//            return idx;
//        }
//
//        public void setIdx(int idx) {
//            this.idx = idx;
//        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
            //接收数据后，重新绘制矩形
//            repaint();
        }
    }
}