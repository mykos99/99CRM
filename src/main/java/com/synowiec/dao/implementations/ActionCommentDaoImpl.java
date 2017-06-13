package com.synowiec.dao.implementations;

import com.synowiec.dao.interfaces.ActionCommentDao;
import com.synowiec.domain.ActionComment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("ActionCommentDao")
public class ActionCommentDaoImpl implements ActionCommentDao{

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ActionComment findActionComment(long id){
		return (ActionComment) sessionFactory.getCurrentSession().get(ActionComment.class, id);
	};

	@Override
	public List<ActionComment> getAllActionComments() {
		return sessionFactory.getCurrentSession().createCriteria(ActionComment.class).list();
	};

	@Override
	public void addActionComment(ActionComment actionComment) {
		sessionFactory.getCurrentSession().persist(actionComment);
	};

	@Override
	public void updateActionComment(ActionComment actionComment) {
		sessionFactory.getCurrentSession().update(actionComment);
	};

	@Override
	public void deleteActionComment(ActionComment actionComment) {
		sessionFactory.getCurrentSession().delete(actionComment);
	};
}