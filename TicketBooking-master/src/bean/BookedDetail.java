
package bean;

import java.util.Date;

public class BookedDetail
{
	private String trainNo;
	private String passangername;
	private int age;
	private String phonenumber;
	private Date bookdate;
	private int pnr;
	
	public int getPnr() {
		return pnr;
	}
	public void setPnr(int pnr) {
		this.pnr = pnr;
	}
	public String getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}
	public String getPassangername() {
		return passangername;
	}
	public void setPassangername(String passangername) {
		this.passangername = passangername;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public Date getBookdate() {
		return bookdate;
	}
	public void setBookdate(Date bookdate) {
		this.bookdate = bookdate;
	}
	
	@Override
	public String toString() {
		return "BookedDetail [trainNo=" + trainNo + ", passangername=" + passangername + ", age=" + age
				+ ", phonenumber=" + phonenumber + ", bookdate=" + bookdate + ", pnr=" + pnr + "]";
	}
	
	
	
	
	
	
}
