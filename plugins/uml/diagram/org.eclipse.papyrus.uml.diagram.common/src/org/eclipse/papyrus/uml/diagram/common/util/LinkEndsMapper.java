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

package org.eclipse.papyrus.uml.diagram.common.util;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Connector;

/**
 * 
 * A utils class to map links, with their sources and targets OR with ends, when source/target have no sense for the link (example for
 * {@link Connector})
 * 
 */
public class LinkEndsMapper {

	/**
	 * the link
	 */
	private final EObject link;

	/**
	 * the ends of the links
	 */
	private final Collection<?> ends;

	/**
	 * the targets of the links
	 */
	private final Collection<?> targets;

	/**
	 * the sources of the links
	 */
	private final Collection<?> sources;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the represented link
	 * @param ends
	 *        the ends for this link (could be <code>null</code>)
	 * @param sources
	 *        the sources for this link (could be <code>null</code>)
	 * @param targets
	 *        the targets for this link (could be <code>null</code>)
	 */
	public LinkEndsMapper(final EObject link, final Collection<?> ends, final Collection<?> sources, final Collection<?> targets) {
		this.link = link;
		this.ends = ends;
		this.targets = targets;
		this.sources = sources;
	}

	/**
	 * 
	 * @return
	 *         the link represented by the instance of this class
	 */
	public EObject getLink() {
		return link;
	}

	/**
	 * 
	 * @return
	 *         the ends for the links
	 */
	public Collection<?> getEnds() {
		return ends;
	}

	/**
	 * 
	 * @return
	 *         the targets for the links
	 */
	public Collection<?> getTargets() {
		return targets;
	}

	/**
	 * 
	 * @return
	 *         the sources for the link
	 */
	public Collection<?> getSources() {
		return sources;
	}


}
