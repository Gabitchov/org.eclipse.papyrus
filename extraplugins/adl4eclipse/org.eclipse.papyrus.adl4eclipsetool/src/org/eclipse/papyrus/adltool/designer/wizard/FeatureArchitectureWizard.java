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

import org.eclipse.papyrus.adltool.designer.ArchitectureSnapshotDesigner;

/**
 * this wizard is used to display feature from workspace and the platform
 *@deprecated
 */
public class FeatureArchitectureWizard extends PluginArchitectureWizard {

	/**
	 * 
	 * Constructor.
	 *
	 * @param onlyWorkspace
	 */
	public FeatureArchitectureWizard(boolean onlyWorkspace) {
		super(onlyWorkspace);
	}

	@Override
	public void addPages() {
		ArrayList<Object> bundleList= new ArrayList<Object>();
		if(onlyWorkspace){
			bundleList.addAll(ArchitectureSnapshotDesigner.getWorkspaceFeature());
		}
		else{
			bundleList.addAll(ArchitectureSnapshotDesigner.getFeature());
		}
		bundleSelectionPage = new BundleSelectionPage(bundleList);
		addPage(bundleSelectionPage);
	}

}
