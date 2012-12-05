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
 *  Arthut Daussy (Atos) arthur.daussy@atos.net - Bug 363827 - [Improvement] Diagram creation, remember the latest tab chosen
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.hyperlink.ui;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.infra.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.papyrus.infra.hyperlink.Activator;
import org.eclipse.papyrus.infra.hyperlink.helper.AbstractHyperLinkHelper;
import org.eclipse.papyrus.infra.hyperlink.helper.HyperLinkHelperFactory;
import org.eclipse.papyrus.infra.hyperlink.messages.Messages;
import org.eclipse.papyrus.infra.hyperlink.object.HyperLinkObject;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkException;
import org.eclipse.papyrus.infra.hyperlink.util.HyperLinkTabsRegistrationUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.XMLMemento;

/**
 * The Class HyperLinkManagerShell2.
 */
public class HyperLinkManagerShell extends AbstractHyperLinkManagerShell {

	/**
	 * Memento's name to store Hyper Link Shell data
	 */
	private static final String HYPER_LINK_SHELL_MEMENTO = "HYPER_LINK_SHELL_MEMENTO"; //$NON-NLS-1$

	/**
	 * Memento's name to store index of the last tab used for a specific element type
	 */
	private static final String LAST_TAB_USE_MEMENTO = "LAST_TAB_USE_MEMENTO"; //$NON-NLS-1$

	/**
	 * Memento's name to store index of the last tab (for all element)
	 */
	protected static final String LAST_GLOBAL_TAB_USED = "LAST_USED_MEMENTO"; //$NON-NLS-1$

	/**
	 * The command to execute to set the new eannotation
	 */
	private CompoundCommand cmd;

	final protected List<HyperLinkObject> allhypHyperlinkObjects = new ArrayList<HyperLinkObject>();

	/** The graphical representation of the element (a View in GMF) */
	protected EModelElement view;

	protected EObject semanticElement;

	/** The domain. */
	protected TransactionalEditingDomain transactionalEditingDomain;

	protected HyperLinkHelperFactory hyperLinkHelperFactory;



