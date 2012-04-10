/*******************************************************************************
 * Copyright (c) 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.xwt.jface;

import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.AbstractTableViewer;
import org.eclipse.papyrus.xwt.metadata.IObjectInitializer;

public class JFaceInitializer implements IObjectInitializer {

	public void initialize(Object object) {
		if(object instanceof AbstractListViewer) {
			AbstractListViewer viewer = (AbstractListViewer)object;
			viewer.setLabelProvider(new DefaultViewerLabelProvider(viewer));
		} else if(object instanceof AbstractTableViewer) {
			AbstractTableViewer viewer = (AbstractTableViewer)object;
			viewer.setLabelProvider(new DefaultViewerLabelProvider(viewer));
		}
	}
}
