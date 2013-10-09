/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.sync;

import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Parameter;

/**
 * Synchronize behavior parameters
 * 
 * A behavior is often a method for a behavioral feature. In this case, UML validation checks that the number and type
 * of parameters of the behavior and the behavioral feature match.
 * This class synchronizes the parameters of the behavior with that of the behavioral feature.
 */
public class SyncBehaviorParameters {
	public static final void syncParameters(Behavior method) {
		
		BehavioralFeature bf = method.getSpecification();
		if (bf != null) {
			method.getOwnedParameters().clear();
			for (Parameter parameter : bf.getOwnedParameters()) {
				Parameter newParameter = method.createOwnedParameter(parameter.getName(), parameter.getType());
				newParameter.setDirection(parameter.getDirection());
				Copy.copyMultElemModifiers(parameter, newParameter);
				StUtils.copyStereotypes(parameter, newParameter);
			}
		}
	}
}
