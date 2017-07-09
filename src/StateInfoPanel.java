import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

//현재 기다리는 사람의 수, 타고 있는 수, 총 몸무게등 상태표시줄의 기능을한다.

public class StateInfoPanel extends JPanel{

   //엘레베이터 상태표시줄 디자인
   public StateInfoPanel(){
      setLayout(null);
      setBounds(1000, 0, 335, 600);
      
   }
   public void paintComponent(Graphics g)
   {
      //문구로 들어갈 문자열 값들
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
      
      //갈색을 넣어준다.
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
      
      // num과 weight을 담을 상자 출력
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

      //해당 문자열을 그려준다. 각 박스안 좌표에다가
      // Waiting 과 Average time
      g.setColor(Color.red);
       
      g.setFont(font1);       
      g.drawString(e, 25, 20);
      g.drawString(h, 20, 110);
      g.drawString(f, 25, 40);
      g.drawString(j, 20, 125);
      
      // 엘레베이터 
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