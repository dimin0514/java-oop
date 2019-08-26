package com.bitcamp.services;
import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지에서 정보보기
 * 3. 비번을 수정
 * 4. 회원탈퇴
 * 5. 아이디 존재 체크
 * 6. 로그인
 * ************
 * <관리자기능>
 * 1. 회원목록
 * 2. 아이디검색
 * 3. 이름검색 (아이디는 달라야함 a a1 이렇게 들어가지만 이름은 같을 수 있음. 동명이인의 경우)
 * 4. 전체 회원수 
 */
					//추상화
	public interface MemberService {
		public String join(MemberBean param);			
		public String getMypage(MemberBean param);
		public String changePassword(MemberBean param);
		public String withdraw(MemberBean param) ;
		public String existId(String id);
		public String login(MemberBean param);
}


