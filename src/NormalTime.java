public class NormalTime {
	// Normal time�� R �Ǵ� I��ư�� ���� ��� 100������ ��ٸ� ����� ����, �����Դ� 50, ���� 5�� ���� 15�� ������ ������ ��ٰ� �����ϰ� �Ǹ�
	// ������ ���� �ڱ� �ڽ��� ���� ������ ������ ���� �ο����ȴ�. 
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
         dest_floor[i] = 1 + (int)(Math.random()*20); // ���� 5������ 15������
      }
      for(int i=0; i<100; i++) 
      {
         present_floor[i] = 1 + (int)(Math.random()*20); 
         while(present_floor[i] == dest_floor[i]){  //���� ��� �������� +4 �� ���Ѽ� �������� ������� �ʰ� �Ѵ�.
            present_floor[i] = 4+(int)(Math.random()*17);
            if(present_floor[i] != dest_floor[i])
               break;
         }
      }
     
   }
   
   //getter �Լ���  
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