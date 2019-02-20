package com.clive.filter;

import com.clive.model.User;
import com.clive.service.MenuService;
import com.clive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MenuFilter extends OncePerRequestFilter {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        User user = userService.getCurrentUser();

        if (user != null) {
            httpServletRequest.setAttribute("menuItems", menuService.getMenuItems(user));
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }
}
