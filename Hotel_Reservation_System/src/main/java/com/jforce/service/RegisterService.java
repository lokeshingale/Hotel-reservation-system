package com.jforce.service;

import java.util.List;

import com.jforce.dto.BookDTO;
import com.jforce.dto.RegisterDTO;

public interface RegisterService {
 String RegisterUser(RegisterDTO dto);
 boolean checkUser(String email, String pwd);
 String userBookRoom(BookDTO dto);
 List<BookDTO> controlReport();
}
