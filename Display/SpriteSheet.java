package Display;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;


import Utilities.FlatArrayTools;

public class SpriteSheet {
    BufferedImage largeImage;
    BufferedImage[] sprites;
    FlatArrayTools tools;

    public SpriteSheet(String path, int columns, int rows, int spriteWidth) throws java.io.IOException {
        tools = new FlatArrayTools(columns, rows);
        largeImage = ImageIO.read(new File(path));
        sprites = new BufferedImage[columns * rows];
        for (int index = 0; index < sprites.length; index++) {
            int rowPixel = tools.getIndexRow(index) * spriteWidth;
            int columnPixel = tools.getIndexColumn(index) * spriteWidth;
            //System.out.println(columnPixel);
            BufferedImage cropped = largeImage.getSubimage(columnPixel, rowPixel, spriteWidth, spriteWidth);
            sprites[index] = cropped;
        }


    }


    public BufferedImage getSheet() {
        return largeImage;
    }

    public BufferedImage getSprite(int index) {
        if (!tools.inRange(index)) {
            return sprites[0];
        }
        return sprites[index];
    }
}
