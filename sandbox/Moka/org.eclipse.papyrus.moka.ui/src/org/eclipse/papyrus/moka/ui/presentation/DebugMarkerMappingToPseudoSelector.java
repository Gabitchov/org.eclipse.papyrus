/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.moka.ui.presentation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.papyrus.infra.gmfdiag.css.service.IMarkerToPseudoSelectorMappingProvider;
import org.eclipse.papyrus.moka.MokaConstants;

/**
 * A mapping between markers defined by Moka,
 * a corresponding CSS pseudo selectors.
 * These pseudo selectors can be used in CSS styles,
 * in order to attach a specific style with one of these markers.
 *
 */
public class DebugMarkerMappingToPseudoSelector implements IMarkerToPseudoSelectorMappingProvider {
	
	protected Map<String, String> mappings ;
	
	protected final static String BREAKPOINT_MARKER_PSEUDO_SELECTOR = "breakpoint" ;
	protected final static String SUSPENDED_MARKER_PSEUDO_SELECTOR = "suspended" ;
	protected final static String ANIMATION_MARKER_PSEUDO_SELECTOR = "animation" ;

	public DebugMarkerMappingToPseudoSelector() {
		// Do nothing
	}

	public Map<String, String> getMappings() {
		if (this.mappings == null) {
			this.mappings = new HashMap<String, String>() ;
			// Adds pseudo selectors for 'breakpoint', 'suspended' and 'animation' markers
			this.mappings.put(MokaConstants.MOKA_BREAKPOINT_MARKER_ID, BREAKPOINT_MARKER_PSEUDO_SELECTOR) ;
			this.mappings.put(MokaConstants.MOKA_SUSPENDED_MARKER_ID, SUSPENDED_MARKER_PSEUDO_SELECTOR) ;
			this.mappings.put(MokaConstants.MOKA_ANIMATION_MARKER_ID, ANIMATION_MARKER_PSEUDO_SELECTOR) ;
		}
		return this.mappings ;
	}

}
