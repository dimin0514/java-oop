package com.bitcamp.serviceimpls;

import com.bitcamp.domains.MemberBean;
import com.bitcamp.services.AdminService;

public class AdminServiceImpl implements AdminService{
	private MemberBean[] members;
	private int count;
	
	public AdminServiceImpl() {
		members = new MemberBean[10];
		count = 0;
	}
	

	@Override
	public String list() {
		String msg = "회원목록";
		for(int i=0;i<count; i++) {
			msg+= members[i].toString()+",\n";
		}
		return msg;
	}

	@Override
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

	@Override
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
			
			//member = members[i]; c
		}
		return members;
		
	}

	@Override
	public String countAll() {
		//String numbers = String.valueOf(count);
		//return numbers;
		//return "총회원수"+count;
		return String.valueOf(count);
	}

}
