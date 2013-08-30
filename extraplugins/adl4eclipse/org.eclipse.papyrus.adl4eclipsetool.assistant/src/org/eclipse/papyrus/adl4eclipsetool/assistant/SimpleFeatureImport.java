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
package org.eclipse.papyrus.adl4eclipsetool.assistant;

import java.util.ArrayList;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.adltool.command.SimpleFeaturesArchitectureSnapshotCommand;
import org.eclipse.papyrus.adltool.designer.ArchitectureSnapshotDesigner;
import org.eclipse.papyrus.adltool.designer.wizard.BundleSelectionPage;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * this class is used to do the retro engineering from workspace plug-in. It adds only in the platform dependencies.
 *
 */
public class SimpleFeatureImport extends SimplePluginImport{
	@Override
	public void addPages() {
		//look for all plug-ins from the workspace
		ArrayList<Object> bundleList= new ArrayList<Object>();
		bundleList.addAll(ArchitectureSnapshotDesigner.getWorkspaceFeature());
		bundleSelectionPage = new BundleSelectionPage(bundleList);
		addPage(bundleSelectionPage);
	}
	
	
	@Override
	public boolean performFinish() {
		
		// one bundle must be selected
		if(getSelectedBundle().size()>0){
			// get the domain in order to launch the command
			TransactionalEditingDomain dom = modelSet.getTransactionalEditingDomain();
			ArrayList<Element> selection=getSelectionSet();
			
			if( (selection.size()==1) &&(selection.get(0)instanceof Package)){
				//launch the simple retro engineering
				SimpleFeaturesArchitectureSnapshotCommand comd= new SimpleFeaturesArchitectureSnapshotCommand(dom, (Package)selection.get(0), getSelectedBundle());
				dom.getCommandStack().execute(comd);
			}
			return true;
		}
		return false;
	}

}
