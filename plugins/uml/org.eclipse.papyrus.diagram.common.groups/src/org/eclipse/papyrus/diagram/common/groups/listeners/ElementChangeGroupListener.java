/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Arhur Daussy - Bug 315356 - [Common] Provide a common framework in order to manage groups 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.listeners;

import java.util.Comparator;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.request.EdgeGroupFrameworkRequest;
import org.eclipse.papyrus.diagram.common.groups.request.EdgeGroupFrameworkRequest.EdgeType;
import org.eclipse.papyrus.diagram.common.groups.request.ReferenceGroupFrameworkRequest;
import org.eclipse.papyrus.diagram.common.listeners.AbstractModifcationTriggerListener;
import org.eclipse.uml2.uml.Element;

import com.google.common.collect.ImmutableSortedSet;

/**
 * Listener which will notify a node that can be contained by one of the groups registered by the extension that he has changed of group 
 * This class is not register anymore because it not used for the moment. Should be used in the next release.
 */
public class ElementChangeGroupListener extends AbstractModifcationTriggerListener<Element> {
	/**
	 * Registry of all reference which reference a node to a group
	 */
	protected ImmutableSortedSet<EReference> registry;
	
	public ElementChangeGroupListener() {
		super();
		initExtensionPoint();
	}
	/**
	 * Init registry
	 */
	private void initExtensionPoint() {
		Comparator<EStructuralFeature> eStructuralFeatureCompartor = new Comparator<EStructuralFeature>() {
			public int compare(EStructuralFeature arg0, EStructuralFeature arg1) {
				Integer val1 = arg0.getFeatureID();
				Integer val2 = arg1.getFeatureID();
				return val1.compareTo(val2);
			}
			
		};
		registry =  ImmutableSortedSet.copyOf(eStructuralFeatureCompartor, GroupContainmentRegistry.getAllERefencesFromNodeToGroup());	
	}
	/**
	 * {@inheritDoc AbstractModifcationTriggerListener}
	 */
	@Override
	protected Element getElement(Notification notif) {
		Object element = notif.getNotifier();
		if ( element instanceof Element){
			return (Element)element;
		}
		return null;
	}
	/**
	 * {@inheritDoc AbstractModifcationTriggerListener}
	 */
	@Override
	protected boolean isCorrectStructuralfeature(EStructuralFeature eStructuralFeature) {	
		return false;
	}
	/**
	 * {@inheritDoc AbstractModifcationTriggerListener}
	 */
	@Override
	protected ICommand getModificationCommand(Notification notif, TransactionalEditingDomain domain) {
		CompositeCommand notificationCommand = new CompositeCommand("Element change group trigger action");////$NON-NLS-0$
		boolean setMode = notif.getNewValue() != null;
		Object feature = notif.getFeature();
		IGraphicalEditPart part = getChildByEObject(getElement(notif), getDiagramEditPart(), false);
		if (feature instanceof EStructuralFeature && part != null){
			EStructuralFeature eStructuralFeature = (EStructuralFeature)feature;
			ReferenceGroupFrameworkRequest referenceGroupRequest = new ReferenceGroupFrameworkRequest((EObject)notif.getNewValue(),(EObject)notif.getOldValue(), getElement(notif), eStructuralFeature);
			referenceGroupRequest.setType(ReferenceGroupFrameworkRequest.REFERENCED_GROUP_REQUEST);
			Command referenceGroupOnChildCommand = part.getCommand(referenceGroupRequest);
			if (referenceGroupOnChildCommand != null && referenceGroupOnChildCommand.canExecute()){
				notificationCommand.compose(new CommandProxy(referenceGroupOnChildCommand));
			}
			Map registry = ((EditPart)part).getViewer().getEditPartRegistry();
			Object model = ((EditPart)part).getModel();
			if (model instanceof Node){
				//Notify TargetEdge
				notifyEdge(part, notificationCommand, registry, model,EdgeType.TARGET,setMode);
				notifyEdge(part, notificationCommand, registry, model,EdgeType.SOURCE,setMode);
			}

		}
		
		return notificationCommand;
	}
	/**
	 * Add to the composite command all command from request of all incomming and outcoming edge of the current node
	 * @param parent
	 * @param notificationCommand
	 * @param registry
	 * @param model
	 * @param type
	 * @param isSetMode
	 */
	protected void notifyEdge(IGraphicalEditPart parent, CompositeCommand notificationCommand, Map registry, Object model,EdgeGroupFrameworkRequest.EdgeType type, boolean isSetMode) {
		EList edges = null;
		switch(type) {
		case TARGET:
			edges = ((Node)model).getTargetEdges();
			break;
		default:
			edges = ((Node)model).getSourceEdges();
			break;
		}
		for (Object egde : edges){
			if ( egde instanceof Edge){
				Object editPart = registry.get(egde);
				if ( editPart instanceof IGraphicalEditPart){
					EdgeGroupFrameworkRequest edgeGroupRequet = new EdgeGroupFrameworkRequest(type, parent.resolveSemanticElement(), isSetMode);
					Command cmd = ((IGraphicalEditPart)editPart).getCommand(edgeGroupRequet);
					if ( cmd!= null && cmd.canExecute()){
						notificationCommand.compose(new CommandProxy(cmd));
					}
				}
			}
		}
	}
}
