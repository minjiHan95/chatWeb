package board;

public class Board {

	int boardId;
	String b_Title;
	String userId;
	String b_Date;
	String b_Content;
	int b_Available;
	

	public Board(String b_Title, String userId, String b_Content, int b_Available) {
		this.b_Title = b_Title;
		this.userId = userId;
		this.b_Content = b_Content;
		this.b_Available = b_Available;
	}

	public int getBoardId() {
		return boardId;
	}

	public String getB_Title() {
		return b_Title;
	}

	public String getUserId() {
		return userId;
	}

	public String getB_Date() {
		return b_Date;
	}

	public String getB_Content() {
		return b_Content;
	}

	public int getB_Available() {
		return b_Available;
	}

}
