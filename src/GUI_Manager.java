
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUI_Manager extends JPanel {
	
	// Main의 전체적인 GUI를 관리해주는 기능을 한다.  
	//(상황에 맞는 배경과 엘레베이터를 구분해주며, 엘레베이터 라인과, 엘레베이터의 움직임, 라바의 움직임을 설정해준다.)
	
	private ArrayList<PeopleInfo> allpeople;
	private ArrayList<Elevator> elev;
	private int cnt = 0;
	private int cnt2 = 0;
	private int cnt3 = 0;
	private int cnt4 = 0;
	private int cnt5 = 0;

	Main jf;

	public GUI_Manager(Main jf, ArrayList<PeopleInfo> allpeople, ArrayList<Elevator> elev) {
		setLayout(null);
		setBounds(75, 0, 925, 600);
		this.allpeople = allpeople;
		this.elev = elev;
		this.jf = jf;
	}

	public void paintComponent(Graphics g) {

		//NORMAL TIME일 경우
		if (jf.get_selectTime() == 1) {
			
			g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
			g.drawImage(jf.getImg(0), 0, 0, this.getWidth(), this.getHeight(), this); 
			
			//가운데 엘레베이터를 구분해주는 하얀선을 의미한다.
			for (int i = 0; i < 5; i++) {
				g.setColor(Color.white);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}
			
			//NORMAL의 첫번째의 엘레베이터
			Elevator ele1 = elev.get(0);
			if (!ele1.get_open()) { // open 이 아닐 경우 closing 그림
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2 = 0; //총 숫자를 얘기한다.
			} else if (ele1.get_open()) { // 엘레베이터가open 할경우 ( 50 x 30 ) 의 크기
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30, this);
				if (cnt2 / 10 == 1) // 만약에 10명이 가득 차게 되면 문을 닫는다.
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2++; // 한번 돌대마다 카운트를 세준다.
			}

			//NORMAL의 두번째의 엘레베이터
			Elevator ele2 = elev.get(1);
			if (!ele2.get_open()) {
				g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3 = 0;
			} else if (ele2.get_open()) {
				g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30, this);
				if (cnt3 / 10 == 1)
					g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3++;
			}

			//NORMAL의 세번째의 엘레베이터
			Elevator ele3 = elev.get(2);
			if (!ele3.get_open()) {
				g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4 = 0;
			} else if (ele3.get_open()) {
				g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30, this);
				if (cnt4 / 10 == 1)
					g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4++;
			}

			//NORMAL의 네번째의 엘레베이터
			Elevator ele4 = elev.get(3);
			if (!ele4.get_open()) {
				g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5 = 0;
			} else if (ele4.get_open()) {
				g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30, this);
				if (cnt5 / 10 == 1)
					g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5++;
			}

			//라바가 움직이는 것을 바꿔준다.
			for (int i = 0; i < allpeople.size(); i++) {
				PeopleInfo tmpPeople = allpeople.get(i);
				if (tmpPeople.getX() >= tmpPeople.getD_x())
					g.drawImage(tmpPeople.getImg(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
				else { // 목적지 x축에 위치하지 않을 경우에는 계속해서 움직이는 효과를 낸다.
					if (cnt % 2 == 0)
						g.drawImage(tmpPeople.getImg(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else if (cnt % 3 == 0)
						g.drawImage(tmpPeople.getImg(1), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else
						g.drawImage(tmpPeople.getImg(2), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);

				}
			}
			cnt++; // 이미지를 움직이게 하기위해서 카운트를 계속 올려주게 되고, cnt를 2의 배수 3의배수 그리고 나머지의
				   // 배수로 나눠서 사람이 뛰는 모양을 만들어준다.
		}

		// 2번째 버튼 Opening time일 경우를 디자인해준다.(위의 코드와 설명은 같다)
		else if (jf.get_selectTime() == 2) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(jf.getImg(1), 0, 0, this.getWidth(), this.getHeight(), this);
		
			for (int i = 0; i < 5; i++) { 
				g.setColor(Color.white);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}

			Elevator ele1 = elev.get(0);

			if (!ele1.get_open()) {
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2 = 0;
			} else if (ele1.get_open()) {
	
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30, this);
				if (cnt2 / 10 == 1)
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2++;

			}

			Elevator ele2 = elev.get(1);

			if (!ele2.get_open()) {
				g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3 = 0;
			} else if (ele2.get_open()) {
				g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30, this);
				if (cnt3 / 10 == 1)
					g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3++;
	
			}
			Elevator ele3 = elev.get(2);
			if (!ele3.get_open()) {
				g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4 = 0;
			} else if (ele3.get_open()) {
				g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30, this);
				if (cnt4 / 10 == 1)
					g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4++;
	
			}
			Elevator ele4 = elev.get(3);
			if (!ele4.get_open()) {
				g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5 = 0;
			} else if (ele4.get_open()) {
				g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30, this);
				if (cnt5 / 10 == 1)
					g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5++;
			}
			for (int i = 0; i < allpeople.size(); i++) {
				PeopleInfo tmpPeople = allpeople.get(i);
				if (tmpPeople.getX() >= tmpPeople.getD_x())
					g.drawImage(tmpPeople.getImg2(2), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
				else {
					if (cnt % 2 == 0)
						g.drawImage(tmpPeople.getImg2(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else if (cnt % 3 == 0)
						g.drawImage(tmpPeople.getImg2(1), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else
						g.drawImage(tmpPeople.getImg2(2), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);

				}
			}
			cnt++;
		}

		// 3번째 버튼 Closing time일 경우를 디자인해준다.(위의 코드와 설명은 같다)
		else if (jf.get_selectTime() == 3) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.drawImage(jf.getImg(2), 0, 0, this.getWidth(), this.getHeight(), this);
		

			for (int i = 0; i < 5; i++) {
				g.setColor(Color.white);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}

			Elevator ele1 = elev.get(0);
			if (!ele1.get_open()) {
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2 = 0;
			} else if (ele1.get_open()) {
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30, this);
				if (cnt2 / 10 == 1)
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2++;
			}

			Elevator ele2 = elev.get(1);

			if (!ele2.get_open()) {
				g.drawImage(ele2.getImg(0), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3 = 0;
			} else if (ele2.get_open()) {
				g.drawImage(ele2.getImg(1), ele2.getX(), ele2.getY(), 50, 30, this);
				if (cnt3 / 10 == 1)
					g.drawImage(ele2.getImg(2), ele2.getX(), ele2.getY(), 50, 30, this);
				cnt3++;
			}
			
			Elevator ele3 = elev.get(2);
			if (!ele3.get_open()) {
				g.drawImage(ele3.getImg(0), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4 = 0;
			} else if (ele3.get_open()) {
				g.drawImage(ele3.getImg(1), ele3.getX(), ele3.getY(), 50, 30, this);
				if (cnt4 / 10 == 1)
					g.drawImage(ele3.getImg(2), ele3.getX(), ele3.getY(), 50, 30, this);
				cnt4++;
			}
			
			Elevator ele4 = elev.get(3);
			if (!ele4.get_open()) {
				g.drawImage(ele4.getImg(0), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5 = 0;
			} else if (ele4.get_open()) {
				g.drawImage(ele4.getImg(1), ele4.getX(), ele4.getY(), 50, 30, this);
				if (cnt5 / 10 == 1)
					g.drawImage(ele4.getImg(2), ele4.getX(), ele4.getY(), 50, 30, this);
				cnt5++;
			}
			
			for (int i = 0; i < allpeople.size(); i++) {
				PeopleInfo tmpPeople = allpeople.get(i);
				if (tmpPeople.getX() >= tmpPeople.getD_x())
					g.drawImage(tmpPeople.getImg3(1), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
				else {
					if (cnt % 2 == 0)
						g.drawImage(tmpPeople.getImg3(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else if (cnt % 3 == 0)
						g.drawImage(tmpPeople.getImg3(1), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else
						g.drawImage(tmpPeople.getImg3(2), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
				}
			}
			cnt++;
		}
	}
}
