package com.jforce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jforce.bo.AvailableRoomBO;
import com.jforce.dao.AdminDao;
import com.jforce.dto.AvailableRoomDTO;

@Service("service")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao dao;

	
	@Override
	public String availbilityRoom(AvailableRoomDTO dto) {
		AvailableRoomBO bo = null;
		bo = new AvailableRoomBO();

		BeanUtils.copyProperties(dto, bo);
		int count = dao.roomInsert(bo);
		if (count == 0)
			return "Room Not Added";
		else
			return "Room  Added";
	}

	@Override
	public List<AvailableRoomDTO> fetchDateWiseRoom(String inDate, String outDate) {
		List<AvailableRoomBO> listbo = null;
		List<AvailableRoomDTO> listdto = new ArrayList();
		listbo = dao.dateWiseData(inDate, outDate);
		listbo.forEach(bo -> {
			AvailableRoomDTO dto = new AvailableRoomDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}
}
