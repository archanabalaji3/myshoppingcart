package com.niit.shoppingcart.daoimpl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

//another annotation...
@Transactional
@Repository("categoryDAO") // will create instance of CategoryDAOImpl and the name will categoryDAO
public class CategoryDAOimpl implements CategoryDAO {
	// first - inject hibernate session.
		// @Autowire

		@Autowired(required=true) // session factory will automatically inject in this class
		private SessionFactory sessionFactory;

		@Autowired(required=true)
		private Category category;

		//
		public boolean save(Category category) {
			// store in the database.
			try {
				sessionFactory.getCurrentSession().save(category);
				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}

		}

		public boolean update(Category category) {
			try {
				sessionFactory.getCurrentSession().update(category);
				return true;
			} catch (HibernateException e) {
			e.printStackTrace();
				return false;
			}

		}

		public Category get(String id) {
			// it will fetch the record based on emailID and store in Category class
			return sessionFactory.getCurrentSession().get(Category.class,id);

		}

		public boolean delete(String id) {
			try {
				category = get(id);
				if (category == null) {
					return false;
				}

				sessionFactory.getCurrentSession().delete(category);

				return true;
			} catch (HibernateException e) {
				e.printStackTrace();
				return false;
			}

		}
		@SuppressWarnings("unchecked")
		public List<Category> list() {
			return	sessionFactory.getCurrentSession().createQuery("from Category").list();
			}


}
