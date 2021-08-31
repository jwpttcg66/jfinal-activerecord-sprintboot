package com.snowcattle.jfinaldemo.jfinal;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.druid.DruidPlugin;
import com.snowcattle.jfinaldemo.jfinal.model.Emp;
import com.snowcattle.jfinaldemo.jfinal.model.EmpBalance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JfinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JfinalApplication.class, args);
		doTest();
	}

	public static void doTest(){
		DruidPlugin dp = new DruidPlugin("jdbc:mysql://192.168.1.110:3306/jfinal?characterEncoding=utf8&useSSL=false", "root", "123456");
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);

		_MappingKit.mapping(arp);
		// 与web环境唯一的不同是要手动调用一次相关插件的start()方法
		dp.start();
		arp.start();

		new Emp().set("name", "3")
				.set("age", 10).save();

		Emp emp = Emp.dao.findByIdLoadColumns("3", "name,age,id");
		System.out.println(emp.getStr("name"));

//		Record emp2 = Db.use("biz").findFirst("select * from emp where id = 1");
//		System.out.println(emp2.getStr("name"));
//
//		Emp emp3 = new Emp().use("biz").findById(1);
//		System.out.println(emp3.getStr("name"));

		new EmpBalance().set("emp_id", 2)
				.set("balance", 10).save();
	}

}
