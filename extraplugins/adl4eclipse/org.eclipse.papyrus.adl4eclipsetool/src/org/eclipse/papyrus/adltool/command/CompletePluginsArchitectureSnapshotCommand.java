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
package org.eclipse.papyrus.adltool.command;

import java.util.ArrayList;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.adltool.designer.CompleteArchitectureSnapshotDesigner;
import org.eclipse.uml2.uml.Package;


/**
 * this purpose of this comment is to import all the architecture from the currentworkspace
 *
 */
public class CompletePluginsArchitectureSnapshotCommand extends RecordingCommand {
	protected ArrayList<Object> bundleList=null;
	protected Package rootPackage;

	public CompletePluginsArchitectureSnapshotCommand(TransactionalEditingDomain domain,Package rootPackage, ArrayList<Object> bundleList) {
		super(domain,"Import Bundles", "Model architecture from current workspace");
		this.rootPackage=rootPackage;
		this.bundleList=bundleList;
	}


	
	@Override
	protected void doExecute() {
		CompleteArchitectureSnapshotDesigner snapshotDesigner= new CompleteArchitectureSnapshotDesigner(rootPackage, bundleList);
		snapshotDesigner.runImportBundles();
	}
}
