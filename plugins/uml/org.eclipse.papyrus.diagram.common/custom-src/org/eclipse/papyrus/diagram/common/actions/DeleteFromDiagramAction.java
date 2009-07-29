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

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

// TODO: Auto-generated Javadoc
/**
 * An override of the GMF DeleteFromDiagramAction so that it is available in synchronized diagram
 * editors. This <IAction>, when executed, deletes the selected top most <View> of the selected
 * <View> that shares the same <EObject> and removes its reference from the <Diagram>. For example,
 * if a name showing label that is a child of a node is selected, the entire node will be deleted,
 * instead of only the label. It is not meant to be used but in MOSKitt editors.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class DeleteFromDiagramAction extends
		org.eclipse.gmf.runtime.diagram.ui.actions.internal.DeleteFromDiagramAction {

	/**
	 * Instantiates a new delete from diagram action.
	 * 
	 * @param workbenchPage
	 *            the workbench page
	 */
	public DeleteFromDiagramAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * Instantiates a new delete from diagram action.
	 * 
	 * @param workbenchPart
	 *            the workbench part
	 */
	public DeleteFromDiagramAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.diagram.ui.actions.internal.DeleteFromDiagramAction#createTargetRequest
	 * ()
	 */
	@Override
	protected Request createTargetRequest() {
		return createDeleteFromDiagramRequest();
	}

	/**
	 * Creates the delete from diagram request.
	 * 
	 * @return the request
	 */
	protected Request createDeleteFromDiagramRequest() {
		GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
		Map<String, String> extendedData = new HashMap<String, String>();
		extendedData.put("Delete", "Delete from diagram");
		deleteReq.setExtendedData(extendedData);
		return deleteReq;
	}

	/**
	 * The returned <Command> will delete the top most <View> of the selected <View> that share the
	 * same underlying <EObject>.
	 * 
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		/* Get the selected edit parts */
		List objects = createOperationSet();

		CompoundCommand deleteCC = new CompoundCommand(getLabel());
		for (Iterator iter = objects.iterator(); iter.hasNext();) {
			/* Get the next part */
			EditPart editPart = (EditPart) iter.next();
			/* Send the request to the edit part */
			if (editPart instanceof IGraphicalEditPart) {
				final View view = getViewToDelete((IGraphicalEditPart) editPart);
				EditPart editPartToDelete = (EditPart) ((IGraphicalEditPart) editPart).getViewer()
						.getEditPartRegistry().get(view);
				Command command = editPartToDelete.getCommand(createDeleteFromDiagramRequest());
				if (command != null) {
					deleteCC.add(command);
				}
			}
		}
		return deleteCC;
	}

	/**
	 * Gets the view to delete.
	 * 
	 * @param editPart
	 *            the edit part
	 * 
	 * @return the view to delete
	 */
	protected View getViewToDelete(IGraphicalEditPart editPart) {
		IGraphicalEditPart editPartToDelete = editPart;
		IGraphicalEditPart auxEditPart = editPartToDelete.getParent() instanceof IGraphicalEditPart ? (IGraphicalEditPart) editPartToDelete
				.getParent()
				: null;

		while (checkShareSameEObject(auxEditPart, editPartToDelete)) {
			editPartToDelete = auxEditPart;
			auxEditPart = auxEditPart.getParent() instanceof IGraphicalEditPart ? (IGraphicalEditPart) auxEditPart
					.getParent() : null;
		}

		if (editPartToDelete != null) {
			return editPartToDelete.getNotationView();
		}

		return null;
	}

	/**
	 * Check share same e object.
	 * 
	 * @param editPart1
	 *            the edit part1
	 * @param editPart2
	 *            the edit part2
	 * 
	 * @return true, if successful
	 */
	private boolean checkShareSameEObject(IGraphicalEditPart editPart1, IGraphicalEditPart editPart2) {
		if (editPart1 == null || editPart2 == null) {
			return false;
		}
		EObject eObject1 = editPart1.resolveSemanticElement();
		EObject eObject2 = editPart2.resolveSemanticElement();

		if (eObject1 != null && eObject1.equals(eObject2)) {
			return true;
		}
		if (eObject2 != null && eObject2.equals(eObject1)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		/*
		 * Disable the action if any selected editpart returns an unexecutable command for our
		 * request
		 */
		Command command = getCommand();
		if (command != null && command.canExecute() == false) {
			setEnabled(false);
			return;
		}
	}

}
