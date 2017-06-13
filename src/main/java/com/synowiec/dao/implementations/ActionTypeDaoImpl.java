package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.ActionTypeDao;
import com.synowiec.domain.ActionType;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ActionTypeDao")
public class ActionTypeDaoImpl implements ActionTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ActionType findActionType(long id){
		return (ActionType) sessionFactory.getCurrentSession().get(ActionType.class, id);
	};

	@Override
	public List<ActionType> getAllActionTypes() {
		return sessionFactory.getCurrentSession().createCriteria(ActionType.class).list();
	};

	@Override
	public void addActionType(ActionType actionType) {
		sessionFactory.getCurrentSession().persist(actionType);
	};

	@Override
	public void updateActionType(ActionType actionType) {
		sessionFactory.getCurrentSession().update(actionType);
	};

	@Override
	public void deleteActionType(ActionType actionType) {
		sessionFactory.getCurrentSession().delete(actionType);
	};
	
}