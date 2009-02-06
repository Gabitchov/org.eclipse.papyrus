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

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.OpenDiagramCommand;
import org.eclipse.papyrus.diagram.common.util.MDTUtil;
import org.eclipse.ui.IWorkbenchPage;


// TODO: Auto-generated Javadoc
/**
 * "Open as diagram" action for context menu.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class OpenAsDiagramAction extends DiagramAction {

	/** The Constant EMPTY_NAME. */
	private static final String EMPTY_NAME = "";

	/** The diagram to open. */
	private Diagram diagramToOpen = null;

	/** The view. */
	private View view = null;

	/**
	 * Instantiates a new open as diagram action.
	 * 
	 * @param page
	 *            the page
	 * @param view
	 *            the view
	 * @param diagram
	 *            the diagram
	 */
	public OpenAsDiagramAction(IWorkbenchPage page, View view, Diagram diagram) {
		super(page);
		this.view = view;
		this.diagramToOpen = diagram;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#createTargetRequest()
	 */
	@Override
	protected Request createTargetRequest() {
		return null;
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
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#getCommand()
	 */
	@Override
	protected Command getCommand() {
		Command command = new ICommandProxy(new OpenDiagramCommand(diagramToOpen));
		return command;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return diagramToOpen != null && view != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction#refresh()
	 */
	@Override
	public void refresh() {
		super.refresh();
		setText(calculateText());
	}

	/**
	 * Calculate text.
	 * 
	 * @return the string
	 */
	private String calculateText() {
		return MDTUtil.getDiagramName(diagramToOpen);
	}

}
