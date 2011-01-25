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
package org.eclipse.papyrus.properties.runtime.preferences.ui;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


public class PreferencesDialog extends TrayDialog {

	public PreferencesDialog(Shell parent) {
		super(parent);
	}

	@Override
	public void create() {
		super.create();
		super.getShell().setText("Preferences");

		Label label = new Label(getDialogArea(), SWT.NONE);
		label.setText("Contexts : ");

		final ConfigurationManager configurationManager = ConfigurationManager.instance;

		contextState.init();

		for(Context context : configurationManager.getContexts()) {
			boolean applied = configurationManager.isApplied(context);
			Button checkbox = new Button(getDialogArea(), SWT.CHECK);
			checkbox.setText(getLabel(context));
			checkbox.setSelection(applied);
			final Context theContext = context;
			contextState.setContextState(theContext, applied);

			checkbox.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					contextState.setContextState(theContext, ((Button)e.widget).getSelection());
				}

				public void widgetDefaultSelected(SelectionEvent e) {
					//Nothing
				}

			});
		}

		//		Button setDefaults = new Button(getDialogArea(), SWT.PUSH);
		//		setDefaults.setText("Set default values");
		//		setDefaults.addSelectionListener(new SelectionListener() {
		//
		//			public void widgetSelected(SelectionEvent e) {
		//				contextState.setDefaults();
		//			}
		//
		//			public void widgetDefaultSelected(SelectionEvent e) {
		//				//Nothing
		//			}
		//
		//		});

		getShell().pack();
	}

	private String getLabel(Context context) {
		return context.getName() + " (" + (ConfigurationManager.instance.isPlugin(context) ? "plugin" : "custom") + ")";
	}

	@Override
	protected void okPressed() {
		contextState.saveContext();
		super.okPressed();
	}

	@Override
	protected Composite getDialogArea() {
		return (Composite)super.getDialogArea();
	}

	@Override
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE;
	}

	private final ContextState contextState = new ContextState();

	private class ContextState {

		public ContextState() {
		}

		public void init() {
			contexts.clear();
		}

		public void setContextState(Context context, boolean applied) {
			contexts.put(context, applied);
		}

		public void saveContext() {
			for(Entry<Context, Boolean> entry : contexts.entrySet()) {
				if(entry.getValue())
					ConfigurationManager.instance.enableContext(entry.getKey());
				else
					ConfigurationManager.instance.disableContext(entry.getKey());
			}
		}

		private Map<Context, Boolean> contexts = new HashMap<Context, Boolean>();
	}
}
