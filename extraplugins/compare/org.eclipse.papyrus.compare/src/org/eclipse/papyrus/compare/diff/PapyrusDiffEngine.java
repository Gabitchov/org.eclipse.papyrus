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


import java.util.Iterator;

import org.eclipse.emf.compare.diff.engine.GenericDiffEngine;
import org.eclipse.emf.compare.diff.engine.check.ReferencesCheck;
import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.MoveModelElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.compare.match.metamodel.MatchModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.extension.TaggedValueElementBuilder;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


public class PapyrusDiffEngine extends GenericDiffEngine {

	private DiffSwitch<DiffElement> myDiffElementBuilder = new TaggedValueElementBuilder();

	@Override
	protected ReferencesCheck getReferencesChecker() {
		return new UMLReferenceCheck(matchCrossReferencer);
	}
	
	@Override
	public DiffModel doDiff(MatchModel match, boolean threeWay) {
		DiffModel result = super.doDiff(match, threeWay);
		postProcess(result);
		return result;
	}


	private void postProcess(DiffModel diffModel) {
		final Iterator<EObject> it = diffModel.eAllContents();
		while(it.hasNext()) {
			DiffElement diffElement = (DiffElement)it.next();
			visitElement(diffModel, diffElement);
		}
	}
	
	protected void visitElement(DiffModel root, DiffElement diffElement) {
		AbstractDiffExtension hack = UMLDiffFactory.eINSTANCE.createUpdateTaggedValue();
		EObject stereotypeApplication = getStereotypeApplication(diffElement);
		boolean hasStereotypeApplication = stereotypeApplication != null; 
		if(hasStereotypeApplication) {			
			hack.getHideElements().add(diffElement);
			
			Element newVisualParent = UMLUtil.getBaseElement(stereotypeApplication);
			DiffElement newDiffParent = findOrCreateDiffElementFor(root, newVisualParent);
			DiffElement taggedValueDiff = myDiffElementBuilder.doSwitch(diffElement);
			newDiffParent.getSubDiffElements().add(taggedValueDiff);
		}
		if (diffElement instanceof MoveModelElement) {
			// HACK
			hack.getHideElements().add(diffElement);
		}
	}
	
	protected EObject getStereotypeApplication(DiffElement element) {
		if (element instanceof UMLDiffExtension) {
			return null;
		}
		if(element instanceof AttributeChange) {
			AttributeChange attributeChange = (AttributeChange)element;
			EObject stereotypeApplication = attributeChange.getRightElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
			stereotypeApplication = attributeChange.getLeftElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
		} else if(element instanceof ReferenceChange) {
			ReferenceChange referenceChange = (ReferenceChange)element;
			EObject stereotypeApplication = referenceChange.getLeftElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
			stereotypeApplication = referenceChange.getRightElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
		} else if (element instanceof ModelElementChangeLeftTarget) {
			EObject stereotypeApplication = ((ModelElementChangeLeftTarget)element).getLeftElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
		} else if (element instanceof ModelElementChangeRightTarget) {
			EObject stereotypeApplication = ((ModelElementChangeRightTarget)element).getRightElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
		}
		return null;
	}

	private DiffElement findOrCreateDiffElementFor(DiffModel root, EObject object) {
		if(object == null) {
			if(!root.getOwnedElements().isEmpty()) {
				return root.getOwnedElements().get(0);
			}
			DiffGroup diffRoot = DiffFactory.eINSTANCE.createDiffGroup();
			root.getOwnedElements().add(diffRoot);
			return diffRoot;
		}
		DiffElement element = findDiffElementFor(root, object);
		if(element != null) {
			return element;
		}

		DiffElement diffParent = findOrCreateDiffElementFor(root, getParent(object));
		DiffGroup diffElementForObject = DiffFactory.eINSTANCE.createDiffGroup();
		diffElementForObject.setRightParent(object);

		diffParent.getSubDiffElements().add(diffElementForObject);
		return diffElementForObject;
	}

	private EObject getParent(EObject modelElement) {
		return modelElement.eContainer();
	}

	private DiffElement findDiffElementFor(DiffModel root, EObject modelElement) {
		if(modelElement == null) {
			return null;
		}
		final Iterator<EObject> it = root.eAllContents();
		while(it.hasNext()) {
			final DiffElement element = (DiffElement)it.next();
			if(isPertinentDiff(element, modelElement)) {
				return element;
			}
		}
		return null;
	}

	private boolean isPertinentDiff(DiffElement diff, EObject modelElement) {
		EObject curr = getModelElement(diff);
		return modelElement.equals(curr) || modelElement.equals(getMatchedEObject(curr));
	}
	
	private EObject getModelElement(DiffElement diff) {
		if(diff instanceof DiffGroup) {
			return ((DiffGroup)diff).getRightParent();
		}
		if(diff instanceof ModelElementChangeLeftTarget) {
			return ((ModelElementChangeLeftTarget)diff).getLeftElement();
		}
		if(diff instanceof ModelElementChangeRightTarget) {
			return ((ModelElementChangeRightTarget)diff).getRightElement();
		}
		if(diff instanceof UpdateModelElement) {
			return ((UpdateModelElement)diff).getLeftElement();
		}
		return null;
		
	}
}
