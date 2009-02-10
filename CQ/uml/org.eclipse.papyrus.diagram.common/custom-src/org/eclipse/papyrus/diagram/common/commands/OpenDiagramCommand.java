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
package org.eclipse.papyrus.diagram.common.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;


// TODO: Auto-generated Javadoc
/**
 * The Class OpenDiagramCommand.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class OpenDiagramCommand extends AbstractTransactionalCommand {

	/** The diagram to open. */
	private Diagram diagramToOpen = null;

	/**
	 * Flog to close old diagram.
	 */
	private boolean openInNew = false;

	/**
	 * Instantiates a new open uml diagram command.
	 * 
	 * @param diagramToOpen
	 *            the diagram to open
	 */
	public OpenDiagramCommand(Diagram diagramToOpen) {
		this(diagramToOpen, true);
	}

	/**
	 * 
	 * @param diagramToOpen
	 * @param closeOld
	 */
	public OpenDiagramCommand(Diagram diagramToOpen, boolean openInNew) {
		// editing domain is taken for original diagram,
		// if we open diagram from another file, we should use another editing
		// domain
		super(TransactionUtil.getEditingDomain(diagramToOpen), "Open UML Diagram", null);
		this.diagramToOpen = diagramToOpen;
		this.openInNew = openInNew;
	}

	public boolean isOpenInNew() {
		return openInNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		try {
			Diagram diagram = getDiagramToOpen();
			if (diagram == null) {
				return CommandResult.newCancelledCommandResult();
			}
			MultiDiagramUtil.openDiagram(diagram, isOpenInNew());
			return CommandResult.newOKCommandResult();
		} catch (Exception ex) {
			throw new ExecutionException("Can't open diagram", ex);
		}
	}

	/**
	 * Gets the diagram to open.
	 * 
	 * @return the diagram to open
	 */
	protected Diagram getDiagramToOpen() {
		if (diagramToOpen != null) {
			return diagramToOpen;
		}

		List<Diagram> diagrams = MultiDiagramUtil.getDiagramsAssociatedToView(diagramToOpen);
		if (diagrams.size() > 0) {
			return diagrams.get(0);
		}
		return null;
	}

	@Override
	public boolean canUndo() {
		return false;
	}
}