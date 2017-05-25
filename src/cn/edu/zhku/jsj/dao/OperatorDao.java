package cn.edu.zhku.jsj.dao;

import cn.edu.zhku.jsj.domain.Operator;

public interface OperatorDao {

	int add(Operator operator);

	//运营人员登录
	boolean find(String name, String password);

}