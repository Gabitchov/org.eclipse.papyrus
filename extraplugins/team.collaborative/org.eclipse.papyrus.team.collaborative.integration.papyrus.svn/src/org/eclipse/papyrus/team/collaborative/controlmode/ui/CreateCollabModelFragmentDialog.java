/*******************************************************************************
 * Copyright (c) 2006 Anyware Technologies. All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Jacques Lescot (Anyware Technologies) - initial API and
 * implementation
 ******************************************************************************/
package org.eclipse.papyrus.team.collaborative.controlmode.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.dialogs.WorkspaceResourceDialog;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.papyrus.team.collaborative.controlmode.Activator;
import org.eclipse.papyrus.team.collaborative.core.reports.LogHelper;
import org.eclipse.papyrus.team.collaborative.core.utils.CollabFunctionsFactory;
import org.eclipse.papyrus.team.collaborative.core.utils.URIUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * Dialog that will ask the user the name of the new partition and create an {@link URI}
 * 
 * @author adaussy
 * 
 */
public class CreateCollabModelFragmentDialog extends Dialog {

	private URI uri;

	private Resource currentResource;

	private String defaultName;


	private static final String COLLAB_FOLDER_PATH = ".collab/";

	/**
	 * The constructor
	 * 
	 * @param parent
	 * @param theDomain
	 * @param theCurrentResource
	 * @param defaultName
	 */
	public CreateCollabModelFragmentDialog(Shell parent, Resource theCurrentResource, String defaultName) {
		super(parent);
		this.currentResource = theCurrentResource;
		this.defaultName = defaultName;
		this.title = "Create new partition";
		this.style = SWT.SAVE;

		normalizeStyle();
		setShellStyle(getShellStyle() | SWT.MAX | SWT.RESIZE);
	}

	private URI computetURI() {
		IFile file = CollabFunctionsFactory.getResourceToIFile().apply(currentResource);
		IProject project = file.getProject();
		IFolder folder = project.getFolder(COLLAB_FOLDER_PATH);
		if(!folder.exists()) {
			try {
				folder.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
				LogHelper.getInstance().logError("Unable to fragment the model", Activator.PLUGIN_ID, e);
				return null;
			}
		}

		return URIUtils.getURI(folder.getFullPath());
	}

	@Override
	protected Control createContents(Composite parent) {
		Control result = super.createContents(parent);
		this.uriField.setText(defaultName);
		return result;
	}

	/**
	 * Creates and, if it already exists, loads the specified resource. This implementation verifies
	 * that a resource can be opened for that URI, that the resource is not the object's current
	 * container, and that it is not read-only in the editing domain. If there is an existing
	 * resource with that URI, it prompts before overriding or adding to it.
	 * 
	 * @see org.eclipse.emf.common.ui.dialogs.ResourceDialog#processResources()
	 */
	protected boolean processResources() {
		String uriText = getURIText();
		if("".equals(uriText)) {
			ErrorDialog.openError(Display.getDefault().getActiveShell(), "Illegal partition name", "The name can not be empty", new Status(Status.ERROR, Activator.PLUGIN_ID, "Illegal name"));
			return false;
		}
		Matcher matcher = LEGAL_NAME.matcher(uriText);
		if(matcher.matches()) {
			URI uri = computetURI().appendSegment(uriText).appendFileExtension("uml");
			if(!alreadyExist(uri)) {
				this.uri = uri;
				return true;
			} else {
				ErrorDialog.openError(Display.getDefault().getActiveShell(), "Illegal partition name", "This name is already used", new Status(Status.ERROR, Activator.PLUGIN_ID, "Illegal name"));
				return false;
			}
		}
		ErrorDialog.openError(Display.getDefault().getActiveShell(), "Illegal partition name", "The partition name shoudl respect ^[a-zA-Z][a-zA-Z0-9]*?$ convention", new Status(Status.ERROR, Activator.PLUGIN_ID, "Illegal name"));
		return false;
	}

	protected boolean alreadyExist(URI uri) {
		for(Resource r : currentResource.getResourceSet().getResources()) {
			if(r.getURI().equals(uri)) {
				return true;
			}
		}
		return false;
	}

