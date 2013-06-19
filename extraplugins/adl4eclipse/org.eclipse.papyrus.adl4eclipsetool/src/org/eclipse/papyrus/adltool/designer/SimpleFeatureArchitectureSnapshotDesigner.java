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
 * Designer to construct the architecture of feature from the workspace.
 *
 */
public class SimpleFeatureArchitectureSnapshotDesigner extends CompleteFeatureArchitectureSnapshotDesigner {


	protected Package architecture;
	protected Package platform;
	protected Package architecturefeature;
	protected Package platformfeature;
	
	public SimpleFeatureArchitectureSnapshotDesigner(Package rootPackage, ArrayList<Object> bundleInitialList) {
		super(rootPackage, bundleInitialList);
	}

	
	
	@Override
	protected void initModel() {
		super.initModel();
		architecture=rootPackage.createNestedPackage("Architecture");
		platform=rootPackage.createNestedPackage("Platform");
		
	}
	
	@Override
	public void runImportBundles() {
		initModel();
		modelBundles(architecture);
	
	}
	
}
