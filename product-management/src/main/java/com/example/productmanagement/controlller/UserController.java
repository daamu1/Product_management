package com.example.productmanagement.controlller;
import com.example.productmanagement.entity.User;
import com.example.productmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping()
	public List<User> retrieveAllUser() {
		return userService.retrieveAllUser();
	}

	@GetMapping("/{userId}")
	public User GetUserById(@PathVariable Long userId) {
		return userService.retrieveUserById(userId);
	}

	@PostMapping()
	public User addNewUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUserById(@PathVariable Long userId) {
		userService.deleteUserDetail(userId);
	}

	@PutMapping("/{userId}")
	public void updateUserDetails(@PathVariable Long userId, @RequestBody User user) {
		userService.updateUserDetails(userId, user);
	}

//    @GetMapping("/{id}/addresses")
//    public List<Address> getUserAddresses(@PathVariable Long id) {
//        return userService.getUserAddresses(id);
//    }
}
