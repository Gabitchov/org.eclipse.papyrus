/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 349546 - EMF Facet facetSet editor
 */
package org.eclipse.emf.facet.efacet.ui.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;
import org.eclipse.emf.facet.util.core.Logger;

//TODO @Deprecated must be removed after a refactoring planed by https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601
@Deprecated
public class QueryCreationPagePartRegistryImpl implements IQueryCreationPagePartRegistry {

	private static final String EXTENSION_POINT_ID = "org.eclipse.emf.facet.efacet.ui.queryFactoryWizardPageRegistration"; //$NON-NLS-1$
	private static final String WIZARD_PAGE = "wizardPage"; //$NON-NLS-1$
	private static final String MANAGED_TYPE_NAME = "managedQueryTypeName"; //$NON-NLS-1$

	private final Map<String, IQueryCreationPagePart> queryEvaluatorFactories = new HashMap<String, IQueryCreationPagePart>();

	public QueryCreationPagePartRegistryImpl() {
		initRegisteredEntries();
	}

	private void initRegisteredEntries() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extPoint = registry.getExtensionPoint(QueryCreationPagePartRegistryImpl.EXTENSION_POINT_ID);
		if (extPoint != null) {
			for (IExtension ext : extPoint.getExtensions()) {
				for (IConfigurationElement configElt : ext.getConfigurationElements()) {

					IQueryCreationPagePart queryCreationWizardPage;
					try {
						configElt.createExecutableExtension(QueryCreationPagePartRegistryImpl.WIZARD_PAGE);
						queryCreationWizardPage = (IQueryCreationPagePart) configElt
								.createExecutableExtension(QueryCreationPagePartRegistryImpl.WIZARD_PAGE);
						String managedQueryTypeName = configElt.getAttribute(QueryCreationPagePartRegistryImpl.MANAGED_TYPE_NAME);
						if (this.queryEvaluatorFactories.containsKey(managedQueryTypeName)) {
							Logger.logError("A conflict occurred for " //$NON-NLS-1$
									+ managedQueryTypeName + " query IQueryCreationPage. Only one creationPage is allowed at the same time.", //$NON-NLS-1$
									Activator.getDefault());
						} else {
							this.queryEvaluatorFactories.put(managedQueryTypeName, queryCreationWizardPage);
						}
					} catch (CoreException e) {
						Logger.logError(e, Activator.getDefault());
					}
				}
			}
		} else {
			Logger.logError("Could not find extensionPoint: " + QueryCreationPagePartRegistryImpl.EXTENSION_POINT_ID, Activator.getDefault()); //$NON-NLS-1$
		}
	}

	public IQueryCreationPagePart getWizardPagePartFor(final String managedTypeName) {
		return this.queryEvaluatorFactories.get(managedTypeName);
	}

	public Map<String, IQueryCreationPagePart> getRegisteredWizardPageParts() {
		return this.queryEvaluatorFactories;
	}
}
