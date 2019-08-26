package com.bitcamp.controllers;
import javax.swing.JOptionPane;
import com.bitcamp.domains.PhoneBean;
import com.bitcamp.services.PhoneService;

public class CelphoneController {
	public static void main(String[] args) {
		PhoneBean p = null; 
		PhoneService svc = new PhoneService(); 
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료  1.집전화기, 2.2g폰  3.아이폰  4.안드로이드폰")) {
			
			case "0":
				JOptionPane.showMessageDialog(null, "종료");
				return;
			case "1": 
				String[] arr=JOptionPane.showInputDialog("생산자,통화내용.수신자").split(",");
				p = new PhoneBean();
				p.setCompany(arr[0]);  
				p.setCall(arr[1]); 	 
				p.setReceiver(arr[2]);
				JOptionPane.showMessageDialog(null, svc.callWithPhone(p));

				break;
			case "2": break;
			case "3": break;
			case "4": break;
			}
		}
	}

}
