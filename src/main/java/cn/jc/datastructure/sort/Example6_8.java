package cn.jc.datastructure.sort;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Example6_8 extends JFrame implements ActionListener
{
    private JButton left=new JButton("向左移");
    private JButton right=new JButton("向右移");
    private JButton up=new JButton("向上移");
    private JButton down=new JButton("向下移");
    MoveCanvas drawing=new MoveCanvas();
    private class WindowCloser extends WindowAdapter
    {
        public void windowClosing(WindowEvent we)
        {
            System.exit(0);
        }
    }
    public Example6_8()
    {
        super("移动方块");
        setSize(400,400);
        setVisible(true);
        Panel p=new Panel();
        p.setLayout(new FlowLayout());
        setLayout(new BorderLayout());
        add(p,BorderLayout.SOUTH);
        add(drawing,BorderLayout.CENTER);
        p.add(up);
        p.add(down);
        p.add(left);
        p.add(right);
        validate();
        left.addActionListener(this);
        right.addActionListener(this);
        up.addActionListener(this);
        down.addActionListener(this);
        addWindowListener(new WindowCloser());
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==up)
            drawing.moveUp();
        else if(e.getSource()==down)
            drawing.moveDown();
        else if(e.getSource()==left)
            drawing.moveLeft();
        else if(e.getSource()==right)
            drawing.moveRight();
    }
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Example6_8();
    }
}
class MoveCanvas extends Canvas
{
    int WIDTH=30,HEIGHT=30,INC=10;
    int i,j;
    public void paint(Graphics g)
    {
        g.drawRect(0,0,getSize().width-1,getSize().height-1);
        g.setColor(Color.black);
        g.fillRect(i+2,j+2,WIDTH+2,HEIGHT+2);
        g.setColor(Color.red);
        g.fillRect(i,j,WIDTH,HEIGHT);
    }
    public void moveUp()
    {
        if(j>0)
            j-=INC;
        else
            j=getSize().height-INC;
        repaint();
    }
    public void moveDown()
    {
        if(j<getSize().height-INC)
            j+=INC;
        else
            j=0;
        repaint();
    }
    public void moveLeft()
    {
        if(i>0)
            i-=INC;
        else
            i=getSize().width-INC;
        repaint();
    }
    public void moveRight()
    {
        if(i<getSize().width-INC)
            i+=INC;
        else
            i=0;
        repaint();
    }
}