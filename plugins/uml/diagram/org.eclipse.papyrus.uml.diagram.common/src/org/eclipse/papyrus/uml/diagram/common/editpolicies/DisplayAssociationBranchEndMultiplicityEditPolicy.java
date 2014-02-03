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
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.uml.tools.utils.ICustomAppearance;

/**
 * this class enables to refresh the multiplicity label of the association end (target)
 *
 */
public class DisplayAssociationBranchEndMultiplicityEditPolicy extends DisplayAssociationBranchEndEditPolicy {

	/**
	 *
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.DisplayAssociationEndEditPolicy#getDefaultDisplayValue()
	 *
	 */
	@Override
	protected Collection<String> getDefaultDisplayValue() {
		return Collections.singleton(ICustomAppearance.DISP_MULTIPLICITY);
	}
}
