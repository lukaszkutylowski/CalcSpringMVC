# **CalcSpringMVC**

This is a web application which is a simple version of calculator executed in web browser.
Calculations are performed on the server side, data input and output is performed in a web browser.

## Used technologies:
* Java SE
* Spring MVC
* OOP
* JSP
* JSTL
* XML
* HTML
* CSS
* Spring Tool Suite STS

## Description

*web.xml* it is a configuration file, where we can set parameters of Beans, Java Server Pages etc.
All configurations in this projextare implemented by annotations.

*Image shows web.xml file*
![alt text](/.readmeimages/image1.jpg)

*executeCalculation()* method send data to private method in order to calculate result value.
Method assumes two BigDecimal numbers and operator sign (+, -, /, *).
After calculation this method returns BigDecimal result.

*Image shows CalcService class*
![alt text](/.readmeimages/image2.jpg)

*executeCalculation()* method contains four private methods:
*add()*, *subtract()*, *divide()*, *multiply()*.
This private methods use methods from BigDecimal class to execute operations on two numbers.
*divide()* method additionaly contains setting according to rounding last digit and 10 significant digits after the decimal point setting.

*Image shows private methods of CalcService class*
![alt text](/.readmeimages/image3.jpg)

*index.jsp* it is a frontend side of this web application.
This Java Server Page contains settings according to UTF-8 charset, import PrintWriter class and import Java Standard Tag Library file. 
In *<style>* section is declared a CSS styles configurations. It is contains some CSS classes e.g. *.container{}*.

*Image shows index.jsp page*
![alt text](/.readmeimages/image4.jpg)

This servlet use post HTTP method to communicate with backend side of web application.
URI of controller servlet is */calc-servlet*.
This form contains inputs: two numbers and operator (sign) from predefined list. This set of information is sent to the CalcServlet.

*Image shows <form> implementation in index.jsp file*
![alt text](/.readmeimages/image5.jpg)

*CalcServlet* returns set of data: number 1, number 2, sign, result and flag.
If flag equals 0 then result is printed. This condition is implemented to printing values when they are not null. Flag allows to turn off display of null values.
Last section is footer with informations about author and date.

*Image shows code with scriptlet which implements presenting of results*
![alt text](/.readmeimages/image6.jpg)

*MvcConfig* class is a configuration class extends *WebMvcConfigurerAdapter* class.
This class have a *@Configuration* annotation - this class contains Bean configuration.
*@ComponentScan* annotation take information in which package Spring should search Spring components.
*@EnableWebMvc* annotation enables support for *@Controller* and *@RequestMapping* annotation, which is using in web applications.

*Image shows MvcConfig class*
![alt text](/.readmeimages/image7.jpg)

*CalcServlet* class is a configuration class extends *AbstractAnnotationConfigDispatcherServletInitializer* class.
This class contains 3 methods. This application use 2 of them.
*getServletConfigClasses* method contains collection with information about configuration class.
*getServletMappings* method contains tab of Strings - in this case one String - information about mapping which is related to *Controller* class (fragment of the mapped url path).

*Image shows MyWebInitializer class*
![alt text](/.readmeimages/image8.jpg)

*CalcController* class is a controller of web application - *Controller* annotation. 
*doCalc()* method take request and response objects. *RequestMapping("calc")* annotation is name of this controller (fragment of the mapped url path).
*ModelAndView* is a container where we can place objects and send them to the view. 
From request object we get parameters and save in BigDecimal variables.
In next step *service.executeCalculation()* realized calculations on two numbers from request object.
*mv.addObject()* enables add some objects with like parameters.
*mv.setViewName()* enables set a view target file.
 
*Image shows CalcServlet controller*
![alt text](/.readmeimages/image9.jpg)

*Image shows start page of CalcServlet web application.*
*We can input two numbers and operator sign. Result is printed below.*

![alt text](/.readmeimages/image10.jpg)

*Sign input contains predefined list. We should input one sign from list.*

![alt text](/.readmeimages/image11.jpg)

*JSP page contains functionality "This field is required" for all inputs.*

![alt text](/.readmeimages/image12.jpg)

*Example execution of CalcServlet application:*
*input two numbers and set "/" operator and click "Calculate".*

![alt text](/.readmeimages/image13.jpg)

*Result is printed below. We can input next values.*

![alt text](/.readmeimages/image14.jpg)

*Result of addition.*

![alt text](/.readmeimages/image15.jpg)
*Result of subtraction.*

![alt text](/.readmeimages/image16.jpg)

*Result of multiplying.*

![alt text](/.readmeimages/image17.jpg)
