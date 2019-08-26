package com.bitcamp.domains;
/*
 *생산자 이름은 company <생산자명, 통화내용, 수신자>받는 내용!!
 *통화내용은 call
 *수신자 receiver
 *문자 text
 *검색 search
 *전화기 상태는 KIND ->상수 : 아이폰
 *나는 {금성}에서 만든{아이폰}를 사용해서 {구글}에게 {뉴스}를 검색후
 *길동에게 문자를 보냈다. 
 */

public class IphoneBean extends PhoneBean {
	private String search;

	public final static String KIND ="아이폰";


	public void setSearch(String search) {
		this.setSearch(search);
	}
	public String getSearch() {
		return search;
	}
	
	@Override
		public String toString() {
			return String.format("나는 %s에서 만든 %s 를 사용해서 %s 뉴스를 %s 검색후", 
					super.getCompany(), KIND , super.getRecevier(),search);
	
		}
}
