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
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.papyrus.uml.tools.utils.ICustomAppearence;

/**
 * this class enables to refresh the multiplicity label of the association end (source)
 *
 */
public class DisplayAssociationEndSourceMultiplicityEditPolicy extends DisplayAssociationEndSourceEditPolicy {

	/**
	 *
	 * @see org.eclipse.papyrus.uml.diagram.clazz.custom.policies.DisplayAssociationEndEditPolicy#getDefaultDisplayValue()
	 *
	 */
	@Override
	public Collection<String> getDefaultDisplayValue() {
		return Collections.singleton(ICustomAppearence.DISP_MULTIPLICITY);
	}
}
