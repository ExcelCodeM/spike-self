package com.spike.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spike.model.User;
import com.spike.redis.UserRedis;
import com.spike.repository.UserRepository;
import com.spike.service.UserService;
import com.spike.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public UserRedis userRedis;

	@Override
	public User regist(User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@Override
	public UserVO getUser(String username) {
		UserVO userVO = new UserVO();
		User user = userRedis.get(username);
		if(user == null) {
			user = userRepository.findByUsername(username);
			if(user == null) {
				return null;		
			}
			userRedis.put(username, user, -1);
		}
		BeanUtils.copyProperties(user, userVO);			
		return userVO;
	}

	@Override
	public void saveUserToRedisByToken(String token, UserVO userVO) {
		User user = new User();
		BeanUtils.copyProperties(userVO, user);
		userRedis.put(token, user, 60*60*24);
	}
	
	
	
}
