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

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffElement;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffFactory;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;


public class TaggedValueElementBuilder extends UMLDiffSwitch<DiffElement> {
	
	@Override
	public DiffElement caseUMLDiffExtension(UMLDiffExtension object) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public DiffElement caseAttributeChange(AttributeChange object) {
		TaggedValueChange newElement = UMLDiffFactory.eINSTANCE.createUpdateTaggedValue();
		initTaggedValueDiff(newElement, object);
		return newElement;
	}
	
	@Override
	public DiffElement caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		TaggedValueChangeLeftTarget newElement = UMLDiffFactory.eINSTANCE.createTaggedValueChangeLeftTarget();
		initTaggedValueDiff(newElement, object);
		newElement.setLeftTarget(object.getLeftTarget());
		return newElement;
	}
	
	@Override
	public DiffElement caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		TaggedValueChangeRightTarget newElement = UMLDiffFactory.eINSTANCE.createTaggedValueChangeRightTarget();
		initTaggedValueDiff(newElement, object);
		newElement.setRightTarget(object.getRightTarget());
		return newElement;
	}
	
	@Override
	public DiffElement caseUpdateAttribute(UpdateAttribute object) {
		UpdateTaggedValue newElement = UMLDiffFactory.eINSTANCE.createUpdateTaggedValue();
		initTaggedValueDiff(newElement, object);
		return newElement;
	}
	
	@Override
	public DiffElement caseReferenceChange(ReferenceChange object) {
		TaggedValueReferenceChange newElement = UMLDiffFactory.eINSTANCE.createTaggedValueReferenceChange();
		newElement.setLeftElement(object.getLeftElement());
		newElement.setRightElement(object.getRightElement());
		newElement.setReference(object.getReference());
		newElement.setRemote(object.isRemote());
		return newElement;
	}


	protected TaggedValueChange initTaggedValueDiff(TaggedValueChange newElement, AttributeChange attributeChange) {
		newElement.setLeftElement(attributeChange.getLeftElement());
		newElement.setRightElement(attributeChange.getRightElement());
		newElement.setAttribute(attributeChange.getAttribute());
		newElement.setRemote(attributeChange.isRemote());
		return newElement;
	}
}
