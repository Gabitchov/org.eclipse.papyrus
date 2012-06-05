/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.swt.graphics.Image;


public abstract class MoveDropStrategy extends TransactionalDropStrategy {

	//	public final static String TARGET_FEATURE = "targetFeature";

	protected EStructuralFeature feature;

	public String getLabel() {
		return "Move element";
	}

	public String getDescription() {
		return "Move the selected element in one of the target's properties";
	}

	public Image getImage() {
		return null;
	}

	protected EStructuralFeature getTargetFeature(Request request, EditPart targetEditPart) {
		return feature;
	}

	public void setTargetFeature(EStructuralFeature targetFeature) {
		this.feature = targetFeature;
	}

	//parameters: 
	//what element should be dropped ? (Extract the right value from the selection)
	//where should it be dropped ?
	//	- Target object
	//	- Target property
	//	- Target view (Compartment, ...)
	//	public void setOptions(Map<String, Object> options) {
	//		if(options.containsKey(TARGET_FEATURE)) {
	//			Object targetFeature = options.get(TARGET_FEATURE);
	//			if(targetFeature instanceof EStructuralFeature) {
	//				setTargetFeature((EStructuralFeature)targetFeature);
	//			}
	//		}
	//	}

	@Override
	public Command doGetCommand(Request request, EditPart targetEditPart) {
		List<EObject> objectsToDrop = getSourceEObjects(request);
		if(objectsToDrop.isEmpty()) {
			return null;
		}

		Object newValue; //Single or multi-valued

		EObject targetElement = getTargetSemanticElement(targetEditPart);

		EStructuralFeature targetFeature = getTargetFeature(request, targetEditPart);
		if(targetFeature == null) {
			return null;
		}

		if(targetFeature.getUpperBound() == 1) {
			newValue = objectsToDrop.get(0);
		} else {
			EList<?> currentValues = (EList<?>)targetElement.eGet(targetFeature);
			List<? extends Object> values = new LinkedList<Object>(currentValues);
			values.addAll((List)objectsToDrop);
			newValue = values;
		}

		EditingDomain domain = getEditingDomain(targetEditPart);
		SetRequest setRequest = new SetRequest((TransactionalEditingDomain)domain, targetElement, targetFeature, newValue);

		ICommand command = new SetValueCommand(setRequest);

		Command graphicalCommand = getGraphicalCommand(request, targetEditPart);
		if(graphicalCommand != null) {
			command = command.compose(new CommandProxy(graphicalCommand));
		}

		return new ICommandProxy(command);
	}

	/**
	 * 
	 * @param request
	 * @param targetEditPart
	 * @return A command to edit the graphical view
	 */
	protected Command getGraphicalCommand(Request request, EditPart targetEditPart) {
		return null;
	}

}
