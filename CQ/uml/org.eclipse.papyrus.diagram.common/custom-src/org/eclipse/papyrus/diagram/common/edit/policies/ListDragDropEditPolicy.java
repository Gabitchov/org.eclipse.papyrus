/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – Initial implementation.
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.edit.policies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.UpdateDiagramCommand;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;


// TODO: Auto-generated Javadoc
/**
 * A DragAndDropEditPolicy for list compartment nodes. Checks whether the dropped elements can be shown as views in the compartment and if so, created their views and add their references to the
 * diagram's list of references. Those elements containers are changed to the element represented by the host of the policy.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class ListDragDropEditPolicy extends DragDropEditPolicy {

	/** The views to update. */
	private List<View> viewsToUpdate = null;

	/**
	 * Instantiates a new list drag drop edit policy.
	 * 
	 * @param resolver
	 *            the resolver
	 */
	public ListDragDropEditPolicy(ViewAndFeatureResolver resolver) {
		super(resolver);
	}

	/**
	 * Gets the view and feature resolver.
	 * 
	 * @return the view and feature resolver
	 */
	protected ViewAndFeatureResolver getViewAndFeatureResolver() {
		ViewResolver resolver = getViewResolver();
		if (resolver instanceof ViewAndFeatureResolver) {
			return (ViewAndFeatureResolver) resolver;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.papyrus.diagram.common.edit.policies.DragDropEditPolicy#buildDropCommand(org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest, java.util.List, java.util.List, java.util.List)
	 */
	@Override
	protected Command buildDropCommand(DropObjectsRequest request, List<EObject> nodes, List<ViewDescriptor> views, List<EObject> edges) {
		// build commands that add references to the diagram.
		Command command = buildAddEObjectsReferencesCommand(nodes);
		Command edgesCommand = buildAddEObjectsReferencesCommand(edges);
		command = command == null ? edgesCommand : command.chain(edgesCommand);
		// if no nodes or edges are to be added, there is nothing to do.
		if (command == null) {
			return null;
		}
		// build to update containers commands
		Command setEContainerCommand = createAddToNewContainerCommand(nodes);
		command = setEContainerCommand != null ? command.chain(setEContainerCommand) : command;
		// build create views
		Command viewsCommand = createViewsAndArrangeCommand(request, views);
		command = viewsCommand != null ? command.chain(viewsCommand) : command;
		// update diagram.
		command = command.chain(new UpdateDiagramCommand(getGraphicalHost()));
		// return command
		return command;
	}

	/**
	 * Creates the add to new container command.
	 * 
	 * @param elements
	 *            the elements
	 * 
	 * @return the command
	 */
	protected Command createAddToNewContainerCommand(List<EObject> elements) {
		ViewAndFeatureResolver resolver = getViewAndFeatureResolver();
		TransactionalEditingDomain domain = getGraphicalHost().getEditingDomain();
		EObject parent = getGraphicalHost().resolveSemanticElement();
		if (resolver == null || domain == null || parent == null) {
			return null;
		}
		CompositeCommand cc = new CompositeCommand("Set elements parent container");
		for (EObject element : elements) {
			EStructuralFeature feature = resolver.getEStructuralFeatureForEClass(element.eClass());
			if (feature != null) {
				SetRequest request = new SetRequest(parent, feature, element);
				SetValueCommand command = new SetValueCommand(request);
				cc.add(command);
				addViewsOfElementToUpdate(element);
			}
		}
		return cc.isEmpty() ? null : new ICommandProxy(cc);
	}

	/**
	 * Adds the views of element to update.
	 * 
	 * @param element
	 *            the element
	 */
	protected void addViewsOfElementToUpdate(EObject element) {
		for (Object object : DiagramEditPartsUtil.getEObjectViews(element)) {
			if (object instanceof View) {
				addViewToUpdate((View) object);
			}
		}
	}

	/**
	 * Adds the view to update.
	 * 
	 * @param view
	 *            the view
	 */
	protected void addViewToUpdate(View view) {
		if (viewsToUpdate == null) {
			viewsToUpdate = new ArrayList<View>();
		}
		if (viewsToUpdate.contains(view) == false) {
			viewsToUpdate.add(view);
		}
	}
}
