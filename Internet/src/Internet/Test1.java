package Internet;

public class Test1 {

	public static void main(String[] args) throws Exception {
		final DownLoadUtil util = new DownLoadUtil("http://localhost:8080/test/file/��ȱ���.rar", "./��ȱ���.rar", 3);
		util.downLoads();
		new Thread(){
			public void run() {
				while(util.getCompleteRate()<1){
					System.out.println("�Ѿ���ɣ�"+util.getCompleteRate()+"%");
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		}.start();
	}
}
