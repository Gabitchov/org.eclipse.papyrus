/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.profile.ui.compositeforview;

import org.eclipse.papyrus.profile.ImageManager;
import org.eclipse.papyrus.profile.tree.ProfileElementLabelProvider;
import org.eclipse.papyrus.profile.tree.objects.TreeObject;
import org.eclipse.swt.graphics.Image;

/**
 * The Class ProfileElementWithDisplayLabelProvider.
 */
public class ProfileElementWithDisplayLabelProvider extends ProfileElementLabelProvider {

	/**
	 * Gets the image.
	 * 
	 * @param object
	 *            the object
	 * 
	 * @return the image
	 */
	@Override
	public Image getImage(Object object) {

		if (object instanceof TreeObject) {

			TreeObject to = (TreeObject) object;
			if (to.isDisplay()) {
				return ImageManager.IMG_STEREOTYPEDISPLAYED;
			}
		}

		// else, Default case : no display
		return super.getImage(object);
	}
}
