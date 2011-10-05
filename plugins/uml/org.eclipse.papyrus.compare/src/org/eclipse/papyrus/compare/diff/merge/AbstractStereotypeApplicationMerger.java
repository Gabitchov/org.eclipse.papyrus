/**
 * 
 *  Copyright (c) 2011 CEA LIST.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *      Vincent Lorenzo(CEA LIST) - initial API and implementation
 */
package org.eclipse.papyrus.compare.diff.merge;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.compare.diff.merge.DefaultMerger;
import org.eclipse.emf.compare.diff.merge.EMFCompareEObjectCopier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * 
 * Abstract Class for the Stereotype Application Merger
 * 
 */
public class AbstractStereotypeApplicationMerger extends DefaultMerger {

	/**
	 * 
	 * @see org.eclipse.emf.compare.diff.merge.DefaultMerger#copy(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param eObject
	 * @return
	 */
	protected EObject copy(EObject eObject) {
		final EMFCompareEObjectCopier copier = new StereotypeApplicationCopier(getDiffModel());
		final EObject result = copier.copy(eObject);
		copier.copyReferences();
		copier.copyXMIIDs();
		return result;
	}
	
	
}
