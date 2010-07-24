/****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Thibault Landre (Atos Origin) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.preferences.initializer;

import org.eclipse.gmf.runtime.notation.JumpLinkStatus;
import org.eclipse.gmf.runtime.notation.JumpLinkType;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.gmf.runtime.notation.RoutingStyle;
import org.eclipse.gmf.runtime.notation.Smoothness;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle <em>Routing Style</em>} of a
 * connection view with the properties contained in a preference store
 * 
 * <p>
 * The following properties can be initialized :
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getRouting <em> Routing</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getSmoothness <em> Smoothness</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isAvoidObstructions <em>Avoid Obstructions</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isClosestDistance <em>Closest Distance </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkStatus <em>Jump Link Status </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkType <em> Jump Link Type </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isJumpLinksReverse <em>Jump Links Reverse</em>}</li>
 * </ul>
 * </p>
 * 
 * @author tlandre
 */
public class LinkViewInitializer extends AbstractViewInitializer {

	/**
	 * The routing style
	 */
	RoutingStyle routingStyle;

	/**
	 * Constructor
	 * 
	 * @param view
	 *        the view to initialize
	 * @param store
	 *        the preference store where the properties are.
	 */
	// @unused
	public LinkViewInitializer(View view, IPreferenceStore store) {
		super(view, store);
		routingStyle = (RoutingStyle)view.getStyle(NotationPackage.Literals.ROUTING_STYLE);
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#getRouting
	 * <em>Routing</em>}
	 * 
	 * @param preferenceRoutingName
	 *        the name of the preference where is stored the value of the Routing
	 */
	// @unused
	public void initRouting(String preferenceRoutingName) {
		if(routingStyle != null) {
			Routing routing = Routing.get(getStore().getInt(preferenceRoutingName));
			if(routing != null) {
				routingStyle.setRouting(routing);
			}
		}
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#isAvoidObstructions
	 * <em>Avoid Obstructions</em>}
	 * 
	 * @param preferenceRoutingJumpName
	 *        the name of the preference where is stored the value.
	 */
	// @unused
	public void initAvoidObstructions(String preferenceRoutingJumpName) {
		routingStyle.setAvoidObstructions(getStore().getBoolean(preferenceRoutingJumpName));
	}

	/**
	 * Initialize {@link org.eclipse.gmf.runtime.notation.RoutingStyle#isClosestDistance
	 * <em>Closest Distance</em>}
	 * 
	 * @param preferenceClosestDistanceName
	 *        the name of the preference where is stored the value of the closest distance
	 */
	// @unused
	public void initClosestDistance(String preferenceClosestDistanceName) {
		routingStyle.setClosestDistance(getStore().getBoolean(preferenceClosestDistanceName));
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#isJumpLinksReverse
	 * <em>Jump Links Reverse</em>}
	 * 
	 * @param preferenceJumpLinkReverseName
	 *        the name of the preference where is stored the value of the jumplink reverse
	 */
	// @unused
	public void initJumpLinkReverse(String preferenceJumpLinkReverseName) {
		routingStyle.setJumpLinksReverse(getStore().getBoolean(preferenceJumpLinkReverseName));
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkStatus
	 * <em>Jump Link Status</em>}
	 * 
	 * @param preferenceJumpLinkStatusName
	 *        the name of the preference where is stored the value of the jumplink status
	 */
	// @unused
	public void initJumpLinkStatus(String preferenceJumpLinkStatusName) {
		JumpLinkStatus jumpLinkStatus = JumpLinkStatus.get(getStore().getInt(preferenceJumpLinkStatusName));
		if(jumpLinkStatus != null) {
			routingStyle.setJumpLinkStatus(jumpLinkStatus);
		}
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkType
	 * <em>Jump Link Type</em>}
	 * 
	 * @param preferenceJumpLinkTypeName
	 *        the name of the preference where is stored the value of the jumplink type
	 */
	// @unused
	public void initJumpLinkType(String preferenceJumpLinkTypeName) {
		JumpLinkType jumpLinkType = JumpLinkType.get(getStore().getInt(preferenceJumpLinkTypeName));
		if(jumpLinkType != null) {
			routingStyle.setJumpLinkType(jumpLinkType);
		}
	}

	/**
	 * Initialize the {@link org.eclipse.gmf.runtime.notation.RoutingStyle#getSmoothness
	 * <em>Smoothness</em>}
	 * 
	 * @param preferenceSmoothnessName
	 *        the name of the preference where is stored the value of the Smoothness
	 */
	// @unused
	public void initSmoothness(String preferenceSmoothnessName) {
		Smoothness smoothness = Smoothness.get(getStore().getInt(preferenceSmoothnessName));
		if(smoothness != null) {
			routingStyle.setSmoothness(smoothness);
		}
	}

}
