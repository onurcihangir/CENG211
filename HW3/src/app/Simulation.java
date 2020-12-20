package app;

import java.util.ArrayList;

import cargo.EcommerceCargo;
import cargo.CargoLists;
import cargo.NormalCargo;

/**
 * Simulates app and prints what is requested.
 */
public class Simulation {

	private CargoLists cargoLists;
	
	public void run() {
		cargoLists = new CargoLists();
		ArrayList<NormalCargo> normal = cargoLists.getNormalCargoList();
		ArrayList<EcommerceCargo<?>> ecommerce = cargoLists.getEcommerceCargoList();
		
		System.out.println("Welcome!");
		// total accepted e-commerce cargos.
		int accepted = cargoLists.getAmazonAccepted()+cargoLists.getHepsiAccepted()+cargoLists.getHepsiAccepted()+cargoLists.getN11Accepted();
		System.out.println("Number of Accepted Cargo: " + accepted);
		// total non-accepted e-commerce cargos.
		int notAccepted = cargoLists.getAmazonNotAccepted()+cargoLists.getHepsiNotAccepted()+cargoLists.getN11NotAccepted()+cargoLists.getTrendyolNotAccepted();
		System.out.println("Number of Not Accepted Cargo: " + notAccepted);
		System.out.println("Here are the details:");
		System.out.println("Normal Cargo Packages:");
		System.out.printf("No%2c Cargo Code%5c Sender ID%8c Sender Name%5c Recipient Name%5c Recipient "
				+ "Address%15c Size%5c Price%5c Delivery Day\n", ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ');
		for(NormalCargo cargo : normal) {
			System.out.print(normal.indexOf(cargo)+1);
			System.out.printf("%4c%d%9c%2s%7c%-15s%2c%-20s%-27s%8c%d%7c%.2f%7c%s\n",' ',cargo.generateCargoCode(),' ',
					cargo.getSenderId(),' ',cargo.getSenderName(),' ',cargo.getRecipientName(),cargo.getRecipientAddress(),
					' ',cargo.calculateSize(),' ',cargo.calculatePrice(),' ', Days.getDeliveryDay());
		}
		System.out.println();
		System.out.println("E-commerce Cargo Packages:");
		System.out.printf("No%3c E-commerce Site%4c Cargo Code%5c Status%5c Size%5c Delivery Day\n",' ',' ',' ',' ',' ');
		for(EcommerceCargo<?> cargo : ecommerce) {
			System.out.print(ecommerce.indexOf(cargo) + 1);
			System.out.printf("%5c%-16s%4c%-15s%1c%-8s%4c%-5s%11s\n",' ',cargo.getSiteName(),' ',cargo.getCargoCode(),' ',
					cargo.getStatus(),' ',cargo.calculateSize(),Days.getDeliveryDay());
		}
	}
}
