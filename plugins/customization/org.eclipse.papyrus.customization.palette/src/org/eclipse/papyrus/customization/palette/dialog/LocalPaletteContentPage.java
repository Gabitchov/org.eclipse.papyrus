/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.customization.palette.dialog;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.palette.CombinedTemplateCreationEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gmf.runtime.common.core.service.ProviderPriority;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorWithFlyOutPalette;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.customization.palette.proxies.XMLDefinitionPaletteProxyFactory;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.Messages;
import org.eclipse.papyrus.uml.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.uml.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.uml.diagram.common.service.AspectCreationEntry;
import org.eclipse.papyrus.uml.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.papyrus.uml.diagram.common.service.XMLDefinitionPaletteParser;
import org.eclipse.papyrus.uml.diagram.common.service.palette.IAspectAction;
import org.eclipse.papyrus.uml.diagram.common.service.palette.StereotypeAspectActionProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TreeDropTargetEffect;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Wizard page for information about the new local palette definition
 */
public class LocalPaletteContentPage extends WizardPage implements Listener {

	/** editor part in which the palette is created */
	protected IEditorPart editorPart;

	/** available tools viewer */
	protected TreeViewer availableToolsViewer;

	/** label provider for the tree viewer */
	protected PaletteLabelProvider paletteLabelProvider;

	/** icon path when tools are hidden */
	protected static final String HIDDEN_TOOLS_ICON = "/icons/tools_hidden.gif";

	/** icon path when tools are shown */
	protected static final String SHOWN_TOOLS_ICON = "/icons/tools_shown.gif";

	/** path to the icon */
	protected static final String WIZARD_ICON = "/icons/local_desc_wiz.png";

	/** icon path when drawers are hidden */
	protected static final String SHOWN_DRAWERS_ICON = "/icons/drawers_shown.gif";

	/** icon path when drawers are shown */
	protected static final String HIDDEN_DRAWERS_ICON = "/icons/drawers_hidden.gif";

	/** icon path for the add button */
	protected static final String ADD_ICON = "/icons/arrow_right.gif";

	/** icon path for the remove button */
	protected static final String REMOVE_ICON = "/icons/arrow_left.gif";

	/** icon path for the delete button */
	protected static final String DELETE_ICON = "/icons/delete.gif";

	/** icon path for the create drawer button */
	protected static final String CREATE_DRAWERS_ICON = "/icons/new_drawer.gif";

	/** icon path for the create separator button */
	protected String CREATE_SEPARATOR_ICON = "/icons/separator.gif";

	/** icon path for the create stack button */
	protected String CREATE_STACK_ICON = "/icons/stack.gif";

	/** icon path for the delete drawer button */
	protected static final String DELETE_DRAWERS_ICON = "/icons/delete.gif";

	/** icon for the content provider switch button */
	protected String SWITCH_CONTENT_PROVIDER_ICON = "/icons/switch_provider.gif";

	/** label for the standard tools */
	protected static final String UML_TOOLS_LABEL = "UML tools";

	/** icon path for the edit drawer button */
	protected static final String EDIT_ICON = "/icons/obj16/file.gif";

	/** instance of the filter used to show/hide drawers */
	protected final ViewerFilter drawerFilter = new DrawerFilter();

	/** instance of the filter used to show/hide tools */
	protected final ViewerFilter toolFilter = new ToolFilter();

	/** stored preferences */
	protected List<String> storedPreferences;

	/** add button */
	protected Button addButton;

	/** remove button */
	protected Button removeButton;

	/** tree viewer for the new palette */
	protected TreeViewer paletteTreeViewer;

	/** document for element creation */
	protected Document document;

	/** content node for the palette viewer */
	protected PaletteContainerProxy contentNode;

	/** combo to select which profile tools should be visible */
	protected Combo profileCombo;

	/** list of profiles that can provide tools */
	protected List<String> profileComboList = new ArrayList<String>();

	/** tool item in charge of toggling content providers in the available tool viewer */
	protected ToolItem toggleContentProvider;

	/** required profile by this palette */
	protected Set<String> requiredProfiles;

	/** palette customizer used for the palette */
	protected PaletteCustomizer customizer;

	/** current selected entry proxy */
	protected PaletteEntryProxy selectedEntryProxy;

	/** class in charge of the information composite */
	protected PaletteEntryProxyInformationComposite informationComposite = new PaletteEntryProxyInformationComposite();

	/** class in charge of the aspect tool information composite */
	protected AspectActionsInformationComposite aspectActionComposite = new AspectActionsInformationComposite();

	protected ToolBar toolbar;

	/** validator key for toolbar items */
	protected final static String VALIDATOR = "validator";

	/** priority of the current edited palette */
	protected ProviderPriority priority;


	/**
	 * Creates a new wizard page with the given name, title, and image.
	 * 
	 * @param part
	 *        the editor part in which the wizard was created
	 */
	public LocalPaletteContentPage(IEditorPart part, PaletteCustomizer customizer) {
		super(Messages.Local_Palette_ContentPage_Name, Messages.Local_Palette_ContentPage_Title, Activator.getImageDescriptor(WIZARD_ICON));
		this.editorPart = part;
		this.customizer = customizer;
	}

	/**
	 * {@inheritDoc}
	 */
	public void createControl(Composite parent) {

		// initialize dialog units
		initializeDialogUnits(parent);

		// Create a new composite as there is the title bar seperator
		// to deal with
		Composite control = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(4, false);
		control.setLayout(layout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(control);

		// create Available Tools Group
		createAvailableToolsGroup();

		// create add/remove buttons
		createAddRemoveButtons();

		// create Palette Group
		createPalettePreviewGroup();

		// create tool description group (custom name, description, and perhaphs icon.... Just under this group, another one with aspect actions)
		createToolDescriptionGroup();

		// just under, creates a new line of composites...
		createAspectActionComposite();



		// add listeners inter-groups
		ISelectionChangedListener listener = createToolsViewerSelectionChangeListener();
		availableToolsViewer.addSelectionChangedListener(listener);
		paletteTreeViewer.addSelectionChangedListener(listener);

		// end of the control creation
		Dialog.applyDialogFont(control);

		validatePage();
		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(control);
	}

	/**
	 * Creates the composite group that presents information about ascpect actions for aspect tools
	 */
	protected void createAspectActionComposite() {
		aspectActionComposite.createComposite((Composite)getControl(), getAllAppliedProfiles());
	}

	/**
	 * Creates the composite group that presents information about current selected tool
	 */
	protected void createToolDescriptionGroup() {
		informationComposite.createComposite((Composite)getControl(), getAllAppliedProfiles());
	}

	/**
	 * update the preferences to have all tools accessible
	 */
	protected void updatePreferences() {
		// change => set to no hidden palettes
		storedPreferences = PapyrusPalettePreferences.getHiddenPalettes(editorPart);

		// remove all, but should only remove visible palettes
		for(String id : storedPreferences) {
			PapyrusPalettePreferences.changePaletteVisibility(id, editorPart, true);
		}
	}

	/**
	 * Restore preferences
	 */
	public void restorePreferences() {
		// remove all, but should only remove visible palettes
		for(String id : storedPreferences) {
			PapyrusPalettePreferences.changePaletteVisibility(id, editorPart, false);
		}
	}

	/**
	 * creates the palette preview group
	 */
	protected void createPalettePreviewGroup() {
		Composite parent = (Composite)getControl();
		Composite paletteComposite = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		paletteComposite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		paletteComposite.setLayoutData(data);

		Label label = new Label(paletteComposite, SWT.NONE);
		label.setText(Messages.Local_Palette_Palette_Preview);
		data = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		label.setLayoutData(data);

		toolbar = new ToolBar(paletteComposite, SWT.HORIZONTAL);
		data = new GridData(SWT.RIGHT, SWT.FILL, false, false);
		toolbar.setLayoutData(data);
		populatePalettePreviewToolBar(toolbar);

		Tree tree = new Tree(paletteComposite, SWT.SINGLE | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		tree.setLayoutData(data);
		paletteTreeViewer = new TreeViewer(tree);
		paletteTreeViewer.setContentProvider(new PaletteContentProvider(paletteTreeViewer));
		paletteTreeViewer.setLabelProvider(new PaletteProxyLabelProvider());
		paletteTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				handlePalettePreviewSelectionChanged(event);
			}
		});

