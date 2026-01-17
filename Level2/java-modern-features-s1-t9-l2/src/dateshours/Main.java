package dateshours;

import dateshours.service.MenuService;

public class Main {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.showMainMenu();
    }
}
