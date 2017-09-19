package com.fiona.spring_chat.dao;

import com.fiona.spring_chat.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MessageDAOImpl implements MessageDAO{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Message> getMessages() {
        String hql = "from Message";
        System.out.println("getting messages...");
        return (List<Message>) entityManager.createQuery(hql).getResultList();
    }

    public void saveMessage(Message msg) {
        entityManager.persist(msg);
    }
}
