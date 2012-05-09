/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import org.eclipse.papyrus.infra.widgets.creation.StringEditionFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.papyrus.infra.widgets.selectors.StandardSelector;
import org.eclipse.papyrus.infra.widgets.selectors.StringSelector;
import org.eclipse.swt.widgets.Composite;


/**
 * An editor for multivalued String attributes
 * 
 * @author Camille Letavernier
 * 
 */
public class MultipleStringEditor extends MultipleValueEditor {

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 */
	public MultipleStringEditor(Composite parent, int style) {
		super(parent, style, new StringSelector());
		init();
	}

	public MultipleStringEditor(Composite parent, int style, boolean multiline) {
		super(parent, style, new StringSelector(multiline));
		init();
	}

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param ordered
	 *        Indicates if the values should be ordered. If true, the up/down controls will be activated
	 * @param unique
	 *        Indicates if the values should be unique.
	 */
	public MultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique) {
		super(parent, style, new StringSelector(), ordered, unique, null);
		init();
	}

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param ordered
	 *        Indicates if the values should be ordered. If true, the up/down controls will be activated
	 * @param unique
	 *        Indicates if the values should be unique.
	 * @param label
	 *        The editor's label
	 */
	public MultipleStringEditor(Composite parent, int style, boolean ordered, boolean unique, String label) {
		super(parent, style, new StringSelector(), ordered, unique, label);
		init();
	}

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param selector
	 *        The Element selector for the dialog's left-pane. Used to select values or enter new ones.
	 * @param ordered
	 *        Indicates if the values should be ordered. If true, the up/down controls will be activated
	 * @param unique
	 *        Indicates if the values should be unique.
	 * @param label
	 *        The editor's label
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector, boolean ordered, boolean unique, String label) {
		super(parent, style, selector, ordered, unique, label);
		init();
	}

	/**
	 * Constructs an Editor for multiple Integer values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param selector
	 *        The Element selector for the dialog's left-pane. Used to select values or enter new ones.
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector) {
		super(parent, style, selector);
		init();
	}

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param selector
	 *        The Element selector for the dialog's left-pane. Used to select values or enter new ones.
	 * @param label
	 *        The editor's label
	 */
	public MultipleStringEditor(Composite parent, int style, IElementSelector selector, String label) {
		super(parent, style, selector, label);
		init();
	}

	/**
	 * Constructs an Editor for multiple String values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 * 
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param label
	 *        The editor's label
	 */
	public MultipleStringEditor(Composite parent, int style, String label) {
		super(parent, style, new StringSelector(), label);
		init();
	}

	private void init() {
		setFactory(new StringEditionFactory());
	}

	public void setContentProvider(final IStaticContentProvider provider) {
		IElementSelector selector = new StandardSelector(StringCombo.class) {

			@Override
			public void createControls(Composite parent) {
				super.createControls(parent);
				((StringCombo)editor).setProviders(provider, null);
			}
		};
		setSelector(selector);
	}

}
