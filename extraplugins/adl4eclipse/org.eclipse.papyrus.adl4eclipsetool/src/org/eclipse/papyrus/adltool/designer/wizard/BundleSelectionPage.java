
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
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.adltool.designer.wizard;

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.adltool.designer.bundle.BundleLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


public class BundleSelectionPage extends WizardPage {
	/**
	 * the graphical tree 
	 */
	protected Tree elementTree;
	protected ArrayList<?> bundleList;
	protected ArrayList<Object> selectedBundleList;
	protected BundleLabelProvider bundleLabelProvider= new BundleLabelProvider();

	private Composite comp;

	public BundleSelectionPage(ArrayList<?> bundleList) {
		super("BundleSelection");
		setTitle("Bundle Selection");
		setDescription("Select bundles to create the architecture model.");
		this.bundleList=bundleList;
		this.selectedBundleList= new ArrayList<Object>();
	}

	public void createControl(Composite parent) {
		comp = new Composite(parent, SWT.NULL);
		FillLayout layout = new FillLayout();
		comp.setLayout(layout);
		elementTree = new Tree(comp, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL);

		if(bundleList != null) {

			Iterator<?> it = bundleList.iterator();
			while(it.hasNext()) {
				Object current = it.next();
				createTreeItem(current);
			}
		}

		elementTree.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event event) {
				if(event.detail == SWT.CHECK) {
					if(selectedBundleList.contains(event.item.getData())) {
						selectedBundleList.remove(event.item.getData());

					} else {
						selectedBundleList.add(event.item.getData());
					}
					if(selectedBundleList.size()>0){
						setPageComplete(true);
					}
					else{
						setPageComplete(false);
					}
				}
			}
		});
		comp.pack();
		setControl(comp);
		setPageComplete(false);


	}


	/**
	 * create an item that represent the bundle
	 * @param _package
	 */
	private void createTreeItem(Object bundle) {
		TreeItem item = new TreeItem(elementTree, SWT.NONE);
		item.setText(bundleLabelProvider.getText(bundle));
		item.setImage(bundleLabelProvider.getImage(bundle));
		item.setData(bundle);
	}

	/**
	 * Returns the elements to import.
	 * 
	 * @return
	 */
	public ArrayList<Object> getResult() {
		return selectedBundleList;
	}

} 
