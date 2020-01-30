package sodoku;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Hashtable;


import javax.imageio.ImageIO;


public class IImage {
	static boolean init = false;
	static final File dir = new File("C:\\Users\\SinaMirnejad\\SinaProjects\\"
								   + "GridTools.zip_expanded\\Assets");
	static final String[] EXTENSIONS = new String[]{"gif", "png", "bmp", "jpg"};
	
	public static Hashtable<String,Image> IMG = new Hashtable<String,Image>();
	 
	
	static final FilenameFilter IMAGE_FILTER = new FilenameFilter() {
		@Override
        public boolean accept(final File dir, final String name) {
            for (final String ext : EXTENSIONS) {
                if (name.endsWith("." + ext)) {
                    return (true);
                }
            }
            return (false);
        }
    };
    
    
    static public void ClassInit() {
    	init  = true;
    	if (dir.isDirectory()) { // make sure it's a directory
            for (final File f : dir.listFiles(IMAGE_FILTER)) {
                BufferedImage img = null;

                try {
                    img = ImageIO.read(f);
                    IMG.put(f.getName(), img);
                    // you probably want something more involved here
                    // to display in your UI
                    /*System.out.println("image: " + f.getName());
                    System.out.println(" width : " + img.getWidth());
                    System.out.println(" height: " + img.getHeight());
                    System.out.println(" size  : " + f.length());*/
                } catch (final IOException e) {
                	
                    // handle errors here
                }
            }
        }
    }
    
    public IImage() {
    	if (!init)
    		ClassInit();
    }
	
}
