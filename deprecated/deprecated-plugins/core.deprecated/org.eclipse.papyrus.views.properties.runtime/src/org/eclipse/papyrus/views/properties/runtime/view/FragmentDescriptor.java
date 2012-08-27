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
package org.eclipse.papyrus.views.properties.runtime.view;

import java.util.Collections;
import java.util.List;

import org.eclipse.papyrus.views.properties.runtime.Activator;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptor;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Node;


/**
 * descriptor for fragments
 */
public class FragmentDescriptor extends AbstractConstrainedDescriptor implements IFragmentDescriptor {

	/** list of containers created by this dialog */
	protected List<ContainerDescriptor> descriptors;

	/**
	 * Creates a new FragmentDescriptor.
	 * 
	 * @param id
	 *        the identifier of the fragment
	 * @param constraints
	 *        the list of constraints to be verified when the fragment is to be displayed
	 * @param descriptors
	 *        list of containers in this fragment
	 * @param selectionSize
	 *        the size of the selection for which this fragment is valid
	 */
	public FragmentDescriptor(String id, List<IConstraintDescriptor> constraints, List<ContainerDescriptor> descriptors, int selectionSize) {
		super(id, constraints, selectionSize);
		this.descriptors = descriptors;
	}

	/**
	 * Creates a new FragmentDescriptor.
	 * 
	 * @param id
	 *        the identifier of the fragment
	 * @param constraints
	 *        the list of constraints to be verified when the fragment is to be displayed
	 * @param contentNode
	 *        the node configuring this fragment descriptor
	 * @param selectionSize
	 *        the size of the selection for which this fragment is valid
	 * @param parser
	 *        the parser used to parse the configuration node
	 */
	public FragmentDescriptor(String id, List<IConstraintDescriptor> constraints, Node contentNode, int selectionSize, PropertyViewProviderParser parser) {
		super(id, constraints, contentNode, selectionSize, parser);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ContainerDescriptor> getContainerDescriptors() {
		if(unparsed && !parseFailed) {
			if(parser == null) {
				descriptors = Collections.emptyList();
				Activator.log.error("No parser was given to the view descriptor " + id, null);
				parseFailed = true;
			} else {
				try {
					descriptors = parser.parseFragmentContentNode(contentNode);
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
	 * {@inheritDoc}
	 */
	public String getText() {
		return "Fragment: " + getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return Activator.getImage("/icons/Fragment.gif");
	}

	/**
	 * {@inheritDoc}
	 */
	public FragmentDescriptorState createState(boolean readOnly) {
		return new FragmentDescriptorState(this, readOnly);
	}

}
