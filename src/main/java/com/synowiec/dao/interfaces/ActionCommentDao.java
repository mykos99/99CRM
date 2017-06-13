package com.synowiec.dao.interfaces;

import com.synowiec.domain.ActionComment;

import java.util.List;

public interface ActionCommentDao {
	
	ActionComment findActionComment(long id);
	List<ActionComment> getAllActionComments();
	void addActionComment(ActionComment actionComment);
	void updateActionComment(ActionComment actionComment);
	void deleteActionComment(ActionComment actionComment);

}
