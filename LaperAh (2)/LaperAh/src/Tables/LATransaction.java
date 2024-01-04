package Tables;

public class LATransaction {
	private Integer TransactionID;
	private String CustomerName;
	private Integer RestaurantID;
	private String ReservationType;
	private Integer BookedSeats;
	private String BranchID;
	private Integer EmployeeID;
	private int BookedTables;
	private String Status;
	
	public Integer getTransactionID() {
		return TransactionID;
	}
	
	public void setTransactionID(Integer transactionID) {
		TransactionID = transactionID;
	}
	
	public Integer getRestaurantID() {
		return RestaurantID;
	}
	
	public void setRestaurantID(Integer restaurantID) {
		RestaurantID = restaurantID;
	}
	
	public String getReservationType() {
		return ReservationType;
	}
	
	public void setReservationType(String reservationType) {
		ReservationType = reservationType;
	}
	
	public Integer getBookedSeats() {
		return BookedSeats;
	}
	
	public void setBookedSeats(Integer bookedSeats) {
		BookedSeats = bookedSeats;
	}
	
	public String getBranchID() {
		return BranchID;
	}
	
	public void setBranchID(String branchID) {
		BranchID = branchID;
	}
	
	public Integer getEmployeeID() {
		return EmployeeID;
	}
	
	public void setEmployeeID(Integer employeeID) {
		EmployeeID = employeeID;
	}
	
	public String getStatus() {
		return Status;
	}
	
	public void setStatus(String string) {
		Status = string;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public int getBookedTables() {
		return BookedTables;
	}

	public void setBookedTables(int bookedTables) {
		BookedTables = bookedTables;
	}
	
}