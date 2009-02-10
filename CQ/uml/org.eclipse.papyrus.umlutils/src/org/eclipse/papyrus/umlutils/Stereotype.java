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
 *  Yann TANGUY  (CEA LIST) Yann.tanguy@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.swt.graphics.Image;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 * 
 * @author tanguy
 */
public class Stereotype extends NamedElement {

	/**
     * 
     */
	private org.eclipse.uml2.uml.Stereotype uml2Stereotype;

	/**
	 * 
	 * 
	 * @param uml2Stereotype
	 */
	public Stereotype(org.eclipse.uml2.uml.Stereotype uml2Stereotype) {
		super(uml2Stereotype);
		this.uml2Stereotype = uml2Stereotype;
	}

	/**
	 * 
	 * 
	 * @return Returns the uml2Class.
	 */
	public org.eclipse.uml2.uml.Stereotype getUml2Stereotype() {
		return uml2Stereotype;
	}

	/**
	 * Return the shape of the stereotype if it has one else returns null.
	 * 
	 * @return
	 */
	@Override
	public Image getShape() {
		return getIcon(1);
	}

	/**
	 * Return the icon of the stereotype if it has one else returns null WARNING!! the image is created each time this method is called, it should use in association with an ImageRegistry.
	 * 
	 * @return the icon of the element
	 */
	@Override
	public Image getIcon() {
		return getIcon(0);
	}

	/**
	 * Returns the name of the icon for a given Stereotype (used as the key for an image registry).
	 * 
	 * @return the key of the icon
	 */
	public String getIconNameForStereotype() {
		return this.getQualifiedName() + "Icon";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.umlutils.Element#hasIcon()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public boolean hasIcon() {
		return hasIcon(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.umlutils.Element#hasShape()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	public boolean hasShape() {
		return hasIcon(1);
	}

	/**
	 * Return the icon of the stereotype if it has one else returns null WARNING!! the image is created each time this method is called, it should use in association with an ImageRegistry.
	 * 
	 * @param imageIndex
	 * 
	 * @return
	 */
	public boolean hasIcon(int imageIndex) {

		if (uml2Stereotype.getIcons().size() < 2) {
			// no icon set
			return false;
		}

		org.eclipse.uml2.uml.Image umlIcon = (org.eclipse.uml2.uml.Image) uml2Stereotype.getIcons().get(imageIndex);
		if (umlIcon.getContent() == null) {
			// null image
			return false;
		}

		// Else
		return true;
	}

	/**
	 * Return the icon of the stereotype if it has one else returns null WARNING!! the image is created each time this method is called, it should use in association with an ImageRegistry.
	 * 
	 * @param imageIndex
	 * 
	 * @return
	 */
	public Image getIcon(int imageIndex) {

		Image icon = null;

		if (uml2Stereotype.getIcons().size() < 2) {
			// no icon set
			return null;
		}

		org.eclipse.uml2.uml.Image umlIcon = (org.eclipse.uml2.uml.Image) uml2Stereotype.getIcons().get(imageIndex);
		if (umlIcon.getContent() == null) {
			// null image
			return null;
		}
		// Else
		String rawData = umlIcon.getContent();
		StringTokenizer strToken = new StringTokenizer(rawData, "%");
		byte[] target = new byte[strToken.countTokens()];

		// decodage
		int j = 0;
		while (strToken.hasMoreTokens()) {
			target[j] = (new Byte(strToken.nextToken()).byteValue());
			j++;
		}

		icon = new Image(null, new ByteArrayInputStream(target));
		return icon;
	}

	/**
	 * 
	 * 
	 * @param iconFile
	 */
	public void setIcon(File iconFile) {
		setIcon(iconFile, 0);
	}

	/**
	 * returns the number of icons of the stereotype
	 * 
	 * @return
	 */
	public int getNbrOfIcons() {
		int nbr = getUml2Stereotype().getIcons().size();
		if (!hasIcon())
			return 0;
		else
			return nbr;
	}

	/**
	 * 
	 * 
	 * @param shapeFile
	 */
	public void setShape(File shapeFile) {
		setIcon(shapeFile, 1);
	}

	/**
	 * 
	 * 
	 * @param iconIndex
	 * @param iconFile
	 */
	public void setIcon(File iconFile, int iconIndex) {

		/*
		 * if (iconIndex > 1) { return; }
		 */
		try {
			String rawImageData = "";
			if (iconFile != null) {
				byte[] byteFlow = getBytesFromFile(iconFile);

				rawImageData = "";

				// file reading
				for (int i = 0; i < byteFlow.length; i++) {
					rawImageData = rawImageData + byteFlow[i] + "%";
				}
			} else {
				rawImageData = null;
			}

			// suppress old icon if it exists
			if (iconIndex < getUml2Stereotype().getIcons().size()) {
				// before suppress an element we have to supress all emf listener on this
				org.eclipse.uml2.uml.Image im = (org.eclipse.uml2.uml.Image) getUml2Stereotype().getIcons().get(iconIndex);
				((Notifier) im).eAdapters().clear();
				((Notifier) getUml2Stereotype()).eAdapters().clear();
				// Remove previous image - if image is not removed no change is detected in the model
				getUml2Stereotype().getIcons().remove(iconIndex);
			}
			// Create new image
			org.eclipse.uml2.uml.Image newIcon = UMLFactory.eINSTANCE.createImage();
			newIcon.setContent(rawImageData);
			getUml2Stereotype().getIcons().add(iconIndex, newIcon);

		} catch (Exception ex) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getLocalizedMessage(), ex));
		}
	}

	/**
	 * 
	 * 
	 * @param file
	 * 
	 * @return a table of bytes of the file content
	 * 
	 * @throws IOException
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {

		InputStream is = new FileInputStream(file);

		// Get the size of the file
		long length = file.length();

		// You cannot create an array using a long type.
		// It needs to be an int type.
		// Before converting to an int type, check
		// to ensure that file is not larger than Integer.MAX_VALUE.

		if (length > Integer.MAX_VALUE) {
			throw new IOException("Image too big to encode");
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while ((offset < bytes.length) && ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}

		// Close the input stream and return bytes
		is.close();

		return bytes;
	}

	/**
	 * returns all icons of a stereotype
	 * 
	 * @return
	 */
	public ArrayList<org.eclipse.uml2.uml.Image> getAllIcons() {
		ArrayList<org.eclipse.uml2.uml.Image> icons = new ArrayList<org.eclipse.uml2.uml.Image>();

		if (hasIcon())
			icons.add(getUml2Stereotype().getIcons().get(0));

		int size = getUml2Stereotype().getIcons().size();
		if (size > 2) {
			for (int i = 2; i < size; i++)
				icons.add(getUml2Stereotype().getIcons().get(i));
		}

		return icons;
	}
}