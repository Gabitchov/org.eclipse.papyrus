/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.util.Log;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIStatusCodes;
import org.eclipse.gmf.runtime.diagram.ui.internal.editparts.DefaultNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.util.EditPartUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.OrphanViewPolicy;

@SuppressWarnings("restriction")
public class CleanDiagramHelper {

	protected static CleanDiagramHelper cleanDiagramHelper;

	/** The view to remove. */
	protected ArrayList<View> viewToRemove = new ArrayList<View>();

	protected DiagramEditPart selectedElement;

	public static CleanDiagramHelper getInstance() {
		if(cleanDiagramHelper == null) {
			cleanDiagramHelper = new CleanDiagramHelper();
		}
		return cleanDiagramHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(DiagramEditPart diagramEditPart) {
		this.selectedElement = diagramEditPart;
		OrphanViewPolicy removeOrphanViewPolicy = (OrphanViewPolicy)diagramEditPart.getEditPolicy("RemoveOrphanView");
		if(removeOrphanViewPolicy != null) {
			removeOrphanViewPolicy.forceRefresh();
		}
		scan(diagramEditPart);
		deleteUnknownViews();

	}

	/**
	 * Delete unknown views.
	 */
	protected void deleteUnknownViews() {
		for(int i = 0; i < viewToRemove.size(); i++) {
			Activator.getDefault().logInfo("Remove " + viewToRemove.get(i));
			executeCommand(getDeleteViewCommand(viewToRemove.get(i)));
		}
	}

	/**
	 * comes from {@link OrphanViewPolicy}.
	 * 
	 * @param cmd
	 *        the cmd
	 */
	@SuppressWarnings("rawtypes")
	protected void executeCommand(final Command cmd) {
		Map options = null;

		EditPart ep = selectedElement;
		boolean isActivating = true;
		// use the viewer to determine if we are still initializing the diagram
		// do not use the DiagramEditPart.isActivating since
		// ConnectionEditPart's
		// parent will not be a diagram edit part
		EditPartViewer viewer = ep.getViewer();
		if(viewer instanceof DiagramGraphicalViewer) {
			isActivating = ((DiagramGraphicalViewer)viewer).isInitializing();
		}

		if(isActivating || !EditPartUtil.isWriteTransactionInProgress((IGraphicalEditPart)selectedElement, false, false))
			options = Collections.singletonMap(Transaction.OPTION_UNPROTECTED, Boolean.TRUE);

		AbstractEMFOperation operation = new AbstractEMFOperation(((IGraphicalEditPart)selectedElement).getEditingDomain(), StringStatics.BLANK, options) {

			protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

				cmd.execute();

				return Status.OK_STATUS;
			}
		};
		try {
			operation.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING, getClass(), "executeCommand", e); //$NON-NLS-1$
			Log.warning(DiagramUIPlugin.getInstance(), DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING, "executeCommand", e); //$NON-NLS-1$
		}
	}

	/**
	 * Try to construct.
	 * 
	 * @param parent
	 *        the parent
	 * @param child
	 *        the child
	 * 
	 * @return the edits the part
	 */
	protected EditPart tryToConstruct(EditPart parent, View child) {

		if(selectedElement.getViewer().getEditPartFactory().createEditPart(parent, child) instanceof DefaultNodeEditPart) {
			viewToRemove.add(child);
		} else {
			Object object = selectedElement.getViewer().getEditPartRegistry().get(child);
			if(object instanceof EditPart) {
				return ((EditPart)object);
			}
		}
		return null;
	}

	/**
	 * gets a {@link Command} to delete the supplied {@link View}.
	 * 
	 * @param view
	 *        view to use
	 * 
	 * @return command
	 */
	protected Command getDeleteViewCommand(View view) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)selectedElement).getEditingDomain();
		return new ICommandProxy(new DeleteCommand(editingDomain, view));
	}

	/**
	 * Scan.
	 * 
	 * @param editPart
	 *        the edit part
	 */
	protected void scan(EditPart editPart) {
		View parentView = (View)editPart.getModel();
		Iterator<EObject> iterator = parentView.eAllContents();
		while(iterator.hasNext()) {
			EObject currentObject = iterator.next();
			if(currentObject instanceof View) {
				tryToConstruct(editPart, (View)currentObject);

			}
		}

	}

}
