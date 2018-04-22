package threadText;
//第三题
/*
 * 在代码Test类中不断地产生数据，交给TestDo.doSome()方法处理，
 * 类似我们讲的生产者在不断地产生数据，消费者在不断消费数据。请
 * 将程序改造成有10个线程来消费生成者产生的数据，这些消费者都调
 * 用TestDo.doSome()方法去进行处理，故每个消费者都需要一秒才
 * 能处理完，程序应保证这些消费者线程依次有序地消费数据，只有上
 * 一个消费者消费完后，下一个消费者才能消费数据，下一个消费者是
 * 谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。原始代
 * 码如下：
 * 
 */
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Text3 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		Semaphore s = new Semaphore(1);
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		for(int i=0;i<10;i++){  //这行不能改动
			String input = i+"";  //这行不能改动
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


//不能改动此TestDo类
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