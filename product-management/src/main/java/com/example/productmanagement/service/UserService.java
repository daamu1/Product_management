package com.example.productmanagement.service;

import com.example.productmanagement.dto.UserDto;
import com.example.productmanagement.entity.User;
import com.example.productmanagement.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
	@Autowired(required=true)
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	public List<User> retrieveAllUser() {
		return userRepository.findAll();
	}

	public User retrieveUserById(Long userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
			throw new UserNotFoundException("Invalid User id ");
		}
		return user;
	}

	public User addNewUser(User user) {
		User userr =new User();
		return userr;
	}

	public void deleteUserDetail(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isEmpty()) {
			throw new UserNotFoundException(" in This Given UserId there Are No user " + userId);
		} else {
			userRepository.deleteById(userId);
		}
	}

	public void updateUserDetails(Long userId, User user) {
		if (user == null) {
			throw new UserNotFoundException(" in This Given UserId there Are No user " + userId);
		} else {
			userRepository.save(user);
		}
	}

	public User userToDto(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		return user;
	}

	public UserDto dtoToUser(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
}
