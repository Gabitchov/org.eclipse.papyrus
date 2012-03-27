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
 *	Arthut Daussy (Atos) arthur.daussy@atos.net - Bug 363827 - [Improvement] Diagram creation, remember the latest tab chosen
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.ui.hyperlinkshell;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
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
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;

/**
 * The Class HyperLinkManagerShell2.
 */
public class HyperLinkManagerShell extends AbstractHyperLinkManagerShell {

	/**
	 * Memento's name to store Hyper Link Shell data
	 */
	private static final String HYPER_LINK_SHELL_MEMENTO = "HYPER_LINK_SHELL_MEMENTO";

	/**
	 * Memento's name to store index of the last tab used for a specific element type
	 */
	private static final String LAST_TAB_USE_MEMENTO = "LAST_TAB_USE_MEMENTO";

	/**
	 * Memento's name to store index of the last tab (for all element)
	 */
	protected static final String LAST_GLOBAL_TAB_USED = "LAST_USED_MEMENTO";

	protected ArrayList<HyperlinkObject> allhypHyperlinkObjects = new ArrayList<HyperlinkObject>();

	/** The view. */
	protected View view;

	/** The amodel. */
	protected Package amodel;

	/** The domain. */
	protected TransactionalEditingDomain transactionalEditingDomain;

	protected HyperlinkHelperFactory hyperLinkHelperFactory;

