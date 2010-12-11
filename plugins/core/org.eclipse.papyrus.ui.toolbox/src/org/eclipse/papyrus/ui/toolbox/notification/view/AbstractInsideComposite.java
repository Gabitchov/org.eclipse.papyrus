/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan Faure (ATOS ORIGIN INTEGRATION) tristan.faure@atosorigin.com - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox.notification.view;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.eclipse.papyrus.ui.toolbox.notification.ICallBack;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * A composite contained in PapyrusNotificationView
 * 
 * @author tfaure
 */
public abstract class AbstractInsideComposite extends Composite {

	private final FormToolkit toolkit;

	private Section section;

	private Control previous;

	private Control after;

	private final ICallBack callback;

	protected IContext context = new IContext.Context();

	private Collection<NotificationRunnable> runnables;

	AbstractInsideComposite(ICallBack callback, ScrolledForm parent, FormToolkit toolkit, Collection<NotificationRunnable> collection) {
		super(parent.getBody(), SWT.NONE);
		this.callback = callback;
		this.toolkit = toolkit;
		this.runnables = collection;
		createContents();
	}

	private void createContents() {
		section = toolkit.createSection(this, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		section.setText(getSectionName() + " - " + new SimpleDateFormat("HH'h'mm'm'ss's'").format(new Date()));
		section.setLayout(new FillLayout());
		Composite compo = toolkit.createComposite(section);
		compo.setLayout(new GridLayout(1, false));
		Control control = doCreateContents(toolkit, compo);
		control.setLayoutData(new GridData(GridData.FILL_BOTH));
		createHyperLinkSection(compo);
		section.setClient(compo);
	}

	protected void createHyperLinkSection(Composite compo) {
		Composite compoHL = toolkit.createComposite(compo);
		compoHL.setLayout(new FillLayout());
		if(runnables != null && !runnables.isEmpty()) {
			for(final NotificationRunnable r : runnables) {
				Button b = toolkit.createButton(compoHL, r.getLabel() == null ? "run" : r.getLabel(), SWT.NONE);
				b.addSelectionListener(new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						run(r);
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						run(r);
					}
				});
			}
		} else {
			Button b = toolkit.createButton(compoHL, "close", SWT.NONE);
			b.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					close();
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					close();
				}
			});
		}
		compoHL.setLayoutData(new GridData(GridData.END, GridData.END, false, true, 1, 1));
	}

	protected void setCompositeCreated(Composite c) {
		context.put(IContext.COMPOSITE_CREATED, c);
	}

	/**
	 * Close the current Composite
	 */
	public void close() {
		callback.callBack(this);
	}

	public void run(NotificationRunnable r) {
		if(r != null) {
			r.run(context);
			close();
		}
	}

	public void runDefault() {
		if(runnables != null && !runnables.isEmpty()) {
			runnables.iterator().next().run(context);
		}
		close();
	}

	public void expand() {
		section.setExpanded(true);
	}

	public void collapse() {
		section.setExpanded(false);
	}

	protected abstract Control doCreateContents(FormToolkit toolkit, Composite composite);

	protected abstract String getSectionName();

	public void setAfter(Control after) {
		this.after = after;
	}

	public Control getAfter() {
		return after;
	}

	public void setPrevious(Control previous) {
		this.previous = previous;
	}

	public Control getPrevious() {
		return previous;
	}


}
