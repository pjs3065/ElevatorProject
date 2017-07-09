import java.awt.Image;
import java.awt.Toolkit;

//각 사람들의 정보를 나타낸다. 위치, 어디로 갈지, 우선순위, 어디에 타고 있는지, 기다리는지? 그리고 이동하는것도 이미지를 이용해서 이동하게 된다.
public class PeopleInfo {
   public static int cnt = 0;
   
   private int p_id;
   private Toolkit tk;
   
   //세명의 사람이 멈추고 앞으로 가고 하는 이미지이다.
   private Image img[] = new Image[3]; 
   private Image img2[] = new Image[3];
   private Image img3[] = new Image[3];
  
   //현재 사람의 위치
   private int x = 0 ; 
   private int y ;
   
   //가고자 하는 위치
   private int d_x;
   private int d_y;
   
   //시작시간과 끝시간
   private long starttime=0;
   private long endtime=0;
   
   //먼저 탈수 있는 priority
   private int priority;
   private boolean done;
   
   //타고 있는지 내렸는지 기다리는지
   private boolean offriding = false;
   private boolean riding = false; 
   private boolean isWait = false;
   
   //몸무게 기본값 50
   private int weight=50;
   
   public void setDone(boolean a){
      this.done = a;
   }
   public boolean getDone(){
      return done;
   }
   public void setPri(int pri){
      this.priority=pri;
   }
   public int getPri(){ 
      return priority;
   }
   public int getD_y() {
      return d_y;
   }
   public void setD_y(int d_y) {
      this.d_y = d_y;
   }


   public PeopleInfo(int destination_x, int destination_y, int weight){
      this.d_x = destination_x;
      this.d_y = destination_y;
      this.weight=weight;
      tk = Toolkit.getDefaultToolkit();
      img[0] = tk.createImage("노란라바1.png");
      img[1] = tk.createImage("노란라바2.png");
      img[2] = tk.createImage("노란라바3.png");
      
      img2[0] = tk.createImage("검은라바1.png");
      img2[1] = tk.createImage("검은라바2.png");
      img2[2] = tk.createImage("검은라바3.png");
      
      img3[0] = tk.createImage("빨간라바1.png");
      img3[1] = tk.createImage("빨간라바2.png");
      img3[2] = tk.createImage("빨간라바3.png");
      
      
      this.p_id = cnt++;
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
   
   public Image getImg2(int i) {
      return img2[i];
   }
   
   public Image getImg3(int i){
      return img3[i];
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
   public int getP_id() {
      return p_id;
   }
   public void setP_id(int p_id) {
      this.p_id = p_id;
   }
   public boolean isWait() {
      return isWait;
   }
   public void setWait(boolean isWait) {
      this.isWait = isWait;
   }
   public boolean get_OutPeople() {
      return offriding;
   }
   public void set_OutPeople(boolean offriding) {
      this.offriding = offriding;
   }
   public boolean get_OnPeople() {
      return riding;
   }
   public void set_OnPeople(boolean riding) {
      this.riding = riding;
   }
   public int getWeight() {
      return weight;
   }
   public void setWeight(int weight) {
      this.weight = weight;
   }
   public long getStarttime() {
       return starttime;
   }
   public void setStarttime(long starttime) {
      this.starttime = starttime;
   }
   public long getEndtime() {
      return endtime;
   }
   public void setEndtime(long endtime) {
      this.endtime = endtime;
   }
   
}