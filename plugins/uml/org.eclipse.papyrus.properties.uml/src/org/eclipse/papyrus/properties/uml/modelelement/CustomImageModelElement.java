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
package org.eclipse.papyrus.properties.uml.modelelement;

import static org.eclipse.papyrus.properties.uml.databinding.ImageKindObservableValue.KIND_ICON;
import static org.eclipse.papyrus.properties.uml.databinding.ImageKindObservableValue.KIND_SHAPE;
import static org.eclipse.papyrus.properties.uml.databinding.ImageKindObservableValue.KIND_UNDEFINED;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.uml.Activator;
import org.eclipse.papyrus.properties.uml.databinding.ImageExpressionObservableValue;
import org.eclipse.papyrus.properties.uml.databinding.ImageKindObservableValue;
import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.uml2.uml.Image;


public class CustomImageModelElement extends AbstractModelElement {

	protected Image image;

	protected EditingDomain editingDomain;

	public CustomImageModelElement(Image umlSource, EditingDomain domain) {
		this.image = umlSource;
		this.editingDomain = domain;
	}

	public IObservable getObservable(String propertyPath) {
		if(propertyPath.equals("kind")) {
			return new ImageKindObservableValue(image, editingDomain);
		} else if(propertyPath.equals("expression")) {
			return new ImageExpressionObservableValue(image, editingDomain);
		}

		Activator.log.warn("Unknown property : " + propertyPath);

		return null;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(propertyPath.equals("kind")) {
			return new AbstractStaticContentProvider() {

				public Object[] getElements() {
					return new String[]{ KIND_UNDEFINED, KIND_ICON, KIND_SHAPE };
				}

			};
		}

		return null;
	}

}
