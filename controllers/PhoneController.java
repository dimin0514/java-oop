package com.bitcamp.controllers;
import com.bitcamp.domains.PhoneBean;
import com.bitcamp.services.PhoneService;
import javax.swing.JOptionPane;

public class PhoneController {
	
	
	public static void main(String[] args) {
		PhoneService svc = new PhoneService(); // 서버는 하나만 만들어서 공유!! 
		
		PhoneBean p = null;  // 지역변수는 유니크 해야한다. 그래서 와일문 바깥으로 빼야 함. 얘는 여러개 만드니까 아래서 뉴...~~
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료  1.집전화기, 2.2g폰  3.아이폰  4.안드로이드폰")) {
			case "0": 
				JOptionPane.showMessageDialog(null, "종료"); 
				return;
			case "1":
				//String msg= JOptionPane.showInputDialog("생산자, 통화내용, 수신자");   //입력받는 내용!! 입력하는건 리턴값이 없음.set get set 줄때는 리턴!
				// 이건 세터 다음에 게터 바로 출력  ***지역변수가  한번 사용되는 건 합치면 된다.
				//String[] arr = msg.split(",");  // 쪼개줘야 함. arr 한번 쓰임... 
				
				String[]arr=JOptionPane.showInputDialog("생산자, 통화내용, 수신자").split(",");
				p = new PhoneBean();
				p.setCompany(arr[0]);    	// set 을 해서 호출. 
				p.setCall(arr[1]); 	 		// p 를 서비스의 파라미터로 보내줘야함.
				p.setReceiver(arr[2]);
				//String s = svc.callWithPhone(p);   // s 는 tostring
				//JOptionPane.showMessageDialog(null,s) ; 근데 위에 지역변수 한번 사용이니깐 아래로 합치자!
				
				JOptionPane.showMessageDialog(null, svc.callWithPhone(p));
				
				break;
			case "2": 
				break;
			case "3": 
				break;
			case "4": 
				break;
			
			}
			
		}
		
	}

}
