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
package org.eclipse.papyrus.cdo.internal.core.exporter;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.exporter.IModelExportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.importer.AbstractModelTransferMapping;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;

/**
 * This is the AbstractModelImportMapping type. Enjoy.
 */
public class ModelExportMapping extends AbstractModelTransferMapping implements IModelExportMapping {

	private final IWorkspaceRoot wsRoot = ResourcesPlugin.getWorkspace().getRoot();

	public ModelExportMapping(IModelTransferConfiguration config) {
		super(config);
	}

	@Override
	protected boolean validateMapping(IModelTransferNode node, DiagnosticChain diagnostics) {
		boolean result = true;

		IPath mapping = getMapping(node);
		if(mapping == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelExportMapping_0, node.getName()), new Object[]{ node }));
			result = false;
		} else {
			for(URI next : node.getResourceURIs()) {
				IPath resourcePath = mapping.removeFileExtension().addFileExtension(next.fileExtension());
				IPath containerPath = mapping.removeLastSegments(1);

				IContainer container = (containerPath.segmentCount() == 1) ? wsRoot.getProject(containerPath.segment(0)) : wsRoot.getFolder(containerPath);
				if(!container.getProject().exists()) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelExportMapping_1, mapping, node.getName()), new Object[]{ node }));
					result = false;
					break;
				} else if(!container.exists()) {
					// does it not exist because there is a file of that name?
					IFile file = wsRoot.getFile(containerPath);
					if(file.exists()) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelExportMapping_2, containerPath, node.getName()), new Object[]{ node }));
						result = false;
						break;
					}
				} else {
					// the container exists.  Does the mapped file clash?
					IFile file = wsRoot.getFile(resourcePath);
					if(file.exists()) {
						diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.ModelExportMapping_3, resourcePath, node.getName()), new Object[]{ node }));
						result = false;
						break;
					} else {
						// final check is whether the workspace will allow creation of this resource
						IStatus status = wsRoot.getWorkspace().validatePath(resourcePath.toString(), IResource.FILE);
						if(!status.isOK()) {
							diagnostics.add(BasicDiagnostic.toDiagnostic(status));
							if(status.getSeverity() > IStatus.WARNING) {
								result = false;
								break;
							}
						}
					}
				}
			}
		}

		return result;
	}
}
