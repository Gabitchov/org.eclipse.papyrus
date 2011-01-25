/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.generation.generators;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.generation.Activator;

@Deprecated
public abstract class QVTGenerator implements IGenerator {

	private URI transformationURI;

	protected QVTGenerator(URI transformationURI) {
		this.transformationURI = transformationURI;
	}

	public Context generate(URI targetURI) {
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		EObject source;

		try {
			source = loadEMFModel(targetURI);
		} catch (IOException ex) {
			Activator.log.error(ex);
			return null;
		}

		ModelExtent inputModel = getModelExtent(source);
		ModelExtent outputContext = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();

		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$

		ExecutionDiagnostic result = executor.execute(context, inputModel, outputContext);

		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> outObjects = outputContext.getContents();
			Object objectResult = outObjects.get(0);
			if(!(objectResult instanceof Context)) {
				return null;
			}
			return (Context)objectResult;
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
		}
		return null;
	}



	private EObject loadEMFModel(URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		try {
			Resource resource = resourceSet.getResource(uri, true);
			if(resource != null) {
				if(!resource.getContents().isEmpty()) {
					return resource.getContents().get(0);
				}
			}
		} catch (Exception ex) {
			throw new IOException(ex.toString());
		}

		return null;
	}

	private ModelExtent getModelExtent(EObject source) {
		EList<EObject> objects = new BasicEList<EObject>();
		objects.add(source);
		ModelExtent extent = new BasicModelExtent(objects);
		return extent;
	}
}
