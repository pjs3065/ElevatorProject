public class ClosingTime {
	
// Closing time�� R �Ǵ� I��ư�� ���� ��� 100������ ��ٸ� ����� ����, �����Դ� 50, 3�� ~ 15�� ������ ������ ��ٰ� �����ϰ� �Ǹ�
// �������� ���� 5������ 1������ �ο����ȴ�.
	
   private int[] weight = new int[100];
   private int[] dest_floor = new int[100];
   private int[] present_floor = new int[100];

   public ClosingTime() {
      // �����߰� ******
      for (int i = 0; i < 100; i++)
      {
         weight[i] = 50;
         present_floor[i] = 8 + (int) (Math.random() * 13); //���������� �־��ش�. ��� 8������ ���� �� ��3��
      }

      for (int i = 0; i < 100; i++)
      {
         dest_floor[i] = 1 + (int) (Math.random() * 6); //�������� 1������ 6�������� ���� 5������ ��1�������̴�.
      }

      
   }

   //getter �Լ���
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