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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.match.MatchOptions;
import org.eclipse.emf.compare.match.engine.AbstractSimilarityChecker;
import org.eclipse.emf.compare.match.engine.internal.GenericMatchEngineToCheckerBridge;
import org.eclipse.emf.compare.match.internal.statistic.NameSimilarity;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.match.metamodel.MatchFactory;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.compare.match.metamodel.Side;
import org.eclipse.emf.compare.match.metamodel.UnmatchElement;
import org.eclipse.emf.compare.util.EMFCompareMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.compare.diff.Activator;
import org.eclipse.papyrus.uml.compare.diff.services.standalone.UMLStandaloneMatchEngine;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.util.UMLUtil;

//TODO verify the super class for UML models
/**
 * 
 * A specific match engine for the Nested UML Compare Editor
 * 
 * @see bug 377154
 */
public class UMLMatchEngine extends UMLStandaloneMatchEngine {//GenericMatchEngine {

	/** the left object to compare */
	protected EObject leftObject;

	/** the right object to compare */
	protected EObject rightObject;

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
	public MatchModel contentMatch(final EObject leftObject, final EObject rightObject, final Map<String, Object> optionMap) {
		this.leftObject = leftObject;
		this.rightObject = rightObject;
		final MatchModel matchModel = super.contentMatch(leftObject, rightObject, optionMap);
		if(this.leftObject.eResource() != null && this.rightObject.eResource() != null) {
			completeMatchModelWithUMLDifferences(matchModel, leftObject, rightObject, optionMap);
			completeMatchWithStereotypeApplications(matchModel, leftObject, rightObject);
		}
		return matchModel;
	}

	/**
	 * 
	 * @param matchModel
	 *        the match model
	 * @param leftObject
	 *        the initial left element used for the comparison
	 * @param rightObject
	 *        the initial right element used for the comparison
	 * 
	 */
	protected void completeMatchWithStereotypeApplications(MatchModel matchModel, EObject leftObject, EObject rightObject) {
		//we check the stereotype application on the compared elements
		AbstractSimilarityChecker checker = prepareChecker();
		final List<MatchElement> supplementaryMatchElement = new ArrayList<MatchElement>();
		final List<UnmatchElement> supplementaryUnmatchedElement = new ArrayList<UnmatchElement>();

		if(leftObject instanceof Element && rightObject instanceof Element) {
			List[] newValue = getAdditionalStereotypeApplicationModelElement(checker, (Element)leftObject, (Element)rightObject);
			supplementaryMatchElement.addAll(newValue[0]);
			supplementaryUnmatchedElement.addAll(newValue[1]);
		}

		//we check the stereotype application for all others matching children
		for(final MatchElement current : matchModel.getMatchedElements().get(0).getSubMatchElements()) {
			if(current instanceof Match2Elements) {
				final EObject left = ((Match2Elements)current).getLeftElement();
				final EObject right = ((Match2Elements)current).getRightElement();
				if(left instanceof Element && right instanceof Element) {
					List[] newValue = getAdditionalStereotypeApplicationModelElement(checker, (Element)left, (Element)right);
					supplementaryMatchElement.addAll(newValue[0]);
					supplementaryUnmatchedElement.addAll(newValue[1]);
				}
			}
		}
		matchModel.getMatchedElements().get(0).getSubMatchElements().addAll(supplementaryMatchElement);
		matchModel.getUnmatchedElements().addAll(supplementaryUnmatchedElement);

	}


