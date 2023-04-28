package com.myTinyLibrary.user.model.service;

import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myTinyLibrary.user.model.dto.AuthorsDto;
import com.myTinyLibrary.user.model.dto.UserDto;
import com.myTinyLibrary.user.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;
	
	@Autowired
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}

	@Override
	public int idCheck(String id) throws SQLException {
		return userMapper.idCheck(id);
	}

	@Override
	public void joinUser(UserDto userDto) throws SQLException {
		userMapper.joinUser(userDto);
	}

	@Override
	public UserDto login(Map<String, String> map) throws SQLException {
		return userMapper.login(map);
	}

	@Override
	public UserDto getUser(String id) throws SQLException {
		return userMapper.getUser(id);
	}

	@Override
	public void updateUser(UserDto userDto) throws SQLException {
		userMapper.updateUser(userDto);
	}

	@Override
	public void deleteUser(String id) throws SQLException {
		userMapper.deleteUser(id);
	}

	@Override
	public void registAuthor(AuthorsDto authorsDto) throws SQLException {
		userMapper.registAuthor(authorsDto);
	}

	@Override
	public List<UserDto> listUser(Map<String, Object> map) throws SQLException {
		return userMapper.listUser(map);
	}

	@Override
	public List<AuthorsDto> listAuthors(Map<String, Object> map) throws SQLException {
		return userMapper.listAuthors(map);
	}

	@Override
	public AuthorsDto getAuthors(String id) throws SQLException {
		return userMapper.getAuthors(id);
	}

	@Override
	public void updateAuthors(AuthorsDto authorsDto) throws SQLException {
		userMapper.updateAuthors(authorsDto);
	}

	@Override
	public void deleteAuthors(String id) throws SQLException {
		userMapper.deleteAuthors(id);
	}

}
