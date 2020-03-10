package com.spring.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.Junior;

@Transactional
@Repository
public class JuniorDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Junior> getJuniorList() {
		List<Junior> list = new ArrayList<>();
		Date date = null;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"select u.first_name,u.last_name,u.email,j.department,j.batch,u.date_of_birth from junior j inner join user u where u.user_id=j.user_id");

		List<Object[]> lis = query.list();
		for (Object[] obj : lis) {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
			System.out.println(obj[3]);
			System.out.println(obj[4]);
			System.out.println(obj[5]);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(obj[5].toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Junior junior = new Junior();
			junior.setFirstName(obj[0].toString());
			junior.setLastName(obj[1].toString());
			junior.setEmail(obj[2].toString());
			junior.setDepartment(obj[3].toString());
			junior.setBatch(Integer.parseInt(obj[4].toString()));
			junior.setDateOfBirth(date);
			list.add(junior);

		}

		return list;

	}

}
