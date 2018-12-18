package dao;

public interface QueryMapper {
	

	public static final String RETRIVE_ALL_QUERY="select * from ticket order by trainno";
	public static final String VIEW_DONAR_DETAILS_QUERY="select * from ticket where trainno=?";
	public static final String DETAILS_QUERY="insert into bookeddetail values(?,?,?,?,SYSDATE,pnr_seq.nextval)";
	public static final String INSERT_QUERY="insert into Ticket values(train_no.nextval,?,?,?,?,?)";
	public static final String DISPLAY_QUERY="Select * from Ticket order by trainno";
	public static final String DONARID_QUERY_SEQUENCE="SELECT donorId_sequence.CURRVAL FROM DUAL";
	public static final String BOOk_QUERY_SEQUENCE="Select * from bookeddetail order by pnr";
	
}
