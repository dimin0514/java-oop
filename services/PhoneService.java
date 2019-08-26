package com.bitcamp.services;
import com.bitcamp.domains.PhoneBean;  //tostring 에 자료가 있으니깐 가져와야지.
/**
 * 기능정의
 * 1. 집전화기로 통화
 * 2. 2G폰 통화
 * 3. 아이폰 통화
 * 4. 안드로이드폰 통화
 */
/*
 *생산자 이름은 company <생산자명, 통화내용, 수신자>받는 내용!!
 *통화내용은 call
 *전화번호 number
 *수신자 receiver
 *전화기 상태는 KIND ->상수 : 집전화기, 2G폰, 아이폰, 안드로이드폰
 *나는 {금성}에서 만든{집전화기}를 사용해서 {길동}에게 {안녕} 이라고 통화했다. tostring 찍힘 
 */

public interface PhoneService {
	public String callWithPhone(PhoneBean k); 
	public String callTwoG(PhoneBean k);
	public String callIphone(PhoneBean k);
	public String callAndroid(PhoneBean k);
	

}
