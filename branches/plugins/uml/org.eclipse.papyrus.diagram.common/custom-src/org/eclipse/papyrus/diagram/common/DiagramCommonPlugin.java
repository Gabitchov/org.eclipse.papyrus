/***************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) – initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.papyrus.diagram.common.providers.AlternativeUMLItemProviderAdapterFactory;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.edit.providers.UMLItemProviderAdapterFactory;
import org.osgi.framework.BundleContext;

// TODO: Auto-generated Javadoc
/**
 * The Class UMLDiagramEditorPlugin.
 * 
 * @generated
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class DiagramCommonPlugin extends AbstractUIPlugin {

	/** The Constant ID. */
	public static final String ID = "org.eclipse.papyrus.common.diagram.common";

	/** The Constant DIAGRAM_PREFERENCES_HINT. */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(ID);

	/**
	 * This plugin's instance.
	 */
	private static DiagramCommonPlugin instance = null;

	/** The adapter factory. */
	private ComposedAdapterFactory adapterFactory;

	/**
	 * The Constructor.
	 * 
	 * @generated
	 */
	public DiagramCommonPlugin() {
	}

	/**
	 * Start.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @throws Exception
	 *             the exception
	 * 
	 * @generated
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());
	}

	/**
	 * Stop.
	 * 
	 * @param context
	 *            the context
	 * 
	 * @throws Exception
	 *             the exception
	 * 
	 * @generated
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

	/**
	 * Gets the instance.
	 * 
	 * @return the instance
	 */
	public static DiagramCommonPlugin getInstance() {
		return instance;
	}

	/**
	 * Log error.
	 * 
	 * @param error
	 *            the error
	 */
	public void logError(String error) {
		logError(error, null);
	}

	/**
	 * Log error.
	 * 
	 * @param throwable
	 *            actual error or null could be passed
	 * @param error
	 *            the error
	 */
	public void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.ERROR, DiagramCommonPlugin.ID, IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	/**
	 * Log info.
	 * 
	 * @param message
	 *            the message
	 */
	public void logInfo(String message) {
		logInfo(message, null);
	}

	/**
	 * Log info.
	 * 
	 * @param throwable
	 *            actual error or null could be passed
	 * @param message
	 *            the message
	 */
	public void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getLog().log(new Status(IStatus.INFO, DiagramCommonPlugin.ID, IStatus.OK, message, throwable));
		debug(message, throwable);
	}

	/**
	 * Debug.
	 * 
	 * @param message
	 *            the message
	 * @param throwable
	 *            the throwable
	 */
	private void debug(String message, Throwable throwable) {
		if (!isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}

	/**
	 * Creates the adapter factory.
	 * 
	 * @return the composed adapter factory
	 */
	protected ComposedAdapterFactory createAdapterFactory() {
		List factories = new ArrayList();
		fillItemProviderFactories(factories);
		return new ComposedAdapterFactory(factories);
	}

	/**
	 * Use alternative UMLItemProviderAdapterFactory insteadof UMLItemProviderAdapterFactory.
	 * 
	 * @param factories
	 *            the factories
	 * 
	 * @see org.eclipse.emf.edit.provider.ComposedAdapterFactory#getFactoryForTypes(java.util.Collection)
	 */
	protected void fillItemProviderFactories(List factories) {
		// custom icons for diagram elements
		factories.add(new AlternativeUMLItemProviderAdapterFactory(getPreferenceStore()));

		factories.add(new UMLItemProviderAdapterFactory());
		factories.add(new EcoreItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
	}

	/**
	 * Gets the item providers adapter factory.
	 * 
	 * @return the item providers adapter factory
	 */
	public AdapterFactory getItemProvidersAdapterFactory() {
		if (adapterFactory == null) {
			adapterFactory = createAdapterFactory();
		}
		return adapterFactory;
	}
}
