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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public abstract class AbstractQVTGenerator implements IGenerator, Listener {

	protected Context generatedContext;

	protected EPackage sourcePackage;

	protected ModelExtent out;

	private Set<Listener> listeners = new HashSet<Listener>();

	public Context generate(URI targetURI) {

		URI transformationURI = getTransformationURI();
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		List<ModelExtent> extents = getModelExtents();

		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		//context.setLog(new WriterLog(new OutputStreamWriter(System.out)));

		ExecutionDiagnostic result = executor.execute(context, extents.toArray(new ModelExtent[0]));

		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> outObjects = getOutContextExtent().getContents();
			Object objectResult = outObjects.get(0);
			if(!(objectResult instanceof Context)) {
				return null;
			}

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource contextResource = resourceSet.createResource(targetURI);
			contextResource.getContents().addAll(outObjects);

			return generatedContext = (Context)outObjects.get(0);
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
		}
		return generatedContext = null;
	}

	abstract protected List<ModelExtent> getModelExtents();

	protected ModelExtent getOutContextExtent() {
		if(out == null) {
			out = new BasicModelExtent();
		}

		return out;
	}

	abstract protected URI getTransformationURI();

	protected EObject loadEMFModel(URI uri) throws IOException {
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

	public void addListener(Listener listener) {
		listeners.add(listener);
	}

	public void handleEvent(Event event) {
		for(Listener listener : listeners) {
			listener.handleEvent(event);
		}
	}
}
