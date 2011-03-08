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
package org.eclipse.papyrus.compare.ui.viewer.structure;

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.papyrus.compare.StyledMessageFormat;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.AddStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.RemoveStereotypeApplication;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeLeftTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueChangeRightTarget;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.TaggedValueReferenceChange;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UpdateTaggedValue;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;
import org.eclipse.uml2.uml.util.UMLUtil;


public class StyledDiffLabelSwitch extends UMLDiffSwitch<StyledString> {

	private final ILabelProvider myDomainElementLabelProvider;

	public StyledDiffLabelSwitch(ILabelProvider labelProvider) {
		myDomainElementLabelProvider = labelProvider;
	}

	@Override
	public StyledString defaultCase(EObject object) {
		int classifierID = object.eClass().getClassifierID();
		switch(classifierID) {
		case DiffPackage.DIFF_GROUP:
		{
			DiffGroup diffGroup = (DiffGroup)object;
			return caseDiffGroup(diffGroup);
		}
		case DiffPackage.UPDATE_ATTRIBUTE:
		{
			UpdateAttribute updateAttribute = (UpdateAttribute)object;
			return caseUpdateAttribute(updateAttribute);
		}
		}
		return null;
	}

	private ILabelProvider getLabelProvider() {
		return myDomainElementLabelProvider;
	}

	@Override
	public StyledString caseCompareTwoElementsDiffModel(CompareTwoElementsDiffModel object) {
		int subchanges = ((DiffGroup)object.getOwnedElements().get(0)).getSubchanges();
		EObject leftElement = object.getLeftRoots().get(0);
		String leftName = getLabelProvider().getText(leftElement);
		EObject rightElement = object.getRightRoots().get(0);
		String rightName = getLabelProvider().getText(rightElement);

		//		String message = "%s change(s) between elements [%s] and [%s]";
		//		return String.StyledMessageFormat.format(message, subchanges, leftName, rightName);

		return StyledMessageFormat.format("{0} change(s) between elements {1} and {2}", String.valueOf(subchanges), leftName, rightName);

	}

	@Override
	public StyledString caseAddStereotypeApplication(AddStereotypeApplication object) {
		EObject element = object.getRightElement();
		String elementLabel = getLabelProvider().getText(element);
		if(UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = getLabelProvider().getText(UMLUtil.getStereotype(element));
		}
		return StyledMessageFormat.format("Stereotype {0} has been added", elementLabel);
	}

	@Override
	public StyledString caseRemoveStereotypeApplication(RemoveStereotypeApplication object) {
		EObject element = object.getLeftElement();
		String elementLabel = getLabelProvider().getText(element);
		if(UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = getLabelProvider().getText(UMLUtil.getStereotype(element));
		}
		return StyledMessageFormat.format("Stereotype {0} has been removed", elementLabel);
	}

	@Override
	public StyledString caseTaggedValueChange(TaggedValueChange object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String leftValueString = attributeValueToString(leftValue);
		final String rightValueString = attributeValueToString(rightValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format("Tagged value {0} : remote = {1}, local = {2}", elementLabel, leftValueString, rightValueString);
		}
		return StyledMessageFormat.format("Tagged value {0} : {1} -> {2}", attributeLabel, leftValueString, rightValueString);
	}

	@Override
	public StyledString caseTaggedValueChangeLeftTarget(TaggedValueChangeLeftTarget object) {

		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String rightValueString = attributeValueToString(rightValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format("Tagged value {0} has been remotely removed: {1}", elementLabel, rightValueString);
		}
		return StyledMessageFormat.format("Tagged value {0} has been added: {1}", attributeLabel, rightValueString);
	}

	@Override
	public StyledString caseTaggedValueChangeRightTarget(TaggedValueChangeRightTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final String leftValueString = attributeValueToString(leftValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format("Tagged value {0} has been remotely added: {1}", elementLabel, leftValueString);
		}
		return StyledMessageFormat.format("Tagged value {0} has been removed: {1}", attributeLabel, leftValueString);
	}

	@Override
	public StyledString caseTaggedValueReferenceChange(TaggedValueReferenceChange object) {
		final String referenceLabel = getLabelProvider().getText(object.getReference());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(object.getLeftElement()).getValue(UMLUtil.getStereotype(object.getLeftElement()), object.getReference().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(object.getRightElement()).getValue(UMLUtil.getStereotype(object.getRightElement()), object.getReference().getName());

		String leftValue = getLabelProvider().getText((EObject)leftTaggedValue);
		String rightValue = getLabelProvider().getText((EObject)rightTaggedValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format("Tagged value {0} : remote = {1}, local = {2}", elementLabel, leftValue, rightValue);
		}
		return StyledMessageFormat.format("Tagged value {0} : {1} -> {2}", referenceLabel, leftValue, rightValue);

	}

	@Override
	public StyledString caseUpdateTaggedValue(UpdateTaggedValue object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(object.getLeftElement()).getValue(UMLUtil.getStereotype(object.getLeftElement()), object.getAttribute().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(object.getRightElement()).getValue(UMLUtil.getStereotype(object.getRightElement()), object.getAttribute().getName());

		String leftValue = attributeValueToString(leftTaggedValue);
		String rightValue = attributeValueToString(rightTaggedValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format("Tagged value {0} : remote = {1}, local = {2}", elementLabel, leftValue, rightValue);
		}
		return StyledMessageFormat.format("Tagged value {0}: {1} -> {2}", attributeLabel, rightValue, leftValue);
	}

	public StyledString caseDiffGroup(DiffGroup object) {
		final EObject parent = object.getRightParent();
		final String parentLabel;
		if(parent != null) {
			parentLabel = getLabelProvider().getText(parent);
		} else {
			parentLabel = "model";
		}
		return StyledMessageFormat.format("{0} change(s) in {1}", String.valueOf(object.getSubchanges()), parentLabel);
	}

	@Override
	public StyledString caseAttributeChange(AttributeChange object) {
		return StyledMessageFormat.format("Attribute Change {0}", String.valueOf(object.isConflicting()));
	}

	@Override
	public StyledString caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getRightElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format("{0} has been remotely removed from attribute {1} in {2}", attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format("The value {0} has been added to the attribute {1} in {2}", attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format("{0} has been remotely added to attribute {1} in {2}", attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format("The value {0} has been removed from the attribute {1} in {2}", attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseUpdateAttribute(UpdateAttribute object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());

		if(object.isRemote()) {
			return StyledMessageFormat.format("Attribute {0} in {1} has been remotely changed from {2} to {3}", attributeLabel, elementLabel, attributeValueToString(leftValue), attributeValueToString(rightValue));
		}

		if(object.isConflicting()) {
			return StyledMessageFormat.format("Attribute {0} : remote = {1}, local = {2}", attributeLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
		}
		return StyledMessageFormat.format("Attribute {0} in {1} has changed from {2} to {3}", attributeLabel, elementLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
	}

	@Override
	public StyledString caseReferenceChange(ReferenceChange object) {
		return StyledMessageFormat.format("Reference Change {0}", String.valueOf(object.isConflicting()));
	}

	private String attributeValueToString(Object attributeValue) {
		return attributeValue == null ? "null" : attributeValue.toString();
	}

}
