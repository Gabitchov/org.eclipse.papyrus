/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arthur Daussy (Atos) arthur.daussy@atos.net - Bug 249786: [General] drag'n'drop does not work for elements stored in nested classifier compartment
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.policies;


import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

import com.google.common.collect.ImmutableSet;

/**
 * This EditPolicy listener the {@link UMLPackage.Literals#INTERFACE__NESTED_CLASSIFIER} {@link EStructuralFeature}.
 * It adds element when added
 * It removes element when deleted
 * 
 * @author arthur daussy
 * 
 */
public class InterfaceNestedClassifierListenerEditPolicy extends AbstractNestedClassifierListenerEditPolicy {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.editpolicies.ListenerEventEditPolicy#getEStructuralFeaturesToListen()
	 * 
	 * @return {@link ImmutableSet}
	 */
	public ImmutableSet<EStructuralFeature> getEStructuralFeaturesToListen() {
		return ImmutableSet.of((EStructuralFeature)UMLPackage.Literals.INTERFACE__NESTED_CLASSIFIER);
	}


}
