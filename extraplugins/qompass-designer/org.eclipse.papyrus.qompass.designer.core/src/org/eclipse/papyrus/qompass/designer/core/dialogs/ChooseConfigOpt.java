/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.dialogs;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.uml.profile.ui.dialogs.AlphabeticalViewerSorter;
import org.eclipse.papyrus.uml.profile.ui.dialogs.ChooseSetAssistedDialog;
import org.eclipse.papyrus.uml.profile.ui.dialogs.IChooseDialog;
import org.eclipse.papyrus.uml.properties.profile.ui.dialogs.StereotypeQualifiedLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;


public class ChooseConfigOpt extends ChooseSetAssistedDialog implements IChooseDialog {

	protected EList<Package> visitedPackages;

	/**
	 * LabelProvider for stereotype completion proposal provider with qualified names.
	 */
	final private StereotypeQualifiedLabelProvider qualifiedLabelProvider = new StereotypeQualifiedLabelProvider();

	/**
	 * Default Constructor.
	 * 
	 * @param parentShell
	 *        the parent shell
	 * @param theElement
	 *        the UML element to be modified
	 */
	public ChooseConfigOpt(Shell parentShell, Package model, ContainerRule rule) {
		super(parentShell,
				"Available configuration options: ",
				"Applied configuration options: ");
		labelProvider = new ConfigOptionLabelProvider();
		decoratedContentProposalProvider = new ConfigOptContentProposalProvider();

		for(ConfigOption option : rule.getForConfig()) {
			selectedElementList.addElement(option.getBase_Class());
		}

		visitedPackages = new BasicEList<Package>();
		EList<Class> configOptList = new BasicEList<Class>();
		getAvailConfigOpts(model, configOptList);
		for(Class current : configOptList) {
			if(!selectedElementList.contains(current)) {
				possibleElementList.addElement(current);
			}
		}
	}

	private void getAvailConfigOpts(Package pkg, EList<Class> configOptList) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Package) {
				if(!visitedPackages.contains(el)) {
					visitedPackages.add((Package)el);
					getAvailConfigOpts((Package)el, configOptList);
				}
			} else if(el instanceof Class) {
				if(StUtils.isApplied(el, ConfigOption.class)) {
					configOptList.add((Class)el);
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#createDialogArea(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * Creates the dialog area.
	 * 
	 * @param parent
	 *        the parent
	 * 
	 * @return the control
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Control composite = super.createDialogArea(parent);

		// Add 2 columns to the table area
		// possibleElementsTable.setLinesVisible(true);
		possibleElementsTable.setHeaderVisible(true);

		// 1st column with image/checkboxes - NOTE: The SWT.CENTER has no effect!!
		TableColumn column = new TableColumn(possibleElementsTable, SWT.CENTER, 0);
		column.setText("Option");
		column.setWidth(100);
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));
			}
		});

		// 2nd column with task Description
		column = new TableColumn(possibleElementsTable, SWT.LEFT, 1);
		column.setText("Information");
		column.setWidth(165);
		// Add listener to column so tasks are sorted by description when clicked 
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(1));
			}
		});

		// set sorter to the possible element table viewer 
		possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));

		return composite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#runAddElement(java.lang.String)
	 */
	/**
	 * Run add element.
	 * 
	 * @param name
	 *        the name
	 */
	@Override
	protected void runAddElement(String name) {
		// find the stereotype in the list
		Class option = null;
		for (Object possibleElement : possibleElementList.getElements()) {
			Class element = (Class) possibleElement;
			if(name.equalsIgnoreCase(element.getName()) ||
				name.equalsIgnoreCase(element.getQualifiedName())) {
				option = element;
			}
		}
		if(option != null) {
			runActionAdd(option);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog#isSelectableElement(java.lang.String)
	 */
	/**
	 * Checks if is selectable element.
	 * 
	 * @param text
	 *        the text
	 * 
	 * @return true, if is selectable element
	 */
	@Override
	protected boolean isSelectableElement(String text) {
		// iterate through all possibilities and return true if text corresponds
		for (Object possibleElement : possibleElementList.getElements()) {
			Class element = (Class) possibleElement;
			if(text.equalsIgnoreCase(element.getName()) || text.equalsIgnoreCase(element.getQualifiedName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Content Proposal provider for stereotypes dialog. Propose the simple
	 * name of the stereotype and its qualified name.
	 * 
	 * @author Remi Schnekenburger
	 */
	public class ConfigOptContentProposalProvider extends DecoratedContentProposalProvider {

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.cea.papyrus.ui.dialogs.ChooseSetAssistedDialog.DecoratedContentProposalProvider#getProposals(java.lang.String, int)
		 */
		/**
		 * Gets the proposals.
		 * 
		 * @param contents
		 *        the contents
		 * @param position
		 *        the position
		 * 
		 * @return the proposals
		 */
		@Override
		public DecoratedContentProposal[] getProposals(String contents, int position) {
			ArrayList<DecoratedContentProposal> proposals = new ArrayList<DecoratedContentProposal>();

			if(possibleElementList != null) {
				for(Object configOptObj : possibleElementList.getElements()) {
					final Class configOpt = (Class)configOptObj;
					final String simpleName = configOpt.getName();
					final String qualifiedName = configOpt.getQualifiedName();

					if(position < simpleName.length() && contents.substring(0, position).equalsIgnoreCase(simpleName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(configOpt, labelProvider));
					}

					if(position < qualifiedName.length() && contents.substring(0, position).equalsIgnoreCase(qualifiedName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(configOpt, qualifiedLabelProvider));
					}
				}
			}

			Collections.sort(proposals);
			return proposals.toArray(new DecoratedContentProposal[proposals.size()]);
		}
	}
}
