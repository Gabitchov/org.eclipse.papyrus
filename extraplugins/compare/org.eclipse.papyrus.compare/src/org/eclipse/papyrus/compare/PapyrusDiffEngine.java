package org.eclipse.papyrus.compare;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.MatchElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.uml.Element;


public class PapyrusDiffEngine extends GenericDiffEngine {
	
	@Override
	protected ReferencesCheck getReferencesChecker() {
		return new ReferencesCheck(matchCrossReferencer) {
			
			@Override
			protected void checkReferenceUpdates(DiffGroup root, Match2Elements mapping, EReference reference) throws FactoryException {
				super.checkReferenceUpdates(root, mapping, reference);
			}
		};
	}

	@Override
	protected void checkForDiffs(DiffGroup current, Match2Elements match) throws FactoryException {
		// temporary hack in order to avoid displaying of StereotypeApplication as a child of resource  
		if (false == match.getLeftElement() instanceof DynamicEObjectImpl) {
			super.checkForDiffs(current, match);
		} 
		checkStereotypeApplication(current, match);
	}
	
	private void checkStereotypeApplication(DiffGroup current, Match2Elements matchElement) throws FactoryException {
		final Iterator<MatchElement> it = matchElement.getSubMatchElements().iterator();
		while (it.hasNext()) {
			final Match2Elements element = (Match2Elements)it.next();
			if (element.getLeftElement() instanceof DynamicEObjectImpl) {
				super.checkForDiffs(current, element);
			}
		}
	}
	
	private List<EObject> getStereotypeApplications(EObject eObject) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		} else {
			return Collections.emptyList();
		}
	}

	
}
