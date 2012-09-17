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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.resources.ResourceDropAdapterAssistant;

/**
 * Assistant to manage drag and drop of {@link IPapyrusFile}
 * {@link IPapyrusFile} are not adapted to {@link IResource} to prevent
 * misunderstanding so during transfer the selection is changed
 * 
 * @author tristan.faure@atosorigin.com
 * 
 */
public class PapyrusCommonDropAdapterAssistant extends
		ResourceDropAdapterAssistant {

	@Override
	public IStatus validateDrop(Object target, int aDropOperation,
			TransferData transferType) {
		manageSelection();
		return super.validateDrop(target, aDropOperation, transferType);
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {
		manageSelection();
		return super.handleDrop(aDropAdapter, aDropTargetEvent, aTarget);
	}

	@Override
	protected void doInit() {
		super.doInit();
		manageSelection();
	}

	private void manageSelection() {
		List<Object> elements = new ArrayList<Object>();
		ISelection selec = LocalSelectionTransfer.getTransfer().getSelection();
		if (selec instanceof IStructuredSelection) {
			IStructuredSelection struc = (IStructuredSelection) selec;
			for (Iterator<Object> i = struc.iterator(); i.hasNext();) {
				Object o = i.next();
				if (o instanceof IPapyrusFile) {
					IPapyrusFile papy = (IPapyrusFile) o;
					// TODO if a drop assistant is implemented use previous implementation :
					// elements.add(papy.getMainFile());
					elements.addAll(Arrays.asList(papy.getAssociatedResources()));
				}
			}
		}
		LocalSelectionTransfer.getTransfer().setSelection(
				new StructuredSelection(elements));
	}

}
