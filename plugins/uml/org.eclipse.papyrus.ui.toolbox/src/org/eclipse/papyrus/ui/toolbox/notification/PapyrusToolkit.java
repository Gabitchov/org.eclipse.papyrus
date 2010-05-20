/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;


/**
 * This class allows specific toolkit for component creation
 * 
 * @author tfaure
 * 
 */
public class PapyrusToolkit extends FormToolkit {

	public static int DEFAULT_STYLE = -1;

	public PapyrusToolkit(Display display) {
		super(display);
	}

	@Override
	public Section createSection(Composite parent, int sectionStyle) {
		if(sectionStyle == DEFAULT_STYLE) {
			return super.createSection(parent, Section.EXPANDED | Section.TITLE_BAR);
		}
		return super.createSection(parent, sectionStyle);
	}

}
