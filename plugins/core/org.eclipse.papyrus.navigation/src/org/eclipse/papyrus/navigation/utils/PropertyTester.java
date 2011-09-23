/*******************************************************************************
 * Copyright (c) 2011 AtoS
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anass RADOUANI (AtoS) - test property to enable or disable Navigation Icons
 *******************************************************************************/
package org.eclipse.papyrus.navigation.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.adaptor.gmf.DiagramsUtil;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.navigation.Activator;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;

public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {

	@SuppressWarnings("deprecation")
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean result = false;

		ServicesRegistry serviceRegistry = EditorUtils.getServiceRegistry();
		if(serviceRegistry != null && Messages.IS_BACK_POSSIBLE.equals(property)) {
			try {
				IPageMngr pageMngr = serviceRegistry.getService(IPageMngr.class);
				result = pageMngr.hasPreviousHistory();
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		} else if(serviceRegistry != null && Messages.IS_NEXT_POSSIBLE.equals(property)) {
			try {
				IPageMngr pageMngr = serviceRegistry.getService(IPageMngr.class);
				result = pageMngr.hasNextHistory();
			} catch (ServiceException e) {
				e.printStackTrace();
			}

		} else if(Messages.IS_UP_POSSIBLE.equals(property) || Messages.IS_TOP_POSSIBLE.equals(property)) {
			IWorkbenchWindow activeWorkbenchWindow = Activator.getActiveWorkbenchWindow();
			if (activeWorkbenchWindow != null)
			{
				IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
				if (activePage != null)
				{
					IEditorPart editor = activePage.getActiveEditor();
					if(editor instanceof CoreMultiDiagramEditor) {
						CoreMultiDiagramEditor papyrusEditor = (CoreMultiDiagramEditor)editor;
						EObject parent = null;
						if(papyrusEditor.getDiagram() != null && papyrusEditor.getDiagram().getElement() != null) {
							parent = papyrusEditor.getDiagram().getElement().eContainer();
						}
						
						if(parent != null) {
							while(parent != null && !result) {
								result = !DiagramsUtil.getAssociatedDiagrams(parent, null).isEmpty();
								parent = parent.eContainer();
							}
						}
					}
				}
			}
		}

		return result;
	}

}
