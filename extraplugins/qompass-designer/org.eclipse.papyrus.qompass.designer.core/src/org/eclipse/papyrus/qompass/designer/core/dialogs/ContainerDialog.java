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

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Select container rules, either from a list of globally defined rules
 * or from local rules which may be created "on the fly" by this dialog.
 * 
 * TODO: extend rule application to instances (problematic, since rules transformation
 * is done on type level)
 * 
 * @author ansgar
 */
public class ContainerDialog extends SelectionStatusDialog {

	protected Class m_component;

	// protected EList<Package> visitedPackages;
	protected Text fDescription;

	// protected FilteredList fRules;
	protected CheckboxTableViewer fRules;

	// protected Combo fInterceptionKind;

	// protected Button fInterButton;

	// protected Label fPortLabel;
	// protected Text fRuleName;
	// protected Button fOptionButton;

	// protected Button fPortButton;

	protected ContainerRule m_currentRule;

	protected Package m_model;

	protected boolean m_rulePropertiesOnly;

	public ContainerDialog(Shell parent, Class componentOrRule) {
		super(parent);
		// visitedPackages = new BasicEList<Package> ();
		m_rulePropertiesOnly = StUtils.isApplied(componentOrRule, ContainerRule.class);
		if(m_rulePropertiesOnly) {
			// m_currentRule = UMLUtil.getStereotypeApplication(componentOrRule, ContainerRule.class);
		} else {
			m_component = componentOrRule;
		}
		m_model = Utils.getTop(componentOrRule);
	}

