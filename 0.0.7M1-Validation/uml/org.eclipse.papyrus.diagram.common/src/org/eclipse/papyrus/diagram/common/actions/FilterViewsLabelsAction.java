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

import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.common.dialogs.SelectDiagramViewsFilterDialog;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;

// TODO: Auto-generated Javadoc
/**
 * The Class FilterViewsLabelsAction.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class FilterViewsLabelsAction extends DiagramAction {

	/**
	 * Instantiates a new filter views labels action.
	 * 
	 * @param workbenchPage
	 *            the workbench page
	 */
	public FilterViewsLabelsAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
		setText("Filter views...");
	}

	/**
	 * Instantiates a new filter views labels action.
	 * 
	 * @param workbenchpart
	 *            the workbenchpart
	 */
	public FilterViewsLabelsAction(IWorkbenchPart workbenchpart) {
		super(workbenchpart);
		setText("Filter views...");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return new Request("none");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#isSelectionListener()
	 */
	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return getDiagramEditPart() != null && getTransactionalEditingDomain() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#runWithEvent(org.eclipse.swt
	 * .widgets.Event)
	 */
	@Override
	public void runWithEvent(Event event) {
		run();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.common.ui.action.AbstractActionHandler#run()
	 */
	@Override
	public void run() {
		if (getDiagramEditPart() == null || getTransactionalEditingDomain() == null) {
			return;
		}
		// // show dialog to user
		SelectDiagramViewsFilterDialog dialog = new SelectDiagramViewsFilterDialog(Display.getCurrent()
				.getActiveShell(), getDiagramEditPart());
		int result = dialog.open();
		// // filter the selected elements
		if (result == Window.OK) {
			executeCommand(dialog.getSelected());
		}
	}

	/**
	 * Gets the transactional editing domain.
	 * 
	 * @return the transactional editing domain
	 */
	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		if (getDiagramEditPart() != null) {
			EObject eObject = getDiagramEditPart().getNotationView();
			return TransactionUtil.getEditingDomain(eObject);
		}
		if (getDiagramEditPart() != null) {
			if (getDiagramEditPart().getDiagramEditDomain() instanceof TransactionalEditingDomain) {
				return getDiagramEditPart().getEditingDomain();
			}
		}
		return null;
	}

	/**
	 * Gets the diagram.
	 * 
	 * @return the diagram
	 */
	protected Diagram getDiagram() {
		if (getDiagramEditPart() != null) {
			Diagram diagram = (Diagram) getDiagramEditPart().getNotationView();
			return diagram;
		}
		return null;
	}

	/**
	 * Execute command.
	 * 
	 * @param infos
	 *            the infos
	 */
	protected void executeCommand(final Collection<Integer> infos) {
		final Diagram diagram = getDiagram();
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(getTransactionalEditingDomain(),
				"Add filter references", null) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				MDTUtil.setElementsToFilterToDiagram(diagram, infos);
				return null;
			}
		};
		execute(new ICommandProxy(command), new NullProgressMonitor());
	}
}
