/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.creation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.infra.gmfdiag.css.stylesheets.Theme;
import org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory;
import org.eclipse.swt.widgets.Control;


/**
 * Editor factor for workspace theme.
 * 
 * @author gpascual
 *
 */
public class ThemePropertyEditorFactory extends EcorePropertyEditorFactory {

	/**
	 * Default constructor.
	 *
	 * @param referenceIn
	 */
	public ThemePropertyEditorFactory(EReference referenceIn) {
		super(referenceIn);
	}


	/**
	 * @see org.eclipse.papyrus.views.properties.creation.EcorePropertyEditorFactory#simpleCreateObject(org.eclipse.swt.widgets.Control)
	 *
	 * @param widget
	 * @return
	 */
	@Override
	protected EObject simpleCreateObject(Control widget) {
		EObject createdObject = super.simpleCreateObject(widget);

		//Generate an unique ID for created  theme
		if(createdObject instanceof Theme) {
			((Theme)createdObject).setId(EcoreUtil.generateUUID());
		}

		return createdObject;
	}

}
