/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Added support for Image's name
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * Utility class for <code>org.eclipse.uml2.uml.Image</code><BR>
 */
public class ImageUtil {

	/**
	 * ID of the EAnnotation where "expression" (used to select stereotype icon) is stored on image.
	 */
	public static String IMAGE_PAPYRUS_EA = "image_papyrus";

	/**
	 * KEY of the EAnnotation where "expression" (used to select stereotype icon) is stored on
	 * image.
	 */
	public static String IMAGE_EXPR_KEY = "image_expr_key";

	/**
	 * KEY of the EAnnotation where "kind" (kind = icon/shape) is stored on image.
	 */
	public static String IMAGE_KIND_KEY = "image_kind_key";

	/**
	 * KEY of the EAnnotation where the image's name is stored
	 * 
	 * @see {@link #getName(Image)}
	 * @see {@link #setName(Image, String)}
	 */
	public static String IMAGE_NAME_KEY = "image_name_key";

	/**
	 * Set the content of an {@link Image} with a file (containing an image).
	 * 
	 * @param image
	 *        the UML {@link Image} to set
	 * @param imageFile
	 *        the icon
	 */
	// @unused
	public static void setContent(Image image, File imageFile) {

		try {
			String rawImageData = "";
			if(imageFile != null) {
				byte[] byteFlow = getBytesFromFile(imageFile);

				rawImageData = "";

				// file reading
				for(byte element : byteFlow) {
					rawImageData = rawImageData + element + "%";
				}
			} else {
				rawImageData = null;
			}

			image.setContent(rawImageData);

		} catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getLocalizedMessage(), ex));
		}
	}

	/**
	 * Get the content of an {@link Image} as {@link org.eclipse.swt.graphics.Image}
	 * 
	 * @param image
	 *        the UML {@link Image} to set
	 * 
	 * @return {@link org.eclipse.swt.graphics.Image} content
	 */
	public static org.eclipse.swt.graphics.Image getContent(Image image) throws Exception {

		if(image == null) {
			// null parameter
			return null;
		}

		if(image.getContent() == null) {
			// null image
			return null;
		}

		// else
		String rawData = image.getContent();
		StringTokenizer strToken = new StringTokenizer(rawData, "%");
		byte[] target = new byte[strToken.countTokens()];

		// decoding image
		int j = 0;
		while(strToken.hasMoreTokens()) {
			target[j] = (new Byte(strToken.nextToken()).byteValue());
			j++;
		}

		org.eclipse.swt.graphics.Image decodedImage = new org.eclipse.swt.graphics.Image(null, new ByteArrayInputStream(target));

		return decodedImage;
	}

	/**
	 * Get the image specified by the location property of an {@link Image} as {@link org.eclipse.swt.graphics.Image}
	 * 
	 * @param image
	 *        the UML {@link Image} to set
	 * 
	 * @return {@link org.eclipse.swt.graphics.Image} image
	 */
	public static org.eclipse.swt.graphics.Image getImageFromLocation(Image image) {

		org.eclipse.swt.graphics.Image swtImage = null;

		// Try to instantiate an SWT image from the path stored
		// in UML Image location property
		String location = image.getLocation();
		if((location != null) && !("".equals(location))) {

			URI iconURI = URI.createURI(location);
			if(iconURI.isRelative()) {
				String err_msg = "Incorrect implementation of relative location." + location;
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, err_msg, new Exception(err_msg)));
				URI pluginURI = URI.createPlatformPluginURI(location, true); // <- TODO : fix this to retrieve the related plug-in URI
				iconURI = iconURI.resolve(pluginURI);
			}

			try {
				ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(new URL(iconURI.toString()));
				swtImage = imageDescriptor.createImage();

			} catch (Exception e) {
				Activator.getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "Could not create image from location : " + location, e));
			}
		}

		return swtImage;
	}

	/**
	 * Read an image file content.
	 * 
	 * @param file
	 *        the file
	 * 
	 * @return a table of bytes of the file content
	 * 
	 * @throws IOException
	 *         Signals that an I/O exception has occurred.
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {

		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.
		if(length > Integer.MAX_VALUE) {
			is.close();
			throw new IOException("Image too big to encode");
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int)length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while((offset < bytes.length) && ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if(offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file " + file.getName());
		}

		// Close the input stream and return bytes
		is.close();

		return bytes;
	}

	/**
	 * Associates an expression to an image.
	 * 
	 * @param image
	 *        the image
	 * @param expression
	 *        the expression
	 */
	public static void setExpression(Image image, String expression) {

		EAnnotation ea_Image = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		// Create annotation for icon selection if it does not exist
		if(ea_Image == null) {
			ea_Image = image.createEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		}

		// If expression == "" remove the EAnnotation
		if("".equals(expression)) {
			ea_Image.getDetails().removeKey(IMAGE_EXPR_KEY);
		} else {
			ea_Image.getDetails().put(ImageUtil.IMAGE_EXPR_KEY, expression);
		}

		cleanImageAnnotation(ea_Image);
	}

	/**
	 * Returns the expression associated to the image.
	 * 
	 * @param image
	 *        the image
	 * 
	 * @return the expression associated to the image
	 */
	public static String getExpression(org.eclipse.uml2.uml.Image image) {
		EAnnotation ea_ImageExpr = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);

		String expr = null;
		if((ea_ImageExpr != null) && (ea_ImageExpr.getDetails().containsKey(ImageUtil.IMAGE_EXPR_KEY))) {
			expr = ea_ImageExpr.getDetails().get(ImageUtil.IMAGE_EXPR_KEY);
		}
		return expr;
	}

	/**
	 * Associates a name to an Image.
	 * 
	 * The UML Image is not a NamedElement : the name is stored as an
	 * EAnnotation, and is not mandatory. The name should only be used for
	 * displaying the image's label : this is *not* an identifier.
	 * 
	 * @param image
	 *        The image
	 * @param name
	 *        The name
	 */
	public static void setName(Image image, String name) {
		EAnnotation ea_Image = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		// Create annotation for icon selection if it does not exist
		if(ea_Image == null) {
			ea_Image = image.createEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		}

		// If expression == "" remove the EAnnotation
		if("".equals(name)) {
			ea_Image.getDetails().removeKey(IMAGE_NAME_KEY);
		} else {
			ea_Image.getDetails().put(ImageUtil.IMAGE_NAME_KEY, name);
		}

		cleanImageAnnotation(ea_Image);
	}

	/**
	 * Returns the name associated to the image
	 * 
	 * The UML Image is not a NamedElement : the name is stored as an
	 * EAnnotation, and is not mandatory. The name should only be used for
	 * displaying the image's label : this is *not* an identifier.
	 * 
	 * @param image
	 *        the image
	 * @return
	 *         the name associated to the image
	 */
	public static String getName(Image image) {
		EAnnotation ea_Image = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);

		String name = null;
		if((ea_Image != null) && (ea_Image.getDetails().containsKey(IMAGE_NAME_KEY))) {
			name = ea_Image.getDetails().get(IMAGE_NAME_KEY);
		}
		return name;
	}

	/**
	 * Removes the EAnnotation from the Image if the annotation doesn't contain any valid key
	 * 
	 * @param annotation
	 */
	private static void cleanImageAnnotation(EAnnotation annotation) {
		EMap<String, String> details = annotation.getDetails();
		if(details.isEmpty()) {
			//if(!(details.containsKey(IMAGE_NAME_KEY)) && !(details.containsKey(IMAGE_KIND_KEY) && !(details.containsKey(IMAGE_NAME_KEY)))) {
			annotation.setEModelElement(null);
		}

	}

	/**
	 * Associates kind to an image.
	 * 
	 * @param image
	 *        the image
	 * @param kind
	 *        of image (icon / shape)
	 */
	// @unused
	public static void setKind(org.eclipse.uml2.uml.Image image, String kind) {

		EAnnotation ea_Image = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		// Create annotation for icon selection if it does not exist
		if(ea_Image == null) {
			ea_Image = image.createEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);
		}

		// If expression == "" remove the EAnnotation
		if("".equals(kind)) {
			ea_Image.getDetails().removeKey(IMAGE_KIND_KEY);
		} else {
			ea_Image.getDetails().put(ImageUtil.IMAGE_KIND_KEY, kind);
		}

		cleanImageAnnotation(ea_Image);
	}

	/**
	 * Returns the kind of the image (icon or shape for Papyrus).
	 * 
	 * @param image
	 *        the image
	 * 
	 * @return kind of image
	 */
	public static String getKind(org.eclipse.uml2.uml.Image image) {
		EAnnotation ea_ImageExpr = image.getEAnnotation(ImageUtil.IMAGE_PAPYRUS_EA);

		String kind = null;
		if((ea_ImageExpr != null) && (ea_ImageExpr.getDetails().containsKey(ImageUtil.IMAGE_KIND_KEY))) {
			kind = ea_ImageExpr.getDetails().get(ImageUtil.IMAGE_KIND_KEY);
		}
		return kind;
	}

	/**
	 * Evaluates the "Expression" EAnnotation associated to the image.
	 * 
	 * @param element
	 *        on which the stereotype (owning current image) is applied
	 * @param image
	 *        the image
	 * 
	 * @return true if the expression is correct
	 */
	public static boolean evalExpression(Image image, Element element) {
		/*
		 * Expression has the form : propName = Literal
		 */

		/* Firstly we extract the propertyName and the literal */

		String propName = null;
		String literal = null;
		Stereotype st = (Stereotype)image.getOwner();

		// Retrieve Expression
		String expression = ImageUtil.getExpression(image);
		if(expression == null) {
			// No expression to check
			return false;
		}

		// Parse and test expression
		StringTokenizer sToken = new StringTokenizer(expression.replace(" ", ""), "=");
		if(sToken.countTokens() == 2) {
			propName = sToken.nextToken();
			literal = sToken.nextToken();

		} else {
			// Bad formed expression --> ignore
			return false;
		}

		if(element.getValue(st, propName) != null) {
			/* extract property value from applied stereotype */
			Object val = element.getValue(st, propName);

			if(val instanceof EnumerationLiteral) {
				if(((EnumerationLiteral)val).getLabel().equals(literal)) {
					return true;
				}
			}
		}
		// In any other case (bad expression, not property found...)
		return false;
	}

	/**
	 * Test expression on every image, stop on first verified expression.
	 * 
	 * @param element
	 *        the element to check
	 * @param images
	 *        the list of images to check
	 * 
	 * @return first image verifying its expression
	 */
	public static Image findImageVerifyingExpression(Element element, EList<Image> images) {

		Image image = null;
		Iterator<Image> it = images.iterator();
		while((image == null) && it.hasNext()) {
			Image current = it.next();
			if(ImageUtil.evalExpression(current, element)) {
				image = current;
			}
		}

		return image;
	}

	/**
	 * Create an Id to store and retrieve image (SWT) In registry.
	 * 
	 * @param image
	 *        the image
	 * 
	 * @return the image id
	 */
	public static String getImageId(Image image) {
		String id = "";

		Stereotype owner = (Stereotype)image.getOwner();
		id += owner.getQualifiedName() + "_img_" + owner.getIcons().indexOf(image);

		return id;

	}
}
