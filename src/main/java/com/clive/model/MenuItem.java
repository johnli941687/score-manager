package com.clive.model;

public class MenuItem {
    String menuTitle;
    String menuUrl;

    public MenuItem(String menuTitle, String menuUrl) {
        this.menuTitle = menuTitle;
        this.menuUrl = menuUrl;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }
}
