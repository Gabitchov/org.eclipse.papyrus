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

package org.eclipse.papyrus.diagram.common.part;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteEntry;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteCustomizerDialogEx;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.papyrus.diagram.common.service.PapyrusPaletteService;
import org.eclipse.papyrus.diagram.common.wizards.NewLocalPaletteWizard;
import org.eclipse.papyrus.sasheditor.editor.ISashWindowsContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * specific dialog window for the customisation of the palette
 */
public class PapyrusPaletteCustomizerDialog extends PaletteCustomizerDialogEx {

	/** left arrow image */
	// @unused
	protected static final String LEFT_ARROW = "icons/ArrowLeft.gif";

	/** right arrow image */
	// @unused
	protected static final String RIGHT_ARROW = "icons/ArrowRight.gif";

	/** new local palette icon */
	private static final String NEW_LOCAL_DESC_IMAGE = "/icons/local_desc_new.gif";

	/** delete palette icon */
	private static final String DELETE_LOCAL_DESC_IMAGE = "/icons/local_desc_delete.gif";

	/** path to the local descriptor icon */
	protected final String LOCAL_DESCRIPTOR = "/icons/local_desc.gif";

	/** path to the plugin descriptor icon */
	protected final String PLUGIN_DESCRIPTOR = "/icons/plugin_desc.gif";

	/** viewer for the available tools */
	protected TreeViewer availableToolsTreeViewer;

	/** tree viewed by the availableToolsTreeViewer */
	// @unused
	protected Tree availableToolsTree;

	/** table viewed by the availablePalettesTreeViewer */
	protected Table availablePalettesTable;

	/** viewer for the available palettes */
	protected CheckboxTableViewer availablePalettesTableViewer;

	/** label provider for palette provider */
	private PaletteLabelProvider providersLabelProvider;

