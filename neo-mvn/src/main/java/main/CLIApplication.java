package main;

import java.util.Scanner;

import astro.Asteroid;
import astro.NasaDataProvider;

public class CLIApplication {
	
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter start/end dates");
		String start = in.next(), end = in.next();

		new NasaDataProvider().getNeoAsteroids(start, end);

	}

}
