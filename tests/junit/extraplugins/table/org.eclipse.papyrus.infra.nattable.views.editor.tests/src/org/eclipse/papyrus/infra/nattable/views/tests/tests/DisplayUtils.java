/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.views.tests.tests;

import org.eclipse.swt.widgets.Display;


public class DisplayUtils {


	private DisplayUtils() {
		//to prevent instanciation
	}

	/**
	 * a safe version of the call while(Display.getDefault().readAndDispatch());
	 */
	//FIXME move me in an upper plugin if i works fine
	public static void safeReadAndDispatch() {
		while(true) {
			boolean res = true;
			try {
				res = Display.getDefault().readAndDispatch();
			} catch (Exception e) {
				//nothing to do
			}
			if(res == false) {
				return;
			}
		}
	}


}
