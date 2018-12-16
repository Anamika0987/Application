package TicketBean;

public class Passenger {
	private String passengerName;
	private int age;
	private String mailId;
	private String phonenumber;
	private String source;
	private String destination;
	private int Pnr;
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPnr() {
		return Pnr;
	}
	public void setPnr(int pnr) {
		Pnr = pnr;
	}
	@Override
	public String toString() {
		return "Passenger [passengerName=" + passengerName + ", age=" + age + ", mailId=" + mailId + ", phonenumber="
				+ phonenumber + ", source=" + source + ", destination=" + destination + ", Pnr=" + Pnr + "]";
	}
	
}
