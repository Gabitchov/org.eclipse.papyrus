package org.eclipse.papyrus.compare.ui.viewer.structure;

import java.text.MessageFormat;

import org.eclipse.emf.compare.diff.metamodel.AttributeChange;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeLeftTarget;
import org.eclipse.emf.compare.diff.metamodel.AttributeChangeRightTarget;
import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.compare.diff.metamodel.DiffPackage;
import org.eclipse.emf.compare.diff.metamodel.ReferenceChange;
import org.eclipse.emf.compare.diff.metamodel.UpdateAttribute;
import org.eclipse.emf.compare.util.AdapterUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.papyrus.compare.UMLCompareUtils;
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

	private ILabelProvider myDomainElementLabelProvider;

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

	protected ILabelProvider getLabelProvider() {
		if(myDomainElementLabelProvider == null) {
			myDomainElementLabelProvider = (ILabelProvider)UMLCompareUtils.getInstance().getPapyrusLabelProvider();
		}
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
		//		return String.format(message, subchanges, leftName, rightName);

		return formatStyledString("{0} change(s) between elements {1} and {2}", String.valueOf(subchanges), leftName, rightName);

	}

	@Override
	public StyledString caseRemoveStereotypeApplication(RemoveStereotypeApplication object) {
		StyledString styledString = new StyledString();
		EObject element = object.getLeftElement();
		String elementLabel = getLabelProvider().getText(element);
		if(UMLCompareUtils.isStereotypeApplication(element)) {
			elementLabel = UMLUtil.getStereotype(element).getName();
		}
		styledString.append(elementLabel);
		styledString.append(" stereotype has been removed", StyledString.DECORATIONS_STYLER);
		return styledString;
	}

	@Override
	public StyledString caseTaggedValueChange(TaggedValueChange object) {
		StyledString styledString = new StyledString();

		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String leftValueString = leftValue == null ? "null" : leftValue.toString();
		final String rightValueString = rightValue == null ? "null" : rightValue.toString();

		if(object.isRemote()) {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(elementLabel);
			styledString.append(" : remote = ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValueString);
			styledString.append(", local = ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValueString);
		} else {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(attributeLabel);
			styledString.append(" : ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValueString);
			styledString.append(", -> ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValueString);
		}
		return styledString;
	}

	@Override
	public StyledString caseTaggedValueChangeLeftTarget(TaggedValueChangeLeftTarget object) {
		StyledString styledString = new StyledString();

		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String rightValueString = rightValue == null ? "null" : rightValue.toString();

		if(object.isRemote()) {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(elementLabel);
			styledString.append(" has been remotely removed: ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValueString);
		} else {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(attributeLabel);
			styledString.append(" has been added: ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValueString);
		}
		return styledString;
	}

	@Override
	public StyledString caseTaggedValueChangeRightTarget(TaggedValueChangeRightTarget object) {
		StyledString styledString = new StyledString();
		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());
		final String leftValueString = leftValue == null ? "null" : leftValue.toString();
		final String rightValueString = rightValue == null ? "null" : rightValue.toString();

		if(object.isRemote()) {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(elementLabel);
			styledString.append(" has been remotely added: ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValueString);
		} else {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(attributeLabel);
			styledString.append(" has been removed: ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValueString);
		}
		return styledString;
	}

	@Override
	public StyledString caseTaggedValueReferenceChange(TaggedValueReferenceChange object) {
		StyledString styledString = new StyledString();
		final String referenceLabel = getLabelProvider().getText(object.getReference());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(object.getLeftElement()).getValue(UMLUtil.getStereotype(object.getLeftElement()), object.getReference().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(object.getRightElement()).getValue(UMLUtil.getStereotype(object.getRightElement()), object.getReference().getName());

		String leftValue = getLabelProvider().getText((EObject)leftTaggedValue);
		String rightValue = getLabelProvider().getText((EObject)rightTaggedValue);

		if(object.isRemote()) {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(elementLabel);
			styledString.append(" : remote = ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValue);
			styledString.append(", local = ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValue);
		} else {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(referenceLabel);
			styledString.append(" : ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValue);
			styledString.append(" -> ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValue);
		}
		return styledString;
	}

	@Override
	public StyledString caseUpdateTaggedValue(UpdateTaggedValue object) {
		StyledString styledString = new StyledString();

		final String attributeLabel = getLabelProvider().getText(object.getAttribute());
		final String elementLabel = getLabelProvider().getText(object.getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(object.getLeftElement()).getValue(UMLUtil.getStereotype(object.getLeftElement()), object.getAttribute().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(object.getRightElement()).getValue(UMLUtil.getStereotype(object.getRightElement()), object.getAttribute().getName());

		String leftValue = leftTaggedValue != null ? leftTaggedValue.toString() : "null";
		String rightValue = rightTaggedValue != null ? rightTaggedValue.toString() : "null";

		if(object.isRemote()) {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(elementLabel);
			styledString.append(" : remote = ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValue);
			styledString.append(", local = ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValue);
		} else {
			styledString.append("Tagged value ", StyledString.DECORATIONS_STYLER);
			styledString.append(attributeLabel);
			styledString.append(" : ", StyledString.DECORATIONS_STYLER);
			styledString.append(leftValue);
			styledString.append(" -> ", StyledString.DECORATIONS_STYLER);
			styledString.append(rightValue);
		}
		return styledString;
	}

	public StyledString caseDiffGroup(DiffGroup object) {
		StyledString styledString = new StyledString();
		final EObject parent = object.getRightParent();
		if(parent != null) {
			final String parentLabel = getLabelProvider().getText(parent);
			styledString = formatStyledString("{0} change(s) in {1}", String.valueOf(object.getSubchanges()), parentLabel);
		} else {
			styledString.append(String.valueOf(object.getSubchanges()));
			styledString.append(" change(s) in ", StyledString.DECORATIONS_STYLER);
			styledString.append("model");
		}
		return styledString;
	}

	@Override
	public StyledString caseAttributeChange(AttributeChange object) {
		return formatStyledString("Attribute Change {0}", String.valueOf(object.isConflicting()));
	}

	@Override
	public StyledString caseAttributeChangeLeftTarget(AttributeChangeLeftTarget object) {
		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getRightElement());

		if(object.isRemote()) {
			return formatStyledString("{0} has been remotely removed from attribute {1} in {2}", attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
		}
		return formatStyledString("The value {0} has been added to the attribute {1} in {2}", attributeValueToString(object.getLeftTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseAttributeChangeRightTarget(AttributeChangeRightTarget object) {
		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());

		if(object.isRemote()) {
			return formatStyledString("{0} has been remotely added to attribute {1} in {2}", attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
		}
		return formatStyledString("The value {0} has been removed from the attribute {1} in {2}", attributeValueToString(object.getRightTarget()), attributeLabel, elementLabel);
	}

	@Override
	public StyledString caseUpdateAttribute(UpdateAttribute object) {
		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());
		final Object leftValue = object.getLeftElement().eGet(object.getAttribute());
		final Object rightValue = object.getRightElement().eGet(object.getAttribute());

		if(object.isRemote()) {
			return formatStyledString("Attribute {0} in {1} has been remotely changed from {2} to {3}", attributeLabel, elementLabel, attributeValueToString(leftValue), attributeValueToString(rightValue));
		}

		if(object.isConflicting()) {
			return formatStyledString("Attribute {0} : remote = {1}, local = {2}", attributeLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
		}
		return formatStyledString("Attribute {0} in {1} has changed from {2} to {3}", attributeLabel, elementLabel, attributeValueToString(rightValue), attributeValueToString(leftValue));
	}

	@Override
	public StyledString caseReferenceChange(ReferenceChange object) {
		return formatStyledString("Reference Change {0}", String.valueOf(object.isConflicting()));
	}

	private String attributeValueToString(Object attributeValue) {
		return attributeValue == null ? "null" : attributeValue.toString();
	}

	private StyledString formatStyledString(String pattern, String... args) {
		StyledString styledString = new StyledString();
		// TODO process localized strings
		styledString.append(MessageFormat.format(pattern, (Object[])args), StyledString.DECORATIONS_STYLER);
		int currInd = 0;
		int gap = 0;
		for(int i = 0; i < args.length; i++) {
			int nextInd = pattern.indexOf("{", currInd);
			if(nextInd != -1 && args.length > i) {
				styledString.setStyle(nextInd + gap, args[i].length(), null);
				currInd = nextInd + 1;
				gap += args[i].length() - "{}".length() - String.valueOf(i).length();
			} else {
				break;
			}
		}
		return styledString;
	}

}
