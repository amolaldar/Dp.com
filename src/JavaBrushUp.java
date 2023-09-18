import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaBrushUp {

	public static void main(String[] args) {
		int num = 10;
		String name = "Amol";
		double deci = 5.99;
		char letter = 'c';
		boolean myCard = true;

		System.out.println(num);
		int[] arr = new int[5];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		int[] arr2 = { 10, 20, 30, 40, 60 };
		System.out.println(arr2[4]);
		for (int number : arr) {
			if (number % 3 == 0) {
				System.out.println(number);
			}
		}
		ArrayList<String> a = new ArrayList<String>();
		a.add("A");
		String[] cities = { "Mum", "Pune", "Delhi" };
		List<String> city = Arrays.asList(cities);
	}

}
