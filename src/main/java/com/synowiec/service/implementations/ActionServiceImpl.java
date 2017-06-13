package com.synowiec.service.implementations;

import com.synowiec.dao.interfaces.ActionCommentDao;
import com.synowiec.dao.interfaces.ActionDao;
import com.synowiec.dao.interfaces.ActionTypeDao;
import com.synowiec.domain.Action;
import com.synowiec.domain.ActionComment;
import com.synowiec.domain.ActionType;
import com.synowiec.service.interfaces.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ActionService")
public class ActionServiceImpl implements ActionService {

    @Autowired
    ActionDao actionDao;
    @Autowired
    ActionTypeDao actionTypeDao;
    @Autowired
    ActionCommentDao actionCommentDao;

    @Override
    @Transactional
    public Action findActionById(long id) {
        return actionDao.findAction(id);
    }

    @Override
    @Transactional
    public List<Action> getAllActions() {

        return actionDao.getAllActions();
    }

    @Override
    @Transactional
    public void addAction(Action action) {

        actionDao.addAction(action);
    }

    @Override
    @Transactional
    public void updateAction(Action action) {

        actionDao.addAction(action);
    }

    @Override
    @Transactional
    public void deleteAction(Action action) {

        actionDao.deleteAction(action);
    }

    @Override
    @Transactional
    public ActionType findActionTypeById(long id) {

        return actionTypeDao.findActionType(id);
    }

    @Override
    @Transactional
    public List<ActionType> getAllActionTypes() {

        return actionTypeDao.getAllActionTypes();
    }

    @Override
    @Transactional
    public void addActionType(ActionType actionType) {

        actionTypeDao.addActionType(actionType);
    }

    @Override
    @Transactional
    public void updateActionType(ActionType actionType) {

        actionTypeDao.updateActionType(actionType);
    }

    @Override
    @Transactional
    public void deleteActionType(ActionType actionType) {

        actionTypeDao.deleteActionType(actionType);
    }

    @Override
    @Transactional
    public ActionComment findActionCommentById(long id) {

        return actionCommentDao.findActionComment(id);
    }

    @Override
    @Transactional
    public List<ActionComment> getAllActionComments() {

        return actionCommentDao.getAllActionComments();
    }

    @Override
    @Transactional
    public void addActionComment(ActionComment actionComment) {

        actionCommentDao.addActionComment(actionComment);
    }

    @Override
    @Transactional
    public void updateActionComment(ActionComment actionComment) {

        actionCommentDao.updateActionComment(actionComment);
    }

    @Override
    @Transactional
    public void deleteActionComment(ActionComment actionComment) {

        actionCommentDao.deleteActionComment(actionComment);
    }
}
