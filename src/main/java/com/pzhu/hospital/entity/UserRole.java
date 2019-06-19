package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


/**
 * 
 * @Title: 用户角色表
 * @author: Oldguo
 * @Desc:
 * @date: 2019年5月24日 下午2:47:43
 */
@TableName("tab_User_Role")
public class UserRole extends Model<UserRole> implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId
	private Integer id;
	private String  User_code;
	private Integer Role_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_code() {
		return User_code;
	}

	public void setUser_code(String user_code) {
		User_code = user_code;
	}

	public Integer getRole_id() {
		return Role_id;
	}

	public void setRole_id(Integer role_id) {
		Role_id = role_id;
	}



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
