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
package org.eclipse.papyrus.compare.diff.extension;

import java.util.Iterator;

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffFactory;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateModelElement;
import org.eclipse.emf.compare.diff.metamodel.impl.AbstractDiffExtensionImpl;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;


public class ProcessTaggedValues extends AbstractDiffExtensionImpl {
	
	private DiffSwitch<DiffElement> myDiffElementBuilder = new TaggedValueElementBuilder();

	@Override
	public void visit(DiffModel diffModel) {
		final Iterator<EObject> it = diffModel.eAllContents();
		while(it.hasNext()) {
			DiffElement diffElement = (DiffElement)it.next();
			visitElement(diffModel, diffElement);
		}
	}
	
	protected void visitElement(DiffModel root, DiffElement diffElement) {
		EObject stereotypeApplication = getStereotypeApplication(diffElement);
		boolean hasStereotypeApplication = stereotypeApplication != null; 
		if(hasStereotypeApplication) {
			getHideElements().add(diffElement);
			
			Element newVisualParent = UMLUtil.getBaseElement(stereotypeApplication);
			DiffElement newDiffParent = findOrCreateDiffElementFor(root, newVisualParent);
			DiffElement taggedValueDiff = myDiffElementBuilder.doSwitch(diffElement);
			newDiffParent.getSubDiffElements().add(taggedValueDiff);
		}
	}
	
	protected EObject getStereotypeApplication(DiffElement element) {
		if (element instanceof UMLDiffExtension) {
			return null;
		}
		if(element instanceof AttributeChange) {
			AttributeChange attributeChange = (AttributeChange)element;
			EObject stereotypeApplication = attributeChange.getLeftElement();
			if(UMLCompareUtils.isStereotypeApplication(stereotypeApplication)) {
				return stereotypeApplication;
			} 
			stereotypeApplication = attributeChange.getRightElement();
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
		if(diff instanceof DiffGroup) {
			return modelElement.equals(((DiffGroup)diff).getRightParent());
		}
		if(diff instanceof ModelElementChangeLeftTarget) {
			return ((ModelElementChangeLeftTarget)diff).getLeftElement().equals(modelElement);
		}
		if(diff instanceof ModelElementChangeRightTarget) {
			return ((ModelElementChangeRightTarget)diff).getRightElement().equals(modelElement);
		}
		if(diff instanceof UpdateModelElement) {
			return ((UpdateModelElement)diff).getLeftElement().equals(modelElement);
		}
		return false;
	}

}
