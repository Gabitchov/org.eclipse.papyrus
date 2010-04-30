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
import org.eclipse.papyrus.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.papyrus.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.papyrus.properties.runtime.view.content.ContainerDescriptor;
import org.w3c.dom.Node;

/**
 * Descriptor for dialogs
 */
public class DialogDescriptor extends AbstractConstrainedDescriptor {

	/** list of ViewDescriptor created by this dialog */
	protected List<String> viewDescriptorsIds;

	/** title for the dialog */
	protected Object title;

	/** message for the dialog */
	protected Object message;

	/**
	 * Creates a new DialogDescriptor.
	 */
	public DialogDescriptor(String id, List<IConstraintDescriptor> constraints, List<ContainerDescriptor> descriptors) {
		super(id, constraints);
	}

	/**
	 * Creates a new DialogDescriptor.
	 */
	public DialogDescriptor(String id, List<IConstraintDescriptor> constraints, Node contentNode, Object title, Object message, PropertyViewProviderParser parser) {
		super(id, constraints, contentNode, parser);
		this.title = title;
		this.message = message;
	}

	/**
	 * Returns the list of identifier of view descriptors
	 * 
	 * @return the list of identifier of view descriptors
	 */
	public List<String> getContainerDescriptors() {
		if(unparsed) {
			if(parser == null) {
				viewDescriptorsIds = Collections.emptyList();
				Activator.log.error("No parser was given to the view descriptor " + id, null);
				parseFailed = true;
			} else {
				try {
					viewDescriptorsIds = parser.parseDialogContentNode(contentNode);
					parseFailed = false;
				} catch (XMLParseException e) {
					Activator.log.error(e);
					parseFailed = true;
				}
			}
		}
		return viewDescriptorsIds;
	}

	/**
	 * 
	 * Returns the title object, either a {@link String} or a {@link IBindingLabelProviderDescriptor}
	 * 
	 * @return the title object, either a string or a message binding descriptor
	 */
	public Object getTitle() {
		return title;
	}

	/**
	 * 
	 * Returns the message object, either a {@link String} or a {@link IBindingLabelProviderDescriptor}
	 * 
	 * @return the message object, either a string or a message binding descriptor
	 */
	public Object getMessage() {
		return message;
	}
}
