/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.editpart;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.StyleEditPolicy;
import org.eclipse.papyrus.infra.gmfdiag.common.notation.LineStyleProvider;


/**
 * Abstract edit part for all connection nodes. CSS Ready.
 */
//TODO : Intercept the GMF Styles and retrieve the values from the CSS Engine
//TODO: Move this EditPart to infra.gmfdiag.common
public abstract class ConnectionEditPart extends ConnectionNodeEditPart implements IPapyrusEditPart, IStylableEditPart {

	public ConnectionEditPart(View view) {
		super(view);
		//TODO: Implement refresh* to use the StyleEditPolicy
	}


	//Styles implementation

	//        refreshVisibility();
	//        refreshRoutingStyles();
	//        refreshSmoothness();
	//        refreshRoundedBendpoints();
	//        refreshJumplinks();
	//        refreshBendpoints();
	//        refreshFont();

	@Override
	protected final void refreshForegroundColor() {
		LineStyleProvider provider = (LineStyleProvider)getStyleProvider(NotationPackage.eINSTANCE.getLineStyle());
		if(provider == null) {
			super.refreshForegroundColor();
			return;
		}
		setForegroundColor(DiagramColorRegistry.getInstance().getColor(Integer.valueOf(provider.getLineColor())));
	}

	/**
	 * Returns the StyleProvider for the given Style EClass
	 * May be null if a StyleEditPolicy is not defined.
	 * 
	 * @param styleClass
	 * @return
	 */
	protected Object getStyleProvider(EClass styleClass) {
		Object styleEditPolicy = getEditPolicy(StyleEditPolicy.KEY);
		if(styleEditPolicy == null || !(styleEditPolicy instanceof StyleEditPolicy)) {
			return null;
		}

		Object styleProvider = ((StyleEditPolicy)styleEditPolicy).getStyle(styleClass);
		return styleProvider;
	}
}
