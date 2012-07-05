package org.eclipse.papyrus.infra.core.markers;

import org.eclipse.emf.ecore.EValidator;


public class MarkerConstants {

	public static final String modelrefMarkerID = "org.eclipse.papyrus.modelmarker";

	/**
	 * Use the same name for the reference as in the "diagnostic" marker defined in org.eclipse.emf.ecore
	 * (we don't use the diagnostic marker, since it defines additional attributes that are not useful for
	 * trace point)
	 */
	public static final String uri = EValidator.URI_ATTRIBUTE;
}
