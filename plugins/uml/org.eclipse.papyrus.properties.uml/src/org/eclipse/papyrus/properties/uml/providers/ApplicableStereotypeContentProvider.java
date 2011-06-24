/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.uml2.uml.Element;


public class ApplicableStereotypeContentProvider extends AbstractStaticContentProvider {

	private Element umlElement;

	public ApplicableStereotypeContentProvider(Element umlElement) {
		this.umlElement = umlElement;
	}

	public Object[] getElements() {
		return umlElement.getApplicableStereotypes().toArray();
	}

}
