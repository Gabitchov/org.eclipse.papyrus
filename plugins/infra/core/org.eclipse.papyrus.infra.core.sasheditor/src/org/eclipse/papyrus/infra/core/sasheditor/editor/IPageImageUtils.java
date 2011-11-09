/*****************************************************************************
 * Copyright (c) 2011 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;


/**
 * Utility class to get an Image from an IPage.
 * 
 * @author cedric dumoulin
 * 
 */
public class IPageImageUtils {


	/**
	 * Get an Image of the page.
	 * The Image is build from the Control.
	 * 
	 * @param The IPage for which an Image is requested.
	 * @return The Image of the page, or null if no Image can be built.
	 */
	static public Image getPageImage(IPage page) {
		Rectangle size;
		Control control = page.getControl();

		size = control.getBounds();
		if(size.width == 0 && size.height == 0) {
			Point pt = control.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			size = new Rectangle(0, 0, pt.x, pt.y);
		}

		Image image = new Image(control.getDisplay(), size);
		GC gc = new GC(image);

		boolean success = control.print(gc);
		gc.dispose();
		if(!success) {
			image.dispose();
			return null;
		}

		return image;
	}
}
