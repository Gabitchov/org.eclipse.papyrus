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
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;


public class TraceFunctions implements IDecorationSpecificFunctions {

	public static final String activeBreakpoint16 = "icons/etool16/brkp_16x16.gif"; //$NON-NLS-1$

	public static final String inActiveBreakpoint16 = "icons/etool16/brkpd_16x16.gif"; //$NON-NLS-1$

	public static final String activeTracepoint16 = "icons/etool16/trcp_16x16.gif"; //$NON-NLS-1$

	public static final String inActiveTracepoint16 = "icons/etool16/trcpd_16x16.gif"; //$NON-NLS-1$

	public static final String activeBreakpoint9 = "icons/etool16/brkp_9x9.gif"; //$NON-NLS-1$

	public static final String inActiveBreakpoint9 = "icons/etool16/brkpd_9x9.gif"; //$NON-NLS-1$

	public static final String activeTracepoint11 = "icons/etool16/trcp_11x12.gif"; //$NON-NLS-1$

	public static final String inActiveTracepoint11 = "icons/etool16/trcp_11x12.gif"; //$NON-NLS-1$

	/**
	 * Return the image descriptor associated with a trace or breakpoint marker
	 */
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker) {


		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		boolean isTracepoint = marker.getAttribute(TracepointConstants.isTracepoint, false);
		if(isTracepoint) {
			overlay = isActive ?
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeTracepoint16) :
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveTracepoint16);
		}
		else {
			overlay = isActive ?
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint16) :
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint16);
		}

		return overlay;
	}

	/**
	 * Return the image descriptor associated with a trace or breakpoint marker
	 */
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker) {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		ImageDescriptor overlay = null;
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		boolean isTracepoint = marker.getAttribute(TracepointConstants.isTracepoint, false);
		if(isTracepoint) {
			overlay = isActive ?
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeTracepoint11) :
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveTracepoint11);
		}
		else {
			overlay = isActive ?
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, activeBreakpoint9) :
				widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, inActiveBreakpoint9);
		}

		return overlay;
	}

	public PreferedPosition getPreferedPosition(IPapyrusMarker marker) {
		return PreferedPosition.SOUTH_EAST;
	}

	public String getMessage(IPapyrusMarker marker) {
		boolean isActive = marker.getAttribute(TracepointConstants.isActive, false);
		boolean isTracepoint = marker.getAttribute(TracepointConstants.isTracepoint, false);
		return (isActive ? "active" : "inactive") + " " +   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
			(isTracepoint ? "trace point" : "break point");  //$NON-NLS-1$//$NON-NLS-2$
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

	@Override
	public int getPriority(IPapyrusMarker marker) {
		// TODO Auto-generated method stub
		return 0;
	}
}
