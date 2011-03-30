/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.net.URL;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * this is an hyperlink to manage web link (it open a web browser when it is selected) 
 *
 */
public class HyperLinkWeb extends HyperlinkObject {

	public String getHyperLinkWeb() {
		// TODO Auto-generated method stub
		return (String)super.getObject();
	}

	public void setHyperLinkWeb(String object) {
		// TODO Auto-generated method stub
		super.setObject(object);
	}

	@Override
	public void executeMousePressed() {
		try {
			// this is an url
			PlatformUI.getWorkbench().getBrowserSupport().createBrowser(IWorkbenchBrowserSupport.AS_EXTERNAL, "aCustomId", "url", "url").openURL(new URL(this.getHyperLinkWeb()));
		} catch (Exception e) {
			Activator.log.error(e);
		}
		
	}
}
