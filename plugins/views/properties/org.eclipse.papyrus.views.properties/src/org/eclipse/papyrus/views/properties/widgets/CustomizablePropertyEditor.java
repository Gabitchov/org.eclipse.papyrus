/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.views.properties.modelelement.DataSource;

/**
 * The inteface to be implemented by all PropertyEditors
 * 
 * @author Camille Letavernier
 * 
 */
public interface CustomizablePropertyEditor {

	public DataSource getInput();

	public void setInput(DataSource input);

	public String getProperty();

	public void setProperty(String property);

	public boolean getShowLabel();

	public void setShowLabel(boolean showLabel);

	public String getCustomLabel();

	public void setCustomLabel(String customLabel);

	public void setReadOnly(boolean readOnly);

	public boolean getReadOnly();
}
