package org.houor.spring.datajpa;

import org.houor.spring.datajpa.domain.Product;
import org.houor.spring.datajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class AppTest extends TestCase {

	@Autowired
	ProductService productService;

	ApplicationContext context;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
		context = new ClassPathXmlApplicationContext("application-context.xml");
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void testApp() {

		productService = context.getBean(ProductService.class);

		Product p = new Product();
		p.setName("C#");
		p.setDescription("test");

		productService.save(p);

		assertEquals(2, productService.findByID(Long.valueOf(2)).getId().intValue());

	}

	public void testPageable() {

		productService = context.getBean(ProductService.class);

		Pageable pageable = new PageRequest(0, 2, Direction.DESC, "id");
		Page<Product> productPage = productService.findByName("Java", pageable);
		
		for(Product p : productPage.getContent()) {
			System.out.println(p.getName());
		}

		assertEquals(2, productPage.getSize());
		assertEquals(1, productPage.getTotalPages());
		
		assertEquals(true, productPage.isFirst());
		assertEquals(true, productPage.isLast());
		assertEquals(false, productPage.hasNext());
		assertEquals(false, productPage.hasPrevious());

	}
}
