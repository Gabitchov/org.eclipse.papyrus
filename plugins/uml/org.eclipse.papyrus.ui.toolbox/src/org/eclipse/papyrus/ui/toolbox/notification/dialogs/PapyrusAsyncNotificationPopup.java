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
package org.eclipse.papyrus.ui.toolbox.notification.dialogs;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;

/**
 * This popup creates an async notification
 * 
 * @author tristan faure
 * 
 */
public class PapyrusAsyncNotificationPopup extends AbstractNotificationPopup {

	protected String text;

	protected String title;

	protected IContext context = new IContext.Context();

	private Collection<NotificationRunnable> runnables = new LinkedList<NotificationRunnable>();

	public PapyrusAsyncNotificationPopup(Display display, FormToolkit toolkit) {
		super(display, toolkit);
	}

	@Override
	protected void createContentArea(Composite parent) {
		super.createContentArea(parent);
		doCreateClient(parent);
		doCreateActionSection(parent);
	}

	protected void doCreateActionSection(Composite parent) {
		Composite compo = toolkit.createComposite(parent);
		compo.setLayoutData(new GridData(GridData.END, GridData.END, true, false, 1, 1));
		compo.setLayout(new FillLayout(SWT.HORIZONTAL));
		createRunnables(compo);
	}

	protected void createRunnables(Composite compo) {
		if(!runnables.isEmpty()) {
			boolean first = true;
			for(final NotificationRunnable r : runnables) {
				if(!first) {
					toolkit.createLabel(compo, " ");
				}
				Hyperlink h = toolkit.createHyperlink(compo, r.getLabel() == null ? "run" : r.getLabel(), SWT.NONE);
				h.addHyperlinkListener(new HyperlinkAdapter() {

					@Override
					public void linkActivated(HyperlinkEvent e) {
						run(r);
					}
				});
				first = false;
			}
		}
	}

	protected void setCompositeCreated(Composite c) {
		context.put(IContext.COMPOSITE_CREATED, c);
	}

	protected void run(NotificationRunnable r) {
		if(r != null) {
			r.run(context);
		}
	}

	protected void doCreateClient(Composite parent) {
		Label label = new Label(parent, SWT.None);
		label.setText(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addRunnable(NotificationRunnable runnable) {
		runnables.add(runnable);
	}

	public void addAllRunnable(Collection<NotificationRunnable> runnable) {
		runnables.addAll(runnable);
	}

	@Override
	protected String getPopupShellTitle() {
		if(title == null) {
			return super.getPopupShellTitle();
		}
		return title;
	}

}
