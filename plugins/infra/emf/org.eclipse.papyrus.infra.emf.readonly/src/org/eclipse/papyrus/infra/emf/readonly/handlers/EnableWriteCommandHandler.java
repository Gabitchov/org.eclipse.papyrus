/*****************************************************************************
 * Copyright (c) 2011 Atos Origin
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.readonly.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.readonly.ReadOnlyManager;
import org.eclipse.papyrus.infra.emf.utils.BusinessModelResolver;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.papyrus.infra.onefile.model.PapyrusModelHelper;
import org.eclipse.papyrus.infra.onefile.utils.OneFileUtils;
import org.eclipse.ui.PlatformUI;

public class EnableWriteCommandHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		EObject elem = getSelectedElement();
		if(elem != null && elem.eResource() != null && elem.eResource().getResourceSet() != null) {
			Resource res = elem.eResource();
			ResourceSet rs = res.getResourceSet();

			if(res.getURI() != null && res.getURI().isPlatformResource()) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(res.getURI().toPlatformString(true)));
				IPapyrusFile papFile = PapyrusModelHelper.getPapyrusModelFactory().createIPapyrusFile(file);
				IFile[] associatedFiles = OneFileUtils.getAssociatedFiles(papFile);

				URI[] associatedUris = new URI[associatedFiles.length];
				for (int i=0 ; i < associatedFiles.length ; i++) {
					associatedUris[i] = URI.createPlatformResourceURI(associatedFiles[i].getFullPath().toString(), true);
				}

				ReadOnlyManager.getReadOnlyHandler(WorkspaceEditingDomainFactory.INSTANCE.getEditingDomain(rs))
				.makeWritable(associatedUris);
			}
		}
		return null;
	}

	protected EObject getSelectedElement() {
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(selection instanceof IStructuredSelection) {
			Object obj = ((IStructuredSelection)selection).getFirstElement();
			return resolveSemanticObject(obj);
		}
		return null;
	}

	/**
	 * Resolve semantic element
	 * 
	 * @param object
	 *        the object to resolve
	 * @return <code>null</code> or the semantic element associated to the
	 *         specified object
	 */
	protected EObject resolveSemanticObject(Object object) {
		Object businessObject = BusinessModelResolver.getInstance().getBusinessModel(object);
		if(businessObject instanceof EObject) {
			return (EObject)businessObject;
		}
		return null;
	}
}
