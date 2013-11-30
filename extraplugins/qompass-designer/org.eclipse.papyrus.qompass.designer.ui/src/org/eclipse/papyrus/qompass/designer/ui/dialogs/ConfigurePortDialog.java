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

package org.eclipse.papyrus.qompass.designer.ui.dialogs;

import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.infra.widgets.editors.TreeSelectorDialog;
import org.eclipse.papyrus.infra.widgets.toolbox.utils.DialogUtils;
import org.eclipse.papyrus.qompass.designer.core.Description;
import org.eclipse.papyrus.qompass.designer.core.PortUtils;
import org.eclipse.papyrus.qompass.designer.core.Utils;
import org.eclipse.papyrus.qompass.designer.ui.Messages;
import org.eclipse.papyrus.uml.tools.providers.ServiceEditFilteredContentProvider;
import org.eclipse.papyrus.uml.tools.providers.UMLLabelProvider;
import org.eclipse.papyrus.uml.tools.utils.StereotypeUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Select container rules, either from a list of globally defined rules or from
 * local rules which may be created "on the fly" by this dialog.
 * 
 * TODO: extend rule application to instances (problematic, since rules
 * transformation is done on type level)
 * 
 * @author ansgar
 */
public class ConfigurePortDialog extends SelectionStatusDialog {

	protected Class m_component;

	protected Text fDescription;

	protected TableViewer fPortList;

	protected Port m_currentPort;

	protected Combo fKindCombo;

	protected EList<PortKind> portKindList;

	protected Label fType;

	protected Button fTypeButton;

	protected Label fProvided;

	protected Label fRequired;

	protected Package m_model;

	protected EList<Port> m_ports;

	public static final String COLON = ":"; //$NON-NLS-1$
	
	public ConfigurePortDialog(Shell parent) {
		super(parent);
	}

	public boolean init(Port port) {
		// visitedPackages = new BasicEList<Package> ();
		m_component = port.getClass_();
		m_currentPort = port; // preselect port (don't call selectPort before initialization of dialog area);
		m_model = Utils.getTop(m_component);
		m_ports = PortUtils.getAllPorts(m_component);
		return true;
	}

	public boolean init(Class clazz) {
		// visitedPackages = new BasicEList<Package> ();
		m_component = clazz;
		m_model = Utils.getTop(m_component);
		m_currentPort = null;
		m_ports = PortUtils.getAllPorts(m_component);
		return true;
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

		createPortConfigurationGroup(contents);
		if(m_currentPort != null) {
			int index = m_ports.indexOf(m_currentPort);
			if(index != -1) {
				fPortList.getTable().setSelection(index);
				selectPort(m_currentPort);
			}
		}
		return contents;
	}

