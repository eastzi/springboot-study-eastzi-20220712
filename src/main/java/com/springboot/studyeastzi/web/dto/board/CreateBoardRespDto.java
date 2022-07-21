package com.springboot.studyeastzi.web.dto.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateBoardRespDto { //요청 반대로 응답가는것 toDto가 필요한 것 -> entity가 가짐 
	private int boardcode;
	private String title;
	private int usercode;
	private String content;
	private boolean insertStatus;
	
	
}
