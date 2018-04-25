var CustomerLogin=function(){

	var customer= element(by.id('userSelect'));
	var loginBtn=element(by.buttonText('Login'));
	
	
	this.SelectCustomer=function(index){
		customer.all(by.tagName('option'))
	      .then(function (options) {
	          options[index].click();
	      });
		return this;
	}
	
	this.Login=function(){
		loginBtn.click();
		var mystr = 'Harry Potter';
		var loginMsg = element(by.cssContainingText('span', mystr));
		expect(loginMsg.getText()).toContain(mystr);
		
		
	}
	var currency=element.all(by.options('account for account in Accounts'));
	this.SelectCurrency=function(index){
		currency.then(function(text) {
	    	text[index].click();
	    	
	    });
		return this;
	}
	

	

}
module.exports=new CustomerLogin();