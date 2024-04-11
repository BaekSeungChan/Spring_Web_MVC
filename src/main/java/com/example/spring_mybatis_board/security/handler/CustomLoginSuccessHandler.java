//package com.example.spring_mybatis_board.security.handler;
//
//import kr.or.kosa.mapper.MemberDAO;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Slf4j
//public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//	@Autowired
//	private MemberDAO memberDAO;
//
//	@Override
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
//			throws IOException, ServletException {
//
//		memberDAO.updateMemberLastLogin(authentication.getName());
//		memberDAO.loginCountClear(authentication.getName());
//
//		System.out.println("authentication ->" + authentication);
//
//		setDefaultTargetUrl("/sample/member");
//
//  	super.onAuthenticationSuccess(request, response, authentication);
//
//	}
//
//}