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

import org.eclipse.papyrus.tabbedproperties.core.forms.AbstractControlsGroup;
import org.eclipse.papyrus.tabbedproperties.core.forms.InputTextControls;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Layout;

/**
 * UML Role (Property) editor.
 * 
 * @author dumoulin
 * 
 */
public class RoleFigure extends AbstractControlsGroup {

	private InputTextControls nameControl;

	private InputTextControls nameControl2;

	private AggregationKindFigure aggregationKind;

	private LabeledQualifiersFigure qualifiers;

	private VisibilityFigure visibility;

	private LabeledMultiplicityFigure multiplicity;

	/**
	 * @return the nameControl
	 */
	public InputTextControls getNameControl() {
		return nameControl;
	}

	/**
	 * @return the nameControl2
	 */
	public InputTextControls getNameControl2() {
		return nameControl2;
	}

	/**
	 * @return the visibility
	 */
	public VisibilityFigure getVisibility() {
		return visibility;
	}

	/**
	 * @return the aggregationKind
	 */
	public AggregationKindFigure getAggregationKind() {
		return aggregationKind;
	}

	/**
	 * @return the qualifiers
	 */
	public LabeledQualifiersFigure getQualifiers() {
		return qualifiers;
	}

	/**
	 * @return the multiplicity
	 */
	public LabeledMultiplicityFigure getMultiplicity() {
		return multiplicity;
	}

	@Override
	public void createDirectChildren() {
		System.out.println("RoleGroup.createControls()");
		nameControl = new InputTextControls("Role:", "");
		add(nameControl);
		nameControl2 = new InputTextControls("Name:", "");
		add(nameControl2);
		aggregationKind = new AggregationKindFigure("Kind:", "");
		add(aggregationKind);
		qualifiers = new LabeledQualifiersFigure("Qualifiers:", "");
		add(qualifiers);
		visibility = new VisibilityFigure("Visibility:", "");
		add(visibility);
		multiplicity = new LabeledMultiplicityFigure("Multiplicity:", "");
		add(multiplicity);

	}

	/**
	 * Create a vertical layout
	 */
	@Override
	public Composite createLocalControls(Composite parent) {

		// Remove style border to have no border.
		Composite composite = getWidgetFactory().createComposite(parent, SWT.BORDER);

		Layout layout = new FillLayout(SWT.VERTICAL);
		composite.setLayout(layout);
		// set a border
		return composite;
	}

	@Override
	public void initializeLocalControl() {
	}

	// /**
	// * Set the name
	// * @param name
	// */
	// public void setName(String name)
	// {
	// nameControl.setText(name);
	// }
	//    
	// /**
	// * Set the name
	// * @param name
	// */
	// public void setName2(String name)
	// {
	// nameControl2.setText(name);
	// }
}
