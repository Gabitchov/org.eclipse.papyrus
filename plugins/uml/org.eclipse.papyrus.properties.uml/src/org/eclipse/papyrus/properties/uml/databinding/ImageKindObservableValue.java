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


public class ImageKindObservableValue extends AbstractObservableValue {


	public static final String KIND_UNDEFINED = "undefined"; //$NON-NLS-1$

	public static final String KIND_ICON = "icon"; //$NON-NLS-1$

	public static final String KIND_SHAPE = "shape"; //$NON-NLS-1$

	private Image image;

	private EditingDomain domain;

	public ImageKindObservableValue(Image image, EditingDomain domain) {
		this.image = image;
		this.domain = domain;
	}

	public Object getValueType() {
		return String.class;
	}

	@Override
	protected String doGetValue() {
		return ImageUtil.getKind(image);
	}

	@Override
	protected void doSetValue(Object value) {
		if(value instanceof String) {
			final String kind = (String)value;

			Runnable runnable = new Runnable() {

				public void run() {
					ImageUtil.setKind(image, kind);
				}
			};

			Command emfCommand = new ChangeCommand(domain, runnable);
			domain.getCommandStack().execute(emfCommand);
		}
	}

}
