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
package org.eclipse.papyrus.emf.facet.efacet.ui.internal;

import java.util.Map;

import org.eclipse.papyrus.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;


/**
 * This interface is dedicated to the registry
 * @since 0.2
 * @deprecated This interface has been replaced by {@link IQueryCreationPagePart2Registry}. No tracking bug needed because this API has not been released yet.
 */
@Deprecated
public interface IQueryCreationPagePartRegistry {

	/**
	 * Returns an instance of {@link QueryCreationPagePartRegistryImpl}.
	 */
	IQueryCreationPagePartRegistry INSTANCE = new QueryCreationPagePartRegistryImpl();

	/**
	 * Return a registered {@link IQueryCreationPagePart} corresponding to the given type name.
	 * 
	 * @param managedTypeName
	 *            the type we need a part for.
	 * @return a registered {@link IQueryCreationPagePart} corresponding to the given type name.
	 */
	public IQueryCreationPagePart getWizardPagePartFor(String managedTypeName);

	/**
	 * Returns every registered {@link IQueryCreationPagePart} associated with their managed type.
	 * 
	 * @return
	 */
	public Map<String, IQueryCreationPagePart> getRegisteredWizardPageParts();

}
