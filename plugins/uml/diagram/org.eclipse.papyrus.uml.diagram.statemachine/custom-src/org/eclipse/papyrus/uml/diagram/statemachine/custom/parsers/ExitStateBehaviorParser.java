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
 *   Arthur daussy (Atos) arthur.daussy@atos.net - Bug : 365405: [State Machine Diagram] Behaviours (Entry,exit,do) on states should have their own mechanisms
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.statemachine.custom.parsers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * parser for entry behavior state label
 * 
 * @author adaussy
 * 
 */
public class ExitStateBehaviorParser extends AbstractStateBehaviorsParser {

	private AbstractStateBehaviorsParser.BehaviorType myBehavior = null;

	@Override
	protected BehaviorType getParserType() {
		if(myBehavior == null) {
			myBehavior = new AbstractStateBehaviorsParser.BehaviorType() {

				public String getKeyWord() {
					return Messages.ExitStateBehaviorParser_EXIT_KEYWORD;
				}

				public EStructuralFeature getEStructuralFeature() {
					return UMLPackage.Literals.STATE__EXIT;
				}
			};
		}
		return myBehavior;
	}

}
