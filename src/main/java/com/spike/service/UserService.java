package com.spike.service;

import com.spike.model.User;
import com.spike.vo.UserVO;

public interface UserService {
	
	public User regist(User user);
	
	public UserVO getUser(String username);
	
	public void saveUserToRedisByToken(String token, UserVO userVO);
	
}
