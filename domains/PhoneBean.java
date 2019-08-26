package com.bitcamp.domains;
/*
 *생산자 이름은 company <생산자명, 통화내용, 수신자>받는 내용!!
 *통화내용은 call
 *전화번호 number
 *수신자 receiver
 *전화기 상태는 KIND ->상수 : 집전화기, 2G폰, 아이폰, 안드로이드폰
 *나는 {금성}에서 만든{집전화기}를 사용해서 {길동}에게 {안녕} 이라고 통화했다. tostring 찍힘 
 */
public class PhoneBean {
	private String company, call, receiver;         //pojo 객체의 은닉화!!
	public final static String KIND ="집전화기";
	
	public void setCompany(String company) {   //컨트롤러에서 set 한개 들어옴.
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	public void setCall(String call) {
		this.call=call;
	}
	public String getCall() {
		return call;
	}
	public void setReceiver(String receiver) {
		this.receiver=receiver;
	}
	public String getRecevier() {
		return receiver;
	}
	
	@Override   //최상위 객체 상속
		public String toString() {
			return String.format("나는 %s에서 %s를 사용해서 %s애개 %s이라고 통화했다",
					company, KIND, receiver, call);
		}
}
