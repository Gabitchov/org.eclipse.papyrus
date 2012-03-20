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
package org.eclipse.papyrus.uml.alf.syntax.statements;

import java.util.List;

import org.eclipse.papyrus.uml.alf.syntax.common.ElementReference;
import org.eclipse.papyrus.uml.alf.syntax.common.SyntaxElement;

public class AcceptBlock extends SyntaxElement {

	// Synthesized Properties
	public Block block ;
	public String name ;
	public QualifiedNameList signalNames ;
	
	// Derived Properties
	public List<ElementReference> signal ;
	
	// Constraints
	
	/*
	 * The signals of an accept block are the referents of the signal names of the accept block.
	 */
	public void checkAcceptBlockSignalDerivation() {
		
	}
	
	/*
	 * All signal names in an accept block must resolve to signals.
	 */
	public void checkAcceptBlockSignalNames() {
		
	}
	
	
}
