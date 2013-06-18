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
import org.eclipse.papyrus.compare.Messages;
import org.eclipse.papyrus.compare.StyledMessageFormat;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;


/**
 * Switch to return Styled label for the given  DiffElement.
 * Usually changed elements and number of chnages are shown in bold.
 */
//TODO use this to get the tatiana customization in the upper viewer
public class StyledDiffLabelSwitch extends UMLDiffSwitch<StyledString> {

	/** The my domain element label provider. */
	private final ILabelProvider myDomainElementLabelProvider;

	/**
	 * Instantiates a new styled diff label switch.
	 *
	 * @param labelProvider the label provider
	 */
	public StyledDiffLabelSwitch(ILabelProvider labelProvider) {
		myDomainElementLabelProvider = labelProvider;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
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

	/**
	 * Gets the label provider.
	 *
	 * @return the label provider
	 */
	private ILabelProvider getLabelProvider() {
		return myDomainElementLabelProvider;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseCompareTwoElementsDiffModel(org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel)
	 */
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

	/**
	 * Case diff group.
	 *
	 * @param object the object
	 * @return the styled string
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseAttributeChange(org.eclipse.emf.compare.diff.metamodel.AttributeChange)
	 */
	@Override
	public StyledString caseAttributeChange(AttributeChange object) {
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_text, String.valueOf(object.isConflicting()));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseAttributeChangeLeftTarget(org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget)
	 */
	@Override
	public StyledString caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getRightElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_left_target_remote_text, attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_left_target_text, attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseAttributeChangeRightTarget(org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget)
	 */
	@Override
	public StyledString caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		if(object.isRemote()) {
			return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_right_target_remote_text, attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
		}
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_attribute_change_right_target_text, attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseUpdateAttribute(org.eclipse.emf.compare.diff.metamodel.UpdateAttribute)
	 */
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

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch#caseReferenceChange(org.eclipse.emf.compare.diff.metamodel.ReferenceChange)
	 */
	@Override
	public StyledString caseReferenceChange(ReferenceChange object) {
		return StyledMessageFormat.format(Messages.StyledDiffLabelSwitch_reference_chnage_text, String.valueOf(object.isConflicting()));
	}

	/**
	 * Attribute value to string.
	 *
	 * @param attributeValue the attribute value
	 * @return the string
	 */
	private String attributeValueToString(Object attributeValue) {
		return attributeValue == null ? Messages.StyledDiffLabelSwitch_null_value_text : attributeValue.toString();
	}

}
