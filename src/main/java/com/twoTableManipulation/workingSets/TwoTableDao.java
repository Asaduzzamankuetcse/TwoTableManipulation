package com.twoTableManipulation.workingSets;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class TwoTableDao {
	@Autowired
	SessionFactory _sessionFactory;
	private Session getSession(){
		return _sessionFactory.getCurrentSession();
	}
	
	
	public void saveForm(TwoTableEntity twoTableEntity) {
		getSession().saveOrUpdate(twoTableEntity);
		
	}

}
