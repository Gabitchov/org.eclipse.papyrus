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
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gef.ui.palette.PaletteCustomizer;
import org.eclipse.gmf.runtime.gef.ui.palette.customize.PaletteCustomizerDialogEx;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;

/**
 * specific dialog window for the customisation of the palette
 */
public class PapyrusPaletteCustomizerDialog extends PaletteCustomizerDialogEx {

	/** left arrow image */
	protected static final String LEFT_ARROW = "icons/ArrowLeft.gif";

	/** right arrow image */
	protected static final String RIGHT_ARROW = "icons/ArrowRight.gif";

	/** viewer for the available tools */
	protected TreeViewer availableToolsTreeViewer;

	/** tree viewed by the availableToolsTreeViewer */
	protected Tree availableToolsTree;

	/** Add tool button */
	protected Button addButton;

	/** Remove tool button */
	protected Button removeButton;

	private PaletteLabelProvider toolsTreeLabelProvider;

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
		// RS: does not call super, as the composite should not be drawn like they are in parent
		Composite mainComposite = createMainComposite(parent);

		final Control availableToolsComposite = createAvailableToolsViewer(mainComposite);
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		// data.right = new FormAttachment(40, 0);
		availableToolsComposite.setLayoutData(data);

		final Control displayButtons = createDisplayButtons(mainComposite);
		data = new FormData();
		data.left = new FormAttachment(availableToolsComposite, 0);
		// data.width = 30;
		data.top = new FormAttachment(40, 0);
		data.bottom = new FormAttachment(100, 0);
		displayButtons.setLayoutData(data);

		// Create the tree
		Control outline = createOutline(mainComposite);
		data = new FormData();
		data.left = new FormAttachment(displayButtons, 0);
		data.top = new FormAttachment(0, 0);
		data.bottom = new FormAttachment(100, 0);
		// data.right = new FormAttachment(90, 0);
		outline.setLayoutData(data);

		// Create the panel where the properties of the selected palette entry will
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

	protected Control createDisplayButtons(Composite container) {
		// Create the Composite that will contain the available tools
		Composite composite = new Composite(container, SWT.NONE);
		composite.setFont(container.getFont());
		GridLayout layout = new GridLayout(1, false);
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		addButton = new Button(composite, SWT.NONE);
		addButton.setText("");
		addButton.setToolTipText(Messages.PapyrusPaletteCustomizerDialog_AddButtonTooltip);
		addButton.setImage(Activator.getPluginIconImage(Activator.ID, RIGHT_ARROW));
		GridData data = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		addButton.setLayoutData(data);
		addButton.addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
				addEntry(e);

			}

			public void mouseDown(MouseEvent e) {
				// on mouse down, do nothing
			}

