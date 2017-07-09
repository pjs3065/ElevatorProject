public class OpeningTime {
   // Opening Time time�� R �Ǵ� I��ư�� ���� ��� 100������ ��ٸ� ����� ����, �����Դ� 50, ���� 5�� ���� 1�� ������ ������ ��ٰ� �����ϰ� �Ǹ�
   // ������ ���� �ڱ� �ڽ��� ���� ������ ������ ���� �ο����ȴ�.
   // Opening Time�̹Ƿ� 1���� �� ���� �ο��� �����ϰ� �ȴ�.
	
   private int[] weight = new int[100];
   private int[] dest_floor = new int[100];
   private int[] present_floor = new int[100];
   public OpeningTime()
   {
      for(int i=0; i<100; i++)
      {
         weight[i] = 50;
         present_floor[i] = 1;
         
         if(i % 2 == 0) // 1���� �� ���� �ο��� �����Ű�� ����
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
   
   //getter �Լ���  
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