/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Arthur Daussy (Atos) - Initial API and implementation
 *   Arthur Daussy - 371712 : 372745: [ActivityDiagram] Major refactoring group framework
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.activitygroup.ui;

import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.papyrus.uml.diagram.activity.activitygroup.editpolicy.notifiers.IGroupNotifier;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * Composite used to notify user of new visual child
 */
public class IntegrateViewToConfigureComposite extends Composite {

	/**
	 * 
	 */
	private Table table;

	/**
	 * 
	 */
	private CheckboxTableViewer checkboxTableViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public IntegrateViewToConfigureComposite(Composite parent, int style, List<IGroupNotifier> newChildren, String label) {
		super(parent, style);
		setLayout(new GridLayout(1, false));
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setText(label);
		checkboxTableViewer = CheckboxTableViewer.newCheckList(this, SWT.FULL_SELECTION);
		table = checkboxTableViewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		checkboxTableViewer.setContentProvider(new ArrayContentProvider());
		checkboxTableViewer.setLabelProvider(new GroupNotifierLabelProvider());
		checkboxTableViewer.setInput(newChildren);
		checkboxTableViewer.setAllChecked(true);
	}

	@Override
	protected void checkSubclass() {
	}

	public Iterable<IGroupNotifier> getSelectedNotifier() {
		Object[] selection = checkboxTableViewer.getCheckedElements();
		Iterable<Object> groupNotifiers = Iterables.filter(Lists.newArrayList(selection), Predicates.instanceOf(IGroupNotifier.class));
		return Iterables.transform(groupNotifiers, new Function<Object, IGroupNotifier>() {

			public IGroupNotifier apply(Object arg0) {
				return (IGroupNotifier)arg0;
			}
		});
	}
}
