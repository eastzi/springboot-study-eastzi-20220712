package com.springboot.studyeastzi.web.controller.api.board;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.studyeastzi.service.board.BoardService;
import com.springboot.studyeastzi.web.dto.CMRespDto;
import com.springboot.studyeastzi.web.dto.board.CreateBoardReqDto;
import com.springboot.studyeastzi.web.dto.board.CreateBoardRespDto;
import com.springboot.studyeastzi.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	
	//게시글 작성
	@PostMapping("/content") //json만 @RequestBody를 붙여야만 데이터가 들어옴
	public ResponseEntity<?> addBoard(@RequestBody CreateBoardReqDto createBoardReqDto) { //key값과 변수명이 같다면 key값과 @RequestParams 생략 가능 
		//1
//		System.out.println("게시글 작성 요청");
//		System.out.println("title: " + createBoardReqDto.getTitle());		
//		System.out.println("usercode: " + createBoardReqDto.getUsercode());		 
//		System.out.println("content: " + createBoardReqDto.getContent());		
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Contnetn-Type", "text/html;charset=utf-8"); 
//		return ResponseEntity.ok().headers(headers).body("test");
		
		//2
//		boolean responseData = false;
//		try { //예외가 발생해도 서버는 꺼지지말아야 한다.
//			responseData = boardService.createBoard(createBoardReqDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return ResponseEntity.internalServerError().body(responseData);
//		}
//		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 등록 성공", null));
		
		//return new ResponseEntity<>(title + "게시글 작성 성공", headers, HttpStatus.BAD_REQUEST);
		
		//3
		CreateBoardRespDto createBoardRespDto = null;
		try {
			createBoardRespDto = boardService.createBoard(createBoardReqDto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body(new CMRespDto<>(1, "게시글 등록 실패", createBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 등록 성공", createBoardRespDto));
	}
	
	//게시글 조회
	
	@GetMapping("/content/{boardcode}")
	public ResponseEntity<?> getBoard(@PathVariable int boardcode) {
		ReadBoardRespDto readBoardRespDto = null;
		try {
			readBoardRespDto = boardService.readBoard(boardcode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 실패", readBoardRespDto));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 조회 성공", readBoardRespDto));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getBoardList(@RequestParam int page) {
		List<ReadBoardRespDto> boardDtoList = null;
		try {
			boardDtoList = boardService.readBoardList(page);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.ok().body(new CMRespDto<>(-1, "게시글 리스트" + page + "페이지 불러오기 실패", boardDtoList));
		}
		return ResponseEntity.ok().body(new CMRespDto<>(1, "게시글 리스트 " + page + "페이지 불러오기 성공", boardDtoList));
	}
	
	//게시글 수정
	
	
	//게시글 삭제 
}
