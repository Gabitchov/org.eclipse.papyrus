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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram 
 *****************************************************************************/
package org.eclipse.papyrus.diagram.profile.custom.policies;

import org.eclipse.papyrus.diagram.profile.custom.helper.AssociationEndTargetLabelHelper;

public class DisplayAssociationEndTargetEditPolicy extends DisplayAssociationEndEditPolicy {

	/**
	 * Instantiates a new display association end target edit policy.
	 */
	public DisplayAssociationEndTargetEditPolicy() {
		super();
		propertyLabelHelper = AssociationEndTargetLabelHelper.getInstance();
	}

}
