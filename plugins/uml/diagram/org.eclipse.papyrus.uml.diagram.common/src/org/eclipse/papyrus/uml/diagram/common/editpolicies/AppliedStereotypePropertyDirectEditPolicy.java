/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;


public class AppliedStereotypePropertyDirectEditPolicy extends LabelDirectEditPolicy {

	/**
	 * @see DirectEditPolicy#getDirectEditCommand(DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		if (edit.getCellEditor() instanceof TextCellEditorEx)
			if (!((TextCellEditorEx) edit.getCellEditor()).hasValueChanged())
				return null;
			
		String labelText = (String) edit.getCellEditor().getValue();
		
		//for CellEditor, null is always returned for invalid values
		if (labelText == null) {
			return null;
		}
		
		ITextAwareEditPart compartment = (ITextAwareEditPart) getHost();
		EObject model = (EObject)compartment.getModel();
		SemanticAdapter elementAdapter = null ;
		if (model instanceof View) {
            View view = (View)model;
			elementAdapter =new SemanticAdapter(((View)model).getElement(), model);
        }
		else
			elementAdapter = new SemanticAdapter(((View)model).getElement(), model);
		// check to make sure an edit has occurred before returning a command.
		String prevText = compartment.getParser().getEditString(elementAdapter,
			compartment.getParserOptions().intValue());
		if (!prevText.equals(labelText)) {
			ICommand iCommand = 
				compartment.getParser().getParseCommand(elementAdapter, labelText, 0);
			return new ICommandProxy(iCommand);
		}

		return null;
	}
}
