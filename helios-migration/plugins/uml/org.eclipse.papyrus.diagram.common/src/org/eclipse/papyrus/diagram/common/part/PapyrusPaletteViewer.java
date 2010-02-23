/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.diagram.common.part;

import org.eclipse.gef.ui.palette.customize.PaletteCustomizerDialog;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteViewerEx;

/**
 * Extended Palette Viewer, to have a new customize dialog
 */
public class PapyrusPaletteViewer extends PaletteViewerEx {

	private PapyrusPaletteCustomizerDialog customizerDialog = null;

	public PaletteCustomizerDialog getCustomizerDialog() {
		if(customizerDialog == null) {
			customizerDialog = new PapyrusPaletteCustomizerDialog(getControl().getShell(), getCustomizer(), getPaletteRoot());
		}
		return customizerDialog;
	}
}
