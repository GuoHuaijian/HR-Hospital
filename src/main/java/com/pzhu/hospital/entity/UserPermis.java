package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Title:用户权限表
 * @author: Oldguo
 * @Desc:
 * @date: 2019年5月24日 下午2:57:01
 */
@TableName("tab_User_Permis")
public class UserPermis extends Model<UserPermis> implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String  User_code;
	private Integer Permis_id;
	
	
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


	public Integer getPermis_id() {
		return Permis_id;
	}


	public void setPermis_id(Integer permis_id) {
		Permis_id = permis_id;
	}


	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
