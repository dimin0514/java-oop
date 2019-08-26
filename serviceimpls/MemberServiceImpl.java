package com.bitcamp.serviceimpls;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberBean[] members;
	private int count;
	
	public MemberServiceImpl() {
		members = new MemberBean[10];
		count = 0;
	}
	@Override
	public String join(MemberBean param) {
		String msg ="회원가입 성공";
		members[count]=param;   //count 쓰닌 이유는 [0], [1] 이렇게 가려고?
		count++;          		//this.count++;  여기서 this 생략가능 안써도 위에 클래스변수로 감. 메서드 안에 없으니깐.
		return msg;
	}
	@Override
	public String getMypage(MemberBean param) {
		return param.toString();
	}
	@Override
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
	@Override
	public String withdraw(MemberBean param) {
		String msg = "회원탈퇴";
		return msg;
	}
	@Override
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
	@Override
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

}
