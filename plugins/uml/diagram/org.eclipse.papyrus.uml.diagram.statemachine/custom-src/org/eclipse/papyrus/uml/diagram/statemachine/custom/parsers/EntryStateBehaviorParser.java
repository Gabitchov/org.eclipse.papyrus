/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.parsers;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * parser for entry behavior state label
 * 
 * @author adaussy
 * 
 */
public class EntryStateBehaviorParser extends AbstractStateBehaviorsParser {

	private AbstractStateBehaviorsParser.BehaviorType myBehavior = null;

	@Override
	protected BehaviorType getParserType() {
		if(myBehavior == null) {
			myBehavior = new AbstractStateBehaviorsParser.BehaviorType() {

				public String getKeyWord() {
					return Messages.EntryStateBehaviorParser_ENTRY_KEYWORD;
				}

				public EStructuralFeature getEStructuralFeature() {
					return UMLPackage.Literals.STATE__ENTRY;
				}
			};
		}
		return myBehavior;
	}

}
