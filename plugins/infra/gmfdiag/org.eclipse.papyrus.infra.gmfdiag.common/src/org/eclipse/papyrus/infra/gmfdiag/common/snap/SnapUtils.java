/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.SWT;


public class SnapUtils {

	private SnapUtils() {
		//to prevent instanciation
	}

	/**
	 * Key modifier for centered resizing. It's ALT on the Mac and MOD1 on all
	 * other platforms.
	 */
	public static final int MODIFIER_CENTERED_RESIZE;

	static {
		if(Platform.OS_MACOSX.equals(Platform.getOS())) {
			MODIFIER_CENTERED_RESIZE = SWT.ALT;
		} else {
			MODIFIER_CENTERED_RESIZE = SWT.MOD1;
		}
	}

	/**
	 * Key modifier for constrained resizing. It's SHIFT on all platforms.
	 */
	public static final int MODIFIER_CONSTRAINED_RESIZE = SWT.SHIFT;
	
	/**
	 * Key modifier for ignoring snap while dragging. It's CTRL on Mac, and ALT
	 * on all other platforms.
	 */
	public static final int MODIFIER_NO_SNAPPING;

	static {
		if (Platform.OS_MACOSX.equals(Platform.getOS())) {
			MODIFIER_NO_SNAPPING = SWT.CTRL;
		} else {
			MODIFIER_NO_SNAPPING = SWT.ALT;
		}
	}

}
