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
package org.eclipse.papyrus.properties.uml.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.diagram.common.providers.EditorLabelProvider;
import org.eclipse.papyrus.properties.modelelement.EMFModelElement;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableList;
import org.eclipse.papyrus.properties.uml.databinding.PapyrusObservableValue;

/**
 * A Model Element for manipulating Stereotype properties
 * 
 * @author Camille Letavernier
 */
public class StereotypeModelElement extends EMFModelElement {

	/**
	 * Constructor.
	 * 
	 * @param source
	 *        The StereotypeApplication being edited
	 * @param domain
	 *        The Editing domain on which the commands will be called
	 * 
	 */
	public StereotypeModelElement(EObject source, EditingDomain domain) {
		super(source, domain);
	}

	@Override
	public IObservable getObservable(String propertyPath) {
		FeaturePath featurePath = getFeaturePath(propertyPath);
		EStructuralFeature feature = getFeature(featurePath);
		if(feature.getUpperBound() != 1) {
			return new PapyrusObservableList(EMFProperties.list(featurePath).observe(source), domain, getSource(featurePath), feature);
		}

		return new PapyrusObservableValue(getSource(featurePath), feature, domain);
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		EStructuralFeature feature = getFeature(propertyPath);
		if(feature.getEType() instanceof EEnum) {
			return super.getLabelProvider(propertyPath);
		}
		return new EditorLabelProvider();
	}
}
