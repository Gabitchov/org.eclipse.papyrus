/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.modelexplorer.widgets;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.widgets.providers.IHierarchicContentProvider;


/**
 * this is a content provider on which we can filter wanted meta-classes
 * So the method is valid has to take in account the list of metaclasses
 */
public interface IMetaclassFilteredContentProvider extends
		IHierarchicContentProvider {
	/**
	 * set the list of meta-classes that we do not want to display.
	 *  It could be interesting to look for a kind of metaclasses without sub metaclasses.
	 * @param metaClassNotWanted list of metaclasses that are not wanted
	 * 
	 */
	public void setMetaClassNotWanted(List<Object> metaClassNotWanted);
	/**
	 * a the kind of metaclasses wanted
	 * @param metaClassWanted
	 */
	public void setMetaClassWanted(Object metaClassWanted);
}
