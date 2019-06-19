package com.pzhu.hospital.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * 加班表
 * @author ZHT
 *
 */
@TableName("overtime")
public class Overtime extends Model<Overtime> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@TableId(type= IdType.AUTO)
	private Integer id;
	private Integer departmentNumber;
	private Integer employeeNumber;
	private Date day;
	private Date startTime;
	private Date endTime;
	private String notes;


    @TableField(exist = false)
	private String date;
	@TableField(exist=false)
	private Employee employee;
	@TableField(exist=false)
	private Department department;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(Integer departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public Integer getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
	
	@Override
	protected Serializable pkVal() {
		return this.id;
	}

    @Override
    public String toString() {
        return "Overtime{" +
                "id=" + id +
                ", departmentNumber=" + departmentNumber +
                ", employeeNumber=" + employeeNumber +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", notes='" + notes + '\'' +
                ", date='" + date + '\'' +
                ", employee=" + employee +
                ", department=" + department +
                '}';
    }
}
