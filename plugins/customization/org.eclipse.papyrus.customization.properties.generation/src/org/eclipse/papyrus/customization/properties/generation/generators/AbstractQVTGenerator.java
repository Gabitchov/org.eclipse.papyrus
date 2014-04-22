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
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Strategy improvement of generated files
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.generation.generators;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
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
import org.eclipse.m2m.qvt.oml.util.WriterLog;
import org.eclipse.papyrus.customization.properties.generation.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * An Abstract generator based on QVTO transformations.
 * Subclasses should specify the .qvto file and ModelExtents, as well as the
 * SWT widgets allowing the user to chose the input models.
 *
 * @author Camille Letavernier
 */
public abstract class AbstractQVTGenerator implements IGenerator, Listener {

	/**
	 * The Contexts created by the transformation.
	 */
	protected List<Context> generatedContexts;

	/**
	 * The output ModelExtent
	 */
	protected ModelExtent out;

	private Set<Listener> listeners = new HashSet<Listener>();

	private int strategy;

	public List<Context> generate(List<URI> targetURI) {

		switch(strategy) {
		case 0:
			generatedContexts = generateSameFile(targetURI);
			break;
		case 1:
			generatedContexts = generateSameFile(targetURI);
			break;
		case 2:
			generatedContexts = generateDifferentFile(targetURI);
			break;
		default:
			generatedContexts = null;
		}
		return generatedContexts;
	}





	/**
	 * @return the list of in/out/inout ModelExtents (including the OutContextExtent)
	 *         Implementors should ensure they add the outContextExtent to the list.
	 */
	abstract protected List<ModelExtent> getModelExtents();

	/**
	 * @return the ModelExtent containing the generated context
	 */
	protected ModelExtent getOutContextExtent() {
		if(out == null) {
			out = new BasicModelExtent();
		}

		return out;
	}

	/**
	 * @return the URI of the QVTO transformation file.
	 */
	abstract protected URI getTransformationURI();

	/**
	 * Loads the EObject from the given URI.
	 *
	 * @param uri
	 *        The URI from which the EObject is loaded
	 * @return
	 *         The loaded EObject, or null if an error occured
	 * @throws IOException
	 *         If the URI isn't a valid EObject
	 */
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

	public void removeListener(Listener listener) {
		listeners.remove(listener);
	}

	public void handleEvent(Event event) {
		for(Listener listener : listeners) {
			listener.handleEvent(event);
		}
	}

	/**
	 * Return the generated Context from a list of EObjects
	 *
	 * @param outObjects
	 *        The list of EObjects from which the context will be retrieved
	 * @return
	 *         The main generated context
	 */
	protected List<Context> getContexts(List<EObject> outObjects) {
		List<Context> result = new LinkedList<Context>();

		for(Object objectResult : outObjects) {
			if(objectResult instanceof Context) {
				result.add((Context)objectResult);
			}
		}

		return result;
	}


	public abstract IObservableValue getObservableValue();

	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}

	private List<Context> generateSameFile(List<URI> targetURI) {

		URI transformationURI = getTransformationURI();

		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		Diagnostic diagnostic = executor.loadTransformation();
		if(diagnostic.getSeverity() != Diagnostic.OK) {
			Activator.log.warn("Cannot load the transformation : " + transformationURI);
			return generatedContexts = null;
		}
		List<ModelExtent> extents = getModelExtents();


		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		context.setLog(new WriterLog(new OutputStreamWriter(System.out)));

		ExecutionDiagnostic result = executor.execute(context, extents.toArray(new ModelExtent[0]));

		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> outObjects = getOutContextExtent().getContents();
			Object objectResult = outObjects.get(0);
			if(!(objectResult instanceof Context)) {
				return null;
			}

			ResourceSet resourceSet = new ResourceSetImpl();
			Resource contextResource = resourceSet.createResource(targetURI.get(0));
			contextResource.getContents().addAll(outObjects);

			return generatedContexts = getContexts(outObjects);
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.log.warn(String.format("%s : %s", status.getPlugin(), status.getMessage()));
		}
		return generatedContexts = null;
	}




	protected abstract List<ModelExtent> getModelExtents(int i);


	private List<Context> generateDifferentFile(List<URI> targetURI) {

		URI transformationURI = getTransformationURI();

		TransformationExecutor executor = new TransformationExecutor(transformationURI);
		Diagnostic diagnostic = executor.loadTransformation();
		if(diagnostic.getSeverity() != Diagnostic.OK) {
			Activator.log.warn("Cannot load the transformation : " + transformationURI);
			return generatedContexts = null;
		}
		List<ModelExtent> extents = null;
		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		context.setLog(new WriterLog(new OutputStreamWriter(System.out)));
		List<Context> temp = new LinkedList<Context>();

		for(int i = 0; i < targetURI.size(); i++) {
			extents = getModelExtents(i);



			ExecutionDiagnostic result = executor.execute(context, extents.toArray(new ModelExtent[0]));

			if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
				List<EObject> outObjects = getOutContextExtent().getContents();
				Object objectResult = outObjects.get(0);
				if(!(objectResult instanceof Context)) {
					return null;
				}
				ResourceSet resourceSet = new ResourceSetImpl();
				Resource contextResource = resourceSet.createResource(targetURI.get(i));
				contextResource.getContents().addAll(outObjects);
				temp.addAll(getContexts(outObjects));

			} else {
				IStatus status = BasicDiagnostic.toIStatus(result);
				Activator.log.warn(String.format("%s : %s", status.getPlugin(), status.getMessage()));
			}
		}

		return temp;

	}



}
