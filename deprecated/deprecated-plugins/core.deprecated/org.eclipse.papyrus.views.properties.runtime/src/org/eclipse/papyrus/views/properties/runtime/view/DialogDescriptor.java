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
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.IBindingLabelProviderDescriptor;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.IConstraintDescriptor;
import org.eclipse.swt.graphics.Image;
import org.w3c.dom.Node;

/**
 * Descriptor for dialogs
 */
public class DialogDescriptor extends AbstractConstrainedDescriptor {

	/** list of FragmentDescriptor created by this dialog */
	protected List<IFragmentDescriptor> fragmentDescriptors;

	/** title for the dialog */
	protected Object title;

	/** message for the dialog */
	protected Object message;

	/** list of identifier of replaced dialogs */
	protected List<String> replacedDialogIds;

	/**
	 * Creates a new DialogDescriptor.
	 * 
	 * @param id
	 *        identifier of this dialog descriptor
	 * @param constraints
	 *        the list of constraints for this dialog
	 * @param contentNode
	 *        the unparsed node describing the content of the dialog
	 * @param selectionSize
	 *        size of the selection for which this dialog is valid
	 * @param replacedDialogIds
	 *        the list of replaced ids for the dialog
	 * @param title
	 *        the title of the dialog (either a simple String or a {@link IBindingLabelProviderDescriptor}
	 * @param message
	 *        the message of the dialog (either a simple String or a {@link IBindingLabelProviderDescriptor}
	 * @param parser
	 *        the parser used to parse the content node
	 */
	public DialogDescriptor(String id, List<IConstraintDescriptor> constraints, Node contentNode, int selectionSize, List<String> replacedDialogIds, Object title, Object message, PropertyViewProviderParser parser) {
		super(id, constraints, contentNode, selectionSize, parser);
		this.replacedDialogIds = replacedDialogIds;
		this.title = title;
		this.message = message;
	}

	/**
	 * Returns the list of identifier of fragment descriptors
	 * 
	 * @return the list of identifier of fragment descriptors
	 */
	public List<IFragmentDescriptor> getFragmentDescriptors() {
		if(unparsed) {
			if(parser == null) {
				fragmentDescriptors = Collections.emptyList();
				Activator.log.error("No parser was given to the fragment descriptor " + id, null);
				parseFailed = true;
			} else {
				try {
					fragmentDescriptors = parser.parseDialogContentNode(contentNode);
					parseFailed = false;
				} catch (XMLParseException e) {
					Activator.log.error(e);
					parseFailed = true;
				}
			}
		}
		return fragmentDescriptors;
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

	/**
	 * Returns the identifier of replaced dialogs
	 * 
	 * @return the identifier of replaced dialogs
	 */
	public List<String> getReplacedDialogIds() {
		return replacedDialogIds;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getText() {
		return "DialogDescriptor";
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public IState createState(boolean readOnly) {
		return null;
	}
}
