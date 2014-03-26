/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.INodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.helper.FixAnchorHelper;


/**
 * 
 * an abstract command used to update anchor location in the notation
 * 430702: [Diagram] Moving source of a link moves the target too.
 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=430702
 */
public abstract class AbstractFixEdgeAnchorDeferredCommand extends AbstractTransactionalCommand {

	/** the diagram editpart used to get the editpart registry */
	private IGraphicalEditPart containerEP;

	/**
	 * the fix anchor helper
	 */
	private FixAnchorHelper helper;

	private static final Point orig = new Point(0, 0);

	private static final Dimension nullDimension = new Dimension(0, 0);

	public AbstractFixEdgeAnchorDeferredCommand(final TransactionalEditingDomain editingDomain, final String commandTitle, final IGraphicalEditPart containerEP) {
		super(editingDomain, commandTitle, null); //$NON-NLS-1$
		this.containerEP = containerEP;
		this.helper = new FixAnchorHelper(editingDomain);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#getAffectedFiles()
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List getAffectedFiles() {
		if(containerEP != null) {
			View view = (View)containerEP.getModel();
			if(view != null) {
				IFile f = WorkspaceSynchronizer.getFile(view.eResource());
				return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * 
	 * @param connectionToRefresh
	 *        the connection edit part to refresh
	 * @param commandToContribute
	 *        the command to contribute (as parameter to avoid to create several compound command
	 */
	protected void addFixAnchorCommand(final AbstractConnectionEditPart connectionToRefresh, final CompoundCommand commandToContribute) {
		Assert.isNotNull(commandToContribute);
		final EditPart sourceEditPart = ((AbstractConnectionEditPart)connectionToRefresh).getSource();
		final EditPart targetEditPart = ((AbstractConnectionEditPart)connectionToRefresh).getTarget();
		if(sourceEditPart instanceof NodeEditPart) {
			final INodeEditPart nodeEditPart = (INodeEditPart)sourceEditPart;
			PrecisionRectangle nodeBounds = new PrecisionRectangle(nodeEditPart.getFigure().getBounds());
			nodeEditPart.getFigure().translateToAbsolute(nodeBounds);
			final Command cc = this.helper.getFixAnchorCommand(nodeEditPart, nodeBounds, nodeBounds, connectionToRefresh, orig, nullDimension, true);
			if(cc != null) {
				commandToContribute.add(cc);
			}
		}
		if(targetEditPart instanceof NodeEditPart) {
			final INodeEditPart nodeEditPart = (INodeEditPart)targetEditPart;
			PrecisionRectangle nodeBounds = new PrecisionRectangle(nodeEditPart.getFigure().getBounds());
			nodeEditPart.getFigure().translateToAbsolute(nodeBounds);
			final Command cc = this.helper.getFixAnchorCommand(nodeEditPart, nodeBounds, nodeBounds, connectionToRefresh, orig, nullDimension, false);
			if(cc != null) {
				commandToContribute.add(cc);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#cleanup()
	 * 
	 */
	protected void cleanup() {
		this.containerEP = null;//for garbage collection
		this.helper = null;
		super.cleanup();
	}

	/**
	 * gets the container edit part's figure
	 * 
	 * @return the container figure
	 */
	protected final IFigure getContainerFigure() {
		return this.containerEP.getFigure();
	}

	/**
	 * gets the container edit part
	 * 
	 * @return the container edit part
	 */
	protected final IGraphicalEditPart getContainerEP() {
		return this.containerEP;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.operations.AbstractOperation#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		return super.canExecute() && this.helper != null && this.containerEP != null;
	}

	
}
