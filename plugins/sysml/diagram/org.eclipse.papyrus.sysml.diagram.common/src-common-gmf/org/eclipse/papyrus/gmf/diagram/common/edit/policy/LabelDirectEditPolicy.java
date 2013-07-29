/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart;

/**
 * Overrides {@link org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy} in
 * order to pass parser options to the method that returns the modification command.
 * (always pass 0 - ParserOptions.NONE in the original class).
 * 
 * Also this uses (or tries to) the EObject given by {@link org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart#getParserElement()} to
 * get the edit command instead of using the EObject associated to the edited edit part.
 */
public class LabelDirectEditPolicy extends org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy {

	/**
	 * We need an adapter that will be able to hold both a model
	 * and an view
	 */
	class EObjectAdapterEx extends EObjectAdapter {

		private View view = null;

		/**
		 * constructor
		 * 
		 * @param element
		 *        element to be wrapped
		 * @param view
		 *        view to be wrapped
		 */
		public EObjectAdapterEx(EObject element, View view) {
			super(element);
			this.view = view;
		}

		@SuppressWarnings("rawtypes")
		public Object getAdapter(Class adapter) {
			Object o = super.getAdapter(adapter);
			if(o != null)
				return o;
			if(adapter.equals(View.class)) {
				return view;
			}
			return null;
		}
	}

	/**
	 * @see DirectEditPolicy#getDirectEditCommand(DirectEditRequest)
	 */
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		if(edit.getCellEditor() instanceof TextCellEditorEx)
			if(!((TextCellEditorEx)edit.getCellEditor()).hasValueChanged())
				return null;

		String labelText = (String)edit.getCellEditor().getValue();

		//for CellEditor, null is always returned for invalid values
		if(labelText == null) {
			return null;
		}

		// Papyrus - using org.eclipse.papyrus.gmf.diagram.common.edit.part.ITextAwareEditPart here
		ITextAwareEditPart compartment = (ITextAwareEditPart)getHost();
		EObjectAdapter elementAdapter = new EObjectAdapterEx(compartment.getParserElement(), null);
		//

		// Papyrus - elementAdapter created with compartment.getParserElement(), no need to use the view here.
		//		EObject model = (EObject)compartment.getModel();
		//		EObjectAdapter elementAdapter = null;
		//		if(model instanceof View) {
		//			View view = (View)model;
		//			elementAdapter = new EObjectAdapterEx(ViewUtil.resolveSemanticElement(view), view);
		//		} else
		//			elementAdapter = new EObjectAdapterEx(model, null);

		// check to make sure an edit has occurred before returning a command.
		String prevText = compartment.getParser().getEditString(elementAdapter, compartment.getParserOptions().intValue());
		if(!prevText.equals(labelText)) {
			ICommand iCommand = compartment.getParser().getParseCommand(elementAdapter, labelText, compartment.getParserOptions().intValue());
			// Papyrus - use parser options to build command 
			// compartment.getParser().getParseCommand(elementAdapter, labelText, 0);
			return new ICommandProxy(iCommand);
		}

		return null;
	}
}
