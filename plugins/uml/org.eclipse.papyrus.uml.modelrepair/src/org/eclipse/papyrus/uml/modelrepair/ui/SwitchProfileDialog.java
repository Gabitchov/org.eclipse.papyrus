/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.ui;

import static com.google.common.base.Strings.nullToEmpty;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.utils.TransactionHelper;
import org.eclipse.papyrus.infra.emf.resource.DependencyManager;
import org.eclipse.papyrus.infra.emf.resource.Replacement;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForResourceSet;
import org.eclipse.papyrus.infra.services.labelprovider.service.LabelProviderService;
import org.eclipse.papyrus.infra.services.markerlistener.dialogs.DiagnosticDialog;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.providers.EncapsulatedContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.StaticContentProvider;
import org.eclipse.papyrus.infra.widgets.providers.WorkspaceContentProvider;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.tools.util.ProfileHelper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Profile;

/**
 * The dialog to switch from a Profile application to another
 * 
 * @author Camille Letavernier
 */
public class SwitchProfileDialog extends SelectionDialog {

	private static final int APPLY_ID = IDialogConstants.CLIENT_ID + 1;

	private static final String APPLY_LABEL = "Apply";

	private static final int BROWSE_WORKSPACE_ID = IDialogConstants.CLIENT_ID + 2;

	private static final int BROWSE_REGISTERED_ID = IDialogConstants.CLIENT_ID + 3;

	private ModelSet modelSet;

	private TransactionalEditingDomain editingDomain;

	protected TableViewer viewer;

	protected Table table;

	protected LabelProviderService labelProviderService;

	protected final Map<Resource, Resource> profilesToEdit = new HashMap<Resource, Resource>();

