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
package org.eclipse.papyrus.diagram.common.wizards;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.PaletteStack;
import org.eclipse.gef.palette.PaletteToolbar;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteViewer;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.part.PaletteUtil;
import org.eclipse.papyrus.diagram.common.part.PapyrusPalettePreferences;
import org.eclipse.papyrus.diagram.common.service.IPapyrusPaletteConstant;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Wizard page for information about the new local palette definition
 */
public class LocalPaletteContentPage extends WizardPage implements Listener {

	/** editor part in which the palette is created */
	protected IEditorPart editorPart;

	/** available tools viewer */
	protected TableViewer availableToolsViewer;

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
	protected static final String ADD_ICON = "/icons/ArrowRight.gif";

	/** icon path for the remove button */
	protected static final String REMOVE_ICON = "/icons/ArrowLeft.gif";

	// /** icon path for the disabled add icon */
	// protected static final String ADD_DISABLED_ICON =
	// "/icons/ArrowRight_dis.gif";;
	//
	// /** icon path for the disabled add icon */
	// protected static final String REMOVE_DISABLED_ICON =
	// "/icons/ArrowLeft_dis.gif";;

	/** instance of the filter used to show/hide drawers */
	protected final ViewerFilter drawerFilter = new DrawerFilter();

	/** instance of the filter used to show/hide tools */
	protected final ViewerFilter toolFilter = new ToolFilter();

	/** stored preferences */
	private List<String> storedPreferences;

	/** add button */
	protected Button addButton;

	/** remove button */
	protected Button removeButton;

	/** tree viewer for the new palette */
	protected TreeViewer paletteTreeViewer;

	/** document for element creation */
	protected Document document;

	/**
	 * Creates a new wizard page with the given name, title, and image.
	 * 
	 * @param part
	 *            the editor part in which the wizard was created
	 */
	public LocalPaletteContentPage(IEditorPart part) {
		super(Messages.Local_Palette_ContentPage_Name, Messages.Local_Palette_ContentPage_Title, Activator
				.getImageDescriptor(WIZARD_ICON));
		this.editorPart = part;
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
		GridLayout layout = new GridLayout(3, false);
		control.setLayout(layout);
		control.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		setControl(control);

		// small workaround to have all
		updatePreferences();

		// create Available Tools Group
		createAvailableToolsGroup();

		// create add/remove buttons
		createAddRemoveButtons();

		// create Palette Group
		createPalettePreviewGroup();

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
		setPageComplete(false);
		setControl(control);
	}

	/**
	 * update the preferences to have all tools accessible
	 */
	private void updatePreferences() {
		// change => set to no hidden palettes
		storedPreferences = PapyrusPalettePreferences.getHiddenPalettes(editorPart);

		// remove all, but should only remove visible palettes
		for (String id : storedPreferences) {
			PapyrusPalettePreferences.changePaletteVisibility(id, editorPart, true);
		}
	}

	/**
	 * Restore preferences
	 */
	public void restorePreferences() {
		// remove all, but should only remove visible palettes
		for (String id : storedPreferences) {
			PapyrusPalettePreferences.changePaletteVisibility(id, editorPart, false);
		}
	}

