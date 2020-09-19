package com.jforce.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jforce.dto.AvailableRoomDTO;
import com.jforce.dto.BookDTO;
import com.jforce.dto.RegisterDTO;
import com.jforce.service.AdminService;
import com.jforce.service.RegisterService;
import com.jforce.vo.BookVO;
import com.jforce.vo.LoginVO;
import com.jforce.vo.RegisterVO;
import com.jforce.vo.SearchRoomVO;

@Controller
public class MainController {
	@Autowired
	private RegisterService service;
	@Autowired
	private AdminService service1;

	@GetMapping("/home.htm")
	public String home() {
		return "welcome";
	}

	@GetMapping("/register.htm")
	public String registerControl(@ModelAttribute("register") RegisterVO vo) {
		return "visitor";
	}

	@PostMapping("/register.htm")
	public String processUser(Map<String, Object> map, @ModelAttribute("register") RegisterVO vo, BindingResult br) {
		RegisterDTO dto = null;

		dto = new RegisterDTO();
		dto.setMobileNumber(Long.parseLong(vo.getMobileNumber()));
		BeanUtils.copyProperties(vo, dto);
		String output = service.RegisterUser(dto);
		map.put("output", output);
		return "visitor";
	}

	@GetMapping("/login.htm")
	public String loginControl(@ModelAttribute("login") LoginVO vo) {
		return "login";
	}

	@PostMapping("/login.htm")
	public String loginUser(@ModelAttribute("login") LoginVO vo, BindingResult br) {
		boolean flag = false;
		String email = vo.getEmail();
		String pwd=vo.getPwd();
		flag = service.checkUser(email, pwd);
		if (flag)
			return "search_form";
		else
			return "login";
		
	}

	@GetMapping("/search.htm")
	public String searchControl(@ModelAttribute("search") SearchRoomVO vo) {
		return "search_room";
	}
	
	@PostMapping("/search.htm")
	public String getDataBasedOnDate(Map<String, Object> map, @ModelAttribute("search") SearchRoomVO vo, BindingResult br) {
		String inDate=vo.getCheckInDate();
		String outDate=vo.getCheckOutDate();
		List<AvailableRoomDTO> listdto=null;
		listdto=service1.fetchDateWiseRoom(inDate, outDate);
		map.put("listdto", listdto);
		return "search_room";
	}
	
	@GetMapping("/booking.htm")
	public String loginControl(@ModelAttribute("book") BookVO vo) {
		return "book";
	}

	
	@PostMapping("/booking.htm")
	public String getDataBasedOnDate(Map<String, Object> map, @ModelAttribute("book") BookVO vo, BindingResult br) {
		BookDTO dto=null;
		String conform=null;
		dto=new BookDTO();
		dto.setNo_of_guest(Integer.parseInt(vo.getNo_of_guest()));
		BeanUtils.copyProperties(vo, dto);
		conform=service.userBookRoom(dto);
		map.put("conform", conform);
		return "book";
	}
	
	
	@GetMapping("/viewReport.htm")
	public String viewReportData(Map<String, Object> map, @ModelAttribute("book") BookVO vo, BindingResult br) {
		List<BookDTO> listdto=null;
		listdto=service.controlReport();
		map.put("listdto", listdto);
		return "view_report";
	}
}
