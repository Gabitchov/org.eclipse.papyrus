/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.navigation;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.papyrus.infra.gmfdiag.navigation.NavigableElement;
import org.eclipse.swt.graphics.Color;

public class UMLNavigationColorProvider implements IColorProvider {

	public Color getForeground(Object element) {
		// not used
		return getBackground(element);
	}

	public Color getBackground(Object element) {
		if (element instanceof NavigableElement) {
			String navType = UMLNavigationHelper.getNavigationType((NavigableElement) element);
			if (UMLNavigationHelper.BEHAVIORAL_NAVIGATION.equals(navType)) {
				return ColorConstants.lightGreen;
			}
			if (UMLNavigationHelper.STRUCTURAL_NAVIGATION.equals(navType)) {
				return ColorConstants.lightBlue;
			}
		}
		return null;
	}

}
