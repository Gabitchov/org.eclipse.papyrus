/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.facadeSpecificEditor;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.ui.util.EditUIUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.facade.Facade;
import org.eclipse.papyrus.facade.FacadePackage;
import org.eclipse.papyrus.facade.extensiondefinition.BaseMetaclass;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinition;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensionDefinitionKind;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionFactory;
import org.eclipse.papyrus.facade.extensiondefinition.ExtensiondefinitionPackage;
import org.eclipse.papyrus.facade.presentation.FacadeEditor;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualMetamodel;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelFactory;
import org.eclipse.papyrus.facade.virtualmetamodel.VirtualmetamodelPackage;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.EditionUtils;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.ExtensionKindColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.IsPossibleColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.MetaclassAliasColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.MetaclassIsAbstractColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.MetaclassToKeepColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.MetaclassUseRepresentedColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.PropertiesAliasColumnEdintingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.PropertiesMaxColumnEdintingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.PropertiesMinColumnEdintingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.PropertiesToKeepColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.editingSupport.StereotypeIncompatibilityColumnEditingSupport;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.CreatePreliminaryMetamodelListener;
import org.eclipse.papyrus.facadeSpecificEditor.metamodel.EcoreGenerator;
import org.eclipse.papyrus.facadeSpecificEditor.providers.ExtensionDefintionContentProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.ExtensionDefintionLabelProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.IncompatibilitiesContentProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.IncompatibilitiesLabelProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.MetamodelContentProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.MetamodelLabelProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.TypedElementContentProvider;
import org.eclipse.papyrus.facadeSpecificEditor.providers.TypedElementLabelProvider;
import org.eclipse.papyrus.facadeSpecificEditor.utils.ProfileUtils;
import org.eclipse.papyrus.facadeSpecificEditor.utils.StereotypeUtils;
import org.eclipse.papyrus.facadeSpecificEditor.utils.UMLModelUtils;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The Class Facade Definition Editor. It is mostly UI.
 */
public class FacadeSpecificEditor extends FacadeEditor {

	/** The facade under edition */
	protected Facade facade;

	/** The model resource of the facade */
	protected Resource facadeModelResource;

	/** The initialize button. */
	protected Button initializeButton;

	/** The profiles that are invloved in the facade. */
	protected List<Profile> profileModels = new ArrayList<Profile>();

	/** The resource set used to open UML profiles */
	protected ResourceSet profileResourceSet = new ResourceSetImpl();


	/**
	 * UI elements
	 */
	protected Tree metamodelTree;

	protected Tree extensionDefinitionTable;

	protected FilteredTree extensionDefintionFilteredTreeViewer;

	protected static TreeViewer extensionDefintionTreeViewer;

	protected FilteredTree metamodelFilteredTreeViewer;

	protected static TreeViewer metamodelTreeViewer;

	protected TreeViewer propertiesTreeViewer;

	protected Tree propertiesTree;

	protected TableViewer incompatibilitiesTableViewer;

	protected Table incompatibilitiesTable;

	protected TabFolder tabFolder;

	protected Button createMetamodelButton;

	protected Button createEcoreButton;

	protected Button createGlueButton;

	protected Text metamodelName;

	protected Text nsPrefix;

	protected Text nsURI;


	/**
	 * @see org.eclipse.papyrus.facade.presentation.FacadeEditor#createModel()
	 * 
	 */
	public void createModel() {

		URI resourceURI = EditUIUtil.getURI(getEditorInput());
		Exception exception = null;
		facadeModelResource = null;
		try {
			// Load the resource through the editing domain.
			facadeModelResource = editingDomain.getResourceSet().getResource(resourceURI, true);
		} catch (Exception e) {
			exception = e;
			facadeModelResource = editingDomain.getResourceSet().getResource(resourceURI, false);
		}

		Diagnostic diagnostic = analyzeResourceProblems(facadeModelResource, exception);
		if(diagnostic.getSeverity() != Diagnostic.OK) {
			resourceToDiagnosticMap.put(facadeModelResource, analyzeResourceProblems(facadeModelResource, exception));
		}
		editingDomain.getResourceSet().eAdapters().add(problemIndicationAdapter);

		if(facadeModelResource.getContents().size() > 0) {
			// Get the root
			facade = (Facade)facadeModelResource.getContents().get(0);

			if(!facade.getExtensionDefinitions().isEmpty()) {
				// Shouldn't be required but just in case
				ProfileUtils.clearSiblings();

				for(ExtensionDefinition stereotypeDefinition : facade.getExtensionDefinitions()) {
					ProfileUtils.initSiblings(stereotypeDefinition.getStereotype());
				}
			}
		}
	}

