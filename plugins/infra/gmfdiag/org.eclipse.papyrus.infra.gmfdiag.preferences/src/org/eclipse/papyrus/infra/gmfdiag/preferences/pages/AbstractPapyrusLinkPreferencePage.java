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
 *      Vincent Lorenzo (CEA-LIst) -  bug 335989: [Preferences] [Enhancement] Add a group for labels in each Connection Preference Page
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.preferences.pages;

import java.util.TreeMap;

import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.ConnectionGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.LabelGroup;
import org.eclipse.papyrus.infra.gmfdiag.preferences.ui.LinkColorGroup;
import org.eclipse.swt.widgets.Composite;

/**
 * An abstract implementation of a basic link preference page.
 * 
 * <p>
 * This Preference page adds the preference for
 * <ul>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getRouting <em>Routing</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getSmoothness <em>Smoothness</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isAvoidObstructions <em>Avoid Obstructions</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isClosestDistance <em>Closest Distance </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkStatus <em>Jump Link Status </em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#getJumpLinkType <em>Jump Link Type</em>}</li>
 * <li>{@link org.eclipse.gmf.runtime.notation.RoutingStyle#isJumpLinksReverse <em>Jump Links Reverse</em>}</li>
 * </ul>
 * 
 * @author tlandre
 */
public abstract class AbstractPapyrusLinkPreferencePage extends AbstractPapyrusElementPreferencePage {


	@Override
	protected void createPageContents(Composite parent) {
		super.createPageContents(parent);
		// color pref for links
		LinkColorGroup colorGroupComposite = new LinkColorGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(colorGroupComposite);

		// router for links
		ConnectionGroup connectionGroupComposite = new ConnectionGroup(parent, getPreferenceKey(), this);
		addAbstractGroup(connectionGroupComposite);

		//Label role group
		if(!getLabelRole().isEmpty()) {
			LabelGroup compartmentGroup = new LabelGroup(parent, getPreferenceKey(), this, getLabelRole());
			addAbstractGroup(compartmentGroup);
		}

	}

	protected TreeMap<String, String> getLabelRole() {
		return new TreeMap<String, String>();
	}
}