	private static final Pattern LEGAL_NAME = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]*?$");

	/**
	 * Return the created Resource
	 * 
	 * @return the Resource
	 */
	public URI getURI() {
		return uri;
	}


	protected static final int CONTROL_OFFSET = 10;

	protected String title;

	protected int style;

	protected Text uriField;

	protected String uriText;

	protected void normalizeStyle() {
		// Ensure there are no extraneous style bits.
		//
		if((style & ~(SWT.MULTI | SWT.SINGLE | SWT.OPEN | SWT.SAVE)) != 0) {
			throw new IllegalArgumentException("extraneous style bits specified (only SWT.MULTI, SWT.SINGLE, SWT.OPEN, SWT.SAVE allowed");
		}

		// Assign default style bits, if necessary, and ensure none conflict.
		//
		if((style & SWT.MULTI) == 0 && (style & SWT.SINGLE) == 0) {
			style |= SWT.SINGLE;
		} else if((style & SWT.MULTI) != 0 && (style & SWT.SINGLE) != 0) {
			throw new IllegalArgumentException("conflicting style bits specified (sWT.MUTLI and SWT.SINGLE)");
		}

		if((style & SWT.OPEN) == 0 && (style & SWT.SAVE) == 0) {
			style |= SWT.OPEN;
		} else if((style & SWT.OPEN) != 0 && (style & SWT.SAVE) != 0) {
			throw new IllegalArgumentException("conflicting style bits specified (sWT.OPEN and SWT.SAVE)");
		}

		if(isMulti() && isSave()) {
			throw new IllegalArgumentException("conflicting style bits specified (sWT.MULTI and SWT.SAVE)");
		}
	}

	protected boolean isSave() {
		return (style & SWT.SAVE) != 0;
	}

	protected boolean isMulti() {
		return (style & SWT.MULTI) != 0;
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(title);
	}

	/**
	 * Creates and returns the contents of the upper part of this dialog.
	 * This implementation creates a labeled text field for the URI(s) and buttons for browsing the
	 * file system and workspace. These buttons are configured (selection listeners are added) by calling {@link #prepareBrowseFileSystemButton} and
	 * {@link #prepareBrowseWorkspaceButton}, respectively.
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		{
			FormLayout layout = new FormLayout();
			composite.setLayout(layout);

			GridData data = new GridData();
			data.verticalAlignment = GridData.FILL;
			data.grabExcessVerticalSpace = true;
			data.horizontalAlignment = GridData.FILL;
			data.grabExcessHorizontalSpace = true;
			data.widthHint = 500;
			composite.setLayoutData(data);
		}

		// buttonComposite has to be the first child of composite because subclasses are expecting this.
		Composite buttonComposite = new Composite(composite, SWT.NONE);

		Label resourceURILabel = new Label(composite, SWT.LEFT);
		{
			resourceURILabel.setText("Name of the new partition");
			FormData data = new FormData();
			data.left = new FormAttachment(0, CONTROL_OFFSET);
			data.top = new FormAttachment(0, CONTROL_OFFSET);
			resourceURILabel.setLayoutData(data);
		}

		{
			FormData data = new FormData();
			data.top = new FormAttachment(resourceURILabel, CONTROL_OFFSET, SWT.CENTER);
			data.left = new FormAttachment(resourceURILabel, CONTROL_OFFSET);
			data.right = new FormAttachment(100, -CONTROL_OFFSET);
			buttonComposite.setLayoutData(data);

			buttonComposite.setLayout(new FormLayout());
		}

		uriField = new Text(composite, SWT.BORDER);
		{
			FormData data = new FormData();
			data.top = new FormAttachment(buttonComposite, CONTROL_OFFSET);
			data.left = new FormAttachment(0, CONTROL_OFFSET);
			data.right = new FormAttachment(100, -CONTROL_OFFSET);
			uriField.setLayoutData(data);
		}

		composite.setTabList(new Control[]{ uriField, buttonComposite });
		return composite;
	}

	/**
	 * Called to prepare the Browse File System button, this implementation adds a selection listener
	 * that creates an appropriate {@link FileDialog}.
	 */
	protected void prepareBrowseFileSystemButton(Button browseFileSystemButton) {
		browseFileSystemButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				FileDialog fileDialog = new FileDialog(getShell(), style);
				fileDialog.open();

				String filterPath = fileDialog.getFilterPath();
				if(isMulti()) {
					String[] fileNames = fileDialog.getFileNames();
					StringBuffer uris = new StringBuffer();

					for(int i = 0, len = fileNames.length; i < len; i++) {
						uris.append(URI.createFileURI(filterPath + File.separator + fileNames[i]).toString());
						uris.append("  ");
					}
					uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
				} else {
					String fileName = fileDialog.getFileName();
					if(fileName != null) {
						uriField.setText(URI.createFileURI(filterPath + File.separator + fileName).toString());
					}
				}
			}
		});
	}

	/**
	 * Called to prepare the Browse Workspace button, this implementation adds a selection listener
	 * that creates an appropriate {@link WorkspaceResourceDialog}.
	 */
	protected void prepareBrowseWorkspaceButton(Button browseWorkspaceButton) {
		browseWorkspaceButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				if(isMulti()) {
					StringBuffer uris = new StringBuffer();

					IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, true, null, null);
					for(int i = 0, len = files.length; i < len; i++) {
						uris.append(URI.createPlatformResourceURI(files[i].getFullPath().toString(), true));
						uris.append("  ");
					}
					uriField.setText((uriField.getText() + "  " + uris.toString()).trim());
				} else {
					IFile file = null;

					if(isSave()) {
						file = WorkspaceResourceDialog.openNewFile(getShell(), null, null, null, null);
					} else {
						IFile[] files = WorkspaceResourceDialog.openFileSelection(getShell(), null, null, false, null, null);
						if(files.length != 0) {
							file = files[0];
						}
					}

					if(file != null) {
						uriField.setText(URI.createPlatformResourceURI(file.getFullPath().toString(), true).toString());
					}
				}
			}
		});
	}

	/**
	 * Called when the OK button has been pressed, this method calls {@link #getURIText} to cache and return
	 * the URI text field's value (so that it may be retrieved even after the field has been disposed).
	 * It then calls {@link #processResources} to handle the specified URIs and optionally closes the dialog,
	 * based on its return value.
	 */
	@Override
	protected void okPressed() {
		uriText = getURIText();
		if(processResources()) {
			super.okPressed();
		} else {
			uriField.selectAll();
			uriField.setFocus();
		}
	}

	/**
	 * Returns the value of the URI text field.
	 */
	public String getURIText() {
		return uriField != null && !uriField.isDisposed() ? uriField.getText() : uriText;
	}

	/**
	 * Returns the list of space-separated URIs from the URI text field.
	 */
	public List<URI> getURIs() {
		List<URI> uris = new ArrayList<URI>();
		for(StringTokenizer stringTokenizer = new StringTokenizer(getURIText()); stringTokenizer.hasMoreTokens();) {
			String uri = stringTokenizer.nextToken();
			uris.add(URI.createURI(uri));
		}
		return uris;
	}


}
