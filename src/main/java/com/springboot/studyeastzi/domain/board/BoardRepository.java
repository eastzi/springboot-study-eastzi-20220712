package com.springboot.studyeastzi.domain.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper 
//mapper는 mybatis 매핑xml에 기재된 sql 호출하기 위한 인터페이스 
public interface BoardRepository { //board.xml 이 중요한 역할을 함.
	public int save(Board board); //무조건 int 타입만 있어서 int로 적음. 
	public Board findBoardByBoardcode(int boardcode);
	public List<Board> getBoardListOfIndex(int index);
}
