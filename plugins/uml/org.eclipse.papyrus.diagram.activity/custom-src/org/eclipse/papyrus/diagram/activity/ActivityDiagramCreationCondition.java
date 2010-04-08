/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.extension.commands.ICreationCondition;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Package;

/**
 * ActivityDiagramCreationCondition class allows to check if an Activity diagram can be added to the
 * selected element.
 */
public class ActivityDiagramCreationCondition implements ICreationCondition {

	/**
	 * @return whether the diagram can be created.
	 */
	public boolean create(EObject selectedElement) {
		// FIXME creation under BehavioredClassifier disabled for now (until bug 348 fixed)
		if(selectedElement instanceof Activity && selectedElement.eContainer() instanceof BehavioredClassifier) {
			return false;
		}
		return selectedElement instanceof Activity || selectedElement instanceof Package;// || selectedElement instanceof BehavioredClassifier;
	}

}