	// create instance configuration group
	protected void createPortConfigurationGroup(Composite parent) {
		GridData groupGridData = DialogUtils.createFillGridData();

		// create grid data
		GridData gridData = DialogUtils.createFillGridData();
		GridData gridDataH80Span2 = DialogUtils.createFillGridData();
		gridDataH80Span2.horizontalSpan = 2;
		gridDataH80Span2.heightHint = 80;
		GridData gridDataH25Span2 = DialogUtils.createFillGridData();
		gridDataH25Span2.horizontalSpan = 2;
		gridDataH25Span2.heightHint = 25;
		GridData gridDataH60 = DialogUtils.createFillGridData();
		gridDataH60.heightHint = 60;
		GridData gridDataSpan2 = DialogUtils.createFillGridData();
		gridDataSpan2.horizontalSpan = 2;

		// fRuleName = new Text (ruleInfoGroup, SWT.NONE);
		Group portSelection = new Group(parent, SWT.BORDER);
		portSelection.setLayout(new GridLayout(1, false));
		// configL.setLayout(new RowLayout());

		portSelection.setText(" " + Messages.ConfigurePortDialog_AvailPorts + " "); //$NON-NLS-1$ //$NON-NLS-2$
		portSelection.setLayoutData(gridDataH60);

		fPortList = new TableViewer(portSelection, SWT.BORDER);
		fPortList.setLabelProvider(new PortLabelProvider());
		fPortList.setContentProvider(new ArrayContentProvider());
		fPortList.setInput(m_ports.toArray());
		fPortList.getTable().setLayoutData(gridDataH60);
		fPortList.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = fPortList.getSelection();
				if(selection instanceof StructuredSelection) {
					Object[] selected = ((StructuredSelection)selection)
						.toArray();
					if((selected.length == 1)
						&& (selected[0] instanceof Port)) {
						selectPort((Port)selected[0]);
					}
				}
			}
		});
		portSelection.pack();

		Group instanceConfigurationGroup = new Group(parent, SWT.BORDER);
		instanceConfigurationGroup.setText(" " + Messages.ConfigurePortDialog_AvailPorts + " ");  //$NON-NLS-1$ //$NON-NLS-2$
		instanceConfigurationGroup.setLayout(new GridLayout(2, false));
		instanceConfigurationGroup.setLayoutData(groupGridData);

		Label kindText = new Label(instanceConfigurationGroup, SWT.NONE);
		kindText.setText(Messages.ConfigurePortDialog_Kind + COLON);

		fKindCombo = new Combo(instanceConfigurationGroup, SWT.NONE);
		portKindList = getAvailableKinds(m_model);
		if (portKindList.size() == 0) {
			MessageDialog.openInformation(new Shell(), "No port kinds founds", "No port kinds are available. Please import a Qompass model library");
		}
		String[] portKindStrList = new String[portKindList.size() + 1];
		portKindStrList[0] = Messages.ConfigurePortDialog_None;
		for(int i = 0; i < portKindList.size(); i++) {
			portKindStrList[i + 1] = portKindList.get(i).getBase_Class().getName();
		}
		fKindCombo.setItems(portKindStrList);
		fKindCombo.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				// changePortKind
				org.eclipse.papyrus.FCM.Port fcmPort = StereotypeUtil.applyApp(m_currentPort, org.eclipse.papyrus.FCM.Port.class);
				if(fcmPort != null)
				{
					int index = fKindCombo.getSelectionIndex();
					if(index > 0) {
						PortKind kind = portKindList.get(index - 1);
						fcmPort.setKind(kind);
						selectPort(m_currentPort);
					}
					else {
						StereotypeUtil.unapply(m_currentPort, org.eclipse.papyrus.FCM.Port.class);
						selectPort(m_currentPort);
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		Label fTypeLabel = new Label(instanceConfigurationGroup, SWT.NONE);
		fTypeLabel.setText(Messages.ConfigurePortDialog_Type + COLON);
		fTypeLabel.setLayoutData(gridData);

		fType = new Label(instanceConfigurationGroup, SWT.NONE);
		fType.setLayoutData(gridData);

		fTypeButton = new Button(instanceConfigurationGroup, SWT.NONE);
		fTypeButton.setText(Messages.ConfigurePortDialog_ChangeType);
		fTypeButton.setLayoutData(gridDataH25Span2);
		fTypeButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				// use Papyrus type selection dialog ...
				TreeSelectorDialog tsd = new TreeSelectorDialog(new Shell());
				
				EStructuralFeature feature = UMLPackage.eINSTANCE.getTypedElement_Type();
				ServiceEditFilteredContentProvider contentProvider =
					new ServiceEditFilteredContentProvider(m_currentPort, feature, new EObject[] { m_model });

				EList<EClassifier> wantedMetaClasses = new BasicEList<EClassifier>();
				wantedMetaClasses.add(feature.getEType());
				// creates (indirect) dependency to org.eclipse.emf.facet.infra.browser.uicore.CustomizableModelContentProvider
				contentProvider.setWantedMetaclasses(wantedMetaClasses);
				contentProvider.setNotWantedMetaclasses(Collections.EMPTY_LIST);
				tsd.setContentProvider(contentProvider);
				tsd.setLabelProvider(new UMLLabelProvider());
				tsd.open();
				Object result[] = tsd.getResult();
				if((result != null) && (result.length == 1)) {
					// if(result[0] instanceof IAdaptable) {
					// Object type = ((IAdaptable)result[0]).getAdapter(EObject.class);
					Object type = result[0];
					if(type instanceof Type) {
						m_currentPort.setType((Type)type);
						selectPort(m_currentPort);
					}
				}
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// Label emptySpace = new Label(instanceConfigurationGroup, SWT.NONE);
		// emptySpace.setLayoutData(gridDataSpan2);


		// Composite derivedInterfaces = new Composite(instanceConfigurationGroup, SWT.NONE);
		Group derivedInterfaces = new Group(instanceConfigurationGroup, SWT.NONE);
		derivedInterfaces.setLayout(new GridLayout(2, false));

		// Label dil = new Label(derivedInterfaces, SWT.NONE);
		// dil.setText("Interfaces derived from port kind");
		derivedInterfaces.setText(Messages.ConfigurePortDialog_IntfDerived);
		// dil.setLayoutData(gridDataSpan2);
		derivedInterfaces.setLayoutData(gridDataSpan2);

		Label fProvidedLabel = new Label(derivedInterfaces, SWT.NONE);
		fProvidedLabel.setText(Messages.ConfigurePortDialog_Provided + COLON);
		fProvided = new Label(derivedInterfaces, SWT.NONE);
		fProvided.setLayoutData(gridData);

		Label fRequiredLabel = new Label(derivedInterfaces, SWT.NONE);
		fRequiredLabel.setText(Messages.ConfigurePortDialog_Required + COLON);
		fRequired = new Label(derivedInterfaces, SWT.NONE);
		fRequired.setLayoutData(gridData);
		derivedInterfaces.pack();

		fDescription = new Text(instanceConfigurationGroup, SWT.NONE | SWT.WRAP
			| SWT.V_SCROLL | SWT.READ_ONLY);
		fDescription.setLayoutData(gridDataH80Span2);
		// createMessageArea (ruleInfoGroup);
		instanceConfigurationGroup.pack();
		setEnabled(false);
	}

	/**
	 * Select a rule, i.e. update the visual representation from the rule
	 * 
	 * @param rule
	 */
	protected void selectPort(Port port) {
		m_currentPort = port;
		if(port == null) {
			setEnabled(false);
			return;
		}
		setEnabled(true);
		org.eclipse.papyrus.FCM.Port fcmPort = UMLUtil.getStereotypeApplication(port, org.eclipse.papyrus.FCM.Port.class);
		if(port.getType() != null) {
			fType.setText(port.getType().getQualifiedName());
		}
		else {
			fType.setText(Messages.ConfigurePortDialog_Undef);
		}
		if((fcmPort != null) && (fcmPort.getKind() != null)) {
			PortKind kind = fcmPort.getKind();
			if(portKindList.contains(kind)) {
				int index = portKindList.indexOf(kind) + 1;
				fKindCombo.select(index);
			}
			fDescription.setText(Description.getDescription(kind.getBase_Class(), Messages.ConfigurePortDialog_NotAvail));
			Interface providedI = PortUtils.getProvided(port);
			Interface requiredI = PortUtils.getRequired(port);
			fProvided.setText(providedI != null ? providedI.getQualifiedName() : Messages.ConfigurePortDialog_None);
			fRequired.setText(requiredI != null ? requiredI.getQualifiedName() : Messages.ConfigurePortDialog_None);
		}
		else {
			fProvided.setText(port.getProvideds().size() > 0 ? port.getProvideds().get(0).getQualifiedName() : Messages.ConfigurePortDialog_None);
			fRequired.setText(port.getRequireds().size() > 0 ? port.getRequireds().get(0).getQualifiedName() : Messages.ConfigurePortDialog_None);
			fKindCombo.select(0);
			fDescription.setText(""); //$NON-NLS-1$
		}
	}

	private void setEnabled(boolean enabled) {
		fDescription.setEnabled(enabled);
		if(!enabled) {
			fDescription.setText(""); //$NON-NLS-1$
		}
	}

	protected EList<PortKind> getAvailableKinds(Package pkg) {
		EList<PortKind> portKindList = new UniqueEList<PortKind>();
		EList<Package> visitedPackages = new BasicEList<Package>();
		getAvailableKinds(pkg, portKindList, visitedPackages);
		return portKindList;
	}

	protected void getAvailableKinds(Package pkg, EList<PortKind> portKindList, EList<Package> visitedPackages) {
		for(Element el : pkg.getMembers()) {
			if(el instanceof Package) {
				if(!visitedPackages.contains(el)) {
					visitedPackages.add((Package)el);
					getAvailableKinds((Package)el, portKindList, visitedPackages);
				}
			} else if(el instanceof Class) {
				PortKind portKind = UMLUtil.getStereotypeApplication((Class)el, PortKind.class);
				if(portKind != null) {
					portKindList.add(portKind);
				}
			}
		}
	}
}
