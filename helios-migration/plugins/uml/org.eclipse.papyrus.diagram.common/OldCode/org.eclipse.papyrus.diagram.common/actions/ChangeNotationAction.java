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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;

public abstract class ChangeNotationAction extends DiagramAction {

	private CreateViewRequest myCreateViewRequest;

	public ChangeNotationAction(IWorkbenchPage workbenchPage, String actionId) {
		super(workbenchPage);
		setId(actionId);
	}

	@Override
	public void init() {
		super.init();
		updateText();
		updateImage();
	}

	@Override
	public void refresh() {
		super.refresh();
		updateText();
		updateImage();
	}

	protected abstract String getSemanticHint(GraphicalEditPart editPart);

	protected void updateImage() {
	}

	protected void updateText() {
	}

	@Override
	protected final Request createTargetRequest() {
		return null;
	}

	@Override
	protected final Command getCommand() {
		final GraphicalEditPart editPart = getSelectedEditPart();
		if (editPart == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Command deleteCommand = getDeleteViewCommand(editPart);
		if (deleteCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		Command createViewCommand = getCreateViewCommand(editPart);
		if (createViewCommand == null) {
			return UnexecutableCommand.INSTANCE;
		}
		CompoundCommand command = new CompoundCommand(getCommandLabel());
		command.add(deleteCommand);
		command.add(createViewCommand);
		return command.isEmpty() ? UnexecutableCommand.INSTANCE : (Command) command;
	}

	protected final Command getDeleteViewCommand(GraphicalEditPart editPart) {
		View view = (View) editPart.getModel();
		return new ICommandProxy(new DeleteCommand(view));
	}

	protected final Command getCreateViewCommand(GraphicalEditPart editPart) {
		myCreateViewRequest = getCreateViewRequest(editPart);
		if (myCreateViewRequest == null) {
			return null;
		}
		return editPart.getParent().getCommand(myCreateViewRequest);
	}

	protected final CreateViewRequest getCreateViewRequest(GraphicalEditPart editPart) {
		View view = (View) editPart.getModel();
		EObject element = view.getElement();
		String semanticHint = getSemanticHint(editPart);
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(element), Node.class, semanticHint,
				getPreferencesHint());
		CreateViewRequest createViewRequest = new CreateViewRequest(viewDescriptor);
		createViewRequest.setLocation(getLocation(editPart));
		return createViewRequest;
	}

	@Override
	protected final boolean isSelectionListener() {
		return true;
	}

	protected final GraphicalEditPart getSelectedEditPart() {
		for (Object ob : getSelectedObjects()) {
			if (ob instanceof GraphicalEditPart) {
				return (GraphicalEditPart) ob;
			}
		}
		return null;
	}

	private Point getLocation(GraphicalEditPart editPart) {
		Rectangle b = editPart.getFigure().getBounds().getCopy();
		editPart.getFigure().translateToAbsolute(b);
		return b.getLocation();
	}

	@Override
	protected void doRun(IProgressMonitor progressMonitor) {
		super.doRun(progressMonitor);
		selectAddedObject();
		myCreateViewRequest = null;
	}

	/**
	 * Almost copy of standard GMF implementation from
	 * org.eclipse.gmf.runtime.diagram.ui.actions.internal.CreateViewAction etc
	 */
	private void selectAddedObject() {
		// we use myCreateViewRequest field instead of getRequest()
		if (myCreateViewRequest == null) {
			return;
		}
		Object result = myCreateViewRequest.getNewObject();
		if (!(result instanceof Collection)) {
			return;
		}
		final List editparts = new ArrayList(1);

		IDiagramGraphicalViewer viewer = getDiagramGraphicalViewer();
		if (viewer == null) {
			return;
		}

		Map editpartRegistry = viewer.getEditPartRegistry();
		for (Iterator iter = ((Collection) result).iterator(); iter.hasNext();) {
			Object viewAdaptable = iter.next();
			if (viewAdaptable instanceof IAdaptable) {
				Object editPart = editpartRegistry.get(((IAdaptable) viewAdaptable).getAdapter(View.class));
				if (editPart != null)
					editparts.add(editPart);
			}
		}

		if (!editparts.isEmpty()) {
			viewer.setSelection(new StructuredSelection(editparts));

			// automatically put the first shape into edit-mode
			Display.getCurrent().asyncExec(new Runnable() {

				public void run() {
					EditPart editPart = (EditPart) editparts.get(0);
					editPart.performRequest(new Request(RequestConstants.REQ_DIRECT_EDIT));
				}
			});
		}
	}

}
