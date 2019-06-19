package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Title: 权限表
 * @author: Oldguo
 * @Desc:
 * @date: 2019年5月24日 下午2:52:02
 */
@TableName("tab_permis")
public class Permis extends Model<Permis> implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@TableId
	private Integer id;
	private String  Permission_name;
	private String  Permission_sign;
	private String  Permission_desc;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermission_name() {
		return Permission_name;
	}

	public void setPermission_name(String permission_name) {
		Permission_name = permission_name;
	}

	public String getPermission_sign() {
		return Permission_sign;
	}

	public void setPermission_sign(String permission_sign) {
		Permission_sign = permission_sign;
	}

	public String getPermission_desc() {
		return Permission_desc;
	}

	public void setPermission_desc(String permission_desc) {
		Permission_desc = permission_desc;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
