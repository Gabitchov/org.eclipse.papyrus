/*****************************************************************************
 * Copyright (c) 2011, 2014 CEA LIST and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 323802
 *  
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.infra.emf.databinding.AnnotationObservableValue;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

/**
 * A ModelElement for handling EAnnotations
 * 
 * @author Camille Letavernier
 */
public class AnnotationModelElement extends AbstractModelElement {

	/**
	 * The EModelElement owning the represented EAnnotation
	 */
	protected EModelElement source;

	/**
	 * The editing domain on which the modification commands will be executed
	 */
	protected EditingDomain domain;

	/**
	 * The name of the annotation being represented
	 */
	protected String annotationName;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param source
	 *        The EModelElement owning the EAnnotation that will be edited
	 * @param domain
	 *        The EditingDomain on which the commands will be executed
	 * @param annotationName
	 *        The name of the EAnnotation to edit. The EAnnotation doesn't need to exist yet
	 */
	public AnnotationModelElement(EModelElement source, EditingDomain domain, String annotationName) {
		this.source = source;
		this.domain = domain;
		this.annotationName = annotationName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservable doGetObservable(String propertyPath) {
		return new AnnotationObservableValue(source, domain, annotationName, propertyPath);
	}

	@Override
	public boolean isEditable(String propertyPath) {
		return !EMFHelper.isReadOnly(source);
	}
}
