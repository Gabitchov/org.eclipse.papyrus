/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Florian Noyrit (CEA LIST) florian.noyrit@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbed.customization.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.views.properties.runtime.state.IState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionSetDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.StatesStore;
import org.eclipse.papyrus.views.properties.tabbed.core.view.TabDescriptorState;
import org.eclipse.papyrus.views.properties.tabbed.core.view.SectionDescriptorState.ReplacedSectionState;
import org.eclipse.papyrus.views.properties.tabbed.customization.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.views.properties.tabbed.ISectionDescriptor;



/**
 * Validator for configuration that output report for errors and warnings.
 */
public class ConfigurationValidator {

	protected Shell shell;

	/** problem found during validation */
	protected ArrayList<AbstractValidationProblem> errorsFound = new ArrayList<AbstractValidationProblem>();

	/** problem found during validation */
	protected ArrayList<AbstractValidationProblem> warningsFound = new ArrayList<AbstractValidationProblem>();

	TableViewer errorsTableViewer;

	TableViewer warningsTableViewer;

	/**
	 * A specific validation problem for duplicates
	 */
	protected class Duplicate extends AbstractValidationProblem {

		protected IState stateA;

		protected IState stateB;

		/**
		 * Getter for the first state concerned by this problem
		 * 
		 * @return
		 *         the state concerned by this problem
		 */
		public IState getStateA() {
			return stateA;
		}

		/**
		 * Setter for the first state concerned by this problem
		 * 
		 * @param state
		 *        the state concerned by this problem
		 */
		public void setStateA(IState state) {
			this.stateA = state;
		}

		/**
		 * Getter for the second state concerned by this problem
		 * 
		 * @return
		 *         the state concerned by this problem
		 */
		public IState getStateB() {
			return stateB;
		}

		/**
		 * Setter for the second state concerned by this problem
		 * 
		 * @param state
		 *        the state concerned by this problem
		 */
		public void setStateB(IState state) {
			this.stateB = state;
		}

		/**
		 * 
		 * Constructor.
		 * 
		 * @param stateA
		 *        the first state concerned by this problem
		 * @param stateB
		 *        the second state concerned by this problem
		 */
		public Duplicate(IState stateA, IState stateB) {
			setMessage("Duplicate : ");
			this.stateA = stateA;
			this.stateB = stateB;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Duplicate) {
				if(((Duplicate)obj).getStateA() == stateA || ((Duplicate)obj).getStateB() == stateA) {
					return true;
				} else {
					return false;
				}
			}

			return super.equals(obj);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText() {
			return message + stateA.getText() + " <-> " + stateB.getText();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage() {
			return Activator.getImage("/icons/Duplicate.gif");
		}
	}

	/**
	 * A specific validation problem for broken link (broken references among elements)
	 */
	protected class BrokenLink extends AbstractValidationProblem {

		protected IState state;

		/**
		 * Getter for the state concerned by this problem
		 * 
		 * @return
		 *         the state concerned by this problem
		 */
		public IState getState() {
			return state;
		}

		/**
		 * Setter for the state concerned by this problem
		 * 
		 * @param state
		 *        the state concerned by this problem
		 */
		public void setStateA(IState state) {
			this.state = state;
		}