		addPalettePreviewDropSupport();
		addPalettePreviewDragSupport();
		addPalettePreviewEditSupport();

		paletteTreeViewer.setInput(contentNode);
	}

	/**
	 * handle the selection change event for the palette preview
	 * 
	 * @param event
	 *        the event that is thrown by the palette viewer
	 */
	protected void handlePalettePreviewSelectionChanged(SelectionChangedEvent event) {
		// retrieve current selection
		ITreeSelection selection = (TreeSelection)event.getSelection();
		Object firstSelected = selection.getFirstElement();
		if(firstSelected instanceof PaletteEntryProxy) {
			// update the current selected palette entry proxy
			selectedEntryProxy = ((PaletteEntryProxy)firstSelected);
			informationComposite.setSelectedEntryProxy(selectedEntryProxy);
			aspectActionComposite.setSelectedEntryProxy(selectedEntryProxy);
		}

		// update toolbar
		if(toolbar != null && !toolbar.isDisposed()) {
			for(int i = 0; i < toolbar.getItemCount(); i++) {
				ToolItem item = toolbar.getItem(i);
				Object validator = item.getData(VALIDATOR);
				if(validator instanceof ToolBarItemValidator) {
					item.setEnabled(((ToolBarItemValidator)validator).isEnable());
				}
			}
		}

	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void dispose() {
		super.dispose();
	}

	/**
	 * Adds the behavior for the double click strategy
	 */
	protected void addPalettePreviewEditSupport() {
		paletteTreeViewer.addDoubleClickListener(new IDoubleClickListener() {

			/**
			 * {@inheritDoc}
			 */
			public void doubleClick(DoubleClickEvent event) {
				// retrieve current item double clicked...
				ITreeSelection selection = (TreeSelection)event.getSelection();
				Object firstSelected = selection.getFirstElement();
				if(firstSelected instanceof PaletteLocalDrawerProxy) {
					UpdateLocalDrawerWizard wizard = new UpdateLocalDrawerWizard(((PaletteLocalDrawerProxy)firstSelected).getParent(), (PaletteLocalDrawerProxy)firstSelected);
					WizardDialog dialog = new WizardDialog(getShell(), wizard);
					dialog.open();
					//paletteTreeViewer.refresh();
				}
			}
		});

	}

	/**
	 * Add drop behavior for the palette preview
	 */
	protected void addPalettePreviewDropSupport() {
		// transfer types
		Transfer[] transfers = new Transfer[]{ LocalSelectionTransfer.getTransfer() };

		// drag listener
		DropTargetListener listener = new TreeDropTargetEffect(paletteTreeViewer.getTree()) {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void drop(DropTargetEvent event) {
				super.drop(event);

				// create proxy and adds it to its target parent
				PaletteEntryProxy target = (PaletteEntryProxy)((TreeItem)event.item).getData();
				if(target == null) {
					target = (PaletteContainerProxy)paletteTreeViewer.getInput();
				}

				// get the elements from the drag listener (either a palette entry or a palette
				// entry proxy)
				IStructuredSelection transferedSelection = (IStructuredSelection)LocalSelectionTransfer.getTransfer().nativeToJava(event.currentDataType);
				Object entry = transferedSelection.getFirstElement();

				// creates the proxy for the element to be dropped
				PaletteEntryProxy entryProxy = createNodeFromEntry(entry);

				if(entryProxy == null) {
					return;
				}
				if(target instanceof PaletteContainerProxy) {
					// tries to remove from its parent if possible
					if(entryProxy.getParent() != null) {
						entryProxy.getParent().removeChild(entryProxy);
					}
					((PaletteContainerProxy)target).addChild(entryProxy);
					paletteTreeViewer.expandToLevel(target, 1);
				} else if(target instanceof PaletteEntryProxy) {
					// tries to remove from its parent if possible
					if(entryProxy.getParent() != null) {
						entryProxy.getParent().removeChild(entryProxy);
					}
					target.getParent().addChild(entryProxy, target);
					paletteTreeViewer.expandToLevel(target.getParent(), 1);
				} else {
					// add to parent...
					target.getParent().addChild(entryProxy);
					paletteTreeViewer.expandToLevel(target.getParent(), TreeViewer.ALL_LEVELS);
				}
				setPageComplete(validatePage());
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dragOver(DropTargetEvent event) {
				super.dragOver(event);

				IStructuredSelection transferedSelection = (IStructuredSelection)LocalSelectionTransfer.getTransfer().nativeToJava(event.currentDataType);
				// check selection is compatible for drop target

				TreeItem item = paletteTreeViewer.getTree().getItem(paletteTreeViewer.getTree().toControl(new Point(event.x, event.y)));

				checkSelectionForDrop(transferedSelection, item, event);
			}
		};

		paletteTreeViewer.addDropSupport(DND.DROP_LINK | DND.DROP_MOVE, transfers, listener);
	}

	/**
	 * Adds drag ability to the palette preview composite
	 */
	protected void addPalettePreviewDragSupport() {

		// transfer types
		Transfer[] transfers = new Transfer[]{ LocalSelectionTransfer.getTransfer() };

		// drag listener
		DragSourceListener listener = new DragSourceAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dragStart(DragSourceEvent event) {
				super.dragStart(event);
				event.data = paletteTreeViewer.getSelection();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dragSetData(DragSourceEvent event) {
				super.dragSetData(event);
				LocalSelectionTransfer.getTransfer().setSelection(paletteTreeViewer.getSelection());
			}

		};

		paletteTreeViewer.addDragSupport(DND.DROP_MOVE, transfers, listener);
	}

	/**
	 * Checks if the selection can be added to the target widget
	 * 
	 * @param transferedSelection
	 *        the selection to be dropped
	 * @param widget
	 *        the widget where to drop
	 * @return <code>true</code> if element can be dropped
	 */
	protected void checkSelectionForDrop(IStructuredSelection transferedSelection, TreeItem item, DropTargetEvent event) {
		event.detail = DND.DROP_NONE;
		Object entry = transferedSelection.getFirstElement();
		// handle only first selected element
		if(item == null) {
			// adding to the root, should only be a drawer
			if(entry instanceof PaletteDrawer) {
				event.detail = DND.DROP_LINK;
			}
		} else {
			PaletteEntryProxy targetProxy = (PaletteEntryProxy)item.getData();
			switch(targetProxy.getType()) {
			case DRAWER:
				if(entry instanceof ToolEntry) {
					event.detail = DND.DROP_LINK;
				} else if(entry instanceof PaletteEntryProxy) {
					event.detail = DND.DROP_MOVE;
				}
				break;
			case STACK:
				if(entry instanceof ToolEntry) {
					event.detail = DND.DROP_LINK;
				} else if(entry instanceof PaletteEntryProxy && !(entry instanceof PaletteLocalStackProxy)) {
					event.detail = DND.DROP_MOVE;
				}
				break;
			case TOOL:
				if(entry instanceof ToolEntry) {
					event.detail = DND.DROP_LINK; // add the selected tool before the destination
					// tool
				} else if(entry instanceof PaletteEntryProxy) {
					event.detail = DND.DROP_MOVE; // moves the element before the entry
				}
				break;
			case SEPARATOR:
				if(entry instanceof PaletteEntryProxy) {
					event.detail = DND.DROP_MOVE;
				}
				break;
			default:
				break;
			}
		}
	}

	/**
	 * Sets an empty content for the palette preview
	 */
	public void initializeContent() {
		contentNode = new PaletteContainerProxy(null);

		// adds a default local drawer
		PaletteLocalDrawerProxy proxy = new PaletteLocalDrawerProxy("Default", generateID("Drawer_"), "/icons/drawer.gif", "Default Drawer");
		contentNode.addChild(proxy);

		setPageComplete(false);
	}

	/**
	 * Sets the initial content for the palette preview
	 */
	public void initializeContent(PapyrusPaletteService.LocalProviderDescriptor descriptor) {
		// retrieve the xml definition file
		String xmlPath = PapyrusPalettePreferences.getPalettePathFromID(descriptor.getContributionID());

		// parse the content file
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			// Bundle bundle = Platform.getBundle(pluginID);
			// URL url = bundle.getEntry(path);

			File file = Activator.getDefault().getStateLocation().append(xmlPath).toFile();
			if(!file.exists()) {
				Activator.log.error("Impossible to load file: " + file, null);
			} else {
				Document document = documentBuilder.parse(file);
				Map<String, PaletteEntry> entries = PaletteUtil.getAvailableEntriesSet(editorPart, ProviderPriority.HIGHEST);
				XMLDefinitionPaletteProxyFactory factory = new XMLDefinitionPaletteProxyFactory(entries);
				XMLDefinitionPaletteParser parser = new XMLDefinitionPaletteParser(factory);
				for(int i = 0; i < document.getChildNodes().getLength(); i++) {
					Node node = document.getChildNodes().item(i);
					if(IPapyrusPaletteConstant.PALETTE_DEFINITION.equals(node.getNodeName())) {
						parser.parsePaletteDefinition(node);
					}
				}
				contentNode = factory.getRootProxy();

				// tells that the page can be closed directly without modifying the palette
				setPageComplete(true);
				return;
			}
		} catch (ParserConfigurationException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		} catch (SAXException e) {
			Activator.log.error(e);
		}

		// paletteTreeViewer.setInput(contentNode);
		contentNode = new PaletteContainerProxy(null);
	}

	/**
	 * Saves the xml document into file
	 * 
	 * @param document
	 *        the document to save
	 * @param path
	 *        name of the file
	 * @return the file created or updated
	 */
	protected File loadDocument(Document document, String path) {
		File file = null;
		try {
			// create the file that stores the XML configuration
			file = Activator.getDefault().getStateLocation().append(path).toFile();
			Transformer aTransformer = TransformerFactory.newInstance().newTransformer();

			Source src = new DOMSource(document);
			Result dest = new StreamResult(file);
			aTransformer.transform(src, dest);
		} catch (TransformerConfigurationException e) {
			Activator.log.error(e);
		} catch (TransformerException e) {
			Activator.log.error(e);
		}
		return file;

	}

	/**
	 * populates the preview palette toolbar
	 * 
	 * @param toolbar
	 *        the toolbar to populate
	 */
	protected void populatePalettePreviewToolBar(ToolBar toolbar) {
		PaletteEntryProxySelectedValidator validator = new PaletteEntryProxySelectedValidator();
		createToolBarItem(toolbar, DELETE_ICON, Messages.PapyrusPaletteCustomizerDialog_RemoveButtonTooltip, createRemoveElementListener(), validator);
		createToolBarItem(toolbar, EDIT_ICON, Messages.PapyrusPaletteCustomizerDialog_EditButtonTooltip, createEditElementListener(), new EditElementToolBarItemValidator());
		createToolBarItem(toolbar, CREATE_DRAWERS_ICON, Messages.Local_Palette_Create_Drawer_Tooltip, createNewDrawerListener(), null);
		createToolBarItem(toolbar, CREATE_SEPARATOR_ICON, Messages.Local_Palette_Create_Separator_Tooltip, createNewSeparatorListener(), validator);
		createToolBarItem(toolbar, CREATE_STACK_ICON, Messages.Local_Palette_Create_Stack_Tooltip, createNewStackListener(), validator);
	}

	/**
	 * Edits the current selected elements. This works for drawers, should work on more elements
	 * 
	 * @return the listener for the edit button
	 */
	protected Listener createEditElementListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection)paletteTreeViewer.getSelection();
				if(selection == null || selection.size() < 1) {
					return;
				}

				Object selected = selection.getFirstElement();
				if(selected instanceof PaletteLocalDrawerProxy) {
					UpdateLocalDrawerWizard wizard = new UpdateLocalDrawerWizard(((PaletteLocalDrawerProxy)selected).getParent(), (PaletteLocalDrawerProxy)selected);
					WizardDialog dialog = new WizardDialog(getShell(), wizard);
					dialog.open();
				}

				// paletteTreeViewer.refresh();
			}
		};
	}

	/**
	 * Creates the listener for the remove item(s) button
	 * 
	 * @return the listener for the remove button
	 */
	protected Listener createRemoveElementListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				IStructuredSelection selection = (IStructuredSelection)paletteTreeViewer.getSelection();
				if(selection == null || selection.size() < 1) {
					return;
				}

				Iterator<Object> it = selection.iterator();
				while(it.hasNext()) {
					Object o = it.next();
					if(o instanceof PaletteEntryProxy) {
						PaletteEntryProxy proxyToDelete = (PaletteEntryProxy)o;
						// create a new entry in the document
						// get container of the proxy to be deleted
						PaletteContainerProxy parentProxy = proxyToDelete.getParent();
						if(parentProxy != null) {
							parentProxy.removeChild(proxyToDelete);
						}
					}
				}
				// paletteTreeViewer.refresh();
			}
		};
	}

	/**
	 * Creates the listener for the new drawer tool item
	 * 
	 * @return the listener created
	 */
	protected Listener createNewDrawerListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				// retrieve selected container
				PaletteContainerProxy containerProxy;
				containerProxy = (PaletteContainerProxy)paletteTreeViewer.getInput();
				NewDrawerWizard wizard = new NewDrawerWizard(containerProxy);
				WizardDialog wizardDialog = new WizardDialog(new Shell(), wizard);
				wizardDialog.open();
				// paletteTreeViewer.refresh();
				setPageComplete(validatePage());
			}
		};
	}

	/**
	 * Creates the listener for the new stack tool item
	 * 
	 * @return the listener created
	 */
	protected Listener createNewStackListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				// retrieve selected element
				Object object = ((IStructuredSelection)paletteTreeViewer.getSelection()).getFirstElement();

				// if element = drawer => the new stack must be created at the end of the drawer's
				// children list
				// if element = tool => must be placed before this tool
				// else : nothinng to do
				if(object instanceof PaletteLocalDrawerProxy) {
					String id = generateID("Stack");
					PaletteLocalStackProxy proxy = new PaletteLocalStackProxy(id);
					((PaletteLocalDrawerProxy)object).addChild(proxy);
				} else if(object instanceof PaletteEntryProxy) {
					String id = generateID("Stack");
					PaletteLocalStackProxy proxy = new PaletteLocalStackProxy(id);
					// retrieve parent
					PaletteEntryProxy childProxy = (PaletteEntryProxy)object;
					PaletteContainerProxy parentProxy = childProxy.getParent();
					parentProxy.addChild(proxy, childProxy);
				}

				// paletteTreeViewer.refresh();
				setPageComplete(validatePage());
			}
		};
	}

	/**
	 * Generates the ID for a local element
	 * 
	 * @param base
	 *        the begining of the id
	 * @return the separator id
	 */
	protected String generateID(String base) {
		StringBuffer id = new StringBuffer();
		id.append(base);
		id.append("_");
		id.append(System.currentTimeMillis());

		return id.toString();
	}

	/**
	 * Creates the listener for the new separator tool item
	 * 
	 * @return the listener created
	 */
	protected Listener createNewSeparatorListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				// retrieve selected element
				Object object = ((IStructuredSelection)paletteTreeViewer.getSelection()).getFirstElement();

				// if element = drawer => the new stack must be created at the end of the drawer's
				// children list
				// if element = tool => must be placed before this tool
				// else : nothinng to do
				if(object instanceof PaletteLocalDrawerProxy) {
					String id = generateID("Separator");
					PaletteLocalSeparatorProxy proxy = new PaletteLocalSeparatorProxy(id);
					((PaletteLocalDrawerProxy)object).addChild(proxy);
				} else if(object instanceof PaletteEntryProxy) {
					String id = generateID("Separator");
					PaletteLocalSeparatorProxy proxy = new PaletteLocalSeparatorProxy(id);
					// retrieve parent
					PaletteEntryProxy childProxy = (PaletteEntryProxy)object;
					PaletteContainerProxy parentProxy = childProxy.getParent();
					parentProxy.addChild(proxy, childProxy);
				}

				setPageComplete(validatePage());
			}
		};
	}

	/**
	 * Creates a toolbar item.
	 * 
	 * @param toolbar
	 *        the parent toolbar
	 * @param itemIcon
	 *        path for icon
	 * @param tooltip
	 *        tooltip text for the toolbar item
	 * @param listener
	 *        listener for tool bar item
	 */
	protected void createToolBarItem(ToolBar toolbar, String itemIcon, String tooltip, Listener listener, ToolBarItemValidator validator) {
		ToolItem item = new ToolItem(toolbar, SWT.BORDER);
		item.setImage(Activator.getPluginIconImage(Activator.ID, itemIcon));
		item.setToolTipText(tooltip);
		item.addListener(SWT.Selection, listener);
		item.setData(VALIDATOR, validator);
	}

	/**
	 * creates the buttons to add/remove entries
	 */
	protected void createAddRemoveButtons() {
		Composite composite = new Composite((Composite)getControl(), SWT.NONE);
		GridLayout layout = new GridLayout(1, true);
		composite.setLayout(layout);

		GridData data = new GridData(SWT.CENTER, SWT.CENTER, false, true);
		composite.setLayoutData(data);

		addButton = new Button(composite, SWT.NONE);
		addButton.setImage(Activator.getPluginIconImage(Activator.ID, ADD_ICON));
		addButton.setToolTipText(Messages.PapyrusPaletteCustomizerDialog_AddButtonTooltip);
		addButton.addMouseListener(createAddButtonListener());
		addButton.setEnabled(false);
		addButton.addListener(SWT.MouseUp, this);

		removeButton = new Button(composite, SWT.NONE);
		removeButton.setImage(Activator.getPluginIconImage(Activator.ID, REMOVE_ICON));
		removeButton.setToolTipText(Messages.PapyrusPaletteCustomizerDialog_RemoveButtonTooltip);
		removeButton.addMouseListener(createRemoveButtonListener());
		removeButton.setEnabled(false);
		removeButton.addListener(SWT.MouseUp, this);
	}

	/**
	 * selection listener for the tools viewer , to update the state of the add button
	 * 
	 * @return the new created selection listener
	 */
	protected ISelectionChangedListener createToolsViewerSelectionChangeListener() {
		return new ISelectionChangedListener() {

			/**
			 * {@inheritDoc}
			 */
			public void selectionChanged(SelectionChangedEvent event) {

				// get source and target selection
				// check source entry can be added to target entry
				Object source = ((IStructuredSelection)availableToolsViewer.getSelection()).getFirstElement();
				Object target = ((IStructuredSelection)paletteTreeViewer.getSelection()).getFirstElement();

				// manage add button
				if(isAddValidTarget(source, target)) {
					addButton.setEnabled(true);
				} else {
					addButton.setEnabled(false);
				}

				// manage remove button
				if(isRemoveValidSource(target)) {
					removeButton.setEnabled(true);
				} else {
					removeButton.setEnabled(false);
				}

			}

			/**
			 * Returns true if the source can be added to the target
			 * 
			 * @param source
			 *        the source object
			 * @param target
			 *        the target object
			 * @return <code>true</code> if the source can be added to the target
			 */
			protected boolean isAddValidTarget(Object source, Object target) {
				if(!(source instanceof PaletteEntry)) {
					return false;
				}

				// case1: source is a drawer.
				// it can only be added to the root element (no selection)
				// case2: source is a palette tool
				// it can't be added to the root element
				// it can only be added to a container element (drawer or stack)
				if(source instanceof PaletteDrawer) {
					if(target == null) {
						return true;
					}
					return false;
				} else if(source instanceof ToolEntry) {
					if(target instanceof PaletteEntryProxy) {
						EntryType type = ((PaletteEntryProxy)target).getType();
						switch(type) {
						case DRAWER:
						case STACK:
							return true;
						default:
							return false;
						}
					}
					return false;
				}
				return false;
			}

			/**
			 * Returns true if the source can be added to the target
			 * 
			 * @param source
			 *        the source object
			 * @return <code>true</code> if the source can be removed (not null and instanceof
			 *         PaletteEntryProxy)
			 */
			protected boolean isRemoveValidSource(Object source) {
				if(source instanceof PaletteEntryProxy) {
					return true;
				}
				return false;
			}
		};

	}

	/**
	 * Creates the add button listener
	 */
	protected MouseListener createAddButtonListener() {
		return new MouseListener() {

			public void mouseUp(MouseEvent e) {
				// add the element selected on the left to the right tree
				// check the selection.
				IStructuredSelection selection = (IStructuredSelection)availableToolsViewer.getSelection();
				if(selection == null || selection.size() < 1) {
					return;
				}
				PaletteEntry entry = (PaletteEntry)selection.getFirstElement();
				if(entry == null) {
					return;
				}

				// find the selection on the right
				selection = (IStructuredSelection)paletteTreeViewer.getSelection();

				PaletteEntryProxy parentNode = (PaletteEntryProxy)selection.getFirstElement();
				// Bugfix: only drawers can be added to root element
				if(parentNode == null && entry instanceof PaletteDrawer) {
					parentNode = (PaletteContainerProxy)paletteTreeViewer.getInput();
				}

				// check we have a containe here
				if(!(parentNode instanceof PaletteContainerProxy)) {
					return;
				}

				// create a new entry in the document
				PaletteEntryProxy proxy = createNodeFromEntry(entry);
				((PaletteContainerProxy)parentNode).addChild(proxy);

				paletteTreeViewer.expandToLevel(parentNode, 1);
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {
				// do nothing
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// do nothing
			}
		};
	}

	/**
	 * Creates a node in the xml document from the given entry
	 * 
	 * @param entry
	 *        the palette entry from which to create the node
	 * @param parentNode
	 *        the parent node for the newly created node
	 * @return the created entry proxy or <code>null</code>
	 */
	protected PaletteEntryProxy createNodeFromEntry(Object entry) {
		PaletteEntryProxy entryProxy = null;

		if(entry instanceof AspectCreationEntry) {
			// should modify id of the element here, otherwise, different elements would have the same id...
			entryProxy = new PaletteAspectToolEntryProxy(((AspectCreationEntry)entry).clone());
		} else if(entry instanceof CombinedTemplateCreationEntry) {
			CombinedTemplateCreationEntry originalEntry = (CombinedTemplateCreationEntry)entry;
			// create a new Aspect entry proxy
			AspectCreationEntry aspectEntry = new AspectCreationEntry(originalEntry.getLabel(), originalEntry.getDescription(), originalEntry.getId() + "_" + System.currentTimeMillis(), originalEntry.getSmallIcon(), originalEntry, new HashMap<Object, Object>());
			entryProxy = new PaletteAspectToolEntryProxy(aspectEntry);
		} else if(entry instanceof PaletteContainer) {
			entryProxy = new PaletteContainerProxy((PaletteContainer)entry);
		} else if(entry instanceof PaletteEntryProxy) {
			entryProxy = ((PaletteEntryProxy)entry);
		}
		return entryProxy;
	}

	/**
	 * Creates the add button listener
	 */
	protected MouseListener createRemoveButtonListener() {
		return new MouseListener() {

			public void mouseUp(MouseEvent e) {
				// remove the element selected on the right
				// add the element selected on the left to the right tree
				// check the selection.
				IStructuredSelection selection = (IStructuredSelection)paletteTreeViewer.getSelection();
				if(selection == null || selection.size() < 1) {
					return;
				}
				PaletteEntryProxy proxyToDelete = (PaletteEntryProxy)selection.getFirstElement();
				if(proxyToDelete == null) {
					return;
				}

				// create a new entry in the document
				// get container of the proxy to be deleted
				PaletteContainerProxy parentProxy = proxyToDelete.getParent();
				parentProxy.removeChild(proxyToDelete);
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {
				// do nothing
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {
				// do nothing
			}
		};
	}

	/**
	 * creates the available entries group
	 */
	protected void createAvailableToolsGroup() {
		Composite parent = (Composite)getControl();
		Composite availableToolsComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		availableToolsComposite.setLayout(layout);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
		availableToolsComposite.setLayoutData(data);

		Label label = new Label(availableToolsComposite, SWT.NONE);
		label.setText(Messages.Local_Palette_Available_Tools);
		data = new GridData(SWT.LEFT, SWT.CENTER, true, false);
		label.setLayoutData(data);

		ToolBar toolbar = new ToolBar(availableToolsComposite, SWT.HORIZONTAL);
		data = new GridData(SWT.RIGHT, SWT.FILL, false, false);
		toolbar.setLayoutData(data);
		populateAvailableToolsToolBar(toolbar);

		createProfileCombo(availableToolsComposite);

		Tree tree = new Tree(availableToolsComposite, SWT.SINGLE | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		tree.setLayoutData(data);
		availableToolsViewer = new TreeViewer(tree);
		availableToolsViewer.setContentProvider(new UMLToolsTreeContentProvider());
		paletteLabelProvider = new PaletteLabelProvider();
		availableToolsViewer.setLabelProvider(paletteLabelProvider);
		ViewerComparator labelComparator = new LabelViewerComparator();
		availableToolsViewer.setComparator(labelComparator);
		// remove the note stack and standard group
		availableToolsViewer.addFilter(new ViewerFilter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if(element instanceof PaletteStack && "noteStack".equals(((PaletteStack)element).getId())) {
					return false;
				} else if(element instanceof PaletteToolbar && "standardGroup".equals(((PaletteToolbar)element).getId())) {
					return false;
				}
				return true;
			}
		});
		availableToolsViewer.addFilter(new DrawerFilter());
		// add drag support
		addAvailableToolsDragSupport();
		// availableToolsViewer.setInput(getAllVisibleStandardEntries());
	}

	/**
	 * Creates the profile combo
	 * 
	 * @param availableToolsComposite
	 *        the available tools composite
	 * @return the created combo
	 */
	protected Combo createProfileCombo(Composite availableToolsComposite) {
		// retrieve top package, to know which profiles are available
		// creates the combo
		profileCombo = new Combo(availableToolsComposite, SWT.BORDER | SWT.READ_ONLY);
		GridData data = new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1);
		profileCombo.setLayoutData(data);

		// retrieve all applied profiles
		List<Profile> profiles = getAllAppliedProfiles();

		int profileNumber = profiles.size();
		for(int i = 0; i < profileNumber; i++) {
			profileComboList.add(i, profiles.get(i).getName());
		}
		profileComboList.add(UML_TOOLS_LABEL);
		profileCombo.setItems(profileComboList.toArray(new String[]{}));

		// add selection listener for the combo. selects the "UML tools" item
		ProfileComboSelectionListener listener = new ProfileComboSelectionListener();
		profileCombo.addSelectionListener(listener);
		profileCombo.addModifyListener(listener);
		// profileCombo.select(profileNumber);

		return profileCombo;
	}

	/**
	 * returns the list of applied profile for the nearest package of the top element
	 * 
	 * @return the list of applied profile for the nearest package of the top element or an empty
	 *         list
	 */
	protected List<Profile> getAllAppliedProfiles() {
		Package topPackage = null;
		if(editorPart instanceof DiagramEditorWithFlyOutPalette) {
			EObject element = ((DiagramEditorWithFlyOutPalette)editorPart).getDiagram().getElement();
			if(element instanceof org.eclipse.uml2.uml.Element) {
				topPackage = ((org.eclipse.uml2.uml.Element)element).getNearestPackage();
			}
		}
		if(topPackage != null) {
			return topPackage.getAllAppliedProfiles();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * Add drag support from the available tools viewer
	 */
	protected void addAvailableToolsDragSupport() {
		// transfer types
		Transfer[] transfers = new Transfer[]{ LocalSelectionTransfer.getTransfer() };

		// drag listener
		DragSourceListener listener = new DragSourceAdapter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dragStart(DragSourceEvent event) {
				super.dragStart(event);
				event.data = availableToolsViewer.getSelection();
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public void dragSetData(DragSourceEvent event) {
				super.dragSetData(event);
				LocalSelectionTransfer.getTransfer().setSelection(availableToolsViewer.getSelection());
			}

		};

		availableToolsViewer.addDragSupport(DND.DROP_LINK, transfers, listener);
	}

	/**
	 * Adds elements to the tool bar for available tools viewer
	 * 
	 * @param toolbar
	 *        the toolbar to populate
	 */
	protected void populateAvailableToolsToolBar(ToolBar toolbar) {
		toggleContentProvider = createCheckToolBarItem(toolbar, SWITCH_CONTENT_PROVIDER_ICON, Messages.Local_Palette_SwitchToolsContentProvider_Tooltip, createSwitchToolsContentProviderListener());
		toggleContentProvider.setSelection(true);
		toggleContentProvider.setEnabled(false);
		createCheckToolBarItem(toolbar, SHOWN_TOOLS_ICON, Messages.Local_Palette_ShowTools_Tooltip, createsShowToolListener());
	}

	/**
	 * Creates the listener for the available tools content provider
	 * 
	 * @return the listener created
	 */
	protected Listener createSwitchToolsContentProviderListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				if(!(event.widget instanceof ToolItem)) {
					return;
				}
				ToolItem item = ((ToolItem)event.widget);
				// retrieve current profile selected in the combo profile
				int index = profileCombo.getSelectionIndex();
				Collection<PaletteEntry> standardEntries = getAllVisibleStandardEntries();
				Profile profile = getAllAppliedProfiles().get(index);

				if(item.getSelection()) {
					availableToolsViewer.setContentProvider(new ProfileToolsStereotypeMetaclassTreeContentProvider(profile, standardEntries));
					item.setSelection(true);
				} else {

					availableToolsViewer.setContentProvider(new ProfileToolsMetaclassStereotypeTreeContentProvider(profile, standardEntries));
					item.setSelection(false);
				}

				// generate tools for given profile
				availableToolsViewer.setInput(profile);
			}
		};
	}

	/**
	 * creates the tool item for drawers visibility listener
	 * 
	 * @return the listener for the tool button
	 */
	protected Listener createShowDrawerListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				if(!(event.widget instanceof ToolItem)) {
					return;
				}
				ToolItem item = ((ToolItem)event.widget);
				if(item.getSelection()) {
					// elements should be hidden
					availableToolsViewer.addFilter(drawerFilter);
					item.setSelection(true);
				} else {
					availableToolsViewer.removeFilter(drawerFilter);
					item.setSelection(false);
				}
			}
		};
	}

	/**
	 * creates the tool item for tools visibility listener
	 * 
	 * @return the listener for the tool button
	 */
	protected Listener createsShowToolListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				if(!(event.widget instanceof ToolItem)) {
					return;
				}
				ToolItem item = ((ToolItem)event.widget);
				if(item.getSelection()) {
					// elements should be hidden
					availableToolsViewer.addFilter(toolFilter);
					item.setSelection(true);
				} else {
					availableToolsViewer.removeFilter(toolFilter);
					item.setSelection(false);
				}
			}
		};
	}

	/**
	 * Creates a toolbar item which can be checked.
	 * 
	 * @param toolbar
	 *        the parent toolbar
	 * @param shownElementsIcon
	 *        path for shown elements icon
	 * @param listener
	 *        listener for button action
	 * @param tooltip
	 *        tooltip text for the toolbar item
	 */
	protected ToolItem createCheckToolBarItem(ToolBar toolbar, String shownElementsIcon, String tooltip, Listener listener) {
		ToolItem item = new ToolItem(toolbar, SWT.CHECK | SWT.BORDER);
		item.setImage(Activator.getPluginIconImage(Activator.ID, shownElementsIcon));
		item.setToolTipText(tooltip);
		item.addListener(SWT.Selection, listener);
		return item;
	}

	/**
	 * Validates the content of the fields in this page
	 */
	protected boolean validatePage() {
		boolean valid = true;

		if(valid) {
			setMessage(null);
			setErrorMessage(null);
		}
		return valid;
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this <code>Listener</code> method handles all events and enablements for controls
	 * on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	/**
	 * Content provider for available tools viewer
	 */
	public class UMLToolsTreeContentProvider implements ITreeContentProvider {

		/**
		 * Constructor
		 * 
		 * @param viewer
		 *        The viewer whose ContentProvider this content provider is
		 */
		public UMLToolsTreeContentProvider() {
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = null;

			if(inputElement instanceof Collection<?>) {
				elements = ((Collection<?>)inputElement).toArray();
			} else if(inputElement instanceof PaletteRoot) {
				// paletteUil.getAllEntries(...) to add drawers
				// if so, uncomment the addFilterbutton for drawers in populate tool bar
				elements = PaletteUtil.getAllToolEntries(((PaletteRoot)inputElement)).toArray();
			}

			if(elements == null) {
				elements = new Object[0];
			}
			return elements;
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			Object[] elements = null;

			if(parentElement instanceof Collection<?>) {
				elements = ((Collection<?>)parentElement).toArray();
			} else if(parentElement instanceof PaletteRoot) {
				// paletteUil.getAllEntries(...) to add drawers
				// if so, uncomment the addFilterbutton for drawers in populate tool bar
				elements = PaletteUtil.getAllToolEntries(((PaletteRoot)parentElement)).toArray();
			}

			return elements;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			return getChildren(element) != null && getChildren(element).length > 0;
		}
	}

	/**
	 * Label provider for palette tools.
	 * <P>
	 * We should be using the Palette label provider from GEF, if it was not with visibility "package"...
	 * 
	 * @see org.eclipse.gef.ui.palette.customize.PaletteLabelProvider </P>
	 * 
	 */
	public class PaletteLabelProvider implements ILabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof PaletteEntry) {
				ImageDescriptor descriptor = ((PaletteEntry)element).getSmallIcon();
				if(descriptor == null) {
					return null;
				}
				return Activator.getPluginIconImage(Activator.ID, descriptor);
			} else if(element instanceof Stereotype) {
				return Activator.getPluginIconImage(Activator.ID, "/icons/stereotype.gif");
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if(element instanceof PaletteEntry) {
				return ((PaletteEntry)element).getLabel();
			} else if(element instanceof Stereotype) {
				return ((Stereotype)element).getName();
			}
			return "unknown element";
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {

		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {

		}

	}

	/**
	 * Label provider for palette tools.
	 * <P>
	 * We should be using the Palette label provider from GEF, if it was not with visibility "package"...
	 * 
	 * @see org.eclipse.gef.ui.palette.customize.PaletteLabelProvider </P>
	 * 
	 */
	public class PaletteProxyLabelProvider implements ILabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy)element).getImage();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if(element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy)element).getLabel();
			}
			return "unknown element";
		}

		/**
		 * {@inheritDoc}
		 */
		public void addListener(ILabelProviderListener listener) {

		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {

		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {

		}

	}

	/**
	 * Filter for the viewer. Hide/show Drawers
	 */
	public class DrawerFilter extends ViewerFilter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof PaletteDrawer) {
				return false;
			}
			return true;
		}

	}

	/**
	 * Filter for the viewer. Hide/show Drawers
	 */
	public class ToolFilter extends ViewerFilter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if(element instanceof ToolEntry) {
				return false;
			}
			return true;
		}

	}

	/**
	 * Content provider for the palette
	 */
	public class PaletteContentProvider implements ITreeContentProvider {

		/** tree viewer this provider provides content */
		protected final TreeViewer viewer;

		/** the document root where to build the palette */
		protected PaletteContainerProxy rootProxy;

		/** model listener that will listens for all modifications in the entries */
		protected PropertyChangeListener modelListener = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent evt) {
				handlePropertyChanged(evt);
			}
		};

		/**
		 * Creates a new PaletteContentProvider.
		 * 
		 * @param treeviewer
		 *        tree viewer this provider provides content
		 */
		public PaletteContentProvider(TreeViewer treeviewer) {
			this.viewer = treeviewer;
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			// remove all listeners
			traverseModel(rootProxy, false);
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof PaletteEntryProxy) {
				List<PaletteEntryProxy> children = ((PaletteEntryProxy)parentElement).getChildren();
				return (children != null) ? children.toArray() : new Object[0];
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			if(element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy)element).getChildren() != null && !((PaletteEntryProxy)element).getChildren().isEmpty();
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = getChildren(inputElement);
			if(elements == null) {
				elements = new Object[0];
			}
			return elements;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if(element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy)element).getParent();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if(rootProxy != null) {
				// warning.. the root has no entry, this is a virtual node
				traverseModel(rootProxy, false);
			}

			if(newInput != null) {
				rootProxy = ((PaletteContainerProxy)newInput);
				traverseModel(rootProxy, true);
			}
		}

		/**
		 * This method is invoked whenever there is any change in the model. It updates the
		 * viewer with the changes that were made to the model. Sub-classes may override this
		 * method to change or extend its functionality.
		 * 
		 * @param evt
		 *        The {@link PropertyChangeEvent} that was fired from the model
		 */
		protected void handlePropertyChanged(PropertyChangeEvent evt) {
			PaletteEntryProxy entry = ((PaletteEntryProxy)evt.getSource());
			String property = evt.getPropertyName();
			if(property.equals(PaletteEntry.PROPERTY_LABEL) || property.equals(PaletteEntry.PROPERTY_SMALL_ICON) || property.equals(PaletteEntryProxy.PROPERTY_ICON_PATH)) {
				viewer.update(entry, null);
			} else if(property.equals(PaletteContainerProxy.PROPERTY_ADD_CHILDREN)) {
				viewer.refresh(entry.getParent());
				// add the listeners to the child
				traverseModel(((PaletteEntryProxy)evt.getNewValue()), true);
			} else if(property.equals(PaletteContainerProxy.PROPERTY_REMOVE_CHILDREN)) {
				viewer.refresh(entry.getParent());
				// add the listeners to the child
				traverseModel(((PaletteEntryProxy)evt.getOldValue()), false);
			}

		}

		protected void traverseModel(PaletteEntryProxy entryProxy, boolean isHook) {
			if(entryProxy != null) {
				if(isHook) {
					entryProxy.addPropertyChangeListener(modelListener);
				} else {
					entryProxy.removePropertyChangeListener(modelListener);
				}
			}

			if(entryProxy.getChildren() != null && !entryProxy.getChildren().isEmpty()) {
				for(PaletteEntryProxy proxy : entryProxy.getChildren()) {
					traverseModel(proxy, isHook);
				}
			}
		}
	}

	/**
	 * Performs all action on finish
	 * 
	 * @param id
	 *        the path for the file
	 */
	public void performFinish(String path) {
		// creates the document
		Document document = createXMLDocumentFromPalettePreview();
		saveDocument(document, path);
		requiredProfiles = collectRequiredProfiles();
	}

	/**
	 * collect the required profiles from all tool provided by the local palette definition
	 */
	protected Set<String> collectRequiredProfiles() {
		Set<String> profiles = new HashSet<String>();
		PaletteContainerProxy rootProxy = (PaletteContainerProxy)paletteTreeViewer.getInput();
		collectRequiredProfiles(rootProxy.getChildren(), profiles);
		return profiles;
	}

	/**
	 * collect the required profiles from all tool provided by the local palette definition
	 */
	protected void collectRequiredProfiles(List<PaletteEntryProxy> proxies, Set<String> requiredProfiles) {
		for(PaletteEntryProxy proxy : proxies) {
			// add profile(s) if relevant, check for children

			if(proxy instanceof PaletteAspectToolEntryProxy) {
				// list of profiles
				for(String stereotypeQN : ((PaletteAspectToolEntryProxy)proxy).getStereotypesQNList()) {
					// retrieve list of profiles from the stereotype QN (only remove last segment
					// ?!)
					String profileName = PaletteUtil.findProfileNameFromStereotypeName(stereotypeQN);
					requiredProfiles.add(profileName);
				}
			}

			if(proxy.getChildren() != null) {
				collectRequiredProfiles(proxy.getChildren(), requiredProfiles);
			}
		}
	}

	/**
	 * Saves the xml document into file
	 * 
	 * @param document
	 *        the document to save
	 * @param path
	 *        name of the file
	 * @return the file created or updated
	 */
	protected File saveDocument(Document document, String path) {
		File file = null;
		try {
			// create the file that stores the XML configuration
			file = Activator.getDefault().getStateLocation().append(path).toFile();
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer;

			aTransformer = tranFactory.newTransformer();

			Source src = new DOMSource(document);
			Result dest = new StreamResult(file);
			aTransformer.transform(src, dest);
		} catch (TransformerConfigurationException e) {
			Activator.log.error(e);
		} catch (TransformerException e) {
			Activator.log.error(e);
		}
		return file;

	}

	/**
	 * Creates the document from the palette preview
	 * 
	 * @return the dom structure of the document
	 */
	protected Document createXMLDocumentFromPalettePreview() {
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setNamespaceAware(true);
		DocumentBuilder documentBuilder;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.newDocument();
			Element paletteDefElement = document.createElement(IPapyrusPaletteConstant.PALETTE_DEFINITION);
			document.appendChild(paletteDefElement);
			Element contentElement = document.createElement(IPapyrusPaletteConstant.CONTENT);
			paletteDefElement.appendChild(contentElement);

			generateXMLPaletteContent(document, contentElement);
			return document;
		} catch (ParserConfigurationException e) {
			Activator.getDefault().logError("impossible to create the palette tree viewer content", e);
		}
		return null;
	}

	/**
	 * Generates the xml content for the palette
	 * 
	 * @param document
	 *        the document to fill
	 * @param contentElement
	 *        the root for the xml content
	 */
	protected void generateXMLPaletteContent(Document document, Element contentElement) {
		PaletteContainerProxy rootProxy = (PaletteContainerProxy)paletteTreeViewer.getInput();
		for(PaletteEntryProxy proxy : rootProxy.getChildren()) {
			generateXMLPaletteContainerProxy(document, contentElement, proxy);
		}
	}

	/**
	 * Generates the xml content for the given container
	 * 
	 * @param document
	 *        the document to fill
	 * @param containerProxy
	 *        the entry proxy
	 */
	protected void generateXMLPaletteContainerProxy(Document document, Element contentElement, PaletteEntryProxy containerProxy) {

		Element element = null;
		List<PaletteEntryProxy> children = containerProxy.getChildren();
		// generate the element
		switch(containerProxy.getType()) {
		case DRAWER:
			element = document.createElement(IPapyrusPaletteConstant.DRAWER);
			element.setAttribute(IPapyrusPaletteConstant.NAME, containerProxy.getLabel());
			if(containerProxy instanceof PaletteLocalDrawerProxy) {
				element.setAttribute(IPapyrusPaletteConstant.ICON_PATH, ((PaletteLocalDrawerProxy)containerProxy).getImagePath());
			}
			break;
		case TOOL:
			element = document.createElement(IPapyrusPaletteConstant.TOOL);
			break;
		case SEPARATOR:
			element = document.createElement(IPapyrusPaletteConstant.SEPARATOR);
			break;
		case STACK:
			element = document.createElement(IPapyrusPaletteConstant.STACK);
			break;
		case ASPECT_TOOL:
			element = document.createElement(IPapyrusPaletteConstant.ASPECT_TOOL);
			// try to cast the element into PaletteAspectToolEntryProxy
			if(containerProxy instanceof PaletteAspectToolEntryProxy) {
				PaletteAspectToolEntryProxy aspectEntryProxy = (PaletteAspectToolEntryProxy)containerProxy;
				// element.setAttribute(IPapyrusPaletteConstant.ID, aspectEntryProxy.getId());
				element.setAttribute(IPapyrusPaletteConstant.NAME, aspectEntryProxy.getLabel());
				element.setAttribute(IPapyrusPaletteConstant.DESCRIPTION, aspectEntryProxy.getEntry().getDescription());
				element.setAttribute(IPapyrusPaletteConstant.REF_TOOL_ID, aspectEntryProxy.getReferencedPaletteID());

				if(aspectEntryProxy.getImagePath() != null && !aspectEntryProxy.getImagePath().equals("")) {
					element.setAttribute(IPapyrusPaletteConstant.ICON_PATH, aspectEntryProxy.getImagePath());
				}


				// add post action, stereotype list
				for(IAspectAction action : ((PaletteAspectToolEntryProxy)containerProxy).getPostActions()) {
					Element postActionNode = document.createElement(IPapyrusPaletteConstant.POST_ACTION);
					postActionNode.setAttribute(IPapyrusPaletteConstant.ID, action.getFactoryId());
					action.save(postActionNode);
					element.appendChild(postActionNode);
				}
				for(IAspectAction action : ((PaletteAspectToolEntryProxy)containerProxy).getPreActions()) {
					Element preActionNode = document.createElement(IPapyrusPaletteConstant.PRE_ACTION);
					preActionNode.setAttribute(IPapyrusPaletteConstant.ID, action.getFactoryId());
					action.save(preActionNode);
					element.appendChild(preActionNode);
				}
			}
		default:
			break;
		}

		element.setAttribute(IPapyrusPaletteConstant.ID, containerProxy.getId());
		contentElement.appendChild(element);

		if(children != null) {
			for(PaletteEntryProxy proxy : children) {
				generateXMLPaletteContainerProxy(document, element, proxy);
			}
		}
	}

	public enum EntryType {
		DRAWER, TOOL, STACK, SEPARATOR, ASPECT_TOOL
	}

	public class LabelViewerComparator extends ViewerComparator {

		/**
		 * Creates a new LabelViewerComparator.
		 */
		public LabelViewerComparator() {
			super();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int compare(Viewer testViewer, Object e1, Object e2) {
			String label1 = "";
			String label2 = "";

			if(e1 instanceof PaletteEntry) {
				label1 = ((PaletteEntry)e1).getLabel();
			} else if(e1 instanceof Stereotype) {
				label1 = ((Stereotype)e1).getName();
			}
			if(e2 instanceof PaletteEntry) {
				label2 = ((PaletteEntry)e2).getLabel();
			} else if(e2 instanceof Stereotype) {
				label2 = ((Stereotype)e2).getName();
			}

			if(label1 == null) {
				return 1;
			}
			if(label2 == null) {
				return -1;
			}

			return label1.compareTo(label2);
		}
	}

	/**
	 * Listener for the profile combo. It changes the input of the following viewer.
	 */
	public class ProfileComboSelectionListener implements SelectionListener, ModifyListener {

		/**
		 * {@inheritDoc}
		 */
		public void widgetDefaultSelected(SelectionEvent e) {
			// nothing to do
		}

		/**
		 * {@inheritDoc}
		 */
		public void widgetSelected(SelectionEvent e) {
			handleSelectionChanged();
		}

		/**
		 * {@inheritDoc}
		 */
		public void modifyText(ModifyEvent e) {
			handleSelectionChanged();
		}

		/**
		 * handles the change selection for the combo
		 */
		protected void handleSelectionChanged() {
			int index = profileCombo.getSelectionIndex();
			if(index < 0 || index >= profileCombo.getItems().length) {
				return;
			}
			String name = profileComboList.get(index);

			Collection<PaletteEntry> standardEntries = getAllVisibleStandardEntries();
			// retrieve the profile or uml standards tools to display
			if(UML_TOOLS_LABEL.equals(name)) {
				// change content provider
				availableToolsViewer.setContentProvider(new UMLToolsTreeContentProvider());
				availableToolsViewer.setInput(standardEntries);
				toggleContentProvider.setEnabled(false);
			} else {
				if(toggleContentProvider != null && !toggleContentProvider.isDisposed()) {
					toggleContentProvider.setEnabled(true);
				}
				// switch content provider
				// this is a profile in case of uml2 tools
				Profile profile = getAllAppliedProfiles().get(index);
				if(toggleContentProvider.getSelection()) {
					availableToolsViewer.setContentProvider(new ProfileToolsStereotypeMetaclassTreeContentProvider(profile, standardEntries));
				} else {
					availableToolsViewer.setContentProvider(new ProfileToolsMetaclassStereotypeTreeContentProvider(profile, standardEntries));
				}

				// generate tools for given profile
				availableToolsViewer.setInput(profile);
			}
		}
	}

	/**
	 * Content provider for the available tools viewer, when the tools to see are coming from a
	 * profile
	 */
	public class ProfileToolsStereotypeMetaclassTreeContentProvider implements ITreeContentProvider {

		/** standard uml tools palette entries */
		final protected Collection<PaletteEntry> standardEntries;

		/**
		 * Creates a new ProfileToolsStereotypeMetaclassTreeContentProvider.
		 * 
		 * @param profile
		 *        the profile for which tools are built
		 * @param standardEntries
		 *        list of standard uml tools palette entries
		 */
		public ProfileToolsStereotypeMetaclassTreeContentProvider(Profile profile, Collection<PaletteEntry> standardEntries) {
			this.standardEntries = standardEntries;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof Profile) {
				return ((Profile)parentElement).getOwnedStereotypes().toArray();
			} else if(parentElement instanceof Stereotype) {
				List<PaletteEntry> entries = new ArrayList<PaletteEntry>();
				Stereotype stereotype = (Stereotype)parentElement;

				for(PaletteEntry entry : standardEntries) {
					// retrieve the element type created by the tool.
					if(entry instanceof CombinedTemplateCreationEntry) {

						EClass toolMetaclass = PaletteUtil.getToolMetaclass((CombinedTemplateCreationEntry)entry);
						if(toolMetaclass != null) {
							List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();
							for(Class stMetaclass : metaclasses) {
								// get Eclass
								java.lang.Class metaclassClass = stMetaclass.getClass();
								if(metaclassClass != null) {
									EClassifier metaClassifier = UMLPackage.eINSTANCE.getEClassifier(stMetaclass.getName());
									if(((EClass)metaClassifier).isSuperTypeOf(toolMetaclass)) {
										// should create the palette entry
										HashMap properties = new HashMap();
										properties.put(IPapyrusPaletteConstant.ASPECT_ACTION_KEY, StereotypeAspectActionProvider.createConfigurationNode(stereotype.getQualifiedName()));
										AspectCreationEntry aspectEntry = new AspectCreationEntry(stereotype.getName() + " (" + entry.getLabel() + ")", "Create an element with a stereotype", entry.getId() + "_" + System.currentTimeMillis(), entry.getSmallIcon(), (CombinedTemplateCreationEntry)entry, properties);
										entries.add(aspectEntry);
									}
								}

							}
						}
					}
				}
				return entries.toArray();
			} else {
				return new Object[0];
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if(element instanceof Stereotype) {
				return ((Stereotype)element).getProfile();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			if(element instanceof Profile) {
				return true;
			} else if(element instanceof Stereotype) {
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Profile) {
				List<Stereotype> stereotypes = ((Profile)inputElement).getOwnedStereotypes();
				return stereotypes.toArray();
			}
			return new Object[0];
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// nothing to do here
		}

	}

	/**
	 * Content provider for the available tools viewer, when the
	 */
	public class ProfileToolsMetaclassStereotypeTreeContentProvider implements ITreeContentProvider {

		/** standard uml tools palette entries */
		final protected Collection<PaletteEntry> standardEntries;

		/** profile to display */
		final protected Profile profile;

		/**
		 * Creates a new ProfileToolsMetaclassStereotypeTreeContentProvider.
		 * 
		 * @param profile
		 *        the profile for which tools are built
		 * @param standardEntries
		 *        list of standard uml tools palette entries
		 */
		public ProfileToolsMetaclassStereotypeTreeContentProvider(Profile profile, Collection<PaletteEntry> standardEntries) {
			this.profile = profile;
			this.standardEntries = standardEntries;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			if(parentElement instanceof Profile) {
				return standardEntries.toArray();
			} else if(parentElement instanceof AspectCreationEntry) {
				return new Object[0];
			} else if(parentElement instanceof PaletteEntry) {
				List<AspectCreationEntry> entries = new ArrayList<AspectCreationEntry>();
				// display all stereotypes applicable to the type of element created by this tool
				if(parentElement instanceof CombinedTemplateCreationEntry) {
					CombinedTemplateCreationEntry entry = (CombinedTemplateCreationEntry)parentElement;
					EClass toolMetaclass = PaletteUtil.getToolMetaclass(entry);
					if(toolMetaclass != null) {
						for(Stereotype stereotype : profile.getOwnedStereotypes()) {
							List<Class> metaclasses = stereotype.getAllExtendedMetaclasses();
							for(Class stMetaclass : metaclasses) {
								// get Eclass
								java.lang.Class metaclassClass = stMetaclass.getClass();
								if(metaclassClass != null) {
									EClassifier metaClassifier = UMLPackage.eINSTANCE.getEClassifier(stMetaclass.getName());
									if(((EClass)metaClassifier).isSuperTypeOf(toolMetaclass)) {
										// should create the palette entry
										HashMap properties = new HashMap();
										ArrayList<String> stereotypesQNToApply = new ArrayList<String>();
										properties.put(IPapyrusPaletteConstant.ASPECT_ACTION_KEY, StereotypeAspectActionProvider.createConfigurationNode(stereotype.getQualifiedName()));
										AspectCreationEntry aspectEntry = new AspectCreationEntry(stereotype.getName() + " (" + entry.getLabel() + ")", "Create an element with a stereotype", entry.getId() + "_" + System.currentTimeMillis(), entry.getSmallIcon(), entry, properties);
										entries.add(aspectEntry);
									}
								}

							}
						}
					}
				}
				return entries.toArray();
			} else {
				return new Object[0];
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if(element instanceof Stereotype) {
				return ((Stereotype)element).getProfile();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			if(element instanceof Profile) {
				return true;
			} else if(element instanceof AspectCreationEntry) {
				return false;
			} else if(element instanceof PaletteEntry) {
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof Profile) {
				return standardEntries.toArray();
			}
			return new Object[0];
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			// nothing to do here
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// nothing to do here
		}

	}

	/**
	 * Returns the list of all visible palette entries
	 * 
	 * @return the list of all visible palette entries
	 */
	protected Collection<PaletteEntry> getAllVisibleStandardEntries() {
		HashSet<PaletteEntry> result = new HashSet<PaletteEntry>();
		for(PaletteEntry entry : PaletteUtil.getAvailableEntriesSet(editorPart, priority).values()) {
			// the entry is not just a defineOnly entry but a visible one
			if(getRootParent(entry) != null) {
				result.add(entry);
			}
		}
		return result;
	}

	/**
	 * Returns the Root element for the palette entry. It searches recursively from parent to parent, until it find the root element
	 * 
	 * @param entry
	 *        the palette entry for which root element is searched
	 * @return the root element or <code>null</code> if none was found
	 */
	protected PaletteRoot getRootParent(PaletteEntry entry) {
		PaletteContainer parent = entry.getParent();
		if(parent instanceof PaletteRoot) {
			return (PaletteRoot)parent;
		} else if(parent != null) {
			return getRootParent(parent);
		} else {
			return null;
		}
	}

	/**
	 * Returns the list of required profiles by this local palette definition
	 * 
	 * @return the profiles required by this palette
	 */
	public Set<String> getRequiredProfiles() {
		return requiredProfiles;
	}

	/**
	 * Item validator
	 */
	protected abstract class ToolBarItemValidator {

		/**
		 * Checks if the button should be enable or not
		 * 
		 * @return <code>true</code> if the button should be enable
		 */
		public abstract boolean isEnable();
	}

	/**
	 * validator for the edit element tool item. It does not remove
	 */
	protected class EditElementToolBarItemValidator extends ToolBarItemValidator {

		/**
		 * @{inheritDoc
		 */
		@Override
		public boolean isEnable() {
			// retrieve selection
			if(paletteTreeViewer != null && !paletteTreeViewer.getControl().isDisposed()) {
				// retrieve selection. first element should be a drawer
				IStructuredSelection selection = (IStructuredSelection)paletteTreeViewer.getSelection();
				if(selection == null) {
					return false;
				} else {
					// look for first element. should be an instance of drawer
					return (selection.getFirstElement() instanceof PaletteLocalDrawerProxy);
				}
			}
			return false;
		}
	}

	/**
	 * validator for the create separator or stack tool item. Only valid when selection is a {@link PaletteEntryProxy} or a
	 * {@link PaletteLocalDrawerProxy}
	 */
	protected class PaletteEntryProxySelectedValidator extends ToolBarItemValidator {

		/**
		 * @{inheritDoc
		 */
		@Override
		public boolean isEnable() {
			// retrieve selection
			if(paletteTreeViewer != null && !paletteTreeViewer.getControl().isDisposed()) {
				// retrieve selection. first element should be a drawer
				IStructuredSelection selection = (IStructuredSelection)paletteTreeViewer.getSelection();
				if(selection == null) {
					return false;
				} else {
					Object object = selection.getFirstElement();
					return (object instanceof PaletteEntryProxy);
				}
			}
			return false;
		}
	}

	/**
	 * Sets the priority of the current edited palette
	 * 
	 * @param priority
	 *        the priority of the current edited palette
	 */
	public void setPriority(ProviderPriority priority) {
		this.priority = priority;
	}
}