	/**
	 * @see SelectionStatusDialog#computeResult()
	 */
	protected void computeResult() {
		// nothing to do
	}

	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);
		// (parent, "Container rules", "Avail. extensions/interceptors");

		if(m_rulePropertiesOnly) {
			createRuleInfoGroup(contents);
			selectRule(m_currentRule);
		} else {
			createRuleSelectionGroup(contents);
			createRuleInfoGroup(contents);
		}
		return contents;
	}

	protected void createRuleSelectionGroup(Composite parent) {
		Composite ruleSelections = new Composite(parent, SWT.NONE);
		GridLayout grid = new GridLayout(1, true);
		GridData groupGridData = new GridData();
		// data3.widthHint = 400;
		// data3.heightHint = 300;
		groupGridData.grabExcessVerticalSpace = true;
		groupGridData.grabExcessHorizontalSpace = true;
		groupGridData.horizontalAlignment = GridData.FILL;
		groupGridData.verticalAlignment = GridData.FILL;
		ruleSelections.setLayout(grid);
		ruleSelections.setLayoutData(groupGridData);
		ruleSelections.setSize(400, 300);

		/*
		 * fRules = DialogUtils.createFilteredList (ruleSelGroup, new RuleLabelProvider(), 200, 200,
		 * SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		 */
		GridData data = new GridData(GridData.FILL_BOTH);
		data.heightHint = 150;
		data.widthHint = 200;

		ICheckStateListener checkListener = new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object obj = event.getElement();
				if(obj instanceof ContainerRule) {
					ContainerRule rule = (ContainerRule)obj;
					if(event.getChecked()) {
						applyRule(rule);
					}
					else {
						unapplyRule(rule);
					}
				}
			}
		};

		//
		// --------------- global rules -------------------
		//
		Group gRuleSelGroup = new Group(ruleSelections, SWT.BORDER);
		gRuleSelGroup.setText(" available rules ");
		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		gRuleSelGroup.setLayout(new GridLayout(1, false));
		gRuleSelGroup.setLayoutData(groupGridData);

		EList<ContainerRule> globalRuleList = Utils.getAllRules(m_model);
		//		Table table = new Table(gRuleSelGroup, SWT.CHECK);
		fRules = CheckboxTableViewer.newCheckList(gRuleSelGroup, SWT.BORDER);
		//		fRules = new CheckboxTableViewer(table);


		GridData data2 = new GridData(GridData.FILL_BOTH);
		data2.heightHint = 200;
		// data.widthHint = 200;
		fRules.getTable().setLayoutData(data);
		fRules.setLabelProvider(new RuleLabelProvider());
		fRules.setContentProvider(new ArrayContentProvider());

		fRules.setInput(globalRuleList.toArray());
		for(ContainerRule rule : globalRuleList) {
			if(isRuleApplied(rule)) {
				fRules.setChecked(rule, true);
			}
		}
		fRules.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = fRules.getSelection();
				if(selection instanceof StructuredSelection) {
					Object[] selected = ((StructuredSelection)selection).toArray();
					if((selected.length == 1) && (selected[0] instanceof ContainerRule)) {
						if(m_currentRule != selected[0]) {
							selectRule((ContainerRule)selected[0]);
						}
					}
				}
			}
		});
		fRules.addCheckStateListener(checkListener);
	}

	protected void createRuleInfoGroup(Composite parent) {
		GridData groupGridData = DialogUtils.createFillGridData();
		// data3.widthHint = 400;
		// data3.heightHint = 300;

		Group ruleInfoGroup = new Group(parent, SWT.BORDER);
		ruleInfoGroup.setText(" rule information ");
		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		ruleInfoGroup.setLayout(new GridLayout(2, false));
		ruleInfoGroup.setLayoutData(groupGridData);

		GridData span2 = new GridData();
		span2.horizontalSpan = 2;
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.grabExcessVerticalSpace = true;
		span2.verticalAlignment = GridData.FILL;
		span2.heightHint = 80;


		fDescription = new Text(ruleInfoGroup, SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);
		fDescription.setLayoutData(span2);
		//	createMessageArea (ruleInfoGroup);
		ruleInfoGroup.pack();
		// fPortLabel = new Label (ruleInfoGroup, SWT.NONE);
		// fPortLabel.setText ("for Ports");
		// fPortLabel.setEnabled (false);
	}

	/**
	 * Select a rule, i.e. update the visual representation from the rule
	 * 
	 * @param rule
	 */
	protected void selectRule(ContainerRule rule) {
		m_currentRule = rule;
		fDescription.setText(Description.getDescription(rule.getBase_Class()));
	}

	/**
	 * Helper: add a local container rule to the current class
	 * 
	 * @param name
	 *        the name of the local rule
	 * @return
	 */
	ContainerRule addRule(String name) {
		Class ruleCl = (Class)
			m_component.createNestedClassifier(name, UMLPackage.eINSTANCE.getClass_());
		StUtils.apply(ruleCl, ContainerRule.class);
		return UMLUtil.getStereotypeApplication(ruleCl, ContainerRule.class);
	}

	/**
	 * Helper function: delete a container rule from a class
	 * 
	 * @param rule
	 */
	void deleteRule(ContainerRule rule) {
		Classifier ruleCl = m_component.getNestedClassifier(rule.getBase_Class().getName());
		if(ruleCl instanceof Class) {
			ruleCl.destroy();
		}
	}

	/**
	 * Helper: apply a container rule to current component
	 * 
	 * @param rule
	 */
	void applyRule(ContainerRule rule) {
		if(!StUtils.isApplied(m_component, RuleApplication.class)) {
			StUtils.apply(m_component, RuleApplication.class);
		}
		RuleApplication containerConfig =
			UMLUtil.getStereotypeApplication(m_component, RuleApplication.class);
		containerConfig.getContainerRule().add(rule);
	}

	/**
	 * Helper: apply a container rule to current component
	 * 
	 * @param rule
	 */
	void unapplyRule(ContainerRule rule) {
		RuleApplication containerConfig =
			UMLUtil.getStereotypeApplication(m_component, RuleApplication.class);
		int index = containerConfig.getContainerRule().indexOf(rule);
		if((index >= 0) && (index < containerConfig.getContainerRule().size())) {
			containerConfig.getContainerRule().remove(index);
		}
	}

	/**
	 * check whether a container rule is applied
	 * h * @param rule
	 * 
	 * @return true, if container rule is applied
	 */
	boolean isRuleApplied(ContainerRule rule) {
		RuleApplication containerConfig =
			UMLUtil.getStereotypeApplication(m_component, RuleApplication.class);
		if(containerConfig != null) {
			return containerConfig.getContainerRule().contains(rule);
		}
		return false;
	}
}
