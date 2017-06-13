package com.synowiec.dao.interfaces;

import com.synowiec.domain.ActionType;

import java.util.List;

public interface ActionTypeDao {
	
	ActionType findActionType(long id);
	List<ActionType> getAllActionTypes();
	void addActionType(ActionType actionType);
	void updateActionType(ActionType actionType);
	void deleteActionType(ActionType actionType);

}
