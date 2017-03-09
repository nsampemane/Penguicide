package Display;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
public class SpriteSheet {
    BufferedImage image;
    public SpriteSheet(String path) throws java.io.IOException{
        image = ImageIO.read(new File(path));

    }
    public BufferedImage getImage(){
        return image;
    }
}
