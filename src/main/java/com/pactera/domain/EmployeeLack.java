package com.pactera.domain;

import lombok.Data;

@Data
public class EmployeeLack extends Employee{
	private String lackDate;//没打卡的日期
}
