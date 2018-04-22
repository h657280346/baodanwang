package threadText;

public class Text4 {
    static int j = 0;
	public static void main(String[] args){
		String [] s = new String [16];
		System.out.println("begin:"+(System.currentTimeMillis()/1000));
		/*模拟处理16行日志，下面的代码产生了16个日志对象，当前代码需要运行16秒才能打印完这些日志。
		修改程序代码，开四个线程让这16个对象在4秒钟打完。
		*/
		for(int i=0;i<16;i++){  //这行代码不能改动
			final String log = ""+(i+1);//这行代码不能改动
			s[i] = log;
		}
			new Thread(new  Runnable() {
				public void run() {
					Text4.parseLog(s[0]);
					Text4.parseLog(s[1]);
					Text4.parseLog(s[2]);
					Text4.parseLog(s[3]);
				}
			}).start();

		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[4]);
				Text4.parseLog(s[5]);
				Text4.parseLog(s[6]);
				Text4.parseLog(s[7]);
			}
		}).start();
		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[8]);
				Text4.parseLog(s[9]);
				Text4.parseLog(s[10]);
				Text4.parseLog(s[11]);
			}
		}).start();
		new Thread(new  Runnable() {
			public void run() {
				Text4.parseLog(s[12]);
				Text4.parseLog(s[13]);
				Text4.parseLog(s[14]);
				Text4.parseLog(s[15]);
			}
		}).start();
	}
	
	//parseLog方法内部的代码不能改动
	public static void parseLog(String log){
		System.out.println(log+":"+(System.currentTimeMillis()/1000));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
}
