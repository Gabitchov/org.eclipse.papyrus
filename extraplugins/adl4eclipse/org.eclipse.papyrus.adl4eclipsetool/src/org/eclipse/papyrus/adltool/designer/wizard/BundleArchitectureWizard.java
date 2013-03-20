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

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.papyrus.adltool.designer.ArchitectureSnapshotDesigner;



public class BundleArchitectureWizard extends Wizard {

	protected BundleSelectionPage bundleSelectionPage;
	protected boolean onlyWorkspace=true;

	public BundleArchitectureWizard(boolean onlyWorkspace) {
		super();
		setNeedsProgressMonitor(true);
		this.onlyWorkspace=onlyWorkspace;
	}

	@Override
	public void addPages() {
		ArrayList<Object> bundleList= new ArrayList<Object>();
		bundleList.addAll(ArchitectureSnapshotDesigner.getWorkspaceBundle());
		//do not look for loaded plugin in the case of a simple research 
		if(!onlyWorkspace){
			bundleList.addAll(ArchitectureSnapshotDesigner.getLoadedBundles());
		}
		bundleSelectionPage = new BundleSelectionPage(bundleList);
		addPage(bundleSelectionPage);
	}

	public ArrayList<Object> getSelectedBundle(){
		return bundleSelectionPage.getResult();
	}
	@Override
	public boolean performFinish() {
		if(bundleSelectionPage.getResult().size()>0){

			return true;
		}
		return false;
	}
} 
