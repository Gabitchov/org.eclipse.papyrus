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

		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_two_elements_model_text, String.valueOf(subchanges), leftName, rightName);

	}

	@Override
	public StyledString caseAddStereotypeApplication(AddStereotypeApplication object) {
		EObject element = object.getRightElement();
		String elementLabel = getLabelProvider().getText(element);
		if(UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = getLabelProvider().getText(UMLUtil.getStereotype(element));
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_add_stereotype_application_text, elementLabel);
	}

	@Override
	public StyledString caseRemoveStereotypeApplication(RemoveStereotypeApplication object) {
		EObject element = object.getLeftElement();
		String elementLabel = getLabelProvider().getText(element);
		if(UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = getLabelProvider().getText(UMLUtil.getStereotype(element));
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_remove_stereotype_application_text, elementLabel);
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
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_changed_remote_text, elementLabel, leftValueString, rightValueString);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_changed_text, attributeLabel, leftValueString, rightValueString);
	}

	@Override
	public StyledString caseTaggedValueChangeLeftTarget(TaggedValueChangeLeftTarget object) {

		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String rightValueString = attributeValueToString(rightValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_left_target_remote_text, elementLabel, rightValueString);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_left_target_text, attributeLabel, rightValueString);
	}

	@Override
	public StyledString caseTaggedValueChangeRightTarget(TaggedValueChangeRightTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final String leftValueString = attributeValueToString(leftValue);

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_right_target_remote_text, elementLabel, leftValueString);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_right_target_text, attributeLabel, leftValueString);
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
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_reference_remote_text, elementLabel, leftValue, rightValue);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_tagged_value_reference_text, referenceLabel, leftValue, rightValue);

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
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_update_tagged_value_remote_text, elementLabel, leftValue, rightValue);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_update_tagged_value_text, attributeLabel, rightValue, leftValue);
	}

	public StyledString caseDiffGroup(DiffGroup object) {
		final EObject parent = object.getRightParent();
		final String parentLabel;
		if(parent != null) {
			parentLabel = getLabelProvider().getText(parent);
		} else {
			parentLabel = Messages.StyledDiffLabelSwitch_root_text;
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_diff_group_text, String.valueOf(object.getSubchanges()), parentLabel);
	}

	@Override
	public StyledString caseAttributeChange(AttributeChange object) {
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_text, String.valueOf(object.isConflicting()));
	}

	@Override
	public StyledString caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getRightElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_left_target_remote_text, attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_left_target_text, attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_right_target_remote_text, attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_right_target_text, attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseUpdateAttribute(UpdateAttribute object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_update_attribute_remote_text, attributeLabel, elementLabel, attributeValueToString(leftValue), attributeValueToString(rightValue));
		}

		if(object.isConflicting()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_update_attribute_conflicting_text, attributeLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_update_attribute_text, attributeLabel, elementLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
	}

	@Override
	public StyledString caseReferenceChange(ReferenceChange object) {
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_reference_chnage_text, String.valueOf(object.isConflicting()));
	}

	private String attributeValueToString(Object attributeValue) {
		return attributeValue == null ? Messages.StyledDiffLabelSwitch_null_value_text : attributeValue.toString();
	}

}
