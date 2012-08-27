/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.views.properties.runtime.controller.descriptor.ControllerDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.dialogs.PropertyDialog;
import org.eclipse.papyrus.views.properties.runtime.state.IFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.runtime.view.DialogDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.FragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.PredefinedFragmentDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.PropertyViewService;
import org.eclipse.papyrus.views.properties.runtime.view.XMLParseException;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.AppliedStereotypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ConstraintDescriptorState;
import org.eclipse.papyrus.views.properties.runtime.view.constraints.ObjectTypeConstraintDescriptor;
import org.eclipse.papyrus.views.properties.runtime.view.content.ContainerDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicSectionDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.DynamicTabDescriptor;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.StatesStore;
import org.eclipse.papyrus.views.properties.tabbed.core.view.TabDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState.ReplacedSectionState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.papyrus.views.properties.tabbed.customization.Messages;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.ContainerMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.ContentHolderMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.ControllerMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.EClassifierMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.FragmentMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.PredefinedFragmentMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.ReplacedSectionMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.SectionMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.SectionSetMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.dialog.actions.StereotypeMenuCreator;
import org.eclipse.papyrus.views.properties.tabbed.customization.state.StatePropertyTabViewProviderParser;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.views.properties.tabbed.ITabDescriptor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Wizard page where user can customize the content of the property view
 */
@SuppressWarnings("restriction")
public class CustomizeContentWizardPage extends WizardPage {

	/** initial content */
	protected Document document;

	/** UML metamodel label for the metamodel selection combo */
	protected static final String UML_METAMODEL = "UML"; //$NON-NLS-1$

	/** Tree viewer on the metamodel and the set of available section sets descriptors */
	protected FilteredTree metamodelViewer;

	/** current selection of section set */
	protected SectionSetDescriptorState currentSectionSetDescriptorState;

	/** current selection of metaclass */
	protected EClassifier currentMetaClass;

	/** tree viewer for the configuration area */
	protected TreeViewer configurationViewer;

	/** viewer for tabs */
	protected TableViewer tabViewer;

	/** current tab selection */
	protected TabDescriptorState selectedTab;

	/** preview area */
	protected ScrolledComposite previewArea;

	/** widget factory for preview area */
	protected TabbedPropertySheetWidgetFactory factory = new TabbedPropertySheetWidgetFactory();

	/** current selection size for the preview */
	protected int currentSelectionsize = 1;

	/** area displaying the current selection size */
	protected Combo sizeArea;

	/** values in the selection size combo */
	protected final static List<String> sizeValues = Arrays.asList("1", "-1"); //$NON-NLS-1$ //$NON-NLS-2$

	/** file where to save the content of the configuration */
	protected File file;

	/** list of available metamodels or profile */
	protected List<EObject> metamodels = new ArrayList<EObject>();

	/** combo to select metamodel being edited */
	protected CCombo metamodelSelectionCombo;

	/** current selected stereotype */
	protected Stereotype currentStereoype;

	/**
	 * Creates a new CustomizeContentWizardPage.
	 */
	public CustomizeContentWizardPage() {
		super(Messages.CustomizeContentWizardPage_Title, Messages.CustomizeContentWizardPage_Message, null);
	}

	/** filters for the metamodel tree viewer */
	private List<ViewerFilter> metamodelViewerFilters;

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		SashForm sashForm = new SashForm(composite, SWT.HORIZONTAL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createContentExplorer(sashForm);
		createConfigurationArea(sashForm);

		sashForm.setWeights(new int[]{ 40, 60 });

		setControl(composite);
	}

	/**
	 * Sets the initial content for this page
	 * 
	 * @param initialContent
	 *        the initial content for this page, i.e. the document
	 */
	public void setInitialContent(Document document) {
		this.document = document;

		// parses the content of the document to create the
		// SectionSetDescriptors states
		List<ITabDescriptor> tabDescriptors = new ArrayList<ITabDescriptor>();

		StatePropertyTabViewProviderParser parser = new StatePropertyTabViewProviderParser(tabDescriptors);
		try {
			parser.parseXMLfile(document, PropertyViewService.getInstance().getAllFragmentDescriptors(), new HashMap<String, DialogDescriptor>());
			StatesStore.setSectionSetDescriptorStates(parser.getSectionSetDescriptorStates());
			StatesStore.setTabDescriptorStates(parser.getTabDescriptorStates());
			metamodelViewer.getViewer().setContentProvider(new MetamodelContentProvider(StatesStore.getSectionSetDescriptorStates()));
			metamodelViewer.getViewer().setLabelProvider(new MetamodelLabelProvider());

			// load by default the metamodel
			metamodelViewer.getViewer().setInput(UMLPackage.eINSTANCE);
			metamodelSelectionCombo.select(0);
			tabViewer.setInput(StatesStore.getTabDescriptorStates());
		} catch (XMLParseException e) {
			Activator.log.error(e);
		}
	}

