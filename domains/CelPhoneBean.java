package com.bitcamp.domains;
	/*
	 *생산자 이름은 company <생산자명, 통화내용, 수신자>받는 내용!!
	 *통화내용은 call
	 *수신자 receiver
	 *문자 text
	 *전화기 상태는 KIND ->상수 : 셀럴로폰
	 *나는 {금성}에서 만든{집전화기}를 사용해서 {길동}에게 {안녕} 이라고 문자했다. tostring에 찍힘 
	 */
public class CelPhoneBean extends PhoneBean{
	
	public final static String KIND ="셀럴러폰";
	private String text;
	
	public void setText(String text) {
		this.text = text;
	}
	public String getText() {
		return text;
	}
	
	
	@Override
		public String toString() {
			return String.format("나는 %s에서 만든 %s 를 사용해서 %s %s에게 %s라고 문자했다.",
			super.getCompany(), KIND, super.getRecevier(), super.getCall());          
	}			// super 는 생략이 가능.  super나 this 나 같은논리로 이해.
	 			//private은 자기자신한테밖에 상속은 백터 public 을 가져와야함

}