	/**
	 * Creates a new PapyrusPaletteCustomizerDialog
	 * 
	 * @param shell
	 *            the shell that hosts the dialog window
	 * @param customizer
	 *            the customizer used to customize the palette
	 * @param root
	 *            the root of the palette
	 */
	public PapyrusPaletteCustomizerDialog(Shell shell, PaletteCustomizer customizer, PaletteRoot root) {
		super(shell, customizer, root);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		// RS: does not call super, as the composite should not be drawn like
		// they are in parent
		Composite mainComposite = createMainComposite(parent);

		final Control availableToolsComposite = createAvailablePalettesViewer(mainComposite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		// data.right = new FormAttachment(40, 0);
		availableToolsComposite.setLayoutData(data);

		// final Control displayButtons = createDisplayButtons(mainComposite);
		// data = new FormData();
		// data.left = new FormAttachment(availableToolsComposite, 0);
		// // data.width = 30;
		// data.top = new FormAttachment(40, 0);
		// data.bottom = new FormAttachment(100, 0);
		// displayButtons.setLayoutData(data);

		final Label nameLabel = new Label(mainComposite, SWT.NONE);
		nameLabel.setText(Messages.Palette_Viewer);
		data = new FormData();
		data.left = new FormAttachment(availableToolsComposite, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(0, 0);
		nameLabel.setLayoutData(data);

		// Create the tree
		Control outline = createOutline(mainComposite);
		data = new FormData();
		data.left = new FormAttachment(availableToolsComposite, ITabbedPropertyConstants.HSPACE);
		data.top = new FormAttachment(nameLabel, 0);
		data.bottom = new FormAttachment(100, 0);
		// data.right = new FormAttachment(90, 0);
		outline.setLayoutData(data);

		// Create the panel where the properties of the selected palette entry
		// will
		// be shown
		Control properties = createPropertiesPanel(mainComposite);
		data = new FormData();
		data.left = new FormAttachment(outline, ITabbedPropertyConstants.HSPACE);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		properties.setLayoutData(data);

		return mainComposite;
	}

	/*
	 * protected Control createDisplayButtons(Composite container) { // Create the Composite that
	 * will contain the available tools Composite composite = new Composite(container, SWT.NONE);
	 * composite.setFont(container.getFont()); GridLayout layout = new GridLayout(1, false);
	 * layout.horizontalSpacing = 0; layout.verticalSpacing = 0; layout.marginHeight = 0;
	 * layout.marginWidth = 0; composite.setLayout(layout);
	 * 
	 * addButton = new Button(composite, SWT.NONE); addButton.setText(""); addButton
	 * .setToolTipText(Messages.PapyrusPaletteCustomizerDialog_AddButtonTooltip );
	 * addButton.setImage(Activator.getPluginIconImage(Activator.ID, RIGHT_ARROW)); GridData data =
	 * new GridData(SWT.CENTER, SWT.CENTER, false, false); addButton.setLayoutData(data);
	 * addButton.addMouseListener(new MouseListener() {
	 * 
	 * public void mouseUp(MouseEvent e) { addEntry(e);
	 * 
	 * }
	 * 
	 * public void mouseDown(MouseEvent e) { // on mouse down, do nothing }
	 * 
	 * public void mouseDoubleClick(MouseEvent e) { // on double click, do nothing } });
	 * 
	 * removeButton = new Button(composite, SWT.NONE); removeButton.setToolTipText
	 * (Messages.PapyrusPaletteCustomizerDialog_RemoveButtonTooltip);
	 * removeButton.setImage(Activator.getImage(LEFT_ARROW)); removeButton.setLayoutData(data);
	 * 
	 * return composite; }
	 */

	// @unused
	protected void addEntry(MouseEvent e) {
		ISelection selection = availableToolsTreeViewer.getSelection();
		PaletteEntry entry = null;
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (!(firstElement instanceof PaletteEntry)) {
				return;
			} else {
				entry = ((PaletteEntry) firstElement);
			}
		}
		// sets the active entry, to have the page useful for saving
		// modification
		setActiveEntry(entry);
		// add entry to the selected container
		// retrieve the selection in the palette viewer
		PaletteEntry destContainer = getSelectedPaletteEntry();
		((PapyrusPaletteCustomizer) getCustomizer()).storePaletteState(entry);
		if (destContainer instanceof PaletteContainer) {
			PaletteContainer oldParent = entry.getParent();

			// checks if the parent is already changed. If not, must store the
			// standard parent (the
			// one given by the factory)
			PaletteContainer stdParent = ((PapyrusPaletteCustomizer) getCustomizer()).changedParents.get(entry);
			if (stdParent == null) {
				((PapyrusPaletteCustomizer) getCustomizer()).changedParents.put(entry, entry.getParent());
			}
			oldParent.remove(entry);
			entry.setParent((PaletteContainer) destContainer);
			((PaletteContainer) destContainer).add(entry);
		} else {
			// add it to the palette root
			PaletteRoot root = (PaletteRoot) PaletteUtil.getRoot(entry);
			if (root != null) {
				PaletteContainer oldParent = entry.getParent();
				PaletteContainer stdParent = ((PapyrusPaletteCustomizer) getCustomizer()).changedParents.get(entry);
				if (stdParent == null) {
					((PapyrusPaletteCustomizer) getCustomizer()).changedParents.put(entry, stdParent);
				}
				oldParent.remove(entry);
				entry.setParent(root);
				root.add(entry);
			}
		}

	}

	/**
	 * Creates the available palettes viewer part of the dialog.
	 * 
	 * @param container
	 *            The Composite within which the viewer has to be created
	 * @return The newly created Control that has the viewer
	 */
	protected Control createAvailablePalettesViewer(Composite container) {
		// Create the Composite that will contain the available tools
		Composite composite = new Composite(container, SWT.NONE);
		composite.setFont(container.getFont());
		GridLayout layout = new GridLayout(3, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		final Label nameLabel = new Label(composite, SWT.NONE);
		nameLabel.setText(Messages.Available_Palettes);
		GridData data = new GridData(SWT.FILL, SWT.CENTER, true, false);
		nameLabel.setLayoutData(data);

		final Button newPalette = new Button(composite, SWT.NONE);
		newPalette.setImage(Activator.getImage(NEW_LOCAL_DESC_IMAGE));
		newPalette.setToolTipText(Messages.Dialog_Create_Palette_Tooltip);
		newPalette.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				createNewLocalPalette();
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		data = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		newPalette.setLayoutData(data);

		final Button deletePalette = new Button(composite, SWT.NONE);
		deletePalette.setImage(Activator.getImage(DELETE_LOCAL_DESC_IMAGE));
		deletePalette.setToolTipText(Messages.Dialog_Delete_Palette_Tooltip);
		deletePalette.addMouseListener(new MouseListener() {

			/**
			 * {@inheritDoc}
			 */
			public void mouseUp(MouseEvent e) {
				deleteLocalPalette();
			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDown(MouseEvent e) {

			}

			/**
			 * {@inheritDoc}
			 */
			public void mouseDoubleClick(MouseEvent e) {

			}
		});
		data = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		deletePalette.setLayoutData(data);

		availablePalettesTable = new Table(composite, SWT.BORDER | SWT.CHECK);
		availablePalettesTable.setFont(composite.getFont());
		availablePalettesTable.addSelectionListener(new SelectionListener() {

			/**
			 * {@inheritDoc}
			 */
			public void widgetSelected(SelectionEvent e) {
				if (e.detail == SWT.CHECK) {
					TableItem item = (TableItem) e.item;
					// one item was checked => display/hide the given provider
					changeProviderVisibility((PapyrusPaletteService.ProviderDescriptor) item.getData(), item
							.getChecked());
				}
			}

			/**
			 * {@inheritDoc}
			 */
			public void widgetDefaultSelected(SelectionEvent e) {
				// does nothing
			}
		});
		data = new GridData(GridData.FILL_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL);
		data.horizontalSpan = 3;
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will
		// keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		availablePalettesTable.setLayoutData(data);
		availablePalettesTableViewer = new CheckboxTableViewer(availablePalettesTable);
		AvailablePalettesCheckStateProvider availablePalettesCheckStateProvider = new AvailablePalettesCheckStateProvider();
		availablePalettesTableViewer.setCheckStateProvider(availablePalettesCheckStateProvider);
		availablePalettesTableViewer.setContentProvider(new PalettesTableContentProvider(availablePalettesTableViewer));
		providersLabelProvider = new PaletteLabelProvider(availablePalettesTableViewer);
		availablePalettesTableViewer.setLabelProvider(providersLabelProvider);
		availablePalettesTableViewer.setInput(PapyrusPaletteService.getInstance());

		return composite;
	}

	/**
	 * Launch the wizard for the palette creation
	 * 
	 * @param shell
	 *            the shell where to display the wizard
	 */
	protected void createNewLocalPalette() {
		NewLocalPaletteWizard wizard = new NewLocalPaletteWizard(getActiveSashPage());
		WizardDialog wizardDialog = new WizardDialog(new Shell(), wizard);
		wizardDialog.open();
	}

	/**
	 * Deletes the current selected local palette
	 */
	protected void deleteLocalPalette() {
		IStructuredSelection selection = (IStructuredSelection) availablePalettesTableViewer.getSelection();
		if (selection == null
				|| !(selection.getFirstElement() instanceof PapyrusPaletteService.LocalProviderDescriptor)) {
			MessageDialog.openError(getShell(), Messages.Dialog_Not_Local_Palette_Title,
					Messages.Dialog_Not_Local_Palette_Message);
		} else {
			PapyrusPaletteService.LocalProviderDescriptor descriptor = ((PapyrusPaletteService.LocalProviderDescriptor) selection
					.getFirstElement());
			String id = descriptor.getContributionID();
			PapyrusPalettePreferences.deleteLocalPalette(id);
		}
	}

	/**
	 * Changes the visibility of the given provider
	 * 
	 * @param descriptor
	 *            the provider to hide/show
	 * @param isChecked
	 *            <code>true</code> if the descriptor should be visible
	 */
	protected void changeProviderVisibility(PapyrusPaletteService.ProviderDescriptor descriptor, boolean isChecked) {
		PapyrusPalettePreferences.changePaletteVisibility(descriptor.getContributionID(), getActiveSashPage()
				.getClass().getName(), isChecked);
	}

	/**
	 * Creates the main composite for the dialog area
	 * 
	 * @param parent
	 *            the parent of the createrd composite
	 * @return the newly created Composite
	 */
	protected Composite createMainComposite(Composite parent) {
		// dialog window
		// create a composite with standard margins and spacing
		Composite composite = new Composite(parent, SWT.NONE);
		FormLayout layout = new FormLayout();
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		applyDialogFont(composite);
		return composite;
	}

	/**
	 * Content provider for available tools viewer
	 */
	public class PalettesTableContentProvider implements IStructuredContentProvider {

		/** the palette root */
		private PapyrusPaletteService paletteService;

		/** tree viewer to fill */
		private final TableViewer viewer;

		/**
		 * Constructor
		 * 
		 * @param tableViewer
		 *            The TableViewer whose ContentProvider this PaletteTreeProvider is
		 */
		public PalettesTableContentProvider(TableViewer tableViewer) {
			this.viewer = tableViewer;
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			paletteService = null;
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput != null) {
				paletteService = (PapyrusPaletteService) newInput;
			}
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if (inputElement instanceof PapyrusPaletteService) {
				List<PapyrusPaletteService.ProviderDescriptor> providers = ((PapyrusPaletteService) inputElement)
						.getContributingProviders(getActiveSashPage(), getPaletteRoot());

				return providers.toArray();
			}
			return null;
		}
	}

	/**
	 * Returns the current active sash page
	 * 
	 * @return the current active sash page
	 */
	protected IEditorPart getActiveSashPage() {
		// Lookup ServiceRegistry
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editorPart = page.getActiveEditor();
		assert editorPart != null;
		ISashWindowsContainer sashWindowsContainer = (ISashWindowsContainer) editorPart
				.getAdapter(ISashWindowsContainer.class);
		if (sashWindowsContainer != null) {
			return sashWindowsContainer.getActiveEditor();
		}
		return null;
	}

	/**
	 * provider in charge of the check boxes in the available palettes table viewer
	 */
	protected class AvailablePalettesCheckStateProvider implements ICheckStateProvider {

		/**
		 * {@inheritDoc}
		 */
		public boolean isChecked(Object element) {
			if (element instanceof PapyrusPaletteService.ProviderDescriptor) {
				return !PapyrusPalettePreferences.getHiddenPalettes(getActiveSashPage()).contains(
						((PapyrusPaletteService.ProviderDescriptor) element).getContributionID());
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isGrayed(Object element) {
			return false;
		}

	}

	/**
	 * Label provider for available tools viewer
	 */
	protected class PaletteLabelProvider implements ILabelProvider {

		/**
		 * Creates a new PaletteLabelProvider.
		 * 
		 * @param viewer
		 *            the table viewer where the labels are displayed
		 */
		public PaletteLabelProvider(TableViewer viewer) {
		}

		private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>();

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(Object)
		 */
		public Image getImage(Object element) {
			if (element instanceof PapyrusPaletteService.LocalProviderDescriptor) {
				return Activator.getImage(LOCAL_DESCRIPTOR);
			} else if (element instanceof PapyrusPaletteService.ProviderDescriptor) {
				return Activator.getImage(PLUGIN_DESCRIPTOR);
			}
			return Activator.getImage(Activator.DEFAULT_IMAGE);
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(Object)
		 */
		public String getText(Object element) {
			if (element instanceof PapyrusPaletteService.ProviderDescriptor) {
				return ((PapyrusPaletteService.ProviderDescriptor) element).getContributionName();
			}
			return "<undefined>";
		}

		/**
		 * Not implemented
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(ILabelProviderListener)
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			Iterator<Image> images = imageCache.values().iterator();
			while (images.hasNext()) {
				images.next().dispose();
			}
			imageCache = null;
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(Object, String)
		 */
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		/**
		 * Not implemented
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(ILabelProviderListener)
		 */
		public void removeListener(ILabelProviderListener listener) {
		}

		/**
		 * @see org.eclipse.jface.viewers.IColorProvider#getBackground(Object)
		 */
		// @unused
		public Color getBackground(Object element) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.IColorProvider#getForeground(Object)
		 */
		// @unused
		public Color getForeground(Object element) {
			PaletteEntry entry = (PaletteEntry) element;
			if (!entry.isVisible() || !entry.getParent().isVisible()) {
				return ColorConstants.gray;
			}
			return null;
		}

	}

}
