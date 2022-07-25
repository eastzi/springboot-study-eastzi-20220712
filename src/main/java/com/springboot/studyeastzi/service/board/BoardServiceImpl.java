package com.springboot.studyeastzi.service.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.studyeastzi.domain.board.Board;
import com.springboot.studyeastzi.domain.board.BoardRepository;
import com.springboot.studyeastzi.web.dto.board.CreateBoardReqDto;
import com.springboot.studyeastzi.web.dto.board.CreateBoardRespDto;
import com.springboot.studyeastzi.web.dto.board.ReadBoardRespDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardRepository boardRepository; //board.xml 파라메터타입 주소생성
	
	@Override
	public CreateBoardRespDto createBoard(CreateBoardReqDto createBoardReqDto) throws Exception {
		//1
		//서비스에서 dto로 받은 것을 entity로 바꿔줘야 한다.(toEntity로 가져옴. dto클래스안에 있음)
//		System.out.println(createBoardReqDto);
//		if(0 == 0) {
//			throw new RuntimeException(); //예외가 발생해도 서버는 꺼지지말아야 한다.			
//		}
//		return true;
		
		//2
//		Board board = createBoardReqDto.toEntity();
//		System.out.println("DB 다녀오기 전: " + board);
//		int result = boardRepository.save(board);
//		System.out.println("DB 다녀온 후: " + board);
//		return boardRepository.save(createBoardReqDto.toEntity()) > 0;

		//3
		//entity -> dto 로 응답 
		Board boardEntity = createBoardReqDto.toEntity(); //요청을 보내고
		
		boolean insertStatus = boardRepository.save(boardEntity) > 0;
		
		return boardEntity.toCreateBoardDto(insertStatus); //응답을 받아온다.
	}
	
	@Override
	public ReadBoardRespDto readBoard(int boardcode) throws Exception {
		return boardRepository.findBoardByBoardcode(boardcode).toReadBoardDto();
	}
	
	@Override
	public List<ReadBoardRespDto> readBoardList(int page) throws Exception {
		List<ReadBoardRespDto> BoardDtoList = new ArrayList<ReadBoardRespDto>();
		
		//List<Board> boardList = boardRepository.getBoardListOfIndex((page-1) * 10);
		boardRepository.getBoardListOfIndex((page-1) * 10).forEach(board -> {
			BoardDtoList.add(board.toReadBoardDto());
		});
 		return BoardDtoList;
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
