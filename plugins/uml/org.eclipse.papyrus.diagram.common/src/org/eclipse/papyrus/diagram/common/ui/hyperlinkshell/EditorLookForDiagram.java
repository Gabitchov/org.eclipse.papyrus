/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.core.editor.BackboneContext;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.extension.NotFoundException;
import org.eclipse.papyrus.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.core.extension.diagrameditor.IEditorFactoryRegistry;
import org.eclipse.papyrus.core.extension.editorcontext.IEditorContextRegistry;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * The Class EditorLookForDiagram.
 */
public class EditorLookForDiagram extends AbstractLookForDiagramShell {

	/** The editor registry. */
	private final IEditorFactoryRegistry editorRegistry;

	/** The SEP. */
	// @unused
	private final String SEP = " - ";

	/** The adapter factory. */
	protected AdapterFactory adapterFactory = new ComposedAdapterFactory(
			ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** The selected diagram. */
	protected Diagram selectedDiagram;

	/**
	 * Gets the selected diagram.
	 * 
	 * @return the selectedDiagram
	 */
	protected Diagram getSelectedDiagram() {
		return selectedDiagram;
	}

	/**
	 * Sets the selected diagram.
	 * 
	 * @param selectedDiagram
	 *            the selectedDiagram to set
	 */
	protected void setSelectedDiagram(Diagram selectedDiagram) {
		this.selectedDiagram = selectedDiagram;
	}

	/** The model. */
	protected Package model;

	/** The diagram menu button. */
	protected Menu diagramMenuButton;

	/** The diagram list tree viewer. */
	protected TreeViewer diagramListTreeViewer;

	/** The tree viewer. */
	protected TreeViewer treeViewer;

	/**
	 * The listener interface for receiving diagramCreate events. The class that is interested in
	 * processing a diagramCreate event implements this interface, and the object created with that
	 * class is registered with a component using the component's
	 * <code>addDiagramCreateListener<code> method. When
	 * the diagramCreate event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see DiagramCreateEvent
	 */
	public class DiagramCreateListener extends SelectionAdapter {

		/** The command descriptor. */
		private final CreationCommandDescriptor commandDescriptor;

		/** The backbone context. */
		private final BackboneContext backboneContext;

		/** The container. */
		private Element container;

		/** The i creation command registry. */
		private final ICreationCommandRegistry iCreationCommandRegistry;

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param e
		 *            the e
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			try {
				Element elt = (Element) ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();

				setContainer(elt);
				ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
				IEditorContextRegistry contextRegistry = (IEditorContextRegistry) servicesRegistry
						.getService(IEditorContextRegistry.class);

				// Get the context by its ID
				BackboneContext editorContext = (BackboneContext) contextRegistry
						.getContext(BackboneContext.BACKBONE_CONTEXT_ID);
				ICreationCommand creationCommand = iCreationCommandRegistry
						.getCommand(commandDescriptor.getCommandId());
				DiResourceSet diResourceSet = editorContext.getResourceSet();
				creationCommand.createDiagram(diResourceSet, container, null);

				// refresh several filtered tree
				getDiagramfilteredTree().getViewer().setInput(null);
				getDiagramfilteredTree().getViewer().setInput("");
				getModeFilteredTree().getViewer().setInput(null);
				getModeFilteredTree().getViewer().setInput(model.eResource());
			} catch (NotFoundException ex) {
				ex.printStackTrace();
			} catch (BackboneException ex) {
				ex.printStackTrace();
			} catch (ServiceException ex) {
				ex.printStackTrace();
			}
		}

		/**
		 * Instantiates a new diagram create listener.
		 * 
		 * @param commandDescriptor
		 *            the command descriptor
		 * @param backboneContext
		 *            the backbone context
		 * @param container
		 *            the container
		 * @param iCreationCommandRegistry
		 *            the i creation command registry
		 */
		public DiagramCreateListener(CreationCommandDescriptor commandDescriptor, BackboneContext backboneContext,
				Element container, ICreationCommandRegistry iCreationCommandRegistry) {
			super();
			this.commandDescriptor = commandDescriptor;
			this.backboneContext = backboneContext;
			this.container = container;
			this.iCreationCommandRegistry = iCreationCommandRegistry;
		}

		/**
		 * Sets the container.
		 * 
		 * @param container
		 *            the new container
		 */
		public void setContainer(Element container) {
			this.container = container;
		}
	}

	/**
	 * The Class DocumentLabelProvider.
	 */
	public class ObjectLabelProvider implements ILabelProvider {

		/** The image path. */
		protected String theImagePath;

