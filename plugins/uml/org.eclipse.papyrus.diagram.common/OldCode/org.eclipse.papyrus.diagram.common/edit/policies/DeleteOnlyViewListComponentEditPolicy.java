/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.edit.policies;

import java.util.Collections;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.RemoveEObjectReferencesFromDiagram;

// TODO: Auto-generated Javadoc
/**
 * Component edit policy for child node label edit part.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * @generated NOT
 */
public class DeleteOnlyViewListComponentEditPolicy extends ListItemComponentEditPolicy {

	/**
	 * We don't want to delete the semantic element.
	 * 
	 * @return true, if should delete semantic
	 * 
	 * @generated NOT
	 */
	@Override
	protected boolean shouldDeleteSemantic() {
		// return super.shouldDeleteSemantic();
		return false;
	}

	/**
	 * Gets the graphical host.
	 * 
	 * @return the graphical host
	 */
	protected IGraphicalEditPart getGraphicalHost() {
		if (getHost() instanceof IGraphicalEditPart) {
			return (IGraphicalEditPart) getHost();
		}
		return null;
	}

	/**
	 * Will delete the view and remove the EObject's reference from the diagram's list of elements
	 * to show.
	 * 
	 * @param request
	 *            the request
	 * 
	 * @return the delete command
	 */
	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		IGraphicalEditPart editPart = getGraphicalHost();
		TransactionalEditingDomain domain = editPart != null ? editPart.getEditingDomain() : null;
		View view = editPart != null ? editPart.getNotationView() : null;
		Diagram diagram = view != null ? view.getDiagram() : null;
		EObject element = editPart != null ? editPart.resolveSemanticElement() : null;
		Command command = super.getDeleteCommand(request);
		if (domain != null && diagram != null && element != null) {
			command = command.chain(new ICommandProxy(new RemoveEObjectReferencesFromDiagram(domain, diagram,
					Collections.singletonList(element))));
		}
		return command;
	}

}
