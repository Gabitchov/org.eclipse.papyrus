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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.DiagramHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.DocumentHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelperFactory;
import org.eclipse.papyrus.diagram.common.helper.WebHyperLinkHelper;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * The Class HyperLinkManagerShell2.
 */
public class HyperLinkManagerShell extends AbstractHyperLinkManagerShell {

	

	/** The diagram list. */
	protected ArrayList<HyperLinkDiagram> diagramList = new ArrayList<HyperLinkDiagram>();

	/** The document list. */
	protected ArrayList<HyperlinkDocument> documentList = new ArrayList<HyperlinkDocument>();

	/** The hyperlink web list. */
	protected ArrayList<HyperLinkWeb> hyperlinkWebList = new ArrayList<HyperLinkWeb>();


	protected ArrayList<HyperlinkObject> allhypHyperlinkObjects=new ArrayList<HyperlinkObject>();

	/**
	 * Gets the diagram list.
	 * 
	 * @return the diagramList
	 */
	public ArrayList<HyperLinkDiagram> getDiagramList() {
		return diagramList;
	}


	public void sethyperLinkObjectList(ArrayList<HyperlinkObject> hyperLinkObjectList) {
		this.allhypHyperlinkObjects.clear();
		this.allhypHyperlinkObjects.addAll(hyperLinkObjectList);
		Iterator<HyperlinkObject> iter= hyperLinkObjectList.iterator();
		while(iter.hasNext()) {
			HyperlinkObject hyperlinkObject = (HyperlinkObject)iter.next();
			if(hyperlinkObject.getIsDefault()){
				
			}
			if(hyperlinkObject instanceof HyperLinkDiagram){
				this.diagramList.add((HyperLinkDiagram)hyperlinkObject);

			}
			if(hyperlinkObject instanceof HyperlinkDocument){
				this.documentList.add((HyperlinkDocument)hyperlinkObject);

			}
			if(hyperlinkObject instanceof HyperLinkWeb){
				this.hyperlinkWebList.add((HyperLinkWeb)hyperlinkObject);

			}

		}
		diagramlistTableViewer.setInput(getDiagramList());
		documentlistTableViewer.setInput(getDocumentList());
		hyperlinkWeblistTableViewer.setInput(getHyperlinkWebList());
	//	availableHyperLinkViewer.setInput(this.allhypHyperlinkObjects);
	}


	/**
	 * Gets the document list.
	 * 
	 * @return the documentList
	 */
	public ArrayList<HyperlinkDocument> getDocumentList() {
		return documentList;

	}

	/**
	 * Gets the hyperlink web list.
	 * 
	 * @return the hyperlinkWebList
	 */
	public ArrayList<HyperLinkWeb> getHyperlinkWebList() {
		return hyperlinkWebList;
	}



	/**
	 * The Class DiagramContentProvider.
	 */
	public class ObjectContentProvider implements IStructuredContentProvider {

		/**
		 * {@inheritedDoc}.
		 */
		public void dispose() {
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param viewer
		 *        the viewer
		 * @param oldInput
		 *        the old input
		 * @param newInput
		 *        the new input
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		/**
		 * {@inheritedDoc}.
		 * 
		 * @param inputElement
		 *        the input element
		 * 
		 * @return the elements
		 */
		public Object[] getElements(Object inputElement) {
			if(inputElement instanceof ArrayList<?>) {
				return ((ArrayList<?>)inputElement).toArray();
			}
			return null;
		}

	}

	

	/** The editor registry. */
	private IPageIconsRegistry editorRegistry;

	/** The SEP. */
	private final String SEP = " - ";

	/** The element. */
	private Element element;

	/** The view. */
	private View view;

	/** The diagramlist table viewer. */
	private TableViewer diagramlistTableViewer;

	/** The documentlist table viewer. */
	private TableViewer documentlistTableViewer;

	/** The hyperlink weblist table viewer. */
	private TableViewer hyperlinkWeblistTableViewer;

	/** The content provider. */
	protected ObjectContentProvider contentProvider;

	/** The amodel. */
	private Package amodel;

	/** The domain. */
	private TransactionalEditingDomain transactionalEditingDomain;

//	protected TableViewer availableHyperLinkViewer;

	//protected TableViewer defaultHyperLinkViewer;

