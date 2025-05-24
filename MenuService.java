import java.util.*;

public class MenuService {
    private List<MenuItem> menu = new ArrayList<>();

    public void addMenuItem(MenuItem item){
        menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return menu;
    }

    public MenuItem getItemById(int id){
        for (MenuItem item : menu){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
