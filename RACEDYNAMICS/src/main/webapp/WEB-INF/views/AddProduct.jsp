<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/header.jsp" %>


<div class="container wrapper">
     <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>
            
            <p class="lead">Fill the below information to add the product</p> 
        </div>
        
        <form:form action="${pageContext.request.contextPath}/admin/productInventory/AddProduct" method="post" commandName="product">
        <div class="form-group">
             <label for="name">Name</label>
           <form:input path="productName" id="name" class="form-control"/>
        </div>
        
        <div class="form-group">
            <label for = "category">Category</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="engine"/>Engine</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="suspension"/>Suspension</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="steeringrack"/>SteeringRack</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="tyres"/>Tyres</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="brakepedalsetup"/>BrakePedalSetup</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="differential"/>Differential</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                               value="impactattenuator"/>ImpactAttenuator</label>                                                                                                                                                                                                                                                                                                                  
         </div>
       
       <div class="form-group">
             <label for="description">Description</label>
           <form:textarea path="productDescription" id="description" class="form-control"/>
        </div>
       
        <div class="form-group">
             <label for="price">Price</label>
           <form:input path="productPrice" id="price" class="form-control"/>
        </div>
       
     <div class="form-group">
            <label for = "condition">Condition</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                               value="new"/>New</label>
            <label class = "checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                               value="used"/>Used</label>
      
       </div>
       
        <div class="form-group">
            <label for = "status">Status</label>
            <label class = "checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                               value="available"/>Available</label>
            <label class = "checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                               value="soldout"/>Soldout</label>
       </div>
       
       <div class="form-group">
            <label for = "unitinstock">UnitInStock</label>
            <form:input path="unitinStock" id="unitinstock" class="form-Control"/>
       </div>
       
       <div class="form-group">
            <label for = "manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
       </div>
       
       <div class="form-group">
             <label for="sid">SupplierId</label>
           <form:input path="sid" id="sid" class="form-control"/>
        </div>
       
       <div class="form-group">
             <label for="cid">CategoryId</label>
           <form:input path="cid" id="cid" class="form-control"/>
        </div>
       
       <br><br>
       <input type="submit"  value="submit"  class = "btn btn-default">
       <a href = "/admin/productInventory" class= "btn btn-default">cancel</a>
       
        </form:form>
     </div>
</div>   
        
        <%@include file="/WEB-INF/views/footer.jsp" %>