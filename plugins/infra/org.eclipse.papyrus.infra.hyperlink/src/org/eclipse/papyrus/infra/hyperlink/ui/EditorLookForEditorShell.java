/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.util.Iterator;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.infra.core.editor.BackboneException;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.core.extension.NotFoundException;
import org.eclipse.papyrus.infra.core.extension.commands.CreationCommandDescriptor;
import org.eclipse.papyrus.infra.core.extension.commands.CreationCommandRegistry;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommand;
import org.eclipse.papyrus.infra.core.extension.commands.ICreationCommandRegistry;
import org.eclipse.papyrus.infra.core.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.infra.core.utils.EditorUtils;
import org.eclipse.papyrus.infra.emf.providers.MoDiscoContentProvider;
import org.eclipse.papyrus.infra.hyperlink.util.EditorListContentProvider;
import org.eclipse.papyrus.views.modelexplorer.MoDiscoLabelProviderWTooltips;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;



public class EditorLookForEditorShell extends AbstractLookForDiagramShell {

	/** The adapter factory. */
	protected AdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

	/** The selected diagram. */
	protected Object selectedEditor;

	/**
	 * Gets the selected editor.
	 * 
	 * @return the selectedEditor
	 */
	protected Object getSelectedEditor() {
		return selectedEditor;
	}

	/**
	 * Sets the selected editor
	 * 
	 * @param selectedEditor
	 *        the selectedEditor to set
	 */
	protected void setSelectedEditor(Object selectedEditor) {
		this.selectedEditor = selectedEditor;
	}

	/** The model. */
	protected EObject model;

	/** The diagram menu button. */
	protected Menu diagramMenuButton;

	/** The diagram list tree viewer. */
	protected TreeViewer diagramListTreeViewer;

	/** The tree viewer. */
	protected TreeViewer treeViewer;

	/**
	 * The listener interface for receiving diagramCreate events. The class that
	 * is interested in processing a diagramCreate event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's <code>addDiagramCreateListener<code> method. When
	 * the diagramCreate event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see DiagramCreateEvent
	 */
	public class DiagramCreateListener extends SelectionAdapter {

		/** The command descriptor. */
		private final CreationCommandDescriptor commandDescriptor;

		/** The container. */
		private EObject container;

		/** The i creation command registry. */
		private final ICreationCommandRegistry iCreationCommandRegistry;

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param e
		 *        the e
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			try {
				EObject elt = (EObject)((IStructuredSelection)treeViewer.getSelection()).getFirstElement();

				setContainer(elt);
				ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
				DiResourceSet diResourceSet = servicesRegistry.getService(DiResourceSet.class);

				ICreationCommand creationCommand = iCreationCommandRegistry.getCommand(commandDescriptor.getCommandId());
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
		 *        the command descriptor
		 * @param backboneContext
		 *        the backbone context
		 * @param container
		 *        the container
		 * @param iCreationCommandRegistry
		 *        the i creation command registry
		 */
		public DiagramCreateListener(CreationCommandDescriptor commandDescriptor, EObject container, ICreationCommandRegistry iCreationCommandRegistry) {
			super();
			this.commandDescriptor = commandDescriptor;
			this.container = container;
			this.iCreationCommandRegistry = iCreationCommandRegistry;
		}

		/**
		 * Sets the container.
		 * 
		 * @param container
		 *        the new container
		 */
		public void setContainer(EObject container) {
			this.container = container;
		}
	}




	/**
	 * Instantiates a new editor look for diagram.
	 * 
	 * @param editorFactoryRegistry
	 *        the editor factory registry
	 * @param amodel
	 *        the amodel
	 */
	public EditorLookForEditorShell(IPageIconsRegistry editorFactoryRegistry, EObject amodel) {
		super();
		this.model = amodel;
		// create the shell
		createLookforShell();

		// intall tree with uml element
		treeViewer = getModeFilteredTree().getViewer();
		treeViewer.setUseHashlookup(true);
		//		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory) {
		//
		//			@Override
		//			public Image getImage(Object object) {
		//				//TODO
		////				if(object instanceof PapyrusTableInstance) {
		////					return editorRegistry.getEditorIcon((object));
		////				} else {
		////					return super.getImage(object);
		////				}
		//				Image im = super.getImage(object);
		//				return im;
		////				return null;
		//			}
		//		});
		treeViewer.setLabelProvider(new MoDiscoLabelProviderWTooltips());
		//treeViewer.setContentProvider(new CustomAdapterFactoryContentProvider(adapterFactory));
		treeViewer.setContentProvider(new MoDiscoContentProvider());
		//		treeViewer.setContentProvider(new CustomizableModelContentProvider());
		//treeViewer.setInput(model.eResource());
		treeViewer.setInput(EditorUtils.getServiceRegistry());

		// install diagramlist
		diagramListTreeViewer = getDiagramfilteredTree().getViewer();
		diagramListTreeViewer.setUseHashlookup(true);

		// fill list of diagram
		//TODO
		//diagramListTreeViewer.setLabelProvider(new ObjectLabelProvider(null));
		diagramListTreeViewer.setLabelProvider(new MoDiscoLabelProviderWTooltips());//TODO remove the dependency on the property view
		diagramListTreeViewer.setContentProvider(new EditorListContentProvider());
		diagramListTreeViewer.setInput(" ");

		// add listner on the new button to display menu for each diagram
		diagramMenuButton = new Menu(getNewDiagrambutton());
		getNewDiagrambutton().setMenu(diagramMenuButton);
		CreationCommandRegistry commandRegistry = CreationCommandRegistry.getInstance(org.eclipse.papyrus.infra.core.Activator.PLUGIN_ID);
		for(CreationCommandDescriptor desc : commandRegistry.getCommandDescriptors()) {
			MenuItem menuItem = new MenuItem(diagramMenuButton, SWT.PUSH);
			menuItem.addSelectionListener(new DiagramCreateListener(desc, null, commandRegistry));
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
				IStructuredSelection iSelection = (IStructuredSelection)getModeFilteredTree().getViewer().getSelection();
				Iterator iterator = iSelection.iterator();
				while(iterator.hasNext()) {
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
				Object selection = ((IStructuredSelection)getModeFilteredTree().getViewer().getSelection()).getFirstElement();
				//TODO
				selectedEditor = selection;
				//				if(selection instanceof PapyrusTableInstance) {
				//					selectedEditor = (PapyrusTableInstance)selection;
				//				}

			}
		});

		// add listener to keep in mind the selected diagram in the list for the
		// view of digram list
		getDiagramfilteredTree().getViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection)getDiagramfilteredTree().getViewer().getSelection()).getFirstElement();
				//TODO
				selectedEditor = selection;
				//				if(selection instanceof PapyrusTableInstance) {
				//					selectedEditor = (PapyrusTableInstance)selection;
				//				}

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
				setSelectedEditor(null);
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
		while(!getLookforShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
