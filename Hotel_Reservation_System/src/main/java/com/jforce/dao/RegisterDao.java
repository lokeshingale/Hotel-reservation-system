package com.jforce.dao;

import java.util.List;

import com.jforce.bo.BookBO;
import com.jforce.bo.RegisterBO;

public interface RegisterDao{
	int insertData(RegisterBO bo);
	int retriveUser(String email, String pwd);
	int insertBookUserData(BookBO bo);
	List<BookBO> showReport();
}
