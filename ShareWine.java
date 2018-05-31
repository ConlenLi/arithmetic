import java.util.HashMap;
import java.util.Map;

/**
 * ���ɷ־�
 *
 *
 */
public class ShareWine {
    static int b1 = 12;//��һ��ƿ�ӵ�����
    static int b2 = 8;//�ڶ���ƿ�ӵ�����
    static int b3 = 5;//������ƿ�ӵ�����
    static int  m = 13;//Ŀ������
    static Map<String,String> map = new HashMap<String, String>();
    public static void main(String[] args) {
        shareWine(12,0,0,map);
    }

    /**
     *
     * @param bl1 ��һ��ƿ�ӵ�ǰ����
     * @param bl2 �ڶ���ƿ�ӵ�ǰ����
     * @param bl3 ������ƿ�ӵ�ǰ����
     */
    private static void shareWine(int bl1, int bl2, int bl3, Map<String,String> map) {
        System.out.println("��ǰ���bl1:"+bl1+" bl2:"+bl2+" bl3:"+bl3);
        if (bl1 == m || bl2 == m || bl3 == m) {
            System.out.println("���bl1:"+bl1+" bl2:"+bl2+" bl3:"+bl3);
            return;
        }
        String key = String.valueOf(bl1) + String.valueOf(bl2) + String.valueOf(bl3);
        if (map.containsKey(key)) {
            System.out.println("�޷�����������Ѿ�������ѭ��");
            return;
        } else {
            map.put(key,"");
        }
        if (bl2 != 0 && bl3 != b3) {//�ڶ���ƿ���оƣ�������ƿ��δ��
            if (bl2 + bl3 <= b3) {//�ɽ��ڶ���ƿ�ӵľ�ȫ���������ƿ��
                shareWine(bl1,0,bl2 + bl3,map);
            } else {
                shareWine(bl1,bl2 - (b3 - bl3),b3,map);
            }
        } else if (bl3 == b3) {//ƿ��������
            if (bl1 + b3 <= b1) {//�ɽ�ƿ�����ľƶ�����ƿ��һ
                shareWine(bl1 + bl3,bl2,0,map);
            } else {
                shareWine(b1,bl2,bl3 - (b1 - bl1),map);
            }
        } else if (bl2 == 0) {//��ƿ��һ����ƿ�Ӷ�
            if (bl1 > b2) {
                shareWine(bl1 - b2,b2,bl3,map);
            } else {
                shareWine(0,bl2 + bl1,bl3,map);
            }
        }
    }
}
