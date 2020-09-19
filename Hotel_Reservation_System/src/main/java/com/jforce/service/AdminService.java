package com.jforce.service;

import java.util.List;

import com.jforce.dto.AvailableRoomDTO;

public interface AdminService {
	String availbilityRoom(AvailableRoomDTO dto);
	List<AvailableRoomDTO> fetchDateWiseRoom(String inDate, String outDate);
}
