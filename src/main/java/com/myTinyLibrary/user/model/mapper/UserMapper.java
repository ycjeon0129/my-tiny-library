package com.myTinyLibrary.user.model.mapper;

import java.sql.SQLException;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.myTinyLibrary.user.model.dto.AuthorsDto;
import com.myTinyLibrary.user.model.dto.UserDto;

@Mapper
public interface UserMapper {
	
	int idCheck(String id) throws SQLException;
	void joinUser(UserDto userDto) throws SQLException;
	UserDto login(Map<String, String> map) throws SQLException;
	UserDto getUser(String id) throws SQLException;
	void updateUser(UserDto userDto) throws SQLException;
	void deleteUser(String id) throws SQLException;
	
	/* Admin */
	void registAuthor(AuthorsDto authorsDto) throws SQLException;
	List<UserDto> listUser(Map<String, Object> map) throws SQLException;
	List<AuthorsDto> listAuthors(Map<String, Object> map) throws SQLException;
	AuthorsDto getAuthors(String id) throws SQLException;
	void updateAuthors(AuthorsDto authorsDto) throws SQLException;
	void deleteAuthors(String id) throws SQLException;
	
}
