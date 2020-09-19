package com.jforce.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.jforce.bo.AvailableRoomBO;
import com.jforce.bo.BookBO;
import com.jforce.bo.RegisterBO;
@Repository
public class RegisterDaoImpl implements RegisterDao {
private static final String REGISTER_QUERY="INSERT INTO REGISTER_USER (name, email, mobileNumber, pwd)VALUES(?,?,?,?)";
private static final String LOGIN_QUERY="SELECT COUNT(*) FROM REGISTER_USER WHERE EMAIL=? AND PWD=?";
private static final String BOOK_ROOM_QUERY="INSERT INTO BOOK_ROOM1 (name, no_of_guest, room_type, checkindate, checkoutdate) VALUES(?,?,?,?,?)";
private static final String RETIRVE_ALL_DATA="SELECT * FROM BOOK_ROOM1";
@Autowired
private JdbcTemplate jt;
	@Override
	public int insertData(RegisterBO bo) {
		int count=0;
		count=jt.update(REGISTER_QUERY, bo.getName(), bo.getEmail(), bo.getMobileNumber(), bo.getPwd());
		return count;
	}
	@Override
	public int retriveUser(String email, String pwd) {
		int user;
		user=jt.queryForObject(LOGIN_QUERY, Integer.class, email, pwd);
		return user;
	}
	@Override
	public int insertBookUserData(BookBO bo) {
		int book=0;
		String s=null;
		book=jt.update(BOOK_ROOM_QUERY, bo.getName(), bo.getNo_of_guest(), bo.getRoom_type(), bo.getCheckInDate(), bo.getCheckOutDate());
		return book;
	}
	@Override
	public List<BookBO> showReport() {
     List<BookBO> listbo1=null;
		
		listbo1=jt.query(RETIRVE_ALL_DATA,  rs->{
			List<BookBO> listbo=null;
			BookBO bo=null;
			listbo=new ArrayList();
			while(rs.next()) {
				bo=new BookBO();
				bo.setBid(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setNo_of_guest(rs.getInt(3));
				bo.setRoom_type(rs.getString(4));
				bo.setCheckInDate(rs.getString(5));
				bo.setCheckOutDate(rs.getString(6));
				listbo.add(bo);
			}//while
			return listbo;
		} );
		return listbo1;
	}
		

}
