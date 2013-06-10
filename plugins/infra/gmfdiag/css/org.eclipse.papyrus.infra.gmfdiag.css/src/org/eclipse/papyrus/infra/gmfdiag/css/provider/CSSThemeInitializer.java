/*****************************************************************************
 * Copyright (c) 2012, 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - support adapter instead of custom resource impl for CSS (CDO)
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.provider;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.providers.IThemeInitializer;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.resource.CSSNotationResource;

/**
 * A class to skip the PreferenceInitializer when the CSS support is enabled.
 * 
 * @author Camille Letavernier
 */
public class CSSThemeInitializer implements IThemeInitializer {

	/**
	 * Return false when the CSS support is enabled
	 */
	public boolean usePreferenceInitializer(View view) {
		//Sometimes, the view is created before its diagram is attached to its resource
		//This happens in diagrams which are initialized with a root element (Activity, Sequence, StateMachine, IBD, ...)
		//In this case, it is better to test the CSSDiagram than the resource (As there is no resource yet)
		if(view.getDiagram() != null) {
			return !(view.getDiagram() instanceof CSSDiagram);
		}

		Resource resource = view.eResource();

		return !CSSNotationResource.isCSSEnabled(resource);
	}

}
