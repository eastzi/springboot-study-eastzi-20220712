package com.springboot.studyeastzi.service.board;

import org.springframework.stereotype.Service;

import com.springboot.studyeastzi.web.dto.board.CreateBoardReqDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public boolean createBoard(CreateBoardReqDto createBoardReqDto) throws Exception {
		System.out.println(createBoardReqDto);
		if(0 == 0) {
			throw new RuntimeException(); //예외가 발생해도 서버는 꺼지지말아야 한다.			
		}
		return true;
	}

	@Override
	public boolean updateBoard(int boardcode, CreateBoardReqDto createBoardReqDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(int boardcode) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
