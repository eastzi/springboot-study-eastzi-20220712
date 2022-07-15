package com.springboot.studyeastzi.web.dto.board;

import lombok.Data;

@Data
public class CreateBoardReqDto {
	private String title;
	private int usercode;
	private String content;
}