	/**
	 * Returns the final content for this page
	 * 
	 * @return the final content for this page
	 */
	public Document getFinalContent() {
		return createFinalDocument();
	}

	/**
	 * Creates the final document, serializing the existing section set
	 * descriptor states
	 * 
	 * @return the final document created
	 */
	protected Document createFinalDocument() {
		// remove existing elements on the current document
		Node topNode = retrieveTopNode(document);

		if(topNode == null) {
			return document;
		}

		removeAllExistingSectionSetDescriptors(topNode);

		removeAllExistingTabDescriptors(topNode);

		// add all new tab descriptors using states
		for(TabDescriptorState state : StatesStore.getTabDescriptorStates()) {
			topNode.appendChild(state.generateNode(document));
		}

		// add all new section set descriptors using states
		for(SectionSetDescriptorState state : StatesStore.getSectionSetDescriptorStates()) {
			topNode.appendChild(state.generateNode(document));
		}

		return document;
	}



	/**
	 * Retrieves the top node for this document
	 * 
	 * @param document
	 *        the document to look in
	 */
	protected Node retrieveTopNode(Document document) {
		NodeList childNodes = document.getChildNodes();
		for(int i = 0; i < childNodes.getLength(); i++) {
			Node childNode = childNodes.item(i);
			// be sure child node is the propertyTabView node
			if("propertyTabView".equals(childNode.getNodeName())) {
				return childNode;
			}
		}
		Activator.log.error(Messages.CustomizeContentWizardPage_Error_NoRootNode, null);
		return null;
	}

	/**
	 * Removes all section set descriptors child of the specified node
	 * 
	 * @param topNode
	 *        the node that contains the element to remove
	 */
	protected void removeAllExistingSectionSetDescriptors(Node topNode) {
		NodeList children = topNode.getChildNodes();
		for(int i = children.getLength() - 1; i >= 0; i--) {
			Node child = children.item(i);
			if("sectionSet".equals(child.getNodeName())) {
				topNode.removeChild(child);
				child = null;
			}
		}
	}

	/**
	 * Removes all tab descriptors child of the specified node
	 * 
	 * @param topNode
	 *        the node that contains the element to remove
	 */
	protected void removeAllExistingTabDescriptors(Node topNode) {
		NodeList children = topNode.getChildNodes();
		for(int i = children.getLength() - 1; i >= 0; i--) {
			Node child = children.item(i);
			if("tab".equals(child.getNodeName())) {
				topNode.removeChild(child);
				child = null;
			}
		}
	}

