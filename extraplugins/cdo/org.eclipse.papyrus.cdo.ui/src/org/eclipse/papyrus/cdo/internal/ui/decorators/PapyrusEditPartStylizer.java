/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.decorators;

import org.eclipse.emf.cdo.dawn.gmf.appearance.DawnAppearancer;
import org.eclipse.emf.cdo.dawn.gmf.appearance.DawnEditPartStylizer;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.ui.util.DisplayUtils;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.SharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This is the PapyrusEditPartStylizer type. Enjoy.
 */
abstract class PapyrusEditPartStylizer
		extends DawnEditPartStylizer {

	public PapyrusEditPartStylizer() {
		super();
	}

	@Override
	public Image getImage(Object element, DawnState state) {
		Image result;

		switch (state) {
			case LOCKED_LOCALLY :
				result = SharedImages
					.getImage(Activator.ICON_SELF_LOCKED_OVERLAY24);
				break;
			case LOCKED_REMOTELY :
				result = SharedImages
					.getImage(Activator.ICON_OTHER_LOCKED_OVERLAY24);
				break;
			case CONFLICT :
				result = SharedImages
					.getImage(Activator.ICON_CONFLICTED_OVERLAY24);
				break;
			default :
				result = super.getImage(element, state);
				break;
		}

		return result;
	}

	@Override
	public void setDefault(EditPart editPart) {
		setState(editPart, DawnState.CLEAN);
	}

	@Override
	public void setLocked(EditPart editPart, int type) {
		DawnState state;

		switch (type) {
			case DawnAppearancer.TYPE_LOCKED_GLOBALLY :
				state = DawnState.LOCKED_REMOTELY;
				break;
			case DawnAppearancer.TYPE_LOCKED_LOCALLY :
				state = DawnState.LOCKED_LOCALLY;
				break;
			default :
				state = DawnState.LOCKED_REMOTELY;
				break;
		}

		setState(editPart, state);
	}

	@Override
	public void setConflicted(EditPart editPart, int type) {
		setState(editPart, DawnState.CONFLICT);
	}

	protected void setState(final EditPart editPart, DawnState state) {
		View view = (View) editPart.getModel();

		CDOStateAdapter.setState(view, state);

		// post refresh of the edit-part later to let the decorator catch up
		DisplayUtils.getDisplay().asyncExec(new Runnable() {

			public void run() {
				editPart.refresh();
			}
		});
	}
}
