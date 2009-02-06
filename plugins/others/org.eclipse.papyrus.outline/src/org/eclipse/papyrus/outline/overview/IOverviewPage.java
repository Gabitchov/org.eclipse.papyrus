/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 * 
 * $Id$
 **********************************************************************/
package org.eclipse.papyrus.outline.overview;

import org.eclipse.ui.part.IPageBookViewPage;

/**
 * An interface representing a page to be used in the Overview.
 * IOverviewPage.class is passed as the argument to the getAdapter(Object)
 * method of a GEF-based editor to retrieve the page to be displayed in the
 * Overview.
 * 
 * @author Jacques Lescot
 */
public interface IOverviewPage extends IPageBookViewPage {

}
