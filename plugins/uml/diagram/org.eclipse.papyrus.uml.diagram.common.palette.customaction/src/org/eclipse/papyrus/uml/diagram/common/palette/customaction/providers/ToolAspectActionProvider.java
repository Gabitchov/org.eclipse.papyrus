/*****************************************************************************
 * Copyright (c) 2011 AtoS.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (AtoS) tristan.faure@atos.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.palette.customaction.providers;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AbstractAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.uml2.uml.Profile;
import org.w3c.dom.Node;

/**
 * Provider for custom creation
 * @author tfaure
 *
 */
public class ToolAspectActionProvider extends AbstractAspectActionProvider {

	private List<Tool> filtered;
	private Node node;

	public IAspectAction createAction(Node configurationNode) {
		if (configurationNode != null)
		{
			this.node = configurationNode;
		}
		ToolAspectAction action = new ToolAspectAction();
		action.init(node, this);
		return action;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectActionProvider#isEnable(org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy)
	 */
	public boolean isEnable(final IPaletteEntryProxy entryProxy) {
		Collection<Tool> allExtensions = ToolAspectAction
				.getAllExtensions();
		boolean result = allExtensions != null && !allExtensions.isEmpty();
		if (result) {
			filtered = ToolAspectAction.getFiltered(entryProxy, allExtensions);
			result = !filtered.isEmpty();
		}
		return result;
	}

	public void init(Node configurationNode, IAspectActionProvider factory) {
	}

	public IStatus checkPreCondition() {
		return null;
	}

	public IStatus checkPostCondition() {
		return null;
	}

	public Control createConfigurationComposite(Composite parent,
			IPaletteEntryProxy entryProxy, List<Profile> appliedProfiles) {
		return null;
	}

	public void save(Node parentNode) {
		
	}


}