		/**
		 * Instantiates a new object label provider.
		 * 
		 * @param imagePath
		 *            the image path
		 */
		public ObjectLabelProvider(String imagePath) {
			theImagePath = imagePath;
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param element
		 *            the element
		 * 
		 * @return the image
		 */
		public Image getImage(Object element) {
			if (element instanceof Diagram) {
				return editorRegistry.getEditorIcon((element));
			}
			return null;
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param element
		 *            the element
		 * 
		 * @return the text
		 */
		public String getText(Object element) {
			String out = "";
			if (element instanceof Diagram) {
				out = ((Diagram) element).getName();
			} else {
				return element.toString();
			}
			return out;
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param listener
		 *            the listener
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritedDoc}.
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param element
		 *            the element
		 * @param property
		 *            the property
		 * 
		 * @return true, if checks if is label property
		 */
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param listener
		 *            the listener
		 */
		public void removeListener(ILabelProviderListener listener) {
		}

	}

	/**
	 * The Class DiagramContentProvider.
	 */
	public class DiagramListContentProvider implements ITreeContentProvider {

		/**
		 * {@inheritDoc}
		 */
		public Object[] getChildren(Object parentElement) {
			return null;
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
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		public Object[] getElements(Object inputElement) {
			try {
				IPageMngr iPageMngr = EditorUtils.getIPageMngr();
				Object[] result = iPageMngr.allPages().toArray();
				return result;
			} catch (Exception e) {
			}
			return null;
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
	 * Instantiates a new editor look for diagram.
	 * 
	 * @param editorFactoryRegistry
	 *            the editor factory registry
	 * @param amodel
	 *            the amodel
	 */
	public EditorLookForDiagram(IEditorFactoryRegistry editorFactoryRegistry, Package amodel) {
		super();
		this.editorRegistry = editorFactoryRegistry;
		this.model = amodel;
		// create the shell
		createLookforShell();

		// intall tree with uml element
		treeViewer = getModeFilteredTree().getViewer();
		treeViewer.setUseHashlookup(true);
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {

			@Override
			public Image getImage(Object object) {
				if (object instanceof Diagram) {
					return editorRegistry.getEditorIcon((object));
				} else {
					return super.getImage(object);
				}
			}
		});
		treeViewer.setContentProvider(new CustomAdapterFactoryContentProvider(adapterFactory));
		treeViewer.setInput(model.eResource());

		// install diagramlist
		diagramListTreeViewer = getDiagramfilteredTree().getViewer();
		diagramListTreeViewer.setUseHashlookup(true);

		// fill list of diagram
		diagramListTreeViewer.setLabelProvider(new ObjectLabelProvider(null));
		diagramListTreeViewer.setContentProvider(new DiagramListContentProvider());
		diagramListTreeViewer.setInput(" ");

		// add listner on the new button to display menu for each diagram
		diagramMenuButton = new Menu(getNewDiagrambutton());
		getNewDiagrambutton().setMenu(diagramMenuButton);
		CreationCommandRegistry commandRegistry = new CreationCommandRegistry(
				org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		for (CreationCommandDescriptor desc : commandRegistry.getCommandDescriptors()) {
			MenuItem menuItem = new MenuItem(diagramMenuButton, SWT.PUSH);
			menuItem.addSelectionListener(new DiagramCreateListener(desc, null, null, commandRegistry));
			menuItem.setText(desc.getLabel());
		}
		getNewDiagrambutton().addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				diagramMenuButton.setVisible(true);
			}
		});

		// add listener to remove diagram
		getRemoveDiagrambutton().addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				IStructuredSelection iSelection = (IStructuredSelection) getModeFilteredTree().getViewer()
						.getSelection();
				Iterator iterator = iSelection.iterator();
				while (iterator.hasNext()) {
					IPageMngr pageMngr = EditorUtils.getIPageMngr();
					pageMngr.removePage(iterator.next());
				}
				getDiagramfilteredTree().getViewer().setInput(null);
				getDiagramfilteredTree().getViewer().setInput("");
				getModeFilteredTree().getViewer().setInput(null);
				getModeFilteredTree().getViewer().setInput(model.eResource());
			}
		});

		// add listener to keep the selected diagram in the list for the model
		// view
		getModeFilteredTree().getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection) getModeFilteredTree().getViewer().getSelection())
						.getFirstElement();
				if (selection instanceof Diagram) {
					selectedDiagram = (Diagram) selection;
				}

			}
		});

		// add listener to keep in mind the selected diagram in the list for the
		// view of digram list
		getDiagramfilteredTree().getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection) getDiagramfilteredTree().getViewer().getSelection())
						.getFirstElement();
				if (selection instanceof Diagram) {
					selectedDiagram = (Diagram) selection;
				}

			}
		});

		// add listener for the button ok, keep the selected diagram
		getOKbutton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				getLookforShell().close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// add listener for the button cancel, remove the value of the selected
		// diagram
		getCancelbutton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				setSelectedDiagram(null);
				getLookforShell().close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

	}

	/**
	 * Open the shell
	 */
	public void open() {
		Display display = Display.getCurrent();
		getLookforShell().setSize(700, 500);

		// code use to wait for an action from the user
		getLookforShell().pack();
		getLookforShell().setBounds(500, 500, 500, 300);
		getLookforShell().open();
		while (!getLookforShell().isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
