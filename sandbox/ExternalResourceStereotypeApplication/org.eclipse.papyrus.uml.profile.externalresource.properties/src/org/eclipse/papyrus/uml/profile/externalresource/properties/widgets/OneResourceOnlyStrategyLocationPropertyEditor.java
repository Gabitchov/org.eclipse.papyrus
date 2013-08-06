/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.properties.widgets;

import org.eclipse.papyrus.uml.properties.widgets.ProfileApplicationEditor;
import org.eclipse.papyrus.uml.properties.widgets.ProfileApplicationPropertyEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property editor for Profile Application, extended to support external resource for profile applications
 */
public class OneResourceOnlyStrategyLocationPropertyEditor extends ProfileApplicationPropertyEditor {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public OneResourceOnlyStrategyLocationPropertyEditor(Composite parent, int style) {
		super(parent, style);
		setEditor(new ResourcePerProfileStrategyLocationEditor(parent, style));
	}

	
	
	/**
	 * Location editor for the common resource where stereotype application are stored
	 * 
	 *                                 		---------------------------------------
	 *  Stereotype Application Location 	|                                     |  |+| |X|
	 *  									---------------------------------------
	 */
	public class ResourcePerProfileStrategyLocationEditor extends ProfileApplicationEditor {

		/**
		 * @param parent
		 * @param style
		 */
		public ResourcePerProfileStrategyLocationEditor(Composite parent, int style) {
			super(parent, style);
		}
	}
}
