package com.gmail.voscob;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TempMain {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		List<String> list = new ArrayList<>();
		list.add("moto g dual sim");
		list.add("women's snow boots");
		list.add("candy crush saga on facebook");
		list.add("already a member of netflix");
		list.add("windows live movie maker");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("==");
			System.out.println("Strat query: " + list.get(i));
			System.out.println("==");
			new Query(list.get(i));
		}
	}
}
