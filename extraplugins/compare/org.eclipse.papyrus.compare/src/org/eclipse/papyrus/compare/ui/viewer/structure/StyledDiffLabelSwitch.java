package org.eclipse.papyrus.compare.ui.viewer.structure;

import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
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

	private ILabelProvider myDomainElementLabelProvider = (ILabelProvider)UMLCompareUtils.getInstance().getPapyrusLabelProvider();
	
	@Override
	public StyledString defaultCase(EObject object) {
		return null;
	}

	@Override
	public StyledString caseCompareTwoElementsDiffModel(CompareTwoElementsDiffModel object) {
		StyledString styledString = new StyledString();
		int subchanges = ((DiffGroup)object.getOwnedElements().get(0)).getSubchanges();
		EObject leftElement = object.getLeftRoots().get(0);
		String leftName = myDomainElementLabelProvider.getText(leftElement);
		EObject rightElement = object.getRightRoots().get(0);
		String rightName = myDomainElementLabelProvider.getText(rightElement);

		//		String message = "%s change(s) between elements [%s] and [%s]";
		//		return String.format(message, subchanges, leftName, rightName);

		styledString.append(String.valueOf(subchanges));
		styledString.append(" change(s) between elements ", StyledString.DECORATIONS_STYLER);
		styledString.append(leftName);
		styledString.append(" and ", StyledString.DECORATIONS_STYLER);
		styledString.append(rightName);
		return styledString;

	}

	@Override
	public StyledString caseRemoveStereotypeApplication(RemoveStereotypeApplication object) {
		StyledString styledString = new StyledString();
		EObject element = object.getLeftElement();
		String elementLabel = AdapterUtils.getItemProviderText(element);
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

		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());
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

		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());
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
		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());
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
		final String referenceLabel = AdapterUtils.getItemProviderText(object.getReference());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());

		Object leftTaggedValue = UMLUtil.getBaseElement(object.getLeftElement()).getValue(UMLUtil.getStereotype(object.getLeftElement()), object.getReference().getName());
		Object rightTaggedValue = UMLUtil.getBaseElement(object.getRightElement()).getValue(UMLUtil.getStereotype(object.getRightElement()), object.getReference().getName());

		String leftValue = AdapterUtils.getItemProviderText((EObject)leftTaggedValue);
		String rightValue = AdapterUtils.getItemProviderText((EObject)rightTaggedValue);

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

		final String attributeLabel = AdapterUtils.getItemProviderText(object.getAttribute());
		final String elementLabel = AdapterUtils.getItemProviderText(object.getLeftElement());

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
	
}
