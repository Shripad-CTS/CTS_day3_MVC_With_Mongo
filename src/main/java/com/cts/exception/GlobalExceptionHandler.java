package com.cts.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundException.class)
	public String EmployeeExceptionHandler(EmployeeNotFoundException ex,Model model) {
		model.addAttribute("errorTitle", "Employee not found");
		model.addAttribute("errorMessage", ex.getMessage());
		return "error";
	}
    @ExceptionHandler(Exception.class)
    public String handleGenericException(
            Exception ex,
            Model model) {

        model.addAttribute("errorTitle", "Something went wrong");
        model.addAttribute("errorMessage", "Please try again later.");

        return "error";
    }
}
