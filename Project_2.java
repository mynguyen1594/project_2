package project_2;
//import java.util.*;

public class Project_2 {
	
	// ************************************
	// ParkedCar class
	// ************************************
	public static class ParkedCar {
		String maker;
		String model;
		String color;
		String lisenceNumber;
		int parkedTime;

		ParkedCar() {}

		ParkedCar(String Maker, String Model, String Color, String LisenceNum, int ParkedTime) {
			maker = Maker;
			model = Model;
			color = Color;
			lisenceNumber = LisenceNum;
			parkedTime = ParkedTime;
		}

		public String getMaker() {
			return maker;
		}

		public void setMaker(String maker) {
			this.maker = maker;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getLisenceNumber() {
			return lisenceNumber;
		}

		public void setLisenceNumber(String lisenceNumber) {
			this.lisenceNumber = lisenceNumber;
		}

		public int getParkedTime() {
			return parkedTime;
		}

		public void setParkedTime(int parkedTime) {
			this.parkedTime = parkedTime;
		}
	}

	// ************************************
	// ParkingMeter class
	// ************************************
	public static class ParkingMeter {
		int purchasedTime;

		ParkingMeter() {}

		ParkingMeter(int minutes) {
			purchasedTime = minutes;
		}

		public int getPurchasedTime() {
			return purchasedTime;
		}

		public void setPurchasedTime(int purchasedTime) {
			this.purchasedTime = purchasedTime;
		}
	}

	// ************************************
	// ParkingTicket class
	// ************************************
	public static class ParkingTicket {
		ParkingTicket() {}
		
		ParkedCar getParkedInfo (ParkedCar parkedCar) {
//			parkedCar.getMaker();
//			parkedCar.getColor();
//			parkedCar.getModel();
//			parkedCar.getLisenceNumber();
//			
			return parkedCar;
		}
		
		double calculateFine(int min) {
			double parkedFine = 0;
			double hrs = min/60;
			
			if (hrs <= 1) {
				parkedFine = 25;
			}
			else {
				hrs -= 1;
				parkedFine = 25 + hrs*10;
			}
			
			return parkedFine;
		}
		
		PoliceOfficer getPoliceInfo(PoliceOfficer policeOfficer) {
			policeOfficer.getName();
			policeOfficer.getBadgeNumber();
			
			return policeOfficer;
		}
	}

	// ************************************
	// PoliceOfficer
	// ************************************
	public static class PoliceOfficer {
		String name;
		int badgeNumber;

		PoliceOfficer() {}

		PoliceOfficer(String Name, int BadgeNum) {
			name = Name;
			badgeNumber = BadgeNum;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getBadgeNumber() {
			return badgeNumber;
		}

		public void setBadgeNumber(int badgeNumber) {
			this.badgeNumber = badgeNumber;
		}
		
		boolean expired(ParkedCar parkedCar, ParkingMeter parkingMeter) {
			boolean expired = false;
			
			// If the parked time is over the purchased time
			if (parkedCar.getParkedTime() > parkingMeter.getPurchasedTime()) {
				expired = true;
			}
			else {
				expired = false;
			}
		
			return expired;
		}
		
		void issueTicket (ParkedCar parkedCar,ParkingMeter parkingMeter, ParkingTicket parkingTicket, PoliceOfficer policeOfficer) {
			if (policeOfficer.expired(parkedCar, parkingMeter) == true) { 
				System.out.printf("\t\t\t PARKING VIOLATION \n");
				System.out.printf("License Number: " + parkingTicket.getParkedInfo(parkedCar).getLisenceNumber() + "\n");
				System.out.printf("Maker: " + parkingTicket.getParkedInfo(parkedCar).getMaker() +
							"\t Model: " + parkingTicket.getParkedInfo(parkedCar).getModel() +
							"\t Model: " + parkingTicket.getParkedInfo(parkedCar).getColor() + " \n");
				System.out.printf("Parked Time: " + parkingTicket.getParkedInfo(parkedCar).getParkedTime() +
							"\t\t Purchased Time: " + parkingMeter.getPurchasedTime() + " \n");
				System.out.printf("Fine Amount: " + parkingTicket.calculateFine(61) + " \n");
				System.out.printf("Police Officer: " + parkingTicket.getPoliceInfo(policeOfficer).getName() +
							" Badge Number: " + parkingTicket.getPoliceInfo(policeOfficer).getBadgeNumber() + " \n");
			}
			else {
				System.out.printf("Ticket is not issued \n");
			}
		}

	}

	public static void main(String[] args) {
		ParkedCar parkedCar = new ParkedCar("Lamborghini", "Aventador LP 700-4", "Black", "nDebt", 45);
		ParkingMeter parkingMeter = new ParkingMeter(40);
		PoliceOfficer policeOfficer = new PoliceOfficer("Howard A. Pollman", 8441);
		ParkingTicket parkingTicket = new ParkingTicket();
		
		policeOfficer.issueTicket(parkedCar, parkingMeter, parkingTicket, policeOfficer);
		

	}

}