	/**
	 * Instantiates a new hyper link manager shell2.
	 * 
	 * @param editorFactoryRegistry
	 *        the editor factory registry
	 * @param model
	 *        the model that contains all elements
	 * @param domain
	 *        the domain inorder to execute command
	 * @param umlElement
	 *        the uml element linked to the view
	 * @param aview
	 *        the aview of the uml element
	 */
	public HyperLinkManagerShell(IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, Element umlElement, View aview, Package model) {
		super();
		this.element = umlElement;
		this.view = aview;
		this.amodel = model;
		this.transactionalEditingDomain = domain;
		this.editorRegistry = editorFactoryRegistry;
		this.diagramList = new ArrayList<HyperLinkDiagram>();
		this.hyperlinkWebList = new ArrayList<HyperLinkWeb>();
		this.documentList = new ArrayList<HyperlinkDocument>();
		contentProvider = new ObjectContentProvider();
		createHyperLinkShell();
		// associate tableViewer for each table

		diagramlistTableViewer = new TableViewer(this.getDiagramListtable());
		diagramlistTableViewer.setLabelProvider(new HyperLinkLabelProvider(editorFactoryRegistry));
		diagramlistTableViewer.setContentProvider(contentProvider);
		diagramlistTableViewer.setInput(getDiagramList());

		initializeLocalHyperLinkFolder();
		initializeHyperlinkWebFolder();
		initializeDocumentFolder();
		initializeDiagramFolder();
		initializeDefaultHyperLinkFolder();

		// listener for the button cancel
		getCancelButton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				diagramList = null;
				documentList = null;
				hyperlinkWebList = null;
				getHyperLinkShell().close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			};
		});

		// listener for the button OK
		getOkButton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				
				// empaty all hyperlinks
				transactionalEditingDomain.getCommandStack().execute(HyperlinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));
				allhypHyperlinkObjects.clear();
				allhypHyperlinkObjects.addAll(diagramList);
				allhypHyperlinkObjects.addAll(documentList);
				allhypHyperlinkObjects.addAll(hyperlinkWebList);
				
				// save hyperlink Document list
				ArrayList<AbstractHyperLinkHelper>  hyperLinkHelpers= new ArrayList<AbstractHyperLinkHelper>();
				hyperLinkHelpers.add(new DiagramHyperLinkHelper());
				hyperLinkHelpers.add(new DocumentHyperLinkHelper());
				hyperLinkHelpers.add(new WebHyperLinkHelper());
				HyperlinkHelperFactory hyperlinkHelperFactory= new HyperlinkHelperFactory(hyperLinkHelpers);
				try {
					transactionalEditingDomain.getCommandStack().execute(hyperlinkHelperFactory.getAddHyperLinkCommand(transactionalEditingDomain, view, allhypHyperlinkObjects));
				} catch (HyperLinkException error) {
					Activator.log.error(error);
				}
		

				getHyperLinkShell().close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

	}

	public void initializeDefaultHyperLinkFolder() {
//		this.defaultHdown.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowDown_16x16.gif").createImage());
//		this.defaultHup.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowUp_16x16.gif").createImage());
//		this.defaultHleft.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowLeft_16x16.gif").createImage());
//		this.defaultHRight.setImage(AbstractUIPlugin.imageDescriptorFromPlugin("org.eclipse.papyrus.diagram.common", "/icons/obj16/ArrowRight_16x16.gif").createImage());
//		availableHyperLinkViewer = new TableViewer(this.availableHyperLink);
//		availableHyperLinkViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
//		availableHyperLinkViewer.setContentProvider(contentProvider);
//
//
//
//		defaultHyperLinkViewer = new TableViewer(this.defaultHyperLink);
//		defaultHyperLinkViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
//		defaultHyperLinkViewer.setContentProvider(contentProvider);
//		defaultHyperLinkViewer.setInput(getHyperlinkWebList());
	}

	public void initializeLocalHyperLinkFolder() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialize hyperlink web folder.
	 */
	public void initializeHyperlinkWebFolder() {
		hyperlinkWeblistTableViewer = new TableViewer(this.getHyperlinkTable());
		hyperlinkWeblistTableViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		hyperlinkWeblistTableViewer.setContentProvider(contentProvider);
		hyperlinkWeblistTableViewer.setInput(getHyperlinkWebList());

		// button and behavior
		getNewhyperlinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				EditorHyperlinkWebShell editor = new EditorHyperlinkWebShell();
				editor.open();
				if(editor.getHyperLinkWeb() != null) {
					hyperlinkWebList.add(editor.getHyperLinkWeb());
					hyperlinkWeblistTableViewer.setInput(getHyperlinkWebList());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		getModifyHyperlinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {

				if(hyperlinkWeblistTableViewer.getTable().getSelection().length != 0) {
					HyperLinkWeb hyperLinkWeb = (HyperLinkWeb)((IStructuredSelection)hyperlinkWeblistTableViewer.getSelection()).getFirstElement();
					EditorHyperlinkWebShell editor = new EditorHyperlinkWebShell();
					editor.setHyperLinkWeb(hyperLinkWeb);
					editor.open();
					int index = hyperlinkWebList.indexOf(hyperLinkWeb);
					hyperlinkWebList.remove(hyperLinkWeb);
					hyperlinkWebList.add(index, editor.getHyperLinkWeb());
					hyperlinkWeblistTableViewer.setInput(getHyperlinkWebList());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		getRemoveHyperLinkButton().addMouseListener(new RemoveElementListener(hyperlinkWeblistTableViewer, hyperlinkWebList));
		getUpHyperLinkWebButton().addMouseListener(new UpElementListener(hyperlinkWeblistTableViewer, hyperlinkWebList));
		getDownHyperLinkWebbutton().addMouseListener(new DownElementListener(hyperlinkWeblistTableViewer, hyperlinkWebList));
	}

	/**
	 * Initialize document folder.
	 */
	public void initializeDocumentFolder() {
		documentlistTableViewer = new TableViewer(this.getDocumentTable());
		documentlistTableViewer.setLabelProvider(new HyperLinkLabelProvider(editorRegistry));
		documentlistTableViewer.setContentProvider(contentProvider);
		documentlistTableViewer.setInput(getDocumentList());
		getNewDocumentButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {

			}

			public void mouseDown(MouseEvent e) {
				EditorHyperlinkDocumentShell editor = new EditorHyperlinkDocumentShell();
				editor.open();
				if(editor.getHyperlinkDocument() != null) {
					documentList.add(editor.getHyperlinkDocument());
					documentlistTableViewer.setInput(getDocumentList());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getModifyDocumentButton1().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(documentlistTableViewer.getTable().getSelection().length != 0) {
					HyperlinkDocument hyperLinkdoc = (HyperlinkDocument)((IStructuredSelection)documentlistTableViewer.getSelection()).getFirstElement();
					EditorHyperlinkDocumentShell editor = new EditorHyperlinkDocumentShell();
					editor.setHyperlinkDocument(hyperLinkdoc);
					editor.open();
					int index = documentList.indexOf(hyperLinkdoc);
					documentList.remove(hyperLinkdoc);
					documentList.add(index, editor.getHyperlinkDocument());
					documentlistTableViewer.setInput(documentList);
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getRemoveDocumentButton().addMouseListener(new RemoveElementListener(documentlistTableViewer, documentList));
		getUpDocumentButton().addMouseListener(new UpElementListener(documentlistTableViewer, documentList));
		getDownDocumentButton().addMouseListener(new DownElementListener(documentlistTableViewer, documentList));
	}

	/**
	 * Initialize diagram folder.
	 */
	public void initializeDiagramFolder() {
		getRemoveDiagramButton().addMouseListener(new RemoveElementListener(diagramlistTableViewer, diagramList));
		getUpDiagramButton().addMouseListener(new UpElementListener(diagramlistTableViewer, diagramList));
		getDownDiagramButton().addMouseListener(new DownElementListener(diagramlistTableViewer, diagramList));
		getNewDiagrambutton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {

			}

			public void mouseDown(MouseEvent e) {
				EditorHyperlinkDiagramShell editor = new EditorHyperlinkDiagramShell(editorRegistry, amodel);
				editor.open();
				if(editor.getHyperLinkDiagram() != null) {
					diagramList.add(editor.getHyperLinkDiagram());
					diagramlistTableViewer.setInput(getDiagramList());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		getModifyDiagramButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(diagramlistTableViewer.getTable().getSelection().length != 0) {
					HyperLinkDiagram hyperLinkdiagram = (HyperLinkDiagram)((IStructuredSelection)diagramlistTableViewer.getSelection()).getFirstElement();
					EditorHyperlinkDiagramShell editor = new EditorHyperlinkDiagramShell(editorRegistry, amodel);
					editor.setHyperLinkDiagram(hyperLinkdiagram);
					editor.open();
					int index = diagramList.indexOf(hyperLinkdiagram);
					diagramList.remove(hyperLinkdiagram);
					diagramList.add(index, editor.getHyperLinkDiagram());
					diagramlistTableViewer.setInput(getDiagramList());
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}

	/**
	 * Open the shell.
	 */
	public void open() {
		Display display = Display.getCurrent();

		// code use to wait for an action from the user
		getHyperLinkShell().pack();
		getHyperLinkShell().setBounds(500, 500, 700, 300);
		getHyperLinkShell().open();
		while(!getHyperLinkShell().isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}
}
