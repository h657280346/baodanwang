package threadText;
public class Text2 {
	public static void main(String[] args) {
		Text2 t = new Text2();
		t.go();
	}
	V v = new V();
	private void go() {
		
	    new Thread(new Runnable() {
			@Override
			public void run() {
				int j = 1;
				for(int i=1;i<=5;i++){
					v.f1(j);
					j+=20;
				}	
			}
		}).start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				int j = 6;
				for(int i=1;i<=5;i++){
					v.f2(j);
					j+=20;
				}
			}
		}).start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				int j = 11;
				for(int i=1;i<=5;i++){
					v.f3(j);
					j+=20;
					
				}
				
			}
		}).start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
				int j = 16;
				for(int i=1;i<=5;i++){
					v.f4(j);
					j+=20;
					
				}
				
			}
		}).start();
	}
	class V{
		int a = 1;
	public synchronized  void f1(int j){
		while(a!=1){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.print(j+",");
			j++;
		}
		a = 2; 
		notifyAll();
	}
	public synchronized  void f2(int j){
		while(a!=2){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.print(j+",");
			j++;
		}
		a = 3;
		notifyAll();
	}
	public synchronized  void f3(int j){
		while(a!=3){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.print(j+",");
			j++;
		}
		a = 4;
		notifyAll();
	}
	public synchronized  void f4(int j){
		while(a!=4){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i=0;i<5;i++){
			System.out.print(j+",");
			j++;
		}
		a = 1;
		notifyAll();
	}
}
}