	public void setInput(List<HyperLinkObject> hyperLinkObjectList) {
		this.allhypHyperlinkObjects.clear();
		this.allhypHyperlinkObjects.addAll(hyperLinkObjectList);
		Iterator<AbstractHyperLinkTab> iter = tabList.iterator();
		while(iter.hasNext()) {
			AbstractHyperLinkTab hyperLinkTab = iter.next();
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
	public HyperLinkManagerShell(IPageIconsRegistry editorFactoryRegistry, TransactionalEditingDomain domain, EModelElement semanticElement, EModelElement aview, HyperLinkHelperFactory hyperHelperFactory) {
		super();
		this.hyperLinkHelperFactory = hyperHelperFactory;
		this.view = aview;
		this.semanticElement = semanticElement;
		this.transactionalEditingDomain = domain;
		createHyperLinkShell();

		initializeFolder(null);

		//		// associate tableViewer for each table
		//		Iterator<AbstractHyperLinkHelper> iter = hyperHelperFactory.getHyperLinkHelpers().iterator();
		//		while(iter.hasNext()) {
		//			AbstractHyperLinkHelper abstractHyperLinkHelper = (AbstractHyperLinkHelper)iter.next();
		//			initializeFolder(abstractHyperLinkHelper);
		//		}
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

	protected void executeOkButton() {//should be final?
		CompoundCommand myCommand = getCommand();
		//clear the current annotations
		myCommand.append(HyperLinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));
		doAction();

		//store eannotation command
		try {
			myCommand.append(hyperLinkHelperFactory.getAddHyperLinkCommand(transactionalEditingDomain, view, allhypHyperlinkObjects));
		} catch (HyperLinkException e) {
			Activator.log.error(e);
		}

		//execute the command
		Assert.isTrue(myCommand.canExecute());
		this.transactionalEditingDomain.getCommandStack().execute(myCommand);
		closeDialog();
	}



	/**
	 * do the action and fill the command
	 */
	protected void doAction() {
		// empty all hyperlinks
		//clear command
		//		CompoundCommand tmp = getCommand();
		//		tmp.append(HyperLinkHelperFactory.getEmptyAllHyperLinkCommand(transactionalEditingDomain, view));


		allhypHyperlinkObjects.clear();
		allhypHyperlinkObjects.addAll(getSelectedHyperLinkObjectCrossingTabs());
		//set all hyper links is default to false
		Iterator<HyperLinkObject> iterator = allhypHyperlinkObjects.iterator();
		while(iterator.hasNext()) {
			HyperLinkObject hyperLink = iterator.next();
			hyperLink.setIsDefault(false);
		}


		//specific behavior for the DefautHyperLinkTab
		DefaultHyperLinkTab defaultHyperLinkTab = getDefaultHyperLinkTab();

		//look for all hyperlink default and put it as default at the top of the list
		int i = defaultHyperLinkTab.getDefaultHyperLinkObject().size() - 1;
		while(i >= 0) {
			HyperLinkObject hyperLinkObject = defaultHyperLinkTab.getDefaultHyperLinkObject().get(i);
			hyperLinkObject.setIsDefault(true);
			if(allhypHyperlinkObjects.contains(hyperLinkObject)) {
				allhypHyperlinkObjects.remove(hyperLinkObject);
				allhypHyperlinkObjects.add(0, hyperLinkObject);
			}
			i--;
		}

		//		//store eannotation command
		//		try {
		//			tmp.append(hyperLinkHelperFactory.getAddHyperLinkCommand(transactionalEditingDomain, view, allhypHyperlinkObjects));
		//		} catch (HyperLinkException e) {
		//			Activator.log.error(e);
		//		}
	}

	private void closeDialog() {
		//save the corresponding tab
		saveCorrespondingTab();
		tabList.clear();
		getHyperLinkShell().close();
	}

	protected CompoundCommand getCommand() {
		if(cmd == null) {
			cmd = new CompoundCommand(Messages.HyperLinkManagerShell_HyperLinksCommands);
		}
		return cmd;
	}

	/**
	 * Initialize diagram folder.
	 */
	public void initializeFolder(final AbstractHyperLinkHelper abstractHyperLinkHelper) { //TODO remove this parameter which is not used!
		Iterator<AbstractHyperLinkTab> iter = HyperLinkTabsRegistrationUtil.INSTANCE.getAllHyperLinkTab().iterator();
		while(iter.hasNext()) {
			AbstractHyperLinkTab current = iter.next();
			current.init(getcTabFolder(), allhypHyperlinkObjects, semanticElement);
			tabList.add(current);
		}

		//specific behavior for the default tab : 
		final DefaultHyperLinkTab defaultTab = getDefaultHyperLinkTab();
		defaultTab.getMainComposite().addListener(SWT.Show, new Listener() {

			public void handleEvent(Event event) {
				defaultTab.setInput(HyperLinkManagerShell.this.getSelectedHyperLinkObjectCrossingTabs());
			}
		});

	}

	/**
	 * Open the shell.
	 */
	public void open() {
		Display display = Display.getCurrent();
		getHyperLinkShell().pack();
		//		getHyperLinkShell().setBounds(500, 500, 700, 300);
		getHyperLinkShell().open();
		//Select the good tab
		selectLastTab();
		// code use to wait for an action from the user
		while(!getHyperLinkShell().isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
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
		if(semanticElement != null) {
			//Save the corresponding tab for the element
			//Use InstanceTypeName in order to make a convenient ID
			int selectionIndex = getcTabFolder().getSelectionIndex();
			memento.putInteger(semanticElement.eClass().getInstanceTypeName(), selectionIndex);
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
		Integer lastIndexUsed = null;
		if(semanticElement != null) {
			lastIndexUsed = getLastTabUseMemento(rootMemento, semanticElement.eClass().getInstanceTypeName());
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
			Activator.log.error(Messages.HyperLinkManagerShell_InputOutputException, e);
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
			Activator.log.error(Messages.HyperLinkManagerShell_ImpossibleToReadPreferences, e);
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

	//TODO : should be a set ? 
	public List<HyperLinkObject> getSelectedHyperLinkObjectCrossingTabs() {
		Set<HyperLinkObject> selectedObjects = new HashSet<HyperLinkObject>();
		for(AbstractHyperLinkTab current : tabList) {
			if(!(current instanceof DefaultHyperLinkTab)) {
				List<HyperLinkObject> tmp = current.getHyperlinkObjects();
				if(tmp != null) {
					selectedObjects.addAll(tmp);
				}
			}
		}
		return new ArrayList<HyperLinkObject>(selectedObjects);
	}

	protected DefaultHyperLinkTab getDefaultHyperLinkTab() {
		int nbTab = 0;
		DefaultHyperLinkTab defaultHyperLinkTab = null;
		for(AbstractHyperLinkTab current : tabList) {
			if(current instanceof DefaultHyperLinkTab) {
				defaultHyperLinkTab = (DefaultHyperLinkTab)current;
				nbTab++;
			}
		}
		//there is only one DefaultHyperLinkTab in the dialog!
		Assert.isTrue(nbTab == 1);
		Assert.isNotNull(defaultHyperLinkTab);
		return defaultHyperLinkTab;
	}
}
