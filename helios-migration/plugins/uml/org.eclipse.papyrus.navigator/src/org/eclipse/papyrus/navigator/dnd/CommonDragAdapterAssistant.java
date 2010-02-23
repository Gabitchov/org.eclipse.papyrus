/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.dnd;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;
import org.eclipse.uml2.uml.PackageableElement;

/**
 * This class handle Drag events in ModelExplorer view.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CommonDragAdapterAssistant extends org.eclipse.ui.navigator.CommonDragAdapterAssistant {

	public CommonDragAdapterAssistant() {
	}

	@Override
	public Transfer[] getSupportedTransferTypes() {
		Transfer[] transfer = new Transfer[]{ LocalSelectionTransfer.getInstance() };
		return transfer;
	}

	@Override
	public boolean setDragData(DragSourceEvent anEvent, IStructuredSelection selection) {
		Object o = selection.getFirstElement();
		if(o instanceof PackageableElement) {
			anEvent.data = o;
			return true;
		}
		return false;
	}

}
