/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.papyrus.uml.modelexplorer.widgets.ServiceEditFilteredUMLContentProvider;
import org.eclipse.uml2.uml.InstanceValue;

/**
 * A Content provider for the value of an InstanceValue
 * 
 * The valid instance specifications are filtered according to the type of the
 * InstanceValue
 * 
 * @author Camille Letavernier
 * 
 * @see InstanceValue#getType()
 * @see InstanceValueViewerFilter
 */
public class InstanceValueContentProvider extends ServiceEditFilteredUMLContentProvider {

	private InstanceValue source;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The InstanceValue being edited
	 * @param feature
	 *        The EStructuralFeature being edited
	 * @param semanticRoot
	 *        The root EObject for the Tree representing the model
	 */
	public InstanceValueContentProvider(InstanceValue source, EStructuralFeature feature, EObject semanticRoot) {
		super(source, feature, semanticRoot);
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		super.inputChanged(viewer, oldInput, newInput);
		if(this.viewer != null) {
			this.viewer.setFilters(new ViewerFilter[]{ new InstanceValueViewerFilter(this, source) });
		}
	}

}
