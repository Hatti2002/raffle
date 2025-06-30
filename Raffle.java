import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Raffle extends JFrame{
  JTextField tR1;
  JTextField tR2;
  JTextField tB1;
  JTextField tB2;
  JTextField ladd3;
  JTextField ladd4;
  public static void main(String args[]){
    Raffle panel = new Raffle();
    panel.setBounds(15, 15, 240, 230);
    panel.setTitle("ランダム");
    panel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel.setVisible(true);
  }

  private Raffle(){
    JTabbedPane tab = new JTabbedPane();
      JPanel panel1 = new JPanel();
        panel1.setLayout(null);
      JPanel panel2 = new JPanel();
        panel2.setLayout(null);

      JLabel lR = new JLabel("人数");
      panel1.add(lR);
      lR.setBounds(10,0,100,30);

      JLabel lB = new JLabel("人数");
      panel2.add(lB);
      lB.setBounds(10,0,100,30);

      JLabel ladd1 = new JLabel("同じ人が当たる場合があります。");
      panel1.add(ladd1);
      ladd1.setBounds(10,100,190,30);

      JLabel ladd2 = new JLabel("一度当たった人は当たりません。");
      panel2.add(ladd2);
      ladd2.setBounds(10,100,190,30);

      ladd3 = new JTextField("番号：");
      panel1.add(ladd3);
      ladd3.setBounds(10,134,190,16);

      ladd4 = new JTextField("番号：");
      panel2.add(ladd4);
      ladd4.setBounds(10,134,190,16);

      tR1 = new JTextField();
      panel1.add(tR1);
      tR1.setBounds(120,9,80,16);
      tR1.setHorizontalAlignment(JTextField.RIGHT);

      tR2 = new JTextField("入力不要");
      panel1.add(tR2);
      tR2.setBounds(120,59,80,16);
      tR2.setHorizontalAlignment(JTextField.RIGHT);

      tB1 = new JTextField();
      panel2.add(tB1);
      tB1.setBounds(120,9,80,16);
      tB1.setHorizontalAlignment(JTextField.RIGHT);

      tB2 = new JTextField("入力不要");
      panel2.add(tB2);
      tB2.setBounds(120,59,80,16);
      tB2.setHorizontalAlignment(JTextField.RIGHT);

      JButton bR = new JButton("当てる");
      panel1.add(bR);
      bR.setBounds(120,35,80,16);
      bR.setMargin(new Insets(0,0,0,0));

      JButton bB = new JButton("当てる");
      panel2.add(bB);
      bB.setBounds(120,35,80,16);
      bB.setMargin(new Insets(0,0,0,0));

      JButton ac1 = new JButton("オールクリア");
      panel1.add(ac1);
      ac1.setBounds(120,85,80,16);
      ac1.setMargin(new Insets(0,0,0,0));

      JButton ac2 = new JButton("オールクリア");
      panel2.add(ac2);
      ac2.setBounds(120,85,80,16);
      ac2.setMargin(new Insets(0,0,0,0));

      bR.addActionListener(new action1());
      bB.addActionListener(new action2());
      ac1.addActionListener(new action3());
      ac2.addActionListener(new action4());
      tab.addTab("完全ランダム", panel1);
      tab.addTab("1人1回", panel2);
    Container contentPane = getContentPane();
    getContentPane().add(tab, BorderLayout.CENTER);
  }

  private class action1 implements ActionListener{
    public void actionPerformed(ActionEvent e){

      String a1String2 =new String(tR1.getText());
      if(a1String2.indexOf("人") != -1){
        a1String2 = a1String2.substring(0,a1String2.length()-1);
      }

      double a1num = Integer.parseInt(a1String2);
      double a1ran = Math.random();
      int a1num1 = (int)((a1ran*a1num)+1);
      String a1String = new String(Integer.toString(a1num1));
      tR2.setText(a1String+"番");
      ladd3.setText(ladd3.getText()+a1String+", ");
    }
  }

  private class action2 implements ActionListener{
    public void actionPerformed(ActionEvent e){

      String a2String2 =new String(tB1.getText());
      if(a2String2.indexOf("人") != -1){
        a2String2 = a2String2.substring(0,a2String2.length()-1);
      }

      String a2String;
      String a2String3;
      double a2num = Integer.parseInt(a2String2);
      int a2num4 = Integer.parseInt(a2String2);
      String a2String4 = new String(ladd4.getText());
      int a2num3 = a2String4.length();
      if(a2String4.indexOf("全") != -1){
        ladd4.setText("番号：");
      }

      String a2S;
      String a2S2;
      int a2N = -1;
      if(a2num3 > 4){
        for(int i=1;i <= a2num4; i++){
          a2S = new String(Integer.toString(i));
          a2S2 = new String(" "+a2S+",");
          a2N = (ladd4.getText()).indexOf(a2S2);
          if(a2N == -1){
            break;
          }
        }
      }

      if(a2N == -1){
        do{
          double a2ran = Math.random();
          int a2num2 = (int)((a2ran*a2num)+1);
          a2String = new String(Integer.toString(a2num2));
          a2String3 = new String(ladd4.getText());
        }while(a2String3.indexOf(" "+a2String+",") != -1);
        tB2.setText(a2String+"番");
        ladd4.setText(ladd4.getText()+" "+a2String+",");
      }else{
        tB2.setText("入力不要");
        ladd4.setText("全ての番号が当たりました。");
      }
    }
  }

  private class action3 implements ActionListener{
    public void actionPerformed(ActionEvent e){
      tR1.setText("");
      tR2.setText("入力不要");
      ladd3.setText("番号：");
    }
  }

  private class action4 implements ActionListener{
    public void actionPerformed(ActionEvent e){
      tB1.setText("");
      tB2.setText("入力不要");
      ladd4.setText("番号：");
    }
  }
}
