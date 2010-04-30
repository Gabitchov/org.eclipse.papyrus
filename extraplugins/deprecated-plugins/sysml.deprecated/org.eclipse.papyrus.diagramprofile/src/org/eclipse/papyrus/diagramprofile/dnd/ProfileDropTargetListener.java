/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin) tristan.faure@atosorigin.com - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagramprofile.dnd;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.papyrus.diagram.common.listeners.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

public class ProfileDropTargetListener extends DropTargetListener {

	private final TransactionalEditingDomain domain;

	public ProfileDropTargetListener(EditPartViewer viewer, Transfer xfer, TransactionalEditingDomain domain) {
		super(viewer, xfer);
		this.domain = domain;
	}

	@Override
	protected Object getJavaObject(TransferData data) {
		return LocalSelectionTransfer.getTransfer().nativeToJava(data);
	}

	@Override
	protected TransactionalEditingDomain getTransactionalEditingDomain() {
		return domain;
	}

}
