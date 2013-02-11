/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.editpolicies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartListener;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.ServiceUtilsForEditPart;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.CSSDiagram;
import org.eclipse.papyrus.infra.gmfdiag.css.notation.StatefulView;
import org.eclipse.papyrus.infra.gmfdiag.css.service.CssMarkerEventManagerService;
import org.eclipse.papyrus.infra.gmfdiag.css.service.MarkerToPseudoSelectorMappingService;
import org.eclipse.papyrus.infra.services.markerlistener.IMarkerEventListener;
import org.w3c.dom.Element;

/**
 * An EditPolicy to handle marker events on semantic element associated with EditParts
 * 
 */
public class MarkerEventListenerEditPolicy extends AbstractEditPolicy implements EditPolicy, EditPartListener {

	public static final String ROLE = "MARKER_EVENT_LISTENER";

	/**
	 * The marker event manager service to which this edit policy is attached.
	 */
	protected CssMarkerEventManagerService markerEventManagerService ;

	public MarkerEventListenerEditPolicy() {
		//Nothing
	}

	/**
	 * Register this edit policy with the marker event manager service.
	 * When an edit policy has to be notified, this must be done through this marker event manager service.
	 * 
	 * @see org.eclipse.gef.EditPolicy#activate()
	 */
	@Override
	public void activate() {
		try {
			ServicesRegistry servicesRegistry = ServiceUtilsForEditPart.getInstance().getServiceRegistry(getHost()) ;
			markerEventManagerService = servicesRegistry.getService(CssMarkerEventManagerService.class) ;
			if (markerEventManagerService != null) {
				markerEventManagerService.registerEditPolicy(this) ;
			}
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		getHost().addEditPartListener(this);
	}

	/**
	 * Unregister this edit policy from the marker event manager service
	 * 
	 * @see org.eclipse.gef.EditPolicy#deactivate()
	 */
	@Override
	public void deactivate() {
		if (markerEventManagerService != null) {
			markerEventManagerService.unregisterEditPolicy(this) ;
		}
		getHost().removeEditPartListener(this);
	}

	protected View getSemanticView() {
		return (View)getHost().getModel();
	}

	/**
	 * Updates the css state of the element associated with this edit policy
	 * 
	 * @param state The css states to be added or removed from the current state
	 * @param addedOrRemoved Indicates wheter states have to be added or removed (Possible values are IMarkerEventListener.MARKER_ADDED and IMarkerEventListener.MARKER_REMOVED)
	 */
	public void updateState(Set<String> state, int addedOrRemoved) {
		MarkerEventListenerEditPolicy primaryEditPolicy = getPrimaryEditPolicy();

		if(primaryEditPolicy == this) {
			View view = getSemanticView();
			if(view.getDiagram() instanceof CSSDiagram) {
				Element domElement = ((CSSDiagram)view.getDiagram()).getEngine().getElement(view);
				if(domElement instanceof StatefulView) {
					if (addedOrRemoved == IMarkerEventListener.MARKER_ADDED)
						((StatefulView)domElement).addStates(state);
					else
						((StatefulView)domElement).removeStates(state);
				}
			}
		} else if(primaryEditPolicy != null) {
			primaryEditPolicy.updateState(state, addedOrRemoved);
		}
	}

	/**
	 * Returns the primary edit policy
	 * 
	 * @return THe primary edit policy
	 */
	private MarkerEventListenerEditPolicy getPrimaryEditPolicy() {
		EditPart current = getHost();
		EditPart parent = current.getParent();

		while(parent != null && semanticCompareEditParts(parent, getHost())) {
			current = parent;
			parent = parent.getParent();
		}

		return (MarkerEventListenerEditPolicy)current.getEditPolicy(ROLE);
	}

	/**
	 * Compares semantically the two given edit parts
	 * 
	 * @param one The first edit part to be compared
	 * @param other The second edit part to be compared
	 * @return True if the two edit parts refer to the same model element, false otherwise
	 */
	private boolean semanticCompareEditParts(EditPart one, EditPart other) {
		if(one.getModel() instanceof View && other.getModel() instanceof View) {
			View view1 = (View)one.getModel();
			View view2 = (View)other.getModel();
			return view1 != null && view2 != null && view1.getElement() == view2.getElement();
		}
		return false;
	}

	//Helper method: casts the host edit part to the right type.
	@Override
	public GraphicalEditPart getHost() {
		return (GraphicalEditPart)super.getHost();
	}

	/*
	 * Events support
	 */
	public void selectedStateChanged(EditPart editpart) {
		//Ignore
	}

	/*
	 * Ignored events
	 */
	public void childAdded(EditPart child, int index) {
		//Ignore
	}

	public void partActivated(EditPart editpart) {
		//Ignore
	}

	public void partDeactivated(EditPart editpart) {
		//Ignore
	}

	public void removingChild(EditPart child, int index) {
		//Ignore
	}

	/**
	 * Notifies this edit policy about a marker change
	 * 
	 * @param marker The actual marker
	 * @param addedOrRemoved Indicates whether states have to be added or removed (Possible values are IMarkerEventListener.MARKER_ADDED and IMarkerEventListener.MARKER_REMOVED)
	 */
	public void notifyMarkerChange(IMarker marker, int addedOrRemoved) {
		String cssName = this.getPseudoSelector(marker) ;
		if (! cssName.equals("")) {
			Set<String> state = new HashSet<String>() ;
			state.add(cssName) ;
			updateState(state, addedOrRemoved) ;
		}
	}

	/**
	 * Notifies this edit policy about multiple marker changes
	 * 
	 * @param markers The actual markers
	 * @param addedOrRemoved Indicates whether states have to be added or removed (Possible values are IMarkerEventListener.MARKER_ADDED and IMarkerEventListener.MARKER_REMOVED)
	 */
	public void notifyMarkerChange(IMarker[] markers, int addedOrRemoved) {
		if (markers.length == 0)
			return ;
		String cssName = "" ;
		Set<String> state = new HashSet<String>() ;
		for (int i = 0 ; i < markers.length ; i++) {
			cssName = this.getPseudoSelector(markers[i]) ;
			if (! cssName.equals("")) {
				state.add(cssName) ;
			}
		}
		updateState(state, addedOrRemoved) ;
	}

	/**
	 * A mapping between a marker.toString() representation, and corresponding pseudo selector
	 * Elements are added in this mapping when a marker is added.
	 * This mapping is then used to retrieve the pseudo selector for a marker that does not exist anymore (i.e., !marker.exists(), which is the case when a marker has been removed),
	 * so that this pseudo selector can be removed from the state of the edit part.
	 */
	protected Map<String, String> markerStringToMarkerPseudoSelector = new HashMap<String, String>() ;
	
	/**
	 * The Marker To Pseudo Selector Mapping Service
	 */
	protected MarkerToPseudoSelectorMappingService markerToPseudoSelectorMappingService ; 
	
	/**
	 * Convenience method returning the pseudo selector associated with a marker, using the MarkerToPseudoSelectorMappingService
	 * 
	 * @param marker The marker for which
	 * @return the pseudo selector associated with the given marker
	 */
	protected String getPseudoSelector(IMarker marker) {
		try {
			if (!marker.exists()) {
				// Tries to retrieve it from the local map
				String pseudoSelector = this.markerStringToMarkerPseudoSelector.get(marker.toString()) ;
				return pseudoSelector == null ? "" : pseudoSelector ;
			}
			
			if (this.markerToPseudoSelectorMappingService == null) {
				try {
					ServicesRegistry servicesRegistry = ServiceUtilsForEditPart.getInstance().getServiceRegistry(getHost()) ;
					this.markerToPseudoSelectorMappingService = servicesRegistry.getService(MarkerToPseudoSelectorMappingService.class) ;
				} catch (ServiceException e) {
					e.printStackTrace();
				}
			}
			String pseudoSelector = this.markerToPseudoSelectorMappingService.getPseudoSelector(marker.getType()) ;
			this.markerStringToMarkerPseudoSelector.put(marker.toString(), pseudoSelector) ;
			return pseudoSelector ;
		} catch (CoreException e) {
			e.printStackTrace();
		} 
		return "" ;
	}
}
