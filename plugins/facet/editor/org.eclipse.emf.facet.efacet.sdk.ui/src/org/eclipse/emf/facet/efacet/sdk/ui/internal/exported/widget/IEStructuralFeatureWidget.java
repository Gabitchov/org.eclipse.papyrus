/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget;


/**
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IEStructuralFeatureWidget extends IDerivedTypedElementWidget {

	boolean isTransient();

	void setTransient(boolean value);

	boolean isVolatile();

	void setVolatile(boolean value);

	boolean isChangeable();

	void setChangeable(boolean value);

	boolean isDerived();

	void setDerived(boolean value);
}
