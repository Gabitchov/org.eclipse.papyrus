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
package org.eclipse.papyrus.views.properties.preferences;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.messages.Messages;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationConflict;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
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

/**
 * The PreferencePage for the Papyrus Property View. Offers an UI to enable or disable
 * property view contexts.
 * 
 * @author Camille Letavernier
 */
public class Preferences extends PreferencePage implements IWorkbenchPreferencePage {

	private boolean changeOccured = false;

	public void init(IWorkbench workbench) {
		//Nothing
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite self = new Composite(parent, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label label = new Label(self, SWT.NONE);
		label.setText(Messages.Preferences_Contexts);

		final ConfigurationManager configurationManager = ConfigurationManager.instance;

		contextState.init();

		//Only customizable Property view contexts should appear here
		List<Context> contexts = new java.util.ArrayList<Context>(configurationManager.getCustomizableContexts());
		contexts.addAll(configurationManager.getMissingContexts());
		
		for(Context context : contexts) {
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

		changeOccured = false;
		return null;
	}

	@Override
	public boolean performOk() {
		return contextState.saveContext() && super.performOk();
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
			if(checkbox != null) {
				checkbox.setSelection(applied);
			}

			contextState.setContextState(context, applied);
		}
	}

	private String getLabel(Context context) {
		String qualifier;
		
		if (ConfigurationManager.instance.isPlugin(context)) {
			qualifier = Messages.Preferences_Plugin;
		} else if (ConfigurationManager.instance.isMissing(context)) {
			qualifier = "missing";
		} else {
			qualifier = Messages.Preferences_Custom;
		}
		
		return String.format("%s (%s)", context.getName(), qualifier); //$NON-NLS-1$
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
			changeOccured = true;
		}

		public boolean saveContext() {
			for(Entry<Context, Boolean> entry : contexts.entrySet()) {
				if(entry.getValue()) {
					ConfigurationManager.instance.enableContext(entry.getKey(), false);
				} else {
					ConfigurationManager.instance.disableContext(entry.getKey(), false);
				}
			}

			ConfigurationManager.instance.update();

			Collection<ConfigurationConflict> conflicts = ConfigurationManager.instance.checkConflicts();

			if(changeOccured && !conflicts.isEmpty()) {
				String errorMessage = Messages.Preferences_ConflictWarning1;
				for(ConfigurationConflict conflict : conflicts) {
					errorMessage += conflict.toString() + "\n"; //$NON-NLS-1$
				}
				errorMessage += Messages.Preferences_ConflictWarning2;

				MessageDialog dialog = new MessageDialog(getShell(), Messages.Preferences_ConflictWarningTitle, null, errorMessage, MessageDialog.WARNING, new String[]{ IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 1);
				int result = dialog.open();
				if(result != 0) {
					return false;
				}
			}

			changeOccured = false;
			return true;
		}

		private Map<Context, Boolean> contexts = new HashMap<Context, Boolean>();
	}

}
