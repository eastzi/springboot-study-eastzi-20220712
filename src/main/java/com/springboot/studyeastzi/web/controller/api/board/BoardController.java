package com.springboot.studyeastzi.web.controller.api.board;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studyeastzi.service.board.BoardService;
import com.springboot.studyeastzi.web.dto.board.CreateBoardReqDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	//게시글 작성
	@PostMapping("/content")
	public ResponseEntity<?> addBoard(CreateBoardReqDto createBoardReqDto) { //key값과 변수명이 같다면 key값과 @RequestParams 생략 가능 
//		System.out.println("게시글 작성 요청");
//		System.out.println("title: " + createBoardReqDto.getTitle());		
//		System.out.println("usercode: " + createBoardReqDto.getUsercode());		 
//		System.out.println("content: " + createBoardReqDto.getContent());		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Contnetn-Type", "text/html;charset=utf-8"); 
//		return ResponseEntity.ok().headers(headers).body("test");
		
		boolean responseData = false;
		try { //예외가 발생해도 서버는 꺼지지말아야 한다.
			responseData = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(responseData);
		}
		return ResponseEntity.ok().body(responseData);
		
		//return new ResponseEntity<>(title + "게시글 작성 성공", headers, HttpStatus.BAD_REQUEST);
	}
	
	//게시글 조회
	
	//게시글 수정
	
	//게시글 삭제 
}
