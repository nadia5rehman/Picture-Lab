import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.  This is a great lesson for learning 
 * about 2D arrays and the Color class.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{

	/** Main method for testing.  Every class can have a main
	 * method in Java */
	public static void main(String[] args)
	{
		/*
		 * You will write the methods that do the following
		 * 
		 */
		//	  testZeroBlue();
		//    testKeepOnlyBlue();
		//	  testKeepOnlyRed();
		//	  testKeepOnlyGreen();
		//	  testNegate();
		//	  testGrayscale();
		//	  testEdgeDetection();
			  testFixUnderwater();
		//	  testMirrorVertical();
		//    testMirrorTemple();
		//    testMirrorArms();
		//    testMirrorGull();
		//    testMirrorDiagonal();
		    testCollage();
		//    testCopy();

		//    testChromakey();
		//    testEncodeAndDecode();  // use png, gif or bmp because of compression
		//    testGetCountRedOverValue(250);
		//    testSetRedToHalfValueInTopHalf();
		//    testClearBlueOverValue(200);
		//	  Picture pic= new Picture ("koala.jpg");
		//	  int col=4;
		//	  Color avgColor = testGetAverageForColumn(pic, col);// specified column 
	}
	/** Method to test zeroBlue */
	public static void testZeroBlue()
	{
		// opens the image so that it can be manipulated
		Picture koala = new Picture("koala.jpg");
		koala.explore();// shows the picture in a windo

		Pixel[][] pixels = koala.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setBlue(0);
			}
		}

		// shows the current version of the pic in a new window
		koala.explore(); 
	}

	private static void testKeepOnlyBlue() {
		Picture koala = new Picture("koala.jpg");
		koala.explore();

		Pixel[][] pixels = koala.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
		koala.explore();
	}

	private static void testKeepOnlyGreen() {
		Picture koala = new Picture("koala.jpg");
		koala.explore();

		Pixel[][] pixels = koala.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
		koala.explore();
	}

	private static void testKeepOnlyRed() {
		Picture koala = new Picture("koala.jpg");
		koala.explore();

		Pixel[][] pixels = koala.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				pixelObj.setGreen(0);
				pixelObj.setBlue(0);
			}
		}
		koala.explore();

	}

	/** 
	 * Because this is a task commonly invoked on a Picture, it makes sense to add this method 
	 * to the Picture class.  If we are doing things that won't likely be used often, we can 
	 * write these algorithms in this class. 
	 */
	private static void testNegate() {
		Picture koala = new Picture("koala.jpg");
		// write this in Picture class
		koala.explore();
		koala.negate();
		koala.explore();

	}

	/**
	 * Again, like the method above, this is pretty common, so let's add this method to the 
	 * Picture class.
	 */
	private static void testGrayscale() {
		Picture koala = new Picture("koala.jpg");
		// write this method in Picture class
		koala.explore();
		koala.grayScale();
		koala.explore();

	}

	/** Method to test edgeDetection */
	public static void testEdgeDetection()
	{

		Picture koala = new Picture("koala.jpg");

		// written in Picture class
		koala.explore();
		koala.edgeDetection(10);
		koala.explore();
		koala.write("koala outline.jpg");// writes the new picture to a new file
	}
	/** Method to test mirrorVertical */
	public static void testMirrorVertical()
	{
		Picture koala = new Picture("koala.jpg");
		koala.explore();
		// this should take the left-hand half of the picture and reflect it across 
		// the vertical midline.
		koala.mirrorVertical();// need to write this method in the picture class
		koala.explore();
	}

	/** Method to test mirrorTemple */
	public static void testMirrorTemple()
	{
		Picture temple = new Picture("temple.jpg");
		temple.explore();
		// This method makes a mirror image of a section of this picture
		// If this picture is of the temple, it mirror images the top.
		// what if this picture is of a different image?
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		// this method creates a mirror image for a section of its
		// pixels.  What would happen if we used a different starting 
		// image?  Is mirrorTemple a useful method in the long run?  How
		// could you change it so that it would be more useful?
		Pixel[][] pixels = temple.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];      
				rightPixel = pixels[row]                       
						[mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}



		temple.explore();
	}

	/** Method to test the collage method */
	public static void testCollage()
	{
		Picture canvas = new Picture("640x480.jpg");
		canvas.createCollage();// this method has been written in the Picture class
		// how can it be changed so that we could pass in 
		// pictures that could be added to a collage?
		canvas.explore();
	}


	/*so, you have a choice for this one and the methods that follow.  You can write the
	 * code in the methods below or you can add functionality to the picture class.  Sometimes
	 * it makes sense to add it to the class for reusability reasons.  Sometimes it is too unique
	 * a need to add to the class. 
	 */

	// So, you can create a Picture Object and find the average value of 
	// the component in that column
	private static Color testGetAverageForColumn(Picture pic, int col) {
		Color avg = null;
		Pixel [][] pixels= pic.getPixels2D();
		int blue=0,red=0,green=0;
		for (int r=0;r<pixels.length; r++) {
			blue=pixels[r][col].getBlue();
			green=pixels[r][col].getGreen();
			red=pixels[r][col].getRed();
		}
		int avgBl=blue/pixels.length;
		int avgGr=green/pixels.length;
		int avgRe=red/pixels.length;
		avg= new Color (avgRe, avgGr, avgBl);
		return avg;
	}

	// so for this one, any pixels that have blue over a certain value are set 
	// to no blue at all.  Or for a different effect, have those pixels set to black.
	private static void testClearBlueOverValue(int i) {
		Picture koala=new Picture ("koala.jpg");
		Pixel [][] pixels= koala.getPixels2D();
		koala.explore();
		for(Pixel [] rowArray : pixels) {
			for (Pixel pixelobj : rowArray) {
				if (pixelobj.getBlue()>i) pixelobj.setBlue(0);
			}
		}
		koala.explore();
	}

	// goes to each pixel in the top half and cuts the red component in half
	// So, bottom half of pic should look normal
	private static void testSetRedToHalfValueInTopHalf() {
		Picture koala=new Picture ("koala.jpg");
		Pixel [][] pixels= koala.getPixels2D();
		koala.explore();
		for (int r=0;r<pixels.length/2;r++) {
			for (int c=0;c<pixels[r].length;c++) {
				int red=pixels[r][c].getRed();
				pixels[r][c].setRed(red/2);
			}
		}
		koala.explore();
	}
	// displays the number of pixels in the pic that have a red component
	// greater than the specifies int.
	private static void testGetCountRedOverValue(int i) {
		Picture koala=new Picture ("koala.jpg");
		Pixel [][] pixels= koala.getPixels2D();
		int count=0;
		for(Pixel[] rowArray : pixels) {
			for (Pixel pixelobj : rowArray) {
				if (pixelobj.getRed()>i) count++;
			}
		}
		System.out.println(count);

	}

	/**
	 * The method below is really cool!!  Use the following approach:
	 * go through the entire Picture (the one to carry the message), 
	 * and make the red component of every pixel an even number.  
	 * To do this, mod by 2 and see if remainder>0.  If so, add or 
	 * subtract one (subtracting is safer. Why?) 
	 * Then, using a Picture of a message (one color on white background), 
	 * any pixel from Picture of message that is not white causes you to 
	 * add one to the corresponding pixel's red component of the 
	 * encoded picture (the one with all even red components).
	 * 
	 * Then you can send along the encoded picture to someone else and they should 
	 * be able to decode it by looking for Pixels with odd red components.
	 */
	private static void testEncodeAndDecode() {
		

	}

	/** chroma key means to superimpose one image over another.  The image to be
		drawn over the other one, only draws the pixels that aren't the chroma key
		The common name for this is green screen*/

	private static void testChromakey() {
		
	}
	/**
	 * use edge detection and search for an oval... HARD!!!
	 */
	private static void testFaceDetect() {

	}

	// copies a picture onto another
	private static void testCopy() {


	}

	// Creates a new Picture that creates a mirror image along one diagonal
	private static void testMirrorDiagonal() {

	}

	private static void testMirrorGull() {
		// creates a mirror image of a bird making image look like bird is over water

	}

	private static void testMirrorArms() {
		// TODO Auto-generated method stub

	}
	/** This method is an effort to make a Picture taken underwater look
	 * more like it would be if the water were drained
	 */
	private static void testFixUnderwater() {
		Picture water=new Picture("water.jpg");
		Pixel[][] pixels= water.getPixels2D();
		water.explore();
		for (Pixel[] rowArray:pixels) {
			for (Pixel pixelobj:rowArray) {
				int blue=pixelobj.getBlue();
				int red=pixelobj.getRed();
				int green=pixelobj.getGreen();
				Color finish=new Color (red+80, green-60, blue-60);
				pixelobj.setColor(finish);
			}
		}
		water.explore();
	}

}