		/**
		 * 
		 * Constructor.
		 * 
		 * @param state
		 *        the state concerned by this problem
		 */
		public BrokenLink(IState state) {
			setMessage("BrokenLink : ");
			this.state = state;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public String getText() {
			return message + state.getText();
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Image getImage() {
			return Activator.getImage("/icons/BrokenLink.gif");
		}
	}

	public ConfigurationValidator(Shell shell) {
		this.shell = shell;
	}

	/**
	 * Validates the configuration
	 * 
	 * @param forSave
	 *        if set to true, the report dialog will be adapted for saving purpose
	 * @param verbose
	 *        if set to true, report is given even when configuration is valid
	 * @return true if the configuration is valid, false otherwise
	 */
	public boolean validateConfig(boolean forSave, boolean verbose) {

		errorsFound.clear();
		warningsFound.clear();
		//Find duplicates

		//For tabs 
		for(TabDescriptorState tabDescriptorState : StatesStore.getTabDescriptorStates()) {
			for(TabDescriptorState tabDescriptorState2 : StatesStore.getTabDescriptorStates()) {
				if(tabDescriptorState != tabDescriptorState2) {
					if(tabDescriptorState.getId().equals(tabDescriptorState2.getId())) {
						if(!errorsFound.contains(new Duplicate(tabDescriptorState, tabDescriptorState2))) {
							Duplicate duplicate = new Duplicate(tabDescriptorState, tabDescriptorState2);
							duplicate.setMessage("Duplicated tabID: ");
							errorsFound.add(duplicate);
						}
					}
				}
			}
		}

		//For sections
		List<SectionDescriptorState> sectionDescriptorStates = new ArrayList<SectionDescriptorState>();
		for(SectionSetDescriptorState sectionSetDescriptorState : StatesStore.getSectionSetDescriptorStates()) {
			sectionDescriptorStates.addAll(sectionSetDescriptorState.getSectionDescriptorStates());
		}
		for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
			for(SectionDescriptorState sectionDescriptorState2 : sectionDescriptorStates) {
				if(sectionDescriptorState != sectionDescriptorState2) {
					if(sectionDescriptorState.getId().equals(sectionDescriptorState2.getId())) {
						if(!errorsFound.contains(new Duplicate(sectionDescriptorState, sectionDescriptorState2))) {
							Duplicate duplicate = new Duplicate(sectionDescriptorState, sectionDescriptorState2);
							duplicate.setMessage("Duplicated sectionID: ");
							errorsFound.add(duplicate);
						}
					}
				}
			}
		}

		//For fragments
		//		List<IFragmentDescriptorState> fragmentDescriptorStates = new ArrayList<IFragmentDescriptorState>();
		//		for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
		//			fragmentDescriptorStates.addAll(sectionDescriptorState.getFragmentDescriptorStates());
		//		}
		//		for(IFragmentDescriptorState fragmentDescriptorState : fragmentDescriptorStates) {
		//			for(IFragmentDescriptorState fragmentDescriptorState2 : fragmentDescriptorStates) {
		//				if(fragmentDescriptorState != fragmentDescriptorState2) {
		//					if(fragmentDescriptorState.getId().equals(fragmentDescriptorState2.getId())) {
		//						if(!IDduplicates.containsValue(fragmentDescriptorState) && !IDduplicates.containsKey(fragmentDescriptorState)) {
		//							IDduplicates.put(fragmentDescriptorState, fragmentDescriptorState2);
		//						}
		//					}
		//				}
		//			}
		//		}

		//Check tabs label 
		for(TabDescriptorState tabDescriptorState : StatesStore.getTabDescriptorStates()) {
			for(TabDescriptorState tabDescriptorState2 : StatesStore.getTabDescriptorStates()) {
				if(tabDescriptorState != tabDescriptorState2) {
					if(tabDescriptorState.getLabel().equals(tabDescriptorState2.getLabel())) {
						if(!warningsFound.contains(new Duplicate(tabDescriptorState, tabDescriptorState2))) {
							Duplicate duplicate = new Duplicate(tabDescriptorState, tabDescriptorState2);
							duplicate.setMessage("Confusing tab label: ");
							warningsFound.add(duplicate);
						}
					}
				}
			}
		}




		//Check references
		boolean found;
		//TabIdentifier in sections
		for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
			found = false;
			for(TabDescriptorState tabDescriptorState : StatesStore.getTabDescriptorStates()) {
				if(sectionDescriptorState.getTargetTab().equals(tabDescriptorState.getId())) {
					found = true;
				}
			}
			if(!found) {
				BrokenLink brokenLink = new BrokenLink(sectionDescriptorState);
				brokenLink.setMessage("Broken link for TargetTab in : ");
				errorsFound.add(brokenLink);
			}
		}

		//AfterSection in sections
		for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
			found = false;
			if(!sectionDescriptorState.getAfterSection().equals(ISectionDescriptor.TOP)) {
				for(SectionDescriptorState sectionDescriptorState2 : sectionDescriptorStates) {
					if(sectionDescriptorState.getAfterSection().equals(sectionDescriptorState2.getId())) {
						found = true;
					}
				}
				if(!found) {
					BrokenLink brokenLink = new BrokenLink(sectionDescriptorState);
					brokenLink.setMessage("Broken link for AfterSection in : ");
					warningsFound.add(brokenLink);
				}
			}
		}

		//Identifier in ReplacedSection
		List<ReplacedSectionState> replacedSectionStates = new ArrayList<ReplacedSectionState>();
		for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
			replacedSectionStates.addAll(sectionDescriptorState.getReplacedSectionStates());
		}
		for(ReplacedSectionState replacedSectionState : replacedSectionStates) {
			found = false;
			for(SectionDescriptorState sectionDescriptorState : sectionDescriptorStates) {
				if(replacedSectionState.getId().equals(sectionDescriptorState.getId())) {
					found = true;
				}
			}
			if(!found) {
				BrokenLink brokenLink = new BrokenLink(replacedSectionState);
				brokenLink.setMessage("Broken link for Identifier in : ");
				warningsFound.add(brokenLink);
			}
		}

