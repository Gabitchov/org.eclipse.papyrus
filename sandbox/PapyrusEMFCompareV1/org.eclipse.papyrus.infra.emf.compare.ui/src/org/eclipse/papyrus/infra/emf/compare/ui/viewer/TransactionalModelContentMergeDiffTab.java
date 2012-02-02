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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.viewer;

import org.eclipse.compare.internal.CompareEditor;
import org.eclipse.emf.compare.ui.viewer.content.part.ModelContentMergeTabFolder;
import org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.AbstractSelectionService;


/**
 * The Structure Tab in the Merge Viewer.
 */
//duplicate code from tatiana
//TODO : verify the super class
public class TransactionalModelContentMergeDiffTab extends ModelContentMergeDiffTab {

	IEditorPart currentEditor;

	/**
	 * Instantiates a new uML model content merge diff tab.
	 * 
	 * @param parentComposite
	 *        the parent composite
	 * @param side
	 *        the side
	 * @param parentFolder
	 *        the parent folder
	 */
	public TransactionalModelContentMergeDiffTab(Composite parentComposite, int side, ModelContentMergeTabFolder parentFolder) {
		super(parentComposite, side, parentFolder);
		currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		//		service.
		ISelectionProvider selectionprovider = currentEditor.getEditorSite().getSelectionProvider();
		//		org.eclipse.emf.compare.ui.viewer.structure.ParameterizedStructureMergeViewer
		//		selectionprovider.setSelection(selection)addSelectionChangedListener(listener)SelectionChangedListener(this);
	}

	@Override
		protected void fireSelectionChanged(SelectionChangedEvent event) {
			// TODO Auto-generated method stub
			super.fireSelectionChanged(event);
			if(currentEditor instanceof ISelectionProvider){
//				((ISelectionProvider)currentEditor).getSelection()
				ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
				
			}
			if(currentEditor instanceof CompareEditor){
				ISelectionProvider selectionprovider = currentEditor.getSite().getSelectionProvider();
				ISelectionService service = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
//				((AbstractSelectionService)service).
				selectionprovider.setSelection(null);
			int d=0;
			d++;
			}
			
		}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}

	//	/*
	//	 * (non-Javadoc)
	//	 * 
	//	 * @see org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab#setSelectionToWidget(java.util.List, boolean)
	//	 */
	//	@Override
	//	protected void setSelectionToWidget(List l, boolean reveal) {
	//		// tfesenko filter stereotype applications
	//		List result = new ArrayList();
	//		for(Object next : l) {
	//			if(next instanceof EObject && UMLCompareUtils.isStereotypeApplication((EObject)next)) {
	//				EObject stereotypeApplication = (EObject)next;
	//				result.add(UMLUtil.getBaseElement(stereotypeApplication));
	//			} else {
	//				result.add(next);
	//			}
	//		}
	//		super.setSelectionToWidget(result, reveal);
	//	}
	//
	//	/*
	//	 * (non-Javadoc)
	//	 * 
	//	 * @see org.eclipse.emf.compare.ui.viewer.content.part.diff.ModelContentMergeDiffTab#setReflectiveInput(java.lang.Object)
	//	 */
	//	@Override
	//	public void setReflectiveInput(Object object) {
	//		// tfesenko 336361 - [UML Compare] Compare two elements: show right element as root
	//		if(object instanceof EObject) {
	//			clearCaches();
	//			// tfesenko default implementation sets object.eResource here
	//			setInput(object);
	//			setupCaches();
	//			needsRedraw = true;
	//		}
	//		super.setReflectiveInput(object);
	//	}

	@Override
	protected void firePostSelectionChanged(SelectionChangedEvent event) {
		// TODO Auto-generated method stub
		super.firePostSelectionChanged(event);
	}

}
