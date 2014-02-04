/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.newchild;


import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.infra.newchild.CreationMenuFactory;
import org.eclipse.papyrus.infra.newchild.CreationMenuRegistry;
import org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Folder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.CompoundContributionItem;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

/**
 * This class has in charge to create menu from elementCreationMenuModel
 *
 */
public class DynamicNewChild extends CompoundContributionItem  {

	protected TransactionalEditingDomain editingDomain;
	protected CreationMenuRegistry creationMenuRegistry;
	/**
	 * 
	 * Constructor.
	 *
	 */
	public DynamicNewChild() {
		creationMenuRegistry = new CreationMenuRegistry();
	}

	/**
	 * 
	 * Constructor.
	 *
	 * @param id
	 */
	public DynamicNewChild(String id) {
		super(id);
	}
	
	
	 protected IContributionItem[] getContributionItems() {
	        return new IContributionItem[0]; 
	    }
	
	  public boolean isDynamic(){
	        return true;
	    }

	
	
	public void fill(Menu menu, int index) {
		super.fill(menu, index);
		EObject eObject= getSelection();
		CreationMenuFactory creationMenuFactory= new CreationMenuFactory(editingDomain);
		ArrayList<Folder> folders= creationMenuRegistry.getRootFolder();
		Iterator<Folder> iterFolder= folders.iterator();
		while (iterFolder.hasNext()) {
			Folder currentFolder= iterFolder.next();
			creationMenuFactory.populateMenu(menu, currentFolder,eObject);
		}

	}



	
	/**
	 * getSelected eObject in the model explorer
	 * @return eObject or null
	 */
	protected EObject getSelection(){
		ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService();
		ISelection selection = selectionService.getSelection();

		if(selection instanceof IStructuredSelection) {
			Object selectedobject = ((IStructuredSelection)selection).getFirstElement();
			if(selectedobject instanceof IAdaptable) {
				EObject selectedEObject = (EObject)((IAdaptable)selectedobject).getAdapter(EObject.class);
				try {
					editingDomain =ServiceUtilsForEObject.getInstance().getService(org.eclipse.emf.transaction.TransactionalEditingDomain.class, selectedEObject);
				} catch (Exception ex) {
					System.err.println("impossible to get the Transactional Editing Domain "+ex);
				}
				return selectedEObject;
			}
		}
		return null;
	}
}
