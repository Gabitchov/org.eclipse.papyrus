/*****************************************************************************
* Copyright (c) 2012 CEA LIST.
*
*    
 * All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Ansgar Radermacher (CEA LIST) - Initial API and implementation
*
*****************************************************************************/

package org.eclipse.papyrus.views.tracepoints.views;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.views.tracepoints.Activator;
import org.eclipse.swt.graphics.Image;


public class TraceViewImages {

	public static ImageDescriptor getGotoObjID() {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		return widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, "icons/gotoobj_tsk.gif");
	}

	public static ImageDescriptor getSkipAllID() {
		org.eclipse.papyrus.infra.widgets.Activator widgetsActivator =
			org.eclipse.papyrus.infra.widgets.Activator.getDefault();
		return widgetsActivator.getImageDescriptor(Activator.PLUGIN_ID, "icons/skip_brkp.gif");
	}

	public static Image getSkipAllImage() {
		if(skipAllImage == null) {
			skipAllImage = getSkipAllID().createImage();
		}
		return skipAllImage;
	}

	protected static Image skipAllImage = null;
}
