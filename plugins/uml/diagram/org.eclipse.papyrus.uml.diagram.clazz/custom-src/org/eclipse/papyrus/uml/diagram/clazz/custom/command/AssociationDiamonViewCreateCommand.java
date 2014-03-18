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
package org.eclipse.papyrus.uml.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.providers.UMLViewProvider;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;

/**
 * Custom class to create the associationClass node
 * 
 * @author Patrick Tessier
 */
public class AssociationDiamonViewCreateCommand extends AbstractCustomCommand {

	private View containerView;

	private Point location;

	private PreferencesHint preferenceHint;

	public EObjectAdapter result;

	private SemanticAdapter semanticApdater;

	/**
	 * constructor
	 * 
	 * @param createConnectionViewAndElementRequest
	 *            the request that is used to obtained the associationclass
	 * @param domain
	 *            the current edit domain
	 * @param container
	 *            the container view
	 * @param viewer
	 *            the viewer
	 * @param preferencesHint
	 *            the preference hint of the diagram
	 * @param point
	 *            the location of the future association node
	 */
	public AssociationDiamonViewCreateCommand(TransactionalEditingDomain domain, View container, EditPartViewer viewer, PreferencesHint preferencesHint, Point point, SemanticAdapter semanticAdapter) {
		super(domain, "AssociationDiamonViewCreateCommand", null); //$NON-NLS-1$
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
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// / get the factory of the viewer
		// Dependency2ViewFactory factory = new Dependency2ViewFactory();
		// creation of the element
		// this.node = factory.createView(semanticApdater, this.containerView,
		// ((IHintedType) UMLElementTypes.Dependency_2014)
		// .getSemanticHint(), -1, true, preferenceHint);
		UMLViewProvider viewProvider = new UMLViewProvider();
		setNode(viewProvider.createAssociation_2015(((EObject) semanticApdater.getAdapter(EObject.class)), this.containerView, -1, true, preferenceHint));
		// put to the good position
		Location notationLocation = NotationFactory.eINSTANCE.createLocation();
		notationLocation.setX(location.x);
		notationLocation.setY(location.y);
		if (getNode() instanceof Node)
		{
			((Node) getNode()).setLayoutConstraint(notationLocation);
		}

		semanticApdater.setView(getNode());

		return CommandResult.newOKCommandResult(semanticApdater);
	}
}
