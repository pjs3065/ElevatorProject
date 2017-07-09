public class OpeningTime {
   // Opening Time time의 R 또는 I버튼을 누를 경우 100마리의 라바를 만들어 내며, 몸무게는 50, 지하 5층 부터 1층 사이의 랜덤한 라바가 등장하게 되며
   // 목적지 또한 자기 자신의 층을 제외한 나머지 층이 부여가된다.
   // Opening Time이므로 1층에 더 많은 인원이 등장하게 된다.
	
   private int[] weight = new int[100];
   private int[] dest_floor = new int[100];
   private int[] present_floor = new int[100];
   public OpeningTime()
   {
      for(int i=0; i<100; i++)
      {
         weight[i] = 50;
         present_floor[i] = 1;
         
         if(i % 2 == 0) // 1층에 더 많은 인원을 등장시키기 위함
         {
        	 present_floor[i] = 6;
         }
         
         else
        	 present_floor[i] = 1 + (int)(Math.random()*6);
      }
      for(int i=0;i<100; i++){
         dest_floor[i] = 6 + (int)(Math.random() * 15);
         while(present_floor[i] == dest_floor[i]){
            dest_floor[i] = 6 + (int)(Math.random() * 15);
             if(present_floor[i] != dest_floor[i])
                break;
         }
      }
   }
   
   //getter 함수들  
   public int[] getWeight(){
      return weight;
   }
   public int[] get_presentFloor(){
      return present_floor;
   }
   public int[] get_destFloor(){
	   return dest_floor;
   }
}