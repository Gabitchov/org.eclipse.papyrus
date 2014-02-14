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
 *  Gregoire Dupe (Mia-Software) - Bug 361617 - Deprecation of APIs for the old Facet metamodels
 */
package org.eclipse.emf.facet.efacet.ui.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.facet.efacet.ui.internal.exported.wizard.IQueryCreationPagePart;

/**
 * This interface is dedicated to the registry
 * 
 * TODO: This interface has to be renamed to IQueryCreationPagePartRegistry before the release of 0.2
 * 
 * @since 0.2
 */
//TODO: This interface has to be renamed to IQueryCreationPagePartRegistry before the release of 0.2
public interface IQueryCreationPagePart2Registry {

	/**
	 * Returns an instance of {@link QueryCreationPagePartRegistryImpl}.
	 */
	IQueryCreationPagePart2Registry INSTANCE = null; //TODO cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=364601

	/**
	 * Return a registered {@link IQueryCreationPagePart} corresponding to the given type name.
	 * 
	 * @param managedTypeName
	 *            the type we need a part for.
	 * @return a registered {@link IQueryCreationPagePart} corresponding to the given type name.
	 */
	public IQueryCreationPagePart2 getWizardPagePartFor(EClass managedQueryType);

	/**
	 * Returns every registered {@link IQueryCreationPagePart} associated with their managed type.
	 * 
	 * @return
	 */
	public Map<String, IQueryCreationPagePart2> getRegisteredWizardPageParts();

}
