package org.eclipse.papyrus.infra.services.validation;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.services.decoration.IDecorationSpecificFunctions;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration;
import org.eclipse.papyrus.infra.services.decoration.util.Decoration.PreferedPosition;
import org.eclipse.papyrus.infra.services.decoration.util.IPapyrusDecoration;
import org.eclipse.papyrus.infra.services.validation.preferences.PreferencePage;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


public class ValidationFunctions implements IDecorationSpecificFunctions {

	public static final String error_co = "icons/etool16/error_co.gif";

	public static final String warning_co = "icons/etool16/warning_co.gif";

	public static final String info_co = "icons/etool16/info_co.gif";

	/**
	 * Return the image descriptor associated with an validation marker
	 */
	public ImageDescriptor getImageDescriptorForGE(IMarker marker) {
		int severity = marker.getAttribute(IMarker.SEVERITY, -1);
		return getImageDescriptorForGE(severity);
	}

	public ImageDescriptor getImageDescriptorForGE(int severity) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor overlay = null;
		switch(severity) {
		case IMarker.SEVERITY_ERROR:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_ERROR_TSK);
			break;
		case IMarker.SEVERITY_WARNING:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_WARN_TSK);
			break;
		case IMarker.SEVERITY_INFO:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK);
			break;
		}

		return overlay;
	}

	/**
	 * Return the image descriptor associated with an validation marker
	 */
	public ImageDescriptor getImageDescriptorForME(IMarker marker) {
		int severity = marker.getAttribute(IMarker.SEVERITY, -1);
		return getImageDescriptorForME(severity);
	}

	public ImageDescriptor getImageDescriptorForME(int severity) {
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor overlay = null;

		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		switch(severity) {
		case IMarker.SEVERITY_ERROR:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR);
			// workaround for bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383810
			if(overlay == null) {
				overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, error_co);
			}
			break;
		case IMarker.SEVERITY_WARNING:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
			// workaround for bug https://bugs.eclipse.org/bugs/show_bug.cgi?id=383810
			if(overlay == null) {
				overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, warning_co);
			}
			break;
		case IMarker.SEVERITY_INFO:
			overlay = widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, info_co);
			break;
		}

		return overlay;
	}

	public PreferedPosition getPreferedPosition(IMarker marker) {
		return PreferedPosition.SOUTH_WEST;
	}

	public String getMessage(IMarker marker) {
		// message is stored within marker
		return marker.getAttribute(IMarker.MESSAGE, "");
	}

	public int getPriority(IMarker marker) {
		return marker.getAttribute(IMarker.SEVERITY, -1);
	}

	public MarkChildren supportsMarkerPropagation() {
		return PreferencePage.getHierarchicalMarkers();
	}

	/**
	 * Set of child decorations. use severity information?
	 */
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		boolean childWarnings = false;
		boolean childErrors = false;
		// loop over children. Use the "highest" level for parent decoration
		for(IPapyrusDecoration childDecoration : childDecorations) {
			if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IMarker.SEVERITY_WARNING)) {
				childWarnings = true;
			}
			else if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IMarker.SEVERITY_ERROR)) {
				childErrors = true;
			}
		}
		if(childWarnings || childErrors) {
			String message = "";
			int childSeverity = 0;
			if(childErrors && childWarnings) {
				message = "Error and warning";
				childSeverity = IMarker.SEVERITY_ERROR;
			}
			else if(childErrors) {
				message = "Error";
				childSeverity = IMarker.SEVERITY_ERROR;
			}
			else if(childWarnings) {
				message = "Warning";
				childSeverity = IMarker.SEVERITY_WARNING;
			}
			message += " marker(s) in one of the children";
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
