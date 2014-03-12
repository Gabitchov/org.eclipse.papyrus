/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.infra.emf.nattable.registry;

import org.eclipse.papyrus.infra.widgets.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Image registry to use for EStructuralFeature
 */
public class EStructuralFeatureImageRegistry {

	/** paths for emf feature icons */
	private static final String LINK_ICON_PATH = "/icons/link.gif"; //$NON-NLS-1$

	private static final String LINK_UNIDIR_ICON_PATH = "/icons/link_unidir.gif"; //$NON-NLS-1$

	private static final String AGGREG_ICON_PATH = "/icons/aggreg.gif"; //$NON-NLS-1$

	private static final String AGGREG_UNIDIR_ICON_PATH = "/icons/aggreg_unidir.gif"; //$NON-NLS-1$

	private static final String INV_AGGREG_ICON_PATH = "/icons/inv_aggreg.gif"; //$NON-NLS-1$

	private static final String ATTRIBUTE_ICON_PATH = "/icons/attributes.gif"; //$NON-NLS-1$


	/**
	 * 
	 * @param path
	 *        a path
	 * @return
	 *         the image loaded from this path
	 */
	private static final Image getImage(final String path) {
		return Activator.getDefault().getImage(org.eclipse.papyrus.infra.emf.nattable.Activator.PLUGIN_ID, path);
	}

	/**
	 * 
	 * @return
	 *         the icon for link
	 */
	public static Image getLinkIcon() {
		return EStructuralFeatureImageRegistry.getImage(LINK_ICON_PATH);
	}

	/**
	 * 
	 * @return
	 *         the icon for unidirectional link
	 */
	public static Image getUnidirectionalLinkIcon() {
		return EStructuralFeatureImageRegistry.getImage(LINK_UNIDIR_ICON_PATH);
	}

	/**
	 * 
	 * @return
	 *         the icon for aggregation
	 */
	public static Image getInvAggregIcon() {
		return EStructuralFeatureImageRegistry.getImage(INV_AGGREG_ICON_PATH);
	}

	/**
	 * 
	 * @return
	 *         the icon for aggregation
	 */
	public static Image getAggregIcon() {
		return EStructuralFeatureImageRegistry.getImage(AGGREG_ICON_PATH);
	}

	/**
	 * 
	 * @return
	 *         the icon for unidirectional aggregation
	 */
	public static Image getUnidirectionalAggregIcon() {
		return EStructuralFeatureImageRegistry.getImage(AGGREG_UNIDIR_ICON_PATH);
	}

	/**
	 * 
	 * @return
	 *         the attribute icon
	 */
	public static Image getAttributeIcon() {
		return EStructuralFeatureImageRegistry.getImage(ATTRIBUTE_ICON_PATH);
	}
}
