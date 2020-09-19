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
@Repository
public class AdminDaoImpl implements AdminDao {
private static final String ROOM_ADDED="INSERT INTO AVAILABLE_ROOM (room_type, capacity, date) VALUES(?,?,?)";
private static final String GET_ROOM_DATE_WISE="SELECT  AID, ROOM_TYPE, CAPACITY, DATE FROM AVAILABLE_ROOM WHERE DATE IN(?,?)";
@Autowired
private JdbcTemplate jt;

	@Override
	public int roomInsert(AvailableRoomBO bo) {
		
		  int count=0; 
		  count=jt.update(ROOM_ADDED, bo.getRoom_type(), bo.getCapacity(), bo.getDate()); 
		return count;
	}
	@Override
	public List<AvailableRoomBO> dateWiseData(String inDate, String outDate) {
		List<AvailableRoomBO> listbo1=null;
		
		listbo1=jt.query(GET_ROOM_DATE_WISE, 
				new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, inDate);
				ps.setString(2, outDate);
			}
		},
				rs->{
			List<AvailableRoomBO> listbo=null;
			AvailableRoomBO bo=null;
			listbo=new ArrayList();
			while(rs.next()) {
				bo=new AvailableRoomBO();
				bo.setAid(rs.getInt(1));
				bo.setRoom_type(rs.getString(2));
				bo.setCapacity(rs.getInt(3));
				bo.setDate(rs.getString(4));
				
				listbo.add(bo);
			}//while
			return listbo;
		} );
		return listbo1;
	}

	
}
