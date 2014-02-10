/**
 * Copyright (c) 2009 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Frederic MADIOT (Mia-Software) - meta-model design
 *     Gregoire DUPE (Mia-Software) - design and implementation
 * 
 *
 * $Id$
 */
package org.eclipse.emf.facet.infra.facet.editor.presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.emf.facet.infra.common.core.internal.utils.BuildPropertiesUtils;
import org.eclipse.emf.facet.infra.common.core.internal.utils.PluginUtils;
import org.eclipse.emf.facet.infra.common.core.internal.utils.ProjectUtils;
import org.eclipse.emf.facet.infra.facet.FacetFactory;
import org.eclipse.emf.facet.infra.facet.FacetPackage;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.core.FacetSetCatalog;
import org.eclipse.emf.facet.infra.facet.editor.Messages;
import org.eclipse.emf.facet.util.core.Logger;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.part.ISetSelectionTarget;

/**
 * This is a simple wizard for creating a new model file. <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * 
 * @generated NOT
 */
public class FacetModelWizard extends Wizard implements INewWizard {
	/**
	 * The supported extensions for created files. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<String> FILE_EXTENSIONS = Collections.unmodifiableList(Arrays
			.asList(FacetEditorPlugin.INSTANCE
					.getString("_UI_FacetEditorFilenameExtensions").split( //$NON-NLS-1$
							"\\s*,\\s*"))); //$NON-NLS-1$

	/**
	 * A formatted list of supported file extensions, suitable for display. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String FORMATTED_FILE_EXTENSIONS = FacetEditorPlugin.INSTANCE.getString(
			"_UI_FacetEditorFilenameExtensions").replaceAll( //$NON-NLS-1$
			"\\s*,\\s*", ", "); //$NON-NLS-1$ //$NON-NLS-2$

	/**
	 * This caches an instance of the model package. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FacetPackage facetPackage = FacetPackage.eINSTANCE;

	/**
	 * This caches an instance of the model factory. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FacetFactory facetFactory = this.facetPackage.getFacetFactory();

	/**
	 * This is the file creation page. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected FacetModelWizardNewFileCreationPage newFileCreationPage;

	// /**
	// * This is the initial object creation page.
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected FacetModelWizardInitialObjectCreationPage
	// initialObjectCreationPage;

	/**
	 * Remember the selection during initialization for populating the default
	 * container. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IStructuredSelection selection;

	/**
	 * Remember the workbench during initialization. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected IWorkbench workbench;

	/**
	 * Caches the names of the types that can be created as the root object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected List<String> initialObjectNames;

	/**
	 * This just records the information. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public void init(final IWorkbench workbench, final IStructuredSelection selection) {
		this.workbench = workbench;
		this.selection = selection;
		setWindowTitle(FacetEditorPlugin.INSTANCE.getString("_UI_Wizard_label")); //$NON-NLS-1$
		setDefaultPageImageDescriptor(ExtendedImageRegistry.INSTANCE
				.getImageDescriptor(FacetEditorPlugin.INSTANCE.getImage("full/wizban/NewFacet"))); //$NON-NLS-1$
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (this.initialObjectNames == null) {
			this.initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : this.facetPackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (!eClass.isAbstract()) {
						this.initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(this.initialObjectNames, CommonPlugin.INSTANCE.getComparator());
		}
		return this.initialObjectNames;
	}

	/**
	 * Create a new model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected EObject createInitialModel() {
		FacetSet rootObject = this.facetFactory.createFacetSet();
		String modelFacetSetName = getModelFile().getName().replaceAll(".facetSet$", ""); //$NON-NLS-1$ //$NON-NLS-2$
		rootObject.setName(modelFacetSetName);
		return rootObject;
	}

	/**
	 * Do the work after everything is specified. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean performFinish() {
		try {
			// Remember the file.
			//
			final IFile modelFile = getModelFile();

			// Do the work within an operation.
			//
			WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
				@Override
				protected void execute(final IProgressMonitor progressMonitor) {
					try {
						// Create a resource set
						//
						ResourceSet resourceSet = new ResourceSetImpl();

						// Get the URI of the model file.
						//
						URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath()
								.toString(), true);

						// Create a resource for this file.
						//
						Resource resource = resourceSet.createResource(fileURI);

						// Add the initial model object to the contents.
						//
						EObject rootObject = createInitialModel();
						if (rootObject != null) {
							resource.getContents().add(rootObject);
						}

						// Save the contents of the resource to the file system.
						//
						resource.save(null);

						try {
							BuildPropertiesUtils.addToBuild(modelFile);
						} catch (Exception e) {
							Logger
									.logError(
											e,
											"Error adding file " + modelFile.getFullPath() //$NON-NLS-1$
													+ " to the build.properties", FacetEditorPlugin.getPlugin()); //$NON-NLS-1$
						}

						PluginUtils.register(modelFile,
								FacetSetCatalog.REGISTRATION_EXTENSION_POINT_ID, "facetset"); //$NON-NLS-1$
					} catch (Exception exception) {
						FacetEditorPlugin.INSTANCE.log(exception);
					} finally {
						progressMonitor.done();
					}
				}
			};

			getContainer().run(false, false, operation);

			// Select the new file resource in the current view.
			//
			IWorkbenchWindow workbenchWindow = this.workbench.getActiveWorkbenchWindow();
			IWorkbenchPage page = workbenchWindow.getActivePage();
			final IWorkbenchPart activePart = page.getActivePart();
			if (activePart instanceof ISetSelectionTarget) {
				final ISelection targetSelection = new StructuredSelection(modelFile);
				getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						((ISetSelectionTarget) activePart).selectReveal(targetSelection);
					}
				});
			}

			// Open an editor on the new file.
			//
			try {
				page.openEditor(new FileEditorInput(modelFile), this.workbench.getEditorRegistry()
						.getDefaultEditor(modelFile.getFullPath().toString()).getId());
			} catch (PartInitException exception) {
				MessageDialog
						.openError(workbenchWindow.getShell(), FacetEditorPlugin.INSTANCE
								.getString("_UI_OpenEditorError_label"), exception.getMessage()); //$NON-NLS-1$
				return false;
			}

			return true;
		} catch (Exception exception) {
			FacetEditorPlugin.INSTANCE.log(exception);
			return false;
		}
	}

	/**
	 * This is the one page of the wizard. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public class FacetModelWizardNewFileCreationPage extends WizardNewFileCreationPage {
		/**
		 * Pass in the selection. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public FacetModelWizardNewFileCreationPage(final String pageId,
				final IStructuredSelection selection) {
			super(pageId, selection);
		}
		
		@Override
		public void createControl(final Composite parent) {
			super.createControl(parent);
			// so that the warning can appear initially
			validatePage();
		}

		/**
		 * The framework calls this to see if the file is correct. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated NOT
		 */
		@Override
		protected boolean validatePage() {
			boolean valid;
			try {
				valid = super.validatePage();
			} catch (NullPointerException e) {
				// FIXME hackaround bug 305961
				valid = false;
			}

			if (valid) {
				String extension = new Path(getFileName()).getFileExtension();
				if (extension == null || !FacetModelWizard.FILE_EXTENSIONS.contains(extension)) {
					String key = FacetModelWizard.FILE_EXTENSIONS.size() > 1 ? "_WARN_FilenameExtensions" : "_WARN_FilenameExtension"; //$NON-NLS-1$ //$NON-NLS-2$
					setErrorMessage(FacetEditorPlugin.INSTANCE.getString(key,
							new Object[] { FacetModelWizard.FORMATTED_FILE_EXTENSIONS }));
					valid = false;
				}
			}

			if (valid) {
				IPath containerFullPath = getContainerFullPath();
				if (!ProjectUtils.isInEmfFacetProject(containerFullPath)) {
					setMessage(
							Messages.FacetModelWizard_facetInNonEmfFacetProject,
							IMessageProvider.WARNING);
				}
			}

			return valid;
		}

