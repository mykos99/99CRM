package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.ActionDao;
import com.synowiec.domain.Action;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ActionDao")
public class ActionDaoImpl implements ActionDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Action findAction(long id){
		return (Action) sessionFactory.getCurrentSession().get(Action.class, id);
	};

	@Override
	public List<Action> getAllActions() {
		return sessionFactory.getCurrentSession().createCriteria(Action.class).list();
	};

	@Override
	public void addAction(Action action) {
		sessionFactory.getCurrentSession().persist(action);
	};

	@Override
	public void updateAction(Action action) {
		sessionFactory.getCurrentSession().update(action);
	};

	@Override
	public void deleteAction(Action action) {
		sessionFactory.getCurrentSession().delete(action);
	};
	
}