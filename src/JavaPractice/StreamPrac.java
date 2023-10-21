package JavaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

public class StreamPrac {

	public static void main(String[] args) {
		StreamPrac sp= new StreamPrac();
//		sp.m1();
//		sp.m2();
		sp.m3();

	}
	//@Test
	public void m1() {
		List<String> names= new ArrayList<String>();
		names.add("Amol");
		names.add("Sneha");
		names.add("Aldar");
		names.add("Walekar");
		int count=0;
		for(int i=0;i<names.size();i++) {
			if(names.get(i).startsWith("A")) {
				count++;
				System.out.println(names.get(i));
			}
		}
		System.out.println(count);
		
	}
	public void m2() {
		List<String> names= new ArrayList<String>();
		names.add("Amol");
		names.add("Sneha");
		names.add("Aldar");
		names.add("Walekar");
		
		long d=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(d);
		names.stream().filter(s->s.startsWith("S")).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>=5).forEach(s->System.out.println(s));
	}
	public void m3() {
		String[] names= {"Amol","Popat","Aldar","Sneha","Ajit"};
		List<String> name=Arrays.asList(names);
		name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
	}

}
