/**
 * Լɪ��ɱ�˷�
 */
public class MyJosephus {
    public static int N = 20;//����
    public static int M = 5;//������������

    class Node{
        int val;//�±�
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public void killNode() {
        Node header = new Node(1);//��һ���ڵ�
        Node x = header;//Ŀǰ���㵽����
        for (int i = 2; i <= N; i++) {//��ʼ������
            x = (x.next = new Node(i));
        }
        x.next = header;//ͷβ���
        System.out.println("�������˳��Ϊ��");
        while (x != x.next) {
            //���ٻ���������
            for (int i = 1; i < M; i++) {
                x = x.next;
            }
            System.out.println(x.next.val + "������");
            x.next = x.next.next;
        }
        System.out.println("�������˶���" + x.val);
    }

    public static void main(String[] args) {
        MyJosephus myJosephus = new MyJosephus();
        myJosephus.killNode();
    }
}
