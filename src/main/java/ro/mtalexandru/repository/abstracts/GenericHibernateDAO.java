//package ro.mtalexandru.repository.abstracts;
//
//import org.hibernate.Criteria;
//import org.hibernate.LockMode;
//import org.hibernate.criterion.Criterion;
//import org.hibernate.criterion.Example;
//import org.hibernate.criterion.Restrictions;
//import org.hibernate.exception.LockAcquisitionException;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by malexandru on 8/22/2016.
// */
//public abstract class GenericHibernateDAO<T, ID extends Serializable> extends AbstractHibernateDAO<T>
//        implements GenericDAO<T,ID> {
//
//    @Override
//    public T findById(ID id){
//        return this.findById(id, false);
//    }
//
//    @Override
//    public List<T> findByIds(Collection<ID> ids){
//       if(ids==null || ids.isEmpty()){
//           return Collections.emptyList();
//       }
//        return findByCriteria(Restrictions.in(getIdentifierProperty(),ids));
//    }
//
//    @Override
//    public T load(ID id){
//        T entity = (T) getSession().load(getPersistentClass(),id);
//        return entity;
//    }
//
//    @Override
//    public T findById(ID id, boolean lock){
//        T entity;
//        if(lock){
//            entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
//        }
//        else {
//            entity = (T) getSession().get(getPersistentClass(), id);
//        }
//        return entity;
//    }
//
//    @Override
//    public T findByIdAndLockNoWait(ID id) {
//        Object obj = getSession().get(getPersistentClass(), id);
//        LockMode lockmode = getSession().getCurrentLockMode(obj);
//
//        if (lockmode == LockMode.NONE || lockmode == LockMode.READ){
//            getSession().lock(obj,LockMode.UPGRADE_NOWAIT);
//        } else {
//            throw new LockAcquisitionException("Object already locked", null);
//        }
//        return (T) obj;
//    }
//
//    @Override
//    public List<T> findAll() {
//        return findByCriteria();
//    }
//
//    @Override
//    public List<T> findByExample (T exampleInstance, String[] excludeProperty) {
//        Criteria criteria = getSession().createCriteria(getPersistentClass());
//        Example example = Example.create(exampleInstance);
//        for (String exclude : excludeProperty){
//            example.excludeProperty(exclude);
//        }
//        criteria.add(example);
//
//        return criteria.list();
//    }
//
//    @Override
//    public void makePersistent(Object entity){
//        synchronized (getSession()) {
//            if(!getSession().contains(entity)){
//                getSession().saveOrUpdate(entity);
//            } else {
//                getSession().merge(entity);
//            }
//        }
//    }
//
//    @Override
//    public void makeTransient(T entity){
//        getSession().delete(entity);
//    }
//
//    @Override
//    public void refresh(T entity) {
//        getSession().refresh(entity);
//    }
//
//    @Override
//    public void flush(T entity) {
//        getSession().flush();
//    }
//
//    @Override
//    public void evict(Object o){
//        getSession().evict(o);
//    }
//
//    protected List<T> findByCriteria(Criterion... criterions){
//        Criteria criteria = getSession().createCriteria(getPersistentClass());
//        for (Criterion c : criterions){
//            criteria.add(c);
//        }
//        return criteria.list();
//    }
//}
