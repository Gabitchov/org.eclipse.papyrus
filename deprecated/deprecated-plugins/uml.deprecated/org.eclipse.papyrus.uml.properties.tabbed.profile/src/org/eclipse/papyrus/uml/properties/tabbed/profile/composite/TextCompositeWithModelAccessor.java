/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.tabbed.profile.composite;

import org.eclipse.uml2.uml.Element;

/**
 * Simple implementation of the {@link SimpleTextComposite} class, using a specified model accessor
 * to read and modify the model
 */
public class TextCompositeWithModelAccessor extends SimpleTextComposite {

	/** model accessor to use with this composite */
	private StringModelAccessor accessor;

	/**
	 * Creates a new TextCompositeWithModelAccessor.
	 * 
	 * @param label
	 *            the label to display before the text
	 * @param accessor
	 *            the model accessor to use with this composite
	 */
	public TextCompositeWithModelAccessor(String label, StringModelAccessor accessor) {
		super(label);
		assert (accessor != null) : "Accessor should not be null for this composite";
		this.accessor = accessor;
	}

	/**
	 * Creates a new TextCompositeWithModelAccessor.
	 * 
	 * @param label
	 *            the label to display before the text
	 * @param featureID
	 *            the id of the feature to modify
	 */
	public TextCompositeWithModelAccessor(String label, int featureID) {
		super(label);
		this.accessor = new StringPropertyModelAccessor(featureID);
		assert (accessor != null) : "Accessor should not be null for this composite";
	}

	@Override
	public String getTextFromModel(Element element) {
		return accessor.getTextFromModel(element);
	}

	@Override
	public void setModelFromText(Element element, String newValue) {
		accessor.setModelFromText(element, newValue);
	}

}
