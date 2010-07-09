package org.eclipse.papyrus.diagram.communication.custom.util;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;

/**
 * 
 * This is a helper for rotating swt figures, it provides a method for computing
 * an rotation angle provided two points, and methods for rotating an swt image
 * 
 */
public class RotationHelper {

	/**
	 * 
	 * @return the GraphicsConfiguration
	 */

	public static GraphicsConfiguration getDefaultConfiguration() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		return gd.getDefaultConfiguration();
	}

	/**
	 * 
	 * This method calculates the rotation clockwise angle w.r.t the source and
	 * target connection anchor positions
	 * 
	 * @param S
	 *        Source connection anchor
	 * @param T
	 *        Target connection anchor
	 * @return The rotation clockwise angle w.r.t the source and target
	 *         connection
	 */

	public static double calculateRotAngle(Point S, Point T) {
		double dx = T.x - S.x;
		double dy = T.y - S.y;
		double angle = 0.0d;

		if((dx > 0) && (dy < 0)) {
			angle = -Math.atan(Math.abs(dy) / Math.abs(dx));
			// System.out.print("(dx > 0) && (dy < 0)\n");
		} else if((dx < 0) && (dy < 0)) {
			angle = -(Math.PI - Math.atan(Math.abs(dy) / Math.abs(dx)));
			// System.out.print("(dx < 0) && (dy < 0)\n");
		} else if((dx < 0) && (dy > 0)) {
			angle = Math.PI - Math.atan(Math.abs(dy) / Math.abs(dx));
			// System.out.print("(dx < 0) && (dy > 0)\n");
		} else if((dx > 0) && (dy > 0)) {
			angle = Math.atan(Math.abs(dy) / dx);
			// System.out.print("((dx > 0) && (dy > 0)\n");
		} else if((dx == 0) && (dy < 0)) {
			angle = -Math.PI / 2;
			// System.out.print("((dx == 0) && (dy < 0))\n");
		} else if((dx == 0) && (dy > 0)) {
			angle = Math.PI / 2;
			// System.out.print("((dx == 0) && (dy > 0))\n");
		} else if((dy == 0) && (dx < 0)) {
			angle = -Math.PI;
			// System.out.print("((dy == 0) && (dx < 0))\n");
		}

		return Math.toDegrees(angle);

	}

	/**
	 * rotates an awt image
	 * 
	 * @param image
	 *        awt image
	 * @param angle
	 *        angle of rotation
	 * @return swt rotated image
	 */
	public static ImageData tilt(BufferedImage image, double angle) {

		double sin = Math.abs(Math.sin(angle)), cos = Math.abs(angle);
		int w = image.getWidth(), h = image.getHeight();
		int neww = w;
		int newh = h;
		if(((int)sin != 0) || ((int)cos != 0))

		{
			neww = (int)Math.floor(w * cos + h * sin);
			newh = (int)Math.floor(h * cos + w * sin);
		}

		GraphicsConfiguration gc = getDefaultConfiguration();
		BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = result.createGraphics();

		g.translate((neww - w) / 2, (newh - h) / 2);

		g.rotate(angle, w / 2, h / 2);
		// System.out.format("Tilt angle %f\n", Math.toDegrees(angle));
		// g.rotate(angle, w / 2, h / 2);
		// java.awt.Shape oldClip = g.getClip();
		// Rectangle e = new Rectangle().expand(50, 50);
		// g.setClip((java.awt.Shape) e);
		g.drawRenderedImage(image, null);
		g.dispose();

		return convertToSWT(result);
	}

	/**
	 * Rotates the swt image
	 * 
	 * @param img
	 * @param degree
	 * @return the rotated image
	 */
	public static ImageData rotateImage(Image img, double degree) {
		ImageData data = img.getImageData();
		BufferedImage bufImg = convertToAWT(data);
		double angle = Math.toRadians(degree);
		// System.out.format("rotateImage angle %f\n", degree);
		return tilt(bufImg, angle);
	}

	/**
	 * convert awt BufferedImage to swt ImageData
	 * 
	 * @param bufferedImage
	 * @return converted ImageData
	 */
	public static ImageData convertToSWT(BufferedImage bufferedImage) {
		if(bufferedImage.getColorModel() instanceof DirectColorModel) {
			DirectColorModel colorModel = (DirectColorModel)bufferedImage.getColorModel();
			PaletteData palette = new PaletteData(colorModel.getRedMask(), colorModel.getGreenMask(), colorModel.getBlueMask());
			ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					int rgb = bufferedImage.getRGB(x, y);
					int pixel = palette.getPixel(new RGB((rgb >> 16) & 0xFF, (rgb >> 8) & 0xFF, rgb & 0xFF));
					data.setPixel(x, y, pixel);
					if(colorModel.hasAlpha()) {
						data.setAlpha(x, y, (rgb >> 24) & 0xFF);
					}
				}
			}
			return data;
		} else if(bufferedImage.getColorModel() instanceof IndexColorModel) {
			IndexColorModel colorModel = (IndexColorModel)bufferedImage.getColorModel();
			int size = colorModel.getMapSize();
			byte[] reds = new byte[size];
			byte[] greens = new byte[size];
			byte[] blues = new byte[size];
			colorModel.getReds(reds);
			colorModel.getGreens(greens);
			colorModel.getBlues(blues);
			RGB[] rgbs = new RGB[size];
			for(int i = 0; i < rgbs.length; i++) {
				rgbs[i] = new RGB(reds[i] & 0xFF, greens[i] & 0xFF, blues[i] & 0xFF);
			}
			PaletteData palette = new PaletteData(rgbs);
			ImageData data = new ImageData(bufferedImage.getWidth(), bufferedImage.getHeight(), colorModel.getPixelSize(), palette);
			data.transparentPixel = colorModel.getTransparentPixel();
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					raster.getPixel(x, y, pixelArray);
					data.setPixel(x, y, pixelArray[0]);
				}
			}
			return data;
		}
		return null;
	}

	/**
	 * converts swt image to awt
	 * 
	 * @param data
	 *        swt ImageData
	 * @return awt BufferdImage
	 */

	public static BufferedImage convertToAWT(ImageData data) {
		ColorModel colorModel = null;
		PaletteData palette = data.palette;
		if(palette.isDirect) {
			colorModel = new DirectColorModel(data.depth, palette.redMask, palette.greenMask, palette.blueMask);
			BufferedImage bufferedImage = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					int pixel = data.getPixel(x, y);
					RGB rgb = palette.getRGB(pixel);
					bufferedImage.setRGB(x, y, rgb.red << 16 | rgb.green << 8 | rgb.blue);
				}
			}
			return bufferedImage;
		} else {
			RGB[] rgbs = palette.getRGBs();
			byte[] red = new byte[rgbs.length];
			byte[] green = new byte[rgbs.length];
			byte[] blue = new byte[rgbs.length];
			for(int i = 0; i < rgbs.length; i++) {
				RGB rgb = rgbs[i];
				red[i] = (byte)rgb.red;
				green[i] = (byte)rgb.green;
				blue[i] = (byte)rgb.blue;
			}
			if(data.transparentPixel != -1) {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue, data.transparentPixel);
			} else {
				colorModel = new IndexColorModel(data.depth, rgbs.length, red, green, blue);
			}
			BufferedImage bufferedImage = new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(data.width, data.height), false, null);
			WritableRaster raster = bufferedImage.getRaster();
			int[] pixelArray = new int[1];
			for(int y = 0; y < data.height; y++) {
				for(int x = 0; x < data.width; x++) {
					int pixel = data.getPixel(x, y);
					pixelArray[0] = pixel;
					raster.setPixel(x, y, pixelArray);
				}
			}
			return bufferedImage;
		}
	}
}
