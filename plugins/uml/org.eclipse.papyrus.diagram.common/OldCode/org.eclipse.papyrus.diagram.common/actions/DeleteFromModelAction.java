/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.DeleteCommand;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

/**
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 * 
 */
public class DeleteFromModelAction extends org.eclipse.gmf.runtime.diagram.ui.actions.DeleteFromModelAction {

	/**
	 * Creates a <code>DeleteFromModelAction</code> with a default label.
	 * 
	 * @param part
	 *            The part this action will be associated with.
	 */
	public DeleteFromModelAction(IWorkbenchPart part) {
		super(part);

	}

	/**
	 * Constructor
	 * 
	 * @param workbenchPage
	 */
	public DeleteFromModelAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);

	}

	@Override
	protected Command getCommand(Request request) {
		List operationSet = getOperationSet();
		Iterator editParts = operationSet.iterator();
		List<Object> elementsToDelete = new ArrayList<Object>();
		while (editParts.hasNext()) {
			EditPart editPart = (EditPart) editParts.next();
			// disable on diagram links
			EObject element = null;
			if (editPart instanceof IGraphicalEditPart) {
				IGraphicalEditPart gEditPart = (IGraphicalEditPart) editPart;
				View view = (View) gEditPart.getModel();
				// Don't delete diagram from model only if it is the top most
				// diagram
				EObject container = view.eContainer();
				element = ViewUtil.resolveSemanticElement(view);
				if ((element instanceof Diagram)
						|| (view instanceof Diagram && (container == null || !(container instanceof View)))) {
					return null;
				} else if (view instanceof Edge && element == null) {
					EObject source = getSource(editPart);
					EObject target = getTarget(editPart);
					if (source != null && target != null) {
						return editPart.getCommand(new EditCommandRequestWrapper(new DestroyReferenceRequest(source,
								null, target, false)));
					}
				}
			}
			if (element != null) {
				elementsToDelete.add(editPart);
			}
		}

		if (elementsToDelete.size() > 0) {
			return new ICommandProxy(new DeleteCommand(getEditingDomain(), "Delete elements", (List) null,
					elementsToDelete));
		}

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected boolean calculateEnabled() {
		boolean enabled = super.calculateEnabled();
		if (!enabled) {
			// Even though the selected elements don't have an associated semantic element, they
			// may be deleted anyway if the edit part knows how to treat a DestroyReferenceRequest
			List operationSet = getOperationSet();
			if (operationSet.isEmpty()) {
				return false;
			}
			Iterator editParts = operationSet.iterator();
			while (editParts.hasNext()) {
				EditPart ep = (EditPart) editParts.next();
				EObject source = getSource(ep);
				EObject target = getTarget(ep);
				if (source != null && target != null) {
					Command command = ep.getCommand(new EditCommandRequestWrapper(new DestroyReferenceRequest(source,
							null, target, false)));
					if (command != null)
						enabled = true;
				}
			}
		}

		return enabled;
	}

	private EObject getSource(EditPart ep) {
		if (ep instanceof ConnectionEditPart) {
			EditPart source = ((ConnectionEditPart) ep).getSource();
			if (source instanceof IGraphicalEditPart) {
				return ((IGraphicalEditPart) source).resolveSemanticElement();
			}
		}

		return null;
	}

	private EObject getTarget(EditPart ep) {
		if (ep instanceof ConnectionEditPart) {
			EditPart source = ((ConnectionEditPart) ep).getTarget();
			if (source instanceof IGraphicalEditPart) {
				return ((IGraphicalEditPart) source).resolveSemanticElement();
			}
		}

		return null;
	}

}
