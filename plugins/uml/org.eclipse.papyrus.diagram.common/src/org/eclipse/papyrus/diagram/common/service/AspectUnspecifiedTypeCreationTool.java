/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Creation tool that adds stereotype application after creation actions.
 */
public class AspectUnspecifiedTypeCreationTool extends UnspecifiedTypeCreationTool {

	/** List of element types of which one will be created (of type <code>IElementType</code>). */
	protected List elementTypes;

	/** list of stereotypes to apply, identified by their qualified names */
	protected List<String> stereotypesToApply;

	/**
	 * Creates an AspectUnspecifiedTypeCreationTool
	 * 
	 * @param elementTypes
	 *            List of element types of which one will be created (of type
	 *            <code>IElementType</code>).
	 */
	public AspectUnspecifiedTypeCreationTool(List elementTypes) {
		super(elementTypes);
		this.elementTypes = elementTypes;

	}

	// /**
	// * {@inheritDoc}
	// */
	// @Override
	// protected Request createTargetRequest() {
	// return new AspectCreateUnspecifiedTypeRequest(elementTypes, getPreferencesHint(),
	// stereotypesToApply);
	// }

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void performCreation(int button) {
		antiScroll = true;

		EditPartViewer viewer = getCurrentViewer();
		Command c = getCurrentCommand();
		executeCurrentCommand();

		// retrieve the list of stereotypes to apply, if any
		if (requiresPostAction()) {
			postAction(viewer, DiagramCommandStack.getReturnValues(c));
		}
		selectAddedObject(viewer, DiagramCommandStack.getReturnValues(c));

		antiScroll = false;
	}

	/**
	 * checks if this tool realizes post actions
	 * 
	 * @return <code>true</code> if post actions must be executed
	 */
	protected boolean requiresPostAction() {
		return stereotypesToApply != null && !stereotypesToApply.isEmpty();
	}

	/**
	 * Action realized after the stereotype application
	 * 
	 * @param viewer
	 *            the edit part viewer that manages the created edit parts
	 * @param returnValues
	 *            the collection of objects created by the creation action
	 */
	protected void postAction(EditPartViewer viewer, Collection returnValues) {
		// retrieves the list of created edit parts
		final List editparts = new ArrayList();
		for (Iterator i = returnValues.iterator(); i.hasNext();) {
			Object object = i.next();
			if (object instanceof IAdaptable) {
				Object editPart = viewer.getEditPartRegistry().get(((IAdaptable) object).getAdapter(View.class));
				if (editPart != null)
					editparts.add(editPart);
			}
		}

		// if edit part were created, apply the stereotypes on these edit parts
		if (!editparts.isEmpty()) {
			// apply the stereotype on the first edit part.
			List<String> list = new ArrayList<String>();
			ApplyStereotypeRequest request = new ApplyStereotypeRequest(stereotypesToApply);
			request.getExtendedData().put(ApplyStereotypeRequest.NEW_EDIT_PART_NAME, "NEW");
			((EditPart) editparts.get(0)).performRequest(request);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void applyProperty(Object key, Object value) {
		if (IPapyrusPaletteConstant.STEREOTYPES_TO_APPLY_KEY.equals(key)) {
			if (value instanceof List<?>)
				stereotypesToApply = (List<String>) value;
			return;
		}
		super.applyProperty(key, value);
	}

	/**
	 * Returns the list of element types
	 * 
	 * @return the list of element types
	 */
	public List<IElementType> getElementTypes() {
		return elementTypes;
	}
}
