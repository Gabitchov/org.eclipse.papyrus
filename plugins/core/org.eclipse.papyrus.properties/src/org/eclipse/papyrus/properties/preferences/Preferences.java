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
package org.eclipse.papyrus.properties.preferences;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.papyrus.properties.contexts.Context;
import org.eclipse.papyrus.properties.runtime.ConfigurationManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;


public class Preferences extends PreferencePage implements IWorkbenchPreferencePage {

	public void init(IWorkbench workbench) {
		//Nothing
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label label = new Label(self, SWT.NONE);
		label.setText("Contexts : ");

		final ConfigurationManager configurationManager = ConfigurationManager.instance;

		contextState.init();

		for(Context context : configurationManager.getContexts()) {
			boolean applied = configurationManager.isApplied(context);
			Button checkbox = new Button(self, SWT.CHECK);
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

			checkboxes.put(context, checkbox);
		}
		return null;
	}

	@Override
	public boolean performOk() {
		contextState.saveContext();
		return super.performOk();
	}

	@Override
	public void performApply() {
		contextState.saveContext();
	}

	@Override
	public void performDefaults() {
		for(Context context : ConfigurationManager.instance.getContexts()) {
			boolean applied = ConfigurationManager.instance.isPlugin(context);
			Button checkbox = checkboxes.get(context);
			if(checkbox != null)
				checkbox.setSelection(applied);

			contextState.setContextState(context, applied);
		}
	}

	private String getLabel(Context context) {
		return context.getName() + " (" + (ConfigurationManager.instance.isPlugin(context) ? "plugin" : "custom") + ")"; //$NON-NLS-1$ //$NON-NLS-4$
	}

	private final ContextState contextState = new ContextState();

	private Map<Context, Button> checkboxes = new HashMap<Context, Button>();

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
