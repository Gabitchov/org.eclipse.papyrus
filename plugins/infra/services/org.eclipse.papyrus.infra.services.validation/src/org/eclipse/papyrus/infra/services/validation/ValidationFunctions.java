/*****************************************************************************
 * Copyright (c) 2011, 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA) - refactor for non-workspace abstraction of problem markers (CDO)
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.validation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.markerlistener.IPapyrusMarker;
import org.eclipse.papyrus.infra.services.validation.preferences.PreferenceUtils;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class ValidationFunctions implements IDecorationSpecificFunctions {

	public static final String error_co = "icons/etool16/error_co.gif";

	public static final String warning_co = "icons/etool16/warning_co.gif";

	public static final String info_co = "icons/etool16/info_co.gif";

	/**
	 * Return the image descriptor associated with an validation marker
	 */
	public ImageDescriptor getImageDescriptorForGE(IPapyrusMarker marker) {
		int severity = marker.getAttribute(IPapyrusMarker.SEVERITY, -1);
		return getImageDescriptorForGE(severity);
	}

	public ImageDescriptor getImageDescriptorForGE(int severity) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor overlay = null;
		switch(severity) {
		case IPapyrusMarker.SEVERITY_ERROR:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK);
			break;
		case IPapyrusMarker.SEVERITY_WARNING:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK);
			break;
		case IPapyrusMarker.SEVERITY_INFO:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK);
			break;
		}

		return overlay;
	}

	/**
	 * Return the image descriptor associated with an validation marker
	 */
	public ImageDescriptor getImageDescriptorForME(IPapyrusMarker marker) {
		int severity = marker.getAttribute(IPapyrusMarker.SEVERITY, -1);
		return getImageDescriptorForME(severity);
	}

	public ImageDescriptor getImageDescriptorForME(int severity) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor overlay = null;

		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		switch(severity) {
		case IPapyrusMarker.SEVERITY_ERROR:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR);
			// workaround for bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383810
			if(overlay == null) {
				overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, error_co);
			}
			break;
		case IPapyrusMarker.SEVERITY_WARNING:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
			// workaround for bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383810
			if(overlay == null) {
				overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, warning_co);
			}
			break;
		case IPapyrusMarker.SEVERITY_INFO:
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, info_co);
			break;
		}

		return overlay;
	}

	public PreferedPosition getPreferedPosition(IPapyrusMarker marker) {
		return PreferedPosition.SOUTH_WEST;
	}

	public String getMessage(IPapyrusMarker marker) {
		// message is stored within marker
		return marker.getAttribute(IPapyrusMarker.MESSAGE, ""); //$NON-NLS-1$
	}

	public int getPriority(IPapyrusMarker marker) {
		return marker.getAttribute(IPapyrusMarker.SEVERITY, -1);
	}

	public MarkChildren supportsMarkerPropagation() {
		return PreferenceUtils.getHierarchicalMarkers();
	}

	/**
	 * Set of child decorations. use severity information?
	 */
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		int childWarnings = 0;
		int childErrors = 0;
		// loop over children. Use the "highest" level for parent decoration
		for(IPapyrusDecoration childDecoration : childDecorations) {
			if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IPapyrusMarker.SEVERITY_WARNING)) {
				childWarnings ++;
			}
			else if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IPapyrusMarker.SEVERITY_ERROR)) {
				childErrors ++;
			}
		}
		if(childWarnings > 0 || childErrors > 0) {
			String message = ""; //$NON-NLS-1$
			int childSeverity = 0;
			String msgErrors = childErrors + " error(s)"; //$NON-NLS-1$
			String msgWarnings =  childWarnings + " warnings(s)"; //$NON-NLS-1$
			if(childErrors > 0 && childWarnings > 0) {
				message =  msgErrors + " and " + msgWarnings; //$NON-NLS-1$
				childSeverity = IPapyrusMarker.SEVERITY_ERROR;
			}
			else if(childErrors > 0) {
				message = msgErrors;
				childSeverity = IPapyrusMarker.SEVERITY_ERROR;
			}
			else if(childWarnings > 0) {
				message = msgWarnings;
				childSeverity = IPapyrusMarker.SEVERITY_WARNING;
			}
			message += " in the children"; //$NON-NLS-1$
			IPapyrusDecoration deco = new Decoration(null, EValidator.MARKER,
				getImageDescriptorForGE(childSeverity), getImageDescriptorForME(childSeverity), message, null, childSeverity);
			deco.setPosition(PreferedPosition.NORTH_WEST);
			return deco;
		}
		else {
			return null;
		}
	}
}
