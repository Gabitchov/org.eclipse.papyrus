/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IMaskManagedLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.MessageLabelEditPolicy.ICustomMessageLabel;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.SelfMessageHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessageName2EditPart extends MessageName2EditPart implements ICustomMessageLabel {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomMessageName2EditPart(View view) {
		super(view);
	}

	@Override
	public void refreshBounds() {
		super.refreshBounds();
		Message2EditPart parent = (Message2EditPart)getParent();
		//Update location of label for self linked message.
		if(SelfMessageHelper.isSelfLink(parent)) {
			SelfMessageHelper.updateLabelLocation(this);
		}
	}

	@Override
	protected void refreshLabel() {
		EditPolicy maskLabelPolicy = getParent().getEditPolicy(IMaskManagedLabelEditPolicy.MASK_MANAGED_LABEL_EDIT_POLICY);
		if(maskLabelPolicy == null) {
			setLabelTextHelper(getFigure(), getLabelText());
			setLabelIconHelper(getFigure(), getLabelIcon());
		}
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	@Override
	public void refreshFont() {
		FontStyle style = (FontStyle)getFontStyleOwnerView().getStyle(NotationPackage.eINSTANCE.getFontStyle());
		if(style != null) {
			FontData fontData = new FontData(style.getFontName(), style.getFontHeight(), (style.isBold() ? SWT.BOLD : SWT.NORMAL) | (style.isItalic() ? SWT.ITALIC : SWT.NORMAL));
			setFont(fontData);
		}
	}

	private View getFontStyleOwnerView() {
		return (View)getParent().getModel();
	}
}
