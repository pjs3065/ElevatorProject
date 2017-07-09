import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Main implements ActionListener {

	private String[] time = new String[3]; // 세개의 시간의 string이 들어감
	private String[] Random = new String[3]; // people per one click 클릭 한번으로
												// 100명을 만들어낸다.
	private String[] Indiv = new String[3]; // I값이다. 클릭시 한명씩 랜덤으로 나온다.
	private JTextArea OnBoardP1 = new JTextArea(); // 탄사람의 수
	private JTextArea OnBoardP2 = new JTextArea();
	private JTextArea OnBoardP3 = new JTextArea();
	private JTextArea OnBoardP4 = new JTextArea();
	private JTextArea elevWeight1 = new JTextArea(); // 엘레베이터당 총 몸무게
	private JTextArea elevWeight2 = new JTextArea();
	private JTextArea elevWeight3 = new JTextArea();
	private JTextArea elevWeight4 = new JTextArea();

	private JTextArea WaitNum = new JTextArea(); // 기다리는 사람의 수
	private JTextArea avgTime = new JTextArea();/// 평균시간타임
	private JFrame jf = new JFrame("Open the door"); // JFrame을 생성 Open the
														// door이 title이다.

	private Toolkit tk; // 이미지를 불러 올수 있는 변수
	private Image img[] = new Image[3]; // 이미지를 저장할 변수
	private JPanel buttonPanel = new JPanel(); // button을 담아줄 panel

	Clip clip; // BGM

	private ArrayList<PeopleInfo> allPeople = new ArrayList<PeopleInfo>();
	private ArrayList<Elevator> Elev = new ArrayList<Elevator>();

	public int[] floor_count = new int[20];
	int select_time = 1;
	int test_case = 0;

	String buttoname;
	String[] time_img = new String[3];
	String[] rand_img = new String[3];
	String[] indiv_img = new String[3];

	// 기다리고 타고, 수용하고있는 몸무게를 나타내는 문자열값
	String waitingnum = "";
	String OnBoardNum1 = "";
	String OnBoardNum2 = "";
	String OnBoardNum3 = "";
	String OnBoardNum4 = "";

	String avaiableWeight1 = "";
	String avaiableWeight2 = "";
	String avaiableWeight3 = "";
	String avaiableWeight4 = "";

	long avg_time = 0, People_queue = 0, time_ = 0;

	inputNumber input;

	public void set_avgTime(long time) {
		this.avg_time = time;
	}

	public long get_avgTime() {
		return avg_time;
	}

	public void set_time(long time) {
		this.time_ = time;
	}

	public long get_time() {
		return time_;
	}

	public void setPeople_queue(long time) {
		this.People_queue = time;
	}

	public long getPeople_queue() {
		return People_queue;
	}

	public void set_test_case(int i) {
		this.test_case = i;
	}

	public int get_test_case() {
		return test_case;
	}

	public void set_WaitNum(String num) {
		WaitNum.setText("       " + num);
		this.waitingnum = num;
	}

	public String get_WaitNum() {
		return waitingnum;
	}

	public void set_avgTime(String num) {
		avgTime.setText("       " + num);
	}

	public void set_OnBoardP1(String num) {
		OnBoardP1.setText("      " + num);
		this.OnBoardNum1 = num;
	}

	public void set_OnBoardP2(String num) {
		OnBoardP2.setText("      " + num);
		this.OnBoardNum2 = num;
	}

	public void set_OnBoardP3(String num) {
		OnBoardP3.setText("      " + num);
		this.OnBoardNum3 = num;
	}

	public void set_OnBoardP4(String num) {
		OnBoardP4.setText("   " + num);
		this.OnBoardNum4 = num;
	}

	public void set_ElevWeight1(String num) {
		elevWeight1.setText("   " + num);
		this.avaiableWeight1 = num;
	}

	public void set_ElevWeight2(String num) {
		elevWeight2.setText("   " + num);
		this.avaiableWeight2 = num;
	}

	public void set_ElevWeight3(String num) {
		elevWeight3.setText("   " + num);
		this.avaiableWeight3 = num;
	}

	public void set_ElevWeight4(String num) {
		elevWeight4.setText("   " + num);
		this.avaiableWeight4 = num;
	}

	public String get_OnBoardP1() {
		return this.OnBoardNum1;
	}

	public String get_OnBoardP2() {
		return this.OnBoardNum2;
	}

	public String get_OnBoardP3() {
		return this.OnBoardNum3;
	}

	public String get_OnBoardP4() {
		return this.OnBoardNum4;
	}

	public String get_ElevWeight1() {
		return this.avaiableWeight1;
	}

	public String get_ElevWeight2() {
		return this.avaiableWeight2;
	}

	public String get_ElevWeight3() {
		return this.avaiableWeight3;
	}

	public String get_ElevWeight4() {
		return this.avaiableWeight4;
	}

	public Main() {
		jf.setLayout(null);
		jf.setBounds(0, 0, 1000 + 340, 600 + 38);
		jf.setLocation(100, 100);
		jf.setResizable(false);

		// BGM
		Sound("videoplayback.wav", true);

		// 버튼 들
		buttonPanel.setLayout(null);
		buttonPanel.setBounds(0, 0, 75, 600);

		time_img[0] = "normal.png";
		time_img[1] = "opening.png";
		time_img[2] = "closing.png";

		rand_img[0] = "r-1.png";
		rand_img[1] = "r-2.png";
		rand_img[2] = "r-3.png";

		indiv_img[0] = "i-1.png";
		indiv_img[1] = "i-2.png";
		indiv_img[2] = "i-3.png";

		time[0] = "Normal";
		time[1] = "RushHour";
		time[2] = "Closing";

		Random[0] = "R";
		Random[1] = "R ";
		Random[2] = " R";

		Indiv[0] = "I";
		Indiv[1] = "I ";
		Indiv[2] = " I";

		for (int i = 0; i < 3; i++) {

			JPanel timePanel = new JPanel(new GridLayout(2, 1));
			timePanel.setOpaque(false);

			JButton timeBtn = new JButton(time[i], new ImageIcon(time_img[i]));
			timeBtn.setBorderPainted(false);
			timeBtn.setContentAreaFilled(false);
			timeBtn.setFocusPainted(false);

			JButton randBtn = new JButton(Random[i], new ImageIcon(rand_img[i]));
			randBtn.setBorderPainted(false);
			randBtn.setContentAreaFilled(false);
			randBtn.setFocusPainted(false);

			JButton indivBtn = new JButton(Indiv[i], new ImageIcon(indiv_img[i]));
			indivBtn.setBorderPainted(false);
			indivBtn.setContentAreaFilled(false);
			indivBtn.setFocusPainted(false);

			JPanel temp = new JPanel(new GridLayout(1, 2));
			temp.setOpaque(false);

			indivBtn.addActionListener(this);
			timeBtn.addActionListener(this);
			randBtn.addActionListener(this);

			temp.add(randBtn);
			temp.add(indivBtn);

			timePanel.add(timeBtn);
			timePanel.add(temp);

			if (i == 0)
				timePanel.setBounds(1020, 210, 151, 190);
			if (i == 1)
				timePanel.setBounds(1171, 210, 151, 190);
			if (i == 2)
				timePanel.setBounds(1020, 410, 151, 190);

			JButton openthedoor = new JButton(new ImageIcon("openthedoor.png"));
			openthedoor.setLayout(null);
			openthedoor.setBounds(1180, 400, 125, 180);

			openthedoor.setBorderPainted(false);
			openthedoor.setContentAreaFilled(false);
			openthedoor.setFocusPainted(false);

			jf.add(timePanel);
			jf.add(openthedoor);
		}

		// textarea(타고 있는사람, 현재 총 몸무게 엘레베이터 네대에 대한 정보)
		OnBoardP1.setBounds(175 - 80 + (0 * 120) + 1000, 50, 40, 20);
		OnBoardP2.setBounds(175 - 80 + (1 * 120) + 1000, 50, 40, 20);
		OnBoardP3.setBounds(175 - 80 + (0 * 120) + 1000, 135, 40, 20);
		OnBoardP4.setBounds(175 - 80 + (1 * 120) + 1000, 135, 40, 20);
		OnBoardP1.setEditable(false);
		OnBoardP2.setEditable(false);
		OnBoardP3.setEditable(false);
		OnBoardP4.setEditable(false);

		elevWeight1.setBounds(225 - 80 + (0 * 120) + 1000, 50, 40, 20);
		elevWeight2.setBounds(225 - 80 + (1 * 120) + 1000, 50, 40, 20);
		elevWeight3.setBounds(225 - 80 + (0 * 120) + 1000, 135, 40, 20);
		elevWeight4.setBounds(225 - 80 + (1 * 120) + 1000, 135, 40, 20);
		elevWeight1.setEditable(false);
		elevWeight2.setEditable(false);
		elevWeight3.setEditable(false);
		elevWeight4.setEditable(false);

		jf.add(OnBoardP1);
		jf.add(OnBoardP2);
		jf.add(OnBoardP3);
		jf.add(OnBoardP4);
		jf.add(elevWeight1);
		jf.add(elevWeight2);
		jf.add(elevWeight3);
		jf.add(elevWeight4);

		WaitNum.setBounds(20 + 1000, 50, 50, 20);// waiting값 좌표
		WaitNum.setEditable(false);

		avgTime.setBounds(20 + 1000, 135, 50, 20);// avg값 좌표
		avgTime.setEditable(false);
		jf.add(WaitNum);
		jf.add(avgTime);

		// 층을 누르는 button생성
		for (int i = 14; i >= -6; i--) {
			JButton btn;
			if (i == -1)
				continue;// ★0층은 제외함

			// ★★지하용
			else if (i < -1) {
				buttoname = "B" + String.valueOf((i + 1) * -1) + "F.png";
				btn = new JButton(new ImageIcon(buttoname));
				btn.setContentAreaFilled(false);
				btn.setFocusPainted(false);
				btn.setBounds(0, 420 + ((-i) - 1) * 30, 75, 30);

				btn.addMouseListener(new Mouse(i));
				buttonPanel.add(btn);
			}

			// ★★지상용
			else {
				buttoname = String.valueOf(i + 1) + "F.png";
				btn = new JButton(new ImageIcon(buttoname));
				btn.setContentAreaFilled(false);
				btn.setFocusPainted(false);
				btn.setBounds(0, (14 - i) * 30, 75, 30);

				btn.addMouseListener(new Mouse(i));
				buttonPanel.add(btn);
			}

		}

		jf.add(buttonPanel);

		JPanel jp = new GUI_Manager(this, allPeople, Elev);
		JPanel jp2 = new StateInfoPanel();

		jf.add(jp);
		jf.add(jp2);

		for (int i = 0; i < 20; i++) {
			floor_count[i] = 0;
		}

		new MainThread(this, allPeople, Elev, jp).start();

		// ★★★엘리베이터 4대의 제일 기본 좌표값!
		Elevator ele1 = new Elevator(0, 570);
		ele1.setX(430);
		ele1.setY(420);
		ele1.set_Onflag(false);
		ele1.set_open(false);
		ele1.setTTLy(0); // 끝에 도달하는 값
		Elev.add(ele1);

		Elevator ele2 = new Elevator(0, 570);
		ele2.setX(480);
		ele2.setY(420);
		ele2.set_Onflag(false);
		ele2.set_open(false);
		ele2.setTTLy(210); // 끝에 도달하는 값
		Elev.add(ele2);

		Elevator ele3 = new Elevator(0, 570);
		ele3.setX(530);
		ele3.setY(420);
		ele3.set_Onflag(false);
		ele3.set_open(false);
		ele3.setTTLy(420); // 끝에 도달하는 값
		Elev.add(ele3);

		Elevator ele4 = new Elevator(0, 570);
		ele4.setX(580);
		ele4.setY(420);
		ele4.set_Onflag(false);
		ele4.set_open(false);
		ele4.setTTLy(570); // 끝에 도달하는 값
		ele4.setLimit(700); // weight을 700으로 늘려줌
		Elev.add(ele4);

		tk = Toolkit.getDefaultToolkit();// 이걸 이용해서 이미지를 가져올 수 있다.
		img[0] = tk.createImage("평상시간.png");
		img[1] = tk.createImage("출근시간.png");
		img[2] = tk.createImage("퇴근시간.png");

		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// BGM을 작동시킨다.

	private void Sound(String file, boolean Loop) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if (Loop)
				clip.loop(-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Image getImg(int i) {
		return img[i];
	}

	// 버튼에 대한 actionPerformed이다.
	public void actionPerformed(ActionEvent e) {
		int dest_floor;
		int[] destination = new int[100];
		int[] normal_floor = new int[100];
		int[] opening_floor = new int[100];
		int[] closing_floor = new int[100];

		for (int i = 0; i < 3; i++) {
			if (e.getActionCommand().equals(Indiv[i])) { // 하나씩 소환시키는 버튼을 눌렀을경우
															// (이건 세가지의 상황을
															// 확인하려고 만든 조건)
				if (i == 0) // 첫번째 I를 눌렀을 경우
				{
					NormalTime test_ = new NormalTime(); // 랜덤값들을 생성한다. 100명의
					destination = test_.get_destFloor(); // 랜덤으로 만든 목적지를 받아준다.
					normal_floor = test_.get_presentFloor(); // 생성될 층을 랜덤으로
																// 받아온다.
					dest_floor = destination[0]; // 먼저 목적지를 받아온 0번째 어레이부터 목적층
													// 변수에 저장된다.
					if (floor_count[normal_floor[0] - 1] == 14) {
						floor_count[normal_floor[0] - 1] = 0; // 14을 넘으면 다시 0부터
						// 세어준다.
					}
					PeopleInfo person = new PeopleInfo(// people의 좌표
							400 - (floor_count[normal_floor[0] - 1] * 30), 600 - (dest_floor * 30), 50);
					person.setY(600 - (normal_floor[0] * 30)); // 현재 층에 위치하고자 하는
																// y축의 위치
					person.setDone(true);

					floor_count[normal_floor[0] - 1]++; // 해당 랜덤층으로 나타난 층의 사람의
														// 수를 세어준다.
					allPeople.add(person);
				}

				// Opening time의 I버튼을 눌렀을 경우
				if (i == 1) {
					int r = 1 + (int) (Math.random() * 100);
					OpeningTime test_ = new OpeningTime();
					destination = test_.get_destFloor(); // 목적지를 받음
					opening_floor = test_.get_presentFloor();
					dest_floor = destination[0];
					if (floor_count[opening_floor[r] - 1] == 14) {
						floor_count[opening_floor[r] - 1] = 0;
					}

					PeopleInfo person = new PeopleInfo(400 - (floor_count[opening_floor[r] - 1] * 30),
							600 - (dest_floor * 30), 50);
					person.setY(600 - opening_floor[r] * 30);
					person.setDone(true);
					floor_count[opening_floor[r] - 1]++;
					allPeople.add(person);
				}

				// closing 일 경우
				if (i == 2) {
					ClosingTime test_ = new ClosingTime();
					closing_floor = test_.get_presentFloor();
					destination = test_.get_destFloor();
					dest_floor = destination[0];
					if (floor_count[closing_floor[0] - 1] == 14) {
						floor_count[closing_floor[0] - 1] = 0;
					}

					PeopleInfo person = new PeopleInfo(400 - (floor_count[closing_floor[0] - 1] * 30),
							600 - (destination[0] * 30), 50);
					person.setY(600 - (closing_floor[0] * 30));
					person.setDone(true);

					floor_count[closing_floor[0] - 1]++;
					allPeople.add(person);
				}
			}
		}

		// 평균시간 값을 보여준다.
		for (int i = 0; i < 3; i++) {
			if (e.getActionCommand().equals(time[i])) { // normal time , Opening
														// time, closing time
				this.avg_time = 0;
				this.time_ = 0;
				this.People_queue = 0;
				this.set_selectTime(i + 1); // normal 일경우 1 opening 일경우 2
											// closing일겨우 3
			}

			// Opening의 R을 누를 경우
			if (e.getActionCommand().equals(Random[i])) {
				this.avg_time = 0;
				this.time_ = 0;
				this.People_queue = 0;
				System.out.println(avg_time + " " + time_ + " " + People_queue);
				if (i == 1) {
					OpeningTime test_ = new OpeningTime();
					opening_floor = test_.get_presentFloor();
					destination = test_.get_destFloor();
					for (int j = 0; j < 100; j++) {
						dest_floor = destination[j];
						if (floor_count[opening_floor[j] - 1] == 14)
							floor_count[opening_floor[j] - 1] = 0;

						PeopleInfo person = new PeopleInfo(400 - (floor_count[opening_floor[j] - 1] * 30),
								600 - (dest_floor * 30), 50);

						person.setY(600 - (opening_floor[j] * 30));
						person.setDone(true);

						floor_count[opening_floor[j] - 1]++;
						allPeople.add(person);

					}
				}

				// normal의 R버튼을 누를 경우 이다.
				else if (i == 0) {
					NormalTime test_ = new NormalTime();
					destination = test_.get_destFloor();
					normal_floor = test_.get_presentFloor();

					for (int j = 0; j < 100; j++) {
						dest_floor = destination[j];
						if (floor_count[normal_floor[j] - 1] == 14) {
							floor_count[normal_floor[j] - 1] = 0;
						}
						PeopleInfo person = new PeopleInfo(400 - (floor_count[normal_floor[j] - 1] * 30),
								600 - (dest_floor * 30), 50);
						person.setY(600 - (normal_floor[j] * 30));
						person.setDone(true);

						floor_count[normal_floor[j] - 1]++;
						allPeople.add(person);
					}
				}

				// Closing 일 경우 R을 누른 경우
				else if (i == 2) {
					ClosingTime test_ = new ClosingTime();
					closing_floor = test_.get_presentFloor();
					destination = test_.get_destFloor();

					for (int j = 0; j < 100; j++) {
						dest_floor = destination[j];
						if (floor_count[closing_floor[j] - 1] == 14) {
							floor_count[closing_floor[j] - 1] = 0;
						}

						PeopleInfo person = new PeopleInfo(400 - (floor_count[closing_floor[j] - 1] * 30),
								600 - dest_floor * 30, 50);
						System.out.println(600 - dest_floor * 30);
						person.setY(600 - (closing_floor[j] * 30));
						person.setDone(true);

						floor_count[closing_floor[j] - 1]++;
						allPeople.add(person);
					}
				}
			}
		}
	}

	public void set_selectTime(int select) {
		this.select_time = select;
	}

	public int get_selectTime() {
		return select_time;
	}

	public static void main(String[] args) {
		new Main();
	}

	// Remote reservation system 리스너 부분이다.

	public class Mouse implements MouseListener {

		private int floor;

		public Mouse() {
			floor = 0;
		}

		public Mouse(int floor) {
			this.floor = floor;
		}

		public void mouseClicked(MouseEvent e) {
			input = new inputNumber(floor);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	// 리모콘 controller에 대한 Frame들!!!!
	public class inputNumber extends JFrame implements ActionListener {
		int a; // 현재층
		int a_; // 지상 층
		int a__; // 지하 층

		// 리모콘 작동시 목적지 층
		JLabel DestinationFloor = new JLabel();
		String Destination = "";

		public inputNumber(int x) {

			a = x + 1;
			a_ = x + 5;
			a__ = x + 6;

			setBounds(1120, 340, 370, 410); // ★리모콘 위치
			setResizable(false);

			JLabel image = new JLabel(new ImageIcon("remoteback.png"));
			image.setBounds(0, 0, 370, 410);
			image.setOpaque(false);

			Container contain = getContentPane();

			JPanel CnDPanel = new JPanel();
			JPanel ButtonPanelN = new JPanel(); // 11층 에서 20층
			JPanel ButtonPanelS = new JPanel(); // 1층에서 10층

			ButtonPanelN.setOpaque(false);
			ButtonPanelS.setOpaque(false);

			// border나 layout의 크기등을 나타낸다.
			JPanel CnDBorder = new JPanel();
			CnDBorder.setLayout(null);
			CnDBorder.setBounds(185, 10, 155, 240);

			JPanel CurrentPanel = new JPanel();
			CurrentPanel.setLayout(null);
			CurrentPanel.setBounds(15, 15, 125, 100);

			JPanel DestinationPanel = new JPanel();
			DestinationPanel.setLayout(null);
			DestinationPanel.setBorder(new TitledBorder(new LineBorder((Color.yellow), 5), "DEST_Floor"));
			DestinationPanel.setBounds(15, 130, 125, 100);

			CnDBorder.add(CurrentPanel);
			CnDBorder.add(DestinationPanel);

			// 현재층
			JLabel CurrentFloor = new JLabel();
			CurrentFloor.setText("" + (a));
			CurrentFloor.setHorizontalAlignment(JLabel.CENTER);
			CurrentFloor.setFont(new Font("Consolas", Font.BOLD, 30));
			CurrentFloor.setBounds(11, 8, 100, 100);

			// 현재 이미지 층뒤의 백 그라운드 이미지를 삽입한다.
			JLabel Currentimage = new JLabel(new ImageIcon("currentfloor2.png"));
			Currentimage.setHorizontalAlignment(JLabel.CENTER);
			Currentimage.setBounds(11, 8, 100, 100);

			// 목적지를 text로 받아와서 출력한다.
			DestinationFloor.setText(Destination);
			DestinationFloor.setHorizontalAlignment(JLabel.CENTER);
			DestinationFloor.setFont(new Font("Consolas", Font.BOLD, 30));
			DestinationFloor.setBounds(11, 8, 100, 100);

			CurrentPanel.add(CurrentFloor);
			CurrentPanel.add(Currentimage);
			DestinationPanel.add(DestinationFloor);

			// ENTER패널과 버튼
			JPanel EnterPanel = new JPanel();
			EnterPanel.setLayout(null);
			EnterPanel.setBounds(213, 255, 110, 80);
			JButton EnterButton = new JButton("ENTER", new ImageIcon("enter2.png"));

			EnterButton.setBorderPainted(false);
			EnterButton.setContentAreaFilled(false);
			EnterButton.setFocusPainted(false);

			EnterButton.addActionListener(this);
			EnterButton.setBounds(0, 0, 110, 80);
			EnterPanel.add(EnterButton);

			// 엘레베이터 버튼들
			JButton[] DestinationButton = new JButton[30];
			ButtonPanelN.setBounds(15, 20, 120, 150);
			ButtonPanelS.setBounds(15, 171, 120, 150);
			ButtonPanelN.setLayout(new GridLayout(5, 2));
			ButtonPanelS.setLayout(new GridLayout(5, 2));

			// 엘레베이터 버튼들의 BORDER부분
			JPanel ElevatorButton = new JPanel();
			ElevatorButton.setLayout(null);
			TitledBorder ElevatorBorder = new TitledBorder(new LineBorder(Color.black, 5));
			ElevatorBorder.setTitleColor(Color.red);

			ElevatorButton.setBorder(ElevatorBorder);
			ElevatorButton.setBounds(20, 10, 150, 330);

			// 버튼 이미지
			for (int i = 9; i >= 5; i--) {
				if (i == 0) {
					DestinationButton[i] = new JButton("" + (i - 4), new ImageIcon(i - 1 + ".PNG"));
				} else {
					DestinationButton[i] = new JButton("" + (i - 4), new ImageIcon(i - 4 + ".PNG"));
				}
				DestinationButton[i].setBorderPainted(false);
				DestinationButton[i].setContentAreaFilled(false);
				DestinationButton[i].setFocusPainted(false);

				DestinationButton[i].setSize(30, 20);
				if (i == a_) {
				} else
					DestinationButton[i].addActionListener(this);
				ButtonPanelN.add(DestinationButton[i]);

				DestinationButton[i + 10] = new JButton("" + ((i + 6)), new ImageIcon(i - 4 + 10 + ".PNG"));

				DestinationButton[i + 10].setBorderPainted(false);
				DestinationButton[i + 10].setContentAreaFilled(false);
				DestinationButton[i + 10].setFocusPainted(false);

				DestinationButton[i + 10].setSize(30, 20);

				if ((i + 10) == a_) {
				} else
					DestinationButton[i + 10].addActionListener(this);
				ButtonPanelN.add(DestinationButton[i + 10]);
			}
			for (int i = 4; i >= 0; i--) {
				DestinationButton[i] = new JButton("" + (i - 5), new ImageIcon(i - 5 + ".PNG"));
				DestinationButton[i].setBorderPainted(false);
				DestinationButton[i].setContentAreaFilled(false);
				DestinationButton[i].setFocusPainted(false);

				DestinationButton[i].setSize(30, 20);

				if (i == a__) {
				} else if (select_time == 2 && (i == 1 || i == 2) && (a == 0 || a == 1 || a == 2)) {
					DestinationButton[i].setBackground(Color.blue);
				} else
					DestinationButton[i].addActionListener(this);
				ButtonPanelS.add(DestinationButton[i]);

				DestinationButton[i + 10] = new JButton("" + ((i - 5) + 11), new ImageIcon(i - 4 + 10 + ".PNG"));

				DestinationButton[i + 10].setBorderPainted(false);
				DestinationButton[i + 10].setContentAreaFilled(false);
				DestinationButton[i + 10].setFocusPainted(false);
				DestinationButton[i + 10].setSize(30, 20);
				if ((i + 10) == a_) {
				} else
					DestinationButton[i + 10].addActionListener(this);
				ButtonPanelS.add(DestinationButton[i + 10]);
			}
			ElevatorButton.add(ButtonPanelN);
			ElevatorButton.add(ButtonPanelS);
			
			ElevatorButton.setOpaque(false);
			EnterPanel.setOpaque(false);
			CnDPanel.setOpaque(false);
			DestinationPanel.setOpaque(false);
			CurrentPanel.setOpaque(false);
			CurrentFloor.setOpaque(false);
			CnDBorder.setOpaque(false);

			contain.add(CnDBorder);

			contain.add(ElevatorButton);
			contain.add(EnterPanel);
			contain.add(CnDPanel);
			contain.add(image);

			repaint();

			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			for (int j = -5; j <= 15; j++) {
				if (j == 0)
					continue;
				else if (e.getActionCommand().equalsIgnoreCase("" + (j))) {
					Destination = "" + (j);
					DestinationFloor.setText(Destination);
				}
			}
		
			//enter를 누를 경우
			if (e.getActionCommand().equalsIgnoreCase("Enter")) {
				int dest = Integer.parseInt(Destination);
				int dest_floor = 0;

				if (dest >= 0) { // 지상
					dest_floor = 600 - ((dest) * 30) - 150;
				} else {
					switch (dest) {
					case -1:
						dest_floor = 450;
						break;

					case -2:
						dest_floor = 480;
						break;

					case -3:
						dest_floor = 510;
						break;

					case -4:
						dest_floor = 540;
						break;

					case -5:
						dest_floor = 570;
						break;
					}
				}

				if (floor_count[a__] == 14) { 
					floor_count[a__] = 0;
				}
				
				PeopleInfo person = new PeopleInfo(400 - (floor_count[a__] * 30), dest_floor, 50);

				if (a_ >= 5) {
					person.setY(600- (a_ + 1) * 30);
				} else {
					person.setY(600- (a__ + 1) * 30);
				}
				person.setDone(true);
				floor_count[a__]++;
				allPeople.add(person);
				setVisible(false);
				return;
			}
		}
	}
}
