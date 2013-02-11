package org.eclipse.papyrus.infra.services.markerlistener;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.services.IService;

public interface IMarkerEventListener extends IService {
	
	/**
	 * ID of the Marker Event Listener extension point, which is used to register a particular IMarkerEventListener with the Markers Monitor Service
	 */
	public static final String MARKER_EVENT_LISTENER_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.services.markerlistener.markereventlistener" ;
	
	/**
	 * Constant representing the deletion of a marker
	 */
	public static final int MARKER_REMOVED = 0 ;
	
	/**
	 * Constant representing the creation of a marker
	 */
	public static final int MARKER_ADDED = 1 ;
	
	/**
	 * Notifies this listener that a marker has been created (MARKER_ADDED) or deleted (MARKER_REMOVED)
	 * 
	 * @param eObjectOfMarker The eObject to which the given marker refers
	 * @param marker The actual marker
	 * @param addedOrRemoved Whether the breakpoint has been added or removed
	 */
	public void notifyMarkerChange(EObject eObjectOfMarker, IMarker marker, int addedOrRemoved) ;
	
	/**
	 * Determines if this listener has to be notified during the initial marker checking performed by MarkersMonitorService
	 * @see MarkersMonitorService.checkMarkers()
	 * 
	 * @return true if this listener has to be notified during the initial marker checking performed by MarkersMonitorService, false otherwise
	 */
	public boolean isNotifiedOnInitialMarkerCheck() ;
	
}
