/*****************************************************************************
 * Copyright (c) 2011 Atos Origin Integration.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (Atos Origin Integration) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.onefile.providers;

import java.text.Collator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.papyrus.infra.onefile.model.IPapyrusFile;
import org.eclipse.ui.views.navigator.ResourceComparator;

/**
 * Sort Papyrus Files according to their Main File
 * 
 * @author tristan.faure@atosorigin.com
 */
public class PapyrusViewerSorter extends ViewerSorter {

	/**
	 * {@link ResourceComparator} for comparison delegation
	 */
	ResourceComparator comp = new ResourceComparator(ResourceComparator.TYPE);

	public PapyrusViewerSorter() {
		super();
	}

	public PapyrusViewerSorter(Collator collator) {
		super(collator);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof IPapyrusFile) {
			IPapyrusFile papyrusFile = (IPapyrusFile) e1;
			e1 = papyrusFile.getMainFile();
		}
		if (e2 instanceof IPapyrusFile) {
			IPapyrusFile papyrusFile = (IPapyrusFile) e2;
			e2 = papyrusFile.getMainFile();
		}
		return comp.compare(viewer, e1, e2);
	}

}
