package TicketBean;

public class BookTicket {
	private String trainNumber;
	private String trainName;
	private int price;
	private int pnr;
	public String getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(String trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	@Override
	public String toString() {
		return "BookTicket [trainNumber=" + trainNumber + ", trainName=" + trainName + ", price=" + price + ", pnr="
				+ pnr + "]";
	}
	
}
