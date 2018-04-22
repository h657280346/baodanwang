package threadText;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Text1 {
	public void go() throws IOException {
		final Print pt = new Print();
		Thread one = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pt.printA();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread two = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pt.printB();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread three = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pt.printC();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		Thread four = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					try {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						pt.printD();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		one.start();
		two.start();
		three.start();
		four.start();
	}

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream p1 = new PrintStream(new File("./A.txt"));
		PrintStream p2 = new PrintStream(new File("./B.txt"));
		PrintStream p3 = new PrintStream(new File("./C.txt"));
		PrintStream p4 = new PrintStream(new File("./D.txt"));
		p1.print("");
		p2.print("");
		p3.print("");
		p4.print("");
		try {
			new Text1().go();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Print {
		int number = 1;
		Lock lock = new ReentrantLock();
		Condition c1 = lock.newCondition();
		Condition c2 = lock.newCondition();
		Condition c3 = lock.newCondition();
		Condition c4 = lock.newCondition();

		public void printA() throws IOException {
			
			Writer w1 = new FileWriter("./A.txt",true);
			Writer w2 = new FileWriter("./B.txt",true);
			Writer w3 = new FileWriter("./C.txt",true);
			Writer w4 = new FileWriter("./D.txt",true);
			lock.lock();
			try {
				while (number != 1 && number % 4 != 1) {
					try {
						c1.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (number == 1) {
					System.out.println("a");
					w1.write("1");
				} else {
					System.out.println("a");
					w1.write("1");
					w2.write("1");
					w3.write("1");
					w4.write("1");
				}
				w2.flush();
				w1.flush();
				w3.flush();
				w4.flush();
				w1.close();
				w2.close();
				w3.close();
				w4.close();
				number++;
				c2.signal();
			} finally {
				lock.unlock();
			}
		}

		public void printB() throws IOException {
		
			Writer w1 = new FileWriter("./A.txt",true);
			Writer w2 = new FileWriter("./B.txt",true);
			Writer w3 = new FileWriter("./C.txt",true);
			Writer w4 = new FileWriter("./D.txt",true);
			lock.lock();
		
			try {
				while (number != 2 && number % 4 != 2) {
					try {
						c2.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (number == 2) {
					System.out.println("b");
					w1.write("2");
					w2.write("2");
				} else {
					System.out.println("b");
					w1.write("2");
					w2.write("2");
					w3.write("2");
					w4.write("2");
				}
				w2.flush();
				w1.flush();
				w3.flush();
				w4.flush();
				w1.close();
				w2.close();
				w3.close();
				w4.close();
				number++;
				c3.signal();
			} finally {
				lock.unlock();
			}
		}

		public void printC() throws IOException {
			
			Writer w1 = new FileWriter("./A.txt",true);
			Writer w2 = new FileWriter("./B.txt",true);
			Writer w3 = new FileWriter("./C.txt",true);
			Writer w4 = new FileWriter("./D.txt",true);
			lock.lock();
			try {
				while (number != 3 && number % 4 != 3) {
					try {
						c3.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (number == 3) {
					System.out.println("c");
					w1.write("3");
					w2.write("3");
					w3.write("3");
				} else {
					System.out.println("c");
					w1.write("3");
					w2.write("3");
					w3.write("3");
					w4.write("3");
				}
				w2.flush();
				w1.flush();
				w3.flush();
				w4.flush();
				w1.close();
				w2.close();
				w3.close();
				w4.close();
				number++;
				c4.signal();
			} finally {
				lock.unlock();
			}
		}

		public void printD() throws IOException {
			
			Writer w1 = new FileWriter("./A.txt",true);
			Writer w2 = new FileWriter("./B.txt",true);
			Writer w3 = new FileWriter("./C.txt",true);
			Writer w4 = new FileWriter("./D.txt",true);
			lock.lock();
			try {
				while (number != 4 && number % 4 != 0) {
					try {
						c4.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("d");
				w1.write("4");
				w2.write("4");
				w3.write("4");
				w4.write("4");
				w2.flush();
				w1.flush();
				w3.flush();
				w4.flush();
				w1.close();
				w2.close();
				w3.close();
				w4.close();
				number++;
				c1.signal();
			} finally {
				lock.unlock();
			}
		}
	}
}

