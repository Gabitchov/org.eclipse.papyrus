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
 *  Adapted code from EMF-Compare
 *****************************************************************************/
package org.eclipse.papyrus.uml.compare.diff.internal.merger;

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.DefaultExtensionTransactionalMerger;

/**
 * Merger of UMLProfileApplicationAddition differences.
 * 
 * @author Cedric Notot <a href="mailto:cedric.notot@obeo.fr">cedric.notot@obeo.fr</a>
 */
public class UMLProfileApplicationAdditionMerger extends DefaultExtensionTransactionalMerger {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultExtensionMerger#isBusinessDependency(boolean,
	 *      org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension)
	 */
	@Override
	protected boolean isBusinessDependency(boolean applyInOrigin, AbstractDiffExtension requiredDiff) {
		return applyInOrigin;
	}

}
