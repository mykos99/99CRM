package com.synowiec.dao.interfaces;

import com.synowiec.domain.Action;

import java.util.List;

public interface ActionDao {
	
	Action findAction(long id);
	List<Action> getAllActions();
	void addAction(Action action);
	void updateAction(Action action);
	void deleteAction(Action action);

}
