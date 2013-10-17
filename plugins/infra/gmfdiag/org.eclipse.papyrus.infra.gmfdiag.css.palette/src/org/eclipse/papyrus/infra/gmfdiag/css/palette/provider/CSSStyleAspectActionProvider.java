/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.palette.provider;

import org.eclipse.papyrus.infra.gmfdiag.css.palette.aspect.CSSStylePostAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AbstractAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.w3c.dom.Node;

/**
 * A Palette post action provider to automatically add a CSS Style on a newly created element
 * 
 * @author Camille Letavernier
 * 
 * @see CSSStylePostAction
 */
public class CSSStyleAspectActionProvider extends AbstractAspectActionProvider {

	public IAspectAction createAction(Node configurationNode) {
		IAspectAction cssStylePostAction = new CSSStylePostAction();
		cssStylePostAction.init(configurationNode, this);
		return cssStylePostAction;
	}

	public boolean isEnable(IPaletteEntryProxy entryProxy) {
		return true;
	}

}
