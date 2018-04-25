var DeleteCustomer=function(){
	
	var name=element(by.model('searchCustomer'));
	var deleteBtn=element(by.buttonText('Delete'));
	
	this.searchName=function(sname){
		name.sendKeys(sname);
		return this;
	}
	
	this.clickNext=function(){
		deleteBtn.click();
	}
	
}
module.exports=new DeleteCustomer();