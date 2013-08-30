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
 * import the list of plugins from all loading plugins 
 *
 */
  public class CompleteArchitectureSnapshotDesigner extends ArchitectureSnapshotDesigner {
 

	/**
	 * 
	 * Constructor.
	 *
	 * @param rootPackage
	 * @param bundleInitialList
	 */
	public CompleteArchitectureSnapshotDesigner(Package rootPackage, ArrayList<Object>bundleInitialList) {
		super(rootPackage, bundleInitialList);
	}
	@Override
	protected void initModel() {
		super.initModel();
	}
	
	@Override
	public void runImportBundles() {
		initModel();
		modelBundles(rootPackage);
	}
}