	/**
	 * Getter for the extensionDefintionTreeViewer widget
	 * 
	 * @return the extensionDefintionTreeViewer widget
	 */
	public static TreeViewer getExtensionDefintionTreeViewer() {
		return extensionDefintionTreeViewer;
	}

	/**
	 * Getter for the metamodelTreeViewer widget
	 * 
	 * @return the metamodelTreeViewer widget
	 */
	public static TreeViewer getMetamodelTreeViewer() {
		return metamodelTreeViewer;
	}

	/**
	 * Helper method to clear the facade.
	 */
	protected void clearModel() {
		RemoveCommand commandMetaclasses = new RemoveCommand(editingDomain, facade, FacadePackage.eINSTANCE.getFacade_Virtualmetamodel(), facade.getVirtualmetamodel());
		editingDomain.getCommandStack().execute(commandMetaclasses);

		RemoveCommand commandStereotype = new RemoveCommand(editingDomain, facade, FacadePackage.eINSTANCE.getFacade_ExtensionDefinitions(), facade.getExtensionDefinitions());
		editingDomain.getCommandStack().execute(commandStereotype);
	}


	protected class FacadeInitializer extends MouseAdapter {

		/**
		 * Open profiles to start the definition of the facade.
		 */
		protected void openProfile() {
			RegisteredProfile[] regProfiles = RegisteredProfile.getRegisteredProfiles();
			ListSelectionDialog dlg = new ListSelectionDialog(Display.getCurrent().getActiveShell(), Arrays.asList(regProfiles), new IStructuredContentProvider() {

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				}

				public void dispose() {
				}

				public Object[] getElements(Object inputElement) {
					if(inputElement instanceof List) {
						return ((List<?>)inputElement).toArray();
					}
					return Collections.emptyList().toArray();
				}
			}, new ExtensionLabelProvider(), Messages.FacadeSpecificEditor_1);
			dlg.setTitle(Messages.FacadeSpecificEditor_2);
			dlg.open();
			if(dlg.getResult() != null) {

				for(Object selectedElement : dlg.getResult()) {
					if(selectedElement instanceof RegisteredProfile) {
						EObject model = UMLModelUtils.loadModel(((RegisteredProfile)selectedElement).uri, profileResourceSet);
						if(model instanceof Profile) {
							TreeIterator<EObject> it = model.eAllContents();
							boolean failed = false;
							while(it.hasNext() && !failed) {
								EObject eObject = (EObject)it.next();
								if(eObject instanceof PrimitiveType) {
									Stereotype stereotype = ((PrimitiveType)eObject).getAppliedStereotype("Ecore::EDataType"); //$NON-NLS-1$
									if(stereotype != null) {
										Object value = ((PrimitiveType)eObject).getValue(stereotype, "instanceClassName"); //$NON-NLS-1$
										if(!(value instanceof String)) {
											failed = true;
											MessageDialog.openError(getContainer().getShell(), Messages.FacadeSpecificEditor_5, Messages.FacadeSpecificEditor_6 + ((PrimitiveType)eObject).getName() + Messages.FacadeSpecificEditor_7);
										}
									}
								}
								if(eObject instanceof Extension) {
									if(((Extension)eObject).isRequired()) {
										failed = true;
										MessageDialog.openError(getContainer().getShell(), Messages.FacadeSpecificEditor_8, Messages.FacadeSpecificEditor_9);
									}
								}
							}
							if(!failed) {
								profileModels.add((Profile)model);
							}
						} else {
							MessageDialog.openError(getContainer().getShell(), Messages.FacadeSpecificEditor_10, Messages.FacadeSpecificEditor_11);
						}
					}
				}
			}
		}

		/**
		 * @see org.eclipse.swt.events.MouseAdapter#mouseUp(org.eclipse.swt.events.MouseEvent)
		 * 
		 * @param e
		 */

