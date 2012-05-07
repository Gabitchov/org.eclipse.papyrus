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
package org.eclipse.papyrus.uml.compare.tatiana;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.GenericMatchEngine;
import org.eclipse.emf.compare.match.statistic.MetamodelFilter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * The implementation of MatchEngine to compare two arbitrary elements, not nesseserily diagrams 
 */
public class ElementContentMatchEngine extends GenericMatchEngine{ //PapyrusMatchEngine {

	/** The my left. */
	private final EObject myLeft;

	/** The my right. */
	private final EObject myRight;

	/**
	 * Instantiates a new element content match engine.
	 *
	 * @param left the left
	 * @param right the right
	 */
	public ElementContentMatchEngine(EObject left, EObject right) {
		this.myLeft = left;
		this.myRight = right;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.compare.match.PapyrusMatchEngine#prepareChecker()
	 */
	@Override
	protected AbstractSimilarityChecker prepareChecker() {
		return new AlwaysSimilarChecker(filter, super.prepareChecker());
	}

	/**
	 * The Class AlwaysSimilarChecker.
	 */
	private class AlwaysSimilarChecker extends AbstractSimilarityChecker {

		/** The delegate. */
		private AbstractSimilarityChecker delegate;

		/**
		 * Instantiates a new always similar checker.
		 *
		 * @param filter the filter
		 * @param fallback the fallback
		 */
		public AlwaysSimilarChecker(MetamodelFilter filter, AbstractSimilarityChecker fallback) {
			super(filter);
			this.delegate = fallback;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker#isSimilar(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
		 */
		/** 
		 * The standard AbstractSimilarityChecker checks the parent of the elements, 
		 * thus, compared elements won't be considered similar. 
		 * To avoid this problem this method always returns true 
		 **/
		@Override
		public boolean isSimilar(EObject obj1, EObject obj2) throws FactoryException {
			return true;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker#init(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public void init(EObject leftObject, EObject rightObject) throws FactoryException {
			delegate.init(leftObject, rightObject);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker#init(org.eclipse.emf.ecore.resource.Resource, org.eclipse.emf.ecore.resource.Resource)
		 */
		@Override
		public void init(Resource leftResource, Resource rightResource) throws FactoryException {
			delegate.init(leftResource, rightResource);
		}

		/* (non-Javadoc)
		 * @see org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker#absoluteMetric(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public double absoluteMetric(EObject obj1, EObject obj2) throws FactoryException {
			return delegate.absoluteMetric(obj1, obj2);
		}
	}

}
