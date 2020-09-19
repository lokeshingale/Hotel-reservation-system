package com.jforce.dao;

import java.util.List;

import com.jforce.bo.AvailableRoomBO;
import com.jforce.bo.SearchRoomBO;

public interface AdminDao {
	int roomInsert(AvailableRoomBO bo);
	List<AvailableRoomBO> dateWiseData(String inDate, String outDate);
}
