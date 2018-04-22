package threadText;
//������
/*
 * �ڴ���Test���в��ϵز������ݣ�����TestDo.doSome()��������
 * �������ǽ����������ڲ��ϵز������ݣ��������ڲ����������ݡ���
 * ������������10���߳������������߲��������ݣ���Щ�����߶���
 * ��TestDo.doSome()����ȥ���д�����ÿ�������߶���Ҫһ���
 * �ܴ����꣬����Ӧ��֤��Щ�������߳�����������������ݣ�ֻ����
 * һ�����������������һ�������߲����������ݣ���һ����������
 * ˭�����ԣ���Ҫ��֤��Щ�������߳��õ�����������˳��ġ�ԭʼ��
 * �����£�
 * 
 */
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Text3 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Semaphore s = new Semaphore(1);
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<10;i++){  //���в��ܸĶ�
			String input = i+"";  //���в��ܸĶ�
			String output = TestDo.doSome(input);
			list.add(output);
			System.out.println(Thread.currentThread().getName()+ ":" + output);
		}
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				
				public void run() {
					try {
						s.acquire();
						String output1 = TestDo.doSome(list.get(0));
						list.remove(0);
						System.out.println(Thread.currentThread().getName()+ ":" + output1);
						s.release();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}).start();
	
		}
	}
	
}


//���ܸĶ���TestDo��
class TestDo {
	public static String doSome(String input){
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String output = input + ":"+ (System.currentTimeMillis() / 1000);
		return output;
	}
}