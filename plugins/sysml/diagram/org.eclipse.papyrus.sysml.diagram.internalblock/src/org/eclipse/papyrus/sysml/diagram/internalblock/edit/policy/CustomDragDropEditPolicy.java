/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policy;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.dnd.helper.CustomLinkMappingHelper;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;

/** Customization of the DND edit policy for the Internal Block Diagram */
public class CustomDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	/** Default constructor. */
	public CustomDragDropEditPolicy() {
		super(new CustomLinkMappingHelper());
		registry = new CustomGraphicalTypeRegistry();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Set<String> getSpecificDropBehaviorTypes() {
		Set<String> specificDropBehaviorTypes = new HashSet<String>();
		
		specificDropBehaviorTypes.add(UMLGraphicalTypes.LINK_UML_CONNECTOR_ID);
		
		return specificDropBehaviorTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getSpecificDropCommand(DropObjectsRequest dropRequest, EObject droppedEObject, String nodeType, String edgeType) {
		if ((UMLGraphicalTypes.LINK_UML_CONNECTOR_ID.equals(edgeType)) && (droppedEObject instanceof Connector)) {
			return getConnectorDropCommand(dropRequest, (Connector) droppedEObject, edgeType);
		}
		
		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}
	
	private ICommand getConnectorDropCommand(DropObjectsRequest dropRequest, Connector droppedEObject, String edgeType) {

		// Only manage binary link during drop
		if(droppedEObject.getEnds().size() != 2) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}
		
		ConnectorEnd source = droppedEObject.getEnds().get(0);
		ConnectorEnd target = droppedEObject.getEnds().get(1);

		// Find views in current diagram representing source and target 
		Collection<View> sourceViews = getViewsForConnectorEnd(source);
		Collection<View> targetViews = getViewsForConnectorEnd(target);

		IAdaptable sourceViewAdapter = null;
		IAdaptable targetViewAdapter = null;

		// If either a source or target lacks create view for these elements, abort...
		if(sourceViews.isEmpty() || targetViews.isEmpty()) {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}

		// Create source adapter
		if(!sourceViews.isEmpty()) { // sourceViewAdapter should still be null in this case
			sourceViewAdapter = new SemanticAdapter(null, sourceViews.toArray()[0]);
		}

		// Create target adapter
		if(!targetViews.isEmpty()) { // targetViewAdapter should still be null in this case
			targetViewAdapter = new SemanticAdapter(null, targetViews.toArray()[0]);
		}

		// Create a view for the dropped link between the source and target view adapters
		IAdaptable droppedObjectAdapter = new SemanticAdapter(droppedEObject, null);

		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(droppedObjectAdapter, edgeType, getDiagramPreferencesHint());

		CommonDeferredCreateConnectionViewCommand createConnectionViewCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), edgeType, sourceViewAdapter, targetViewAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		createConnectionViewCommand.setElement(droppedEObject);

		return  createConnectionViewCommand;
	}
	
	/**
	 * This methods looks for views representing a given {@link ConnectorEnd} in the host diagram.
	 * 
	 * @param end
	 *        the {@link ConnectorEnd} to look for.
	 * @return the list of {@link View} representing the eObject.
	 */
	private Set<View> getViewsForConnectorEnd(ConnectorEnd end) {
		Set<View> views = new HashSet<View>();

		// Retrieve host diagram
		View hostView = ((IGraphicalEditPart)getHost()).getNotationView();
		View hostDiagram = (hostView instanceof Diagram) ? hostView : hostView.getDiagram();

		// Retrieve all views for the ConnectorEnd role
		EReference[] refs = { NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> relatedViews = EMFCoreUtil.getReferencers(end.getRole(), refs);

		// Parse and select views from host diagram only	
		Iterator<View> it = relatedViews.iterator();
		while(it.hasNext()) {
			View currentView = it.next();
			if(currentView.getDiagram() == hostDiagram) {
				
				// If the ConnectorEnd partWithPort is not null, only select Views for which 
				// the graphical parent reference partWithPort.
				if (end.getPartWithPort() != null) {
					if (ViewUtil.getContainerView(currentView).getElement() == end.getPartWithPort()) {
						views.add(currentView);
					}
				
				} else {
					// If the role is a Port, its graphical parent is a EncapsulatedClassifier
					if (end.getRole() instanceof Port) {
						if (ViewUtil.getContainerView(currentView).getElement() instanceof EncapsulatedClassifier) {
							views.add(currentView);
						}
					
					} else { // No further test needed
						views.add(currentView);
					}
				}	
			}
		}

		return views;
	}

}
