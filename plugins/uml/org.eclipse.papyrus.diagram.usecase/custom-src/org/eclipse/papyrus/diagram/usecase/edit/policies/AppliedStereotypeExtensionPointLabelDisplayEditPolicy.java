/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.policies;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.diagram.usecase.helper.ExtensionPointLabelHelper;
import org.eclipse.uml2.uml.ExtensionPoint;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 * 
 * @author eperico
 */
public class AppliedStereotypeExtensionPointLabelDisplayEditPolicy extends AppliedStereotypeLabelDisplayEditPolicy 
{
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ExtensionPoint getUMLElement() {
		return (ExtensionPoint) super.getUMLElement();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {		
		// calls the helper for this edit Part
		ExtensionPointLabelHelper.refreshEditPartDisplay((GraphicalEditPart) getHost());
		super.refreshDisplay();
	}

}
