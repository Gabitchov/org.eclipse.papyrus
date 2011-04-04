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
import java.util.List;

import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.uml2.uml.Package;

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

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject#executeSelectPressed()
	 *
	 */
	@Override
	public void executeSelectPressed() {
		try {
			// this is an url
			PlatformUI.getWorkbench().getBrowserSupport().createBrowser(IWorkbenchBrowserSupport.AS_EXTERNAL, "aCustomId", "url", "url").openURL(new URL(this.getHyperLinkWeb()));
		} catch (Exception e) {
			Activator.log.error(e);
		}
		
	}
/**
 * 
 * @see org.eclipse.papyrus.diagram.common.ui.hyperlinkshell.HyperlinkObject#executeEditMousePressed(java.util.List, org.eclipse.uml2.uml.Package)
 *
 */
	@Override
	public void executeEditMousePressed(List<HyperlinkObject> list,Package amodel) {
		EditorHyperlinkWebShell editor = new EditorHyperlinkWebShell();
		editor.setHyperLinkWeb(this);
		editor.open();
		int index = list.indexOf(this);
		list.remove(this);
		list.add(index, editor.getHyperLinkWeb());
		
	}
}
