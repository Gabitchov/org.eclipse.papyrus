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
package org.eclipse.papyrus.cdo.internal.core.importer;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.importer.IModelImportMapping;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferConfiguration;
import org.eclipse.papyrus.cdo.core.importer.IModelTransferNode;
import org.eclipse.papyrus.cdo.internal.core.Activator;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.l10n.Messages;

/**
 * This is the AbstractModelImportMapping type. Enjoy.
 */
abstract class AbstractModelImportMapping extends AbstractModelTransferMapping implements IModelImportMapping {

	public AbstractModelImportMapping(IModelTransferConfiguration config) {
		super(config);
	}

	@Override
	protected boolean validateMapping(IModelTransferNode node, DiagnosticChain diagnostics) {
		boolean result = true;

		IPath mapping = getMapping(node);
		if(mapping == null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.AbstractModelImportMapping_0, node.getName()), new Object[]{ node }));
			result = false;
		} else {
			for(URI next : node.getResourceURIs()) {
				String resourcePath = mapping.removeFileExtension().addFileExtension(next.fileExtension()).toString();

				if(getView().hasResource(resourcePath)) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, Activator.PLUGIN_ID, 0, NLS.bind(Messages.AbstractModelImportMapping_1, mapping, node.getName()), new Object[]{ node }));
					result = false;
					break;
				}
			}
		}

		return result;
	}

	protected CDOView getView() {
		IInternalPapyrusRepository repo = (IInternalPapyrusRepository)getRepository();

		return (repo == null) ? null : repo.getMasterView();
	}

	@Override
	protected void computeDefaultMappings(IModelTransferConfiguration configuration) {
		for(IModelTransferNode next : configuration.getModelsToTransfer()) {
			if(getMapping(next) == null) {
				mapTo(next, new Path(next.getName()));
			}
		}
	}
}
