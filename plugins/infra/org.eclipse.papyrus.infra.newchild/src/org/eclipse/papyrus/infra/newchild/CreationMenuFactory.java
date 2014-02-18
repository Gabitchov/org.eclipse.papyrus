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
package org.eclipse.papyrus.infra.newchild;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.CreationMenu;
import org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Folder;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

/**
 * this class contains code to construct menu from a Menu and a selected object
 *
 */
public class CreationMenuFactory {
	private TransactionalEditingDomain editingDomain;

	/**
	 * 
	 * Constructor.
	 *
	 * @param editingDomain
	 */
	public CreationMenuFactory(TransactionalEditingDomain editingDomain) {
		super();
		this.editingDomain = editingDomain;
	}

	/**
	 * construct a menu from a folder, this is a recursion
	 * @param menu the current menu
	 * @param folder the folder
	 * @param selectedObject the current selection
	 * @return true if sub-menu has been added
	 */
	public boolean populateMenu(Menu menu, Folder folder, EObject selectedObject){
		if(selectedObject!=null && folder!=null){
			org.eclipse.swt.widgets.MenuItem topMenuItem = new MenuItem(menu,SWT.CASCADE );
			topMenuItem.setText(folder.getLabel());
			if(folder.getIcon()!=null){
				URL url;
				try {
					url = new URL(folder.getIcon());
					ImageDescriptor imgDesc=ImageDescriptor.createFromURL(url);
					topMenuItem.setImage(imgDesc.createImage());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			Menu topMenu=new Menu(menu);
			topMenuItem.setMenu(topMenu);
			boolean oneDisplayedMenu=false;
			for(org.eclipse.papyrus.infra.newchild.ElementCreationMenuModel.Menu currentMenu : folder.getMenu()) {
				boolean result=false;
				if( currentMenu instanceof Folder){
					 result=populateMenu(topMenu, (Folder) currentMenu, selectedObject);
					

				}

				if( currentMenu instanceof CreationMenu){
					CreationMenu currentCreationMenu=(CreationMenu)currentMenu;
					EReference reference=null;
					String role=currentCreationMenu.getRole();
					//the role is precised
					if( role!=null){
						EStructuralFeature feature= selectedObject.eClass().getEStructuralFeature(role);
						if( feature instanceof EReference){
							reference=(EReference)feature;
							 result =constructMenu(selectedObject, topMenu, currentCreationMenu, reference);
						}
					}
					else{//no precisison
						//test if all roles must be displayed
						if(currentCreationMenu.isDisplayAllRoles()){
							 result  = constructMenu(selectedObject, topMenu, currentCreationMenu);
						}
						else{

							result  = constructMenu(selectedObject, topMenu, currentCreationMenu, reference);
						}
					}
				}
				if(result){
					oneDisplayedMenu=true;
				}
			}
			if(!oneDisplayedMenu){
				topMenuItem.dispose();
			}
			return oneDisplayedMenu;

		}
		return false;

	}

	/**
	 * create menu by displaying if possible different roles
	 * @param selectedObject the current object
	 * @param menu the current menu in creation
	 * @param currentCreationMenu 
	 * @return true if sub-menu has been created
	 */
	protected boolean constructMenu(EObject selectedObject, Menu menu, CreationMenu currentCreationMenu) {
		//find the feature between children and owner
		ArrayList<EStructuralFeature> possibleEFeatures = getEreferences(selectedObject, currentCreationMenu);

		if(possibleEFeatures.size()==1){
			Command cmd=buildCommand(null, selectedObject, currentCreationMenu.getElementTypeIdRef());
			if( cmd.canExecute()){
				MenuItem item = new MenuItem(menu, SWT.NONE);
				fillIcon(currentCreationMenu, item);
				item.setEnabled(true);
				item.setText(currentCreationMenu.getLabel());
				item.addSelectionListener(new CreationMenuListener(cmd, editingDomain));
				return true;
			}
			return false;
		}
		else if(possibleEFeatures.size()>1){
			org.eclipse.swt.widgets.MenuItem topMenuItem = new MenuItem(menu,SWT.CASCADE );
			topMenuItem.setText(currentCreationMenu.getLabel());
			Menu topMenu=new Menu(menu);
			topMenuItem.setMenu(topMenu);
			for(EStructuralFeature eStructuralFeature : possibleEFeatures) {

				Command cmd=buildCommand((EReference)eStructuralFeature, selectedObject, currentCreationMenu.getElementTypeIdRef());
				if( cmd.canExecute()){
					MenuItem item = new MenuItem(topMenu, SWT.NONE);
					fillIcon(currentCreationMenu, item);
					item.setEnabled(true);
					item.setText("As "+eStructuralFeature.getName());
					item.addSelectionListener(new CreationMenuListener(cmd, editingDomain));
				}

			}
			if(topMenu.getItemCount()==0){
				topMenu.dispose();
				return false;
			}
			else{
				return true;
			}
		}
		else{
			return false;
		}
	}
	/**
	 * display an icon from a specified url or from Element type
	 * @param currentCreationMenu
	 * @param item
	 */
	protected void fillIcon(CreationMenu currentCreationMenu, MenuItem item) {
		if(currentCreationMenu.getIcon()!=null && !"".equals(currentCreationMenu.getIcon())){
			URL url;
			try {
				url = new URL(currentCreationMenu.getIcon());
				ImageDescriptor imgDesc=ImageDescriptor.createFromURL(url);
				item.setImage(imgDesc.createImage());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}else{
			createIconFromElementType(currentCreationMenu, item);
		}
	}
	/**
	 * it is used in order calculate all roles that can play an element to another
	 * @param selectedObject 
	 * @param currentCreationMenu
	 * @return return the list of Ereference that can be calculated
	 */
	protected ArrayList<EStructuralFeature> getEreferences(EObject selectedObject, CreationMenu currentCreationMenu) {
		ArrayList<EStructuralFeature> possibleEFeatures = new ArrayList<EStructuralFeature>();
		EList<EStructuralFeature> featureList = selectedObject.eClass().getEAllStructuralFeatures();
		Iterator<EStructuralFeature> iterator = featureList.iterator();
		while(iterator.hasNext()) {
			EStructuralFeature eStructuralFeature = iterator.next();
			if(eStructuralFeature instanceof EReference) {
				EReference ref = (EReference)eStructuralFeature;
				if(ref.isContainment()) {
					IElementType menuType =  getElementType(currentCreationMenu.getElementTypeIdRef());
					if(menuType!=null && isSubClass(ref.getEType(), menuType.getEClass())) {
						possibleEFeatures.add(eStructuralFeature);
					}
				}
			}
		}
		return possibleEFeatures;
	}

	/**
	 * Test if a possibleSub eclass is a sub eclass
	 * 
	 * @param aclass
	 *        , cannot be null
	 * @param possibleSubClasse
	 *        , cannot be null
	 * @return true if possible eclass is a subtype of a eclass or false
	 */
	protected boolean isSubClass(EClassifier aclass, EClass possibleSubClasse) {
		if(aclass.equals(possibleSubClasse)) {
			return true;
		}
		EList<EClass> superTypeList = possibleSubClasse.getEAllSuperTypes();
		if(superTypeList.contains(aclass)) {
			return true;
		}
		return false;
	}


	/**
	 * associate the icon from the element type
	 * @param currentCreationMenu 
	 * @param item the current menu
	 */
	protected void createIconFromElementType(CreationMenu currentCreationMenu, MenuItem item) {
		if(getElementType(currentCreationMenu.getElementTypeIdRef()).getIconURL()!=null){
			ImageDescriptor imgDesc=ImageDescriptor.createFromURL(getElementType(currentCreationMenu.getElementTypeIdRef()).getIconURL());
			item.setImage(imgDesc.createImage());
		}
	}

	/**
	 * create a submenu 
	 * @param selectedObject the selected object
	 * @param topMenu the menu when will add menus
	 * @param currentCreationMenu
	 * @param reference the role of the new element
	 * @return true if the menu can be created
	 */
	protected boolean constructMenu(EObject selectedObject, Menu topMenu,  CreationMenu currentCreationMenu, EReference reference) {
		boolean oneDisplayedMenu=false;
		Command cmd=buildCommand(reference, selectedObject, currentCreationMenu.getElementTypeIdRef());
		if( cmd.canExecute()){
			oneDisplayedMenu=true;
			MenuItem item = new MenuItem(topMenu, SWT.NONE);
			fillIcon(currentCreationMenu, item);
			item.setEnabled(true);
			item.setText(currentCreationMenu.getLabel());
			item.addSelectionListener(new CreationMenuListener(cmd, editingDomain));
		}
		return oneDisplayedMenu;
	}

	/**
	 * get the IelementType from a string
	 * @param extendedType the string that represents the element type
	 * @return the element type or null
	 */
	protected IElementType getElementType(String extendedType){
		return  ElementTypeRegistry.getInstance().getType(extendedType);
	}
	/**
	 * Construct a command of creation
	 * @param reference the role of the element that will be created (maybe null)
	 * @param container the container of the created elements
	 * @param extendedType the extended type of the created element 
	 * @return a command that can be executed by the domain
	 */
	protected Command buildCommand(EReference reference, EObject container, String extendedType) {


		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(container);
		if(provider == null) {
			return UnexecutableCommand.INSTANCE;
		}

		ICommand createGMFCommand = provider.getEditCommand(buildRequest(reference, container, extendedType));
		if(createGMFCommand != null) {
			Command emfCommand = new org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper(createGMFCommand);
			return emfCommand;
		}
		return UnexecutableCommand.INSTANCE;
	}
	/**
	 * 
	 * @return
	 *         the creation request to use in this handler
	 */
	protected CreateElementRequest buildRequest(EReference reference, EObject container, String extendedType) {
		if(reference==null){
			return new CreateElementRequest(editingDomain, container,  getElementType(extendedType)) ;
		}
		return new CreateElementRequest(editingDomain, container,  getElementType(extendedType), reference);
	}
}

