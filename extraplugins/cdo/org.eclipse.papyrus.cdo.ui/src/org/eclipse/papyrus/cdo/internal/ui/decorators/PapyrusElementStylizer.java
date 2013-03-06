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
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.dawn.ui.stylizer.DawnDefaultElementStylizer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.SharedImages;
import org.eclipse.swt.graphics.Image;

/**
 * This is the PapyrusNodeEditPartStylizer type. Enjoy.
 */
public class PapyrusElementStylizer
		extends DawnDefaultElementStylizer {

	public PapyrusElementStylizer() {
		super();
	}

	@Override
	public Image getImage(Object element, DawnState state) {
		Image result;

		switch (state) {
			case LOCKED_LOCALLY :
				result = SharedImages
					.getImage(Activator.ICON_SELF_LOCKED_OVERLAY16);
				break;
			case LOCKED_REMOTELY :
				result = SharedImages
					.getImage(Activator.ICON_OTHER_LOCKED_OVERLAY16);
				break;
			case CONFLICT :
				result = SharedImages
					.getImage(Activator.ICON_CONFLICTED_OVERLAY16);
				break;
			default :
				result = super.getImage(element, state);
				break;
		}

		return result;
	}

	@Override
	public void setDefault(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			setState(eObject, DawnState.CLEAN);
		}
	}

	@Override
	public void setConflicted(Object element, final int type) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			setState(eObject, DawnState.CONFLICT);
		}
	}

	@Override
	public void setLocked(Object element, int type) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;

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

			setState(eObject, state);
		}
	}

	protected void setState(EObject object, DawnState state) {
		CDOStateAdapter.setState(object, state);
		CDOStateLabelDecorator.fireLabelUpdates();
	}
}
