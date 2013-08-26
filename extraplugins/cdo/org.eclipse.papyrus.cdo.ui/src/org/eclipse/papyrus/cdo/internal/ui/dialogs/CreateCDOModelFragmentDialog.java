/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.dialogs;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.EresourcePackage;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.ui.EMFEditUIPlugin;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.resource.CDOAwareModelSet;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.infra.services.controlmode.ui.IControlModeFragmentDialogProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Strings;


/**
 * This is the CreateCDOModelFragmentDialog type. Enjoy.
 */
public class CreateCDOModelFragmentDialog extends Dialog {

	private final CDOView view;

	private final URIConverter uriConverter;

	private String selectedURI;

	private Text uriText;

	private Label errorLabel;

	public CreateCDOModelFragmentDialog(Shell parentShell, Resource parentUnit, String defaultUnitName) {
		super(parentShell);

		this.view = ((CDOResource)parentUnit).cdoView();
		this.uriConverter = parentUnit.getResourceSet().getURIConverter();

		URI parentURI = parentUnit.getURI();
		this.selectedURI = parentURI.trimSegments(1).appendSegment(defaultUnitName).appendFileExtension(parentURI.fileExtension()).toString();
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);

		newShell.setText(EMFEditUIPlugin.INSTANCE.getString("_UI_ControlDialog_title")); //$NON-NLS-1$
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite result = (Composite)super.createDialogArea(parent);

		result.setLayout(new GridLayout(2, false));

		new Label(result, SWT.NONE).setText(Messages.CreateCDOFragDlg_uriLabel);

		Composite browseComposite = new Composite(result, SWT.NONE);
		browseComposite.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false));
		browseComposite.setLayout(new RowLayout(SWT.HORIZONTAL));
		createBrowseButtons(browseComposite);

		uriText = new Text(result, SWT.BORDER | SWT.SINGLE);
		GridData ld = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
		ld.widthHint = convertWidthInCharsToPixels(50);
		uriText.setLayoutData(ld);

		if(selectedURI != null) {
			uriText.setText(selectedURI);
		}

		uriText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				validateURI(uriText.getText());
			}
		});

		errorLabel = new Label(result, SWT.WRAP);
		errorLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 2, 1));

		return result;
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);

		// now that the OK button exists, determine initial enablement
		if(selectedURI == null) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
			validateURI(selectedURI);
		}
	}

	public URI getSelectedURI() {
		return ((getReturnCode() != Window.OK) || (selectedURI == null)) ? null : URI.createURI(selectedURI, true);
	}

	private void createBrowseButtons(Composite composite) {
		Button browseRepo = new Button(composite, SWT.PUSH);
		browseRepo.setText(Messages.CreateCDOFragDlg_browseRepo);

		browseRepo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				browseRepository();
			}
		});
	}

	private void browseRepository() {
		BrowseRepositoryDialog dlg = new BrowseRepositoryDialog(getShell(), Messages.CreateCDOFragDlg_browseTitle, Messages.CreateCDOFragDlg_browseMessage, view, SWT.SAVE);

		dlg.setNodeTypeFilter(EresourcePackage.Literals.CDO_RESOURCE);
		dlg.setAllowOverwrite(false);

		String initialURI = uriText.getText().trim();
		if(!Strings.isNullOrEmpty(initialURI)) {
			try {
				dlg.setInitialURI(URI.createURI(initialURI, true));
			} catch (Exception e) {
				// OK, it's not a valid input.  That's fine.  Use the last valid selection
				if(selectedURI != null) {
					dlg.setInitialURI(URI.createURI(selectedURI, true));
				}
			}
		}

		if(dlg.open() == Window.OK) {
			uriText.setText(dlg.getSelectedURI().toString());
		}
	}

	private void setError(String error) {
		if(error == null) {
			errorLabel.setText(""); //$NON-NLS-1$
		} else {
			errorLabel.setText(error);
		}

		errorLabel.getParent().layout();
	}

	private void validateURI(String uri) {
		uri = uri.trim();
		if(uri.length() == 0) {
			getButton(IDialogConstants.OK_ID).setEnabled(false);
		} else {
			try {
				URI parsed = URI.createURI(uri, true);

				if(parsed.hasFragment()) {
					throw new IllegalArgumentException(Messages.CreateCDOFragDlg_hasFragmentError);
				} else if(uriConverter.exists(parsed, null)) {
					throw new IllegalArgumentException(Messages.CreateCDOFragDlg_existsError);
				} else {
					// an empty folder name indicates a resource at the root; the root always exists
					String folder = CDOURIUtil.extractResourceFolderAndName(parsed)[0];
					if(!Strings.isNullOrEmpty(folder)) {
						if(!view.hasResource(folder)) {
							throw new IllegalArgumentException(NLS.bind(Messages.CreateCDOFragDlg_noSuchFolderError, folder));
						}
						if(!(view.getResourceNode(folder) instanceof CDOResourceFolder)) {
							throw new IllegalArgumentException(NLS.bind(Messages.CreateCDOFragDlg_notFolderError, folder));
						}
					}
				}

				getButton(IDialogConstants.OK_ID).setEnabled(true);
				this.selectedURI = uri;
				setError(null);
			} catch (Exception e) {
				getButton(IDialogConstants.OK_ID).setEnabled(false);
				setError(e.getLocalizedMessage());
			}
		}
	}

	//
	// Nested types
	//

	public static class Provider implements IControlModeFragmentDialogProvider {

		public Dialog createDialog(Shell shell, Resource parentUnit, String defaultUnitURI) {
			return (parentUnit instanceof CDOResource) ? new CreateCDOModelFragmentDialog(shell, parentUnit, defaultUnitURI) : DEFAULT.createDialog(shell, parentUnit, defaultUnitURI);
		}

		public URI getSelectedURI(Dialog dialog) {
			return (dialog instanceof CreateCDOModelFragmentDialog) ? ((CreateCDOModelFragmentDialog)dialog).getSelectedURI() : DEFAULT.getSelectedURI(dialog);
		}
	}

	public static class AdapterFactory implements IAdapterFactory {

		private static final Class<?>[] ADAPTERS = { IControlModeFragmentDialogProvider.class };

		@SuppressWarnings("rawtypes")
		public Class[] getAdapterList() {
			return ADAPTERS;
		}

		public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
			Object result = null;

			if(adapterType == IControlModeFragmentDialogProvider.class) {
				if(adaptableObject instanceof CDOAwareModelSet) {
					result = new Provider();
				}
			}

			return result;
		}
	}
}
