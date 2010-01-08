/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.parametric.command.CreateParameterViewCommand;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.parts.ConstraintPropertyEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.providers.SysmlElementTypes;

/**
 * Custom CreateParameterEditPolicy.
 */
public class CreateParameterEditPolicy extends AbstractEditPolicy {

	public CreateParameterEditPolicy() {
		super();
	}

	@Override
	public Command getCommand(Request request) {
		if (RequestConstants.REQ_CREATE.equals(request.getType()) && request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest creationRequest = (CreateUnspecifiedTypeRequest) request;
			EditPart parentEditPart = getHost();
			if (parentEditPart instanceof ConstraintPropertyEditPart) {
				ConstraintPropertyEditPart compartementPart = (ConstraintPropertyEditPart) parentEditPart;
				EObject action = ViewUtil.resolveSemanticElement((View) getHost().getModel());
				for (Object obj : creationRequest.getElementTypes()) {
					if (SysmlElementTypes.Property_3002.equals(obj)) {
						return new CreateParameterViewCommand((IHintedType) SysmlElementTypes.Property_3002,
								compartementPart, action, getHost());
					}
				}
			}
		}
		return super.getCommand(request);
	}

}
