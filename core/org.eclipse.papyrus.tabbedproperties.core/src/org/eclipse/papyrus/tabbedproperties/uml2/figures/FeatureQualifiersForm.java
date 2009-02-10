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
import org.eclipse.papyrus.tabbedproperties.core.forms.AbstractControlsGroup;
import org.eclipse.papyrus.tabbedproperties.core.forms.CheckBoxFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

//End of user code for user imports

/**
 * 
 * 
 * 
 */
public class FeatureQualifiersForm extends AbstractControlsGroup {

	protected CheckBoxFigure derived;

	protected CheckBoxFigure derivedUnion;

	protected CheckBoxFigure ordered;

	protected CheckBoxFigure readOnly;

	protected CheckBoxFigure statique;

	protected CheckBoxFigure unique;

	/**
     * 
     */
	@Override
	public void createDirectChildren() {
		derived = new CheckBoxFigure("isDerived");
		add(derived);
		derivedUnion = new CheckBoxFigure("isDerivedUnion");
		add(derivedUnion);
		ordered = new CheckBoxFigure("isOrdered");
		add(ordered);
		readOnly = new CheckBoxFigure("isReadOnly");
		add(readOnly);
		statique = new CheckBoxFigure("isStatique");
		add(statique);
		unique = new CheckBoxFigure("isUnique");
		add(unique);

	}

	/**
	 * Create the composite used to lay children.
	 */
	@Override
	public Composite createLocalControls(Composite parent) {
		Composite composite = getWidgetFactory().createComposite(parent);
		// Start of user code for create local controls
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.spacing = ITabbedPropertyConstants.HSPACE;
		composite.setLayout(layout);

		// End of user code for create local controls
		return composite;
	}

	/**
	 * @return the derived
	 */
	public CheckBoxFigure getDerived() {
		return derived;
	}

	/**
	 * @return the derivedUnion
	 */
	public CheckBoxFigure getDerivedUnion() {
		return derivedUnion;
	}

	/**
	 * @return the ordered
	 */
	public CheckBoxFigure getOrdered() {
		return ordered;
	}

	/**
	 * @return the readOnly
	 */
	public CheckBoxFigure getReadOnly() {
		return readOnly;
	}

	/**
	 * @return the statique
	 */
	public CheckBoxFigure getStatique() {
		return statique;
	}

	/**
	 * @return the unique
	 */
	public CheckBoxFigure getUnique() {
		return unique;
	}

}