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

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/** 
 * Edit helper advice for {@link Association} with "aggregation = shared" (used for creation purpose only).
 */
public class AssociationSharedEditHelperAdvice extends AssociationNoneEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * The currently created {@link Association} is Shared (manage by super class):
	 * 		it source {@link Property} aggregation is set to Shared kind. 
	 * 
	 * The currently created {@link Association} is bidirectional (navigable in both directions):
	 * 		it source and target {@link Property} are owned by the {@link Classifier} (target and source end types),
	 * 		this is handled by the super class.
	 * </pre>
	 */
	@Override
	protected void configureSourceProperty(Property sourceProperty) {
		sourceProperty.setAggregation(AggregationKind.SHARED_LITERAL);
	}
}