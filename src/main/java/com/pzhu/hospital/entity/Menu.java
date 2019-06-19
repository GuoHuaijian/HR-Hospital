package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * @Title: 菜单表
 * @author: Oldguo
 * @Desc:
 * @date: 2019年5月24日 下午3:05:01
 */
@TableName("tab_menu")
public class Menu  extends Model<UserRole> implements Serializable{

	@TableId
	private Integer id;
	private Integer parent_id;
	private Integer permis_id;
	private String  menu_type;
	private String  menu_name;
	private String  menu_url;
	private Integer  menu_order;
	private String  menu_flag;
	private String  menu_icon;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getParent_id() {
		return parent_id;
	}


	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}


	public Integer getPermis_id() {
		return permis_id;
	}


	public void setPermis_id(Integer permis_id) {
		this.permis_id = permis_id;
	}


	public String getMenu_type() {
		return menu_type;
	}


	public void setMenu_type(String menu_type) {
		this.menu_type = menu_type;
	}


	public String getMenu_name() {
		return menu_name;
	}


	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}


	public String getMenu_url() {
		return menu_url;
	}


	public void setMenu_url(String menu_url) {
		this.menu_url = menu_url;
	}


	public Integer getMenu_order() {
		return menu_order;
	}


	public void setMenu_order(Integer menu_order) {
		this.menu_order = menu_order;
	}


	public String getMenu_flag() {
		return menu_flag;
	}


	public void setMenu_flag(String menu_flag) {
		this.menu_flag = menu_flag;
	}


	public String getMenu_icon() {
		return menu_icon;
	}


	public void setMenu_icon(String menu_icon) {
		this.menu_icon = menu_icon;
	}


	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
