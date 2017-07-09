import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

//엘레베이터의 x,y좌표와, 엘레베이터의 이미지, 엘레베이터가 올라가는지?, 엘레베이터가 내려가는지? 목적지가 어디인지(x,y)?를 알 수 있는 클래스이다.

public class Elevator {
   
   private Toolkit tk;
   private Image img[] = new Image[3]; // 문이 닫힌 상태 반열린 상태 다 열린상태를 나타내주는 이미지 object array이다.
   
   ArrayList<PeopleInfo> ridingMan = new ArrayList<PeopleInfo>(); 
   ArrayList<PeopleInfo> goalfloor = new ArrayList<PeopleInfo>();

   
   // 현재의 position
   private int x = 0 ;
   private int y;
   
   // 목적지 position
   private int d_x;
   private int d_y;
   private boolean flag;

   // 엘레베이터가 열렸을 경우
   private boolean open;
   private boolean flag2=false;
   
   // 엘레베이터가 올라갈 경우
   private boolean up=true;
   
   // 엘레베이터가 내려갈 경우
   private boolean down=false;
   private int TTL=300;
   private int TTLy;
   
   //최대 몸무게 limit
   private int limit=500;
 
   //현재 몸무게
   private int currentweight=0;
   
   public void setTTL(int ttl){
      this.TTL = ttl;
   }
   public int getTTL(){
      return TTL;
   }
   
   //가야할 목적지를 get
   public ArrayList<PeopleInfo> getgoalfloor() {
      return ridingMan;
   }
   
   //가야할 목적지를 set
   public void setgoalfloor(ArrayList<PeopleInfo> goalfloor) {
      this.goalfloor = goalfloor;
   }
   public ArrayList<PeopleInfo> get_OnElev() { 
      return ridingMan;
   }
   public void set_OnElev(ArrayList<PeopleInfo> ridingMan) {
      this.ridingMan = ridingMan;
   }
   
   //엘레베이터가 열렸다 set
   public void set_open(boolean open)
   {
      this.open = open;
   }
   
   //엘레베이터가 열렸는지 get
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
   
   //목적지를 받아온다.
   public int getD_y() { 
      return d_y;
   }
   
   //목적지를 설정한다.
   public void setD_y(int d_y) {
      this.d_y = d_y;
   }


   //엘레베이터를 설정해주는데, 목적지의 x,y축을 설정해 주고, 엘레베이터의 이미지를 설정해준다.
   public Elevator(int destination_x, int destination_y){
      this.d_x = destination_x;
      this.d_y = destination_y;
      
      tk = Toolkit.getDefaultToolkit();
      img[0] = tk.createImage("통조림1.png"); //닫혀 있는 깡통
      img[1] = tk.createImage("통조림2.png"); //조금 열린 깡통
      img[2] = tk.createImage("통조림3.png"); //완전 열린 깡통
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
   
   //위로 올라가는지 get
   public boolean getUp() {
      return up;
   }
   //위로 올라가게 set
   public void setUp(boolean up) {
      this.up = up;
   }
   //아래로 내려가는지 get
   public boolean getDown() {
      return down;
   }
   //아래로 내려가게 set
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