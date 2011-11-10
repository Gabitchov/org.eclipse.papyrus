/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.swt.graphics.Image;


/**
 * Label provider for the configuration area of the content wizard page
 */
public class ConfigurationLabelProvider extends LabelProvider {

	/**
	 * Creates a new ConfigurationLabelProvider.
	 */
	public ConfigurationLabelProvider() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object object) {
		if(object instanceof IState) {
			return ((IState)object).getText();
		} else if(object instanceof LabelProvider) {
			return ((LabelProvider)object).getText(object);
		}
		return super.getText(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object object) {
		if(object instanceof IState) {
			return ((IState)object).getImage();
		} else if(object instanceof LabelProvider) {
			return ((LabelProvider)object).getImage(object);
		}
		return super.getImage(object);
	}

}
