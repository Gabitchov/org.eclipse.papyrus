/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.properties.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.viewpoints.configuration.PapyrusView;
import org.eclipse.papyrus.infra.viewpoints.configuration.ui.ECoreModelContentProvider;
import org.eclipse.papyrus.infra.viewpoints.policy.PolicyChecker;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * Represents a simple ECore model content provider for the selection of a table's root model element
 * @author Laurent Wouters
 */
public class ContextFeatureContentProvider extends ECoreModelContentProvider implements IStaticContentProvider, IHierarchicContentProvider {
	/**
	 * The diagram
	 */
	private Table table;
	
	/**
	 * Initializes the provider with the given root
	 * @param diagram The diagram for which a root model element is to be provided
	 * @param root The root object
	 */
	public ContextFeatureContentProvider(Table table, EObject root) {
		super(root);
		this.table = table;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider#getElements()
	 */
	public Object[] getElements() {
		return getElements(null);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider#isValidValue(java.lang.Object)
	 */
	public boolean isValidValue(Object element) {
		if (element == null)
			return false;
		if (!(element instanceof EObject))
			return false;
		ViewPrototype prototype = ViewPrototype.get((PapyrusView)table.getPrototype());
		if (prototype == null)
			return false;
		return PolicyChecker.getCurrent().canHaveNewView((EObject)element, table.getOwner(), prototype);
	}
}
