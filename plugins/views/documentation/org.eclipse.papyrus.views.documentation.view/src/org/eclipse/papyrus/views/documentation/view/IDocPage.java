/*******************************************************************************
 * Copyright (c) 2005 AIRBUS FRANCE.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    David Sciamma (Anyware Technologies), Mathieu Garcia (Anyware Technologies),
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.documentation.view;

import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.part.IPageBookViewPage;

/**
 * This interface is used to define a page where the documentation about the
 * selected object can be filled.<br>
 * creation : 3 juin 2005
 * 
 * @author <a href="mailto:david@anyware-tech.com">David Sciamma</a>
 */
public interface IDocPage extends IPageBookViewPage, ISelectionListener
{
    // Just typed
}
