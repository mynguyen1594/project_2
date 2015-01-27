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
		
		void getParkedInfo (ParkedCar parkedCar) {
			System.out.printf("License Number: " + parkedCar.getLisenceNumber() + "\n");
			System.out.printf("Maker: " + parkedCar.getMaker() +
					"\t Model: " + parkedCar.getModel() + "\t Color: " + parkedCar.getColor() + " \n");
		}
		
		double calculateFine(ParkedCar parkedCar, ParkingMeter parkingMeter) {
			double parkedFine = 0;
			double violatedTime = parkedCar.getParkedTime() - parkingMeter.getPurchasedTime();
			double hrs = violatedTime/60;
			double min = violatedTime % 60;
			
			if (hrs <= 1) {
				parkedFine = 25;
			}
			else if (hrs > 1 && min > 0){
				hrs -= 1;
				parkedFine = 25 + hrs*10;
			}
			
			return parkedFine;
		}
		
		void getPoliceInfo(PoliceOfficer policeOfficer) {
			System.out.printf("Police Officer: " + policeOfficer.getName() +
					"\nBadge Number: " + policeOfficer.getBadgeNumber() + " \n");
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
				parkingTicket.getParkedInfo(parkedCar);
				System.out.printf("Parked Time: " + parkedCar.getParkedTime() +
							"\t\t Purchased Time: " + parkingMeter.getPurchasedTime() + " \n");
				
				System.out.printf("Fine Amount: $%1.2f \n", parkingTicket.calculateFine(parkedCar, parkingMeter));
				parkingTicket.getPoliceInfo(policeOfficer);
			}
			else {
				System.out.printf("Ticket is not issued \n");
			}
		}
	}

	public static void main(String[] args) {
		ParkedCar parkedCar = new ParkedCar("Lamborghini", "Aventador LP 700-4", "Black", "nDebt", 145);
		ParkingMeter parkingMeter = new ParkingMeter(24);
		PoliceOfficer policeOfficer = new PoliceOfficer("Howard A. Pollman", 8441);
		ParkingTicket parkingTicket = new ParkingTicket();
		
		policeOfficer.issueTicket(parkedCar, parkingMeter, parkingTicket, policeOfficer);
	}

}
