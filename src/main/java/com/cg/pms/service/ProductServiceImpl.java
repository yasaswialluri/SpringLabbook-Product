package com.cg.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.pms.dao.ProductDao;
import com.cg.pms.entity.Product;
import com.cg.pms.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService{

	  @Autowired
	  ProductDao  productDao;
	@Override
	public Product findProductById(int productId) throws ProductException  {
		
		if( ! productDao.existsById(productId))
		{
			throw new ProductException(" ID NOT FOUND ");
		}
		return productDao.findById(productId).get();
	}
	@Override
	public Product createProduct(Product product) {
	 Product  p= productDao.saveAndFlush(product);
     return p;
	}
	@Override
	public List<Product> findAllProduct() throws ProductException {
        
		List<Product> list = productDao.findAll();
		return list;
	}
	@Override
	public Product deleteProductById(int productId) throws ProductException {
Product  p =null;
		
		if( productDao.existsById(productId))
		{
			 p = productDao.findById(productId).get();
			 productDao.deleteById(productId);
		}
		else
		{
			throw new ProductException(" ID NOT FOUND ");
		}
		return p ;
	}
	
	@Override
	public Product updateProduct(Product product) 
			throws ProductException {
		int id = product.getProductId();
		Product  p=null;
		if( productDao.existsById(id))
		{
			p=productDao.saveAndFlush(product);
		}
		else
		{
			throw new ProductException(" ID NOT FOUND ");
		}
		return p;
	}
	@Override
	public int countProduct() {
		
		return (int) productDao.count();
	}
	
}