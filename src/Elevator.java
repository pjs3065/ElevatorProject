import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

//������������ x,y��ǥ��, ������������ �̹���, ���������Ͱ� �ö󰡴���?, ���������Ͱ� ����������? �������� �������(x,y)?�� �� �� �ִ� Ŭ�����̴�.

public class Elevator {
   
   private Toolkit tk;
   private Image img[] = new Image[3]; // ���� ���� ���� �ݿ��� ���� �� �������¸� ��Ÿ���ִ� �̹��� object array�̴�.
   
   ArrayList<PeopleInfo> ridingMan = new ArrayList<PeopleInfo>(); 
   ArrayList<PeopleInfo> goalfloor = new ArrayList<PeopleInfo>();

   
   // ������ position
   private int x = 0 ;
   private int y;
   
   // ������ position
   private int d_x;
   private int d_y;
   private boolean flag;

   // ���������Ͱ� ������ ���
   private boolean open;
   private boolean flag2=false;
   
   // ���������Ͱ� �ö� ���
   private boolean up=true;
   
   // ���������Ͱ� ������ ���
   private boolean down=false;
   private int TTL=300;
   private int TTLy;
   
   //�ִ� ������ limit
   private int limit=500;
 
   //���� ������
   private int currentweight=0;
   
   public void setTTL(int ttl){
      this.TTL = ttl;
   }
   public int getTTL(){
      return TTL;
   }
   
   //������ �������� get
   public ArrayList<PeopleInfo> getgoalfloor() {
      return ridingMan;
   }
   
   //������ �������� set
   public void setgoalfloor(ArrayList<PeopleInfo> goalfloor) {
      this.goalfloor = goalfloor;
   }
   public ArrayList<PeopleInfo> get_OnElev() { 
      return ridingMan;
   }
   public void set_OnElev(ArrayList<PeopleInfo> ridingMan) {
      this.ridingMan = ridingMan;
   }
   
   //���������Ͱ� ���ȴ� set
   public void set_open(boolean open)
   {
      this.open = open;
   }
   
   //���������Ͱ� ���ȴ��� get
   public boolean get_open()
   {
      return open;
   }
   public void set_Onflag(boolean flag){
      this.flag = flag;
   }
   public boolean get_Onflag(){
      return flag;
   }
   
   //�������� �޾ƿ´�.
   public int getD_y() { 
      return d_y;
   }
   
   //�������� �����Ѵ�.
   public void setD_y(int d_y) {
      this.d_y = d_y;
   }


   //���������͸� �������ִµ�, �������� x,y���� ������ �ְ�, ������������ �̹����� �������ش�.
   public Elevator(int destination_x, int destination_y){
      this.d_x = destination_x;
      this.d_y = destination_y;
      
      tk = Toolkit.getDefaultToolkit();
      img[0] = tk.createImage("������1.png"); //���� �ִ� ����
      img[1] = tk.createImage("������2.png"); //���� ���� ����
      img[2] = tk.createImage("������3.png"); //���� ���� ����
   }

   public Toolkit getTk() {
      return tk;
   }

   public void setTk(Toolkit tk) {
      this.tk = tk;
   }

   public Image getImg(int i) {
      return img[i];
   }

   public int getX() {
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }

   public int getY() {
      return y;
   }

   public void setY(int y) {
      this.y = y;
   }


   public int getD_x() {
      return d_x;
   }

   public void setD_x(int d_x) {
      this.d_x = d_x;
   }
   public boolean get_OffFlag() {
      return flag2;
   }
   public void set_OffFlag(boolean flag2) {
      this.flag2 = flag2;
   }
   
   //���� �ö󰡴��� get
   public boolean getUp() {
      return up;
   }
   //���� �ö󰡰� set
   public void setUp(boolean up) {
      this.up = up;
   }
   //�Ʒ��� ���������� get
   public boolean getDown() {
      return down;
   }
   //�Ʒ��� �������� set
   public void setDown(boolean down) {
      this.down = down;
   }
   public int getTTLy() {
      return TTLy;
   }
   public void setTTLy(int tTLy) {
      TTLy = tTLy;
   }
   public int getLimit() {
      return limit;
   }
   public void setLimit(int limit) { //setting limit weight.
   }
   public int getTotalWeight() {
      return currentweight;
   }
   public void setTotalWeight(int currentweight) {
      this.currentweight = currentweight;
   }
   
}