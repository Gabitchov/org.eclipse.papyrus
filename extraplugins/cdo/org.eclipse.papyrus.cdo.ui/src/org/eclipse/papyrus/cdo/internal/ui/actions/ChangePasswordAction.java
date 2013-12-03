/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.actions;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.IWorkbenchPart;

/**
 * The "change password" action.
 */
public final class ChangePasswordAction extends AsyncAction<IInternalPapyrusRepository> {

	private static final String TITLE = Messages.ChangePasswordAction_0;

	private static final String TOOL_TIP = Messages.ChangePasswordAction_1;

	public ChangePasswordAction(IWorkbenchPart part) {
		super(IInternalPapyrusRepository.class, TITLE, (ImageDescriptor)null);

		setToolTipText(TOOL_TIP);
	}

	@Override
	protected void doRun(IInternalPapyrusRepository selection, IProgressMonitor monitor) throws CoreException {
		if(selection.isConnected()) {
			CDOSession session = selection.getCDOSession();
			if((session != null) && !session.isClosed()) {
				session.changeCredentials();
			}
		}
	}

	@Override
	protected boolean updateSelection(IStructuredSelection selection) {
		boolean result = super.updateSelection(selection);

		if(result) {
			result = getSelection().isConnected();
		}

		return result;
	}
}
