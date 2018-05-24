package greeter;

public class Application {
	
	public void welcome() {
		System.out.println("Hello World");
	}

	public static void main(String[] args) {
		Application a = new Application();
		a.welcome();

	}

}
