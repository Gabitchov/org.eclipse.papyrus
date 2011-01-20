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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.internal.statistic.ResourceSimilarity;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;

public class UMLReferenceCheck extends ReferencesCheck {

	public UMLReferenceCheck(CrossReferencer referencer) {
		super(referencer);
	}

	@Override
	protected void checkReferenceUpdates(DiffGroup root, Match2Elements mapping, EReference reference) throws FactoryException {
		if(reference.isMany() && isSimilarSingleReference(mapping, reference)) {
			return;
		}
		super.checkReferenceUpdates(root, mapping, reference);
	}

	private boolean isSimilarSingleReference(Match2Elements mapping, EReference reference) throws FactoryException {
		final double similarReferenceURIThreshold = 0.8d;
		final List<Object> leftElementObjReferences = convertFeatureMapList(EFactory.eGetAsList(mapping.getLeftElement(), reference.getName()));
		final List<Object> rightElementObjReferences = convertFeatureMapList(EFactory.eGetAsList(mapping.getRightElement(), reference.getName()));


		// All values should be EObjects
		final List<EObject> leftElementReferences = new ArrayList<EObject>();
		final List<EObject> rightElementReferences = new ArrayList<EObject>();
		for(Object left : leftElementObjReferences) {
			leftElementReferences.add((EObject)left);
		}
		for(Object right : rightElementObjReferences) {
			rightElementReferences.add((EObject)right);
		}

		final List<EObject> deletedReferences = computeDeletedReferences(leftElementReferences, rightElementReferences);
		final List<EObject> addedReferences = computeAddedReferences(leftElementReferences, rightElementReferences);
		if(addedReferences.size() == 1 && deletedReferences.size() == 1) {
			EObject addedValue = addedReferences.get(0);
			EObject deletedValue = deletedReferences.get(0);

			final double uriSimilarity = ResourceSimilarity.computeURISimilarity(EcoreUtil.getURI(addedValue), EcoreUtil.getURI(deletedValue));
			if(uriSimilarity >= similarReferenceURIThreshold) {
				return true;
			}
		}
		return false;
	}

	private List<EObject> computeAddedReferences(List<EObject> leftReferences, List<EObject> rightReferences) {
		final List<EObject> deletedReferences = new ArrayList<EObject>();
		final List<EObject> addedReferences = new ArrayList<EObject>();
		final double similarReferenceURIThreshold = 0.8d;

		if(leftReferences != null) {
			addedReferences.addAll(leftReferences);
		}
		if(rightReferences != null) {
			deletedReferences.addAll(rightReferences);
		}
		final List<EObject> matchedOldReferences = getMatchedReferences(deletedReferences);

		// "Added" references are the references from the left element that
		// have no matching "right" counterpart
		addedReferences.removeAll(matchedOldReferences);

		return addedReferences;
	}

	/**
	 * This will create and populate a {@link List} with all the references from the <code>rightReferences</code> {@link List} that cannot be
	 * matched in the <code>leftReferences</code> {@link List}.
	 * 
	 * @param leftReferences
	 *        List of the left element reference values.
	 * @param rightReferences
	 *        List of the right element reference values.
	 * @return {@link List} of all the references that have been deleted from the left (local) element since
	 *         the right (distant) element.
	 */
	private List<EObject> computeDeletedReferences(List<EObject> leftReferences, List<EObject> rightReferences) {
		final List<EObject> deletedReferences = new ArrayList<EObject>();
		final List<EObject> addedReferences = new ArrayList<EObject>();
		final double similarReferenceURIThreshold = 0.8d;

		if(leftReferences != null) {
			addedReferences.addAll(leftReferences);
		}
		if(rightReferences != null) {
			deletedReferences.addAll(rightReferences);
		}
		final List<EObject> matchedNewReferences = getMatchedReferences(addedReferences);

		// "deleted" references are the references from the right element that
		// have no counterpart in the left element
		deletedReferences.removeAll(matchedNewReferences);

		return deletedReferences;
	}

	private List<EObject> getMatchedReferences(List<EObject> references) {
		final List<EObject> matchedReferences = new ArrayList<EObject>();
		final Iterator<EObject> refIterator = references.iterator();
		while(refIterator.hasNext()) {
			final Object currentReference = refIterator.next();
			if(currentReference != null) {
				final EObject currentMapped = getMatchedEObject((EObject)currentReference);
				if(currentMapped != null) {
					matchedReferences.add(currentMapped);
				}
			}
		}
		return matchedReferences;
	}

}