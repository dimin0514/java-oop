package com.bitcamp.services;
import com.bitcamp.domains.MemberBean;
/**
 * 요구사항 (기능정의)
 * <사용자기능>
 * 1. 회원가입
 * 2. 마이페이지에서 정보보기
 * 3. 비번을 수정
 * 4. 회원탈퇴
 * ************
 * <관리자기능>
 * 5. 회원목록
 * 6. 아이디검색
 */
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() {
		members = new MemberBean[2];
		count = 0;
	}
	
	/**
	 * 1. 회원가입
	 */
	public String join(MemberBean param) {
		String msg ="회원가입 성공";
		members[count]=param;   //count 쓰닌 이유는 [0], [1] 이렇게 가려고?
		count++;          		//this.count++;  여기서 this 생략가능
		return msg;
	}
	/**
	 * 2.마이페이지
	 */
	public String getMypage(MemberBean param) {
		return param.toString();
	}
	/**
	 * 3.비번수정
	 */
	public String changePassword(MemberBean param) {
		String msg = "비밀번호가 변경되었습니다.";
		return msg;
	}
	/**
	 * 4.회원탈퇴
	 */
	public String withdraw(MemberBean param) {
		String msg = "회원탈퇴";
		return msg;
	}
	/**
	 * 5.회원목록
	 */
	public String list() {
		String msg = "회원목록";
		for(int i=0;i<count; i++) {
			msg+= members[i].toString()+",\n";
		}
		return msg;
	}
	
	/**
	 * 6.아이디검색
	 */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];  //사본주려고... 원본줘서 빼면 안되니깐... 지역변수 gc 없어지게...
			}
		}
		return member;
	}

}
