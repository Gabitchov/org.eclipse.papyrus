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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.core.utils.PapyrusImageUtils;
import org.eclipse.papyrus.ui.toolbox.notification.ICompositeCreator;
import org.eclipse.papyrus.ui.toolbox.notification.NotificationRunnable;
import org.eclipse.papyrus.ui.toolbox.notification.PapyrusToolkit;
import org.eclipse.papyrus.ui.toolbox.notification.builders.IContext;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * A papyrus Popup
 * 
 * @author tristan faure
 * 
 */
public abstract class PapyrusPopup extends Dialog {

	protected FormToolkit toolkit;

	protected boolean useHtml = false;

	protected IContext context = new IContext.Context();

	protected Collection<NotificationRunnable> runnables = new LinkedList<NotificationRunnable>();

	protected Map<Integer, NotificationRunnable> mapForIds = new HashMap<Integer, NotificationRunnable>();

	/**
	 * Used to custom the composite inside the popup
	 */
	protected ICompositeCreator creator = null;

	private String title;

	public PapyrusPopup(Shell parentShell, FormToolkit toolkit) {
		super(parentShell);
		this.toolkit = toolkit;
	}


	@Override
	protected Control createDialogArea(Composite parent) {
		getShell().setText(title == null ? "" : title);
		getShell().setImage(PapyrusImageUtils.getDefaultIcon());
		Composite c = (Composite)super.createDialogArea(parent);
		c.setLayout(new FillLayout());
		createForm(c);
		return c;
	}


	/**
	 * Creates a form and a section
	 * override this method to avoid form creation
	 * 
	 * @param c
	 *        , the composite container
	 */
	protected void createForm(Composite c) {
		ScrolledForm form = toolkit.createScrolledForm(c);
		//		form.getBody().setLayoutData(new GridData(GridData.FILL_BOTH));
		form.getBody().setLayout(new GridLayout());
		toolkit.decorateFormHeading(form.getForm());
		createSection(c, form);
		c.setLayoutData(new GridData(GridData.FILL_BOTH));
	}


	/**
	 * Creates a section
	 * override this method to avoid section creation
	 * 
	 * @param c
	 *        , the composite container of the form
	 * @param form
	 *        , the form container
	 */
	protected void createSection(Composite c, ScrolledForm form) {
		Section section = toolkit.createSection(form.getBody(), PapyrusToolkit.DEFAULT_STYLE);
		section.setText("Papyrus");
		if(creator != null && c instanceof Composite) {
			Composite createComposite = creator.createComposite(section, toolkit);
			section.setClient(createComposite);
			context.put(IContext.COMPOSITE_CREATED, createComposite);
			getShell().setFocus();
		} else {
			section.setClient(doCreateContents(section));
			getShell().setFocus();
		}
		section.setLayoutData(new GridData(GridData.FILL_BOTH));
	}

	/**
	 * @param runnable
	 */
	public void addRunnable(NotificationRunnable runnable) {
		runnables.add(runnable);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		if(runnables != null && !runnables.isEmpty()) {
			int START_AFTER_CANCEL = 2;
			for(final NotificationRunnable r : runnables) {
				createButton(parent, START_AFTER_CANCEL, r.getLabel(), START_AFTER_CANCEL == 2);
				mapForIds.put(START_AFTER_CANCEL, r);
				START_AFTER_CANCEL++;
			}
		} else {
			createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		}
	}



	@Override
	protected void buttonPressed(int buttonId) {
		if(buttonId != IDialogConstants.OK_ID && buttonId != IDialogConstants.CANCEL_ID) {
			NotificationRunnable run = mapForIds.get(buttonId);
			if(run == null) {
				super.buttonPressed(buttonId);
			} else {
				run.run(context);
				// retrieve the return code according to the context if it is set
				Object contextCode = context.get(IContext.ACTION_ID);
				if(contextCode != null && contextCode instanceof Integer) {
					setReturnCode((Integer)contextCode);
				}
			}
		} else {
			super.buttonPressed(buttonId);
		}
		close();
	}

	/**
	 * @param runnable
	 */
	public void addRunnables(Collection<NotificationRunnable> runnable) {
		runnables.addAll(runnable);
	}

	protected abstract Control doCreateContents(Composite composite);

	public void setCompositeCreator(ICompositeCreator creator) {
		this.creator = creator;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the bounds.
	 * 
	 * @return the bounds
	 */
	public static Rectangle getBounds() {
		Display display = Display.getDefault();
		Rectangle bounds = display.getPrimaryMonitor().getBounds();
		Rectangle result = new Rectangle(bounds.x + bounds.width / 4, bounds.y + bounds.height / 4, bounds.width / 2, bounds.height / 2);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.window.Window#getConstrainedShellBounds(org.eclipse.swt.graphics.Rectangle)
	 */
	@Override
	protected Rectangle getConstrainedShellBounds(Rectangle preferredSize) {
		//		return getBounds();
		return super.getConstrainedShellBounds(preferredSize);
	}

	public void setUseHtml(boolean useHtml) {
		this.useHtml = useHtml;
	}

	public boolean isUseHtml() {
		return useHtml;
	}

}
