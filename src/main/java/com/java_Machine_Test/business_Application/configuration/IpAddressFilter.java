package com.java_Machine_Test.business_Application.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Configuration
public class IpAddressFilter extends OncePerRequestFilter {

    @Value("${allowed.ips}")
    private List<String> allowedIps;  // Inject allowed IPs from properties file

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String clientIp = request.getRemoteAddr();

        if (!allowedIps.contains(clientIp)) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Access denied from this IP address");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
