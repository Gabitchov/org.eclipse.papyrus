/*****************************************************************************
 * Copyright (c) 2012 Atos
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure tristan.faure@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sasheditor.internal;

import org.eclipse.papyrus.sasheditor.contentprovider.IComponentModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


/**
 * A generic component to display errors
 * @author tfaure
 *
 */
public class ErrorComponentModel implements IComponentModel {

	private final Object newModel;

	public ErrorComponentModel(Object newModel) {
		this.newModel = newModel;
	}

	public String getTabTitle() {
		return "Error";
	}

	public Image getTabIcon() {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK);
	}

	public Object getRawModel() {
		return newModel;
	}

	public Composite createPartControl(Composite parent) {
		Label l = new Label(parent, SWT.NONE);
		l.setText(String.format("Error : An error occured during the load of this tab, the problematic object : %s", newModel));
		return parent;
	}

}
