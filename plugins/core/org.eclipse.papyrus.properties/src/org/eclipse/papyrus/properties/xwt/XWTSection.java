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
package org.eclipse.papyrus.properties.xwt;

import java.util.Iterator;

import org.eclipse.core.databinding.observable.ChangeEvent;
import org.eclipse.core.databinding.observable.IChangeListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.properties.Activator;
import org.eclipse.papyrus.properties.constraints.Constraint;
import org.eclipse.papyrus.properties.contexts.ConstraintDescriptor;
import org.eclipse.papyrus.properties.contexts.Section;
import org.eclipse.papyrus.properties.contexts.View;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.modelelement.DataSourceFactory;
import org.eclipse.papyrus.properties.runtime.ConstraintFactory;
import org.eclipse.papyrus.properties.runtime.DisplayEngine;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * An Implementation of ISection for the TabbedPropertyView framework.
 * The XWTSection uses an XWT File to display the SWT Controls, and
 * a DataSource for DataBinding
 * 
 * @author Camille Letavernier
 */
public class XWTSection extends AbstractPropertySection implements IChangeListener {

	private Section section;

	private DataSource source;

	private View view;

	private Composite self;

	private DisplayEngine display;

	/**
	 * Constructor.
	 * 
	 * @param section
	 *        The Section object containing the Metadata for the XWTSection
	 * @param view
	 *        The view this section belongs to
	 * @param display
	 *        The display engine that will generate the SWT Controls
	 */
	public XWTSection(Section section, View view, DisplayEngine display) {
		this.section = section;
		this.view = view;
		this.display = display;
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		self = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout(1, false);
		layout.marginHeight = 1;
		self.setLayout(layout);

		layout = new GridLayout(1, false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		parent.setLayout(layout);

		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false);
		self.setLayoutData(data);

		self.setBackground(parent.getBackground());
		self.setBackgroundMode(SWT.INHERIT_DEFAULT);
	}

	@Override
	public void setInput(IWorkbenchPart part, ISelection selection) {
		if(selection == getSelection())
			return;

		super.setInput(part, selection);

		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;

			setSource(DataSourceFactory.instance.createDataSourceFromSelection(structuredSelection, view));
		}
	}

	private void setSource(DataSource source) {
		if(this.source != null)
			this.source.removeChangeListener(this);

		this.source = source;

		if(section.getConstraints().size() > 0) {
			source.addChangeListener(this);
		}
	}

	/**
	 * Displays the section
	 * 
	 * @param refresh
	 *        If true, and the section has already been displayed, the controls will be
	 *        regenerated. If false, the section will only be displayed if it hasn't been
	 *        displayed yet, or if the display engine allows duplication of sections
	 */
	public void display(boolean refresh) {
		if(self.isDisposed()) {
			Activator.log.debug("Error : widget is disposed"); //$NON-NLS-1$
			dispose();
			return;
		}

		if(!isApplied()) {
			hide();
			return;
		}

		if(refresh) {
			display.refreshSection(self, section, source);
		} else {
			display.createSection(self, section, source);
		}
	}

	private void hide() {
		display.removeSection(self);
	}

	@Override
	public void refresh() {
		display(false);
	}

	/**
	 * Tests if this section is applied. A section is applied if it doesn't have
	 * any constraint, or if at least one of its constraints match the current selection
	 * 
	 * @return
	 *         True if the section should be displayed
	 */
	protected boolean isApplied() {
		if(section.getConstraints().isEmpty()) {
			return true;
		}

		ISelection selection = getSelection();

		if(selection instanceof IStructuredSelection) {
			Iterator<?> it = ((IStructuredSelection)selection).iterator();
			while(it.hasNext()) {
				Object element = it.next();
				for(ConstraintDescriptor constraintDescriptor : section.getConstraints()) {
					Constraint constraint = ConstraintFactory.getInstance().createFromModel(constraintDescriptor);
					if(constraint.match(element)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public void dispose() {
		if(source != null)
			source.removeChangeListener(this);
		super.dispose();
	}

	@Override
	public String toString() {
		return "XWTSection : " + section.getName(); //$NON-NLS-1$
	}

	public void handleChange(ChangeEvent event) {
		display(true);
	}

}
