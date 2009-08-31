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
package org.eclipse.papyrus.profile.ui.dialogs;

import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * 
 */
public class PackageImportTreeSelectionDialog extends ElementImportTreeSelectionDialog {

	
	/**
	 * 
	 * 
	 * @param model 
	 * @param parent 
	 */
	public PackageImportTreeSelectionDialog(Shell parent, Package model){
		super(parent, model);
	}

	/*
	 * (non-Javadoc)
	 * @see com.cea.papyrus.ui.dialogs.ElementImportTreeSelectionDialog#buildImportTreeList(org.eclipse.swt.widgets.TreeItem, org.eclipse.uml2.uml.Package)
	 */
	/**
	 * 
	 * 
	 * @param _package 
	 * @param elemTree 
	 */
	protected void buildImportTreeList(TreeItem elemTree, Package _package){
		Iterator elemIter = _package.getPackagedElements().iterator();
		while(elemIter.hasNext()) {
			Element elem = (Element) elemIter.next();
			if(elem instanceof Package){
				TreeItem item = new TreeItem(elemTree, SWT.NONE);
				item.setText(((Package)elem).getName());
				item.setData(elem);
				item.setImage(IMG_PACKAGE);
				buildImportTreeList(item, (Package)elem);
			}
		}
	}
}
