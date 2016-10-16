//package ro.mtalexandru.repository.abstracts;
//
//import org.apache.log4j.Logger;
//import org.hibernate.Criteria;
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//
//import java.lang.reflect.ParameterizedType;
//import java.util.List;
//
///**
// * Created by malexandru on 8/22/2016.
// */
//public abstract class AbstractHibernateDAO<T> implements AbstractDAO<T> {
//
//    public static int MAX_SMALL_LIST_SIZE = 1000;
//    final static Logger logger = Logger.getLogger(AbstractHibernateDAO.class);
//    private Class<T> persistentClass;
//
//    @Autowired
//    @Qualifier(value="mySessionFactory")
//    private SessionFactory sessionFactory;
//
//    protected AbstractHibernateDAO(){
//        persistentClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }
//
//    public SessionFactory getSessionFactory() {
//        return sessionFactory;
//    }
//
//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    protected Session getSession() {
//        if (sessionFactory == null){
//            throw new IllegalStateException("SessionFactory has not been set on REPOSITORY before usage");
//        }
//        return sessionFactory.getCurrentSession();
//    }
//
//    protected String getIdentifierProperty(){
//        if (sessionFactory == null){
//            throw new IllegalStateException("SessionFactory has not been set on REPOSITORY before usage");
//        }
//        return sessionFactory.getClassMetadata(getPersistentClass()).getIdentifierPropertyName();
//    }
//
//    public Class<T> getPersistentClass() {
//        return persistentClass;
//    }
//
//    public void setPersistentClass(Class<T> persistentClass) {
//        this.persistentClass = persistentClass;
//    }
//
//    public void flush(){
//        getSession().flush();
//    }
//
//    public void clear(){
//        getSession().clear();
//    }
//
//    @Override
//    public Query getNamedQuery(String queryName) {
//        return getSession().getNamedQuery(queryName);
//    }
//
//    @Override
//    public List<T> list(Query q) {
//        return q.list();
//    }
//
//    @Override
//    public List<T> list(Criteria c) {
//        return c.list();
//    }
//
//    @Override
//    public T uniqueResult(Query q) {
//        return (T) q.uniqueResult();
//    }
//
//    @Override
//    public T uniqueResult(Criteria c) {
//        return  (T) c.uniqueResult();
//    }
//}
