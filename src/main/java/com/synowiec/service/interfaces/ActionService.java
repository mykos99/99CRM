package com.synowiec.service.interfaces;

import com.synowiec.domain.Action;
import com.synowiec.domain.ActionComment;
import com.synowiec.domain.ActionType;

import java.util.List;

public interface ActionService {
	
	Action findActionById(long id);
	List<Action> getAllActions();
	void addAction(Action action);
	void updateAction(Action action);
	void deleteAction(Action action);
	
	ActionType findActionTypeById(long id);
	List<ActionType> getAllActionTypes();
	void addActionType(ActionType actionType);
	void updateActionType(ActionType actionType);
	void deleteActionType(ActionType actionType);
	
	ActionComment findActionCommentById(long id);
	List<ActionComment> getAllActionComments();
	void addActionComment(ActionComment actionComment);
	void updateActionComment(ActionComment actionComment);
	void deleteActionComment(ActionComment actionComment);
	
}