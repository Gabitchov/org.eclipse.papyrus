/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Chokri Mraidha (CEA LIST) Chokri.Mraidha@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) Patrick.Tessier@cea.fr - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.ui.dialogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.papyrus.uml.profile.ImageManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;



/**
 * this is a dialog to select an element import
 * 
 */
//FIXME: This dialog should be moved to another plug-in
public class ElementImportTreeSelectionDialog extends Dialog {

	/**
	 * 
	 */
	protected Package model;

	protected List<Package> models;

	protected boolean subSelection = false;

	/**
	 * 
	 */
	protected ArrayList<Element> elementsToImport = new ArrayList<Element>();

	/**
	 * 
	 */
	protected Tree elementTree;

	/**
	 * 
	 */
	protected static final Image IMG_PACKAGE = ImageManager.IMG_PACKAGE;

	/**
	 * 
	 */
	protected static final Image IMG_CLASS = ImageManager.IMG_CLASS;

	/**
	 * 
	 */
	protected static final Image IMG_DATATYPE = ImageManager.IMG_DATATYPE;

	/**
	 * 
	 */
	protected static final Image IMG_ENUM = ImageManager.IMG_ENUMERATION;

	/**
	 * 
	 */
	protected static final Image IMG_PRIMITIVE = ImageManager.IMG_PRIMITIVETYPE;

	protected static final Image IMG_PROFILE = ImageManager.IMG_PROFILE;

	/**
	 * 
	 */
	protected static final Image IMG_ASSOCIATION = ImageManager.IMG_ASSOCIATION;

	/**
	 * 
	 */
	protected static final Image IMG_INSTANCESPEC = ImageManager.IMG_INSTANCESPEC;


	/**
	 * @param parent
	 *        the parent shell
	 * @param model
	 *        the UML model of profile or import library
	 * @param subselection
	 *        true, if the selection of an element automatically selects all sub-elements
	 */
	public ElementImportTreeSelectionDialog(Shell parent, Package model) {
		super(parent);
		this.model = model;
		this.models = null;
	}

	/**
	 * 
	 * 
	 * @param model
	 * @param parent
	 */
	public ElementImportTreeSelectionDialog(Shell parent, List<Package> models) {
		super(parent);
		this.model = null;
		this.models = models;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.dialogs.Dialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * 
	 * 
	 * @param parent
	 * 
	 * @return
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite comp = (Composite)super.createDialogArea(parent);
		elementTree = new Tree(comp, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL);
		GridData treeData = new GridData(SWT.FILL, SWT.FILL, true, true);
		treeData.widthHint = 300;
		treeData.heightHint = 300;
		elementTree.setLayoutData(treeData);

		if(model != null) {
			createTreeItem(model);

		} else if(models != null) {
			Iterator<Package> it = models.iterator();
			while(it.hasNext()) {
				Package current = it.next();
				createTreeItem(current);
			}
		}

		elementTree.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK) {
					if(elementsToImport.contains(event.item.getData())) {
						elementsToImport.remove(event.item.getData());
						if(subSelection) {
							remChildSelection((TreeItem)event.item);
						}

					} else {
						elementsToImport.add((Element)event.item.getData());
						if(subSelection) {
							addChildSelection((TreeItem)event.item);
						}
					}
				}
			}
		});

		getShell().setText("Select the elements to import");

		return comp;
	}

	/**
	 * Recursive call that Check item childrens in the tree
	 * 
	 * @param item
	 */
	protected void addChildSelection(TreeItem item) {

		TreeItem[] items = item.getItems();
		if((items != null) && (items.length > 0)) {
			for(int i = 0; i < items.length; i++) {

				items[i].setChecked(true);
				addChildSelection(items[i]);
				elementsToImport.add((Element)items[i].getData());
			}
		}
	}

	/**
	 * Recursive call that unCheck item childrens in the tree
	 * 
	 * @param item
	 */
	protected void remChildSelection(TreeItem item) {

		TreeItem[] items = item.getItems();
		if((items != null) && (items.length > 0)) {
			for(int i = 0; i < items.length; i++) {

				items[i].setChecked(false);
				remChildSelection(items[i]);
				// bug fix when list is already initialized, it can have several instance of the same element
				while(elementsToImport.contains(items[i].getData())) {
					elementsToImport.remove(items[i].getData());
				}
			}
		}
	}

	/**
	 * 
	 * @param _package
	 */
	private void createTreeItem(Package _package) {
		TreeItem item = new TreeItem(elementTree, SWT.NONE);
		item.setText(_package.getName());
		item.setData(_package);
		if(_package instanceof Profile) {
			item.setImage(IMG_PROFILE);
		} else {
			item.setImage(IMG_PACKAGE);
		}
		buildImportTreeList(item, _package);
	}

	/**
	 * Returns the elements to import.
	 * 
	 * @return
	 */
	public ArrayList getResult() {
		return elementsToImport;
	}

	/**
	 * This method builds the element tree widget containing all packageable elements of a given package.
	 * 
	 * @param _package
	 *        the package to explore
	 * @param elemTree
	 *        tree parent of packageable elements
	 */
	protected void buildImportTreeList(TreeItem elemTree, Package _package) {
		Iterator<PackageableElement> elemIter = _package.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = elemIter.next();
			if(elem instanceof Package) {
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((Package)elem).getName());
				item.setData(elem);
				if(elem instanceof Profile) {
					item.setImage(IMG_PROFILE);
				}
				item.setImage(IMG_PACKAGE);
				buildImportTreeList(item, (Package)elem);
			} else if(elem instanceof NamedElement) {
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((NamedElement)elem).getName());
				item.setData(elem);

				/* icon setting */
				if(elem instanceof Association) {
					item.setImage(IMG_ASSOCIATION);
				} else if(elem instanceof Enumeration) {
					item.setImage(IMG_ENUM);
				} else if(elem instanceof PrimitiveType) {
					item.setImage(IMG_PRIMITIVE);
				} else if(elem instanceof DataType) {
					item.setImage(IMG_DATATYPE);
				} else if(elem instanceof org.eclipse.uml2.uml.Class) {
					item.setImage(IMG_CLASS);
				} else if(elem instanceof InstanceSpecification) {
					item.setImage(IMG_INSTANCESPEC);
				}
			}
		}
	}

}