		public void mouseUp(MouseEvent e) {

			profileModels.clear();

			openProfile();

			if(!profileModels.isEmpty()) {

				clearModel();
				ProfileUtils.clearSiblings();

				VirtualMetamodel virtualMetamodel = VirtualmetamodelFactory.eINSTANCE.createVirtualMetamodel();
				virtualMetamodel.setName(""); //$NON-NLS-1$
				virtualMetamodel.setNsPrefix(""); //$NON-NLS-1$
				virtualMetamodel.setNsURI(""); //$NON-NLS-1$

				SetCommand command = new SetCommand(editingDomain, facade, FacadePackage.eINSTANCE.getFacade_Virtualmetamodel(), virtualMetamodel);
				editingDomain.getCommandStack().execute(command);

				createExtensionDefinitions();

				extensionDefintionTreeViewer.refresh();

				metamodelTreeViewer.refresh();
			}
		}
	}

	/**
	 * Creates the extension definitions from the selected UML profiles
	 */
	protected void createExtensionDefinitions() {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
		try {
			dialog.run(false, false, new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {
					monitor.beginTask(Messages.FacadeSpecificEditor_15, IProgressMonitor.UNKNOWN);

					// Find all extensions be it in the profile or in another profile
					Set<Extension> extensions = new HashSet<Extension>();

					for(Profile profile : profileModels) {

						TreeIterator<EObject> iterator = profile.eAllContents();
						while(iterator.hasNext()) {
							EObject eObject = (EObject)iterator.next();
							if(eObject instanceof Stereotype) {

								extensions.addAll(ProfileUtils.findExtensions((Stereotype)eObject));

							}
						}
					}

					for(Extension extension : extensions) {

						List<Stereotype> stereotypes = ProfileUtils.findAllSubsInProfile(extension.getStereotype());

						stereotypes.add(extension.getStereotype());

						for(Stereotype stereotype : stereotypes) {
							ExtensionDefinition extensionDefinition = ExtensiondefinitionFactory.eINSTANCE.createExtensionDefinition();
							extensionDefinition.setExtension(extension);
							extensionDefinition.setKind(ExtensionDefinitionKind.ASSOCIATION);
							extensionDefinition.setStereotype(stereotype);

							AddCommand command = new AddCommand(editingDomain, facade, FacadePackage.eINSTANCE.getFacade_ExtensionDefinitions(), extensionDefinition);
							editingDomain.getCommandStack().execute(command);

							ProfileUtils.initSiblings(stereotype);

							List<EClass> baseMetaclasses = StereotypeUtils.getAllExtendableMetaclasses(extension, false);
							for(EClass eClass : baseMetaclasses) {

								BaseMetaclass baseMetaclass = ExtensiondefinitionFactory.eINSTANCE.createBaseMetaclass();
								baseMetaclass.setBase(eClass);
								baseMetaclass.setPossible(true);

								AddCommand command2 = new AddCommand(editingDomain, extensionDefinition, ExtensiondefinitionPackage.eINSTANCE.getExtensionDefinition_BaseMetaclasses(), baseMetaclass);
								editingDomain.getCommandStack().execute(command2);
							}
						}
					}

					EditionUtils.initAllStereotypeCombinations(facade, editingDomain);

					EditionUtils.initIsPossible(facade, editingDomain);

					monitor.done();

				}

			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see org.eclipse.papyrus.facade.presentation.FacadeEditor#createPages()
	 * 
	 */
	public void createPages() {
		// Creates the model from the editor input
		createModel();

		// Only creates the other pages if there is something that can be edited
		if(!getEditingDomain().getResourceSet().getResources().isEmpty()) {
			Composite composite = new Composite(getContainer(), SWT.NONE);
			composite.setLayout(new GridLayout(1, true));

			initializeButton = new Button(composite, SWT.PUSH);
			initializeButton.setText(Messages.FacadeSpecificEditor_16);
			initializeButton.addMouseListener(new FacadeInitializer());

			tabFolder = new TabFolder(composite, SWT.BORDER);
			GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
			tabFolder.setLayoutData(layoutData);
			tabFolder.setLayout(new GridLayout(1, true));

			TabItem clarifyExtensionsTabItem = new TabItem(tabFolder, SWT.NONE);
			clarifyExtensionsTabItem.setText(Messages.FacadeSpecificEditor_17);

			createClarifyExtension(tabFolder, clarifyExtensionsTabItem);

			TabItem designMetamodelTabItem = new TabItem(tabFolder, SWT.NONE);
			designMetamodelTabItem.setText(Messages.FacadeSpecificEditor_18);

			createDesignMetamodel(tabFolder, designMetamodelTabItem);

			TabItem generateMetamodelTabItem = new TabItem(tabFolder, SWT.NONE);
			generateMetamodelTabItem.setText(Messages.FacadeSpecificEditor_19);

			createGenerateEcore(tabFolder, generateMetamodelTabItem);

			tabFolder.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					if(tabFolder.getSelectionIndex() <= 1) {
						extensionDefintionTreeViewer.refresh();
						metamodelTreeViewer.refresh();
					}
				}
			});

			addPage(composite);
			setActivePage(0);
		}

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		getContainer().addControlListener(new ControlAdapter() {

			boolean guard = false;

			public void controlResized(ControlEvent event) {
				if(!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});

		getSite().getShell().getDisplay().asyncExec(new Runnable() {

			public void run() {
				updateProblemIndication();
			}
		});
	}

	/**
	 * Creates the tab corresponding to the generation of the actual ECore metamodel
	 * 
	 * @param tabFolder
	 *        the tab folder
	 * @param generateMetamodelTabItem
	 *        the generate metamodel tab item
	 */
	protected void createGenerateEcore(Composite tabFolder, TabItem generateMetamodelTabItem) {
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, false);
		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(layoutData);
		composite.setLayout(new GridLayout(1, true));

		Label metamodelNameLabel = new Label(composite, SWT.NONE);
		metamodelNameLabel.setText(Messages.FacadeSpecificEditor_21);
		metamodelName = new Text(composite, SWT.BORDER);
		metamodelName.setLayoutData(layoutData);
		if(facade.getVirtualmetamodel() != null) {
			if(facade.getVirtualmetamodel().getName() != null) {
				metamodelName.setText(facade.getVirtualmetamodel().getName());
			} else {
				metamodelName.setText(""); //$NON-NLS-1$
			}
		}
		metamodelName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SetCommand commandName = new SetCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_Name(), metamodelName.getText());
				editingDomain.getCommandStack().execute(commandName);
			}
		});

		Label nsPrefixLabel = new Label(composite, SWT.NONE);
		nsPrefixLabel.setText(Messages.FacadeSpecificEditor_23);
		nsPrefix = new Text(composite, SWT.BORDER);
		nsPrefix.setLayoutData(layoutData);
		if(facade.getVirtualmetamodel() != null) {
			if(facade.getVirtualmetamodel().getNsPrefix() != null) {
				nsPrefix.setText(facade.getVirtualmetamodel().getNsPrefix());
			} else {
				nsPrefix.setText(""); //$NON-NLS-1$
			}
		}
		nsPrefix.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SetCommand commandName = new SetCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_NsPrefix(), nsPrefix.getText());
				editingDomain.getCommandStack().execute(commandName);

			}
		});

		Label nsURILabel = new Label(composite, SWT.NONE);
		nsURILabel.setText(Messages.FacadeSpecificEditor_25);
		nsURI = new Text(composite, SWT.BORDER);
		nsURI.setLayoutData(layoutData);
		if(facade.getVirtualmetamodel() != null) {
			if(facade.getVirtualmetamodel().getNsURI() != null) {
				nsURI.setText(facade.getVirtualmetamodel().getNsURI());
			} else {
				nsURI.setText(""); //$NON-NLS-1$
			}
		}
		nsURI.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				SetCommand commandName = new SetCommand(editingDomain, facade.getVirtualmetamodel(), VirtualmetamodelPackage.eINSTANCE.getVirtualMetamodel_NsURI(), nsURI.getText());
				editingDomain.getCommandStack().execute(commandName);

			}
		});

		createEcoreButton = new Button(composite, SWT.NONE);
		createEcoreButton.setText(Messages.FacadeSpecificEditor_27);
		createEcoreButton.addMouseListener(new EcoreGenerator(facade, editingDomain));

		generateMetamodelTabItem.setControl(composite);
	}

	/**
	 * Creates the tab used to define the wanted facade metamodel.
	 * 
	 * @param tabFolder
	 *        the tab folder
	 * @param designMetamodelTabItem
	 *        the design metamodel tab item
	 */
	protected void createDesignMetamodel(Composite tabFolder, TabItem designMetamodelTabItem) {

		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		Composite composite = new Composite(tabFolder, SWT.NONE);
		composite.setLayoutData(layoutData);
		composite.setLayout(new GridLayout(1, true));

		createMetamodelButton = new Button(composite, SWT.NONE);
		createMetamodelButton.setText(Messages.FacadeSpecificEditor_28);
		createMetamodelButton.addMouseListener(new CreatePreliminaryMetamodelListener(facade, editingDomain));

		SashForm sashFormMetamodel = new SashForm(composite, SWT.VERTICAL);
		layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashFormMetamodel.setLayoutData(layoutData);
		sashFormMetamodel.setLayout(new GridLayout(1, true));

		metamodelFilteredTreeViewer = new FilteredTree(sashFormMetamodel, SWT.BORDER | SWT.FULL_SELECTION, new PatternFilter(), true);
		metamodelTreeViewer = metamodelFilteredTreeViewer.getViewer();
		metamodelTreeViewer.getControl().setLayoutData(layoutData);
		metamodelTree = metamodelTreeViewer.getTree();
		metamodelTree.setHeaderVisible(true);

		TreeViewerColumn metaclassTreeViewerColumn = new TreeViewerColumn(metamodelTreeViewer, SWT.NONE);
		TreeColumn metaclassTreeColumn = metaclassTreeViewerColumn.getColumn();
		metaclassTreeColumn.setWidth(300);
		metaclassTreeColumn.setText(Messages.FacadeSpecificEditor_29);

		TreeViewerColumn metaclassToKeepTreeViewerColumn = new TreeViewerColumn(metamodelTreeViewer, SWT.NONE);
		TreeColumn metaclassToKeepTreeColumn = metaclassToKeepTreeViewerColumn.getColumn();
		metaclassToKeepTreeColumn.setWidth(60);
		metaclassToKeepTreeColumn.setText(Messages.FacadeSpecificEditor_30);
		metaclassToKeepTreeViewerColumn.setEditingSupport(new MetaclassToKeepColumnEditingSupport(metamodelTreeViewer, editingDomain, metamodelTree, facade));

		TreeViewerColumn metaclassAliasTreeViewerColumn = new TreeViewerColumn(metamodelTreeViewer, SWT.NONE);
		TreeColumn metaclassAliasTreeColumn = metaclassAliasTreeViewerColumn.getColumn();
		metaclassAliasTreeColumn.setWidth(300);
		metaclassAliasTreeColumn.setText(Messages.FacadeSpecificEditor_31);
		metaclassAliasTreeViewerColumn.setEditingSupport(new MetaclassAliasColumnEditingSupport(metamodelTreeViewer, editingDomain, metamodelTree));

		TreeViewerColumn metaclassIsAbstractTreeViewerColumn = new TreeViewerColumn(metamodelTreeViewer, SWT.NONE);
		TreeColumn metaclassIsAbstractTreeColumn = metaclassIsAbstractTreeViewerColumn.getColumn();
		metaclassIsAbstractTreeColumn.setWidth(100);
		metaclassIsAbstractTreeColumn.setText(Messages.FacadeSpecificEditor_32);
		metaclassIsAbstractTreeViewerColumn.setEditingSupport(new MetaclassIsAbstractColumnEditingSupport(metamodelTreeViewer, editingDomain, metamodelTree));

		TreeViewerColumn metaclassUseRepresentedTreeViewerColumn = new TreeViewerColumn(metamodelTreeViewer, SWT.NONE);
		TreeColumn metaclassUseRepresentedTreeColumn = metaclassUseRepresentedTreeViewerColumn.getColumn();
		metaclassUseRepresentedTreeColumn.setWidth(100);
		metaclassUseRepresentedTreeColumn.setText(Messages.FacadeSpecificEditor_0);
		metaclassUseRepresentedTreeViewerColumn.setEditingSupport(new MetaclassUseRepresentedColumnEditingSupport(metamodelTreeViewer, editingDomain, metamodelTree));

		metamodelTreeViewer.setContentProvider(new MetamodelContentProvider());
		metamodelTreeViewer.setLabelProvider(new MetamodelLabelProvider());
		metamodelTreeViewer.setInput(facade);

		metamodelTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection)event.getSelection()).getFirstElement();
					propertiesTreeViewer.setInput(first);
					propertiesTreeViewer.refresh();
				}

			}
		});

		propertiesTreeViewer = new TreeViewer(sashFormMetamodel, SWT.BORDER | SWT.FULL_SELECTION);
		propertiesTreeViewer.getControl().setLayoutData(layoutData);
		propertiesTree = propertiesTreeViewer.getTree();
		propertiesTree.setHeaderVisible(true);

		TreeViewerColumn propertiesTableViewerColumn = new TreeViewerColumn(propertiesTreeViewer, SWT.NONE);
		TreeColumn propertiesTableColumn = propertiesTableViewerColumn.getColumn();
		propertiesTableColumn.setWidth(200);
		propertiesTableColumn.setText(Messages.FacadeSpecificEditor_33);

		TreeViewerColumn propertiesToKeepTableViewerColumn = new TreeViewerColumn(propertiesTreeViewer, SWT.NONE);
		TreeColumn propertiesToKeepTableColumn = propertiesToKeepTableViewerColumn.getColumn();
		propertiesToKeepTableColumn.setWidth(60);
		propertiesToKeepTableColumn.setText(Messages.FacadeSpecificEditor_34);
		propertiesToKeepTableViewerColumn.setEditingSupport(new PropertiesToKeepColumnEditingSupport(propertiesTreeViewer, editingDomain, propertiesTree));

		TreeViewerColumn propertiesAliasTableViewerColumn = new TreeViewerColumn(propertiesTreeViewer, SWT.NONE);
		TreeColumn propertiesAliasTreeColumn = propertiesAliasTableViewerColumn.getColumn();
		propertiesAliasTreeColumn.setWidth(200);
		propertiesAliasTreeColumn.setText(Messages.FacadeSpecificEditor_35);
		propertiesAliasTableViewerColumn.setEditingSupport(new PropertiesAliasColumnEdintingSupport(propertiesTreeViewer, editingDomain, propertiesTree));

		TreeViewerColumn propertiesMinTableViewerColumn = new TreeViewerColumn(propertiesTreeViewer, SWT.NONE);
		TreeColumn propertiesMinTreeColumn = propertiesMinTableViewerColumn.getColumn();
		propertiesMinTreeColumn.setWidth(50);
		propertiesMinTreeColumn.setText(Messages.FacadeSpecificEditor_36);
		propertiesMinTableViewerColumn.setEditingSupport(new PropertiesMinColumnEdintingSupport(propertiesTreeViewer, editingDomain, propertiesTree));

		TreeViewerColumn propertiesMaxTableViewerColumn = new TreeViewerColumn(propertiesTreeViewer, SWT.NONE);
		TreeColumn propertiesMaxTreeColumn = propertiesMaxTableViewerColumn.getColumn();
		propertiesMaxTreeColumn.setWidth(50);
		propertiesMaxTreeColumn.setText(Messages.FacadeSpecificEditor_37);
		propertiesMaxTableViewerColumn.setEditingSupport(new PropertiesMaxColumnEdintingSupport(propertiesTreeViewer, editingDomain, propertiesTree));

		propertiesTreeViewer.setContentProvider(new TypedElementContentProvider());
		propertiesTreeViewer.setLabelProvider(new TypedElementLabelProvider());

		designMetamodelTabItem.setControl(composite);

	}

	/**
	 * Creates the tab used to clarify extensions identified in the UML profiles
	 * 
	 * @param tabFolder
	 *        the tab folder
	 * @param clarifyExtensionsTabItem
	 *        the clarify extensions tab item
	 */
	protected void createClarifyExtension(Composite tabFolder, TabItem clarifyExtensionsTabItem) {
		GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);

		final SashForm sashForm = new SashForm(tabFolder, SWT.HORIZONTAL);
		layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
		sashForm.setLayoutData(layoutData);
		sashForm.setLayout(new GridLayout(1, true));

		extensionDefintionFilteredTreeViewer = new FilteredTree(sashForm, SWT.BORDER | SWT.FULL_SELECTION, new PatternFilter(), true);
		extensionDefintionTreeViewer = extensionDefintionFilteredTreeViewer.getViewer();
		extensionDefintionTreeViewer.getControl().setLayoutData(layoutData);
		extensionDefinitionTable = extensionDefintionTreeViewer.getTree();
		extensionDefinitionTable.setHeaderVisible(true);

		TreeViewerColumn extensionDefinitionTableViewerColumn = new TreeViewerColumn(extensionDefintionTreeViewer, SWT.NONE);
		TreeColumn extensionDefinitionTableColumn = extensionDefinitionTableViewerColumn.getColumn();
		extensionDefinitionTableColumn.setWidth(300);
		extensionDefinitionTableColumn.setText(Messages.FacadeSpecificEditor_38);

		TreeViewerColumn extensionKindTableViewerColumn = new TreeViewerColumn(extensionDefintionTreeViewer, SWT.NONE);
		TreeColumn extensionKindTableColumn = extensionKindTableViewerColumn.getColumn();
		extensionKindTableColumn.setWidth(150);
		extensionKindTableColumn.setText(Messages.FacadeSpecificEditor_39);
		extensionKindTableViewerColumn.setEditingSupport(new ExtensionKindColumnEditingSupport(extensionDefintionTreeViewer, editingDomain, extensionDefinitionTable));

		TreeViewerColumn isPossibleTableViewerColumn = new TreeViewerColumn(extensionDefintionTreeViewer, SWT.NONE);
		TreeColumn isPossibleTableColumn = isPossibleTableViewerColumn.getColumn();
		isPossibleTableColumn.setWidth(200);
		isPossibleTableColumn.setText(Messages.FacadeSpecificEditor_40);
		isPossibleTableViewerColumn.setEditingSupport(new IsPossibleColumnEditingSupport(extensionDefintionTreeViewer, editingDomain, extensionDefinitionTable));

		extensionDefintionTreeViewer.setContentProvider(new ExtensionDefintionContentProvider());
		extensionDefintionTreeViewer.setLabelProvider(new ExtensionDefintionLabelProvider());
		extensionDefintionTreeViewer.setInput(facade);

		extensionDefintionTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				if(event.getSelection() instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection)event.getSelection()).getFirstElement();
					incompatibilitiesTableViewer.setInput(first);
					incompatibilitiesTableViewer.refresh();
				}

			}
		});

		incompatibilitiesTableViewer = new TableViewer(sashForm, SWT.BORDER | SWT.FULL_SELECTION);
		incompatibilitiesTableViewer.getControl().setLayoutData(layoutData);
		incompatibilitiesTable = incompatibilitiesTableViewer.getTable();
		incompatibilitiesTable.setHeaderVisible(true);

		TableViewerColumn stereoTableViewerColumn = new TableViewerColumn(incompatibilitiesTableViewer, SWT.NONE);
		TableColumn stereoTableColumn = stereoTableViewerColumn.getColumn();
		stereoTableColumn.setWidth(300);
		stereoTableColumn.setText(Messages.FacadeSpecificEditor_41);

		TableViewerColumn stereoIncompatibilityTableViewerColumn = new TableViewerColumn(incompatibilitiesTableViewer, SWT.NONE);
		TableColumn stereoIncompatibilityTableColumn = stereoIncompatibilityTableViewerColumn.getColumn();
		stereoIncompatibilityTableColumn.setWidth(150);
		stereoIncompatibilityTableColumn.setText(Messages.FacadeSpecificEditor_42);
		stereoIncompatibilityTableViewerColumn.setEditingSupport(new StereotypeIncompatibilityColumnEditingSupport(incompatibilitiesTableViewer, editingDomain, incompatibilitiesTable));

		incompatibilitiesTableViewer.setContentProvider(new IncompatibilitiesContentProvider());
		incompatibilitiesTableViewer.setLabelProvider(new IncompatibilitiesLabelProvider());

		clarifyExtensionsTabItem.setControl(sashForm);

	}
}
