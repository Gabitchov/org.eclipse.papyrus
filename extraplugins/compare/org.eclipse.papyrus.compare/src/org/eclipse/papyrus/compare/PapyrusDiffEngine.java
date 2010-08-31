package org.eclipse.papyrus.compare;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.internal.statistic.ResourceSimilarity;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.compare.util.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;


public class PapyrusDiffEngine extends GenericDiffEngine {

	@Override
	protected void checkForDiffs(DiffGroup current, Match2Elements match) throws FactoryException {
		// temporary hack in order to avoid displaying of StereotypeApplication as a child of resource  
		if(!isStereotypeApplication(match.getLeftElement())) {
			super.checkForDiffs(current, match);
		}
		checkStereotypesForElement(current, match);
	}

	private boolean isStereotypeApplication(EObject eobject) {
		return eobject instanceof DynamicEObjectImpl;
	}

	private void checkStereotypesForElement(DiffGroup current, Match2Elements matchElement) throws FactoryException {
		final Iterator<MatchElement> it = matchElement.getSubMatchElements().iterator();
		while(it.hasNext()) {
			final Match2Elements element = (Match2Elements)it.next();
			if(element.getLeftElement() instanceof DynamicEObjectImpl) {
				super.checkForDiffs(current, element);
			}
		}
	}

	@Override
	protected ReferencesCheck getReferencesChecker() {
		return new ReferencesCheck(matchCrossReferencer) {

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

		};
	}

}
