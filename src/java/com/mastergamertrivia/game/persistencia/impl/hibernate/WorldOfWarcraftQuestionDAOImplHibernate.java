package com.mastergamertrivia.game.persistencia.impl.hibernate;

import com.mastergamertrivia.game.dominio.WorldOfWarcraftQuestion;
import com.mastergamertrivia.game.persistencia.WorldOfWarcraftQuestionDAO;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class WorldOfWarcraftQuestionDAOImplHibernate extends GenericDAOImplHibernate<WorldOfWarcraftQuestion> implements WorldOfWarcraftQuestionDAO{

    @Override
    public Long getTotalQuestions() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        

    Criteria criteria = session.createCriteria(WorldOfWarcraftQuestion.class);
    criteria.setProjection(Projections.rowCount());
    Long worldOFWarcraftQuestionsQuantity = (Long) criteria.uniqueResult();
    
    return worldOFWarcraftQuestionsQuantity;
    }
    
}
