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
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.papyrus.diagram.common.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.diagram.common.helper.HyperlinkHelperFactory;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * The Class HyperLinkManagerShell2.
 */
public class HyperLinkManagerShell extends AbstractHyperLinkManagerShell {


	protected ArrayList<HyperlinkObject> allhypHyperlinkObjects=new ArrayList<HyperlinkObject>();

	/** The view. */
	protected View view;
	/** The amodel. */
	protected Package amodel;

	/** The domain. */
	protected TransactionalEditingDomain transactionalEditingDomain;

	protected HyperlinkHelperFactory hyperLinkHelperFactory;



	public void setInput(ArrayList<HyperlinkObject> hyperLinkObjectList) {
		this.allhypHyperlinkObjects.clear();
		this.allhypHyperlinkObjects.addAll(hyperLinkObjectList);
		Iterator<HyperLinkTab>iter= tabList.iterator();
		while(iter.hasNext()) {
			HyperLinkTab hyperLinkTab = (HyperLinkTab)iter.next();
			hyperLinkTab.setInput(allhypHyperlinkObjects);
		}
	}

	

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
	public HyperLinkManagerShell(IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, Element umlElement, View aview, Package model, HyperlinkHelperFactory hyperHelperFactory) {
		super();
		this.hyperLinkHelperFactory= hyperHelperFactory;
		this.view = aview;
		this.amodel = model;
		this.transactionalEditingDomain = domain;
		createHyperLinkShell();
		// associate tableViewer for each table
		Iterator<AbstractHyperLinkHelper> iter= hyperHelperFactory.getHyperLinkHelpers().iterator();
		while(iter.hasNext()) {
			AbstractHyperLinkHelper abstractHyperLinkHelper = (AbstractHyperLinkHelper)iter.next();
			initializeFolder(abstractHyperLinkHelper);
		}
		// listener for the button cancel
		getCancelButton().addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				tabList.clear();
				getHyperLinkShell().close();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			};
		});

		// listener for the button OK
		SelectionListener okListener =new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				executeOkButton();
				
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		getOkButton().addSelectionListener(okListener);
	}

	protected void executeOkButton(){
		// empty all hyperlinks
		transactionalEditingDomain.getCommandStack().execute(HyperlinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));
		allhypHyperlinkObjects.clear();
		Iterator<HyperLinkTab>iter= tabList.iterator();
		while(iter.hasNext()) {
			HyperLinkTab hyperLinkTab = (HyperLinkTab)iter.next();
			allhypHyperlinkObjects.addAll(hyperLinkTab.getHyperlinkObjects());
		}
		// save hyperlink Document list
		try {
			transactionalEditingDomain.getCommandStack().execute(hyperLinkHelperFactory.getAddHyperLinkCommand(transactionalEditingDomain, view, allhypHyperlinkObjects));
		} catch (HyperLinkException error) {
			Activator.log.error(error);
		}

		tabList.clear();
		getHyperLinkShell().close();
		
	}



	/**
	 * Initialize diagram folder.
	 */
	public void initializeFolder(final AbstractHyperLinkHelper abstractHyperLinkHelper) {
		
		final HyperLinkTab hyperLinkTab=new HyperLinkTab(getcTabFolder(), abstractHyperLinkHelper,allhypHyperlinkObjects);
		tabList.add( hyperLinkTab);
		hyperLinkTab.getRemoveHyperLinkButton().addMouseListener(new MouseListener() {
			public void mouseUp(MouseEvent e) {}
			public void mouseDown(MouseEvent e) {
				if(hyperLinkTab.getTableViewer().getTable().getSelection().length != 0) {
					Iterator iterator = ((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).iterator();
					while(iterator.hasNext()) {
						Object object = iterator.next();
						hyperLinkTab.getHyperlinkObjects().remove(object);
						hyperLinkTab.getTableViewer().setInput(hyperLinkTab.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		hyperLinkTab.getUpHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {}

			public void mouseDown(MouseEvent e) {
				if(hyperLinkTab.getTableViewer().getTable().getSelection().length != 0) {
					Object elt = ((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).getFirstElement();
					if(hyperLinkTab.getHyperlinkObjects().indexOf(elt) == 0) {
						return;
					}
					Iterator iterator = ((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).iterator();
					while(iterator.hasNext()) {
						HyperlinkObject currentHyperLinkDoc = (HyperlinkObject)iterator.next();
						int index = hyperLinkTab.getHyperlinkObjects().indexOf(currentHyperLinkDoc);
						hyperLinkTab.getHyperlinkObjects().remove(currentHyperLinkDoc);
						hyperLinkTab.getHyperlinkObjects().add(index - 1, currentHyperLinkDoc);
						hyperLinkTab.getTableViewer().setInput(hyperLinkTab.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {}
		});
		hyperLinkTab.getDownHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {}

			public void mouseDown(MouseEvent e) {
				if(hyperLinkTab.getTableViewer().getTable().getSelection().length != 0) {
					Object[] block = ((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).toArray();
					if((hyperLinkTab.getHyperlinkObjects().indexOf(block[block.length - 1])) == hyperLinkTab.getHyperlinkObjects().size() - 1) {
						return;
					}
					for(int i = block.length - 1; i >= 0; i--) {
						HyperlinkObject currentobject = (HyperlinkObject)block[i];
						int index = hyperLinkTab.getHyperlinkObjects().indexOf(currentobject);
						hyperLinkTab.getHyperlinkObjects().remove(currentobject);
						hyperLinkTab.getHyperlinkObjects().add(index + 1, currentobject);
						hyperLinkTab.getTableViewer().setInput(hyperLinkTab.getHyperlinkObjects());
					}
				}
			}

			public void mouseDoubleClick(MouseEvent e) {}
		});
		hyperLinkTab.getNewHyperLinkbutton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {}

			public void mouseDown(MouseEvent e) {
				abstractHyperLinkHelper.executeNewMousePressed(hyperLinkTab.getHyperlinkObjects(), amodel);
				hyperLinkTab.setInput(hyperLinkTab.getHyperlinkObjects());
			}

			public void mouseDoubleClick(MouseEvent e) {}
		});
		hyperLinkTab.getModifyHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {	}

			public void mouseDown(MouseEvent e) {
				if(hyperLinkTab.getTableViewer().getTable().getSelection().length != 0) {
					HyperlinkObject hyperLinkObject = (HyperlinkObject)((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).getFirstElement();
					abstractHyperLinkHelper.executeEditMousePressed(hyperLinkTab.getHyperlinkObjects(), hyperLinkObject,amodel);
					hyperLinkTab.setInput(hyperLinkTab.getHyperlinkObjects());
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
