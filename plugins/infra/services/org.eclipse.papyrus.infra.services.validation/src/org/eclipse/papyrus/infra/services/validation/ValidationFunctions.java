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

		switch(severity) {
		case IMarker.SEVERITY_ERROR:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_ERROR);
			break;
		case IMarker.SEVERITY_WARNING:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_DEC_FIELD_WARNING);
			break;
		case IMarker.SEVERITY_INFO:
			overlay = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK); // TODO: Image too big (unclear, if "info" is useful)
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

	public MarkChildren supportsMarkerPropagation() {
		return PreferencePage.getHierarchicalMarkers();
	}

	/**
	 * Set of child decorations. use severity information?
	 */
	public IPapyrusDecoration markerPropagation(EList<IPapyrusDecoration> childDecorations) {
		int childSeverity = 0;
		// loop over children. Use the "highest" level for parent decoration
		for(IPapyrusDecoration childDecoration : childDecorations) {
			if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IMarker.SEVERITY_WARNING)) {
				childSeverity = IMarker.SEVERITY_WARNING;
			}
			else if(childDecoration.getDecorationImageForME() == getImageDescriptorForME(IMarker.SEVERITY_WARNING)) {
				childSeverity = IMarker.SEVERITY_ERROR;
				break; // no need to check further
			}
		}
		if(childSeverity != 0) {
			String message = (childSeverity == IMarker.SEVERITY_ERROR) ? "Error" : "Warning";
			message += " marker in one of the children (packaged elements)";
			IPapyrusDecoration deco = new Decoration(null, EValidator.MARKER,
				getImageDescriptorForGE(childSeverity), getImageDescriptorForME(childSeverity), message, null);
			deco.setPosition(PreferedPosition.NORTH_WEST);
			return deco;
		}
		else {
			return null;
		}
	}
}
