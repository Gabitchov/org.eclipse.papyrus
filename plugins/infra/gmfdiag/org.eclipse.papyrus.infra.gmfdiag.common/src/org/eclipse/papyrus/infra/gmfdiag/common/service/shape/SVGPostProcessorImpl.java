/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.service.shape;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.w3c.dom.svg.SVGDocument;

/**
 * Aggregation of all SVGPostProcessors declared via the {@link #EXTENSION_POINT} extension point
 * 
 * @author Camille Letavernier
 * 
 */
public class SVGPostProcessorImpl implements SVGPostProcessor {

	protected final List<SVGPostProcessor> processors;

	public SVGPostProcessorImpl() {
		processors = new LinkedList<SVGPostProcessor>();
		loadPostProcessors();
	}

	protected void loadPostProcessors() {

		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(EXTENSION_POINT);

		for(IConfigurationElement e : config) {
			try {
				Object postProcessorObject = e.createExecutableExtension(EXTENSION_CLASS_NAME_ATTRIBUTE);

				if(!(postProcessorObject instanceof SVGPostProcessor)) {
					Activator.log.warn(String.format("Plug-in %s contributed an invalid SVG post-processor: %s", e.getContributor(), e.getAttribute(EXTENSION_CLASS_NAME_ATTRIBUTE))); //$NON-NLS-1$
					continue;
				}

				processors.add((SVGPostProcessor)postProcessorObject);
			} catch (Throwable t) {
				Activator.log.error(String.format("Plug-in %s contributed an invalid SVG post-processor", e.getContributor()), t);
				continue;
			}
		}
	}

	@Override
	public void postProcess(EObject view, SVGDocument document) {
		for(SVGPostProcessor processor : processors) {
			processor.postProcess(view, document);
		}
	}

}
