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
		final List<EObject> selection = new ArrayList<EObject>(getSelection().keySet());
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorInput input = new CompareUMLFileInput(selection, getSelection());
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
	protected Map<EObject, IEditorPart> getSelection() {
		final Map<EObject, IEditorPart> editorsAndEObject = new HashMap<EObject, IEditorPart>();
//		final IWorkbenchWindow ww = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
//		IWorkbenchPart activePart = ww.getActivePage().getActivePart();
//		if(activePart instanceof IEditorPart) {//if not we forbid to launch a comparison
//			int nbPapyrus = 0;
//			if(ww != null) {
//				final IWorkbenchPage[] pages = ww.getPages();
//				final IEditorReference[] refs = pages[0].getEditorReferences();
//				for(IEditorReference iEditorReference : refs) {
//					final IWorkbenchPart part = iEditorReference.getPart(false);
//					if(part != null && part instanceof IMultiDiagramEditor) {
//						nbPapyrus++;
//						final ISelection currentSelection = part.getSite().getSelectionProvider().getSelection();
//						if(currentSelection instanceof IStructuredSelection && ((IStructuredSelection)currentSelection).size() == 1) {
//							final Object object = ((IStructuredSelection)currentSelection).getFirstElement();
//							if(object instanceof IAdaptable) {
//								final Object res = ((IAdaptable)object).getAdapter(EObject.class);
//								if(res instanceof Element) {
//									editorsAndEObject.put((EObject)res, (IEditorPart)part);
//								}
//							}
//						}
//					}
//				}
//			}
//			if(nbPapyrus != 2) {
//				return Collections.emptyMap();
//			}
//		}
		return editorsAndEObject;
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#isEnabled()
	 * 
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		final List<EObject> selection = new ArrayList<EObject>(getSelection().keySet());
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
