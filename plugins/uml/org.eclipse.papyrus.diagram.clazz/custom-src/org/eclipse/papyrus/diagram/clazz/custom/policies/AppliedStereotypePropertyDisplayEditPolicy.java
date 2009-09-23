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
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.policies;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.papyrus.diagram.clazz.custom.helper.PropertyLabelHelper;
import org.eclipse.papyrus.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy;
import org.eclipse.uml2.uml.Property;

/**
 * Specific edit policy for label displaying stereotypes and their properties for edges representing
 * UML elements.
 */
public class AppliedStereotypePropertyDisplayEditPolicy extends AbstractAppliedStereotypeDisplayEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Property getUMLElement() {
		return (Property) super.getUMLElement();
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void refreshDisplay() {
		// calls the helper for this edit Part
		PropertyLabelHelper.getInstance().refreshEditPartDisplay((GraphicalEditPart) getHost());
	}

}
