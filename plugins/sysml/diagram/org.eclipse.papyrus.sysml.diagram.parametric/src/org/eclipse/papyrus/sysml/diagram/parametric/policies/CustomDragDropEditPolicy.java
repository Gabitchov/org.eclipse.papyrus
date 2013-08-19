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
package org.eclipse.papyrus.sysml.diagram.parametric.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.CommonDiagramDragDropEditPolicy;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.internalblock.dnd.helper.CustomLinkMappingHelper;
import org.eclipse.papyrus.sysml.diagram.parametric.provider.CustomGraphicalTypeRegistry;
import org.eclipse.papyrus.sysml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.diagram.common.commands.CommonDeferredCreateConnectionViewCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/** Customization of the DND edit policy for the Internal Block Diagram */
public class CustomDragDropEditPolicy extends CommonDiagramDragDropEditPolicy {

	private ConnectorUtils utils = new ConnectorUtils();
	
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
		if((UMLGraphicalTypes.LINK_UML_CONNECTOR_ID.equals(edgeType)) && (droppedEObject instanceof Connector)) {
			return getConnectorDropCommand(dropRequest, (Connector)droppedEObject, edgeType);
		}

		return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
	}

	protected ICommand getConnectorDropCommand(DropObjectsRequest dropRequest, Connector droppedEObject, String edgeType) {

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

		View selectedSourceView = null;
		View selectedTargetView = null;
		// until a correct one is found, check that source and target views selected are correct given the current path for the connector...
		for(View sourceView : sourceViews) {
			View targetView = getFirstValidTargetViewForSource(sourceView, targetViews, droppedEObject);
			if(targetView !=null) {
				selectedSourceView = sourceView;
				selectedTargetView = targetView;
				break;
			}
		}
		
		
		// Create source adapter
		if(selectedSourceView!=null) { // sourceViewAdapter should still be null in this case
			sourceViewAdapter = new SemanticAdapter(null, selectedSourceView);
		} else {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}

		// Create target adapter
		if(selectedTargetView!=null) { // targetViewAdapter should still be null in this case
			targetViewAdapter = new SemanticAdapter(null, selectedTargetView);
		} else {
			return org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand.INSTANCE;
		}

		// Create a view for the dropped link between the source and target view adapters
		IAdaptable droppedObjectAdapter = new SemanticAdapter(droppedEObject, null);

		CreateConnectionViewRequest.ConnectionViewDescriptor linkdescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(droppedObjectAdapter, edgeType, getDiagramPreferencesHint());

		CommonDeferredCreateConnectionViewCommand createConnectionViewCommand = new CommonDeferredCreateConnectionViewCommand(getEditingDomain(), edgeType, sourceViewAdapter, targetViewAdapter, getViewer(), getDiagramPreferencesHint(), linkdescriptor, null);
		createConnectionViewCommand.setElement(droppedEObject);

		return createConnectionViewCommand;
	}

	/**
	 * get the first valid target view for the given source. the couple source/target is valid if the path to them from the future container is valid
	 * @param sourceView
	 * @param targetViews
	 * @return
	 */
	private View getFirstValidTargetViewForSource(View sourceView, Collection<View> targetViews, Connector droppedConnector) {
		for(View targetView : targetViews) {
			if(isValidTargetViewForSource(sourceView, targetView, droppedConnector)) {
				return targetView;
			}
		}
		 
		return null;
	}
	
	private boolean isValidTargetViewForSource(View sourceView, View targetView, Connector droppedConnector) {
		if(!(utils.isCrossingEncapsulation(sourceView, targetView))) {
			// no encapsulation. Computes the end paths
			List<Property> sourceNestedPaths = utils.getNestedPropertyPath(sourceView, targetView);
			List<Property> targetNestedPaths = utils.getNestedPropertyPath(targetView, sourceView);
			
			// check this is compatible with current connector
			ConnectorEnd sourceConnectorEnd = utils.getSourceConnectorEnd(droppedConnector);
			NestedConnectorEnd nestedSourceConnectorEnd = UMLUtil.getStereotypeApplication(sourceConnectorEnd, NestedConnectorEnd.class);
			if(nestedSourceConnectorEnd!=null) {
				List<Property> currentSourceConnectorPropertyPath = nestedSourceConnectorEnd.getPropertyPath();
				// compare the 2 list
				if(!sourceNestedPaths.equals(currentSourceConnectorPropertyPath)) {
					return false;
				}
				
			} else { // no end for the current connector, so the sourceNestedPath should be empty 
				if(!sourceNestedPaths.isEmpty()) {
					return false;
				}
			}
			
			
			ConnectorEnd targetConnectorEnd = utils.getTargetConnectorEnd(droppedConnector);
			NestedConnectorEnd nestedTargetConnectorEnd = UMLUtil.getStereotypeApplication(targetConnectorEnd, NestedConnectorEnd.class);
			if(nestedTargetConnectorEnd!=null) {
				List<Property> currentTargetConnectorPropertyPath = nestedTargetConnectorEnd.getPropertyPath();
				// compare the 2 list
				if(!targetNestedPaths.equals(currentTargetConnectorPropertyPath)) {
					return false;
				}
				
			} else { // no end for the current connector, so the targetNestedPaths should be empty 
				if(!targetNestedPaths.isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * This methods looks for views representing a given {@link ConnectorEnd} in the host diagram.
	 * 
	 * @param end
	 *        the {@link ConnectorEnd} to look for.
	 * @return the list of {@link View} representing the eObject.
	 */
	protected Set<View> getViewsForConnectorEnd(ConnectorEnd end) {
		Set<View> views = new HashSet<View>();

		// Retrieve host diagram
		View hostView = ((IGraphicalEditPart)getHost()).getNotationView();
		View hostDiagram = (hostView instanceof Diagram) ? hostView : hostView.getDiagram();

		// Retrieve all views for the ConnectorEnd role
		EReference[] refs = { NotationPackage.eINSTANCE.getView_Element() };
		@SuppressWarnings("unchecked")
		Collection<View> relatedViews = EMFCoreUtil.getReferencers(end.getRole(), refs);

		// TODO: We should filter views not only for the current diagram,
		//       but also consider only views nested within the owner of the connector that are closest to the host view
		//       (in case there are several instances of a Part within which the connector could appear).
		// Connector connector = (Connector)end.getOwner();
		// StructuredClassifier connectorOwner = (StructuredClassifier)connector.getOwner();
		// Parse and select views from host diagram only	
		Iterator<View> it = relatedViews.iterator();
		while(it.hasNext()) {
			View currentView = it.next();
			if(currentView.getDiagram() == hostDiagram) { // FIXME: Cf TODO above.

				boolean isInView = false;
				View containerView = currentView;
				while(containerView != null && !(containerView instanceof Diagram)) {
					if(containerView == getReferenceViewForConnectorEnd()) {
						isInView = true;
					}
					containerView = ViewUtil.getContainerView(containerView);
				}

				if(isInView) {

					EObject containerElement = ViewUtil.getContainerView(currentView).getElement();

					// If the ConnectorEnd partWithPort is not null, only select Views for which 
					// the graphical parent reference partWithPort.
					if(end.getPartWithPort() != null) {
						if(containerElement == end.getPartWithPort()) {
							views.add(currentView);
						}
					} else {
						// If the role is a Port, its graphical parent is a EncapsulatedClassifier
						if(end.getRole() instanceof Port) {
							if(containerElement instanceof EncapsulatedClassifier) {
								views.add(currentView);
							} else if(containerElement instanceof Property) {
								Property property = (Property)containerElement;
								if(property.getType() == end.getRole().getOwner()) {
									views.add(currentView);
								}
							}
						} else { // No further test needed
							views.add(currentView);
						}

					}
				}
			}
		}

		return views;
	}

	protected View getReferenceViewForConnectorEnd() {
		return ((IGraphicalEditPart)getHost()).getNotationView();
	}

}
