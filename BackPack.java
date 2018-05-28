/**
 * �����㷨
 * // ����һ����������150kg
 // ��һ�����������кܶ���Ʒ����Ʒ�������ͼ�ֵ�ֱ�Ϊ��
 // 25kg--20
 // 30kg--40
 // 60kg--45
 // 35kg--50
 // 20kg--10
 // 50ke--45
 // 40ke--50
 */
public class BackPack {
    static int[] weight = {25, 30, 60, 35, 20, 50, 40};//����������
    static int[] values = {20, 40, 45, 50, 10, 45, 50};//��Ʒ�ļ�ֵ
    static int capacity = 150;//��������

    public static void main(String[] args) {
        backPack();
    }
    private static void backPack() {
        int size = values.length;//��Ʒ����
        double[] prices = new double[size];//��Ʒ���Լ۱�
        int[] tags = new int[size];
        for (int i = 0; i < size; i++) {
            prices[i] = (double) values[i]/weight[i];
            tags[i] = i;
        }
        //�Լ۱�ѡ������
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (prices[i] < prices[j]) {
                    double temp = prices[i];
                    prices[i] = prices[j];
                    prices[j] = temp;
                    int tag = tags[i];
                    tags[i] = tags[j];
                    tags[j] = tag;
                }
            }
        }
        // �����Ѿ��Ӵ�С�ź�����Լ۱ȣ������Ӧ�������ͼ�ֵ����ӵ�������
        int pick = 0;//�Ѿ�װ��������
        for (int i = 0; i < size; i++) {
            while (weight[tags[i]] < capacity) {
                System.out.println("���������Ϊ"+weight[tags[i]]+"����Ʒ");
                capacity -= weight[tags[i]];
            }
        }
    }
}
