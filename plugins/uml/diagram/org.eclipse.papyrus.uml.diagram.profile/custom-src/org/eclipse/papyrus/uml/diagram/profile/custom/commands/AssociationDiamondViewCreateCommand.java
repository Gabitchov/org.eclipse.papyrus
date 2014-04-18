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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from Class Diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.commands;

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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLViewProvider;

/**
 * Custom class to create the association node
 * 
 * @author Patrick Tessier
 */

//In this file, we need of the UMLViewProviderToCreateTheAssociation
public class AssociationDiamondViewCreateCommand extends AbstractTransactionalCommand {

	/** the created association node */
	private static View node;

	/** the conainer */
	private View containerView;

	/** the location for the node */
	private Point location;

	/** the {@link PreferencesHint} */
	private PreferencesHint preferenceHint;

	/** the result of the command */
	public EObjectAdapter result;

	/** the semantic adapter */
	private SemanticAdapter semanticApdater;

	/** the viewer */
	private EditPartViewer viewer;

	/**
	 * constructor
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
	public AssociationDiamondViewCreateCommand(TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint, Point point, SemanticAdapter semanticAdapter) {
		super(domain, "AssociationDiamondViewCreateCommand", null); //$NON-NLS-1$
		this.containerView = container;
		this.viewer = viewer;
		this.preferenceHint = preferencesHint;
		this.location = point;
		this.semanticApdater = semanticAdapter;
		setResult(CommandResult.newOKCommandResult(semanticAdapter));

	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// / get the factory of the viewer
		// Dependency2ViewFactory factory = new Dependency2ViewFactory();
		// creation of the element
		// this.node = factory.createView(semanticApdater, this.containerView,
		// ((IHintedType) UMLElementTypes.Dependency_2014)
		// .getSemanticHint(), -1, true, preferenceHint);
		UMLViewProvider viewProvider = new UMLViewProvider();
		node = viewProvider.createAssociation_2015(((EObject) semanticApdater.getAdapter(EObject.class)), this.containerView, -1, true, preferenceHint);
		// put to the good position
		Location notationLocation = NotationFactory.eINSTANCE.createLocation();
		notationLocation.setX(location.x);
		notationLocation.setY(location.y);
		((Node) node).setLayoutConstraint(notationLocation);
		semanticApdater.setView(node);
		return CommandResult.newOKCommandResult(semanticApdater);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public List<?> getAffectedFiles() {
		if (viewer != null) {
			EditPart editpart = viewer.getRootEditPart().getContents();
			if (editpart instanceof IGraphicalEditPart) {
				View view = (View) ((IGraphicalEditPart) editpart).getModel();
				if (view != null) {
					IFile f = WorkspaceSynchronizer.getFile(view.eResource());
					return f != null ? Collections.singletonList(f) : Collections.EMPTY_LIST;
				}
			}
		}
		return super.getAffectedFiles();
	}

	/**
	 * used to obtain the created node
	 * 
	 * @return the created node
	 */
	public View getNode() {
		return node;
	}

}