	public void setInput(List<HyperlinkObject> hyperLinkObjectList) {
		this.allhypHyperlinkObjects.clear();
		this.allhypHyperlinkObjects.addAll(hyperLinkObjectList);
		Iterator<HyperLinkTab> iter = tabList.iterator();
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
		this.hyperLinkHelperFactory = hyperHelperFactory;
		this.view = aview;
		this.amodel = model;
		this.transactionalEditingDomain = domain;
		createHyperLinkShell();
		// associate tableViewer for each table
		Iterator<AbstractHyperLinkHelper> iter = hyperHelperFactory.getHyperLinkHelpers().iterator();
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
		SelectionListener okListener = new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				executeOkButton();

			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		};
		getOkButton().addSelectionListener(okListener);
	}

	protected void executeOkButton() {
		// empty all hyperlinks
		transactionalEditingDomain.getCommandStack().execute(HyperlinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));
		allhypHyperlinkObjects.clear();
		Iterator<HyperLinkTab> iter = tabList.iterator();
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
		//save the corresponding tab
		saveCorrespondingTab();
		tabList.clear();
		getHyperLinkShell().close();

	}

	/**
	 * Initialize diagram folder.
	 */
	public void initializeFolder(final AbstractHyperLinkHelper abstractHyperLinkHelper) {

		final HyperLinkTab hyperLinkTab = new HyperLinkTab(getcTabFolder(), abstractHyperLinkHelper, allhypHyperlinkObjects);
		tabList.add(hyperLinkTab);
		hyperLinkTab.getRemoveHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

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

			public void mouseUp(MouseEvent e) {
			}

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

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		hyperLinkTab.getDownHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

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

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		hyperLinkTab.getNewHyperLinkbutton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				abstractHyperLinkHelper.executeNewMousePressed(hyperLinkTab.getHyperlinkObjects(), amodel);
				hyperLinkTab.setInput(hyperLinkTab.getHyperlinkObjects());
			}

			public void mouseDoubleClick(MouseEvent e) {
			}
		});
		hyperLinkTab.getModifyHyperLinkButton().addMouseListener(new MouseListener() {

			public void mouseUp(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if(hyperLinkTab.getTableViewer().getTable().getSelection().length != 0) {
					HyperlinkObject hyperLinkObject = (HyperlinkObject)((IStructuredSelection)hyperLinkTab.getTableViewer().getSelection()).getFirstElement();
					abstractHyperLinkHelper.executeEditMousePressed(hyperLinkTab.getHyperlinkObjects(), hyperLinkObject, amodel);
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
		//Select the good tab
		selectLastTab();
		while(!getHyperLinkShell().isDisposed()) {
			if(!display.readAndDispatch())
				display.sleep();
		}
	}

	/**
	 * Save the last tab used for the specific element and the global last tab used
	 * 
	 * @param rootMemento
	 *        {@link IMemento} use to save information about last tab used
	 */
	protected void saveCorrespondingTab() {
		IMemento rootMemento = getExistingHPMemento();
		IMemento memento = getLastTabUseMemento(rootMemento);
		EObject element = view.getElement();
		if(element != null) {
			//Save the corresponding tab for the element
			//Use InstanceTypeName in order to make a convenient ID
			int selectionIndex = getcTabFolder().getSelectionIndex();
			memento.putInteger(element.eClass().getInstanceTypeName(), selectionIndex);
			//Save the global last tab used
			memento.putInteger(LAST_GLOBAL_TAB_USED, selectionIndex);
		}
		saveMemento((XMLMemento)rootMemento, HYPER_LINK_SHELL_MEMENTO);
	}

	/**
	 * Select the last tab used.
	 * If an element of the same type has already been encountered then it open the last tab used for this type
	 * else open the last tab used for all element
	 */
	protected void selectLastTab() {
		IMemento rootMemento = getExistingHPMemento();
		EObject element = view.getElement();
		Integer lastIndexUsed = null;
		if(element != null) {
			lastIndexUsed = getLastTabUseMemento(rootMemento, element.eClass().getInstanceTypeName());
		}
		if(lastIndexUsed == null) {
			lastIndexUsed = getLastTabUseMemento(rootMemento, LAST_GLOBAL_TAB_USED);
			if(lastIndexUsed == null) {
				lastIndexUsed = 0;
			}
		}
		try {
			getcTabFolder().setSelection(lastIndexUsed);
		} catch (IndexOutOfBoundsException e) {
			getcTabFolder().setSelection(0);
		}
	}

	/**
	 * Save the the moment into the Preference store
	 * 
	 * @param xmlMemento
	 * @param key
	 */
	public static void saveMemento(XMLMemento xmlMemento, String key) {
		// save memento
		StringWriter writer = new StringWriter();
		try {
			xmlMemento.save(writer);
			if(getPreferenceStore() != null) {
				getPreferenceStore().setValue(key, writer.toString());
			}
		} catch (IOException e) {
			Activator.getDefault().logError("input/ouput exception", e);
		}
	}

	/**
	 * Retrieves the root memento for Hyper Link Date Shell data from the plugin preferences if any or create a new one if none
	 * 
	 * @return the root memento for Hyper Links Data
	 */
	public static IMemento getExistingHPMemento() {
		String sValue = getPreferenceStore().getString(HYPER_LINK_SHELL_MEMENTO);
		try {
			if(sValue != null && !sValue.equals("")) { //$NON-NLS-1$
				XMLMemento rootMemento = XMLMemento.createReadRoot(new StringReader(sValue));
				return rootMemento;
			} else {
				return XMLMemento.createWriteRoot(HYPER_LINK_SHELL_MEMENTO);
			}
		} catch (WorkbenchException e) {
			Activator.getDefault().logError("Impossible to read preferences", e);
		}
		return null;
	}

	/**
	 * Return the index of the last tab used for the type (represented by semantic hinted) or null if none
	 * 
	 * @param rootMemento
	 *        Root memento used for Hyper Link Data
	 * @param elementSemanticHint
	 *        String to represent the EClass of the EObject
	 * @return
	 */
	public static Integer getLastTabUseMemento(IMemento rootMemento, String elementSemanticHint) {
		IMemento lastTabUsedMemento = getLastTabUseMemento(rootMemento);
		if(lastTabUsedMemento != null) {
			return lastTabUsedMemento.getInteger(elementSemanticHint);
		}
		return null;
	}

	/**
	 * @param memento
	 * @return
	 */
	protected static IMemento getLastTabUseMemento(IMemento memento) {
		IMemento lastTabUsedMemento = memento.getChild(LAST_TAB_USE_MEMENTO);
		if(lastTabUsedMemento == null) {
			lastTabUsedMemento = memento.createChild(LAST_TAB_USE_MEMENTO);
		}
		return lastTabUsedMemento;
	}

	private static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}
}