	/**
	 * creates the palette preview group
	 */
	protected void createPalettePreviewGroup() {
		Composite parent = (Composite) getControl();
		Composite paletteComposite = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		paletteComposite.setLayout(layout);

		Label label = new Label(paletteComposite, SWT.NONE);
		label.setText(Messages.Local_Palette_Palette_Preview);
		GridData data = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		label.setLayoutData(data);

		ToolBar toolbar = new ToolBar(paletteComposite, SWT.HORIZONTAL);
		data = new GridData(SWT.RIGHT, SWT.FILL, false, false);
		toolbar.setLayoutData(data);
		populatePalettePreviewToolBar(toolbar);

		Tree tree = new Tree(paletteComposite, SWT.SINGLE | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will
		// keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		tree.setLayoutData(data);
		paletteTreeViewer = new TreeViewer(tree);
		paletteTreeViewer.setContentProvider(new PaletteContentProvider(paletteTreeViewer));
		paletteTreeViewer.setLabelProvider(new PaletteProxyLabelProvider());

		PaletteContainerProxy contentNode = createPaletteTreeViewerInput();
		paletteTreeViewer.setInput(contentNode);
	}

	/**
	 * Creates the palette root content
	 * 
	 * @return the root container for the palette
	 */
	private PaletteContainerProxy createPaletteTreeViewerInput() {
		return new PaletteContainerProxy(null);
	}

	/**
	 * populates the preview palette toolbar
	 */
	protected void populatePalettePreviewToolBar(ToolBar toolbar) {
		// nothing here
	}

	/**
	 * creates the buttons to add/remove entries
	 */
	protected void createAddRemoveButtons() {
		Composite composite = new Composite((Composite) getControl(), SWT.NONE);
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
		// add listener to listen for changes in the right tree
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
				Object source = ((IStructuredSelection) availableToolsViewer.getSelection()).getFirstElement();
				Object target = ((IStructuredSelection) paletteTreeViewer.getSelection()).getFirstElement();

				if (isValidTarget(source, target)) {
					addButton.setEnabled(true);
				} else {
					addButton.setEnabled(false);
				}
			}

			/**
			 * Returns true if the source can be added to the target
			 * 
			 * @param source
			 *            the source object
			 * @param target
			 *            the target object
			 * @return <code>true</code> if the source can be added to the target
			 */
			protected boolean isValidTarget(Object source, Object target) {
				if (!(source instanceof PaletteEntry)) {
					return false;
				}

				// case1: source is a drawer.
				// it can only be added to the root element (no selection)
				// case2: source is a palette tool
				// it can't be added to the root element
				// it can only be added to a container element (drawer or stack)
				if (source instanceof PaletteDrawer) {
					if (target == null) {
						return true;
					}
					return false;
				} else if (source instanceof ToolEntry) {
					if (target instanceof PaletteEntryProxy) {
						EntryType type = ((PaletteEntryProxy) target).getType();
						switch (type) {
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
				IStructuredSelection selection = (IStructuredSelection) availableToolsViewer.getSelection();
				if (selection == null || selection.size() < 1) {
					return;
				}
				PaletteEntry entry = (PaletteEntry) selection.getFirstElement();
				if (entry == null) {
					return;
				}

				// find the selection on the right
				selection = (IStructuredSelection) paletteTreeViewer.getSelection();

				PaletteEntryProxy parentNode = (PaletteEntryProxy) selection.getFirstElement();
				// Bugfix: only drawers can be added to root element
				if (parentNode == null && entry instanceof PaletteDrawer) {
					parentNode = (PaletteContainerProxy) paletteTreeViewer.getInput();
				}

				// check we have a containe here
				if (!(parentNode instanceof PaletteContainerProxy)) {
					return;
				}

				// create a new entry in the document
				createNodeFromEntry(entry, (PaletteContainerProxy) parentNode);
				paletteTreeViewer.refresh();
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
	 *            the palette entry from which to create the node
	 * @param parentNode
	 *            the parent node for the newly created node
	 */
	protected void createNodeFromEntry(PaletteEntry entry, PaletteContainerProxy parent) {
		// Element element = null;
		// if (entry instanceof PaletteDrawer) {
		// element = document.createElement(IPapyrusPaletteConstant.DRAWER);
		// } else if (entry instanceof ToolEntry) {
		// element = document.createElement(IPapyrusPaletteConstant.TOOL);
		// }
		// if (element == null) {
		// return;
		// }
		// adds the node to the parent node

		PaletteEntryProxy proxy = null;

		if (entry instanceof PaletteContainer) {
			proxy = new PaletteContainerProxy((PaletteContainer) entry);
		} else {
			proxy = new PaletteEntryProxy(entry);
		}
		parent.addChild(proxy);

		// sets the id
		// element.setAttribute(IPapyrusPaletteConstant.ID, entry.getId());

	}

	/**
	 * Creates the add button listener
	 */
	protected MouseListener createRemoveButtonListener() {
		return new MouseListener() {

			public void mouseUp(MouseEvent e) {
				// remove the element selected on the right
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
	private void createAvailableToolsGroup() {
		Composite parent = (Composite) getControl();
		Composite availableToolsComposite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(2, true);
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		availableToolsComposite.setLayout(layout);

		Label label = new Label(availableToolsComposite, SWT.NONE);
		label.setText(Messages.Local_Palette_Available_Tools);
		GridData data = new GridData(SWT.LEFT, SWT.CENTER, true, true);
		label.setLayoutData(data);

		ToolBar toolbar = new ToolBar(availableToolsComposite, SWT.HORIZONTAL);
		data = new GridData(SWT.RIGHT, SWT.FILL, false, false);
		toolbar.setLayoutData(data);
		populateAvailableToolsToolBar(toolbar);

		Table table = new Table(availableToolsComposite, SWT.SINGLE | SWT.BORDER);
		data = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1);
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will
		// keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		table.setLayoutData(data);
		availableToolsViewer = new TableViewer(table);
		availableToolsViewer.setContentProvider(new ToolsTableContentProvider());
		availableToolsViewer.setLabelProvider(new PaletteLabelProvider());
		// remove the note stack and standard group
		availableToolsViewer.addFilter(new ViewerFilter() {

			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof PaletteStack && "noteStack".equals(((PaletteStack) element).getId())) {
					return false;
				} else if (element instanceof PaletteToolbar
						&& "standardGroup".equals(((PaletteToolbar) element).getId())) {
					return false;
				}
				return true;
			}
		});
		availableToolsViewer.setInput(((PaletteViewer) editorPart.getAdapter(PaletteViewer.class)).getPaletteRoot());
	}

	/**
	 * Adds elements to the tool bar for available tools viewer
	 * 
	 * @param toolbar
	 *            the toolbar to populate
	 */
	protected void populateAvailableToolsToolBar(ToolBar toolbar) {
		createToolBarItem(toolbar, SHOWN_DRAWERS_ICON, HIDDEN_DRAWERS_ICON, Messages.Local_Palette_ShowDrawers_Tooltip,
				createDrawerListener());
		createToolBarItem(toolbar, SHOWN_TOOLS_ICON, HIDDEN_TOOLS_ICON, Messages.Local_Palette_ShowTools_Tooltip,
				createToolListener());
	}

	/**
	 * creates the tool item for drawers visibility listener
	 * 
	 * @return the listener for the tool button
	 */
	protected Listener createDrawerListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				if (!(event.widget instanceof ToolItem)) {
					return;
				}
				ToolItem item = ((ToolItem) event.widget);
				if (item.getSelection()) {
					// elements should be hidden
					availableToolsViewer.addFilter(drawerFilter);
				} else {
					availableToolsViewer.removeFilter(drawerFilter);
				}
			}
		};
	}

	/**
	 * creates the tool item for tools visibility listener
	 * 
	 * @return the listener for the tool button
	 */
	protected Listener createToolListener() {
		return new Listener() {

			/**
			 * {@inheritDoc}
			 */
			public void handleEvent(Event event) {
				if (!(event.widget instanceof ToolItem)) {
					return;
				}
				ToolItem item = ((ToolItem) event.widget);
				if (item.getSelection()) {
					// elements should be hidden
					availableToolsViewer.addFilter(toolFilter);
				} else {
					availableToolsViewer.removeFilter(toolFilter);
				}
			}
		};
	}

	/**
	 * Creates a toolbar item.
	 * 
	 * @param toolbar
	 *            the parent toolbar
	 * @param shownElementsIcon
	 *            path for shown elements icon
	 * @param hiddenElementsIcon
	 *            path for hidden elements icon
	 * @param tooltip
	 *            tooltip text for the toolbar item
	 */
	protected void createToolBarItem(ToolBar toolbar, String shownElementsIcon, String hiddenElementsIcon,
			String tooltip, Listener listener) {
		ToolItem item = new ToolItem(toolbar, SWT.CHECK | SWT.BORDER);
		item.setDisabledImage(Activator.getPluginIconImage(Activator.ID, hiddenElementsIcon));
		item.setImage(Activator.getPluginIconImage(Activator.ID, shownElementsIcon));
		item.setToolTipText(tooltip);
		item.addListener(SWT.Selection, listener);
	}

	/**
	 * Validates the content of the fields in this page
	 */
	protected boolean validatePage() {
		boolean valid = true;

		if (valid) {
			setMessage(null);
			setErrorMessage(null);
		}
		return valid;
	}

	/**
	 * The <code>WizardNewFileCreationPage</code> implementation of this <code>Listener</code>
	 * method handles all events and enablements for controls on this page. Subclasses may extend.
	 */
	public void handleEvent(Event event) {
		setPageComplete(validatePage());
	}

	/**
	 * Content provider for available tools viewer
	 */
	public class ToolsTableContentProvider implements IStructuredContentProvider {

		/**
		 * Constructor
		 * 
		 * @param viewer
		 *            The viewer whose ContentProvider this content provider is
		 */
		public ToolsTableContentProvider() {
		}

		/**
		 * If the given element does not have any children, this method should return
		 * <code>null</code>. This fixes the problem where a "+" sign is incorrectly placed next to
		 * an empty container in the tree.
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(Object)
		 */
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PaletteContainer) {
				List<ToolEntry> children = PaletteUtil.getAllToolEntries((PaletteContainer) parentElement);
				if (!children.isEmpty()) {
					return children.toArray();
				}
			}
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(Object)
		 */
		// @unused
		public boolean hasChildren(Object element) {
			return getChildren(element) != null;
		}

		/**
		 * This method should not return <code>null</code>.
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = null;

			if (inputElement instanceof PaletteRoot) {
				elements = PaletteUtil.getAllEntries(((PaletteRoot) inputElement)).toArray();
			}

			if (elements == null) {
				elements = new Object[0];
			}
			return elements;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(Object)
		 */
		// @unused
		public Object getParent(Object element) {
			return ((PaletteEntry) element).getParent();
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
	}

	/**
	 * Label provider for palette tools.
	 * <P>
	 * We should be using the Palette label provider from GEF, if it was not with visibility
	 * "package"...
	 * 
	 * @see org.eclipse.gef.ui.palette.customize.PaletteLabelProvider </P>
	 * 
	 */
	public class PaletteLabelProvider implements ILabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			if (element instanceof PaletteEntry) {
				ImageDescriptor descriptor = ((PaletteEntry) element).getSmallIcon();
				if (descriptor == null) {
					return null;
				}
				return Activator.getPluginIconImage(Activator.ID, descriptor);
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if (element instanceof PaletteEntry) {
				return ((PaletteEntry) element).getLabel();
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
	 * We should be using the Palette label provider from GEF, if it was not with visibility
	 * "package"...
	 * 
	 * @see org.eclipse.gef.ui.palette.customize.PaletteLabelProvider </P>
	 * 
	 */
	public class PaletteProxyLabelProvider implements ILabelProvider {

		/**
		 * {@inheritDoc}
		 */
		public Image getImage(Object element) {
			if (element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy) element).getImage();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getText(Object element) {
			if (element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy) element).getLabel();
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
			if (element instanceof PaletteDrawer) {
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
			if (element instanceof ToolEntry) {
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
		private final TreeViewer viewer;

		/** the document root where to build the palette */
		private PaletteContainerProxy rootProxy;

		/**
		 * Creates a new PaletteContentProvider.
		 * 
		 * @param treeviewer
		 *            tree viewer this provider provides content
		 */
		public PaletteContentProvider(TreeViewer treeviewer) {
			this.viewer = treeviewer;
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			//
		}

		/**
		 * If the given element does not have any children, this method should return
		 * <code>null</code>. This fixes the problem where a "+" sign is incorrectly placed next to
		 * an empty container in the tree.
		 * 
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(Object)
		 */
		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy) parentElement).getChildren().toArray();
			}
			return null;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object element) {
			if (element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy) element).getChildren() != null
						&& !((PaletteEntryProxy) element).getChildren().isEmpty();
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = getChildren(inputElement);
			if (elements == null) {
				elements = new Object[0];
			}
			return elements;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object getParent(Object element) {
			if (element instanceof PaletteEntryProxy) {
				return ((PaletteEntryProxy) element).getParent();
			}
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(Viewer, Object, Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// if (root != null)
			// traverseModel(root, false);
			if (newInput != null) {
				rootProxy = (PaletteContainerProxy) newInput;
				// traverseModel(root, true);
			}
		}
	}

	/**
	 * Proxy class for palette entries
	 */
	protected class PaletteEntryProxy {

		/** proxy palette entry */
		private final PaletteEntry entry;

		/** parent of this proxy */
		private PaletteContainerProxy parent;

		/** proxy type */
		private EntryType type;

		public PaletteEntryProxy(PaletteEntry entry) {
			this.entry = entry;
			setType(initType());
		}

		/**
		 * Returns the entry cached by this class
		 * 
		 * @return the palette entry
		 */
		public PaletteEntry getEntry() {
			return entry;
		}

		/**
		 * Inits the entry type for this proxy
		 * 
		 * @return the entry type for this proxy
		 */
		protected EntryType initType() {
			if (entry instanceof PaletteDrawer) {
				return EntryType.DRAWER;
			} else if (entry instanceof PaletteSeparator) {
				return EntryType.SEPARATOR;
			} else if (entry instanceof PaletteStack) {
				return EntryType.STACK;
			} else if (entry instanceof ToolEntry) {
				return EntryType.TOOL;
			}
			return EntryType.TOOL;
		}

		/**
		 * returns the label of the cached entry
		 * 
		 * @return the label of the cached entry
		 */
		public String getLabel() {
			return entry.getLabel();
		}

		/**
		 * returns the id of the cached entry
		 * 
		 * @return the id of the cached entry
		 */
		public String getId() {
			return entry.getId();
		}

		/**
		 * returns the small icon of the cached entry
		 * 
		 * @return the small icon of the cached entry
		 */
		public Image getImage() {
			return Activator.getPluginIconImage(Activator.ID, entry.getSmallIcon());
		}

		/**
		 * Sets the parent for this proxy
		 * 
		 * @param parent
		 *            the parent proxy
		 */
		public void setParent(PaletteContainerProxy parent) {
			this.parent = parent;
		}

		/**
		 * Returns the parent of this proxy
		 * 
		 * @return the parent of this proxy
		 */
		public PaletteContainerProxy getParent() {
			return parent;
		}

		/**
		 * Returns the list of children for this entry. By default, entries do not have children.
		 * 
		 * @return the list of children for this entry
		 */
		public List<PaletteEntryProxy> getChildren() {
			return null;
		}

		/**
		 * Sets the king of tool it is.
		 * 
		 * @param type
		 *            the type to set
		 */
		public void setType(EntryType type) {
			this.type = type;
		}

		/**
		 * Returns the kind of entry
		 * 
		 * @return the kind of entry
		 */
		public EntryType getType() {
			return type;
		}
	}

	/**
	 * Proxy class for container entries
	 */
	protected class PaletteContainerProxy extends PaletteEntryProxy {

		/** list of children for this container */
		List<PaletteEntryProxy> children = new ArrayList<PaletteEntryProxy>();

		/**
		 * Creates a new PaletteContainer
		 * 
		 * @param drawer
		 *            the drawer to cache
		 */
		public PaletteContainerProxy(PaletteContainer drawer) {
			super(drawer);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public PaletteContainer getEntry() {
			return (PaletteContainer) super.getEntry();
		}

		/**
		 * Method to add a child proxy to this proxy
		 * 
		 * @param entry
		 *            the entry to add
		 */
		public void addChild(PaletteEntryProxy entry) {
			children.add(entry);
			entry.setParent(this);
			// should throw an event here
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public List<PaletteEntryProxy> getChildren() {
			return children;
		}
	}

	/**
	 * Performs all action on finish
	 * 
	 * @param id
	 *            the path for the file
	 */
	public void performFinish(String path) {
		// creates the document
		Document document = createXMLDocumentFromPalettePreview();
		saveDocument(document, path);
	}

	/**
	 * Saves the xml document into file
	 * 
	 * @param document
	 *            the document to save
	 * @param path
	 *            name of the file
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
			PapyrusTrace.log(e);
		} catch (TransformerException e) {
			PapyrusTrace.log(e);
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
	 *            the document to fill
	 * @param contentElement
	 *            the root for the xml content
	 */
	protected void generateXMLPaletteContent(Document document, Element contentElement) {
		PaletteContainerProxy rootProxy = (PaletteContainerProxy) paletteTreeViewer.getInput();
		for (PaletteEntryProxy proxy : rootProxy.getChildren()) {
			generateXMLPaletteContainerProxy(document, contentElement, proxy);
		}
	}

	/**
	 * Generates the xml content for the given container
	 * 
	 * @param document
	 *            the document to fill
	 * @param containerProxy
	 *            the entry proxy
	 */
	protected void generateXMLPaletteContainerProxy(Document document, Element contentElement,
			PaletteEntryProxy containerProxy) {

		Element element = null;
		List<PaletteEntryProxy> children = containerProxy.getChildren();
		// generate the element
		switch (containerProxy.getType()) {
		case DRAWER:
			element = document.createElement(IPapyrusPaletteConstant.DRAWER);
			element.setAttribute(IPapyrusPaletteConstant.NAME, containerProxy.getLabel());
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
		default:
			break;
		}

		element.setAttribute(IPapyrusPaletteConstant.ID, containerProxy.getId());
		contentElement.appendChild(element);

		if (children != null) {
			for (PaletteEntryProxy proxy : children) {
				generateXMLPaletteContainerProxy(document, element, proxy);
			}
		}
	}

	public enum EntryType {
		DRAWER, TOOL, STACK, SEPARATOR
	}

}
