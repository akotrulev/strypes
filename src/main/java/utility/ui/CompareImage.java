package utility.ui;

import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.ImageComparisonUtil;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;

import java.awt.image.BufferedImage;
import java.io.File;

public class CompareImage {

    public void compareImages(String pathToActual, String pathToExpected, String output) {
        //load images to be compared:
        BufferedImage actualImage = ImageComparisonUtil.readImageFromResources(pathToActual);
        BufferedImage expectedImage = ImageComparisonUtil.readImageFromResources(pathToExpected);


        // where to save the result (leave null if you want to see the result in the UI)
        File resultDestination = new File(output);

        //Create ImageComparison object with result destination and compare the images.
        ImageComparisonResult imageComparisonResult = new ImageComparison(expectedImage, actualImage, resultDestination).compareImages();
    }
}
