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
package org.eclipse.papyrus.cdo.uml.diagram.internal.ui.wizards;

import static org.eclipse.papyrus.uml.diagram.wizards.utils.WizardsHelper.adapt;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.util.CDOURIUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.cdo.core.IPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.core.IInternalPapyrusRepository;
import org.eclipse.papyrus.cdo.internal.ui.views.ModelRepositoryItemProvider;
import org.eclipse.papyrus.uml.diagram.wizards.Activator;
import org.eclipse.papyrus.uml.diagram.wizards.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Strings;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

/**
 * This is the NewModelPage type. Enjoy.
 */
public class NewModelPage
		extends WizardPage {

	public static final String PAGE_ID = "NewCDOModel"; //$NON-NLS-1$

	private Text folderText;

	private TreeViewer foldersTree;

	private Text nameText;

	private IPapyrusRepository repository;

	private CDOResourceNode selectedNode;

	private boolean synchronizingFolderSelection;

	public NewModelPage(IStructuredSelection selection, EventBus bus,
			String modelKindName) {

		super(PAGE_ID);

		setTitle(NLS.bind("New {0} Model", modelKindName));
		setDescription(NLS.bind("Create a new {0} model", modelKindName));

		if (!selection.isEmpty()) {
			selectedNode = adapt(selection.getFirstElement(),
				CDOResourceNode.class);
			if ((selectedNode != null)
				&& !(selectedNode instanceof CDOResourceFolder)) {
				selectedNode = selectedNode.getFolder();
			}
		}

		bus.register(this);
	}

	public void createControl(Composite parent) {
		Composite myComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(myComposite);
		myComposite.setLayout(new GridLayout(2, false));

		Label label = new Label(myComposite, SWT.NONE);
		label.setText("Enter or select the parent folder:");
		GridDataFactory.swtDefaults().span(2, 1).applyTo(label);

		folderText = new Text(myComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).span(2, 1)
			.applyTo(folderText);
		updateFolderSelection();

		foldersTree = new TreeViewer(myComposite, SWT.BORDER | SWT.V_SCROLL
			| SWT.H_SCROLL);
		GridDataFactory.fillDefaults().grab(true, true).span(2, 1)
			.applyTo(foldersTree.getControl());
		ModelRepositoryItemProvider itemProvider = new ModelRepositoryItemProvider(
			null);
		foldersTree.setContentProvider(itemProvider);
		foldersTree
			.setLabelProvider(new DecoratingLabelProvider(itemProvider,
				PlatformUI.getWorkbench().getDecoratorManager()
					.getLabelDecorator()));
		foldersTree.setSorter(itemProvider);
		if (getRepository() != null) {
			foldersTree.setInput(getRepository());
		}
		if (selectedNode != null) {
			foldersTree.setSelection(new StructuredSelection(selectedNode));
		}

		new Label(myComposite, SWT.NONE).setText("Resource name:");

		nameText = new Text(myComposite, SWT.BORDER);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(nameText);
		nameText.setText(suggestName("model", "di"));

		setControl(myComposite);

		folderText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				findFolderSelection();
				validatePage();
			}
		});

		foldersTree
			.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					IStructuredSelection selection = (IStructuredSelection) event
						.getSelection();
					selectedNode = selection.isEmpty()
						? null
						: adapt(selection.getFirstElement(),
							CDOResourceNode.class);
					updateFolderSelection();
					validatePage();
				}
			});

		nameText.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				validatePage();
			}
		});

		validatePage();
	}

	@Subscribe
	public void setRepository(IPapyrusRepository repository) {
		this.repository = repository;

		if (foldersTree != null) {
			foldersTree.setInput(repository);
		}

		validatePage();
	}

	private IInternalPapyrusRepository getRepository() {
		return ((IInternalPapyrusRepository) repository);
	}

	CDOView getView() {
		IInternalPapyrusRepository repo = getRepository();
		return (repo == null)
			? null
			: repo.getMasterView();
	}

	String getSelectedFolderPath() {
		return folderText.getText().trim();
	}

	void updateFolderSelection() {
		whileSynchronizingFolderSelection(new Runnable() {

			public void run() {
				CDOResourceFolder selected = null;
				if (selectedNode instanceof CDOResourceFolder) {
					selected = (CDOResourceFolder) selectedNode;
				} else if (selectedNode != null) {
					// will be null if the selectedNode is contained by the root
					// resource
					selected = selectedNode.getFolder();
				}

				if (selected == null) {
					folderText.setText("");
				} else {
					folderText.setText(selected.getPath());
				}
			}
		});
	}

	void findFolderSelection() {
		whileSynchronizingFolderSelection(new Runnable() {

			public void run() {
				String folder = folderText.getText().trim();
				CDOView view = getView();
				if (view != null) {
					try {
						foldersTree.setSelection(new StructuredSelection(view
							.getResourceNode(folder)));
					} catch (Exception e) {
						// normal occurrence when the folder doesn't exist
					}
				}
			}
		});
	}

	private void whileSynchronizingFolderSelection(Runnable runnable) {
		if (!synchronizingFolderSelection) {
			synchronizingFolderSelection = true;

			try {
				runnable.run();
			} finally {
				synchronizingFolderSelection = false;
			}
		}
	}

	String suggestName(String baseName, String extension) {
		String result = String.format("%s.%s", baseName, extension);
		CDOView view = getView();

		if (view != null) {
			for (int i = 1;; i++) {
				if (!view.hasResource(getNewResourcePath(result))) {
					break;
				} else {
					// use %s instead of %d to avoid any thousands separators
					// (hah! that there should be so many models)
					result = String.format("%s%s.%s", baseName, i, extension);
				}
			}
		}

		return result;
	}

	String getNewResourcePath(String name) {
		String result = null;
		String path = getSelectedFolderPath();

		if (path.equals("")) {
			// it's a resource in the root
			result = "/" + name;
		} else {
			StringBuilder buf = new StringBuilder();

			if (!path.startsWith("/")) {
				buf.append("/");
			}
			buf.append(path);
			if (!path.endsWith("/")) {
				buf.append("/");
			}
			buf.append(name);

			result = buf.toString();
		}

		return result;
	}

	String getNewResourceName() {
		return (nameText == null)
			? null
			: nameText.getText().trim();
	}

	void setNewResourceName(String newName) {
		nameText.setText(newName.trim());
	}

	public URI createNewModelResourceURI() {
		return CDOURIUtil.createResourceURI(getView(),
			getNewResourcePath(getNewResourceName()));
	}

	private String getExtension() {
		String result = null;
		String name = getNewResourceName();

		if (name != null) {
			// the proper extension is whatever follows the *last* '.',
			// but for our purposes we need e.g. "profile.uml" to be
			// an extension
			int dot = name.indexOf('.');
			if (dot >= 0) {
				result = name.substring(dot + 1);
			}
		}

		return result;
	}

	/**
	 * Diagram extension changed.
	 * 
	 * @param newExtension
	 *            the new extension
	 * @return result of validation of the new extension
	 */
	public IStatus diagramExtensionChanged(String newExtension) {
		String currentExtension = getExtension();
		if (!newExtension.equals(currentExtension)) {

			String oldFileName = getNewResourceName();
			String base = oldFileName;
			if (currentExtension != null) {
				// take one off for the '.'
				base = base.substring(0,
					base.length() - currentExtension.length() - 1);
			}
			String newFileName = suggestName(base, newExtension);

			setNewResourceName(newFileName);

			String message1 = Messages.NewModelFilePage_new_diagram_category_needs_specific_extension;
			String message2 = Messages.bind(
				Messages.NewModelFilePage_diagram_file_was_renamed,
				oldFileName, newFileName);
			String message = message1 + message2;
			Status resultStatus = new Status(Status.INFO, Activator.PLUGIN_ID,
				message);

			String errorMessage = getErrorMessage();
			if (errorMessage != null) {
				resultStatus = new Status(Status.ERROR, Activator.PLUGIN_ID,
					errorMessage);
			}
			return resultStatus;
		}
		return Status.OK_STATUS;
	}

	void validatePage() {
		setMessage(null, NONE);
		setPageComplete(true);

		String name = getNewResourceName();
		if (getView() == null) {
			setMessage("No repository is selected.", ERROR);
			setPageComplete(false);
		} else if (Strings.isNullOrEmpty(name)) {
			setMessage("The new model resource name is required.", ERROR);
			setPageComplete(false);
		} else {
			String path = getNewResourcePath(name);
			if (getView().hasResource(path)) {
				setMessage(
					NLS.bind("The resource \"{0}\" already exists.", path),
					ERROR);
				setPageComplete(false);
			} else {
				// check existence of folder (if any)
				String folderPath = getSelectedFolderPath();
				if (!Strings.isNullOrEmpty(folderPath)) {
					if (!getView().hasResource(folderPath)) {
						setMessage(
							"The specified folder does not exist and will be created.",
							WARNING);
					}
				}
			}
		}
	}
}
