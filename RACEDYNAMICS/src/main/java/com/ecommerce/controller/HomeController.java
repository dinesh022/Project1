package com.ecommerce.controller;



import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ecommerce.dao.CategoryDao;
import com.ecommerce.dao.ProductDao;
import com.ecommerce.dao.SupplierDao;
import com.ecommerce.dao.UserDao;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Supplier;
import com.ecommerce.model.Users;





@Controller
public class HomeController {
	

	
 @Autowired
private ProductDao productDao;
 @Autowired
 private UserDao userDao;
 @Autowired
 private SupplierDao supplierDao;
 @Autowired
 private CategoryDao categoryDao;
 

 
 

	@RequestMapping("/")
	public String home(){
		return "home";
	}
    
	
	
	@RequestMapping(value="/Register", method=RequestMethod.GET)
	public String  toregister(Model  m)
	{
		m.addAttribute("users",new Users()) ;
		 
		 return "Register";
}
	
	@RequestMapping(value="saveUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute("users") Users users){
		userDao.saveUser(users);
		return "redirect:/";
}
	
	
	
	
	@RequestMapping("/productList")
	public String getProducts(Model model){
		List<Product>products = productDao.getAllProducts();
		model.addAttribute("products", products);
		return "productList";
				
	}

    @RequestMapping("/productList/viewproduct/{productId}")
    public String viewproduct(@PathVariable String productId, Model model)throws IOException{
    	Product product = productDao.getProductById(productId);
    	model.addAttribute(product);
    	return "viewproduct";
    }

    @RequestMapping("/admin")
    public String adminPage(){
    	return "admin";
    }

    @RequestMapping("/admin/productInventory")
    public String productInventory(Model model){
    	List<Product>products = productDao.getAllProducts();
    	model.addAttribute("products", products);
    	return "productInventory";
    }

  

   
    
    @RequestMapping(value="/admin/productInventory/AddProduct", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("product")Product product){
    	productDao.addProduct(product);
    	return "redirect:/admin/productInventory";
    }
    
    @RequestMapping("/admin/productInventory/deleteProduct{id}")
    public String deleteProduct(@PathVariable String id, Model model){
    	productDao.deleteProduct(id);
    	return "redirect:/admin/productInventory";
    }
    
    
    @RequestMapping(value="/supplier",method=RequestMethod.GET)
    public String showSupplier(@ModelAttribute("supplier")Supplier supplier, BindingResult result, Model m, RedirectAttributes redirectAttrs  )
    {
       List<Supplier> listsupplier= supplierDao.getAllSupplier();    
        m.addAttribute("supplierlist",listsupplier);
       
        m.addAttribute("SupplierPageClicked", "true");
        return "supplier";
     
}
	
    @RequestMapping(value="AddSupplier",method=RequestMethod.POST)
    public String addSupplier(@ModelAttribute("supplier")Supplier supplier,Model m)
    {
        supplierDao.addSupplier(supplier);
                  
        return "redirect:/supplier";
}

    @RequestMapping("editsupplier/{sid}")
	public String editSupplier(@PathVariable("sid") int sid, Model model,RedirectAttributes attributes) {
		System.out.println("editsupplier");
		attributes.addFlashAttribute("supplier", this.supplierDao.getSupplierById(sid));
		return "redirect:/supplier";
	}

	@RequestMapping(value = "deletesupplier/{sid}")
	public String removeSupplier(@PathVariable("sid") int sid,RedirectAttributes attributes) throws Exception {supplierDao.deleteSupplier(sid);
		attributes.addFlashAttribute("DeleteMessage", "supplier has been deleted Successfully");
		return "redirect:/supplier";
}

	


	@RequestMapping(value="/category",  method=RequestMethod.GET)
    public String listOfCategory(@ModelAttribute("category") Category category,  BindingResult result, Model model, RedirectAttributes redirectAttrs) {
       
	 List<Category> listCategory=categoryDao.getAllCategory();	    
         model.addAttribute("categoryList",listCategory);
         model.addAttribute("CategoryPageClicked", "true");
         return "category";
	
         }     
	
	
	@RequestMapping(value="AddCategory",method=RequestMethod.POST)
    public String addCategory(@ModelAttribute("category")Category category,Model m)
    {
        categoryDao.addCategory(category);
                  
        return "redirect:/category";
}
	
	
	@RequestMapping("editcategory/{cid}")
	public String editCategory(@PathVariable("cid") int cid, Model model,RedirectAttributes attributes) {
		System.out.println("editCategory");
		attributes.addFlashAttribute("category", this.categoryDao.getCategoryById(cid));
		return "redirect:/category";
	}
                                                      
	@RequestMapping(value ="deletecategory/{cid}")
	public String removeCategory(@PathVariable("cid") int cid,RedirectAttributes attributes) throws Exception {
		categoryDao.deleteCategory(cid);
		attributes.addFlashAttribute("DeleteMessage", "Category has been deleted Successfully");
		return "redirect:/category";
}
	
	
}


