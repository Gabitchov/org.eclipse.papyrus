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
package org.eclipse.papyrus.uml.compare.diff.services.nested;

import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.engine.internal.GenericMatchEngineToCheckerBridge;
import org.eclipse.emf.compare.match.internal.statistic.NameSimilarity;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneMatchEngine;

//TODO verify the super class for UML models
/**
 * 
 * A specific match engine for the Nested UML Compare Editor
 * 
 * @see bug 377154
 */
public class UMLMatchEngine extends UMLStandaloneMatchEngine{//GenericMatchEngine {

	/** the left object to compare */
	private EObject leftObject;

	/** the right object to compare */
	private EObject rightObject;

	/**
	 * 
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchEngine#contentMatch(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject,
	 *      java.util.Map)
	 * 
	 * @param leftObject
	 * @param rightObject
	 * @param optionMap
	 * @return
	 */
	@Override
	public MatchModel contentMatch(EObject leftObject, EObject rightObject, Map<String, Object> optionMap) {
		this.leftObject = leftObject;
		this.rightObject = rightObject;
		return super.contentMatch(leftObject, rightObject, optionMap);
	}

	/**
	 * 
	 * @see org.eclipse.emf.compare.match.engine.GenericMatchEngine#prepareChecker()
	 * 
	 * @return
	 */
	protected AbstractSimilarityChecker prepareChecker() {
		AbstractSimilarityChecker checker = null;
		GenericMatchEngineToCheckerBridge bridge = new UMLGenericMatchEngineToCheckerBridge();
		Assert.isNotNull(leftObject);
		Assert.isNotNull(rightObject);
		checker = new UMLSimilarityChecker(filter, bridge, leftObject, rightObject);
		return checker;
	}


	/**
	 * 
	 * Duplicate code from GenericMatchEngine
	 * 
	 */
	private class UMLGenericMatchEngineToCheckerBridge extends GenericMatchEngineToCheckerBridge {

		@Override
		public double contentSimilarity(EObject obj1, EObject obj2) throws FactoryException {
			double similarity = 0d;
			try {

				similarity = NameSimilarity.nameSimilarityMetric(NameSimilarity.findName(obj1), NameSimilarity.findName(obj2));
			} catch (final FactoryException e) {
				// fails silently, will return a similarity of 0d
			}
			return similarity;
		}

		@Override
		public double nameSimilarity(EObject obj1, EObject obj2) {
			double similarity = 0d;
			try {
				similarity = NameSimilarity.nameSimilarityMetric(NameSimilarity.contentValue(obj1), NameSimilarity.contentValue(obj2));
			} catch (FactoryException e) {
				// fails silently, will return a similarity of 0d
			}
			return similarity;
		}

	}
}
