/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.model.adapters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

/**
 * Link the Papyrus Editor with {@link IPapyrusFile}
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class PapyrusLinkHelper implements ILinkHelper {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#findSelection(org.eclipse.ui.
	 * IEditorInput)
	 */
	public IStructuredSelection findSelection(IEditorInput anInput) {
		List<Object> select = new ArrayList<Object>();
		if(anInput instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput)anInput;
			IPapyrusFile papy = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(input.getFile());
			select.add(papy);
			IResource res = papy.getMainFile();
			while(res.getParent() != null) {
				select.add(0, res.getParent());
				res = res.getParent();
			}
			return new StructuredSelection(papy);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#activateEditor(org.eclipse.ui.
	 * IWorkbenchPage, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	public void activateEditor(IWorkbenchPage page, IStructuredSelection selection) {
		if(selection == null || selection.isEmpty())
			return;
		Object element = selection.getFirstElement();
		IEditorPart part = OneFileUtils.isOpenInEditor(element);
		if(part != null) {
			page.bringToTop(part);
		}

	}
}
