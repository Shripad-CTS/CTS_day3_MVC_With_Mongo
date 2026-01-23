                      package com.cts.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cts.model.Employee;
import com.cts.repository.EmployeeRepository;

public class FirstLoginFilter extends OncePerRequestFilter {

    private final EmployeeRepository employeeRepository;

    public FirstLoginFilter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth != null && auth.isAuthenticated()
                && !auth.getPrincipal().equals("anonymousUser")) {

            String path = request.getRequestURI();

            // allow these endpoints
            if (path.startsWith("/Springmvc_Mongo/auth/profile")
                    || path.startsWith("/Springmvc_Mongo/auth/change-password")) {
                filterChain.doFilter(request, response);
                return;
            }

            String email = auth.getName();
            Employee emp = employeeRepository.findByEmail(email).orElse(null);

            if (emp != null && emp.isFirstLogin()) {
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getWriter().write("Password change required");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
