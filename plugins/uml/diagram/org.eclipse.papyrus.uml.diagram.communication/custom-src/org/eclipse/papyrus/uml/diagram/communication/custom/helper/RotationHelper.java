/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.helper;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Transform;
import org.eclipse.ui.PlatformUI;

/**
 * This is a helper for rotating SWT figures, it provides a method for computing
 * an rotation angle provided two points, and methods for rotating an SWT image.
 */
public class RotationHelper {

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
	 * rotates an SWTimage using swt.graphics.Transform.
	 * 
	 * @param image
	 *        SWT image
	 * @param degree
	 *        angle of rotation in degrees
	 * @return SWT rotated image
	 */
	public static Image rotateImage(Image image, double degree) {
		ImageData imageData = image.getImageData();
		int w = imageData.width;
		int h = imageData.height;
		float angle = (float) Math.toRadians(degree);
		float sinA = (float) Math.abs(Math.sin(angle));
		float cosA = (float) Math.abs(Math.cos(angle));
		int neww = (int)Math.floor(w * cosA + h * sinA);
		int newh = (int)Math.floor(h * cosA + w * sinA);

		Transform transform = new Transform(PlatformUI.getWorkbench().getDisplay());
		transform.translate(neww/2, newh/2);	// new center
		transform.rotate((float) degree);
		transform.translate(-w/2, -h/2);		// old center
		
		ImageData newImageData = new ImageData(neww, newh, imageData.depth, imageData.palette);
		// make all pixel transparent (is there a better way to do that?)
		for (int y = 0; y <newh ; y++) {
			for (int x = 0; x < neww ; x++) {
				newImageData.setAlpha(x, y, 0);
			}
		}
		final Image newImage = new Image(PlatformUI.getWorkbench().getDisplay(), newImageData);
		GC gc = new GC(newImage);
		gc.setTransform(transform);
		gc.drawImage(image, 0, 0);
		
		gc.dispose();
		
		return newImage;
	}



	/**
	 * rotates an AWT image using awt.geom.AffineTransform.
	 * 
	 * @param image
	 *        awt image
	 * @param degree
	 *        angle of rotation in degrees
	 * @return swt rotated image
	 */
	@Deprecated
	public static ImageData tiltBis(java.awt.Image image, double degree) {
		int w = image.getWidth(null);
		int h = image.getHeight(null);
		double angle = Math.toRadians(degree);
		double sin = Math.abs(Math.sin(angle));
		double cos = Math.abs(Math.cos(angle));
		int neww = (int)Math.floor(w * cos + h * sin);
		int newh = (int)Math.floor(h * cos + w * sin);

		AffineTransform at = new AffineTransform();

		//at.scale((w + 0.0) / (neww + 0.0), (h + 0.0) / (newh + 0.0));
		at.translate((neww - w) / 2, (newh - h) / 2);

		at.rotate(angle, w / 2, h / 2);

		BufferedImage b = new BufferedImage(neww, newh, Transparency.TRANSLUCENT);
		Graphics2D g = b.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.drawImage(image, at, null);
		g.dispose();
		return convertToSWT(b);
	}


	
	/**
	 * Rotates an SWT image by converting it to AWT first.
	 * 
	 * @param img
	 *        the SWT img
	 * @param degree
	 *        the degree
	 * @return the rotated image
	 */
	@Deprecated
	public static Image rotateImageBis(Image img, double degree) {

		ImageData imageData = img.getImageData();
		BufferedImage bufImg = convertToAWT(imageData);
		//double angle = Math.toRadians(degree);
		//return tilt(bufImg, angle);
		ImageData imageDataNew = tiltBis(bufImg, degree);
		Image imageNew = new Image(PlatformUI.getWorkbench().getDisplay(), imageDataNew);
		return imageNew;
	}

	/**
	 * convert an AWT BufferedImage to SWT ImageData.
	 * 
	 * @param bufferedImage
	 *        the buffered image
	 * @return converted ImageData
	 */
	@Deprecated
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
	 * Converts an SWT image to AWT
	 * TODO: This function does not work on MacOS and Linux machines
	 *
	 * @param data
	 *        SWT ImageData
	 * @return AWT BufferdImage
	 */
	@Deprecated
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
