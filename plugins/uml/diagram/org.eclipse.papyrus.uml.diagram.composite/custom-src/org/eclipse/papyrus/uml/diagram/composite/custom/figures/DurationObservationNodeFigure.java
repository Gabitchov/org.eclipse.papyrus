/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.composite.custom.figures;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for DurationObservation
 */
public class DurationObservationNodeFigure extends AbstractObservationNodeFigure {

	public static final String IMAGE_DURATION = "DurationObservation.gif"; //$NON-NLS-1$

	public void setAppliedStereotypeIcon(Image image) {
		if(image == null) {
			setIcon(Activator.getPluginIconImage(ID, PATH + IMAGE_DURATION));
		} else {
			setIcon(image);
		}
	}

}
