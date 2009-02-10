/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml2.figures;

//Start of user code for user imports
import org.eclipse.papyrus.tabbedproperties.core.forms.CheckBoxFigure;
import org.eclipse.papyrus.tabbedproperties.core.forms.ControlWrapper;
import org.eclipse.papyrus.tabbedproperties.core.forms.LabeledPropertyEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

//End of user code for user imports

/**
 * The LabeledPropertyQualifiers form
 * 
 */
public class LabeledPropertyQualifiersForm extends LabeledPropertyEditor {

	protected FeatureQualifiersForm featureQualifiers;

	/**
	 * @param label
	 */
	public LabeledPropertyQualifiersForm(String label, String description) {
		super(label, description);
	}

	@Override
	protected ControlWrapper createRightEditor(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		featureQualifiers = new FeatureQualifiersForm();
		return featureQualifiers;
	}

	/**
	 * @return the derived
	 */
	public CheckBoxFigure getDerived() {
		return featureQualifiers.getDerived();
	}

	/**
	 * @return the derivedUnion
	 */
	public CheckBoxFigure getDerivedUnion() {
		return featureQualifiers.getDerivedUnion();
	}

	/**
	 * @return the ordered
	 */
	public CheckBoxFigure getOrdered() {
		return featureQualifiers.getOrdered();
	}

	/**
	 * @return the readOnly
	 */
	public CheckBoxFigure getReadOnly() {
		return featureQualifiers.getReadOnly();
	}

	/**
	 * @return the statique
	 */
	public CheckBoxFigure getStatique() {
		return featureQualifiers.getStatique();
	}

	/**
	 * @return the unique
	 */
	public CheckBoxFigure getUnique() {
		return featureQualifiers.getUnique();
	}

}