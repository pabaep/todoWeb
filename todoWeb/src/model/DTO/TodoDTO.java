/**
CREATE TABLE todoT (
       todoId          	number  PRIMARY KEY seq,
       todoContent      VARCHAR2(100) NOT NULL,
       todoStart        DATE NOT NULL,
       todoEnd          DATE NOT NULL
       userId			number FK
); */
package model.DTO;

import lombok.Data;

@Data
public class TodoDTO {
	private int todoId;
	private String todoContent;
	private String todoStart;
	private String todoEnd;
	private int userId;
	
	@Override
	public String toString() {
		return "todoDTO [todoId=" + todoId + ", todoContent=" + todoContent + ", todoStart=" + todoStart + ", todoEnd="
				+ todoEnd + ", userId=" + userId + "]";
	}

	public TodoDTO(String todoContent, String todoStart, String todoEnd, int userId) {
		this.todoContent = todoContent;
		this.todoStart = todoStart;
		this.todoEnd = todoEnd;
		this.userId = userId;
	}

}
