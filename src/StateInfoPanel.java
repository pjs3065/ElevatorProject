import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

//���� ��ٸ��� ����� ��, Ÿ�� �ִ� ��, �� �����Ե� ����ǥ������ ������Ѵ�.

public class StateInfoPanel extends JPanel{

   //���������� ����ǥ���� ������
   public StateInfoPanel(){
      setLayout(null);
      setBounds(1000, 0, 335, 600);
      
   }
   public void paintComponent(Graphics g)
   {
      //������ �� ���ڿ� ����
      Font font1 = new Font("Serif",Font.BOLD,15);
      Font font2 = new Font("Serif",Font.TRUETYPE_FONT,14);
      String a = "    Elevator1";
      String b = "    Elevator2";
      String c = "    Elevator3";
      String d = "    Elevator4";
      String e = "Waiting";
      String f = "number";
      String h = "Average";
      String j = "   Time";
      
      //������ �־��ش�.
      Color color1 = new Color(70,50,0);
      g.setColor(color1);
      g.fillRect(0, 0, 335,600);

      for(int i=0; i<2; i++)
      {
         g.setColor(Color.red);
         g.drawRect(15, 5 + (i * 85), 65, 70);
         
         g.setColor(new Color(255,255,0));
         g.fillRect(16, 6 + (i * 85), 64, 69);
         
         g.setColor(Color.red);
         g.drawLine(15, 45+ (i*85), 80, 45+ (i*85));
      }
      
      // num�� weight�� ���� ���� ���
      for(int i=0; i<2; i++){
         g.setColor(Color.yellow);
         g.drawRect(90+(i*120), 5, 105, 70);
         g.setColor(new Color(255,20,0));
         g.fillRect(91+(i*120), 6, 104, 69);
         
      }
      for(int i=0; i<2; i++){
         g.setColor(Color.yellow); 
         g.drawLine(90+(i*120), 25, 195+(i*120), 25);
         g.drawLine(140+(i*120), 25, 140+(i*120), 75);
      }
      
      
      for(int i=0; i<2; i++){ 
          g.setColor(Color.yellow);
          g.drawRect(90+(i*120), 90, 105, 70);
          g.setColor(new Color(255,20,0));
          g.fillRect(91+(i*120), 91, 104, 69);
          
       }
       for(int i=0; i<2; i++){
          g.setColor(Color.yellow); 
          g.drawLine(90+(i*120), 110, 195+(i*120), 110);
          g.drawLine(140+(i*120), 110, 140+(i*120), 160);
       }

      //�ش� ���ڿ��� �׷��ش�. �� �ڽ��� ��ǥ���ٰ�
      // Waiting �� Average time
      g.setColor(Color.red);
       
      g.setFont(font1);       
      g.drawString(e, 25, 20);
      g.drawString(h, 20, 110);
      g.drawString(f, 25, 40);
      g.drawString(j, 20, 125);
      
      // ���������� 
      g.setColor(Color.yellow);
    
      g.drawString(a, 95, 20);
      g.drawString(b, 215, 20);
      g.drawString(c, 95, 107);
      g.drawString(d, 215, 107);

      for(int i=0; i<2; i++)
      {   
         g.setFont(font2);
         g.drawString(" Num", 95+(120*i), 40);
         g.drawString("Weight", 145+(120*i), 40);
      }
      
      for(int i=0; i<2; i++)
      {   
         g.setFont(font2);
         g.drawString(" Num", 95+(120*i), 125);
         g.drawString("Weight", 145+(120*i), 125);
      }
   }
}