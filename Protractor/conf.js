var Jasmine2HtmlReporter = require('protractor-jasmine2-html-reporter');

exports.config = {
		directConnect : true,
		multiCapabilities: [
	        {
	          'browserName': 'chrome',
	          specs :['./src/allScripts/BankApp.js'] ,
	        }, 
	       /* {
	          'browserName': 'firefox',
	          specs :['./src/allScripts/BankApp.js'] ,
	        }*/
	        ],

		framework : 'jasmine',

		
		
		jasmineNodeOpts : {
			defaultTimeoutInterval : 100000
		},
		onPrepare: function() {
		      jasmine.getEnv().addReporter(
		        new Jasmine2HtmlReporter({
		          savePath: 'target/screenshots',
		          takeScreenshots: true,
		          takeScreenshotsOnlyOnFailures: true
		        })
		      );
		   },
	};


/*// An example configuration file.
exports.config = {
  //directConnect: true,
  seleniumAddress: 'http://localhost:4444/wd/hub',

  // Capabilities to be passed to the webdriver instance.
  capabilities: {
    'browserName': 'chrome'
  },

  // Framework to use. Jasmine is recommended.
  framework: 'jasmine',

  // Spec patterns are relative to the current working directory when
  // protractor is called.
  specs: ['./src/example_spec.js'],

  // Options to be passed to Jasmine.
  jasmineNodeOpts: {
    defaultTimeoutInterval: 30000
  }
};*/