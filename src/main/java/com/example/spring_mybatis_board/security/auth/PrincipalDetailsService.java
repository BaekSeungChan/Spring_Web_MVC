//package com.example.spring_mybatis_board.security.auth;
//
//import kr.or.kosa.entity.MemberVO;
//import kr.or.kosa.mapper.MemberDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PrincipalDetailsService implements UserDetailsService {
//
//	@Autowired
//	private MemberDAO memberDAO;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		System.out.println("PrincipalDetailsService : 진입");
//		MemberVO member = memberDAO.findByEmail(username);
//		if (member == null) {
//			throw new UsernameNotFoundException(username + " 계정이 존재하지 않습니다");
//		}
//
//		System.out.println("PrincipalDetailsService : member -> " + member);
//
//		return new PrincipalDetails(member);
//	}
//}
