package com.bitcamp.serviceimpls;
import com.bitcamp.domains.PhoneBean;
import com.bitcamp.services.PhoneService;
public class PhoneServiceImpl implements PhoneService{

	@Override
	public String callWithPhone(PhoneBean k) {
		
		return k.toString();
		}

	@Override
	public String callTwoG(PhoneBean k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String callIphone(PhoneBean k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String callAndroid(PhoneBean k) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
