/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.emf.compare.utils.CompareEditorConfiguration;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

//import AbstractHandler;


public abstract class AbstractEMFCompareHandler extends AbstractHandler {

	@Override
	public boolean isEnabled() {
		return getEditingDomain() != null;
	}

	protected IEditorPart getCurrentEditor() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
	}

	//	protected Viewer getCurrentMergeViewer(){
	//		IEditorPart currentEditor = getCurrentEditor();
	//		if(currentEditor!=null && currentEditor instanceof CompareEditor){
	//			Viewer viewer = ViewerUIInformation.INSTANCE.getMergeViewer(getCurrentEditor());
	//			return viewer;
	//		}
	//		return null;
	//	}

	protected TransactionalEditingDomain getEditingDomain() {
		final CompareEditorConfiguration config = org.eclipse.papyrus.infra.emf.compare.Activator.getDefault().getConfigurationFor(getCurrentEditor());
		if(config != null) {
			return config.getEditingDomain();
		}
		return null;
	}

}
