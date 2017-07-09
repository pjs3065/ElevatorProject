public class NormalTime {
	// Normal time의 R 또는 I버튼을 누를 경우 100마리의 라바를 만들어 내며, 몸무게는 50, 지하 5층 부터 15층 사이의 랜덤한 라바가 등장하게 되며
	// 목적지 또한 자기 자신의 층을 제외한 나머지 층이 부여가된다. 
   private int[] weight = new int[100];
   private int[] dest_floor = new int[100];
   private int[] present_floor = new int[100];
   public NormalTime()
   {
      for(int i=0; i<100; i++) 
      {
         weight[i] = 50;
      }
    
      for(int i=0;i<100; i++) 
      {
         dest_floor[i] = 1 + (int)(Math.random()*20); // 지하 5층부터 15층까지
      }
      for(int i=0; i<100; i++) 
      {
         present_floor[i] = 1 + (int)(Math.random()*20); 
         while(present_floor[i] == dest_floor[i]){  //같은 경우 목적지가 +4 를 시켜서 같은층이 적용되지 않게 한다.
            present_floor[i] = 4+(int)(Math.random()*17);
            if(present_floor[i] != dest_floor[i])
               break;
         }
      }
     
   }
   
   //getter 함수들  
   public int[] getWeight(){
      return weight;
   }
   public int[] get_destFloor(){
      return dest_floor; 
   }
   public int[] get_presentFloor(){
      return present_floor;
   }
}