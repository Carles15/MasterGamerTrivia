//package com.mastergamertrivia.game.persistencia.impl.hibernate;
//
//import com.mastergamertrivia.game.dominio.Pregunta;
//import com.mastergamertrivia.game.persistencia.PreguntaDAO;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//import org.hibernate.Query;
//import org.hibernate.Session;
//
//public class PreguntaDAOImplHibernate extends GenericDAOImplHibernate<Pregunta> implements PreguntaDAO{
//
//    @Override
//    public List<Pregunta> batteryGenerator() {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        try {
//            Query controlQuery = session.createSQLQuery("SELECT COUNT(*) FROM preguntas");
//            int questionControl = (int) controlQuery.uniqueResult();
//            
//            List<Integer> idsConsultasAleatorias = new ArrayList<>();
//            
//            Random random = new Random();
//            
//            for (int i = 0; i < 10; i++) {
//                idsConsultasAleatorias.add(random.nextInt(questionControl-0)+1);
//                
//            }
//            Query query = session.createSQLQuery("SELECT * FROM preguntas WHERE id IN ("+idsConsultasAleatorias+")");
//            List<Pregunta> questionsBattery =  query.list();
//            return questionsBattery;
////            //Query query = session.createQuery("SELECT p FROM SucursalBancaria p WHERE entidadPertenece = " + id);
////            
////            Query query = session.createSQLQuery("SELECT p FROM pregunta p limit 10");
////            //List result = query.list();
////            
////            List<Pregunta> a = query.list();
////            return a;
//        } catch (Exception ex) {
//            if (session.getTransaction().isActive()) {
//                session.getTransaction().rollback();
//            }
//            throw new RuntimeException();
//        }
//    }
//    
//}
