package org.eclipse.papyrus.infra.gmfdiag.css.palette.provider;

import org.eclipse.papyrus.infra.gmfdiag.css.palette.aspect.CSSStylePostAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.AbstractAspectActionProvider;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IPaletteEntryProxy;
import org.w3c.dom.Node;


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
