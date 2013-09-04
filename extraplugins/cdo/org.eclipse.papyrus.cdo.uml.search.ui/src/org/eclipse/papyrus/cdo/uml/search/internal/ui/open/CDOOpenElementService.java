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
package org.eclipse.papyrus.cdo.uml.search.internal.ui.open;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorInput;
import org.eclipse.papyrus.cdo.internal.ui.editors.PapyrusCDOEditorManager;
import org.eclipse.papyrus.infra.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.infra.core.editor.IPapyrusPageInput;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.openelement.service.impl.OpenElementServiceImpl;
import org.eclipse.papyrus.views.search.scope.ScopeEntry;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;


/**
 * A CDO-aware specialization of the <em>Open Element Service</em> attached to the {@link ModelSet} in CDO search-result {@linkplain ScopeEntry scope
 * entries}.
 */
public class CDOOpenElementService extends OpenElementServiceImpl {

	public CDOOpenElementService() {
		super();
	}

	@Override
	protected IPapyrusPageInput createPapyrusPageInput(URI diResourceURI, URI[] pageURIs) {
		return new PapyrusCDOEditorInput.PageInput(diResourceURI, pageURIs, false);
	}

	@Override
	protected IMultiDiagramEditor openEditor(IWorkbenchPage workbenchPage, IEditorInput input) throws PartInitException {
		return (IMultiDiagramEditor)PapyrusCDOEditorManager.INSTANCE.openEditor(workbenchPage, input);
	}
}
