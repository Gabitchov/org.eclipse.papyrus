/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.edit.command;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLViewProvider;

/**
 * Custom class to create the associationClass node.
 * 
 */
public class AssociationClassViewCreateCommand extends AbstractTransactionalCommand {

	/**
	 * iadapter to send eobjet.
	 */
	private class SemanticAdapter implements IAdaptable {

		/** The element. */
		private EObject element;

		/**
		 * Instantiates a new semantic adapter.
		 * 
		 * @param element
		 *        the element
		 */
		public SemanticAdapter(EObject element) {
			this.element = element;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getAdapter(Class adapter) {
			if(adapter.equals(EObject.class)) {
				return element;
			}
			return null;
		}

	}

	/** The node. */
	private static View node;

	/** The container view. */
	private View containerView;

	/** The create connection view and element request. */
	private CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest;

	/** The element. */
	private EObject element;

	/** The eobject. */
	private EObject eobject;

	/** The location. */
	private Point location;

	/** The preference hint. */
	private PreferencesHint preferenceHint;

	/** The result. */
	public EObjectAdapter result;

	/** The viewer. */
	private EditPartViewer viewer;

	/**
	 * constructor.
	 * 
	 * @param createConnectionViewAndElementRequest
	 *        the request that is used to obtained the associationclass
	 * @param domain
	 *        the current edit domain
	 * @param container
	 *        the container view
	 * @param viewer
	 *        the viewer
	 * @param preferencesHint
	 *        the preference hint of the diagram
	 * @param point
	 *        the location of the future association node
	 */
	public AssociationClassViewCreateCommand(CreateConnectionViewAndElementRequest createConnectionViewAndElementRequest, TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint, Point point) {
		super(domain, "AssociationClassViewCreateCommand", null); //$NON-NLS-1$
		this.containerView = container;
		this.viewer = viewer;
		this.preferenceHint = preferencesHint;
		this.createConnectionViewAndElementRequest = createConnectionViewAndElementRequest;
		this.location = point;

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// / get the factory of the viewer
		// AssociationClassViewFactory factory = new
		// AssociationClassViewFactory();

		// creation of the element
		CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest)createConnectionViewAndElementRequest).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
		CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);
		UMLViewProvider viewProvider = new UMLViewProvider();
		this.node = viewProvider.createDependency_3203(createElementRequest.getNewElement(), this.containerView, -1, true, preferenceHint);
		// this.node = factory.createView(new
		// SemanticAdapter(createElementRequest.getNewElement()),
		// this.containerView, ((IHintedType)
		// UMLElementTypes.AssociationClass_2013).getSemanticHint(), -1,
		// true, preferenceHint);
		// put to the good position
		Location notationLocation = NotationFactory.eINSTANCE.createLocation();
		((Bounds)((Node)this.node).getLayoutConstraint()).setX(location.x);
		((Bounds)((Node)this.node).getLayoutConstraint()).setY(location.y);
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
