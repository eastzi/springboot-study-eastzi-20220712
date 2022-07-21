package com.springboot.studyeastzi.domain.board;

import java.time.LocalDateTime;

import com.springboot.studyeastzi.web.dto.board.CreateBoardRespDto;
import com.springboot.studyeastzi.web.dto.board.ReadBoardRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardcode;
	private String title;
	private int usercode;
	private String username;
	private String content;
	private LocalDateTime createdate;
	private LocalDateTime updatedate;
	
	public CreateBoardRespDto toCreateBoardDto(boolean insertStatus) { //entity를 전달할때 매개변수로 전달함. 
		return CreateBoardRespDto.builder()
				.boardcode(boardcode)
				.title(title)
				.usercode(usercode)
				.content(content)
				.insertStatus(insertStatus)
				.build();
	}
	
	public ReadBoardRespDto toReadBoardDto() { //entity를 전달할때 매개변수로 전달함. 
		return ReadBoardRespDto.builder()
				.boardcode(boardcode)
				.title(title)
				.usercode(usercode)
				.username(username)
				.content(content)
				.createDate(createdate)
				.build();
	}
	
}