	public SwitchProfileDialog(Shell shell, ModelSet modelSet, TransactionalEditingDomain domain) throws ServiceException {
		super(shell);

		this.modelSet = modelSet;
		this.editingDomain = domain;
		this.labelProviderService = ServiceUtilsForResourceSet.getInstance().getService(LabelProviderService.class, modelSet);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Composite self = new Composite(contents, SWT.NONE);
		self.setLayout(new GridLayout(1, false));
		self.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		Label descriptionLabel = new Label(self, SWT.WRAP);
		String description = "Select an applied profile, then select a profile (either from the workspace, or a registered one).\n";
		description += "If the profiles are equivalent, the selected profile will replace the applied profile. Stereotype applications will be kept.\n";
		description += "Two profiles are equivalent if one is the copy of the other or if you have deployed a workspace profile in a plug-in.\n";
		description += "If a profile P' is a copy of a profile P, with some modifications, they are also equivalent.";
		descriptionLabel.setText(description);

		descriptionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		Label warningLabel = new Label(self, SWT.WRAP);
		String warning = "Replacing an applied profile with a totally different one will result in loss of stereotype applications.";
		warningLabel.setText(warning);
		warningLabel.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_RED));

		warningLabel.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		Composite buttonsBarComposite = new Composite(self, SWT.NONE);

		GridLayout buttonsLayout = new GridLayout(0, false);
		buttonsLayout.marginWidth = 0;

		buttonsBarComposite.setLayout(buttonsLayout);
		buttonsBarComposite.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));

		Button browseWorkspace = createButton(buttonsBarComposite, BROWSE_WORKSPACE_ID, "", false);
		browseWorkspace.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage("icons/Add_12x12.gif"));
		Button browseRegistered = createButton(buttonsBarComposite, BROWSE_REGISTERED_ID, "", false);
		browseRegistered.setImage(org.eclipse.papyrus.infra.widgets.Activator.getDefault().getImage(Activator.PLUGIN_ID, "icons/AddReg.gif"));


		viewer = new TableViewer(self, SWT.FULL_SELECTION | SWT.BORDER);
		table = viewer.getTable();
		TableLayout layout = new TableLayout();
		table.setLayout(layout);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setHeaderVisible(true);


		TableColumn nameColumn = new TableColumn(table, SWT.NONE);
		nameColumn.setText("Applied Profile");
		layout.addColumnData(new ColumnWeightData(15, 150, true));

		TableColumn locationColumn = new TableColumn(table, SWT.NONE);
		locationColumn.setText("Location");
		layout.addColumnData(new ColumnWeightData(50, 500, true));

		TableColumn newLocationColumn = new TableColumn(table, SWT.NONE);
		newLocationColumn.setText("New Location");
		layout.addColumnData(new ColumnWeightData(50, 500, true));

		viewer.setContentProvider(new IStructuredContentProvider() {

			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				//Nothing
			}

			public void dispose() {
				//Nothing
			}

			public Object[] getElements(Object inputElement) {
				if(inputElement instanceof ModelSet) {
					ModelSet modelSet = (ModelSet)inputElement;

					Collection<Profile> allAppliedProfiles = ProfileHelper.getAllAppliedProfiles(modelSet);

					Set<Resource> allResources = new HashSet<Resource>();
					for(Profile appliedProfile : allAppliedProfiles) {
						URI profileResourceURI = EcoreUtil.getURI(appliedProfile).trimFragment();
						Resource resource = modelSet.getResource(profileResourceURI, true);
						allResources.add(resource);
					}

					return allResources.toArray();
				}
				return null;
			}
		});

		final ILabelProvider labelProvider = new LabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof Resource) {
					Resource resource = (Resource)element;

					for(EObject rootElement : resource.getContents()) {
						if(rootElement instanceof Profile) {
							return ((Profile)rootElement).getName();
						}
					}

					return resource.getURI().toString();
				}
				return super.getText(element);
			}
		};
		viewer.setLabelProvider(new ProfileColumnsLabelProvider(labelProvider));
		viewer.setComparator(new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				return nullToEmpty(labelProvider.getText(e1)).compareTo(nullToEmpty(labelProvider.getText(e2)));
			}
		});
		
		viewer.setInput(modelSet);

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				updateControls();
			}
		});
		
		viewer.getControl().addDisposeListener(new DisposeListener() {
			
			public void widgetDisposed(DisposeEvent e) {
				labelProvider.dispose();
			}
		});

		return contents;
	}

	protected void updateControls() {
		String newTitle = "Switch Profile Locations";
		if(!profilesToEdit.isEmpty()) {
			newTitle += " *";
		}
		getShell().setText(newTitle);
		getButton(APPLY_ID).setEnabled(!profilesToEdit.isEmpty());

		boolean enableBrowse = !viewer.getSelection().isEmpty();

		getButton(BROWSE_REGISTERED_ID).setEnabled(enableBrowse);
		getButton(BROWSE_WORKSPACE_ID).setEnabled(enableBrowse);
		
		viewer.refresh();
	}

	@Override
	protected void setButtonLayoutData(Button button) {
		int buttonId = ((Integer)button.getData()).intValue();
		if(buttonId == BROWSE_REGISTERED_ID || buttonId == BROWSE_WORKSPACE_ID) {
			return; //Don't change the layout data
		}

		super.setButtonLayoutData(button);
	}

	protected void applyPressed() {
		if(profilesToEdit.isEmpty()) {
			return;
		}

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain, "Edit profile applications") {

			@Override
			protected void doExecute() {

				final Collection<Replacement> allReplacements = new LinkedList<Replacement>();
				final BasicDiagnostic diagnostics = new BasicDiagnostic(Activator.PLUGIN_ID, 0, "Problems in switching profile", null);
				
				IRunnableWithProgress runnable = TransactionHelper.createPrivilegedRunnableWithProgress(editingDomain, new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) {
						SubMonitor subMonitor = SubMonitor.convert(monitor, profilesToEdit.size());

						for(Entry<Resource, Resource> replacementEntry : profilesToEdit.entrySet()) {
							URI uriToReplace = replacementEntry.getKey().getURI();
							URI targetURI = replacementEntry.getValue().getURI();

							if(uriToReplace.equals(targetURI)) {
								continue;
							}

							Collection<Replacement> result = new DependencyManager(modelSet).updateDependencies(uriToReplace, targetURI, diagnostics, subMonitor.newChild(1));
							allReplacements.addAll(result);
						}

						subMonitor.done();
					}
				});
				
				try {
					PlatformUI.getWorkbench().getProgressService().busyCursorWhile(runnable);
				} catch (Exception e) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to execute profile switch."), StatusManager.SHOW);
				}

				if(allReplacements.isEmpty()) {
					MessageDialog.openWarning(getShell(), "Switch Profiles", "No profile applications were found to update.");
				} else {
					if(diagnostics.getSeverity() > Diagnostic.OK) {
						DiagnosticDialog dialog = new DiagnosticDialog(getShell(), "Problems in Switching Profiles", "Some incompatible differences in the target profile likely resulted in loss or transformation of data in stereotype applications. Please review the specific details and take any corrective action that may be required.", diagnostics, Diagnostic.ERROR | Diagnostic.WARNING);
						dialog.setBlockOnOpen(true);
						dialog.open();
					}
				}
			}
		});

		profilesToEdit.clear();
		updateControls();
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, APPLY_ID, APPLY_LABEL, true);
		super.createButtonsForButtonBar(parent);
	}

	@Override
	protected void buttonPressed(int buttonId) {
		switch(buttonId) {
		case IDialogConstants.CANCEL_ID:
			if(!profilesToEdit.isEmpty() && !MessageDialog.openQuestion(getShell(), "Switch Profiles", "You have not yet applied the pending profile switch(es). Are you sure you want to cancel?")) {
				// don't cancel
				return;
			}
			break;
		case APPLY_ID:
			applyPressed();
			return;
		case BROWSE_REGISTERED_ID:
			browseRegisteredProfiles();
			return;
		case BROWSE_WORKSPACE_ID:
			browseWorkspaceProfiles();
			return;
		}

		super.buttonPressed(buttonId);
	}

	@Override
	public void create() {
		super.create();
		updateControls();
		getShell().setText("Switch Profile Locations");
		getShell().setMinimumSize(600, 400);
		getShell().pack();
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	public boolean isHelpAvailable() {
		return false;
	}

	@Override
	protected void okPressed() {
		applyPressed();

		super.okPressed();
	}

	@Override
	public boolean close() {
		profilesToEdit.clear();
		return super.close();
	}

	private class ProfileColumnsLabelProvider extends ColumnLabelProvider {

		private ILabelProvider defaultLabelProvider;

		public ProfileColumnsLabelProvider(ILabelProvider defaultLabelProvider) {
			this.defaultLabelProvider = defaultLabelProvider;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			Resource resource = (element instanceof Resource) ? (Resource)element : null;
			
			switch (cell.getColumnIndex()) {
			case 0:
				updateName(cell);
				break;
			case 1:
				updateLocation(cell, resource);
				break;
			case 2:
				updateNewLocation(cell, resource);
				break;
			}

		}

		public void updateName(ViewerCell cell) {
			cell.setImage(defaultLabelProvider.getImage(cell.getElement()));
			cell.setText(defaultLabelProvider.getText(cell.getElement()));
		}

		public void updateLocation(ViewerCell cell, Resource resource) {
			String location = "Unknown";
			if(resource != null) {
				URI uri = resource.getURI();
				if(uri != null) {
					location = uri.toString();
				}
			}

			cell.setText(location);
		}

		public void updateNewLocation(ViewerCell cell, Resource resource) {
			String location = "";
			resource = profilesToEdit.get(resource);
			
			if(resource != null) {
				URI uri = resource.getURI();
				if(uri != null) {
					location = uri.toString();
				}
			}

			cell.setText(location);
		}
	}

	protected void browseWorkspaceProfiles() {
		if(getSelectedResource() == null) {
			return;
		}

		Map<String, String> extensionFilters = new LinkedHashMap<String, String>();
		extensionFilters.put("*.profile.uml", "UML Profiles (*.profile.uml)");
		extensionFilters.put("*.uml", "UML (*.uml)");
		extensionFilters.put("*", "All (*)");

		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
		dialog.setTitle("Browse Workspace");
		dialog.setDescription("Select a profile in the workspace.");
		WorkspaceContentProvider workspaceContentProvider = new WorkspaceContentProvider();
		workspaceContentProvider.setExtensionFilters(extensionFilters);
		dialog.setContentProvider(workspaceContentProvider);

		dialog.setLabelProvider(labelProviderService.getLabelProvider());


		if(dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if(result == null || result.length == 0) {
				return;
			}

			Object selectedFile = result[0];

			if(selectedFile instanceof IFile) {
				IPath filePath = ((IFile)selectedFile).getFullPath();
				URI workspaceURI = URI.createPlatformResourceURI(filePath.toString(), true);

				replaceSelectionWith(workspaceURI);
			}
		}
	}

	protected Resource getSelectedResource() {
		ISelection selection = viewer.getSelection();
		if(selection.isEmpty()) {
			return null;
		}

		if(selection instanceof IStructuredSelection) {
			Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
			if(selectedElement instanceof Resource) {
				return (Resource)selectedElement;
			}
		}

		return null;
	}

	protected void browseRegisteredProfiles() {
		TreeSelectorDialog dialog = new TreeSelectorDialog(getShell());
		dialog.setTitle("Browse Registered Profiles");
		dialog.setDescription("Select one of the registered profiles below.");
		dialog.setContentProvider(new EncapsulatedContentProvider(new StaticContentProvider(RegisteredProfile.getRegisteredProfiles())));
		dialog.setLabelProvider(new LabelProvider() {

			@Override
			public Image getImage(Object element) {
				if(element instanceof RegisteredProfile) {
					RegisteredProfile profile = (RegisteredProfile)element;
					return profile.getImage();
				}
				return super.getImage(element);
			}

			@Override
			public String getText(Object element) {
				if(element instanceof RegisteredProfile) {
					RegisteredProfile profile = (RegisteredProfile)element;
					return profile.name;
				}

				return super.getText(element);
			}
		});

		if(dialog.open() == Window.OK) {
			Object[] result = dialog.getResult();
			if(result == null || result.length == 0) {
				return;
			}

			Object selectedElement = result[0];
			if(selectedElement instanceof RegisteredProfile) {
				RegisteredProfile profile = (RegisteredProfile)selectedElement;

				replaceSelectionWith(profile.uri);
			}
		}
	}

	protected void replaceSelectionWith(URI targetURI) {
		Resource targetResource = modelSet.getResource(targetURI, true);

		if(getSelectedResource() != targetResource) {
			profilesToEdit.put(getSelectedResource(), targetResource);
			updateControls();
		} else {
			MessageDialog.openWarning(getShell(), "Nothing changed", "Nothing to change");
		}
	}
}
