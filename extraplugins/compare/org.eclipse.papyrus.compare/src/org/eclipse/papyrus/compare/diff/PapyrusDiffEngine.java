/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare.diff;


import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;


public class PapyrusDiffEngine extends GenericDiffEngine {

	@Override
	protected ReferencesCheck getReferencesChecker() {
		return new UMLReferenceCheck(matchCrossReferencer);
	}

}
