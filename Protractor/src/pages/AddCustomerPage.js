var AddCustomer=function(){
	
	var fname=element(by.model('fName'));
	var lname=element(by.model('lName'));
	var pcode=element(by.model('postCd'));
	var addCustomer=element.all(by.partialButtonText('Add'));
	
	this.firstName=function(fName){
		fname.sendKeys(fName);
		return this;
	}
	this.lastName=function(lName){
		lname.sendKeys(lName);
		return this;
	}
	this.postCode=function(pCode){
		pcode.sendKeys(pCode);
		return this;
	}
	this.clickNext=function(){
		addCustomer.get(1).click();
	}
	this.acceptAlert=function(){
		 var alertDialog = browser.switchTo().alert();
		 expect(alertDialog.getText()).toContain("Customer added successfully with customer id :");
		 alertDialog.accept();
	}
}
var val1='Dollar';
var val2='Pound';
var val3='Rupee';
/*var curr = element.all(by.className('ng-binding'));
var cu=curr.get(3).getText();	
    
	if(curr=='Dollar'){
		expect(cu).toEqual('Dollar');	
	}else if(curr=='Pound'){
		expect(cu).toEqual('Pound');
	}else if(curr=='Rupee'){
		expect(cu).toEqual('Rupee');
	}
	*/


module.exports=new AddCustomer();