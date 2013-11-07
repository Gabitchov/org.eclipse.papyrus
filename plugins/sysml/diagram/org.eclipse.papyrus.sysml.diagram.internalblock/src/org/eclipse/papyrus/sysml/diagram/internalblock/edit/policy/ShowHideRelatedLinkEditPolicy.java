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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;
import org.eclipse.gmf.tooling.runtime.update.DiagramUpdater;
import org.eclipse.gmf.tooling.runtime.update.UpdaterLinkDescriptor;
import org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysMLDiagramUpdater;
import org.eclipse.papyrus.sysml.diagram.internalblock.part.SysMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractUMLShowHideRelatedLinkEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.util.CrossReferencerUtil;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;


/**
 * 
 * The edit policy to use in the IBD diagram to restore existing links
 * 
 */
public class ShowHideRelatedLinkEditPolicy extends AbstractUMLShowHideRelatedLinkEditPolicy {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param host
	 */
	public ShowHideRelatedLinkEditPolicy(DiagramEditPart host) {
		super(host);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IDiagramInformationProviderEditPolicy#getDiagramUpdater()
	 * 
	 * @return
	 */
	public DiagramUpdater getDiagramUpdater() {
		return SysMLDiagramUpdater.TYPED_INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.IDiagramInformationProviderEditPolicy#getDiagramStructure()
	 * 
	 * @return
	 */
	public DiagramStructure getDiagramStructure() {
		return SysMLVisualIDRegistry.TYPED_INSTANCE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#getSemanticHint(org.eclipse.emf.ecore.EObject)
	 * 
	 * @param eobject
	 * @return
	 */
	@Override
	protected String getSemanticHint(final EObject eobject) {
		return SysMLVisualIDRegistry.getLinkWithClassVisualID(eobject);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.editpolicies.AbstractShowHideRelatedLinkEditPolicy#cleanAdd(java.util.Collection,
	 *      org.eclipse.gmf.runtime.notation.View, java.util.List, java.util.Map)
	 * 
	 * @param result
	 * @param view
	 * @param descriptors
	 * @param domain2NotationMap
	 */
	@Override
	protected void cleanAdd(final Collection<UpdaterLinkDescriptor> result, final View view, final List<?> descriptors, final Map<EObject, View> domain2NotationMap) {
		cleanAddForConnector(result, view, descriptors, domain2NotationMap);
		super.cleanAdd(result, view, descriptors, domain2NotationMap);
	}

	/**
	 * This method manages descriptors representing Connector to verify that it can be displayed according to the nestedPath of the
	 * {@link ConnectorEnd} If the connector can be displayed :
	 * <ul>
	 * <li>
	 * the link descriptor is removed from descriptors and added to result</li>
	 * <li>
	 * the view associated to the role of the connector are added to domain2NotationMap (using the ConnectorEnd as key)</li>
	 * </ul>
	 * 
	 * 
	 * 
	 * @param result
	 *        the result of the method
	 * @param view
	 *        a view
	 * @param descriptors
	 *        the link descriptors
	 * @param domain2NotationMap
	 *        the map between model element and views
	 * 
	 * 
	 */
	protected void cleanAddForConnector(final Collection<UpdaterLinkDescriptor> result, final View view, final List<?> descriptors, final Map<EObject, View> domain2NotationMap) {
		final List<UpdaterLinkDescriptor> toRemove = new ArrayList<UpdaterLinkDescriptor>();
		for(final Object current : descriptors) {
			if(current instanceof UpdaterLinkDescriptor) {
				final UpdaterLinkDescriptor descriptor = (UpdaterLinkDescriptor)current;
				final EObject element = descriptor.getModelElement();
				if(element instanceof Connector && canBeDisplayed((Connector)element, view, domain2NotationMap)) {
					result.add((UpdaterLinkDescriptor)current);
				}
				toRemove.add((UpdaterLinkDescriptor)current);
			}
		}
		descriptors.removeAll(toRemove);
	}

	/**
	 * 
	 * @param end
	 *        a connector end
	 * @param view
	 *        a view
	 * @return
	 *         <code>true</code> if the view represents the role of the connector AND if the view is encapsulated as required by the nested path of
	 *         the connector end
	 */
	protected boolean isCorrectGraphicalView(final ConnectorEnd end, final View view) {
		final NestedConnectorEnd nestedConnectorEnd = org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(end, NestedConnectorEnd.class);
		final Property partWithPort = end.getPartWithPort();
		//		final ConnectableElement role = end.getRole();
		//1. we get the top view of this view with the same semantic element
		View localView = getTopViewWithSameSemanticElement(view);

		//2. we  verify the part with port
		if(partWithPort != null) {
			View parent = getTopViewWithSameSemanticElement(ViewUtil.getViewContainer(localView));
			if(parent.getElement() != partWithPort) {
				return false;
			}
		}

		//3. we verify the nested path
		if(nestedConnectorEnd != null && nestedConnectorEnd.getPropertyPath().size() > 0) {
			View parent = view;
			final List<Property> paths = nestedConnectorEnd.getPropertyPath();
			for(int i = paths.size() - 1; i >= 0; i--) {
				final Property currentProperty = paths.get(i);
				parent = getTopViewWithSameSemanticElement(ViewUtil.getViewContainer(parent));
				if(parent.getElement() != currentProperty) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * 
	 * @param connector
	 *        a connector
	 * @param selectedView
	 *        a view used as source or target for the connector to display
	 * @param domain2NotationMap
	 *        the map to complete if we found source and target View on the diagram to diplsay the connector
	 * @return
	 *         <code>true</code> if the view can be used as source/target for the connector according to the nested path AND if we found a second view
	 *         for the 2nd connector end according to the nested path
	 */
	protected boolean canBeDisplayed(final Connector connector, final View selectedView, final Map<EObject, View> domain2NotationMap) {
		//we need to verify the selected view
		final EObject semanticElement = selectedView.getElement();
		ConnectorEnd endForView = null;

		//1. look for the connector end represented by the selected view
		for(final ConnectorEnd current : connector.getEnds()) {
			if(current.getRole() == semanticElement) {
				endForView = current;
				break;
			}
		}
		Assert.isNotNull(endForView);
		//2. verify the view of the selected connector end
		if(!isCorrectGraphicalView(endForView, selectedView)) {
			return false;
		}

		//3. try to find a view for the second connector end
		View secondView = null;
		for(final ConnectorEnd end : connector.getEnds()) {
			final ConnectableElement role = end.getRole();
			if(end == endForView) {
				continue;
			}

			final Set<View> views = CrossReferencerUtil.getCrossReferencingViewsInDiagram(role, getCurrentDiagram());
			final Iterator<View> iterOnView = views.iterator();
			while(secondView == null && iterOnView.hasNext()) {
				final View currentView = iterOnView.next();
				if(isCorrectGraphicalView(end, currentView)) {
					domain2NotationMap.put(endForView, selectedView);
					domain2NotationMap.put(end, currentView);
					secondView = currentView;
				}
			}
		}
		return secondView != null;
	}


	/**
	 * 
	 * @param domain
	 *        the editing domain to use for this command
	 * @param linkToShow
	 *        a link to show
	 * @param domain2NotationMap
	 * @param linkDescriptors
	 * @return
	 *         the command to display the link on the diagram
	 */
	protected ICommand getShowLinkCommand(final TransactionalEditingDomain domain, final EObject linkToShow, final Map<EObject, View> domain2NotationMap, final Collection<? extends UpdaterLinkDescriptor> linkDescriptors) {
		if(!(linkToShow instanceof Connector)) {
			return super.getShowLinkCommand(domain, linkToShow, domain2NotationMap, linkDescriptors);
		}
		mapModel((View)getHost().getAdapter(View.class), domain2NotationMap);
		final View view = domain2NotationMap.get(linkToShow);
		if(view != null) {
			return new SetPropertyCommand(domain, "Restore related linksCommand show view", new EObjectAdapter(view), Properties.ID_ISVISIBLE, Boolean.TRUE);//$NON-NLS-1$
		} else {//we need to recreate the view

			//we look for the link descriptor
			UpdaterLinkDescriptor descriptor = getLinkDescriptor(linkToShow, linkDescriptors);

			if(descriptor != null) {
				//we override the way to find the source and the target edit part
				EditPart sourceEditPart = getEditPart(((Connector)linkToShow).getEnds().get(0), domain2NotationMap);
				EditPart targetEditPart = getEditPart(((Connector)linkToShow).getEnds().get(1), domain2NotationMap);

				// If the parts are still null...
				if(sourceEditPart == null || targetEditPart == null) {
					return null;
				}
				String semanticHint = getSemanticHint(linkToShow);
				CreateConnectionViewRequest.ConnectionViewDescriptor viewDescriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(descriptor.getSemanticAdapter(), semanticHint, ViewUtil.APPEND, false, ((GraphicalEditPart)getHost()).getDiagramPreferencesHint());
				CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(viewDescriptor);
				ccr.setType(RequestConstants.REQ_CONNECTION_START);
				ccr.setSourceEditPart(sourceEditPart);
				sourceEditPart.getCommand(ccr);
				ccr.setTargetEditPart(targetEditPart);
				ccr.setType(RequestConstants.REQ_CONNECTION_END);
				return new CommandProxy(targetEditPart.getCommand(ccr));
			}
		}
		return null;
	}


	/**
	 * 
	 * @param view
	 *        a view
	 * @return
	 *         the last parent of this view referencing the same semantic element
	 */
	protected View getTopViewWithSameSemanticElement(final View view) {
		final EObject semanticElement = view.getElement();
		View parent = view;
		View lastParent = view;
		while(parent.getElement() == semanticElement) {
			lastParent = parent;
			parent = (View)parent.eContainer();
		}
		return lastParent;
	}

}
