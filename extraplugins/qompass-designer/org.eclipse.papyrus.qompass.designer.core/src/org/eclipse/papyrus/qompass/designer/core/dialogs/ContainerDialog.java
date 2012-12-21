package org.eclipse.papyrus.qompass.designer.core.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

import FCM.ContainerRule;
import FCM.RuleApplication;

import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;

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
	protected Button fPropagate;

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
			// m_currentRule = StUtils.getApplication(componentOrRule, ContainerRule.class);
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
			createRuleApplicationGroup(contents);
			createRuleInfoGroup(contents);
		}
		return contents;
	}

	protected void createRuleApplicationGroup(Composite parent) {
		GridData groupGridData = DialogUtils.createFillGridData();

		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		Group ruleAppGroup = new Group(parent, SWT.BORDER);
		ruleAppGroup.setText(" rule application ");
		ruleAppGroup.setLayout(new GridLayout(1, false));
		ruleAppGroup.setLayoutData(groupGridData);

		fPropagate = new Button(ruleAppGroup, SWT.CHECK);
		fPropagate.setText("Propagate");
		fPropagate.setToolTipText("propagate rule to contained parts (sub-instances)");
		fPropagate.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent event) {
				updateConfigFromPropagateButton(m_currentRule);
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});
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

		// Add a column for propagate checkbox
		TableViewerColumn c1Viewer = new TableViewerColumn(fRules, SWT.CHECK, 0);
		TableColumn column1 = c1Viewer.getColumn();
		column1.setText("Propagate");
		column1.setWidth(50);
		c1Viewer.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return null;
			}

			@Override
			public Image getImage(Object element) {
				// if(true) {
				return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_ERROR);
				//} else {
				//	return JFaceResources.getImage(Dialog.DLG_IMG_MESSAGE_INFO);
				// }
			}
		});

		// TableViewerColumn c2Viewer = new TableViewerColumn(fRules, SWT.CHECK);
		// TableColumn column2 = c2Viewer.getColumn();
		// column2.setText("Propagate2");
		// column2.setWidth(50);


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
							updatePropagateButtonFromConfig(m_currentRule);
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

		fPropagate.setEnabled(false);
	}

	/**
	 * Select a rule, i.e. update the visual representation from the rule
	 * 
	 * @param rule
	 */
	protected void selectRule(ContainerRule rule) {
		m_currentRule = rule;
		fPropagate.setEnabled(true);
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
		return StUtils.getApplication(ruleCl, ContainerRule.class);
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
			StUtils.getApplication(m_component, RuleApplication.class);
		syncPropagateRuleSize(containerConfig);
		containerConfig.getContainerRule().add(rule);
		containerConfig.getPropagateRule().add(fPropagate.getSelection());
	}

	/**
	 * synchronize size of ContainerRule and PropagateRule lists (they can get out of
	 * sync due to manual manipulation via generic profile view or broken models)
	 * 
	 * @param containerConfig
	 *        container configuration for current element
	 */
	void syncPropagateRuleSize(RuleApplication containerConfig) {
		int size = containerConfig.getContainerRule().size();
		while(containerConfig.getPropagateRule().size() < size) {
			containerConfig.getPropagateRule().add(false);
		}
		while(containerConfig.getPropagateRule().size() > size) {
			containerConfig.getPropagateRule().remove(size);
		}
	}

	/**
	 * Helper: apply a container rule to current component
	 * 
	 * @param rule
	 */
	void unapplyRule(ContainerRule rule) {
		RuleApplication containerConfig =
			StUtils.getApplication(m_component, RuleApplication.class);
		int index = containerConfig.getContainerRule().indexOf(rule);
		if((index >= 0) && (index < containerConfig.getContainerRule().size())) {
			containerConfig.getContainerRule().remove(index);
		}
		if((index >= 0) && (index < containerConfig.getPropagateRule().size())) {
			containerConfig.getPropagateRule().remove(index);
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
			StUtils.getApplication(m_component, RuleApplication.class);
		if(containerConfig != null) {
			return containerConfig.getContainerRule().contains(rule);
		}
		return false;
	}

	/**
	 * Update the propagation button from the container config (for a specific rule)
	 * 
	 * @param rule
	 */
	void updatePropagateButtonFromConfig(ContainerRule rule) {
		RuleApplication containerConfig =
			StUtils.getApplication(m_component, RuleApplication.class);
		// update propagation status
		if(containerConfig == null) {
			fPropagate.setSelection(false);
		}
		else {
			int index = containerConfig.getContainerRule().indexOf(rule);
			if(index >= 0 && index < containerConfig.getPropagateRule().size()) {
				fPropagate.setSelection(containerConfig.getPropagateRule().get(index));
			}
			else {
				// rule is not applied
				fPropagate.setSelection(false);
			}
		}
	}

	/**
	 * Update the container info from propagate button (for a specific rule)
	 * 
	 * @param rule
	 */
	void updateConfigFromPropagateButton(ContainerRule rule) {
		RuleApplication containerConfig =
			StUtils.getApplication(m_component, RuleApplication.class);
		// update propagation status
		syncPropagateRuleSize(containerConfig);
		int index = containerConfig.getContainerRule().indexOf(rule);
		if(index >= 0 && index < containerConfig.getPropagateRule().size()) {
			containerConfig.getPropagateRule().set(index, fPropagate.getSelection());
		}
	}

}
