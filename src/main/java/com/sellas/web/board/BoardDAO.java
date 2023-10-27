package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardList(int cate);

	List<Map<String, Object>> setupboardList(int cate);

	int boardWrite(Map<String, Object> map);

	Map<String, Object> boardDetail(int bno);

	int boardEdit(Map<String, Object> map);

	int boardDelete(Map<String, Object> map);

	List<Map<String, Object>> commentList(int bno);
}
