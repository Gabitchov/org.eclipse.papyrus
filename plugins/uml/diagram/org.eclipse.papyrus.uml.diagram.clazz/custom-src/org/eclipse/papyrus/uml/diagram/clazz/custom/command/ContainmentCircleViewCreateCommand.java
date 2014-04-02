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
 *  Fadoi LAKHAL  Fadoi.Lakhal@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;

/**
 * Custom class to create the containment circle node.
 * 
 */
public class ContainmentCircleViewCreateCommand extends AbstractCustomCommand {

	/** The container view. */
	private View containerView;

	// /** The create connection view and element request. */
	// private CreateConnectionViewRequest createConnectionViewRequest;

	/** The preference hint. */
	private PreferencesHint preferenceHint;

	/** The result. */
	public EObjectAdapter result;

	/** descriptor **/
	protected ViewDescriptor descriptor;

	/**
	 * constructor.
	 * 
	 * @param createConnectionViewAndElementRequest
	 *            the request that is used to obtained the containmentCircle
	 * @param domain
	 *            the current edit domain
	 * @param container
	 *            the container view
	 * @param viewer
	 *            the viewer
	 * @param preferencesHint
	 *            the preference hint of the diagram
	 * @param point
	 *            the location of the future containment circle node
	 */
	public ContainmentCircleViewCreateCommand(CreateConnectionViewRequest createConnectionViewRequest, TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint) {
		super(domain, "ContainmentCircleViewCreateCommand", null); //$NON-NLS-1$
		this.containerView = container;
		this.viewer = viewer;
		this.preferenceHint = preferencesHint;
		// this.createConnectionViewRequest = createConnectionViewRequest;
		// make sure the return object is available even before executing/undoing/redoing
		descriptor = new ViewDescriptor(new SemanticAdapter(null, null), Node.class, null, ViewUtil.APPEND, true, preferencesHint);
		setResult(CommandResult.newOKCommandResult(descriptor));
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		UMLViewProvider viewProvider = new UMLViewProvider();
		setNode(viewProvider.createNode_3032(null, this.containerView, -1, true, preferenceHint));
		descriptor.setView(node);
		return CommandResult.newOKCommandResult(node);
	}
}
