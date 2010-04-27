/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.runtime.view;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.properties.runtime.Activator;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.w3c.dom.Node;


/**
 * descriptor for views
 */
public class ViewDescriptor {

	/** id of the view */
	protected final String id;

	/** list of constraints that applies to the view (kind of manipulated element, etc) */
	protected final List<IConstraintDescriptor> constraints;

	/** list of containers created by this view */
	protected List<ContainerDescriptor> descriptors;

	/** unparsed content node */
	protected Node contentNode;

	/** boolean that indicates that the content node has not been parsed yet */
	protected boolean unparsed = false;

	/** indicates if the parsing of the content node failed. not used currently, here to handle errors in a better way */
	protected boolean parseFailed = false;

	/** parser of the content node */
	protected final PropertyViewProviderParser parser;

	/**
	 * Creates a new ViewDescriptor.
	 */
	public ViewDescriptor(String id, List<IConstraintDescriptor> constraints, List<ContainerDescriptor> descriptors) {
		this.id = id;
		this.constraints = constraints;
		this.descriptors = descriptors;
		this.parser = null;
	}

	/**
	 * Creates a new ViewDescriptor.
	 */
	public ViewDescriptor(String id, List<IConstraintDescriptor> constraints, Node contentNode, PropertyViewProviderParser parser) {
		this.id = id;
		this.constraints = constraints;
		this.contentNode = contentNode;
		this.parser = parser;
		unparsed = true;
	}

	/**
	 * Returns the id of the view
	 * 
	 * @return the id of the view
	 */
	public String getId() {
		return id;
	}

	/**
	 * Returns the list of containers descriptors
	 * 
	 * @return the list of containers descriptors
	 */
	public List<ContainerDescriptor> getContainerDescriptors() {
		if(unparsed) {
			if(parser == null) {
				descriptors = Collections.emptyList();
				Activator.log.error("No parser was given to the view descriptor " + id, null);
				parseFailed = true;
			} else {
				try {
					descriptors = parser.parseContentNode(contentNode);
					parseFailed = false;
				} catch (XMLParseException e) {
					Activator.log.error(e);
					parseFailed = true;
				}
			}
		}
		return descriptors;
	}

	/**
	 * Returns the list of containers descriptors
	 * 
	 * @return the list of containers descriptors
	 */
	public List<IConstraintDescriptor> getConstraintDescriptors() {
		return constraints;
	}

}