		if(errorsFound.isEmpty() && warningsFound.isEmpty()) {
			if(verbose) {
				MessageDialog.openInformation(shell, "Validation report", "No error and no warning found");
			}
			return true;
		} else {
			ReportDialog dialog = new ReportDialog(shell, forSave);
			dialog.open();
			//If forSave and save anyway
			if(forSave && dialog.getReturnCode() == IDialogConstants.OK_ID) {
				return true;
			} else {
				return false;
			}
		}
	}

	/**
	 * The report dialog opened to display the errors and warnings found in the configuration
	 */
	protected class ReportDialog extends TitleAreaDialog {

		private boolean forSave;

		/**
		 * 
		 * Constructor.
		 * 
		 * @param parentShell
		 *        the shell to use
		 * @param forSave
		 *        if set to true, the report dialog will be adapted for saving purpose
		 */
		public ReportDialog(Shell parentShell, boolean forSave) {
			super(parentShell);
			this.setShellStyle(getShellStyle() | SWT.RESIZE);
			this.forSave = forSave;
		}

		/**
		 * {@inheritDoc}
		 */
		public Control createContents(Composite parent) {
			Control contents = super.createContents(parent);

			// Set the title
			setTitle("Validation report");

			// Set the message
			setMessage("Please reconsider the following issues.", IMessageProvider.NONE);

			return contents;
		}

		protected Control createProblemReportArea(Composite conposite) {
			Composite contents = new Composite(conposite, SWT.BORDER);
			contents.setLayout(new GridLayout(1, true));
			contents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

			ILabelProvider labelProvider = new LabelProvider() {

				/**
				 * {@inheritDoc}
				 */
				public Image getImage(Object element) {
					if(element instanceof AbstractValidationProblem) {
						return ((AbstractValidationProblem)element).getImage();
					}
					return null;
				}

				/**
				 * {@inheritDoc}
				 */
				public String getText(Object element) {
					if(element instanceof AbstractValidationProblem) {
						return ((AbstractValidationProblem)element).getText();
					}
					return element.toString();
				}
			};

			IContentProvider contentProvider = new IStructuredContentProvider() {

				public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
					// TODO Auto-generated method stub

				}

				public void dispose() {
					// TODO Auto-generated method stub

				}

				public Object[] getElements(Object inputElement) {
					return ((ArrayList<Object>)inputElement).toArray();
				}
			};

			// Create Label
			Label labelErrors = new Label(contents, SWT.NONE);
			labelErrors.setText("Error(s) found: ");


			int flags = SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL;
			errorsTableViewer = new TableViewer(contents, flags);
			GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
			gridData.widthHint = convertWidthInCharsToPixels(80);
			gridData.heightHint = convertHeightInCharsToPixels(18);
			errorsTableViewer.getControl().setLayoutData(gridData);
			errorsTableViewer.setLabelProvider(labelProvider);
			errorsTableViewer.setContentProvider(contentProvider);


			Label labelWarnings = new Label(contents, SWT.NONE);
			labelWarnings.setText("Warning(s) found: ");

			warningsTableViewer = new TableViewer(contents, flags);
			GridData gridData2 = new GridData(SWT.FILL, SWT.FILL, true, true);
			gridData2.widthHint = convertWidthInCharsToPixels(80);
			gridData2.heightHint = convertHeightInCharsToPixels(18);
			warningsTableViewer.getControl().setLayoutData(gridData2);
			warningsTableViewer.setLabelProvider(labelProvider);
			warningsTableViewer.setContentProvider(contentProvider);


			return contents;

		}


		/**
		 * {@inheritDoc}
		 */
		protected Control createDialogArea(Composite parent) {

			Composite parentComposite = (Composite)super.createDialogArea(parent);

			initializeDialogUnits(parentComposite);

			createProblemReportArea(parentComposite);

			errorsTableViewer.setInput(errorsFound);
			warningsTableViewer.setInput(warningsFound);

			return parentComposite;
		}

		/**
		 * {@inheritDoc}
		 */
		protected void createButtonsForButtonBar(Composite parent) {
			if(forSave) {
				createButton(parent, IDialogConstants.CANCEL_ID, "Don't save", true);
				createButton(parent, IDialogConstants.OK_ID, "Save anyway", false);
			} else {
				createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
			}
		}
	}
}