			public void mouseDoubleClick(MouseEvent e) {
				// on double click, do nothing
			}
		});

		removeButton = new Button(composite, SWT.NONE);
		removeButton.setToolTipText(Messages.PapyrusPaletteCustomizerDialog_RemoveButtonTooltip);
		removeButton.setImage(Activator.getImage(LEFT_ARROW));
		removeButton.setLayoutData(data);

		return composite;
	}

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
		// sets the active entry, to have the page useful for saving modification
		setActiveEntry(entry);
		// add entry to the selected container
		// retrieve the selection in the palette viewer
		PaletteEntry destContainer = getSelectedPaletteEntry();
		((PapyrusPaletteCustomizer) getCustomizer()).storePaletteState(entry);
		if (destContainer instanceof PaletteContainer) {
			PaletteContainer oldParent = entry.getParent();

			// checks if the parent is already changed. If not, must store the standard parent (the
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

		// try {
		// Method[] methods = Papyr.class.getDeclaredMethods();
		// Method method = null;
		// for (Method m : methods) {
		// if ("storePaletteState".equals(m.getName())) {
		// method = m;
		// break;
		// }
		// }
		// if (method == null) {
		// throw new NoSuchMethodException("storePaletteState(PaleeteEntry) not found !!!");
		// }
		// method.setAccessible(true);
		// method.invoke(getCustomizer(), entry);
		// } catch (SecurityException e1) {
		// e1.printStackTrace();
		// } catch (NoSuchMethodException e1) {
		// e1.printStackTrace();
		// } catch (IllegalArgumentException e1) {
		// e1.printStackTrace();
		// } catch (IllegalAccessException e1) {
		// e1.printStackTrace();
		// } catch (InvocationTargetException e1) {
		// e1.printStackTrace();
		// }
	}

	/**
	 * Creates the available tools viewer part of the dialog.
	 * 
	 * @param container
	 *            The Composite within which the viewer has to be created
	 * @return The newly created Control that has the viewer
	 */
	protected Control createAvailableToolsViewer(Composite container) {

		// Create the Composite that will contain the available tools
		Composite composite = new Composite(container, SWT.NONE);
		composite.setFont(container.getFont());
		GridLayout layout = new GridLayout();
		layout.horizontalSpacing = 0;
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);

		Tree availableToolsTree = new Tree(composite, SWT.BORDER);
		availableToolsTree.setFont(composite.getFont());
		GridData data = new GridData(GridData.FILL_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL);
		data.widthHint = 185;
		// Make the tree this tall even when there is nothing in it. This will keep the
		// dialog from shrinking to an unusually small size.
		data.heightHint = 200;
		availableToolsTree.setLayoutData(data);
		availableToolsTreeViewer = new TreeViewer(availableToolsTree) {

			protected void preservingSelection(Runnable updateCode) {
				if ((getTree().getStyle() & SWT.SINGLE) != 0)
					updateCode.run();
				else
					super.preservingSelection(updateCode);
			}
		};
		availableToolsTreeViewer.setContentProvider(new ToolsTreeContentProvider(availableToolsTreeViewer));
		toolsTreeLabelProvider = new PaletteLabelProvider(availableToolsTreeViewer);
		availableToolsTreeViewer.setLabelProvider(toolsTreeLabelProvider);
		availableToolsTreeViewer.setInput(getPaletteRoot());
		availableToolsTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				handleOutlineSelectionChanged();
			}
		});

		return composite;
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
	public class ToolsTreeContentProvider implements ITreeContentProvider {

		private PaletteRoot root;

		private TreeViewer viewer;

		/**
		 * Constructor
		 * 
		 * @param treeviewer
		 *            The TreeViewer whose ContentProvider this PaletteTreeProvider is
		 */
		public ToolsTreeContentProvider(TreeViewer treeviewer) {
			this.viewer = treeviewer;
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
		public boolean hasChildren(Object element) {
			return getChildren(element) != null;
		}

		/**
		 * This method should not return <code>null</code>.
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(Object)
		 */
		public Object[] getElements(Object inputElement) {
			Object[] elements = getChildren(inputElement);
			if (elements == null) {
				elements = new Object[0];
			}
			return elements;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(Object)
		 */
		public Object getParent(Object element) {
			return ((PaletteEntry) element).getParent();
		}

		/**
		 * {@inheritDoc}
		 */
		public void dispose() {
			root = null;
		}

		/**
		 * {@inheritDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput != null) {
				root = (PaletteRoot) newInput;
			}
		}

	}

	/**
	 * Label provider for available tools viewer
	 */
	class PaletteLabelProvider implements ILabelProvider {

		public PaletteLabelProvider(TreeViewer viewer) {
		}

		private Map<ImageDescriptor, Image> imageCache = new HashMap<ImageDescriptor, Image>();

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(Object)
		 */
		public Image getImage(Object element) {
			PaletteEntry entry = (PaletteEntry) element;
			ImageDescriptor descriptor = entry.getSmallIcon();
			return getCachedImage(descriptor);
		}

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(Object)
		 */
		public String getText(Object element) {
			return ((PaletteEntry) element).getLabel();
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
			while (images.hasNext())
				images.next().dispose();
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
		public Color getBackground(Object element) {
			return null;
		}

		private Image getCachedImage(ImageDescriptor descriptor) {
			Image image = (Image) imageCache.get(descriptor);
			if (image == null) {
				image = descriptor.createImage();
				imageCache.put(descriptor, image);
			}
			return image;
		}

		/**
		 * @see org.eclipse.jface.viewers.IColorProvider#getForeground(Object)
		 */
		public Color getForeground(Object element) {
			PaletteEntry entry = (PaletteEntry) element;
			if (!entry.isVisible() || !entry.getParent().isVisible()) {
				return ColorConstants.gray;
			}
			return null;
		}

	}

}
