/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorManager;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.BaseSelectionListenerAction;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the AddRepositoryAction type. Enjoy.
 */
public class OpenPapyrusModelAction
		extends BaseSelectionListenerAction {

	private final IWorkbenchPart part;

	public OpenPapyrusModelAction(IWorkbenchPart part) {
		super(Messages.OpenPapyrusModelAction_0);

		this.part = part;
	}

	@Override
	public void run() {
		IStructuredSelection sel = getStructuredSelection();

		if ((sel != null) && !sel.isEmpty()) {
			CDOResource res = getResource(sel.getFirstElement());

			if (res != null) {
				try {
					URI uri = res.getURI();
					String name = uri.trimFileExtension().lastSegment();

					PapyrusCDOEditorManager.INSTANCE.openEditor(part.getSite()
						.getPage(), uri, name);
				} catch (PartInitException e) {
					StatusManager.getManager().handle(e.getStatus(),
						StatusManager.SHOW);
				}
			}
		}
	}

	private CDOResource getResource(Object object) {
		CDOResource result = null;

		if (object instanceof CDOResource) {
			result = (CDOResource) object;
		} else if (object instanceof IAdaptable) {
			result = (CDOResource) ((IAdaptable) object)
				.getAdapter(CDOResource.class);
		}

		return result;
	}
}
