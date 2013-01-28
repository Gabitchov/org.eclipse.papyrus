package org.eclipse.papyrus.qompass.designer.core.dialogs;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

import FCM.InterceptionRule;

import org.eclipse.papyrus.qompass.designer.core.Utils;


public class ChoosePorts extends ChooseSetAssistedDialog implements IChooseDialog {

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
	public ChoosePorts(Shell parentShell, Class component, InterceptionRule rule) {
		super(parentShell, "Available features", "Intercepted features");
		labelProvider = new PortLabelProvider();
		decoratedContentProposalProvider = new ConfigOptContentProposalProvider();

		for(Feature feature : rule.getInterceptionSet()) {
			selectedElementList.addElement(feature);
		}

		visitedPackages = new BasicEList<Package>();
		if(component != null) {
			// local rule with intercept some policy: choose executor ports
			for(Property current : component.getOwnedAttributes()) {
				if(!selectedElementList.contains(current)) {
					possibleElementList.addElement(current);
				}
			}
			for(Feature current : Utils.getAllElementsOfType(component, Feature.class)) {
				if(!selectedElementList.contains(current)) {
					possibleElementList.addElement(current);
				}
			}
		} else {
			// global rule with intercept some policy
			// choose all ports vs. ports of "standard components"
			Package top = Utils.getTop(rule.getBase_Property());
			for(Feature current : Utils.getAllElementsOfType(top, Feature.class)) {
				if(!selectedElementList.contains(current)) {
					possibleElementList.addElement(current);
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
		column.setText("Port");
		column.setWidth(60);
		column.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				possibleElementsTableViewer.setSorter(new AlphabeticalViewerSorter(0));
			}
		});

		// 2nd column with task Description
		column = new TableColumn(possibleElementsTable, SWT.LEFT, 1);
		column.setText("Type");
		column.setWidth(100);
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
		Port port = null;
		for(Object possibleElement : possibleElementList.getElements()) {
			Port element = (Port)possibleElement;
			if(name.equalsIgnoreCase(element.getName()) || name.equalsIgnoreCase(element.getQualifiedName())) {
				port = element;
			}
		}
		if(port != null) {
			runActionAdd(port);
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
		for(Object possibleElement : possibleElementList.getElements()) {
			Port element = (Port)possibleElement;
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
				for(Object portObj : possibleElementList.getElements()) {
					final Port port = (Port)portObj;
					final String simpleName = port.getName();
					final String qualifiedName = port.getQualifiedName();

					if(position < simpleName.length() && contents.substring(0, position).equalsIgnoreCase(simpleName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(port, labelProvider));
					}

					if(position < qualifiedName.length() && contents.substring(0, position).equalsIgnoreCase(qualifiedName.substring(0, position))) {
						proposals.add(new DecoratedContentProposal(port, qualifiedLabelProvider));
					}
				}
			}

			Collections.sort(proposals);
			return proposals.toArray(new DecoratedContentProposal[proposals.size()]);
		}
	}
}
