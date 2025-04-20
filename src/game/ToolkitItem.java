package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;

public abstract class ToolkitItem {

    protected Mei mei;

    protected BodyImage image;

    protected AttachedImage aImage;

    public ToolkitItem(Mei mei){
        this.mei = mei;
    }

    //add image of toolkit item based on what has been chosen
    public void wear(){
        aImage = mei.addImage(image);

        if (mei.getDirection().equals("left"))
            aImage.flipHorizontal();
    }

    public void takeoff(){
        mei.removeAttachedImage(aImage);
    }

    public abstract String getType();

    public abstract void operate();
}
