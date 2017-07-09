import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

// 모든 class의 thread를 관리를 해주며, 엘레베이터의 움직임, 사람의 움직임, waiting의 수, boarding의 수, 엘레베이터의 위치, 초기값을 관리해준다.
public class MainThread extends Thread {

	Main frm;

	ArrayList<PeopleInfo> allPeople;
	ArrayList<Elevator> allEle;
	ArrayList<PeopleInfo> People_queue = new ArrayList<PeopleInfo>();

	// 각 층의 정보들을 저장한다.
	ArrayList<PeopleInfo> floor1 = new ArrayList<PeopleInfo>();//
	ArrayList<PeopleInfo> floor2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor4 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor5 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor6 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor7 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor8 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor9 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor10 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor11 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor12 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor13 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor14 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor15 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor16 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor17 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor18 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor19 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> floor20 = new ArrayList<PeopleInfo>();

	// 사람들이 내리고 타고하는 것을 저장
	ArrayList<PeopleInfo> onBoard = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> outBoard = new ArrayList<PeopleInfo>();

	ArrayList<PeopleInfo> onBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> outBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> onBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> outBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> onBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> outBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> onBoard4 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> outBoard4 = new ArrayList<PeopleInfo>();

	ArrayList<PeopleInfo> OpenOnBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOutBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOnBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOutBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOnBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOutBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOnBoard4 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> OpenOutBoard4 = new ArrayList<PeopleInfo>();

	ArrayList<PeopleInfo> CloseOnBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOutBoard1 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOnBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOutBoard2 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOnBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOutBoard3 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOnBoard4 = new ArrayList<PeopleInfo>();
	ArrayList<PeopleInfo> CloseOutBoard4 = new ArrayList<PeopleInfo>();

	JPanel jp;

	// 처음에 들어갈 엘레베이터들의 초기 max값과 min값
	int Nmax, Nmax1 = 570, Nmax2 = 570, Nmax3 = 570, Nmax4 = 570;
	int Nmin, Nmin1 = 0, Nmin2 = 0, Nmin3 = 0, Nmin4 = 0;
	int Omax, Omax1 = 570, Omax2 = 570, Omax3 = 570, Omax4 = 570;
	int Omin, Omin1 = 0, Omin2 = 0, Omin3 = 0, Omin4 = 0;
	int Cmax, Cmax1 = 270, Cmax2 = 150, Cmax3 = 0, Cmax4 = 570;
	int Cmin, Cmin1 = 0, Cmin2 = 0, Cmin3 = 0, Cmin4 = 0;

	// 층을 분석해서 해당층에 대한 정보를 return 해준다.
	public ArrayList<PeopleInfo> getFloor(int floor) {
		if (floor == 1)
			return floor1;
		else if (floor == 2)
			return floor2;
		else if (floor == 3)
			return floor3;
		else if (floor == 4)
			return floor4;
		else if (floor == 5)
			return floor5;
		else if (floor == 6)
			return floor6;
		else if (floor == 7)
			return floor7;
		else if (floor == 8)
			return floor8;
		else if (floor == 9)
			return floor9;
		else if (floor == 10)
			return floor10;
		else if (floor == 11)
			return floor11;
		else if (floor == 12)
			return floor12;
		else if (floor == 13)
			return floor13;
		else if (floor == 14)
			return floor14;
		else if (floor == 15)
			return floor15;
		else if (floor == 16)
			return floor16;
		else if (floor == 17)
			return floor17;
		else if (floor == 18)
			return floor18;
		else if (floor == 19)
			return floor19;
		else if (floor == 20)
			return floor20;
		return null;
	}

	public MainThread(Main frm, ArrayList<PeopleInfo> allPeople, ArrayList<Elevator> allele, JPanel jp) {
		this.allPeople = allPeople;
		this.allEle = allele;
		this.jp = jp;
		this.frm = frm;
	}

