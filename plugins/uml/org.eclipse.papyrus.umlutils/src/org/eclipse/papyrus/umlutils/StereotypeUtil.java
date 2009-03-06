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
 *
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Stereotype;

// TODO: Auto-generated Javadoc
/**
 * Utility class for Stereotypes.
 */
public class StereotypeUtil {

	/**
	 * Parse the stereotype image and select those that have an "icon" kind (EAnnotation).
	 * 
	 * @param stereotype
	 *            to parse
	 * 
	 * @return a EList of {@link Image}
	 */
	public static EList<Image> getIcons(Stereotype stereotype) {

		EList<Image> icons = new BasicEList<Image>();

		Iterator<Image> it = stereotype.getIcons().iterator();
		while (it.hasNext()) {
			Image image = it.next();
			if ("icon".equals(ImageUtil.getKind(image))) {
				icons.add(image);
			}
		}

		return icons;
	}

	/**
	 * Parse the stereotype image and select those that have an "shape" kind (EAnnotation).
	 * 
	 * @param stereotype
	 *            to parse
	 * 
	 * @return a EList of {@link Image}
	 */
	public static EList<Image> getShapes(Stereotype stereotype) {

		EList<Image> shapes = new BasicEList<Image>();

		Iterator<Image> it = stereotype.getIcons().iterator();
		while (it.hasNext()) {
			Image image = it.next();
			if ("shape".equals(ImageUtil.getKind(image))) {
				shapes.add(image);
			}
		}

		return shapes;
	}
}
