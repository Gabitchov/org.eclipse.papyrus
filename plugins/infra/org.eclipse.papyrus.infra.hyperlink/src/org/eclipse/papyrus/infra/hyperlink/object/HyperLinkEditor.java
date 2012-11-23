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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.object;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.ui.EditorHyperLinkEditorShell;


public class HyperLinkEditor extends HyperLinkObject {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.ui.hyperlinkshell.HyperlinkObject#executeSelectPressed()
	 * 
	 */
	@Override
	public void executeSelectPressed() {
		EObject context = EMFHelper.getEObject(getObject());
		if(context != null) {
			try {
				IPageMngr pageMngr = ServiceUtilsForEObject.getInstance().getIPageMngr(context);
				pageMngr.openPage(getObject());
			} catch (Exception ex) {
				Activator.log.error(ex);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject#executeEditMousePressed(java.util.List, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param list
	 * @param amodel
	 */
	@Override
	public void executeEditMousePressed(List<HyperLinkObject> list, EObject amodel) {
		IPageIconsRegistry editorRegistry;
		try {
			editorRegistry = ServiceUtilsForEObject.getInstance().getService(IPageIconsRegistry.class, amodel);
		} catch (ServiceException e) {
			Activator.log.error(e);
			return;
		}

		EditorHyperLinkEditorShell editor = new EditorHyperLinkEditorShell(editorRegistry, amodel);
		editor.setHyperLinkEditor(this);
		editor.open();
		if(editor.getHyperLinkEditor() != null) {
			int index = list.indexOf(this);
			list.remove(this);
			list.add(index, editor.getHyperLinkEditor());
		}
	}
}
