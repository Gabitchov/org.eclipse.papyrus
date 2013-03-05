/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.labelprovider.service;

import org.eclipse.swt.graphics.Image;

/**
 * A mix-in interface for label providers that provides qualifier text for model
 * elements. For example, in the case of UML, a qualifier might be the qualified
 * name of the parent element.
 */
public interface IQualifierLabelProvider {

	String getQualifierText(Object element);
	
	Image getQualifierImage(Object element);
}
