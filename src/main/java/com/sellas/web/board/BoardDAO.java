package com.sellas.web.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {

	List<Map<String, Object>> noticeList(int board);

	List<Map<String, Object>> setupboardList(int board);
}
