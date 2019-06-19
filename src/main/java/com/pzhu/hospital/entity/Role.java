package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;


/**
 * 角色表
 *
 */
@TableName("tab_Role")
public class Role extends Model<Role> implements Serializable {
	private static final long serialVersionUID = 1L;
	@TableId
	private Integer id;
	private String Role_name;
	private String Role_sign;
	private String Role_desc;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getRole_name() {
		return Role_name;
	}


	public void setRole_name(String role_name) {
		Role_name = role_name;
	}


	public String getRole_sign() {
		return Role_sign;
	}


	public void setRole_sign(String role_sign) {
		Role_sign = role_sign;
	}


	public String getRole_desc() {
		return Role_desc;
	}


	public void setRole_desc(String role_desc) {
		Role_desc = role_desc;
	}


	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
