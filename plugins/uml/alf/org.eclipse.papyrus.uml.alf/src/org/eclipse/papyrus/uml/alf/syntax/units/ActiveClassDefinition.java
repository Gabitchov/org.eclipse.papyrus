/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.alf.syntax.units;

public class ActiveClassDefinition extends ClassDefinition {

	// Synthesized Properties
	public ActivityDefinition classifierBehavior ;

	// Helper Operations
	
	/*
	 * Returns true if the given unit definition matches this active class definition considered as a class
	 * 	definition and the subunit is for an active class definition.
	 */
	public boolean matchForStub(UnitDefinition unit) {
		return false ;
	}
	
}
