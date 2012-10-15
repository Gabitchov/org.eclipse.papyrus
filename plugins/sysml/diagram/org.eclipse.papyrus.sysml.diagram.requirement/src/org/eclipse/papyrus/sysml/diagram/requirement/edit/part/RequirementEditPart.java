/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Olivier Mélois (ATOS) - Initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.requirement.figure.RequirementFigure;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ClassEditPart;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideCompartmentRequest;
import org.eclipse.uml2.uml.NamedElement;

public class RequirementEditPart extends ClassEditPart {



	public RequirementEditPart(View view) {
		super(view);
	}

	@Override
	protected IFigure createNodeShape() {
		//Showing the information compartment.
		View notationView = getNotationView();
		Request request = new ShowHideCompartmentRequest(ShowHideCompartmentRequest.SHOW, notationView);
		request.setType(ShowHideCompartmentRequest.SHOW_HIDE_COMPARTMENT);
		Command showCompartmentCommand = this.getCommand(request);
		getEditDomain().getCommandStack().execute(showCompartmentCommand);
		return primaryShape = new RequirementFigure(); //$NON-NLS-1$
	}

	public void refreshTitle() {
		NamedElement clazz = (NamedElement)((View)this.getModel()).getElement();
		String requirementName = clazz.getName();
		((RequirementFigure)this.getFigure()).setName(requirementName);
	}


	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof RequirementInformationCompartmentEditPart) {
			IFigure pane = ((RequirementFigure)getPrimaryShape()).getRequirementIdInformationCompartmentFigure();
			setupContentPane(pane); // FIXME each compartment should handle his content pane in his own way 
			pane.add(((RequirementInformationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof RequirementInformationCompartmentEditPart) {
			IFigure pane = ((RequirementFigure)getPrimaryShape()).getRequirementIdInformationCompartmentFigure();
			setupContentPane(pane); // FIXME each compartment should handle his content pane in his own way 
			pane.remove(((RequirementInformationCompartmentEditPart)childEditPart).getFigure());
			return true;
		}
		return super.removeFixedChild(childEditPart);
	}

	@Override
	public IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if(editPart instanceof RequirementInformationCompartmentEditPart) {
			return ((RequirementFigure)getPrimaryShape()).getRequirementIdInformationCompartmentFigure();
		}
		return super.getContentPaneFor(editPart);
	}

}
