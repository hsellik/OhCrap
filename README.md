ohcrap  
========  
###Instructions for current use  
1)run "py -m http.server" in partials folder (you need to have python installed for that)  
  
###Making war package for tomcat  
1)open command prompt in project root  
2)run "mvn package"  
  
###TODO: installing dependencies  
1)open command prompt in project root  
2)run "npm install"  
3)run "bower install"  
4)exclude "node_modules" and "bower_components" from git  
  
###Future Technology stack  

1. Spring 3.2. Going to implement REST service with JSON payload and use spring-test for integration tests.  
1. AngularJS 1.2. Minimalist, for single page app and consuming rest service.  
1. MySQL Database on localhost  
  
Additionally, this project contains no XML. Spring config is fully annotation driven and the web.xml is omitted per Servlet 3.0 spec.  
  
###Resources  
  
* http://www.rockhoppertech.com/blog/spring-mvc-configuration-without-xml/
* http://www.java-allandsundry.com/2012/11/spring-test-mvc-with-spring-32rc1.html
* http://www.petrikainulainen.net/programming/spring-framework/unit-testing-of-spring-mvc-controllers-normal-controllers/
* http://www.javacodegeeks.com/2012/10/junit-testing-spring-service-and-dao.html
