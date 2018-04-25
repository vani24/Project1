var data=require(process.cwd()+'/src/utility/BankData.json')
var addCustomer=require(process.cwd()+'/src/pages/AddCustomerPage.js')
var openCustomer=require(process.cwd()+'/src/pages/OpenCustomerPage.js')
var deleteCustomer=require(process.cwd()+'/src/pages/DeleteCustomerPage.js')
var customerLogin=require(process.cwd()+'/src/pages/CustomerLoginPage.js')


describe('Bank XYZ automation', function() {
	beforeEach(function() {
		browser.get(data.url);
		var cusLoginBtn=element(by.partialButtonText('Customer'));
		var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		expect(cusLoginBtn.getText()).toBe('Customer Login');
		expect(bankMangLoginBtn.getText()).toBe('Bank Manager Login');
    });
	it('ManagerLoginPage flow', function() {
	
		var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		bankMangLoginBtn.click();
		var addCustomerBtn=element(by.partialButtonText('Add')).getText();
		var openAccBtn=element(by.partialButtonText('Open')).getText();
		var customerBtn=element(by.buttonText('Customers')).getText();
		expect(addCustomerBtn).toBe('Add Customer');
		expect(openAccBtn).toBe('Open Account');
		expect(customerBtn).toBe('Customers')
		/**/
		//var managerLoginPage=managerLogin.clickNext();
	    browser.sleep(4000);
	});
	it('AddCustomer flow', function() {
		
		var bankMangLoginBtn=element(by.partialButtonText('Bank Manager')).click();
	    var addCustomerBtn=element(by.partialButtonText('Add')).click();
	    addCustomer.firstName(data.customerData.firstName);
	    addCustomer.lastName(data.customerData.lastName);
	    addCustomer.postCode(data.customerData.postcode);
		addCustomer.clickNext();
		addCustomer.acceptAlert();
		
	    browser.sleep(4000);
	});
	
  it('OpenCustomerDoller flow', function() {
		
	  var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		bankMangLoginBtn.click();
		var openAccBtn=element(by.partialButtonText('Open')).click();
		openCustomer.SelectCustomer(2);
		openCustomer.SelectCurrency(1);
		openCustomer.clickNext();
		openCustomer.acceptAlert();
		
	    browser.sleep(4000);
	});
  
  it('OpenCustomerPound flow', function() {
		
	  var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		bankMangLoginBtn.click();
		var openAccBtn=element(by.partialButtonText('Open')).click();
		openCustomer.SelectCustomer(3);
		openCustomer.SelectCurrency(2);
		openCustomer.clickNext();
		openCustomer.acceptAlert();
		
	    browser.sleep(4000);
	});
  
  it('OpenCustomerRupees flow', function() {
		
	  var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		bankMangLoginBtn.click();
		var openAccBtn=element(by.partialButtonText('Open')).click();
		openCustomer.SelectCustomer(4);
		openCustomer.SelectCurrency(3);
		openCustomer.clickNext();
		openCustomer.acceptAlert();
	    browser.sleep(4000);
	});
  it('DeleteCustomer flow', function() {
		
	  var bankMangLoginBtn=element(by.partialButtonText('Bank Manager'));
		bankMangLoginBtn.click();
		var customerBtn=element(by.buttonText('Customers')).click();
		deleteCustomer.searchName(data.customerData.firstName);
		deleteCustomer.clickNext();
	    browser.sleep(4000);
	});
  
  it('CustomerLogin flow', function() {
		
	    var cusLoginBtn=element(by.partialButtonText('Customer')).click();
	    customerLogin.SelectCustomer(2);
	    customerLogin.Login();
	    browser.sleep(4000);
	    customerLogin.SelectCurrency(1);
	    browser.sleep(4000);
	    customerLogin.SelectCurrency(2);
	    browser.sleep(4000);
	    customerLogin.SelectCurrency(3);
	    browser.sleep(4000);
	
	});
  
  
  
  afterEach(function() {
	console.log("test script completed");
});

});