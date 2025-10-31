package com.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.entity.UserEntity;
import com.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private Cloudinary cloudinary;

	@GetMapping("signup")
	public String signup() {
		return "Signup";
	}

	@PostMapping("signup")
	public String signup(UserEntity user, MultipartFile profilePic, Model model) {

		Optional<UserEntity> op = userRepository.findByEmail(user.getEmail());

		if (op.isPresent()) {
			model.addAttribute("error", "Email is already registered with us");
			return "Signup";
		}
		user.setRole("USER");
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setCreatedAt(LocalDate.now());

		try {
			Map map = cloudinary.uploader().upload(profilePic.getBytes(),
					ObjectUtils.asMap("folder", "students/profile_pics", "resource_type", "image"));

			String profilePicUrl = map.get("secure_url").toString();
			user.setProfilePicUrl(profilePicUrl); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		userRepository.save(user);

		return "Login";
	}

	@GetMapping(value = { "/", "login" })
	public String login() {
		return "Login";
	}

	@PostMapping("authenticate")
	public String authenticate(String email, String password, Model model, HttpSession session) {
		Optional<UserEntity> op = userRepository.findByEmail(email);

		UserEntity user = op.get();
		if (op.isEmpty() || passwordEncoder.matches(password, user.getPassword()) == false) {
			model.addAttribute("error", "Invalid Credentials");
			return "Login";
		} else {
			session.setAttribute("user", user);
			return "redirect:/userdashboard";
		}
	}

}
