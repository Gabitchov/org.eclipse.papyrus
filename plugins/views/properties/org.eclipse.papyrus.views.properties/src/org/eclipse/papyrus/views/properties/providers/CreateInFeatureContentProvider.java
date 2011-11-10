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
package org.eclipse.papyrus.views.properties.providers;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;


public interface CreateInFeatureContentProvider extends IStaticContentProvider, IStructuredContentProvider {

	/**
	 * Sets the type of feature we're looking for
	 * 
	 * @param type
	 */
	public void setType(EClass type);
}
