package com;

import java.util.Iterator;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class Employee 
{
	JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	public void create()
	{
	   jt.execute("create table employee(eid int(3),ename varchar(20),sal float(10))");
	   System.out.println("table created");
	}
	public void insert()
	{
		int k=jt.update("insert into employee values(4,'arun',7000)");
		System.out.println(k);
	}
	public void select()
	{
		List li=jt.queryForList("select * from employee");
		Iterator it=li.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}	
		public void update()
		{
			int i =jt.update("update employee set ename='Anand Vaibhav' where eid = 4");
			System.out.println(i);
		}
		public void load()
		{
		 //Integer s1=(Integer)jt.queryForObject("select eid from employee", Integer.class);
		//Float s1=(Float)jt.queryForObject("select sal from employee",Float.class);
			String s1=(String)jt.queryForObject("select ename from employee",String.class);
			System.out.println(s1);
	}
		public void delete()
		{
			int k=jt.update("delete from employee where eid=1");
			System.out.println(k);
		}
		public void count()
		
		{
			int c = jt.queryForInt("select count(*)from employee");
			System.out.println(c);
		}
}
