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
public class MemberService {
	private MemberBean[] members;
	private int count;
	
	public MemberService() { 			//생성자 메서드에서 건드는 이유. 초기값 설정해 줘야 하는게 있어서...!!
		members = new MemberBean[2]; 	// 배열의 크기를 먼저 할당해 줘야함. [ ] 이면 에러.. 배열은 범위가 있어야함.
		count = 0;						//일단 초기값이 0 임 뒤에서 count ++ 때문에 1씩 증가됨
	}

	/***********************************************************
	 * 사용자 기능
	 * *********************************************************
	/**
	 * 1. 회원가입
	 */
	public String join(MemberBean param) {
		String msg ="회원가입 성공";
		members[count]=param;   //count 쓰닌 이유는 [0], [1] 이렇게 가려고?
		count++;          		//this.count++;  여기서 this 생략가능 안써도 위에 클래스변수로 감. 메서드 안에 없으니깐.
		return msg;
	}
	/**
	 * 2.마이페이지
	 */
	public String getMypage(MemberBean param) {
		return param.toString();
	}
	/**
	 * 3.비번수정(ID, 옛날 비번, 신규비번을 입력받아서 옛날비번을 마지막으로 체크 후 일치하면 신규비번으로 변경함.)
	 * 비번 변경후 로그인을 실행해서 새로 바뀐 비번이 로그인 성공, 옛날비번은 로그인 실패.
	 */
	public String changePassword(MemberBean param) {
		String msg = "비밀번호가 변경되었습니다.";
		String id = param.getId();    //메서드는 독립적이니깐 id 또 써도 됨..
		String pw = param.getPw();         //String oldPw = param.getPw().split(",")[0];
		String[] pws = pw.split(",");
		String oldPw = pws[0];
		String newPw = pws[1];
		
		
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId()) 
					&& param.getPw().equals(members[i].getPw())) {
				members[i].setPw(newPw);
				break;
			}
		}
		
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
	 * 5.아이디 체크
	 */
	public String existId(String id) {
		//가입 가능한 아이디 입니다.
		String msg ="가입가능한 아이디";
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				msg ="이미 존재 아이디";
				break;
			}
		}
		return msg;
	}
	/**
	 * 5.로그인(파라미터로 id pw 만 입력받은 상태)
	 */
	public String login(MemberBean param) {
		String msg = "로그인실패";
		String id = param.getId();
		String pw = param.getPw();
		for(int i=0;i<count;i++) {
			if(param.getId().equals(members[i].getId()) 
					&& param.getPw().equals(members[i].getPw())) {
				msg = "로그인 성공";
				break;
			}
		}
		return msg;
	}
	
	
	/***********************************************************
	 * 관리자 기능
	 * *********************************************************
	/**
	 * 1.회원목록
	 */
	public String list() {
		String msg = "회원목록";
		for(int i=0;i<count; i++) {
			msg+= members[i].toString()+",\n";
		}
		return msg;
	}
	/**
	 * 2.아이디검색
	 */
	public MemberBean findById(String id) {
		MemberBean member = new MemberBean();
		
		for(int i=0;i<count;i++) {
			if(id.equals(members[i].getId())) {
				member = members[i];  //사본주려고... 원본줘서 빼면 안되니깐... 지역변수 gc 없어지게...
				break;          //이거 꼭 해야됨..!! 계속 cpu 돌아간다..
			}
		}
		return member;
	}
	/**
	 * 3.이름검색
	 */
	
	public MemberBean[] findByName(String name) {
		int sameNameCount=0;
		for(int i=0;i<count;i++) {
			if(name.equals(this.members[i].getName())) {
				sameNameCount++;
			}
			
		}
		MemberBean[] members = new MemberBean[sameNameCount];
		int j = 0;
		for(int i=0;i<count;i++) {

			if(name.equals(this.members[i].getName())) {
				members[j]= this.members[i];
				j++;
				
				if(members.length == j) {
					break;
				}
			}
			members[i] = this.members[i];
		}
		return members;
		
	}
	/**
	 * 4.전체 회원수
	 */
	public String countAll() {
		//String numbers = String.valueOf(count);
		//return numbers;
		//return "총회원수"+count;
		return String.valueOf(count);
	}

}