	/**
	 * Creates the configuration area, where the configuration for one model
	 * element is displayed. This is the part on the right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationArea(Composite composite) {
		SashForm configurationAreaSashForm = new SashForm(composite, SWT.VERTICAL);
		configurationAreaSashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		createConfigurationEditor(configurationAreaSashForm);
		createPreviewArea(configurationAreaSashForm);

		configurationAreaSashForm.setWeights(new int[]{ 50, 50 });
	}

	/**
	 * Creates the configuration editor, where the configuration for one model
	 * element can be edited
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createConfigurationEditor(Composite composite) {
		Composite configurationAreaComposite = new Composite(composite, SWT.NONE);
		configurationAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label titleLabel = new Label(configurationAreaComposite, SWT.NONE);
		titleLabel.setText(Messages.CustomizeContentWizardPage_ConfigurationArea_Label);

		// content tree and viewer on this tree
		Tree configurationTree = new Tree(configurationAreaComposite, SWT.BORDER);
		configurationTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		configurationViewer = new TreeViewer(configurationTree);
		configurationViewer.setContentProvider(new ConfigurationContentProvider());
		configurationViewer.setLabelProvider(new ConfigurationLabelProvider());
		configurationViewer.addDoubleClickListener(new IDoubleClickListener() {

			/**
			 * {@inheritDoc}
			 */
			public void doubleClick(DoubleClickEvent event) {
				// edit element on which double click occurs => open edit dialog
				ITreeSelection selection = (ITreeSelection)event.getSelection();
				Object selectedElement = selection.getFirstElement();

				// if element is a state, opens the dialog on this state
				if(selectedElement instanceof IState) {
					openEditionDialog(((IState)selectedElement));
				}
			}
		});
		configurationViewer.getTree().addMenuDetectListener(new MenuDetectListener() {

			/**
			 * {@inheritDoc}
			 */
			public void menuDetected(MenuDetectEvent e) {
				// retrieve current selection, this should be a state or
				// a contentHolder/constraintholder
				ITreeSelection selection = (ITreeSelection)configurationViewer.getSelection();
				if(selection == null || selection.size() < 1) {
					Activator.log.warn(Messages.CustomizeContentWizardPage_Error_NoSelectionFound);
					return;
				}

				Object selectedObject = selection.getFirstElement();
				Menu menu = null;
				// awful code, should delegate to each state which menu
				// should be created
				if(selectedObject instanceof SectionDescriptorState) {
					menu = new SectionMenuCreator(((SectionDescriptorState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof FragmentDescriptorState) {
					menu = new FragmentMenuCreator(((FragmentDescriptorState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof PredefinedFragmentDescriptorState) {
					menu = new PredefinedFragmentMenuCreator(((PredefinedFragmentDescriptorState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof ContainerDescriptorState) {
					menu = new ContainerMenuCreator(((ContainerDescriptorState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof ControllerDescriptorState) {
					menu = new ControllerMenuCreator(((ControllerDescriptorState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof ContentHolder) {
					menu = new ContentHolderMenuCreator(((ContentHolder)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				} else if(selectedObject instanceof ReplacedSectionState) {
					menu = new ReplacedSectionMenuCreator(((ReplacedSectionState)selectedObject), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(configurationViewer.getTree());
				}

				if(menu != null) {
					// creates the menu, depending on the selection
					menu.setVisible(true);
				}
			}
		});
	}

	/**
	 * Opens an edition dialog on the given state
	 * 
	 * @param iState
	 *        the state to edit
	 */
	protected void openEditionDialog(IState iState) {
		// find editor descriptor...
		DialogDescriptor descriptor = PropertyViewService.getInstance().getDialogDescriptor(iState.getEditionDialogId());
		List<Object> objectsToEdit = new ArrayList<Object>();
		objectsToEdit.add(iState);

		if(descriptor != null) {
			Shell parentShell = getShell();
			PropertyDialog dialog = new PropertyDialog(parentShell, descriptor, objectsToEdit, new TabbedPropertySheetWidgetFactory());
			dialog.open();
		} else {
			Activator.log.warn(Messages.CustomizeContentWizardPage_Error_NoEditorForElement + iState);
		}
	}

	/**
	 * Creates the area where the preview of the property view is displayed.
	 * This is the part in the lower right.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createPreviewArea(Composite composite) {
		Composite previewAreaComposite = new Composite(composite, SWT.NONE);
		previewAreaComposite.setLayout(new GridLayout(2, false));
		// previewAreaComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
		// true, false));

		Composite titleArea = new Composite(previewAreaComposite, SWT.NONE);
		GridLayout layout = new GridLayout(5, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		titleArea.setLayout(layout);
		titleArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));

		// title of this area
		Label titleLabel = new Label(titleArea, SWT.NONE);
		titleLabel.setText(Messages.CustomizeContentWizardPage_PreviewArea_Label);
		titleLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Composite selectionSize = new Composite(titleArea, SWT.NONE);
		layout = new GridLayout(2, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		selectionSize.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, false, false);
		selectionSize.setLayoutData(data);

		Label sizeLabel = new Label(selectionSize, SWT.NONE);
		sizeLabel.setText(Messages.CustomizeContentWizardPage_PreviewArea_SelectionSizeLabel);

		sizeArea = new Combo(selectionSize, SWT.BORDER | SWT.READ_ONLY);
		sizeArea.setItems(sizeValues.toArray(new String[0]));
		sizeArea.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				int index = sizeArea.getSelectionIndex();
				if(index >= 0) {
					setCurrentSelectionsize(Integer.parseInt(sizeValues.get(index)));
				} else {
					Activator.log.error(Messages.CustomizeContentWizardPage_Error_OutOfBoundExceptionIndex, null);
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});
		updateSizeArea();

		Button button = new Button(titleArea, SWT.NONE);
		button.setImage(Activator.getImage("/icons/Refresh.gif")); //$NON-NLS-1$
		button.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_RefreshButtonTooltip);
		button.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				updatePreview();
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Button validateButton = new Button(titleArea, SWT.NONE);
		validateButton.setImage(Activator.getImage("/icons/Validate.gif")); //$NON-NLS-1$
		validateButton.setToolTipText("Validate configuration");
		validateButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				ConfigurationValidator validator = new ConfigurationValidator(getShell());
				validator.validateConfig(false, true);
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Button saveButton = new Button(titleArea, SWT.NONE);
		saveButton.setImage(Activator.getImage("/icons/Save.gif")); //$NON-NLS-1$
		saveButton.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_SaveButtonTooltip);
		saveButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				serializeContent();
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Composite tabArea = new Composite(previewAreaComposite, SWT.NONE);
		data = new GridData(SWT.FILL, SWT.FILL, false, true);
		data.widthHint = 150;
		data.minimumWidth = 150;
		tabArea.setLayoutData(data);
		layout = new GridLayout(4, false);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		tabArea.setLayout(layout);

		Button addTabButton = new Button(tabArea, SWT.NONE);
		addTabButton.setImage(Activator.getImage("/icons/Add_12x12.gif")); //$NON-NLS-1$
		addTabButton.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_AddTabButtonTooltip);
		addTabButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				InputDialog dialog = new InputDialog(getShell(), "Tab label", "Please enter the tab label", "", new IInputValidator() {

					public String isValid(String newText) {
						// FIXME Should check if already present
						return null;
					}
				});
				dialog.open();
				if(dialog.getValue() != null) {
					DynamicTabDescriptor tabDescriptor = new DynamicTabDescriptor("", "tab_" + dialog.getValue(), dialog.getValue());
					StatesStore.getTabDescriptorStates().add(new TabDescriptorState(tabDescriptor, false));
					tabViewer.refresh();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Button deleteTabButton = new Button(tabArea, SWT.NONE);
		deleteTabButton.setImage(Activator.getImage("/icons/Delete_12x12.gif")); //$NON-NLS-1$
		deleteTabButton.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_DeleteTabButtonTooltip);
		deleteTabButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tabViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					StatesStore.getTabDescriptorStates().remove((TabDescriptorState)((IStructuredSelection)selection).getFirstElement());
					tabViewer.refresh();
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Button moveUpTabButton = new Button(tabArea, SWT.NONE);
		moveUpTabButton.setImage(Activator.getImage("/icons/Up_12x12.gif")); //$NON-NLS-1$
		moveUpTabButton.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_MoveUpTabButtonTooltip);
		moveUpTabButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tabViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					int index = StatesStore.getTabDescriptorStates().indexOf(((IStructuredSelection)selection).getFirstElement());
					if(index != 0) {
						TabDescriptorState tab = StatesStore.getTabDescriptorStates().remove(index);
						StatesStore.getTabDescriptorStates().add(index - 1, tab);
						tabViewer.refresh();
					}
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Button moveDownTabButton = new Button(tabArea, SWT.NONE);
		moveDownTabButton.setImage(Activator.getImage("/icons/Down_12x12.gif")); //$NON-NLS-1$
		moveDownTabButton.setToolTipText(Messages.CustomizeContentWizardPage_PreviewArea_MoveDownTabButtonTooltip);
		moveDownTabButton.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = tabViewer.getSelection();
				if(selection instanceof IStructuredSelection) {
					int index = StatesStore.getTabDescriptorStates().indexOf(((IStructuredSelection)selection).getFirstElement());
					if(index != StatesStore.getTabDescriptorStates().size() - 1) {
						TabDescriptorState tab = StatesStore.getTabDescriptorStates().remove(index);
						StatesStore.getTabDescriptorStates().add(index + 1, tab);
						tabViewer.refresh();
					}
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing to do here
			}
		});

		Table table = new Table(tabArea, SWT.BORDER);
		GridData data2 = new GridData(SWT.FILL, SWT.FILL, false, true);
		data2.widthHint = 150;
		data2.minimumWidth = 150;
		data2.horizontalSpan = 4;
		table.setLayoutData(data2);
		tabViewer = new TableViewer(table);
		tabViewer.setLabelProvider(new LabelProvider() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String getText(Object element) {

				if(element instanceof TabDescriptorState) {
					return ((TabDescriptorState)element).getText();
				}
				return super.getText(element);
			}

		});
		tabViewer.setContentProvider(new IStructuredContentProvider() {

			/**
			 * {@inheritDoc}
			 */
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void dispose() {

			}

			/**
			 * {@inheritDoc}
			 */
			public Object[] getElements(Object inputElement) {
				List<Object> results = new ArrayList<Object>();
				if(inputElement instanceof List<?>) {
					List<?> elements = (List<?>)inputElement;
					for(Object o : elements) {
						if(o instanceof TabDescriptorState) {
							results.add((TabDescriptorState)o);
						}
					}
					return results.toArray();
				}
				return new Object[0];
			}
		});

		tabViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				selectedTab = (TabDescriptorState)((IStructuredSelection)event.getSelection()).getFirstElement();
				updatePreview();
			}
		});

		tabViewer.addDoubleClickListener(new IDoubleClickListener() {

			/**
			 * {@inheritDoc}
			 */
			public void doubleClick(DoubleClickEvent event) {
				// edit element on which double click occurs => open edit dialog
				IStructuredSelection selection = (IStructuredSelection)event.getSelection();

				Object selectedElement = selection.getFirstElement();

				// if element is a state, opens the dialog on this state
				if(selectedElement instanceof IState) {
					openEditionDialog(((IState)selectedElement));
				}
				tabViewer.refresh();
			}
		});

		// real preview area
		previewArea = factory.createScrolledComposite(previewAreaComposite, SWT.BORDER);
		previewArea.setAlwaysShowScrollBars(false);
		previewArea.setLayout(new GridLayout(1, true));
		previewArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		Composite content = factory.createComposite(previewArea);
		content.setLayout(new GridLayout(1, true));
		content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		previewArea.setContent(content);
		previewArea.setExpandVertical(true);
		previewArea.setExpandHorizontal(true);
	}

	/**
	 * updates the content of the size area
	 */
	protected void updateSizeArea() {
		if(sizeArea != null && !sizeArea.isDisposed()) {
			sizeArea.select(sizeValues.indexOf("" + currentSelectionsize)); //$NON-NLS-1$
		}
		updatePreview();

	}

	protected boolean isSectionSetDescriptorStateValid(SectionSetDescriptorState state) {
		// check size
		if(state.getSelectionSize() > getCurrentSelectionsize()) {
			return false;
		}
		List<ConstraintDescriptorState> constraintDescriptorStates = state.getConstraintDescriptorStates();
		for(ConstraintDescriptorState constraintDescriptorState : constraintDescriptorStates) {
			// check the object type constraint if the current selected element
			// is a metaclass
			if(getCurrentMetaClass() != null) {
				if(constraintDescriptorState instanceof ObjectTypeConstraintDescriptor.ObjectTypeConstraintDescriptorState) {
					Class<?> elementClass = ((ObjectTypeConstraintDescriptor.ObjectTypeConstraintDescriptorState)constraintDescriptorState).getElementClassState();
					if(elementClass.isAssignableFrom(getCurrentMetaClass().getInstanceClass())) {
						return true;
					}
				}
			} else if(getCurrentStereoype() != null) {
				if(constraintDescriptorState instanceof AppliedStereotypeConstraintDescriptor.AppliedStereotypeConstraintDescriptorState) {
					List<String> stereotypesToApply = ((AppliedStereotypeConstraintDescriptor.AppliedStereotypeConstraintDescriptorState)constraintDescriptorState).getStereotypesToApply();
					if(stereotypesToApply.size() > 0) {
						String stereotypeName = stereotypesToApply.get(0);
						// we have the stereotype qualified name. Now, should
						// check if it fits to the current stereotype or one of
						// its parent
						if(stereotypeName.equals(getCurrentStereoype().getQualifiedName())) {
							return true;
						}
						// check in the general stereotypes list
						List<Stereotype> generalStereotypes = StereotypeUtil.getAllSuperStereotypes(getCurrentStereoype());
						for(Stereotype stereotype : generalStereotypes) {
							if(stereotypeName.equals(stereotype.getQualifiedName())) {
								return true;
							}
						}
					}
				}
			} else {
				Activator.log.warn(Messages.CustomizeContentWizardPage_Warning_NoStereotypeNeitherMetaclass);
			}

		}
		return false;
	}

	/**
	 * update the preview area
	 */
	protected void updatePreview() {
		if(selectedTab != null && !(getCurrentMetaClass() == null && getCurrentStereoype() == null) && previewArea != null && !previewArea.isDisposed()) {
			List<SectionDescriptorState> displayedSections = new ArrayList<SectionDescriptorState>();
			String selectedTabName = selectedTab.getId();
			Composite parent = previewArea.getParent();
			previewArea.dispose();
			previewArea = null;
			previewArea = factory.createScrolledComposite(parent, SWT.VERTICAL | SWT.HORIZONTAL | SWT.BORDER);
			previewArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			Composite content = factory.createComposite(previewArea);
			content.setLayout(new GridLayout(1, true));
			// content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
			// true));
			previewArea.setExpandVertical(true);
			previewArea.setExpandHorizontal(true);
			previewArea.getHorizontalBar().setIncrement(20);
			previewArea.getVerticalBar().setIncrement(20);

			for(SectionSetDescriptorState sectionSetDescriptorState : StatesStore.getSectionSetDescriptorStates()) {
				if(isSectionSetDescriptorStateValid(sectionSetDescriptorState)) {
					// check the content of this section set: sections give the
					// constraints
					for(SectionDescriptorState state : sectionSetDescriptorState.getSectionDescriptorStates()) {
						if(selectedTabName.equals(state.getTargetTab())) {
							displayedSections.add(state);
						}
					}
				}
			}

			List<SectionDescriptorState> filteredSectionstates = new ArrayList<SectionDescriptorState>();
			for(SectionDescriptorState sectionDescriptorState : displayedSections) {
				boolean isRemoved = false;
				String currentId = sectionDescriptorState.getId();
				// is this descriptor removed by another one ?
				for(SectionDescriptorState state : displayedSections) {
					for(ReplacedSectionState replacedSectionState : state.getReplacedSectionStates()) {
						if(replacedSectionState.getId().equals(currentId)) {
							isRemoved = true;
						}
					}
				}

				if(!isRemoved) {
					filteredSectionstates.add(sectionDescriptorState);
				}
			}

			for(SectionDescriptorState state : filteredSectionstates) {
				for(IFragmentDescriptorState fragmentDescriptorState : state.getFragmentDescriptorStates()) {
					for(ContainerDescriptorState containerDescriptorState : fragmentDescriptorState.getContainerDescriptorStates()) {
						containerDescriptorState.createPreview(content);
					}
				}
			}

			previewArea.setContent(content);
			previewArea.getParent().layout(true);
		}
	}

	/**
	 * Specialization that filters metamodel information
	 */
	private class TreeSelectionPatternFilter extends PatternFilter {

		@Override
		protected boolean isParentMatch(Viewer viewer, Object element) {
			if(element instanceof DynamicSectionDescriptor) {
				String labelText = ((DynamicSectionDescriptor)element).getId();
				if(labelText != null) {
					return wordMatches(labelText);
				}
			} else if(element instanceof SectionSetDescriptorState) {
				return true;
			} else if(element instanceof NamedElement) {
				String labelText = ((NamedElement)element).getQualifiedName();
				if(labelText != null) {
					return wordMatches(labelText);
				}
			} else if(element instanceof ModelElementItem) {
				String labelText;
				EObject eObject = ((ModelElementItem)element).getEObject();
				if(eObject instanceof ENamedElement) {
					labelText = ((ENamedElement)((ModelElementItem)element).getEObject()).getName();
				} else {
					labelText = ((ModelElementItem)element).getText();
				}

				if(labelText != null) {
					return wordMatches(labelText);
				}

			}

			return false;
		}

		@Override
		public boolean isElementVisible(Viewer viewer, Object element) {
			return isParentMatch(viewer, element);
		}
	}


	/**
	 * Creates the area where the metamodel elements, the available views and
	 * controllers are displayed. This is the part on the upper left.
	 * 
	 * @param composite
	 *        the parent composite for the controls created in this area
	 */
	protected void createContentExplorer(Composite composite) {
		Composite mainContentAreaComposite = new Composite(composite, SWT.NONE);
		mainContentAreaComposite.setLayout(new GridLayout(1, false));

		// title of this area
		Label contentLabel = new Label(mainContentAreaComposite, SWT.NONE);
		contentLabel.setText(Messages.CustomizeContentWizardPage_ContentArea_Label);

		metamodelSelectionCombo = new CCombo(mainContentAreaComposite, SWT.BORDER | SWT.READ_ONLY);
		metamodelSelectionCombo.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		metamodels = retrieveAvailableMetamodels();
		String[] metamodelNames = retrieveMetamodelNames();
		metamodelSelectionCombo.setItems(metamodelNames);
		metamodelSelectionCombo.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				// update the input of the content view
				metamodelViewer.getViewer().setInput(metamodels.get(metamodelSelectionCombo.getSelectionIndex()));

			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// nothing here
			}
		});

		// treeviewer for the metamodel
		int flags = SWT.BORDER | SWT.SINGLE;

		TreeSelectionPatternFilter patternfilter = new TreeSelectionPatternFilter();
		patternfilter.setIncludeLeadingWildcard(true);
		metamodelViewer = new FilteredTree(mainContentAreaComposite, flags, patternfilter, true);
		metamodelViewer.getViewer().getControl().addMenuDetectListener(new MenuDetectListener() {

			/**
			 * {@inheritDoc}
			 */
			public void menuDetected(MenuDetectEvent e) {
				// retrieve current selection, this should be an EObject or a
				// SectionSetDescriptorState
				ITreeSelection selection = (ITreeSelection)metamodelViewer.getViewer().getSelection();
				if(selection == null || selection.size() < 1) {
					Activator.log.warn(Messages.CustomizeContentWizardPage_Error_NoSelectionForMenuCreation);
					return;
				}

				Object selectedObject = selection.getFirstElement();
				Menu menu = null;
				// awful code, should delegate to each state which menu should
				// be created
				if(selectedObject instanceof SectionSetDescriptorState) {
					menu = new SectionSetMenuCreator(StatesStore.getSectionSetDescriptorStates(), metamodelViewer.getViewer(), (SectionSetDescriptorState)selectedObject, getCurrentMetaClass(), getCurrentStereoype()).getMenu(metamodelViewer.getViewer().getTree());
				} else if(selectedObject instanceof ModelElementItem) {
					ModelElementItem item = (ModelElementItem)selectedObject;
					EObject selectedEObject = item.getEObject();
					if(selectedEObject instanceof EClassifier) {
						menu = new EClassifierMenuCreator((ModelElementItem)selectedObject, StatesStore.getSectionSetDescriptorStates(), metamodelViewer.getViewer(), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(metamodelViewer.getViewer().getTree());
					} else if(selectedEObject instanceof Stereotype) {
						menu = new StereotypeMenuCreator((ModelElementItem)selectedObject, StatesStore.getSectionSetDescriptorStates(), metamodelViewer.getViewer(), getCurrentSectionSetDescriptorState(), getCurrentMetaClass(), getCurrentStereoype()).getMenu(metamodelViewer.getViewer().getTree());
					}
				}

				if(menu != null) {
					// creates the menu, depending on the selection
					menu.setVisible(true);
				}
			}
		});


		metamodelViewer.getViewer().addPostSelectionChangedListener(new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 */
			public void selectionChanged(SelectionChangedEvent event) {
				// update the current section set selection
				TreeSelection selection = ((TreeSelection)event.getSelection());
				Object selectedElement = selection.getFirstElement();
				// this can be a metaclass or a section set descriptor.
				if(selectedElement instanceof ModelElementItem) {
					setCurrentSectionSetDescriptorState(null);
					EObject selectedEObject = ((ModelElementItem)selectedElement).getEObject();
					if(selectedEObject instanceof EClassifier) {
						setCurrentMetaClass((EClassifier)selectedEObject);
						setCurrentStereotype(null);
					} else if(selectedEObject instanceof Stereotype) {
						setCurrentMetaClass(null);
						setCurrentStereotype((Stereotype)selectedEObject);
					} else {
						Activator.log.error(Messages.CustomizeContentWizardPage_Error_SelectionStereotypeOrClassifier + selectedEObject, null);
					}
				} else if(selectedElement instanceof SectionSetDescriptorState) {
					// retrieve the metaclass using the TreePath of the
					// selection
					TreePath[] paths = selection.getPathsFor(selectedElement);
					// metaclass should be the first element in the
					// table
					if(paths.length > 0) {
						TreePath treePath = paths[0];
						Object firstSegment = treePath.getSegment(0);
						if(firstSegment instanceof ModelElementItem) {
							EObject selectedEObject = ((ModelElementItem)firstSegment).getEObject();
							if(selectedEObject instanceof EClassifier) {
								setCurrentMetaClass((EClassifier)selectedEObject);
								setCurrentStereotype(null);
							} else if(selectedEObject instanceof Stereotype) {
								setCurrentMetaClass(null);
								setCurrentStereotype((Stereotype)selectedEObject);
							} else {
								Activator.log.error(Messages.CustomizeContentWizardPage_Error_SelectionStereotypeOrClassifier + selectedEObject, null);
							}
						}
					}
					currentSectionSetDescriptorState = (SectionSetDescriptorState)selectedElement;
				}
				updatePreview();
				updateConfigurationArea();
			}
		});
		metamodelViewer.getViewer().addDoubleClickListener(new IDoubleClickListener() {

			/**
			 * {@inheritDoc}
			 */
			public void doubleClick(DoubleClickEvent event) {
				// edit element on which double click occurs => open edit dialog
				ITreeSelection selection = (ITreeSelection)event.getSelection();
				Object selectedElement = selection.getFirstElement();

				// if element is a state, opens the dialog on this state
				if(selectedElement instanceof IState) {
					openEditionDialog(((IState)selectedElement));
				}
			}
		});

	}

	/**
	 * Returns the list of metamodels names for the list of available metamodels
	 * 
	 * @return the list of metamodels names for the list of available metamodels
	 */
	protected String[] retrieveMetamodelNames() {
		List<String> names = new ArrayList<String>();
		for(EObject object : metamodels) {
			if(object instanceof EPackage) {
				names.add(((EPackage)object).getName());
			} else if(object instanceof Profile) {
				names.add(((Profile)object).getName());
			} else {
				// should not happen
				names.add(object.toString());
			}
		}

		return names.toArray(new String[0]);
	}

	/**
	 * Updates the configuration area
	 */
	protected void updateConfigurationArea() {
		configurationViewer.setInput(currentSectionSetDescriptorState);
		configurationViewer.expandAll();
	}

	/**
	 * Returns the list of metamodels for which a configuration of property view
	 * could be done.
	 * 
	 * @return the list of metamodels, never <code>null</code>.
	 */
	protected List<EObject> retrieveAvailableMetamodels() {
		List<EObject> metamodels = new ArrayList<EObject>();
		DiagramEditor editor = null;
		// retrieve current editor, and current resources
		IEditorPart mainEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if(mainEditor instanceof org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor) {
			editor = (DiagramEditor)((CoreMultiDiagramEditor)mainEditor).getActiveEditor();
		}
		if(editor == null) {
			Activator.log.warn(Messages.CustomizeContentWizardPage_Error_NoActiveDiagram);
			return Collections.emptyList();
		}
		EObject eObject = editor.getDiagram().getElement();
		if(eObject == null) {
			Activator.log.warn(Messages.CustomizeContentWizardPage_Error_NoActiveDiagram);
			return Collections.emptyList();
		}

		if(eObject instanceof Element) {
			// retrieve the top package, and the applied profiles
			metamodels.add(UMLPackage.eINSTANCE);

			org.eclipse.uml2.uml.Package rootPackage = PackageUtil.getRootPackage(((Element)eObject));
			List<Profile> profilesApplied = rootPackage.getAllAppliedProfiles();
			for(Profile profile : profilesApplied) {
				metamodels.add(profile);
			}
		}
		return metamodels;
	}

	/**
	 * Returns a human readable name for the given profile. This name will also
	 * be used to identify which currently selection has been done
	 * 
	 * @param profile
	 *        the profile to display
	 * @return the name of the profile
	 */
	protected String getProfileDisplayName(Profile profile) {
		return profile.getQualifiedName();
	}

	/**
	 * Returns the currentSectionSetDescriptorState
	 * 
	 * @return the currentSectionSetDescriptorState
	 */
	public SectionSetDescriptorState getCurrentSectionSetDescriptorState() {
		return currentSectionSetDescriptorState;
	}

	/**
	 * Sets the currentSectionSetDescriptorState
	 * 
	 * @param currentSectionSetDescriptorState
	 *        the currentSectionSetDescriptorState to set
	 */
	public void setCurrentSectionSetDescriptorState(SectionSetDescriptorState currentSectionSetDescriptorState) {
		this.currentSectionSetDescriptorState = currentSectionSetDescriptorState;
	}

	/**
	 * Returns the current selected MetaClass
	 * 
	 * @return the current selected MetaClass
	 */
	public EClassifier getCurrentMetaClass() {
		return currentMetaClass;
	}

	/**
	 * Sets the current selected MetaClass
	 * 
	 * @param currentMetaClass
	 *        the current MetaClass to set
	 */
	public void setCurrentMetaClass(EClassifier currentMetaClass) {
		this.currentMetaClass = currentMetaClass;
	}

	/**
	 * Sets the current selected Stereotype
	 * 
	 * @param currentStereoype
	 *        the current Stereotype to set
	 */
	public void setCurrentStereotype(Stereotype currentStereoype) {
		this.currentStereoype = currentStereoype;
	}

	/**
	 * Returns the currentStereoype
	 * 
	 * @return the currentStereoype
	 */
	public Stereotype getCurrentStereoype() {
		return currentStereoype;
	}

	/**
	 * Sets the currentSelectionsize and updates the size area
	 * 
	 * @param currentSelectionsize
	 *        the currentSelectionsize to set
	 */
	protected void setCurrentSelectionsize(int currentSelectionsize) {
		this.currentSelectionsize = currentSelectionsize;
		if(sizeArea != null && !sizeArea.isDisposed()) {
			sizeArea.select(sizeValues.indexOf(currentSelectionsize));
		}
		updateSizeArea();
	}

	/**
	 * Returns the currentSelectionsize
	 * 
	 * @return the currentSelectionsize
	 */
	public int getCurrentSelectionsize() {
		return currentSelectionsize;
	}

	/**
	 * Sets the file where the content will be serialized
	 * 
	 * @param file
	 *        the file in which the content will be serialized
	 */
	public void setNewFile(File file) {
		this.file = file;
	}

	/**
	 * Returns the file in which the content will be serialized
	 * 
	 * @return the file in which the content will be serialized
	 */
	public File getFile() {
		return file;
	}

	/**
	 * Serializes the content of the configuration
	 * 
	 * @return <code>true</code> if serialization finished well
	 */
	public boolean serializeContent() {

		ConfigurationValidator configurationValidator = new ConfigurationValidator(getShell());
		if(configurationValidator.validateConfig(true, false)) {
			Job job = new Job(Messages.CustomizeContentWizardPage_Job_SavingConfiguration) {

				/**
				 * {@inheritDoc}
				 */
				@Override
				protected IStatus run(IProgressMonitor monitor) {

					try {
						final Document document = getFinalContent();
						final File file = getFile();
						// final File file =
						// ResourcesPlugin.getWorkspace().getRoot().getRawLocation().append("test/test.xml").toFile();
						file.delete();

						if(!file.exists()) {
							file.createNewFile();
						}
						TransformerFactory factory = TransformerFactory.newInstance();
						Transformer transformer = factory.newTransformer();

						Source source = new DOMSource(document);
						Result result = new StreamResult(file);

						transformer.transform(source, result);
						return Status.OK_STATUS;
					} catch (TransformerException e) {
						Activator.log.error(e);
						return new Status(Status.ERROR, Activator.ID, e.getLocalizedMessage());
					} catch (IOException e) {
						Activator.log.error(e);
						return new Status(Status.ERROR, Activator.ID, e.getLocalizedMessage());
					}
				}
			};
			job.schedule();
			// there, the xml file should be serialized
			return true;
		} else {
			return false;
		}

	}
}
