/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for TimeObservation
 */
public class TimeObservationNodeFigure extends AbstractObservationNodeFigure {

	public static final String IMAGE_OBSERVATION = "TimeObservation.gif"; //$NON-NLS-1$

	public void setAppliedStereotypeIcon(Image image) {
		if(image == null) {
			setIcon(Activator.getPluginIconImage(ID, PATH + IMAGE_OBSERVATION));
		} else {
			setIcon(image);
		}
	}
}
