/**
 * �˻ʺ����⣨���ݷ���
 */
public class Empress {
    public static int num = 0;//�ۼƷ���
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];//����˻ʺ��λ��

    public static void getCount(int n) {
        boolean[] rows = new boolean[MAXQUEEN];//��¼ÿ��ÿ��λ���Ƿ���ԷŻʺ�
        for (int i = 0; i < n; i++) {
            rows[cols[i]] = true;//ͬһ�в��ܷ�
            int d = n - i;//б�ԽǵĲ�ֵ
            //��б
            if (cols[i] - d >= 0) {
                rows[cols[i] - d] = true;//���е���бλ������Ϊtrue
            }
            //��б
            if (cols[i] + d < MAXQUEEN) {
                rows[cols[i] + d] = true;
            }
        }
        for (int i = 0; i < MAXQUEEN; i++) {
            if (!rows[i]) {//�ܷ�
                cols[n] = i;
                if (n < MAXQUEEN - 1) {
                    getCount(n + 1);
                } else {
                    //�ҵ�һ�������ķ���
                    num++;
                    printQueen();
                }
            }
        }
    }

    private static void printQueen() {
        System.out.println("��" + num + "�׷���");
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == cols[j]) {
                    System.out.print("0 ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getCount(0);
    }
}