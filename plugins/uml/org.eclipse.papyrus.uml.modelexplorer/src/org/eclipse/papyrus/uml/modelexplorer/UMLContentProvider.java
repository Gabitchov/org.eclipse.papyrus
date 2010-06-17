/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
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
package org.eclipse.papyrus.uml.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.Activator;
import org.eclipse.papyrus.modelexplorer.MoDiscoContentProvider;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * this is a specific content provider used to nnot display UML stereotype applications
 *
 */
public class UMLContentProvider extends MoDiscoContentProvider {

	
	@Override
	public EObject[] getRootElements(Object inputElement) {
		// we are standing for the multi editor
		try {
			IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage page = workbenchWindow.getActivePage();
			if (page != null && page.getActiveEditor() instanceof IMultiDiagramEditor) {
				EList<EObject> contents = EditorUtils.getDiResourceSet()
						.getModelResource().getContents();
				ArrayList<EObject> result = new ArrayList<EObject>();
				Iterator<EObject> iterator = contents.iterator();
				while (iterator.hasNext()) {
					EObject eObject = (EObject) iterator.next();
					//functionality that comes from UML2 plugins
					if(UMLUtil.getStereotype(eObject) == null){
						result.add(eObject);
					}
				}
				return result.toArray(new EObject[result.size()]);
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
		return new EObject[0];

	}
}
