import java.awt.Image;
import java.awt.Toolkit;

//�� ������� ������ ��Ÿ����. ��ġ, ���� ����, �켱����, ��� Ÿ�� �ִ���, ��ٸ�����? �׸��� �̵��ϴ°͵� �̹����� �̿��ؼ� �̵��ϰ� �ȴ�.
public class PeopleInfo {
   public static int cnt = 0;
   
   private int p_id;
   private Toolkit tk;
   
   //������ ����� ���߰� ������ ���� �ϴ� �̹����̴�.
   private Image img[] = new Image[3]; 
   private Image img2[] = new Image[3];
   private Image img3[] = new Image[3];
  
   //���� ����� ��ġ
   private int x = 0 ; 
   private int y ;
   
   //������ �ϴ� ��ġ
   private int d_x;
   private int d_y;
   
   //���۽ð��� ���ð�
   private long starttime=0;
   private long endtime=0;
   
   //���� Ż�� �ִ� priority
   private int priority;
   private boolean done;
   
   //Ÿ�� �ִ��� ���ȴ��� ��ٸ�����
   private boolean offriding = false;
   private boolean riding = false; 
   private boolean isWait = false;
   
   //������ �⺻�� 50
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
      img[0] = tk.createImage("������1.png");
      img[1] = tk.createImage("������2.png");
      img[2] = tk.createImage("������3.png");
      
      img2[0] = tk.createImage("�������1.png");
      img2[1] = tk.createImage("�������2.png");
      img2[2] = tk.createImage("�������3.png");
      
      img3[0] = tk.createImage("�������1.png");
      img3[1] = tk.createImage("�������2.png");
      img3[2] = tk.createImage("�������3.png");
      
      
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