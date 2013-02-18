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
package org.eclipse.papyrus.infra.hyperlink.object;

import java.net.URL;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkWebShell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;

/**
 * this is an hyperlink to manage web link (it open a web browser when it is selected)
 * 
 */
public class HyperLinkWeb extends HyperLinkObject {

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
	 * @see org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject#executeSelectPressed()
	 * 
	 */
	@Override
	public void openLink() {
		try {
			// this is an url
			PlatformUI.getWorkbench().getBrowserSupport().createBrowser(IWorkbenchBrowserSupport.AS_EXTERNAL, "aCustomId", "url", "url").openURL(new URL(this.getHyperLinkWeb())); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		} catch (Exception e) {
			Activator.log.error(e);
		}

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject#executeEditMousePressed(java.util.List, org.eclipse.uml2.uml.Package)
	 * 
	 */
	@Override
	public void executeEditMousePressed(List<HyperLinkObject> list, EObject amodel) {
		EditorHyperLinkWebShell editor = new EditorHyperLinkWebShell();
		editor.setHyperLinkWeb(this);
		editor.open();
		int index = list.indexOf(this);
		list.remove(this);
		list.add(index, editor.getHyperLinkWeb());

	}

	@Override
	public boolean needsOpenCommand() {
		return false;
	}
}
