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

import org.eclipse.emf.compare.diff.metamodel.AbstractDiffExtension;
import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.DiffModel;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue;


/**
 * The Class DiffElementExtensionBuilder.
 */
public class DiffElementExtensionBuilder extends DiffSwitch<AbstractDiffExtension> {
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseDiffElement(org.eclipse.emf.compare.diff.metamodel.DiffElement)
	 */
	@Override
	public AbstractDiffExtension caseDiffElement(DiffElement object) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseDiffModel(org.eclipse.emf.compare.diff.metamodel.DiffModel)
	 */
	@Override
	public AbstractDiffExtension caseDiffModel(DiffModel object) {
		CompareTwoElementsDiffModel newElement = UMLDiffFactory.eINSTANCE.createCompareTwoElementsDiffModel();
		newElement.getLeftRoots().addAll(object.getLeftRoots());
		newElement.getRightRoots().addAll(object.getRightRoots());
		newElement.getAncestorRoots().addAll(object.getAncestorRoots());
		newElement.getOwnedElements().addAll(object.getOwnedElements());
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseModelElementChangeLeftTarget(org.eclipse.emf.compare.diff.metamodel.ModelElementChangeLeftTarget)
	 */
	@Override
	public AbstractDiffExtension caseModelElementChangeLeftTarget(ModelElementChangeLeftTarget object) {
		RemoveStereotypeApplication newElement = UMLDiffFactory.eINSTANCE.createRemoveStereotypeApplication();
		newElement.setLeftElement(object.getLeftElement());
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseModelElementChangeRightTarget(org.eclipse.emf.compare.diff.metamodel.ModelElementChangeRightTarget)
	 */
	@Override
	public AbstractDiffExtension caseModelElementChangeRightTarget(ModelElementChangeRightTarget object) {
		AddStereotypeApplication newElement = UMLDiffFactory.eINSTANCE.createAddStereotypeApplication();
		newElement.setRightElement(object.getRightElement());
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseAttributeChange(org.eclipse.emf.compare.diff.metamodel.AttributeChange)
	 */
	@Override
	public AbstractDiffExtension caseAttributeChange(AttributeChange object) {
		TaggedValueChange newElement = UMLDiffFactory.eINSTANCE.createUpdateTaggedValue();
		initTaggedValueDiff(newElement, object);
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseAttributeChangeLeftTarget(org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget)
	 */
	@Override
	public AbstractDiffExtension caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		TaggedValueChangeLeftTarget newElement = UMLDiffFactory.eINSTANCE.createTaggedValueChangeLeftTarget();
		initTaggedValueDiff(newElement, object);
		newElement.setLeftTarget(object.getLeftTarget());
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseAttributeChangeRightTarget(org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget)
	 */
	@Override
	public AbstractDiffExtension caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		TaggedValueChangeRightTarget newElement = UMLDiffFactory.eINSTANCE.createTaggedValueChangeRightTarget();
		initTaggedValueDiff(newElement, object);
		newElement.setRightTarget(object.getRightTarget());
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseUpdateAttribute(org.eclipse.emf.compare.diff.metamodel.UpdateAttribute)
	 */
	@Override
	public AbstractDiffExtension caseUpdateAttribute(UpdateAttribute object) {
		UpdateTaggedValue newElement = UMLDiffFactory.eINSTANCE.createUpdateTaggedValue();
		initTaggedValueDiff(newElement, object);
		return newElement;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.compare.diff.metamodel.util.DiffSwitch#caseReferenceChange(org.eclipse.emf.compare.diff.metamodel.ReferenceChange)
	 */
	@Override
	public AbstractDiffExtension caseReferenceChange(ReferenceChange object) {
		TaggedValueReferenceChange newElement = UMLDiffFactory.eINSTANCE.createTaggedValueReferenceChange();
		newElement.setLeftElement(object.getLeftElement());
		newElement.setRightElement(object.getRightElement());
		newElement.setReference(object.getReference());
		newElement.setRemote(object.isRemote());
		return newElement;
	}


	/**
	 * Inits the tagged value diff.
	 *
	 * @param newElement the new element
	 * @param attributeChange the attribute change
	 * @return the tagged value change
	 */
	protected TaggedValueChange initTaggedValueDiff(TaggedValueChange newElement, AttributeChange attributeChange) {
		newElement.setLeftElement(attributeChange.getLeftElement());
		newElement.setRightElement(attributeChange.getRightElement());
		newElement.setAttribute(attributeChange.getAttribute());
		newElement.setRemote(attributeChange.isRemote());
		return newElement;
	}
}
