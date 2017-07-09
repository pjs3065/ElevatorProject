
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
	
	// Main�� ��ü���� GUI�� �������ִ� ����� �Ѵ�.  
	//(��Ȳ�� �´� ���� ���������͸� �������ָ�, ���������� ���ΰ�, ������������ ������, ����� �������� �������ش�.)
	
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

		//NORMAL TIME�� ���
		if (jf.get_selectTime() == 1) {
			
			g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
			g.drawImage(jf.getImg(0), 0, 0, this.getWidth(), this.getHeight(), this); 
			
			//��� ���������͸� �������ִ� �Ͼἱ�� �ǹ��Ѵ�.
			for (int i = 0; i < 5; i++) {
				g.setColor(Color.white);
				g.drawLine(430 + i * 50, 0, 430 + i * 50, this.getHeight());
			}
			
			//NORMAL�� ù��°�� ����������
			Elevator ele1 = elev.get(0);
			if (!ele1.get_open()) { // open �� �ƴ� ��� closing �׸�
				g.drawImage(ele1.getImg(0), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2 = 0; //�� ���ڸ� ����Ѵ�.
			} else if (ele1.get_open()) { // ���������Ͱ�open �Ұ�� ( 50 x 30 ) �� ũ��
				g.drawImage(ele1.getImg(1), ele1.getX(), ele1.getY(), 50, 30, this);
				if (cnt2 / 10 == 1) // ���࿡ 10���� ���� ���� �Ǹ� ���� �ݴ´�.
					g.drawImage(ele1.getImg(2), ele1.getX(), ele1.getY(), 50, 30, this);
				cnt2++; // �ѹ� ���븶�� ī��Ʈ�� ���ش�.
			}

			//NORMAL�� �ι�°�� ����������
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

			//NORMAL�� ����°�� ����������
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

			//NORMAL�� �׹�°�� ����������
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

			//��ٰ� �����̴� ���� �ٲ��ش�.
			for (int i = 0; i < allpeople.size(); i++) {
				PeopleInfo tmpPeople = allpeople.get(i);
				if (tmpPeople.getX() >= tmpPeople.getD_x())
					g.drawImage(tmpPeople.getImg(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
				else { // ������ x�࿡ ��ġ���� ���� ��쿡�� ����ؼ� �����̴� ȿ���� ����.
					if (cnt % 2 == 0)
						g.drawImage(tmpPeople.getImg(0), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else if (cnt % 3 == 0)
						g.drawImage(tmpPeople.getImg(1), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);
					else
						g.drawImage(tmpPeople.getImg(2), tmpPeople.getX(), tmpPeople.getY(), 30, 30, this);

				}
			}
			cnt++; // �̹����� �����̰� �ϱ����ؼ� ī��Ʈ�� ��� �÷��ְ� �ǰ�, cnt�� 2�� ��� 3�ǹ�� �׸��� ��������
				   // ����� ������ ����� �ٴ� ����� ������ش�.
		}

		// 2��° ��ư Opening time�� ��츦 ���������ش�.(���� �ڵ�� ������ ����)
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

		// 3��° ��ư Closing time�� ��츦 ���������ش�.(���� �ڵ�� ������ ����)
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
