package com.ljp.action;

import java.util.List;

import com.ljp.biz.UserBIZ;
import com.ljp.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	
	UserBIZ userBIZ;
	List<User> userList;
	
		public String execute() throws Exception{
			userList=userBIZ.findAll();
			return SUCCESS;
		}
		public UserBIZ getUserBIZ() {
			return userBIZ;
		}

		public void setUserBIZ(UserBIZ userBIZ) {
			this.userBIZ = userBIZ;
		}

		public List<User> getUserList() {
			return userList;
		}

		public void setUserList(List<User> userList) {
			this.userList = userList;
		}
}
