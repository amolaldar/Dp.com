package JavaPractice;

public class New extends AbstractPrac {

	@Override
	public void a2() {
		System.out.println("a1 a2");

	}

	public static void main(String[] args) {
		New n = new New();
		n.a1();
		n.a2();
	}

}
