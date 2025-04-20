package game;

import java.util.ArrayList;

/**
 * toolkit with useable items
 */
public class Toolkit {

    private ArrayList<ToolkitItem> items;

    private int currentItem;

    public Toolkit(){
        items = new ArrayList<ToolkitItem>();
        currentItem = -1;
    }

    public void addItem(ToolkitItem item){
        items.add(item);
        currentItem = items.size()-1;
    }

    public ToolkitItem getCurrentItem(){
        return items.get(currentItem);
    }

    /**
     * switch between items
     */
    public void toggle(){
        getCurrentItem().takeoff();
        currentItem++;
        if (currentItem == items.size())
            currentItem = 0;
        getCurrentItem().wear();

        System.out.println("Current item: " + getCurrentItem().getType());
    }
}
