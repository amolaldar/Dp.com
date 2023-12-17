package JavaPractice;

public class IndianTraffic implements CentralTraffic {

	@Override
	public void greenGo() {
		System.out.println("green");

	}

	@Override
	public void redStop() {
		System.out.println("red");

	}

	@Override
	public void yellowWait() {
		System.out.println("yellow");

	}

//CentralTraffic
	public static void main(String[] args) {
		IndianTraffic it = new IndianTraffic();
		it.greenGo();
		it.redStop();
		it.yellowWait();
	}

}
//1. Interface is like a class, methods without body only signature-- methods will implement in a class.
//2. Variable access modifier will be Public
//3. We need to do upcasting for creating a object of the class-- Implements word uses.
//4. More than 1 interfaces can be implemented to the class using comma seperated.
//5.
