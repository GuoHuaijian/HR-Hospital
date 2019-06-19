package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Title: 角色权限表
 * @author: Oldguo
 * @Desc:
 * @date: 2019年5月24日 下午3:01:50
 */
@TableName("tab_Role_Permis")
public class RolePermis extends Model<UserRole> implements Serializable{
	private static final long serialVersionUID = 1L;
	@TableId
	private Integer id;
	private Integer Permis_id;
	private Integer Role_id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPermis_id() {
		return Permis_id;
	}

	public void setPermis_id(Integer permis_id) {
		Permis_id = permis_id;
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
