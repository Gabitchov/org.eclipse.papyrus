package org.eclipse.papyrus.compare.ui.viewer.structure;

import org.eclipse.emf.compare.diff.metamodel.DiffGroup;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.papyrus.compare.UMLCompareUtils;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.CompareTwoElementsDiffModel;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.UMLDiffExtension;
import org.eclipse.papyrus.compare.diff.metamodel.uml_diff_extension.util.UMLDiffSwitch;


public class StyledDiffLabelSwitch extends UMLDiffSwitch<StyledString> {
	
	@Override
	public StyledString caseUMLDiffExtension(UMLDiffExtension object) {
		return null;
	}
	
	@Override
	public StyledString caseCompareTwoElementsDiffModel(CompareTwoElementsDiffModel object) {
		StyledString styledString = new StyledString();
		int subchanges = ((DiffGroup)object.getOwnedElements().get(0)).getSubchanges();
		ILabelProvider labelProvider =  (ILabelProvider)UMLCompareUtils.getInstance().getStyledPapyrusLabelProvider();
		EObject leftElement = object.getLeftRoots().get(0);
		String leftName = labelProvider.getText(leftElement);
		EObject rightElement = object.getRightRoots().get(0);
		String rightName = labelProvider.getText(rightElement);

//		String message = "%s change(s) between elements [%s] and [%s]";
//		return String.format(message, subchanges, leftName, rightName);

		styledString.append(String.valueOf(subchanges));
		styledString.append(" change(s) between elements ", StyledString.DECORATIONS_STYLER);
		styledString.append(leftName);
		styledString.append(" and ", StyledString.DECORATIONS_STYLER);
		styledString.append(rightName);
		return styledString;
		
	}

}
