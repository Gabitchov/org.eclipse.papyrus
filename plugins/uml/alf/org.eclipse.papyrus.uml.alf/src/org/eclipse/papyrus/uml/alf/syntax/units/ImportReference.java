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

import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;
import org.eclipse.papyrus.uml.alf.syntax.expressions.QualifiedName;

public class ImportReference extends SyntaxElement {

	public QualifiedName referentName ;
	public UnitDefinition unit ;
	public String visibility ;

	//Derived Properties
	public ElementReference referent ;
	
	// Constraints
	
	/*
	 * The referent name of an import reference must resolve to a single element with public or empty
	 * 	visibility.
	 */
	public void checkImportReferenceReferent() {
		
	}
	
	/*
	 * The referent of an import reference is the element denoted by the referent name.
	 */
	public void checkImportReferenceReferentDerivation() {
		
	}
	
}
