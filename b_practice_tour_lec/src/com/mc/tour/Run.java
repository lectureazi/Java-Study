package com.mc.tour;

import com.mc.tour.presentation.MainMenu;
import com.mc.tour.service.Airline;
import com.mc.tour.service.Tour;
import com.mc.tour.service.Tourist;

public class Run {
	
	public static void main(String[] args) {
		
		Airline[] airlines = {new Airline("미국행", 3000, 300000), new Airline("중국행", 2000, 200000), new Airline("일본행", 1500, 150000)};
		Tourist tourist = new Tourist(1000000, 1000);
		Tour tour = new Tour(airlines, tourist);
		
		new MainMenu(tour, airlines, tourist).mainMenu();
		
	}

}
