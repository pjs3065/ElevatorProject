public class ClosingTime {
	
// Closing time의 R 또는 I버튼을 누를 경우 100마리의 라바를 만들어 내며, 몸무게는 50, 3층 ~ 15층 사이의 랜덤한 라바가 등장하게 되며
// 목적지는 지하 5층부터 1층까지 부여가된다.
	
   private int[] weight = new int[100];
   private int[] dest_floor = new int[100];
   private int[] present_floor = new int[100];

   public ClosingTime() {
      // 새로추가 ******
      for (int i = 0; i < 100; i++)
      {
         weight[i] = 50;
         present_floor[i] = 8 + (int) (Math.random() * 13); //현재층값을 넣어준다. 얘는 8층부터 시작 즉 상3층
      }

      for (int i = 0; i < 100; i++)
      {
         dest_floor[i] = 1 + (int) (Math.random() * 6); //목적지는 1층에서 6층까지로 지하 5층부터 상1층까지이다.
      }

      
   }

   //getter 함수들
   public int[] getWeight() {
      return weight;
   }

   public int[] get_destFloor() {
      return dest_floor;
   }

   public int[] get_presentFloor() {
      return present_floor;
   }
}