	/**
	 * 
	 * @param checker
	 *        the checker
	 * @param left
	 *        the left element
	 * @param right
	 *        the right element
	 * @return
	 *         an array with 2 list : the first one contains the matchedelements to add and the 2nd one contains the unmatched elements to add
	 */
	protected List<?>[] getAdditionalStereotypeApplicationModelElement(final AbstractSimilarityChecker checker, final Element left, final Element right) {
		final List<MatchElement> supplementaryMatchedElementElement = new ArrayList<MatchElement>();
		final List<UnmatchElement> supplementaryUnmatchedElement = new ArrayList<UnmatchElement>();
		final Set<Stereotype> allAppliedStereotypes = new HashSet<Stereotype>();
		allAppliedStereotypes.addAll(left.getAppliedStereotypes());
		allAppliedStereotypes.addAll(right.getAppliedStereotypes());
		for(final Stereotype ste : allAppliedStereotypes) {
			final EObject rightApplication = ((Element)right).getStereotypeApplication(ste);
			final EObject leftApplication = ((Element)left).getStereotypeApplication(ste);
			if(rightApplication != null && leftApplication != null) {
				Match2Elements newMatch = MatchFactory.eINSTANCE.createMatch2Elements();
				newMatch.setLeftElement(leftApplication);
				newMatch.setRightElement(rightApplication);
				double metric = 0.0;
				try {
					metric = checker.absoluteMetric(leftApplication, rightApplication);
				} catch (FactoryException e) {
					Activator.log.error(e);
				}
				newMatch.setSimilarity(metric);
				supplementaryMatchedElementElement.add(newMatch);
			} else if(leftApplication == null) {
				UnmatchElement unmatch = MatchFactory.eINSTANCE.createUnmatchElement();
				unmatch.setConflicting(false);
				unmatch.setElement(rightApplication);
				unmatch.setSide(Side.RIGHT);
				supplementaryUnmatchedElement.add(unmatch);
			} else if(rightApplication == null) {
				UnmatchElement unmatch = MatchFactory.eINSTANCE.createUnmatchElement();
				unmatch.setConflicting(false);
				unmatch.setElement(leftApplication);
				unmatch.setSide(Side.LEFT);
				supplementaryUnmatchedElement.add(unmatch);
			}
		}
		List<?>[] value = new List<?>[2];
		value[0] = supplementaryMatchedElementElement;
		value[1] = supplementaryUnmatchedElement;
		return value;
	}

	/**
	 * This method has been developped to correct the bug 384490: [UML Compare] Comparison between stereotyped elements doesn't work in the nested
	 * Compare Editor
	 * 
	 * @param matchModel
	 * @param leftObject
	 * @param rightObject
	 * @param optionMap
	 */
	protected void completeMatchModelWithUMLDifferences(final MatchModel matchModel, final EObject leftObject, final EObject rightObject, final Map<String, Object> optionMap) {
		/*
		 * the matchModel should have LeftRoot and rightRoot in order to be able to do add the copied stereotype
		 * to the resource -> see mergers :
		 * org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ModelElementChangeLeftTargetTransactionalMerger.getDoUndoInTargetCommand(
		 * TransactionalEditingDomain)
		 * org.eclipse.papyrus.infra.emf.compare.diff.internal.merger.ModelElementChangeRightTargetTransactionalMerger.getDoApplyInOriginCommand(
		 * TransactionalEditingDomain)
		 */
		if(matchModel.getLeftRoots().size() == 0 && matchModel.getRightRoots().size() == 0) {
			matchModel.getLeftRoots().addAll(leftObject.eResource().getContents());
			matchModel.getLeftRoots().add(0, leftObject);
			matchModel.getRightRoots().addAll(rightObject.eResource().getContents());
			matchModel.getRightRoots().add(0, rightObject);
		}

		//we do a resourceMatch to get the stereotypeApplication differences
		final Map<String, Object> stereotypeOptions = new EMFCompareMap<String, Object>(optionMap);
		stereotypeOptions.put(MatchOptions.OPTION_MATCH_SCOPE_PROVIDER, new NestedUMLStereotypeApplicationMatchScopeProvider(leftObject, rightObject));
		MatchModel steMatchModel = null;
		try {
			steMatchModel = super.resourceMatch(leftObject.eResource(), rightObject.eResource(), stereotypeOptions);
		} catch (InterruptedException e) {
			Activator.log.error(e);
		}

		if(steMatchModel != null) {//null when there is no diff...
			final List<UnmatchElement> unmatchedElementToAdd = new ArrayList<UnmatchElement>();
			for(final UnmatchElement current : steMatchModel.getUnmatchedElements()) {
				final EObject stereotypeApplication = UMLUtil.getBaseElement(current.getElement());
				if(stereotypeApplication != null) {
					unmatchedElementToAdd.add(current);
				}
			}
			if(!unmatchedElementToAdd.isEmpty()) {
				matchModel.getUnmatchedElements().addAll(unmatchedElementToAdd);
			}
		}
	}

	/**
	 * 
	 * @param sourceElement
	 *        a uml element
	 * @param stereotypedElement
	 *        a stereotyped element
	 * @return
	 *         <code>true</code> if the stereotyped element is a subelement of the uml element
	 */
	protected boolean isRequiredByTheDiff(final Element sourceElement, Element stereotypedElement) {
		EObject container = stereotypedElement;
		while(container != null) {
			if(container == sourceElement) {
				return true;
			}
			container = container.eContainer();
		}
		return false;
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
