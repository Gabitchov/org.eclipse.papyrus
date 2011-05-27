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
package org.eclipse.papyrus.properties.uml.databinding;

import org.eclipse.core.databinding.observable.value.AbstractObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.umlutils.ImageUtil;
import org.eclipse.uml2.common.edit.command.ChangeCommand;
import org.eclipse.uml2.uml.Image;


public class ImageExpressionObservableValue extends AbstractObservableValue {

	private Image image;

	private EditingDomain domain;

	public ImageExpressionObservableValue(Image image, EditingDomain domain) {
		this.image = image;
		this.domain = domain;
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected Object doGetValue() {
		return ImageUtil.getExpression(image);
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			final String expression = (String)value;

			Runnable runnable = new Runnable() {

				public void run() {

					ImageUtil.setExpression(image, expression);
				}
			};

			Command emfCommand = new ChangeCommand(domain, runnable);
			domain.getCommandStack().execute(emfCommand);
		}
	}

}
