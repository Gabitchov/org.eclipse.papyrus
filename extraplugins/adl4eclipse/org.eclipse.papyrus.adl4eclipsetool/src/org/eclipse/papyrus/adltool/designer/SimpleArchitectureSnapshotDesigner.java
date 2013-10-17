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
package org.eclipse.papyrus.adltool.designer;

import java.util.ArrayList;

import org.eclipse.uml2.uml.Package;


/**
 * this architecture designer is used to construct the structure from workspace  
 *
 */
public class SimpleArchitectureSnapshotDesigner extends ArchitectureSnapshotDesigner {

	
	/**
	 * 
	 * Constructor.
	 *
	 * @param rootPackage the root package where the sub-packages "Architecture" and "platform" will be created
	 * @param bundleInitialList the list of bundle that will be retro engineered.
	 */
	public SimpleArchitectureSnapshotDesigner(Package rootPackage, ArrayList<Object>bundleInitialList) {
		super(rootPackage, bundleInitialList);
		// the simple user cannot choose the level of dependency it has only the level 1
		dependencyLevelMax=1;
	}
	
	@Override
	public void runImportBundles() {
		initModel();
		modelBundles(rootPackage);
	
	}
		
}
