package com.cg.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.pms.entity.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;

@RestController
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("product/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id") int id) throws ProductException {

		Product p = productService.findProductById(id);
		ResponseEntity<Product> re = new ResponseEntity<Product>(p, HttpStatus.OK);
		return re;
	}
	@PostMapping("product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product p= productService.createProduct(product);
		ResponseEntity<Product> re = new ResponseEntity<Product>(p, HttpStatus.OK);
		return re;
	}

	@GetMapping("product/count")
	public ResponseEntity<String> countProduct()
	{
		int  count = productService.countProduct();
		String str="Number of Products = "+count;
		ResponseEntity<String> re =
				new ResponseEntity<String>(str,HttpStatus.OK);
		return re;
	}
	@PutMapping("product")
	public ResponseEntity<Product> updateEmployee(@RequestBody Product product) 
	throws ProductException
	{
		Product p = productService.updateProduct(product);
		ResponseEntity<Product> re = new ResponseEntity<Product>(p, HttpStatus.OK);
		return re;
	}

	@GetMapping("product")
	public ResponseEntity<List<Product>> findAllProduct() throws ProductException {

		List<Product> list = productService.findAllProduct();
		ResponseEntity<List<Product>> rt = new ResponseEntity<List<Product>>(list, HttpStatus.OK);
		return rt;

	}

	@DeleteMapping("product/{id}")
	public ResponseEntity<Product> deleteProductById(@PathVariable("id") int productId) throws ProductException {

		ResponseEntity<Product> rt = null;

		Product product = productService.deleteProductById(productId);
		rt = new ResponseEntity<Product>(product, HttpStatus.OK);

		return rt;
	}

}
