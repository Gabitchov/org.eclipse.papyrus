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
package org.eclipse.papyrus.uml.compare.merger.services.nested;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.internal.DistinctEcoreSimilarityChecker;
import org.eclipse.emf.compare.match.engine.internal.GenericMatchEngineToCheckerBridge;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.ecore.EObject;

//TODO : verify the upper class for UML
/**
 * 
 * A specific similarity checker for the Nested UML Compare Editor
 * @see bug 377154
 */
public class UMLSimilarityChecker extends DistinctEcoreSimilarityChecker {

	/** the left object to compare */
	private final EObject rootLeft;

	/** the right object to compare */
	private final EObject rootRight;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param filter
	 * @param bridge
	 * @param left
	 *        the left object to compare
	 * @param right
	 *        the right object to compare
	 */
	public UMLSimilarityChecker(final MetamodelFilter filter, final GenericMatchEngineToCheckerBridge bridge, final EObject left, final EObject right) {
		super(filter, bridge);
		this.rootLeft = left;
		this.rootRight = right;
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.match.engine.internal.DistinctEcoreSimilarityChecker#isSimilar(org.eclipse.emf.ecore.EObject,
	 *      org.eclipse.emf.ecore.EObject)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 * @throws FactoryException
	 */
	@Override
	public boolean isSimilar(final EObject obj1, final EObject obj2) throws FactoryException {

		/**
		 * We consider that the compared element are always similar (but there names can be different!)
		 */
		if(obj1 == rootLeft || obj1 == rootRight) {
			if(obj2 == rootLeft || obj2 == rootRight) {
				return true;
			}
		}
		return super.isSimilar(obj1, obj2);
	}
}
