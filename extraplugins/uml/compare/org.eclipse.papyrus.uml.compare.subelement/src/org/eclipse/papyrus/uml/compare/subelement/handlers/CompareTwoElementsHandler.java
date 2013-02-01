/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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
package org.eclipse.papyrus.uml.compare.subelement.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.uml.compare.subelement.Activator;
import org.eclipse.papyrus.uml.compare.subelement.editor.CompareUMLModelElementEditor;
import org.eclipse.papyrus.uml.compare.subelement.input.CompareUMLFileInput;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Element;

/**
 * 
 * This handler allows to open the compare editor for 2 elements which are not owned by the same resourceset
 * 
 */
public class CompareTwoElementsHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorInput input = new CompareUMLFileInput(getSelection());
		try {
			//we open the compare editor
			page.openEditor(input, CompareUMLModelElementEditor.EDITOR_TYPE, true);
		} catch (PartInitException e) {
			Activator.log.error("Compare Editor can't be opened", e); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * 
	 * @return
	 *         the selected elements
	 */
	protected List<EObject> getSelection() {
		return Collections.emptyList();
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		final List<EObject> selection = getSelection();
		if(selection.size() == 2) {
			final EObject obj1 = selection.get(0);
			final EObject obj2 = selection.get(1);
			final Resource res1 = obj1.eResource();
			final Resource res2 = obj2.eResource();
			if(obj1.eResource() != obj2.eResource()) {
				final TransactionalEditingDomain domain1 = TransactionUtil.getEditingDomain(res1);
				final TransactionalEditingDomain domain2 = TransactionUtil.getEditingDomain(res2);
				if(domain1 != domain2) {
					final EClass eclass1 = obj1.eClass();
					final EClass eClass2 = obj2.eClass();
					return eclass1 == eClass2;
				}
			}
		}
		return false;
	}
}
