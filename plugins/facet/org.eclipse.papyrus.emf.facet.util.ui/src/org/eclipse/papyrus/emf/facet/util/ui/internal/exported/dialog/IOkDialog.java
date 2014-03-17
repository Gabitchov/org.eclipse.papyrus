/** 
 * Copyright (c) Soft-Maint.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 		Thomas Cicognani (Soft-Maint) - Bug 406565 - Ok Dialog
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog;


/**
 * 
 * @author tcicognani
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 0.4
 */
public interface IOkDialog {
	
	void commit();

	boolean isInformation();
	
	boolean isWarning();
	
	boolean isError();

}
