package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	
	private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);


	    @PostMapping("/add/{number1:.+}/{number2:.+}")
	    public BigDecimal add(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
	    	BigDecimal bigDecimal1 = null;
	    	BigDecimal bigDecimal2 = null;
	    	try {
	    		bigDecimal1 = new BigDecimal(number1);
		    	bigDecimal2 = new BigDecimal(number2);
		    	
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	return bigDecimal1.add(bigDecimal2);
	    }

	    @PostMapping("/subtract/{number1:.+}/{number2:.+}")
	    public BigDecimal subtract(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
	    	
	    	BigDecimal bigDecimal1 = null;
	    	BigDecimal bigDecimal2 = null;
	    	try {
	    		bigDecimal1 = new BigDecimal(number1);
		    	bigDecimal2 = new BigDecimal(number2);
		    	
			} catch (Exception e) {
				// TODO: handle exception
			}
	    	if(bigDecimal2.compareTo(bigDecimal1) > 0) {
	    		logger.info("number1 is less than number2");
	    	};
	        return bigDecimal1.subtract(bigDecimal2);

	    }

	    @PostMapping("/multiply/{number1:.+}/{number2:.+}")
	    public BigDecimal multiply(@PathVariable("number1") String number1, @PathVariable("number2") String number2) {
	    	BigDecimal bigDecimal1 = new BigDecimal(number1);
	    	BigDecimal bigDecimal2 = new BigDecimal(number2);
	        return bigDecimal1.multiply(bigDecimal2);

	    }

	    @PostMapping("/divide/{number1:.+}/{number2:.+}")
	    public BigDecimal divide(@PathVariable("number1") String number1, @PathVariable("number2") String number2) throws Exception {
	    	BigDecimal bigDecimal1 = new BigDecimal(number1);
	    	BigDecimal bigDecimal2 = new BigDecimal(number2);
	    	if (bigDecimal2.equals(BigDecimal.ZERO)) {
	    		logger.info("Error occured");
	            throw new Exception("Division by zero is not allowed.");
	        }
	        return bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP); 	 
	    }
	



}
