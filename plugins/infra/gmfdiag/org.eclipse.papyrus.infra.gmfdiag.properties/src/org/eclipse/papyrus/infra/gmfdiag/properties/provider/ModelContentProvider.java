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
package org.eclipse.papyrus.infra.gmfdiag.properties.provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.infra.viewpoints.configuration.ui.ECoreModelContentProvider;
import org.eclipse.papyrus.infra.viewpoints.policy.ViewPrototype;
import org.eclipse.papyrus.infra.widgets.providers.IHierarchicContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;

/**
 * Represents a simple ECore model content provider for the selection of a diagram's root model element
 * @author Laurent Wouters
 */
public abstract class ModelContentProvider extends ECoreModelContentProvider implements IStaticContentProvider, IHierarchicContentProvider {
	
	/**
	 * The diagram
	 */
	private Diagram diagram;
	
	/**
	 * Initializes the provider with the given root
	 * @param diagram The diagram for which a root model element is to be provided
	 * @param root The root object
	 */
	public ModelContentProvider(Diagram diagram, EObject root) {
		super(root);
		this.diagram = diagram;
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
		ViewPrototype prototype = DiagramUtils.getPrototype(diagram);
		if (prototype == null)
			return false;
		return isValid((EObject) element, diagram, prototype);
	}

	/**
	 * Determines whether the selection is valid
	 * 
	 * @param selection
	 *            The selection
	 * @param diagram
	 *            The diagram
	 * @param prototype
	 *            The diagram's prototype
	 * @return <code>true</code> if the selection is valid
	 */
	protected abstract boolean isValid(EObject selection, Diagram diagram, ViewPrototype prototype);
}
