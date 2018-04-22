package threadText;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ����ĳ���ͬʱ������4���߳�ȥ����TestDo.doSome(key, value)������
 * ����TestDo.doSome(key, value)�����ڵĴ���������ͣ1�룬
 * Ȼ�����������Ϊ��λ�ĵ�ǰʱ��ֵ�����ԣ����ӡ��4����ͬ��ʱ��ֵ��������ʾ��
		4:4:1258199615
		1:1:1258199615
		3:3:1258199615
		1:2:1258199615
        ���޸Ĵ��룬����м����̵߳���TestDo.doSome(key, value)����ʱ��
        ���ݽ�ȥ��key��ȣ�equals�Ƚ�Ϊtrue�������⼸���߳�Ӧ�����Ŷ���������
        �����������̵߳�key����"1"ʱ�������е�һ��Ҫ�����������߳���1����������
        ������ʾ��
		4:4:1258199615
		1:1:1258199615
		3:3:1258199615
		1:2:1258199616
	  ��֮����ÿ���߳���ָ����key���ʱ����Щ���key���߳�Ӧÿ��һ���������ʱ��ֵ
	  ��Ҫ�û��⣩�����key��ͬ������ִ�У��໥֮�䲻���⣩��
	  ԭʼ�������£�

 * @author Administrator
 *
 */

//���ܸĶ���Test��	
public class Text5 extends Thread{
		
		private TestDo1 testDo;
		private String key;
		private String value;
		
		public Text5(String key,String key2,String value){
			this.testDo = TestDo1.getInstance();
			/*����"1"��"1"��ͬһ�������������д������Ҫ��"1"+""�ķ�ʽ�����µĶ���
			��ʵ������û�иı䣬��Ȼ��ȣ�����Ϊ"1"����������ȴ������ͬһ����Ч��*/
			this.key = key+key2; 
			/**
			 *   "1"+""   = "1"
			 *   "1"+""   = "1"
			 */
			this.value = value;
		}


		public static void main(String[] args) throws InterruptedException{
			Text5 a = new Text5("1","","1");
			Text5 b = new Text5("1","","2");
			Text5 c = new Text5("3","","3");
			Text5 d = new Text5("4","","4");
			System.out.println("begin:"+(System.currentTimeMillis()/1000));
			a.start();
			b.start();
			c.start();
			d.start();

		}
		
		public void run(){
			testDo.doSome(key, value);
		}
	}

	class TestDo1 {

		private TestDo1() {}
		private static TestDo1 _instance = new TestDo1();	
		public static TestDo1 getInstance() {
			return _instance;
		}
		private CopyOnWriteArrayList keys = new CopyOnWriteArrayList();
		public void doSome(Object key, String value) {
	
			Object o = key;
			if(!keys.contains(o)){
				keys.add(o);
			}else{

				for(Iterator iter=keys.iterator();iter.hasNext();){
//					try {
//						Thread.sleep(20);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					Object oo = iter.next();
					if(oo.equals(o)){
						o = oo;
						break;
					}
				}
			}
			synchronized(o)
{
				try {
					Thread.sleep(1000);
					System.out.println(key+":"+value + ":"
							+ (System.currentTimeMillis() / 1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


