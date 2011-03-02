/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.customization.providers;

import org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelLabelProvider;
import org.eclipse.papyrus.properties.customization.Activator;

/**
 * The customization editor's label provider. Based on the EMF Facet
 * customizable label provider,
 * 
 * @author Camille Letavernier
 */
public class ContextLabelProvider extends CustomizableModelLabelProvider {

	/**
	 * Constructor.
	 */
	public ContextLabelProvider() {
		super(Activator.getDefault().getCustomizationManager());
	}

}
