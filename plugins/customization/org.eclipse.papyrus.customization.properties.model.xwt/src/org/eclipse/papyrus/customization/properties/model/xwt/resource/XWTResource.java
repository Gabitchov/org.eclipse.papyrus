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
package org.eclipse.papyrus.customization.properties.model.xwt.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.gmt.modisco.xml.Root;
import org.eclipse.gmt.modisco.xml.resource.GenericXMLResourceImpl;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;
import org.eclipse.m2m.qvt.oml.ModelExtent;
import org.eclipse.m2m.qvt.oml.TransformationExecutor;
import org.eclipse.m2m.qvt.oml.util.Log;
import org.eclipse.papyrus.customization.properties.model.xwt.Activator;
import org.eclipse.papyrus.customization.properties.model.xwt.format.XMLFormatter;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.papyrus.views.properties.ui.CompositeWidget;
import org.eclipse.papyrus.views.properties.ui.UiPackage;
import org.eclipse.papyrus.views.properties.util.PropertiesUtil;

/**
 * A Resource for representing XWT (XML Widget Toolkit) files
 * as EObjects.
 * Resulting EObjects are conform to the Papyrus property view UI Metamodel :
 * http://www.eclipse.org/papyrus/properties/ui/0.9
 * 
 * The resource is based on MoDisco for reading and writing XML,
 * and on QVTO to go from XML to EMF and vice-versa.
 * 
 * @author Camille Letavernier
 * 
 * @see UiPackage
 */
public class XWTResource extends ResourceImpl {

	private GenericXMLResourceImpl xmlResource;

	/**
	 * The "format" option.
	 * 
	 * This option is a boolean, which default value is true
	 */
	public static final String OPTION_FORMAT = "format";

	/**
	 * 
	 * Constructs a new XWTResource with the given URI
	 * 
	 * @param uri
	 *        The resource's URI
	 */
	public XWTResource(URI uri) {
		super(uri);
		xmlResource = new GenericXMLResourceImpl(uri);
	}

	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		xmlResource.load(inputStream, options);
		Root root = (Root)xmlResource.getContents().get(0);
		try {
			CompositeWidget widget = xmlToUISection(root);
			if(widget == null) {
				Activator.log.warn("Cannot load the XWT Widget");
			} else {
				getContents().add(widget);
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		if(options == null || options.isEmpty()) {
			Map<String, String> optionsMap = new HashMap<String, String>();
			optionsMap.put(OPTION_SAVE_ONLY_IF_CHANGED, OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			super.save(optionsMap);
		} else {
			super.save(options);
		}

		Object formatValue = options.get(OPTION_FORMAT);
		if(formatValue == null || formatValue == Boolean.TRUE) {
			if(uri.isPlatform()) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
				XMLFormatter.format(file);
			}
		}
	}

	@Override
	protected void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		try {
			if(getContents().isEmpty()) {
				Activator.log.warn("Cannot save an Empty XWT resource : " + getURI());
				return;
			}
			Root root = uiSectionToXML((CompositeWidget)getContents().get(0));
			xmlResource.getContents().clear();
			xmlResource.getContents().add(root);
			xmlResource.save(outputStream, options);
		} catch (IOException ex) {
			Activator.log.error(ex);
			throw ex;
		} catch (Exception ex) {
			Activator.log.error(ex);
		}
	}

	private Collection<Context> findContexts() {
		Set<Context> rootContexts = new HashSet<Context>();
		if(resourceSet == null) {
			return Collections.emptyList();
		}

		for(Resource resource : resourceSet.getResources()) {
			if(!resource.getContents().isEmpty() && resource.getContents().get(0) instanceof Context) {
				Context context = (Context)resource.getContents().get(0);
				rootContexts.add(context);
			}
		}

		Set<Context> allContexts = new HashSet<Context>();

		for(Context context : rootContexts) {
			allContexts.addAll(PropertiesUtil.getDependencies(context));
		}

		return allContexts;
	}

	private CompositeWidget xmlToUISection(Root genericXMLRoot) {
		URI transformationURI = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/Transformation/XMLToUI.qvto", true); //$NON-NLS-1$
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		List<Context> contexts = new LinkedList<Context>(findContexts());

		ModelExtent inXml = getModelExtent(genericXMLRoot);
		ModelExtent inRoot = getModelExtent(ConfigurationManager.getInstance().getPropertiesRoot());
		ModelExtent inContexts = new BasicModelExtent(contexts);
		ModelExtent outUI = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setLog(getLogger());
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$

		ExecutionDiagnostic result = executor.execute(context, inXml, inRoot, inContexts, outUI);

		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> outObjects = outUI.getContents();
			Object objectResult = outObjects.get(0);
			if(!(objectResult instanceof CompositeWidget)) {
				return null;
			}

			return (CompositeWidget)outObjects.get(0);
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
			Activator.log.error(status.getException());
		}

		return null;
	}

	private Log getLogger() {
		return new Log() {

			public void log(int level, String message) {
				Activator.getDefault().getLog().log(new Status(level, Activator.PLUGIN_ID, message));
			}

			public void log(int level, String message, Object param) {
				log(level, message);
			}


			public void log(String message) {
				log(IStatus.INFO, message);
			}

			public void log(String message, Object param) {
				log(message);
			}
		};
	}

	private Root uiSectionToXML(CompositeWidget widget) {
		URI transformationURI = URI.createPlatformPluginURI(Activator.PLUGIN_ID + "/Transformation/UIToXML.qvto", true); //$NON-NLS-1$
		TransformationExecutor executor = new TransformationExecutor(transformationURI);

		ModelExtent inWidget = getModelExtent(widget);
		ModelExtent outXML = new BasicModelExtent();

		ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("keepModeling", true); //$NON-NLS-1$
		context.setLog(getLogger());

		ExecutionDiagnostic result = executor.execute(context, inWidget, outXML);

		if(result.getSeverity() == org.eclipse.emf.common.util.Diagnostic.OK) {
			List<EObject> outObjects = outXML.getContents();

			return (Root)outObjects.get(0);
		} else {
			IStatus status = BasicDiagnostic.toIStatus(result);
			Activator.getDefault().getLog().log(status);
		}
		return null;
	}

	private ModelExtent getModelExtent(EObject source) {
		if(source == null) {
			return new BasicModelExtent();
		}

		EList<EObject> objects = new BasicEList<EObject>();
		objects.add(source);
		ModelExtent extent = new BasicModelExtent(objects);
		return extent;
	}
}
