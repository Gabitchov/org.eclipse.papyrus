/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.compare.common.internal.utils;

import static org.eclipse.papyrus.infra.core.Activator.log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ExtensionServicesRegistry;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.emf.compare.common.Activator;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * 
 * This class provides useful methods to load Papyrus model
 * TODO : replace it using ModelSet
 */
public class PapyrusFileLoader {

	private PapyrusFileLoader() {
		//to prevent instanciation
	}

	/**
	 * This methods takes as parameters a list of uml files. It load them with the di and the notation file which have the same name
	 * 
	 * @param set
	 *        a resourceSet
	 * @param files
	 *        a list of files to load
	 * @param trackingModification
	 * @return
	 *         the root of the uml model
	 *         //TODO add test to avoid stereotypes applications
	 *         //TODO : replace it using ModelSet ?
	 */
	public static EObject[] loadPapyrusFiles(final ResourceSet set, final List<IFile> files, final boolean trackingModification) {
		List<Class<?>> servicesToStart = new ArrayList<Class<?>>(1);
		servicesToStart.add(ModelSet.class);

		final EObject[] roots = new EObject[files.size()];

		for(int i = 0; i < files.size(); i++) {
			String filePath = files.get(i).getFullPath().toString();
			URI uri = URI.createFileURI(filePath); //$NON-NLS-1$ //$NON-NLS-2$
			try {
				roots[i] = EMFHelper.loadEMFModel(set, uri);
				Assert.isNotNull(roots[i]);
			} catch (IOException e) {
				Activator.log.error(NLS.bind("I can't load the model {0}", uri), e);
			};

			//we load the notation file
			int index = filePath.lastIndexOf("."); //$NON-NLS-1$
			String subString = filePath.substring(0, index);

			//we load the .di
			uri = URI.createFileURI(subString + ".di"); //$NON-NLS-1$
			Map<?, ?> options = null;
			if(set.getURIConverter().exists(uri, options)) {
				try {
					set.getResource(uri, true).load(options);
				} catch (IOException e) {
					Activator.log.error(NLS.bind("I can't load the model {0}", uri), e);
				}
			}

			//we load the .notation
			uri = URI.createFileURI(subString + ".notation"); //$NON-NLS-1$
			if(set.getURIConverter().exists(uri, options)) {
				try {
					set.getResource(uri, true).load(options);
				} catch (IOException e) {
					Activator.log.error(NLS.bind("I can't load the model {0}", uri), e);
				}
			}

			//TODO : and if there is other referenced files?

		}

		for(Resource res : set.getResources()) {
			res.setTrackingModification(trackingModification);
		}

		return roots;
	}

	/**
	 * Create the ServicesRegistry.
	 * 
	 * @return
	 */
	private static ServicesRegistry createServicesRegistry() {
		// Create Services Registry
		try {
			ServicesRegistry servicesRegistry = new ExtensionServicesRegistry(Activator.PLUGIN_ID);
			//			servicesRegistry.startRegistry();
			return servicesRegistry;
		} catch (ServiceException e) {
			// Show log and error
			log.error(e.getMessage(), e);
		}
		return null;
	}
}
