package com.docsconsole.tutorials.hibernate5;

import java.util.List;

import org.hibernate.Session;

import com.docsconsole.tutorials.hibernate5.entity.Product;
import com.docsconsole.tutorials.hibernate5.entity.ProductDetails;
import com.docsconsole.tutorials.hibernate5.util.HibernateUtil;

public class ProductsManagerClient {

	public static void main(String[] args) {
		System.out.println("main method@ProductsManagerClient");

		Session session = HibernateUtil.getSessionFactory().openSession();

		// obtains the session
		session.beginTransaction();

		// creates a new product
		Product product = new Product();
		// product.setProductId(new Long(101));
		product.setProdName("Angular");
		product.setProdVendor("Google Inc");

		// creates product detail
		ProductDetails details = new ProductDetails();
		// details.setProductId(new Long(101));
		details.setProdName("Angular");
		details.setProdDescription("UI framework");
		details.setProdPrice(new Float(1000));

		// sets the bi-directional association
		product.setProdDetails(details);
		// details.setProduct(product);

		// persists the product
		session.save(product);

		// queries all products
		List<Product> listProducts = session.createQuery("from Product").list();
		for (Product aProd : listProducts) {

			String info = "Product: " + aProd.getProdName() + "\n";
			info += "\tDescription: " + aProd.getProdVendor() + "\n";

			ProductDetails aDetails = aProd.getProdDetails();
			info += "\tProduct Name: " + aDetails.getProdName() + "\n";
			info += "\tProduct Description: " + aDetails.getProdDescription() + "\n";
			info += "\tProduct Price: " + aDetails.getProdPrice() + "\n";

			System.out.println(info);
		}

		session.getTransaction().commit();
		session.close();
	}

}