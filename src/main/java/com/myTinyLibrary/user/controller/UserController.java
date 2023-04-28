package com.myTinyLibrary.user.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myTinyLibrary.user.model.dto.UserDto;
import com.myTinyLibrary.user.model.service.UserService;

@RestController
//@RequestMapping("/user")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
//	
//	
//	//~~>
//	@GetMapping("/login")
//	public String Login() {
//		return "user/login";
//	}
//	
//	/**
//	 * <pre>
//	 * /login 요청이 post 방식으로 왔을 때 login 처리한다.
//	 * </pre>
//	 * 
//	 * 사용자의 요청에서 계정 정보를 추출해 로그인 처리한다.
//	 * 일단 사용자 id가 ssafy, 비밀번호가 1234면 로그인에 성공으로 간주한다.
//	 * 로그인 성공 시 session에 정보를 담고 redirect로 index로 이동한다.
//	 * 그렇지 않을 경우는 로그인 실패 메시지를 model에 담고 forward로 index로 이동한다.
//	 * 
//	 * @param user
//	 *            전달된 파라미터는 ModelAttribute를 통해서 객체로 받을 수 있다.
//	 * @param session
//	 *            사용자 정보를 세션에 저장하기 위해 사용한다.
//	 * @param model
//	 *            Request scope에 정보를 저장하기 위해서 사용된다.
//	 * @return
//	 * @throws SQLException 
//	 */
//	// 다시보기
//	@PostMapping("/login")
//	public String login(String id, String pass, HttpSession session, Model model) throws SQLException {
////		if (id.equals("ssafy") && pass.equals("1234")) {
////			UserDto userDto = new UserDto();
////			userDto.setName("김싸피");
////			session.setAttribute("loginUser", userDto);
////			return "redirect: /index";
////		}
////		
//		//
//		System.out.println("durl Wlrgla");
//		UserDto userDto = userService.login(id, pass);
//		if (userDto == null) {
//			model.addAttribute("msg", "로그인 실패!");
//			return "index";
//		} else {
//			session.setAttribute("userinfo", userDto);
//			return "index";
//		}
//		
//	}
//	// /다시보기
//
//
//	/**
//	 * <pre>/logout을 get 방식으로 요청했을 때 session을 만료 시키고 로그아웃 처리한다.</pre>
//	 * 다음 경로는 redirect 형태로 /index로 이동한다.
//	 * @param session
//	 * @return
//	 */
//	@GetMapping("/logout")
//	public String doLogOut(HttpSession session) {
//		session.invalidate();
//		return "redirect:/index";
//	}
//	
	
}
