package com.model;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
public class HibernateCriteriaExample {

	
	  @SuppressWarnings("unchecked")
	public static void main(String[] args) {
	  SessionFactory sessionFactory = HBUtil.getSessionFactory();
	  Session session = sessionFactory.getCurrentSession();
	  Transaction tx = session.beginTransaction();
	  
	  Criteria criteria = session.createCriteria(Sales.class);
	  List<Sales> prodList = criteria.list();
	  for(Sales pr :prodList) {
		  System.out.println("Product Table="+pr.getSINO()+pr.getPname()+pr.getQty()+pr.getPrice());
	  }
	  
	 prodList = session.createCriteria(Sales.class).add(Restrictions.gt("price", 500f)).list();
		  for(Sales pr :prodList) {
			  System.out.println("Produt price greater than 500="+pr.getSINO()+pr.getPname()+pr.getQty()+pr.getPrice());
		  }
	 
		  prodList = session.createCriteria(Sales.class).add(Restrictions.gt("qty",10)).list();
				  for(Sales pr :prodList) {
					  System.out.println("Product quantity greater than 10 ="+"\t"+pr.getSINO()+"\t"+pr.getPname()+"\t"+pr.getQty()+"\t"+pr.getPrice());
				  }
				  
					 		  
		Criteria d=session.createCriteria(Sales.class);
		prodList=d.setProjection(Projections.count("SINO")).list();
		System.out.println("*******************************************************************************");
		System.out.println("No.of products available="+prodList.get(0));
		Criteria e=session.createCriteria(Sales.class);
		prodList=e.setProjection(Projections.max("price")).list();
		System.out.println("*******************************************************************************");
		System.out.println("Maximum price in price list="+prodList.get(0));
		Criteria f=session.createCriteria(Sales.class);
		prodList=f.setProjection(Projections.min("SINO")).list();
		System.out.println("*******************************************************************************");
		System.out.println("Minimum price in price list="+prodList.get(0));
		Criteria g=session.createCriteria(Sales.class);
		prodList=g.setProjection(Projections.sum("price")).list();
		System.out.println("*******************************************************************************");
		System.out.println("Sum fo Price="+prodList.get(0));
		System.out.println("*******************************************************************************");
		tx.commit();
		sessionFactory.close();


			 
		  
		  
		  
		  
	}

}
