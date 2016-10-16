//package ro.mtalexandru.repository.abstracts;
//
//import java.io.Serializable;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by malexandru on 8/22/2016.
// */
//public interface GenericDAO<T, ID extends Serializable> extends AbstractDAO<T> {
//    T load(ID id);
//
//    T findById(ID id, boolean lock);
//
//    T findById(ID id);
//
//    List<T> findByIds(Collection<ID> ids);
//
//    T findByIdAndLockNoWait(ID id);
//
//    List<T> findAll();
//
//    List<T> findByExample(T exampleInstance, String[] excludeProperty);
//
//    void makePersistent(Object entity);
//
//    void makeTransient(T entity);
//
//    void refresh(T entity);
//
//    void flush();
//
//    void evict(Object o);
//
//}
