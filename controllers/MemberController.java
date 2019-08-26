package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.serviceimpls.MemberServiceImpl;
import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.MemberService;
public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean member = null;
		String[] arr = null;
		String temp = "";
		
		while(true) {
			
			
			switch (JOptionPane.showInputDialog("0.종료\n "
					+ "1.회원가입\n "
					+ "2.마이페이지\n"
					+ "3.비번수정\n"
					+ "4.회원탈퇴\n"
					+ "5.아이디체크\n"
					+ "6.로그인")) {
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
				
			case "1":
				String spec = JOptionPane.showInputDialog("이름,아이디,비밀번호,주민번호,혈액형,키,몸무게"); //스캐너라 보면됨
				System.out.println("*****"+spec);
				arr = spec.split(","); 
				// "이름,아이디,비밀번호,주민번호,혈액형,키,몸무게" 이거보고 쓸때  홍길동,a,b,1234,a,153,30 이렇게 쓸텐데
				// , 를 기준으로 모두 배열로 바꿔줌. 그래서 이거 쓸때 아래에서 키 몸무게는 숫자로 변환해야함.
				member = new MemberBean();
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPw(arr[2]);
				member.setSsn(arr[3]);
				member.setBlood(arr[4]);
				member.setHeight(Double.parseDouble(arr[5]));
				member.setWeight(Double.parseDouble(arr[6]));
				
				JOptionPane.showMessageDialog(null, service.join(member)); //출력인데 결과값 회원가입완료 뜨겠지
				
				
				
				break;

			case "2":
				JOptionPane.showMessageDialog(null, service.getMypage(member));
				
				break;

			case "3": //근데 화면은 먼저 짜는게 아님. 왜나면 분업화되서 우리가 하는일하고 다를 수 있다! 상상해서 하는걸 연습해야 함.
				temp = JOptionPane.showInputDialog("id, 현재비번, 변경할비번");
				arr = temp.split(",");
				member = new MemberBean();  //청소해줘야 새롭게 들어감 초기화~~
				member.setId(arr[0]);
				member.setPw(arr[1]+","+arr[2]);
				JOptionPane.showMessageDialog(null, service.changePassword(member));
				break;
				
				/**
				 * member.setiId(temp
				 * member.setPw(tempPw);
				 * member2.setPw(newPw);
				 * MemberBean[] member2 = {member, member2};
				 * 
				 */
				
				
			case "4":
				
				break;
				
			
			case "6":
				String loginValue = JOptionPane.showInputDialog("로그인 ID,pw");
				String[] loginValues = loginValue.split(",");
				String loginId = loginValues[0];
				String loginPw = loginValues[1];
				member = new MemberBean(); // 초기화해야함 그래야 새로운거 받음
				member.setId(loginPw);
				member.setPw(loginPw);
				String msg =  service.login(member);
				JOptionPane.showMessageDialog(null, msg);
				
			
				break;
				
			default:
				break;
			}
			
		}
		
	}

}
