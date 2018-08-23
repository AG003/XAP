package applicationMultithreading;

public class RunnerMultipleThread 
{
	public static void main(String[] args) 
	{
		ChromeLoginTest clt = new ChromeLoginTest();
		FirefoxLoginTest flt = new FirefoxLoginTest();
		Thread t1 = new Thread(clt);
		Thread t2 = new Thread(flt);
		t1.start();
		t2.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
	}

}
