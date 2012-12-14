/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.tracepoints;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;


public class TraceFunctions implements IDecorationSpecificFunctions {

	public static final String activeBreakpoint16 = "icons/etool16/brkp_16x16.gif";

	public static final String inActiveBreakpoint16 = "icons/etool16/brkpd_16x16.gif";

	public static final String activeBreakpoint9 = "icons/etool16/brkp_9x9.gif";

	public static final String inActiveBreakpoint9 = "icons/etool16/brkpd_9x9.gif";


	/**
	 * Return the image descriptor associated with a trace or breakpoint marker
	 */
	public ImageDescriptor getImageDescriptorForGE(IMarker marker) {

		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		if(isActive) {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint16);
		}
		else {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint16);
		}

		return overlay;
	}

	/**
	 * Return the image descriptor associated with a trace or breakpoint marker
	 */
	public ImageDescriptor getImageDescriptorForME(IMarker marker) {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		if(isActive) {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint9);
		}
		else {
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint9);
		}

		return overlay;
	}

	public PreferedPosition getPreferedPosition(IMarker marker) {
		return PreferedPosition.SOUTH_EAST;
	}

	public String getMessage(IMarker marker) {
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		boolean isTracepoint = marker.getAttribute(TracepointConstants.isTracepoint, false);
		return (isActive ? "active" : "inactive") + " " +
			(isTracepoint ? "trace point" : "break point");
	}

	public int getPriority(IMarker marker) {
		return 0; // all markers have same priority (and we should not have multiple markers on the same model element). 
	}

	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		return null;
	}

	public MarkChildren supportsMarkerPropagation() {
		return MarkChildren.NO;
	}
}
