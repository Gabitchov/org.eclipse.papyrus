/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *  	Nicolas Bros (Mia-Software) - Bug 374941 - To be able to customize overlay icons on EClass
 */
package org.eclipse.emf.facet.custom.ui.internal.custompt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.eclipse.emf.facet.custom.metamodel.custompt.IImage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

public class ImageWrapper implements IImage {

	private static final long serialVersionUID = -2538802017710069448L;
	private final Image wrappedImage;

	public ImageWrapper(final Image image) {
		this.wrappedImage = image;
	}

	public InputStream getInputStream() {
		// note: this is an inefficient way to get an inputStream from the wrapped Image
		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		final ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] { this.wrappedImage.getImageData() };
		loader.save(stream, SWT.IMAGE_PNG);
		final byte[] byteArray = stream.toByteArray();
		return new ByteArrayInputStream(byteArray);
	}

	public Image getImage() {
		return this.wrappedImage;
	}

}
