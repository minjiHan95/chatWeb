package user;

public class User {

	String userId;
	 String userPassword;
	 String userName;
	 String userGender;
	 String userEmail;

	public User(String userId, String userPassword, String userName, String userGender, String userEmail) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userGender = userGender;
		this.userEmail = userEmail;
	}


	public String getUserId() {
		return userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public String getUserEmail() {
		return userEmail;
	}

}
