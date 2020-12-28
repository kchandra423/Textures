/*
MIT License

Copyright (c) 2020 Kumar.s.Chandra

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package Textures;
import processing.core.PApplet;
// import processing.core.PApplet;
/**
 * Represents an image that can be moved around and resized. Supports Gif, jpeg, and png images.
 * Gifs will be properly animated. Uses processing to draw.
 * @author Kumar Chandra
 *
 */
public abstract class Texture{
	public static enum drawMode{
		CENTER,CORNER;
	}
	public static drawMode currentMode;
	/**
	 * Resizes the textures image to the given width and height
	 * @param w new width of texture
	 * @param h new height of texture
	 */
	public abstract void resize(int w, int h);
	/**
	 * Returns the current width of the image
	 * @return
	 */
	public abstract float getWidth();
	/**
	 * Returns the current height of the image
	 * @return
	 */
	public abstract float getHeight();
	/**
	 * Draws the texture onto the given PApplet
	 * @param p The given PApplet to be drawn to
	 */
	public abstract void draw(PApplet p, float x, float y);
	/**
	 * Returns the current x coordinate of the texture
	 * @return current x coordinate
	 */
	
	/**
	 * Fades the image until it is transparent
	 */
	public abstract void fadeOut();
	/**
	 * Fades the image from transparent to opaque
	 */
	public abstract void fadeIn();
	/**
	 * Used to create a Texture given its pathname
	 * Supports gifs, jpegs, and pngs
	 * @author Kumar Chandra
	 *
	 */
	public static class TextureBuilder{
		/**
		 * Creates a Texture from the image at the given path name
		 * @param pathName The path to the Image
		 * @return A texture at 0,0 with the image at the pathname
		 */
		public static Texture getTexture(String pathName) {
			if(pathName.substring(pathName.length()-4, pathName.length()).equals(".gif")){
				return new PGif(pathName);
			}else {
				return new TextureImage(pathName);
			}
		}
	}
	protected int getProcessingImageMode() {
		if(currentMode==drawMode.CENTER) {
			return PApplet.CENTER;
		}else {
			return PApplet.CORNER;
		}
	}
	
}
