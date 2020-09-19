package com.jforce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jforce.bo.BookBO;
import com.jforce.bo.RegisterBO;
import com.jforce.dao.RegisterDao;
import com.jforce.dto.BookDTO;
import com.jforce.dto.RegisterDTO;
@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private RegisterDao dao;

	@Override
	public String RegisterUser(RegisterDTO dto) {
		
		  RegisterBO bo=null; 
		  bo=new RegisterBO();
		  BeanUtils.copyProperties(dto, bo); 
		  //invoked dao method 
		  int count=dao.insertData(bo);
		  return(count==0) ? "Registration not Completed": "Registration Successfully Completed";
		 
	}

	@Override
	public boolean checkUser(String email, String pwd) {
		int user;
		user=dao.retriveUser(email, pwd);
		if(user==0)
			return false;
		else
		   return true;
	}

	@Override
	public String userBookRoom(BookDTO dto) {
		BookBO bo=null;
		bo=new BookBO();
		int book=0;
		BeanUtils.copyProperties(dto, bo);
		book=dao.insertBookUserData(bo);
		return (book==0) ? "Booking not Completed":"Booking Is Completed";
	}

	@Override
	public List<BookDTO> controlReport() {
		List<BookBO> listbo=null;
		List<BookDTO> listdto=new ArrayList();
		listbo=dao.showReport();
		listbo.forEach(bo->{
			BookDTO dto=new BookDTO();
			BeanUtils.copyProperties(bo, dto);
			listdto.add(dto);
		});
		return listdto;
	}

}