	// NORMAL TIME일 경우
	public void NormalElevator(int ElevNum, ArrayList On, ArrayList Out, int m, int n) {

		Elevator elevator = allEle.get(ElevNum);
		onBoard = On;
		outBoard = Out;
		Nmax = m;
		Nmin = n;

		for (int i = 0; i < elevator.get_OnElev().size(); i++) {
			PeopleInfo tmpMan = elevator.get_OnElev().get(i);
			if (i == 0) {
				Nmax = tmpMan.getD_y();
			}
			if (Nmax > tmpMan.getD_y()) {
				Nmax = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (Nmax == 570 && i == 0) {
				Nmax = tmpMan.getY();
			}
			if (Nmax > tmpMan.getY()) {
				Nmax = tmpMan.getY();
			}
		}

		for (int i = 0; i < elevator.get_OnElev().size(); i++) {
			PeopleInfo tmpMan = elevator.get_OnElev().get(i);
			if (i == 0)
				Nmin = tmpMan.getD_y();
			if (Nmin < tmpMan.getD_y()) {
				Nmin = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (Nmin == 0 && i == 0) {
				Nmin = tmpMan.getY();
			}
			if (Nmin < tmpMan.getY()) {
				Nmin = tmpMan.getY();
			}
		}

		// NORMAL 인데 올라갈 경우
		if (elevator.getUp()) {

			if (Nmax != 570) {
				elevator.setD_y(Nmax);
			}
			int currEleFloor = (600 - elevator.getY()) / 30;

			if ((600 - elevator.getY()) % 30 == 0) {
				ArrayList<PeopleInfo> waitingList = getFloor(currEleFloor);

				for (int i = 0; i < waitingList.size(); i++) {
					PeopleInfo tmpMan = waitingList.get(i);

					// 몸무게와 현재 위치 파악후 태운다.
					if ((tmpMan.getD_y() < elevator.getY()) && tmpMan.get_OnPeople() == false
							&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
						tmpMan.set_OnPeople(true);
						elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());
						if (ElevNum == 0)
							tmpMan.setD_x(400 + 35);
						else if (ElevNum == 1)
							tmpMan.setD_x(400 + 85);
						else if (ElevNum == 2)
							tmpMan.setD_x(400 + 135);
						else if (ElevNum == 3)
							tmpMan.setD_x(400 + 185);
						elevator.set_Onflag(true);
						elevator.set_open(true);
						waitingList.remove(tmpMan);
						elevator.get_OnElev().add(tmpMan);
						onBoard.add(tmpMan);
					}
				}
				// 타고나서 내릴경우
				for (int i = 0; i < elevator.get_OnElev().size(); i++) {
					PeopleInfo tmpMan = elevator.get_OnElev().get(i);

					if ((tmpMan.getD_y() == elevator.getY()) && tmpMan.get_OutPeople() == false) {
						tmpMan.set_OutPeople(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator.getY());
						elevator.set_open(true);
						elevator.set_OffFlag(true);
						allPeople.add(tmpMan);
						outBoard.add(tmpMan);
					}
				}

				// 타고 내리는 시간을 재준다.
				PeopleInfo tmpMan2;
				int c1 = 0;
				int c2 = 0;
				for (int i = 0; i < onBoard.size(); i++) {
					tmpMan2 = onBoard.get(i);
					// 엘레베이터 1번
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 435) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
						// 엘레베이터 2번
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 485) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
						// 엘레베이터 3번
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 535) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}

						// 엘레베이터 4번
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 585) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					}
				}
				if (c1 == onBoard.size() && c1 != 0) {
					elevator.set_Onflag(false);
					elevator.set_open(false);
					onBoard.removeAll(onBoard);
				}
				// 여기까지 사람들이 타는 과정

				// 엘레베이터가 올라가면서 사람들이 내리는 경우
				for (int i = 0; i < outBoard.size(); i++) {
					tmpMan2 = outBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 500) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 550) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 600) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 650) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					}
				}
				if (c2 == outBoard.size() && c2 != 0) {
					elevator.set_OffFlag(false);
					elevator.set_open(false);
					outBoard.removeAll(outBoard);
				}
				if (elevator.get_Onflag() || elevator.get_OffFlag()) {
					return;
				}
			}
		}

		// 엘레베이터가 내려갈때 타는 과정
		if (elevator.getDown()) {
			if (Nmin != 0)
				elevator.setD_y(Nmin);
			int currEleFloor = (600 - elevator.getY()) / 30;

			if ((600 - elevator.getY()) % 30 == 0) {
				ArrayList<PeopleInfo> waitingList = getFloor(currEleFloor);

				// 기다리는 사람이 있을 경우
				for (int i = 0; i < waitingList.size(); i++) {
					PeopleInfo tmpMan = waitingList.get(i);

					if ((tmpMan.getD_y() > elevator.getY()) && tmpMan.get_OnPeople() == false
							&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
						tmpMan.set_OnPeople(true);
						elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());
						if (ElevNum == 0)
							tmpMan.setD_x(400 + 35);
						else if (ElevNum == 1)
							tmpMan.setD_x(400 + 85);
						else if (ElevNum == 2)
							tmpMan.setD_x(400 + 135);
						else if (ElevNum == 3)
							tmpMan.setD_x(400 + 185);
						elevator.set_Onflag(true);
						elevator.set_open(true);
						waitingList.remove(tmpMan);
						elevator.get_OnElev().add(tmpMan);
						onBoard.add(tmpMan);
					}
				}
				for (int i = 0; i < elevator.get_OnElev().size(); i++) {
					PeopleInfo tmpMan = elevator.get_OnElev().get(i);

					if ((tmpMan.getD_y() == elevator.getY()) && tmpMan.get_OutPeople() == false) {
						tmpMan.set_OutPeople(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator.getY());
						elevator.set_open(true);
						elevator.set_OffFlag(true);
						allPeople.add(tmpMan);
						outBoard.add(tmpMan);
					}
				}
				PeopleInfo tmpMan2;
				int c1 = 0;
				int c2 = 0;
				for (int i = 0; i < onBoard.size(); i++) {
					tmpMan2 = onBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 435) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 485) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 535) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 585) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					}
				}

				if (c1 == onBoard.size() && c1 != 0) {

					elevator.set_Onflag(false);
					elevator.set_open(false);
					onBoard.removeAll(onBoard);
				}

				// 내려갈때 내리는 과정
				for (int i = 0; i < outBoard.size(); i++) {
					// moves again after all people get out
					tmpMan2 = outBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 500) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 550) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 600) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 650) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					}
				}
				if (c2 == outBoard.size() && c2 != 0) {
					elevator.set_OffFlag(false);
					elevator.set_open(false);
					outBoard.removeAll(outBoard);
				}
				if (elevator.get_Onflag() || elevator.get_OffFlag()) {
					// jp.repaint();
					return;
				}
			}
		}

		for (int i = 0; i < allPeople.size(); i++) {
			PeopleInfo tmpMan = allPeople.get(i);
			if (tmpMan.getX() >= 920)
				allPeople.remove(tmpMan);
		}

		// 모두가 내렸을 경우
		if (People_queue.size() == 0 && elevator.get_OnElev().size() == 0) {
			Nmin = Nmax = elevator.getY();
			elevator.setUp(true);
			elevator.setDown(true);

			elevator.setD_y(elevator.getTTLy());
			if (elevator.getY() > elevator.getD_y()) {
				elevator.setY(elevator.getY() - 2);
			}
			if ((elevator.getY() < elevator.getD_y())) {
				elevator.setY(elevator.getY() + 2);
			}

		} else {
			if (elevator.getY() <= Nmax && elevator.getUp()) {
				elevator.setDown(true);
				elevator.setUp(false);
			} else if (elevator.getY() >= Nmin && elevator.getDown()) {
				elevator.setDown(false);
				elevator.setUp(true);
			}
			if (elevator.getUp()) {
				if ((elevator.getY() > elevator.getD_y())) {
					elevator.setY(elevator.getY() - 2);
				}
			}
			if (elevator.getDown()) {
				if ((elevator.getY() < elevator.getD_y())) {
					elevator.setY(elevator.getY() + 2);
				}
			}
		}
	}
	// 여기까지 NORMAL TIME

	// Opening time 일 경우
	public void OpeningElevator(int ElevNum, ArrayList On, ArrayList Out, int m, int n) {

		Elevator elevator = allEle.get(ElevNum);
		onBoard = On;
		outBoard = Out;
		Omax = m;
		Omin = n;

		for (int i = 0; i < elevator.get_OnElev().size(); i++) {
			PeopleInfo tmpMan = elevator.get_OnElev().get(i);
			if (i == 0) {
				Omax = tmpMan.getD_y();
			}
			if (Omax > tmpMan.getD_y()) {
				Omax = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (Omax == 570 && i == 0) {
				Omax = tmpMan.getY();
			}
			if (Omax > tmpMan.getY()) {
				Omax = tmpMan.getY();
			}
		}

		for (int i = 0; i < elevator.get_OnElev().size(); i++) {
			PeopleInfo tmpMan = elevator.get_OnElev().get(i);
			if (i == 0)
				Omin = tmpMan.getD_y();
			if (Omin < tmpMan.getD_y()) {
				Omin = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (Omin == 0 && i == 0) {
				Omin = tmpMan.getY();
			}
			if (Omin < tmpMan.getY()) {
				Omin = tmpMan.getY();
			}
		}

		// Opening이고, 엘레베이터가 올라갈 경우
		if (elevator.getUp()) {
			elevator.setD_y(Omax);

			int currEleFloor = (600 - elevator.getY()) / 30;

			if ((600 - elevator.getY()) % 30 == 0) {
				ArrayList<PeopleInfo> waitingList = getFloor(currEleFloor);

				for (int i = 0; i < waitingList.size(); i++) {
					PeopleInfo tmpMan = waitingList.get(i);

					if (ElevNum == 0) {
						// 짝수층만 운행이며 목적지가 1층을 넘어야 한다.
						if (((tmpMan.getD_y() / 30) % 2 == 0 && tmpMan.getD_y() < 450) && tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());

							tmpMan.setD_x(400 + 35);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					} else if (ElevNum == 1) {
						// 홀수층만 운행이며 목적지가 1층을 넘어야 한다.
						if (((tmpMan.getD_y() / 30) % 2 == 1 && tmpMan.getD_y() < 450) && tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());

							tmpMan.setD_x(400 + 85);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					} else if (ElevNum == 2) {
						// 지하층을 운행한다.
						if ((tmpMan.getD_y() >= 0 && tmpMan.getD_y() < 420) && tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());
							tmpMan.setD_x(400 + 135);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					}
					// 마지막 엘레베이터는 전층이므로 NORMAL TIME의 엘레베이터를 대체해서 사용한다.
				}

				for (int i = 0; i < elevator.get_OnElev().size(); i++) {

					PeopleInfo tmpMan = elevator.get_OnElev().get(i);

					if ((tmpMan.getD_y() == elevator.getY()) && tmpMan.get_OutPeople() == false) {
						tmpMan.set_OutPeople(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator.getY());
						elevator.set_open(true);
						elevator.set_OffFlag(true);
						allPeople.add(tmpMan);
						outBoard.add(tmpMan);
					}
				}
				PeopleInfo tmpMan2;
				int c1 = 0;
				int c2 = 0;
				for (int i = 0; i < onBoard.size(); i++) {
					tmpMan2 = onBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 435) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 485) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 535) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 585) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					}
				}
				if (c1 == onBoard.size() && c1 != 0) {
					elevator.set_Onflag(false);
					elevator.set_open(false);
					onBoard.removeAll(onBoard);
				}

				// 엘레베이터가 내려가면 내리는 경우
				for (int i = 0; i < outBoard.size(); i++) {
					tmpMan2 = outBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 500) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 550) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 600) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 650) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					}
				}
				if (c2 == outBoard.size() && c2 != 0) {
					elevator.set_OffFlag(false);
					elevator.set_open(false);
					outBoard.removeAll(outBoard);
				}
				if (elevator.get_Onflag() || elevator.get_OffFlag()) {
					return;
				}
			}
		}

		// Opening 일 경우 모두 내릴 경우
		if (People_queue.size() == 0 && elevator.get_OnElev().size() == 0) {
			Nmin = Nmax = elevator.getY();
			elevator.setUp(true);
			elevator.setDown(true);

			if (ElevNum == 0 || ElevNum == 1)
				elevator.setD_y(420);
			else
				elevator.setD_y(570);
			if (elevator.getY() > elevator.getD_y()) {
				elevator.setY(elevator.getY() - 2);
			}
			if ((elevator.getY() < elevator.getD_y())) {
				elevator.setY(elevator.getY() + 2);
			}
		}
		if (ElevNum == 2) {
			if (elevator.getY() == Omax && elevator.getY() != 570) {
				elevator.setD_y(570);
				elevator.setDown(true);
				elevator.setUp(false);
			} else if (elevator.getY() == 570) {
				elevator.setUp(true);
				elevator.setDown(false);
			}
		}

		else {
			if (elevator.getY() == Omax && elevator.getY() != 420) {
				elevator.setD_y(420);
				elevator.setDown(true);
				elevator.setUp(false);
			} else if (elevator.getY() == 420) {
				elevator.setUp(true);
				elevator.setDown(false);
			}
		}

		if (elevator.getUp()) {
			if ((elevator.getY() > elevator.getD_y())) {
				elevator.setY(elevator.getY() - 2);
			}
		}
		if (elevator.getDown()) {
			if (elevator.getY() < elevator.getD_y()) {
				elevator.setY(elevator.getY() + 2);
			}
		}

	}
	// 여기까지 Opening time

	// Closing time일경우
	public void ClosingElevator(int ElevNum, ArrayList On, ArrayList Out, int m, int n) {

		Elevator elevator = allEle.get(ElevNum);

		onBoard = On;
		outBoard = Out;
		Cmax = m;
		Cmin = n;
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (ElevNum == 0 && (tmpMan.getY() >= 270 && tmpMan.getY() <= 540)) {
				if (Cmax == 270 && i == 0) {
					Cmax = tmpMan.getY();
				}
				if (Cmax > tmpMan.getY()) {
					Cmax = tmpMan.getY();
				}
			} else if (ElevNum == 1 && (tmpMan.getY() >= 150 && tmpMan.getY() <= 330)) {
				if (Cmax == 150 && i == 0) {
					Cmax = tmpMan.getY();
				}
				if (Cmax > tmpMan.getY()) {
					Cmax = tmpMan.getY();
				}
			} else if (ElevNum == 2 && (tmpMan.getY() >= 0 && tmpMan.getY() <= 210)) {
				if (Cmax == 0 && i == 0) {
					Cmax = tmpMan.getY();
				}
				if (Cmax > tmpMan.getY()) {
					Cmax = tmpMan.getY();
				}
			}

		}

		for (int i = 0; i < elevator.get_OnElev().size(); i++) {
			PeopleInfo tmpMan = elevator.get_OnElev().get(i);
			if (i == 0)
				Cmin = tmpMan.getD_y();
			if (Cmin < tmpMan.getD_y()) {
				Cmin = tmpMan.getD_y();
			}
		}
		for (int i = 0; i < People_queue.size(); i++) {
			PeopleInfo tmpMan = People_queue.get(i);
			if (ElevNum == 0 && (tmpMan.getY() >= 270 && tmpMan.getY() <= 540)) {

				if (Cmin == 0 && i == 0) {
					Cmin = tmpMan.getY();
				}
				if (Cmin < tmpMan.getY()) {
					Cmin = tmpMan.getY();
				}
			} else if (ElevNum == 1 && (tmpMan.getY() >= 150 && tmpMan.getY() <= 330)) {

				if (Cmin == 0 && i == 0) {
					Cmin = tmpMan.getY();
				}
				if (Cmin < tmpMan.getY()) {
					Cmin = tmpMan.getY();
				}

			} else if (ElevNum == 2 && (tmpMan.getY() >= 0 && tmpMan.getY() <= 210)) {

				if (Cmin == 0 && i == 0) {
					Cmin = tmpMan.getY();
				}
				if (Cmin < tmpMan.getY()) {
					Cmin = tmpMan.getY();
				}

			}
		}

		// Closing일 경우 올라갈 때
		if (elevator.getUp()) {
			elevator.setD_y(Cmax);
		}
		// 내려갈때
		if (elevator.getDown()) {

			elevator.setD_y(Cmin);

			int currEleFloor = (600 - elevator.getY()) / 30;

			// 엘레베이터가 멈추는 구간
			if ((600 - elevator.getY()) % 30 == 0) {
				ArrayList<PeopleInfo> waitingList = getFloor(currEleFloor);

				// 사람들이 타고 있는 사이즈
				for (int i = 0; i < waitingList.size(); i++) {
					PeopleInfo tmpMan = waitingList.get(i);

					// Closing일경우 첫번째 엘레베이터는 6층까지 운행가능
					if (ElevNum == 0 && (currEleFloor >= 2 && currEleFloor <= 11)) {

						if (tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());

							tmpMan.setD_x(400 + 35);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					}
					// Closing일경우 두번째 엘레베이터의 경우 4층부터 11층까지 운행가능
					else if (ElevNum == 1 && currEleFloor >= 9 && currEleFloor <= 15) {
						if (tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());

							tmpMan.setD_x(400 + 85);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					}
					// Closing일경우 세번째 엘레베이터의 경우 8층부터 15층까지 운행가능
					else if (ElevNum == 2 && currEleFloor >= 13 && currEleFloor <= 20) {
						if (tmpMan.get_OnPeople() == false
								&& ((tmpMan.getWeight() + elevator.getTotalWeight()) <= elevator.getLimit())) {
							tmpMan.set_OnPeople(true);
							elevator.setTotalWeight(tmpMan.getWeight() + elevator.getTotalWeight());

							tmpMan.setD_x(400 + 135);

							elevator.set_Onflag(true);
							elevator.set_open(true);
							waitingList.remove(tmpMan);
							elevator.get_OnElev().add(tmpMan);
							onBoard.add(tmpMan);
						}
					}

					// 마지막 엘레베이터는 전층이기 때문에 NORMALTIME 엘레베이터로 대체합니다.
				}
				for (int i = 0; i < elevator.get_OnElev().size(); i++) {
					PeopleInfo tmpMan = elevator.get_OnElev().get(i);
					if ((tmpMan.getD_y() == elevator.getY()) && tmpMan.get_OutPeople() == false) {
						tmpMan.set_OutPeople(true);
						tmpMan.setD_x(920);
						tmpMan.setY(elevator.getY());
						elevator.set_open(true);
						elevator.set_OffFlag(true);
						allPeople.add(tmpMan);
						outBoard.add(tmpMan);
					}
				}
				PeopleInfo tmpMan2;
				int c1 = 0;
				int c2 = 0;
				for (int i = 0; i < onBoard.size(); i++) {
					tmpMan2 = onBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 435) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 485) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 535) {
							++c1;
							if (tmpMan2.getEndtime() == 0) {
								tmpMan2.setEndtime(System.currentTimeMillis());
								frm.set_time(frm.get_time() + (tmpMan2.getEndtime() - tmpMan2.getStarttime()));
								frm.setPeople_queue(frm.getPeople_queue() + 1);
							}
							People_queue.remove(tmpMan2);
							allPeople.remove(tmpMan2);
						}
					}
				}
				if (c1 == onBoard.size() && c1 != 0) {

					elevator.set_Onflag(false);
					elevator.set_open(false);
					onBoard.removeAll(onBoard);
				}

				// Closing일경우 엘레베이터가 내려갈 경우 내릴 경우
				for (int i = 0; i < outBoard.size(); i++) {
					tmpMan2 = outBoard.get(i);
					if (ElevNum == 0) {
						if (tmpMan2.getX() >= 500) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 1) {
						if (tmpMan2.getX() >= 550) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 2) {
						if (tmpMan2.getX() >= 600) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					} else if (ElevNum == 3) {
						if (tmpMan2.getX() >= 650) {
							++c2;
							elevator.setTotalWeight(elevator.getTotalWeight() - tmpMan2.getWeight());
							elevator.get_OnElev().remove(tmpMan2);
						}
					}
				}
				if (c2 == outBoard.size() && c2 != 0) {
					elevator.set_OffFlag(false);
					elevator.set_open(false);
					outBoard.removeAll(outBoard);
				}
				if (elevator.get_Onflag() || elevator.get_OffFlag()) {
					return;
				}
			}
		}

		if (elevator.getY() <= Cmax) {
			elevator.setDown(true);
			elevator.setUp(false);
		} else if (elevator.getY() >= Cmin) {
			elevator.setUp(true);
			elevator.setDown(false);
		}
		if (People_queue.size() == 0 && elevator.get_OnElev().size() == 0) {
			elevator.setUp(true);
			if (ElevNum == 0)
				elevator.setD_y(270);
			else if (ElevNum == 1)
				elevator.setD_y(150);
			else if (ElevNum == 2)
				elevator.setD_y(0);
		}
		if (elevator.getUp()) {
			if ((elevator.getY() > elevator.getD_y())) {
				elevator.setY(elevator.getY() - 2);
			}
		}
		if (elevator.getDown()) {
			if (elevator.getY() < elevator.getD_y()) {
				elevator.setY(elevator.getY() + 2);
			}
		}
	}

	public void run() {
		while (true) {
			try {
				// 스레드의 스피드
				Thread.sleep(20);

				// 모든 사람들의 FLOOR를 관리해준다.
				for (int i = 0; i < allPeople.size(); i++) {
					PeopleInfo tmpMan = allPeople.get(i);
					if (tmpMan.getX() < tmpMan.getD_x()) {
						tmpMan.setX(tmpMan.getX() + 4);
					}
					if ((tmpMan.getX() >= tmpMan.getD_x()) && (tmpMan.isWait() == false)) {
						People_queue.add(tmpMan);
						if ((600 - tmpMan.getY()) / 30 == 1)
							floor1.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 2)
							floor2.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 3)
							floor3.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 4)
							floor4.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 5)
							floor5.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 6)
							floor6.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 7)
							floor7.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 8)
							floor8.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 9)
							floor9.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 10)
							floor10.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 11)
							floor11.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 12)
							floor12.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 13)
							floor13.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 14)
							floor14.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 15)
							floor15.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 16)
							floor16.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 17)
							floor17.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 18)
							floor18.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 19)
							floor19.add(tmpMan);
						else if ((600 - tmpMan.getY()) / 30 == 20)
							floor20.add(tmpMan);

						tmpMan.setWait(true);
					}
				}
				if (People_queue.size() != 0) {
					// 현재 기다리고 있는 사람을 스케쥴링해준다.(15번째 사람일 경우 겹쳐지게 보이게 된다.(앞으로 이동))
					for (int i = 1; i <= 20; i++) {
						ArrayList<PeopleInfo> waitingList = getFloor(i);
						for (int j = 0; j < waitingList.size(); j++) {
							PeopleInfo tmpMan = waitingList.get(j);
							if (j == 0 && tmpMan.getX() != 400)
								tmpMan.setD_x(400);
							else if (j == 1 && tmpMan.getX() != 370)
								tmpMan.setD_x(370);
							else if (j == 2 && tmpMan.getX() != 340)
								tmpMan.setD_x(340);
							else if (j == 3 && tmpMan.getX() != 310)
								tmpMan.setD_x(310);
							else if (j == 4 && tmpMan.getX() != 280)
								tmpMan.setD_x(280);
							else if (j == 5 && tmpMan.getX() != 250)
								tmpMan.setD_x(250);
							else if (j == 6 && tmpMan.getX() != 220)
								tmpMan.setD_x(220);
							else if (j == 7 && tmpMan.getX() != 190)
								tmpMan.setD_x(190);
							else if (j == 8 && tmpMan.getX() != 160)
								tmpMan.setD_x(160);
							else if (j == 9 && tmpMan.getX() != 130)
								tmpMan.setD_x(130);
							else if (j == 10 && tmpMan.getX() != 100)
								tmpMan.setD_x(100);
							else if (j == 11 && tmpMan.getX() != 70)
								tmpMan.setD_x(70);
							else if (j == 12 && tmpMan.getX() != 40)
								tmpMan.setD_x(40);
							else if (j == 13 && tmpMan.getX() != 10)
								tmpMan.setD_x(10);
						}
					}
				}

				// 선택에 따라서 초기값과 엘레베이터의 상황이 설정된다.
				if (frm.get_selectTime() == 1) {
					NormalElevator(0, onBoard1, outBoard1, Nmax1, Nmin1);
					NormalElevator(1, onBoard2, outBoard2, Nmax2, Nmin2);
					NormalElevator(2, onBoard3, outBoard3, Nmax3, Nmin3);
					NormalElevator(3, onBoard4, outBoard4, Nmax4, Nmin4);
				} else if (frm.get_selectTime() == 2) {
					OpeningElevator(0, OpenOnBoard1, OpenOutBoard1, Omax1, Omin1);
					OpeningElevator(1, OpenOnBoard2, OpenOutBoard2, Omax2, Omin2);
					OpeningElevator(2, OpenOnBoard3, OpenOutBoard3, Omax3, Omin3);
					NormalElevator(3, OpenOnBoard4, OpenOutBoard4, Omax4, Omin4);
				} else if (frm.get_selectTime() == 3) {
					ClosingElevator(0, CloseOnBoard1, CloseOutBoard1, Cmax1, Cmin1);
					ClosingElevator(1, CloseOnBoard2, CloseOutBoard2, Cmax2, Cmin1);
					ClosingElevator(2, CloseOnBoard3, CloseOutBoard3, Cmax3, Cmin1);
					NormalElevator(3, CloseOnBoard4, CloseOutBoard4, Cmax4, Cmin4);
				}

				// 평균 시간을 구할 때 사용한다.
				for (int i = 0; i < People_queue.size(); i++) {
					PeopleInfo tmpMan = People_queue.get(i);
					if (tmpMan.getStarttime() == 0)
						tmpMan.setStarttime(System.currentTimeMillis());
				}

				if (frm.getPeople_queue() != 0)
		               frm.set_avgTime((frm.get_time() / 1000) / frm.getPeople_queue());
		            frm.set_avgTime(Long.toString(frm.get_avgTime()));
		            frm.set_WaitNum(Integer.toString(People_queue.size()));
		            for (int i = 0; i < allEle.size(); i++) {
		               Elevator tmpElevator = allEle.get(i);
		               if (i == 0) {
		                  frm.set_OnBoardP1(Integer.toString(tmpElevator.get_OnElev().size()));
		                  frm.set_ElevWeight1(Integer.toString(tmpElevator.getTotalWeight()));
		               } else if (i == 1) {
		                  frm.set_OnBoardP2(Integer.toString(tmpElevator.get_OnElev().size()));
		                  frm.set_ElevWeight2(Integer.toString(tmpElevator.getTotalWeight()));
		               } else if (i == 2) {
		                  frm.set_OnBoardP3(Integer.toString(tmpElevator.get_OnElev().size()));
		                  frm.set_ElevWeight3(Integer.toString(tmpElevator.getTotalWeight()));
		               } else if (i == 3) {
		                  frm.set_OnBoardP4(Integer.toString(tmpElevator.get_OnElev().size()));
		                  frm.set_ElevWeight4(Integer.toString(tmpElevator.getTotalWeight()));
		               }
		            }
				jp.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}