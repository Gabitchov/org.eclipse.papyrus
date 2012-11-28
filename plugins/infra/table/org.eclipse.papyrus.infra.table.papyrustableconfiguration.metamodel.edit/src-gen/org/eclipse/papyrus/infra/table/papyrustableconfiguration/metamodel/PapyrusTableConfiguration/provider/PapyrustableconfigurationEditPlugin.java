/**
 * Copyright (c) 2012 CEA LIST.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * ttp://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.table.papyrustableconfiguration.metamodel.PapyrusTableConfiguration.provider;

import org.eclipse.emf.common.EMFPlugin;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.provider.EcoreEditPlugin;

import org.eclipse.emf.facet.infra.browser.custom.emf.provider.UiCustomEditPlugin;

import org.eclipse.emf.facet.infra.facet.edit.provider.FacetEditPlugin;

import org.eclipse.emf.facet.infra.query.edit.provider.QueryEditPlugin;

import org.eclipse.emf.facet.widgets.celleditors.edit.CelleditorsEditPlugin;

import org.eclipse.emf.facet.widgets.nattable.tableconfiguration.provider.TableConfigurationEditPlugin;

import org.eclipse.emf.facet.widgets.nattable.tableconfiguration2.provider.TableConfiguration2EditPlugin;

/**
 * This is the central singleton for the Papyrustableconfiguration edit plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class PapyrustableconfigurationEditPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final PapyrustableconfigurationEditPlugin INSTANCE = new PapyrustableconfigurationEditPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PapyrustableconfigurationEditPlugin() {
		super
		  (new ResourceLocator [] {
		     CelleditorsEditPlugin.INSTANCE,
		     EcoreEditPlugin.INSTANCE,
		     FacetEditPlugin.INSTANCE,
		     QueryEditPlugin.INSTANCE,
		     TableConfigurationEditPlugin.INSTANCE,
		     TableConfiguration2EditPlugin.INSTANCE,
		     UiCustomEditPlugin.INSTANCE,
		   });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipsePlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

}
