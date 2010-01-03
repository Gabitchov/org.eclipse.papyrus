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

import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.TableViewer;
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
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelper;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Element;

/**
 * The Class HyperLinkManagerShell is used to display a shell in order to mamange new hyperLinks
 * subdiagrams or attached documents the code was designed from Visual editor
 **/
public class HyperLinkManagerShell {

	/**
	 * The listener interface for receiving diagramCreate events. The class that is interested in
	 * processing a diagramCreate event implements this interface, and the object created with that
	 * class is registered with a component using the component's <code>addDiagramCreateListener<code> method. When
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
		private final Element container;

		/** The i creation command registry. */
		private final ICreationCommandRegistry iCreationCommandRegistry;

		/**
		 * {@inheritedDoc}
		 */
		@Override
		public void widgetSelected(SelectionEvent e) {
			try {
				ServicesRegistry servicesRegistry = EditorUtils.getServiceRegistry();
				DiResourceSet diResourceSet = servicesRegistry.getService(DiResourceSet.class);

				ICreationCommand creationCommand = iCreationCommandRegistry.getCommand(commandDescriptor.getCommandId());
				creationCommand.createDiagram(diResourceSet, container, null);
				diagramTableViewer.setInput(null);
				diagramTableViewer.setInput(element);
			} catch (NotFoundException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (BackboneException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (ServiceException ex) {
				// TODO Auto-generated catch block
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
		public DiagramCreateListener(CreationCommandDescriptor commandDescriptor, BackboneContext backboneContext,
				Element container, ICreationCommandRegistry iCreationCommandRegistry) {
			super();
			this.commandDescriptor = commandDescriptor;
			this.backboneContext = backboneContext;
			this.container = container;
			this.iCreationCommandRegistry = iCreationCommandRegistry;
		}
	}

	/**
	 * The Class DiagramLabelProvider.
	 */
	public class DiagramLabelProvider implements ILabelProvider {

		/**
		 * {@inheritedDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof Diagram) {
				return editorRegistry.getEditorIcon((element));
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public String getText(Object element) {
			if(element instanceof Diagram) {
				return ((Diagram)element).getName();
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * The Class HyperlinkLabelProvider.
	 */
	public class HyperlinkLabelProvider implements ILabelProvider {

		/**
		 * {@inheritedDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof String) {
				return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
						"/icons/obj16/hyperlink.gif").createImage();
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public String getText(Object element) {
			if(element instanceof String) {
				return ((String)element);
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * The Class DocumentLabelProvider.
	 */
	public class DocumentLabelProvider implements ILabelProvider {

		/**
		 * {@inheritedDoc}
		 */
		public Image getImage(Object element) {
			if(element instanceof String) {
				return AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common",
						"/icons/obj16/file.gif").createImage();
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public String getText(Object element) {
			if(element instanceof String) {
				return ((String)element);
			}
			return null;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void addListener(ILabelProviderListener listener) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public boolean isLabelProperty(Object element, String property) {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		 * {@inheritedDoc}
		 */
		public void removeListener(ILabelProviderListener listener) {
			// TODO Auto-generated method stub

		}

	}

	/**
	 * The Class DiagramContentProvider.
	 */
	public class DiagramContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(element != null) {
				return getSubDiagrams().toArray();
			}
			return null;
		}

	}

	/**
	 * The Class DocumentContentProvider.
	 */
	public class DocumentContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement != null) {
				// return
				// HyperlinkHelper.getAllreferencedDocument((EModelElement)
				// inputElement).toArray();
			}
			return null;
		}

	}

	/**
	 * The Class HyperLinkContentProvider.
	 */
	public class HyperLinkContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritedDoc}
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * {@inheritedDoc}
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement != null) {
				// return HyperlinkHelper.getAllHyperLink((EModelElement)
				// inputElement).toArray();
			}
			return null;
		}

	}

	/** The diagram menu button. */
	private Menu diagramMenuButton;

	/** The element. */
	private final Element element;

	/** The view. */
	private final View view;

	/** The domain. */
	private final TransactionalEditingDomain domain;

	/**
	 * Instantiates a new hyper link manager shell.
	 * 
	 * @param umlElement
	 *        the uml element
	 * @param view
	 *        the view
	 * @param editorFactoryRegistry
	 *        the editor factory registry
	 * @param domain
	 *        the domain
	 */
	// @unused
	public HyperLinkManagerShell(Element umlElement, View view, IEditorFactoryRegistry editorFactoryRegistry,
			TransactionalEditingDomain domain) {
		this.editorRegistry = editorFactoryRegistry;
		this.element = umlElement;
		this.view = view;
		this.domain = domain;
	}

	/** The editor registry. */
	private final IEditorFactoryRegistry editorRegistry;

	/** The s shell. */
	private Shell sShell = null; // @jve:decl-index=0:visual-constraint="-341,38"

	/** The c tab folder. */
	private CTabFolder cTabFolder = null;

	/** The hyperlink composite. */
	private Composite hyperlinkComposite = null;

	/** The textfield1. */
	private Text textfield1 = null;

	/** The text label. */
	private Label textLabel = null;

	/** The hyperlink remove button. */
	private Button hyperlinkRemoveButton = null;

	/** The hyperlinkcreate button. */
	private Button hyperlinkcreateButton = null;

	/** The document composite. */
	private Composite documentComposite = null;

	/** The document create button. */
	private Button documentCreateButton = null;

	/** The document remove button. */
	private Button documentRemoveButton = null;

	/** The diagram composite. */
	private Composite diagramComposite = null;

	/** The diagram add button. */
	private Button diagramAddButton = null;

	/** The diagram remove button. */
	private Button diagramRemoveButton = null;

	/** The diagram listlabel. */
	private Label diagramListlabel = null;

	/** The dicument list label. */
	private Label dicumentListLabel = null;

	/** The hyper link list label. */
	private Label hyperLinkListLabel = null;

	/** The list viewer. */
	// @unused
	private final ListViewer listViewer = null;

	/** The hyper link table. */
	private Table hyperLinkTable = null;

	/** The document table. */
	private Table documentTable = null;

	/** The diagram table. */
	private Table diagramTable = null;

	/** The diagram table viewer. */
	private TableViewer diagramTableViewer;

	/** The document table viewer. */
	private TableViewer documentTableViewer;

	/** The hyper link table viewer. */
	private TableViewer hyperLinkTableViewer;

	/**
	 * This method initializes sShell.
	 */
	// @unused
	public void createShell() {
		sShell = new Shell(PlatformUI.getWorkbench().getDisplay().getActiveShell());
		sShell.setText("Shell");
		sShell.setLayout(new FillLayout());
		sShell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		createCTabFolder();
		sShell.setSize(new Point(561, 206));
		sShell.open();
		sShell.setActive();
		sShell.setFocus();

	}

	/**
	 * Gets the s shell.
	 * 
	 * @return the s shell
	 */
	// @unused
	public Shell getsShell() {
		return sShell;
	}

	/**
	 * This method initializes cTabFolder.
	 */
	private void createCTabFolder() {
		cTabFolder = new CTabFolder(sShell, SWT.BORDER);
		cTabFolder.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		createHyperlinkComposite();
		createDocumentComposite();
		createDiagramComposite();
		CTabItem HyperlinkTabItem = new CTabItem(cTabFolder, SWT.NONE);
		HyperlinkTabItem.setControl(hyperlinkComposite);
		HyperlinkTabItem.setText("Hyperlink");

		CTabItem cTabItem = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem.setControl(documentComposite);
		cTabItem.setText("Document");
		CTabItem cTabItem1 = new CTabItem(cTabFolder, SWT.NONE);
		cTabItem1.setControl(diagramComposite);
		cTabItem1.setText("Diagram");
	}

	/**
	 * This method initializes hyperlinkComposite.
	 */
	private void createHyperlinkComposite() {
		GridData gridData16 = new GridData();
		gridData16.horizontalAlignment = GridData.FILL;
		gridData16.horizontalSpan = 2;
		gridData16.heightHint = 60;
		gridData16.verticalAlignment = GridData.FILL;
		GridData gridData15 = new GridData();
		gridData15.widthHint = 50;
		GridData gridData14 = new GridData();
		gridData14.widthHint = 50;
		gridData14.verticalAlignment = GridData.BEGINNING;
		gridData14.horizontalAlignment = GridData.CENTER;
		GridLayout gridLayout11 = new GridLayout();
		gridLayout11.numColumns = 4;
		GridData gridData2 = new GridData();
		gridData2.widthHint = 300;
		gridData2.grabExcessVerticalSpace = false;
		gridData2.horizontalAlignment = GridData.FILL;
		gridData2.verticalAlignment = GridData.CENTER;
		gridData2.grabExcessHorizontalSpace = true;
		GridData gridData = new GridData();
		gridData.horizontalSpan = 11;
		gridData.horizontalAlignment = GridData.CENTER;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.widthHint = 300;
		hyperlinkComposite = new Composite(cTabFolder, SWT.NONE);
		hyperlinkComposite.setLayout(gridLayout11);
		hyperlinkComposite.setBounds(new Rectangle(3, 20, 520, 162));
		hyperlinkComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		textLabel = new Label(hyperlinkComposite, SWT.NONE);
		textLabel.setText("HyperLink:");
		textLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		textfield1 = new Text(hyperlinkComposite, SWT.BORDER);
		textfield1.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
		textfield1.setLayoutData(gridData2);

		hyperlinkcreateButton = new Button(hyperlinkComposite, SWT.NONE);
		hyperlinkcreateButton.setText("Add");
		hyperlinkcreateButton.setLayoutData(gridData15);
		Label filler2 = new Label(hyperlinkComposite, SWT.NONE);
		hyperlinkcreateButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				if(textfield1.getText() != null && !textfield1.getText().trim().equals("")) {
					System.out.println("widgetSelected() '" + textfield1.getText().trim() + "'"); // TODO
					// Auto-generated
					// Event
					// stub
					// widgetSelected()
					// domain.getCommandStack().execute(
					// HyperlinkHelper.getAddHyperLinkDocumentCommand(domain,
					// view, textfield1.getText().trim()));
					hyperLinkTableViewer.setInput(null);
					hyperLinkTableViewer.setInput(view);
					textfield1.setText("");
				}
			}
		});
		hyperLinkListLabel = new Label(hyperlinkComposite, SWT.NONE);
		hyperLinkListLabel.setText("HyperLink List:");
		hyperLinkListLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		Label filler5 = new Label(hyperlinkComposite, SWT.NONE);
		Label filler13 = new Label(hyperlinkComposite, SWT.NONE);
		Label filler1 = new Label(hyperlinkComposite, SWT.NONE);

		hyperLinkTable = new Table(hyperlinkComposite, SWT.BORDER | SWT.MULTI);
		hyperLinkTable.setHeaderVisible(false);
		hyperLinkTable.setLayoutData(gridData16);
		hyperLinkTable.setLinesVisible(false);
		hyperLinkTableViewer = new TableViewer(hyperLinkTable);
		hyperLinkTableViewer.setContentProvider(new HyperLinkContentProvider());
		hyperLinkTableViewer.setLabelProvider(new HyperlinkLabelProvider());
		hyperLinkTableViewer.setInput(view);
		hyperlinkRemoveButton = new Button(hyperlinkComposite, SWT.NONE);
		hyperlinkRemoveButton.setText("Remove");
		hyperlinkRemoveButton.setLayoutData(gridData14);
		hyperlinkRemoveButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				IStructuredSelection iSelection = (IStructuredSelection)hyperLinkTableViewer.getSelection();
				Iterator iterator = iSelection.iterator();
				while(iterator.hasNext()) {
					domain.getCommandStack().execute(
							HyperlinkHelper.getRemoveHyperlinkCommand(domain, view, "" + iterator.next()));
				}
				hyperLinkTableViewer.setInput(null);
				hyperLinkTableViewer.setInput(view);
			}
		});
	}

	/**
	 * This method initializes documentComposite.
	 */
	private void createDocumentComposite() {
		GridData gridData1 = new GridData();
		gridData1.verticalSpan = 2;
		gridData1.verticalAlignment = GridData.FILL;
		gridData1.widthHint = 400;
		gridData1.heightHint = 100;
		gridData1.horizontalAlignment = GridData.FILL;
		GridData gridData8 = new GridData();
		gridData8.widthHint = 100;
		GridData gridData7 = new GridData();
		gridData7.widthHint = 100;
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.numColumns = 2;
		documentComposite = new Composite(cTabFolder, SWT.NONE);
		documentComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		documentComposite.setBounds(new Rectangle(3, 20, 520, 162));
		documentComposite.setLayout(gridLayout1);
		dicumentListLabel = new Label(documentComposite, SWT.NONE);
		dicumentListLabel.setText("Document List:");
		dicumentListLabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		Label filler10 = new Label(documentComposite, SWT.NONE);
		documentTable = new Table(documentComposite, SWT.BORDER | SWT.MULTI);
		documentTable.setHeaderVisible(false);
		documentTable.setLayoutData(gridData1);
		documentTable.setLinesVisible(false);
		documentTableViewer = new TableViewer(documentTable);
		documentTableViewer.setContentProvider(new DocumentContentProvider());
		documentTableViewer.setLabelProvider(new DocumentLabelProvider());
		documentTableViewer.setInput(view);
		documentCreateButton = new Button(documentComposite, SWT.NONE);
		documentCreateButton.setText("Add Document");
		documentCreateButton.setLayoutData(gridData8);
		documentCreateButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				FileDialog fd = new FileDialog(sShell, SWT.OPEN);
				fd.setText("Open");
				String[] filterExt = { "*.txt", "*.doc", "*.pdf", "*.*" };
				fd.setFilterExtensions(filterExt);
				String selected = fd.open();
				System.out.println(selected);
				// domain.getCommandStack().execute(HyperlinkHelper.getAddHyperLinkWebCommand(domain,
				// view, selected.trim()));
				documentTableViewer.setInput(null);
				documentTableViewer.setInput(view);

			}

		});
		documentRemoveButton = new Button(documentComposite, SWT.NONE);
		documentRemoveButton.setText("Remove");
		documentRemoveButton.setLayoutData(gridData7);
		documentRemoveButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				IStructuredSelection iSelection = (IStructuredSelection)documentTableViewer.getSelection();
				Iterator iterator = iSelection.iterator();
				while(iterator.hasNext()) {
					domain.getCommandStack().execute(
							HyperlinkHelper.getRemoveHyperlinkCommand(domain, view, "" + iterator.next()));
				}
				documentTableViewer.setInput(null);
				documentTableViewer.setInput(view);
			}
		});
	}

	/**
	 * This method initializes diagramComposite.
	 */
	private void createDiagramComposite() {
		GridData gridData3 = new GridData();
		gridData3.verticalSpan = 2;
		gridData3.horizontalAlignment = GridData.FILL;
		gridData3.verticalAlignment = GridData.FILL;
		gridData3.widthHint = 380;
		gridData3.heightHint = 100;
		GridData gridData12 = new GridData();
		gridData12.widthHint = 120;
		GridData gridData11 = new GridData();
		gridData11.widthHint = 120;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		diagramComposite = new Composite(cTabFolder, SWT.NONE);
		diagramComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		diagramComposite.setLayout(gridLayout2);
		diagramListlabel = new Label(diagramComposite, SWT.SHADOW_OUT);
		diagramListlabel.setText("Diagram List:");
		diagramListlabel.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		Label filler9 = new Label(diagramComposite, SWT.NONE);
		diagramTable = new Table(diagramComposite, SWT.MULTI | SWT.BORDER);
		diagramTable.setHeaderVisible(false);
		diagramTable.setLayoutData(gridData3);
		diagramTable.setLinesVisible(false);
		diagramTableViewer = new TableViewer(diagramTable);
		diagramTableViewer.setContentProvider(new DiagramContentProvider());
		diagramTableViewer.setLabelProvider(new DiagramLabelProvider());
		diagramTableViewer.setInput(element);
		diagramAddButton = new Button(diagramComposite, SWT.PUSH);
		diagramAddButton.setText("Add a new Diagram");
		diagramAddButton.setLayoutData(gridData11);
		diagramMenuButton = new Menu(diagramAddButton);
		diagramAddButton.setMenu(diagramMenuButton);
		CreationCommandRegistry commandRegistry = new CreationCommandRegistry(
				org.eclipse.papyrus.core.Activator.PLUGIN_ID);
		for(CreationCommandDescriptor desc : commandRegistry.getCommandDescriptors()) {
			MenuItem menuItem = new MenuItem(diagramMenuButton, SWT.PUSH);
			menuItem.addSelectionListener(new DiagramCreateListener(desc, null, element, commandRegistry));
			menuItem.setText(desc.getLabel());
		}
		diagramAddButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				diagramMenuButton.setVisible(true);
			}
		});
		diagramRemoveButton = new Button(diagramComposite, SWT.NONE);
		diagramRemoveButton.setText("remove");
		diagramRemoveButton.setLayoutData(gridData12);
		diagramRemoveButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {

			@Override
			public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
				IStructuredSelection iSelection = (IStructuredSelection)diagramTableViewer.getSelection();
				Iterator iterator = iSelection.iterator();
				while(iterator.hasNext()) {
					IPageMngr pageMngr = EditorUtils.getIPageMngr();
					pageMngr.removePage(iterator.next());
				}
				diagramTableViewer.setInput(null);
				diagramTableViewer.setInput(view);
			}
		});
	}

	/**
	 * Gets the sub diagrams.
	 * 
	 * @return the sub diagrams
	 */
	protected ArrayList<Diagram> getSubDiagrams() {
		ArrayList<Diagram> result = new ArrayList<Diagram>();
		if(element != null) {
			try {
				IPageMngr iPageMngr = EditorUtils.getIPageMngr();
				Iterator<Object> iterator = iPageMngr.allPages().iterator();
				while(iterator.hasNext()) {
					Object current = iterator.next();
					if(current instanceof Diagram) {
						Element diagElement = (Element)((Diagram)current).getElement();
						if(element.equals(diagElement) || element.allOwnedElements().contains(diagElement)) {
							result.add((Diagram)current);
						}
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}

		}
		return result;
	}

}
