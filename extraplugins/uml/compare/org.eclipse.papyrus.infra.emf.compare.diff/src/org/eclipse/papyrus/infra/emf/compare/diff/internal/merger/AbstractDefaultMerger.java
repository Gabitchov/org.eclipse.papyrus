/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.diff.internal.merger;

import org.eclipse.emf.compare.diff.merge.IMerger;


public abstract class AbstractDefaultMerger implements IMerger {

	final public void applyInOrigin() {
		throw new UnsupportedOperationException("This method is not available in a Transactional Compare Editor");
	}

	final public void undoInTarget() {
		throw new UnsupportedOperationException("This method is not available in a Transactional Compare Editor");
	}

}
