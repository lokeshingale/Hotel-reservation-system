package com.jforce.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jforce.dto.AvailableRoomDTO;
import com.jforce.service.AdminService;
import com.jforce.vo.AvailableRoomVO;
import com.jforce.vo.LoginVO;

@Controller
public class AdminController {
@Autowired
private AdminService service;

@GetMapping("/add.htm")
public String registerControl(@ModelAttribute("available") AvailableRoomVO vo) {
	return "add_room";
}

@PostMapping("/add.htm")
public String processUser(Map<String, Object> map, @ModelAttribute("available") AvailableRoomVO vo, BindingResult br) {
	AvailableRoomDTO dto = null;

	dto = new AvailableRoomDTO();
	dto.setCapacity(Integer.parseInt(vo.getCapacity()));
	BeanUtils.copyProperties(vo, dto);
	
	String result = service.availbilityRoom(dto);
	map.put("result", result);
	return "add_room";
}
}