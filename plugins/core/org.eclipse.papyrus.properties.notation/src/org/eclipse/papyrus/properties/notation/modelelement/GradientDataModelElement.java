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
package org.eclipse.papyrus.properties.notation.modelelement;

import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.gmf.runtime.notation.datatype.GradientData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.properties.modelelement.AbstractModelElement;
import org.eclipse.papyrus.properties.notation.Activator;
import org.eclipse.papyrus.properties.notation.databinding.GradientDataObservableValue;
import org.eclipse.papyrus.properties.notation.databinding.GradientDataObservableValue.GradientProperty;
import org.eclipse.papyrus.properties.notation.messages.Messages;
import org.eclipse.papyrus.widgets.providers.AbstractStaticContentProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;


public class GradientDataModelElement extends AbstractModelElement {

	protected GradientData sourceElement;

	public GradientDataModelElement(GradientData sourceElement) {
		this.sourceElement = sourceElement;
	}

	public IObservable getObservable(String propertyPath) {
		return new GradientDataObservableValue(sourceElement, propertyPath);
	}

	@Override
	public boolean isMandatory(String propertyPath) {
		return true;
	}

	@Override
	public IStaticContentProvider getContentProvider(String propertyPath) {
		if(propertyPath.equals("gradientStyle")) { //$NON-NLS-1$
			return new AbstractStaticContentProvider() {

				public Object[] getElements() {
					return new Integer[]{ 0, 1 };
				}

			};
		}

		return null;
	}

	@Override
	public ILabelProvider getLabelProvider(String propertyPath) {
		if(propertyPath.equals("gradientStyle")) { //$NON-NLS-1$
			return new LabelProvider() {

				@Override
				public String getText(Object element) {
					if(element instanceof Integer) {
						int value = (Integer)element;
						if(value == 0) {
							return Messages.GradientDataModelElement_Vertical;
						} else {
							return Messages.GradientDataModelElement_Horizontal;
						}
					}

					return null;
				}
			};
		}

		return null;
	}

	public Object getDefaultValue(String propertyPath) {
		GradientProperty property = GradientProperty.valueOf(propertyPath);
		switch(property) {
		case activate:
			return false;
		case gradientColor1:
			return GradientData.getDefaultGradientData().getGradientColor1();
		case gradientColor2:
			return GradientData.getDefaultGradientData().getGradientColor2();
		case gradientStyle:
			return GradientData.getDefaultGradientData().getGradientStyle();
		default:
			Activator.log.warn("Cannot find a default value for property : " + propertyPath); //$NON-NLS-1$
			return null;
		}
	}

}
