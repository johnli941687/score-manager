package com.clive.filter;

import com.clive.model.User;
import com.clive.service.MenuService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MenuFilter extends OncePerRequestFilter {
    private MenuService menuService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        User user = SecurityContextHolder.getContext().getAuthentication() == null ? null : (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (user != null) {
            httpServletRequest.setAttribute("menuItems", menuService.getMenuItems(user));
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
