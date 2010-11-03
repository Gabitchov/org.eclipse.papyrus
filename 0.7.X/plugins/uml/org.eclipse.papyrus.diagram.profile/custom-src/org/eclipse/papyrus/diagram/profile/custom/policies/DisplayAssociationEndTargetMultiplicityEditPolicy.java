/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from Class Diagram
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies;

import org.eclipse.papyrus.umlutils.ICustomAppearence;

/**
 * this class enables to refresh the multiplicity label of the association end (target)
 * 
 */
public class DisplayAssociationEndTargetMultiplicityEditPolicy extends DisplayAssociationEndTargetEditPolicy {

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.clazz.custom.policies.DisplayAssociationEndEditPolicy#getDefaultDisplayValue()
	 * 
	 */
	@Override
	public int getDefaultDisplayValue() {
		return ICustomAppearence.DISP_MULTIPLICITY;
	}

}
