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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.query;

import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.query.CreateQueryWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.ICommandWidget;


/**
 * @see CreateQueryWidget
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICreateQueryWidget extends ICommandWidget {

	Object getCreateQueryWidget();

	boolean isCanBeCached();

	boolean isHasSideEffect();
}