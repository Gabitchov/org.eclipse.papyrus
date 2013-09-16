package org.eclipse.papyrus.infra.gmfdiag.css.service;

import java.util.Map;

public interface IMarkerToPseudoSelectorMappingProvider {

	public static String MARKER_TO_PSEUDO_SELECTOR_MAPPING_PROVIDER_EXTENSION_POINT_ID = "org.eclipse.papyrus.infra.gmfdiag.css.markertopseudoselectormappingprovider";

	public Map<String, String> getMappings();

}