		/**
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		public IFile getModelFile() {
			return ResourcesPlugin.getWorkspace().getRoot()
					.getFile(getContainerFullPath().append(getFileName()));
		}
	}

	// /**
	// * This is the page where the type of object to create is selected.
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public class FacetModelWizardInitialObjectCreationPage extends WizardPage
	// {
	// // /**
	// // * <!-- begin-user-doc -->
	// // * <!-- end-user-doc -->
	// // * @generated
	// // */
	// // protected Combo initialObjectField;
	//
	// /**
	// * @generated
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// */
	// protected List<String> encodings;
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected Combo encodingField;
	//
	// /**
	// * Pass in the selection.
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public FacetModelWizardInitialObjectCreationPage(String pageId) {
	// super(pageId);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public void createControl(Composite parent) {
	// Composite composite = new Composite(parent, SWT.NONE); {
	// GridLayout layout = new GridLayout();
	// layout.numColumns = 1;
	// layout.verticalSpacing = 12;
	// composite.setLayout(layout);
	//
	// GridData data = new GridData();
	// data.verticalAlignment = GridData.FILL;
	// data.grabExcessVerticalSpace = true;
	// data.horizontalAlignment = GridData.FILL;
	// composite.setLayoutData(data);
	// }
	//
	// // Label containerLabel = new Label(composite, SWT.LEFT);
	// // {
	////				containerLabel.setText(FacetEditorPlugin.INSTANCE.getString("_UI_ModelObject")); //$NON-NLS-1$
	// //
	// // GridData data = new GridData();
	// // data.horizontalAlignment = GridData.FILL;
	// // containerLabel.setLayoutData(data);
	// // }
	// //
	// // initialObjectField = new Combo(composite, SWT.BORDER);
	// // {
	// // GridData data = new GridData();
	// // data.horizontalAlignment = GridData.FILL;
	// // data.grabExcessHorizontalSpace = true;
	// // initialObjectField.setLayoutData(data);
	// // }
	// //
	// // for (String objectName : getInitialObjectNames()) {
	// // initialObjectField.add(getLabel(objectName));
	// // }
	// //
	// // if (initialObjectField.getItemCount() == 1) {
	// // initialObjectField.select(0);
	// // }
	// // initialObjectField.addModifyListener(validator);
	//
	// Label encodingLabel = new Label(composite, SWT.LEFT);
	// {
	//				encodingLabel.setText(FacetEditorPlugin.INSTANCE.getString("_UI_XMLEncoding")); //$NON-NLS-1$
	//
	// GridData data = new GridData();
	// data.horizontalAlignment = GridData.FILL;
	// encodingLabel.setLayoutData(data);
	// }
	// encodingField = new Combo(composite, SWT.BORDER);
	// {
	// GridData data = new GridData();
	// data.horizontalAlignment = GridData.FILL;
	// data.grabExcessHorizontalSpace = true;
	// encodingField.setLayoutData(data);
	// }
	//
	// for (String encoding : getEncodings()) {
	// encodingField.add(encoding);
	// }
	//
	// encodingField.select(0);
	// encodingField.addModifyListener(validator);
	//
	// setPageComplete(validatePage());
	// setControl(composite);
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected ModifyListener validator =
	// new ModifyListener() {
	// public void modifyText(ModifyEvent e) {
	// setPageComplete(validatePage());
	// }
	// };
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected boolean validatePage() {
	// //return getInitialObjectName() != null &&
	// getEncodings().contains(encodingField.getText());
	// return getEncodings().contains(encodingField.getText());
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// @Override
	// public void setVisible(boolean visible) {
	// super.setVisible(visible);
	// if (visible) {
	// // if (initialObjectField.getItemCount() == 1) {
	// // initialObjectField.clearSelection();
	// // encodingField.setFocus();
	// // }
	// // else {
	// // encodingField.clearSelection();
	// // initialObjectField.setFocus();
	// // }
	// }
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public String getInitialObjectName() {
	// // String label = initialObjectField.getText();
	// //
	// // for (String name : getInitialObjectNames()) {
	// // if (getLabel(name).equals(label)) {
	// // return name;
	// // }
	// // }
	// return null;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// public String getEncoding() {
	// return encodingField.getText();
	// }
	//
	// /**
	// * Returns the label for the specified type name.
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected String getLabel(String typeName) {
	// try {
	//				return FacetEditPlugin.INSTANCE.getString("_UI_" + typeName + "_type"); //$NON-NLS-1$ //$NON-NLS-2$
	// }
	// catch(MissingResourceException mre) {
	// FacetEditorPlugin.INSTANCE.log(mre);
	// }
	// return typeName;
	// }
	//
	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// * @generated
	// */
	// protected Collection<String> getEncodings() {
	// if (encodings == null) {
	// encodings = new ArrayList<String>();
	//				for (StringTokenizer stringTokenizer = new StringTokenizer(FacetEditorPlugin.INSTANCE.getString("_UI_XMLEncodingChoices")); stringTokenizer.hasMoreTokens(); ) { //$NON-NLS-1$
	// encodings.add(stringTokenizer.nextToken());
	// }
	// }
	// return encodings;
	// }
	// }

	/**
	 * The framework calls this to create the contents of the wizard. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void addPages() {
		// Create a page, set the title, and the initial model file name.
		//
		this.newFileCreationPage = new FacetModelWizardNewFileCreationPage(
				"Whatever", this.selection); //$NON-NLS-1$
		this.newFileCreationPage.setTitle(FacetEditorPlugin.INSTANCE
				.getString("_UI_FacetModelWizard_label")); //$NON-NLS-1$
		this.newFileCreationPage.setDescription(FacetEditorPlugin.INSTANCE
				.getString("_UI_FacetModelWizard_description")); //$NON-NLS-1$
		this.newFileCreationPage.setFileName(FacetEditorPlugin.INSTANCE
				.getString("_UI_FacetEditorFilenameDefaultBase") //$NON-NLS-1$
				+ "." + FacetModelWizard.FILE_EXTENSIONS.get(0)); //$NON-NLS-1$
		addPage(this.newFileCreationPage);

		// Try and get the resource selection to determine a current directory
		// for the file dialog.
		//
		if (this.selection != null && !this.selection.isEmpty()) {
			// Get the resource...
			//
			Object selectedElement = this.selection.iterator().next();
			if (selectedElement instanceof IResource) {
				// Get the resource parent, if its a file.
				//
				IResource selectedResource = (IResource) selectedElement;
				if (selectedResource.getType() == IResource.FILE) {
					selectedResource = selectedResource.getParent();
				}

				// This gives us a directory...
				//
				if (selectedResource instanceof IFolder || selectedResource instanceof IProject) {
					// Set this for the container.
					//
					this.newFileCreationPage.setContainerFullPath(selectedResource.getFullPath());

					// Make up a unique new name here.
					//
					String defaultModelBaseFilename = FacetEditorPlugin.INSTANCE
							.getString("_UI_FacetEditorFilenameDefaultBase"); //$NON-NLS-1$
					String defaultModelFilenameExtension = FacetModelWizard.FILE_EXTENSIONS.get(0);
					String modelFilename = defaultModelBaseFilename
							+ "." + defaultModelFilenameExtension; //$NON-NLS-1$
					for (int i = 1; ((IContainer) selectedResource).findMember(modelFilename) != null; ++i) {
						modelFilename = defaultModelBaseFilename + i
								+ "." + defaultModelFilenameExtension; //$NON-NLS-1$
					}
					this.newFileCreationPage.setFileName(modelFilename);
				}
			}
		}
		// initialObjectCreationPage = new
		// FacetModelWizardInitialObjectCreationPage(
		//				"Whatever2"); //$NON-NLS-1$
		// initialObjectCreationPage.setTitle(FacetEditorPlugin.INSTANCE
		//				.getString("_UI_FacetModelWizard_label")); //$NON-NLS-1$
		//		initialObjectCreationPage.setDescription(FacetEditorPlugin.INSTANCE.getString("_UI_Wizard_initial_object_description")); //$NON-NLS-1$
		// addPage(initialObjectCreationPage);
	}

	/**
	 * Get the file from the page. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public IFile getModelFile() {
		return this.newFileCreationPage.getModelFile();
	}

}
