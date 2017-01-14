package com.twoTableManipulation.workingSets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_twotable_table1")
public class TwoTableEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer tableId;
	private String name;
	private String code;
	public TwoTableEntity() {
		
	}
	public TwoTableEntity(String name, String code) {
//		super();
		this.name = name;
		this.code = code;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "TwoTableEntity [tableId=" + tableId + ", name=" + name + ", code=" + code + ", getTableId()="
				+ getTableId() + ", getName()=" + getName() + ", getCode()=" + getCode() + "]";
	}
	
	
	

}
