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

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;

/**
 * Custom class to create the containment circle node.
 * 
 */
public class ContainmentCircleViewCreateCommand extends AbstractTransactionalCommand {



	/** The node. */
	private static View node;

	/** The container view. */
	private View containerView;

	/** The create connection view and element request. */
	private CreateConnectionViewRequest createConnectionViewRequest;

	/** The element. */
	private EObject element;

	/** The eobject. */
	private EObject eobject;

	/** The preference hint. */
	private PreferencesHint preferenceHint;

	/** The result. */
	public EObjectAdapter result;

	/** The viewer. */
	private EditPartViewer viewer;

	/** descriptor **/
	protected ViewDescriptor descriptor;

	/**
	 * constructor.
	 * 
	 * @param createConnectionViewAndElementRequest
	 *        the request that is used to obtained the containmentCircle
	 * @param domain
	 *        the current edit domain
	 * @param container
	 *        the container view
	 * @param viewer
	 *        the viewer
	 * @param preferencesHint
	 *        the preference hint of the diagram
	 * @param point
	 *        the location of the future containment circle node
	 */
	public ContainmentCircleViewCreateCommand(CreateConnectionViewRequest createConnectionViewRequest, TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint) {
		super(domain, "ContainmentCircleViewCreateCommand", null); //$NON-NLS-1$
		this.containerView = container;
		this.viewer = viewer;
		this.preferenceHint = preferencesHint;
		this.createConnectionViewRequest = createConnectionViewRequest;
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
		this.node = viewProvider.createNode_3032(null, this.containerView, -1, true, preferenceHint);
		IAdaptable nodeview = new SemanticAdapter(null, getNode());
		descriptor.setView(node);
		return CommandResult.newOKCommandResult(node);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List getAffectedFiles() {
		if(viewer != null) {
			EditPart editpart = viewer.getRootEditPart().getContents();
			if(editpart instanceof IGraphicalEditPart) {
				View view = (View)((IGraphicalEditPart)editpart).getModel();
				if(view != null) {
					IFile f = WorkspaceSynchronizer.getFile(view.eResource());
					return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
				}
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * used to obtain the created node.
	 * 
	 * @return the created node
	 */
	public View getNode() {
		return node;
	}

}
