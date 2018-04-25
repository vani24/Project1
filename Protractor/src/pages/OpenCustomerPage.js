var OpenAccount=function(){

	var customer= element(by.id('userSelect'));
	var currency=element(by.id('currency'));
	var process=element(by.buttonText('Process'));
	
	this.SelectCustomer=function(index){
		customer.all(by.tagName('option'))
	      .then(function (options) {
	          options[index].click();
	      });
		return this;
	}
	this.SelectCurrency=function(index){
		currency.all(by.tagName('option'))
	      .then(function (options) {
	          options[index].click();
	      });
		return this;
	}
	
	this.clickNext=function(){
		process.click();
	}
	this.acceptAlert=function(){
		 var alertDialog = browser.switchTo().alert();
		 expect(alertDialog.getText()).toContain("Account created successfully with account Number :");
		 alertDialog.accept();
		
	}

}
module.exports=new OpenAccount();