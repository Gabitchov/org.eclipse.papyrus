package org.eclipse.papyrus.compare;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.compare.FactoryException;
import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.AttributesCheck;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.UpdateContainmentFeature;
import org.eclipse.emf.compare.match.metamodel.Match2Elements;
import org.eclipse.emf.compare.match.metamodel.Match3Elements;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationHelper;


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
	
	private void checkStereotypeApplication(DiffGroup current, Match2Elements matchElement) {
		final EObject leftElement = matchElement.getLeftElement();
		final EObject rightElement = matchElement.getRightElement();
		for (EObject stereotypeApp: getStereotypeApplications(leftElement)) {
			createUpdateStereotypeApplication(current, leftElement, stereotypeApp, rightElement);
		}
	}
	
	private List<EObject> getStereotypeApplications(EObject eObject) {
		if (eObject instanceof Element) {
			return ((Element)eObject).getStereotypeApplications();
		} else {
			return Collections.emptyList();
		}
	}

	
	private void createUpdateStereotypeApplication(DiffGroup root, EObject leftElement, EObject leftProfileApp, EObject right) {
		final UpdateContainmentFeature updateContainment = DiffFactory.eINSTANCE
				.createUpdateContainmentFeature();
		updateContainment.setLeftElement(leftProfileApp);
		updateContainment.setRightElement(right);
		updateContainment.setRightTarget(getMatchedEObject(leftElement));
		updateContainment.setLeftTarget(getMatchedEObject(right.eContainer()));
		root.getSubDiffElements().add(updateContainment);
	}


}
