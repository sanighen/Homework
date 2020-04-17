package main;

import java.util.Scanner;

import space.Asteroid;

public class CLIApplication {
	
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start/end dates");
		String start = in.next(), end = in.next();

		new Asteroid().getNeoAsteroids(start, end);

	}

}
