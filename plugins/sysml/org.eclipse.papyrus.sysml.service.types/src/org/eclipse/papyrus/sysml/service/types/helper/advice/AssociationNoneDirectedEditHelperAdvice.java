/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper.advice;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/** 
 * Edit helper advice for {@link Association} with "aggregation = none" and navigable in one way (used for creation purpose only). 
 */
public class AssociationNoneDirectedEditHelperAdvice extends AssociationNoneEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * The currently created {@link Association} in the default case (aggregation = none), and directed 
	 * (meaning navigable in one direction only) which in SysML means the target end is owned by the association itself.
	 * 
	 * Moreover this end name should not be set in that case, this latter rule is not followed here for now. 
	 * 
	 * </pre>
	 */
	@Override
	protected void addTargetInModel(Property targetEnd, Classifier owner, Type sourceType, Association association) {
		association.getOwnedEnds().add(targetEnd);
	}
}
