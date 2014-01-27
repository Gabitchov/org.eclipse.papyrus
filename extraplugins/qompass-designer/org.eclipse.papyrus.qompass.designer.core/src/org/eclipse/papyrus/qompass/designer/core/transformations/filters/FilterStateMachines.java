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

package org.eclipse.papyrus.qompass.designer.core.transformations.filters;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.qompass.designer.core.listeners.CopyListener;
import org.eclipse.papyrus.qompass.designer.core.transformations.Copy;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Transition;


public class FilterStateMachines implements CopyListener {

	public static FilterStateMachines getInstance() {
		if(instance == null) {
			instance = new FilterStateMachines();
		}
		return instance;
	}

	public EObject copyEObject(Copy copy, EObject sourceEObj) {
		if(sourceEObj instanceof StateMachine) {
			StateMachine sm = (StateMachine)sourceEObj;
			Class tmClass = getTargetClass(copy, sm);

			// copy opaque behavior in state machine to class level
			for(Region region : sm.getRegions()) {
				for(Transition transition : region.getTransitions()) {
					Behavior effect = transition.getEffect();
					if(effect != null) {
						if(tmClass != null) {
							String newName = sm.getName() + "_" + transition.getName()	//$NON-NLS-1$
									+ "_" + effect.getName(); //$NON-NLS-1$
							moveBehavior(newName, tmClass, effect);
						}
					}
				}
			}
			// remove state machine
			return null;
		}
		return sourceEObj;
	}

	public Class getTargetClass(Copy copy, StateMachine sm) {
		Element smOwner = sm.getOwner();
		EObject tmOwner = copy.getMap(smOwner).get(smOwner);
		if(tmOwner instanceof Class) {
			return (Class)tmOwner;
		}
		return null;
	}

	public void moveBehavior(String newName, Class tmClass, Behavior effect) {
		Behavior copiedEffect = EcoreUtil.copy(effect);
		if(tmClass.getOwnedOperation(newName, null, null) != null) {
			// has already been added
			return;
		}
		Operation operation = tmClass.createOwnedOperation(newName, null, null);
		copiedEffect.setSpecification(operation);
		copiedEffect.setName(newName);
		tmClass.getOwnedBehaviors().add(copiedEffect);

	}

	private static FilterStateMachines instance = null;
}
