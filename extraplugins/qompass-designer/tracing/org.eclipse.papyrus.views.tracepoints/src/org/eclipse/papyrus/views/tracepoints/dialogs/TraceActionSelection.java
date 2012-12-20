/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.views.tracepoints.dialogs;

import java.util.Arrays;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.papyrus.infra.services.tracepoints.ITraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAAttribute;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAClass;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAOperation;
import org.eclipse.papyrus.infra.services.tracepoints.TraceActions.TAState;
import org.eclipse.papyrus.infra.services.tracepoints.TraceMechanism;
import org.eclipse.papyrus.infra.services.tracepoints.preferences.MultipleChoiceFieldEditor;
import org.eclipse.papyrus.infra.services.tracepoints.preferences.TPPreferenceConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

public class TraceActionSelection extends SelectionStatusDialog {

	protected CheckboxTableViewer fTraceActions;

	protected CheckboxTableViewer fTraceImplementations;

	protected Text fDescription;

	/**
	 * The model element that has a trace marker
	 */
	private Element m_me;

	public TraceActionSelection(Shell parent, IMarker marker, Element me) {
		super(parent);
		m_me = me;
		// int traceAction = marker.getAttribute(TracepointConstants.traceAction, 0);
	}


	/**
	 * @see SelectionStatusDialog#computeResult()
	 *      need to return two values: trace action & mechanism
	 */
	protected void computeResult() {
		// nothing to do
		int traceActionValue = 0;
		for(Object tableElement : fTraceActions.getCheckedElements()) {
			int index = ((Enum<?>)tableElement).ordinal();
			traceActionValue += 1 << index;
		};
		String traceMechanism = "";
		for(Object tableElement : fTraceImplementations.getCheckedElements()) {
			traceMechanism = (String)tableElement;
		};

		Object[] result = new Object[]{
			traceActionValue,
			traceMechanism
		};
		setResult(Arrays.asList(result));
	}

	class EnumLabelProvider extends LabelProvider implements ITableLabelProvider {

		public String getColumnText(Object obj, int index) {
			if(obj instanceof Enum) {
				return ((Enum<?>)obj).name();
			}
			return obj.toString();
		}

		public Image getColumnImage(Object obj, int index) {
			return null;
		}
	}

	class TraceActionCP implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			Object items[] = null;
			int i = 0;
			if(m_me instanceof Class) {
				items = new TAClass[TAClass.values().length];

				for(TAClass tLiteral : TAClass.values()) {
					items[i++] = tLiteral;
				}
			}
			else if(m_me instanceof Operation) {
				items = new TAOperation[TAOperation.values().length];
				for(TAOperation tLiteral : TAOperation.values()) {
					items[i++] = tLiteral;
				}
			}
			else if(m_me instanceof Property) {
				items = new TraceActions.TAAttribute[TraceActions.TAAttribute.values().length];
				for(TAAttribute tLiteral : TAAttribute.values()) {
					items[i++] = tLiteral;
				}
			}
			return items;
		}
	}

	class TraceMechanismsCP implements IStructuredContentProvider {

		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			Object items[] = null;
			//
			// Implementations of a tracing mechanism are depending on the injection mechanism and (likely) on the
			// programming language. Therefore, they are not part of this plugin shipped with Papyrus, but use an
			// extension mechanism.

			EList<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
			if(mechanisms.size() == 0) {
				items = new String[]{ "no plugins provide trace extension mechanism" };
			}
			else {
				EList<String> idList = new BasicEList<String>();
				for(ITraceMechanism mechanism : mechanisms) {
					for(String id : mechanism.getTraceMechanismIDs(m_me)) {
						idList.add(id);
					}
				}
				items = idList.toArray(new String[0]);
			}
			return items;
		}
	}

	public Control createDialogArea(Composite parent) {
		Composite contents = (Composite)super.createDialogArea(parent);

		Label label = new Label(contents, SWT.NONE);
		label.setText("Select trace action for this element");

		// need context dependent dialogs on options
		// we may need more than one options (e.g. AllOperations + OperationsWithParameters + (begin/end or both?))
		// clean way: accumulate all options, distribute them automatically accordingly. Better (even if less efficient, if strings)
		String[][] taClassOptions = new String[TAClass.values().length][2];
		String[][] taStateOptions = new String[TAState.values().length][2];
		int i;
		i = 0;
		for(TAClass tLiteral : TAClass.values()) {
			taClassOptions[i][1] = tLiteral.name();
			taClassOptions[i][0] = tLiteral.name();
			i++;
		}
		i = 0;
		for(TAState tLiteral : TAState.values()) {
			taStateOptions[i][1] = tLiteral.name();
			taStateOptions[i][0] = tLiteral.name();
			i++;
		}
		String[][] taOperationOptions = new String[TAOperation.values().length][2];
		i = 0;
		for(TAOperation tLiteral : TAOperation.values()) {
			taOperationOptions[i][1] = tLiteral.name();
			taOperationOptions[i][0] = tLiteral.name();
			i++;
		}

		new MultipleChoiceFieldEditor(TPPreferenceConstants.P_TRACE_OPTION_CLASS, "Class options", 3, taClassOptions, contents, true);

		fTraceActions = CheckboxTableViewer.newCheckList(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		fTraceActions.setContentProvider(new TraceActionCP());
		fTraceActions.setLabelProvider(new EnumLabelProvider());
		fTraceActions.setInput(this);

		// fTraceActions.setItems(items);

		fTraceActions.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				boolean isChecked = event.getChecked();
				if(isChecked) {
					Object traceCall = null;
					Object traceCallWP = null;

					for(Object checkedElement : fTraceActions.getCheckedElements()) {
						if(checkedElement == TAOperation.OnlyCall) {
							traceCall = checkedElement;
						}
						if(checkedElement == TAOperation.ParameterValues) {
							traceCallWP = checkedElement;
						}
					}
					if((traceCall != null) && (traceCallWP != null)) {
						// unset the element that was not checked by the event.
						if(element == traceCall) {
							fTraceActions.setChecked(traceCallWP, false);
						}
						else if(element == traceCallWP) {
							fTraceActions.setChecked(traceCall, false);
						}
					}
				}
			}
		});



		// need additional item how the trace mechanism should be realized, i.e. available tracing mechanisms
		fTraceImplementations = CheckboxTableViewer.newCheckList(parent, SWT.H_SCROLL | SWT.V_SCROLL);

		fTraceImplementations.setContentProvider(new TraceMechanismsCP());
		fTraceImplementations.setInput(this);

		fTraceImplementations.addCheckStateListener(new ICheckStateListener() {

			public void checkStateChanged(CheckStateChangedEvent event) {
				Object element = event.getElement();
				boolean isChecked = event.getChecked();
				// assure radio button functionality
				if(isChecked) {
					for(Object checkedElement : fTraceImplementations.getCheckedElements()) {
						if(checkedElement != element) {
							fTraceImplementations.setChecked(checkedElement, false);
						}
					}
				}
			}
		});

		fTraceImplementations.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if(selection instanceof IStructuredSelection) {
					Object first = ((IStructuredSelection)selection).getFirstElement();
					if(first instanceof String) {
						EList<ITraceMechanism> mechanisms = TraceMechanism.getTraceMechanisms();
						boolean noDesc = true;
						for(ITraceMechanism mechanism : mechanisms) {
							String description = mechanism.getTraceMechanismDescription(m_me, (String)first);
							if(description != null) {
								fDescription.setText(description);
								noDesc = false;
								break;
							}
						}
						if(noDesc) {
							fDescription.setText("<not available>");
						}
					}
				}
			}
		});

		fDescription = new Text(parent, SWT.WRAP | SWT.V_SCROLL | SWT.READ_ONLY);

		GridData span = new GridData();
		span.horizontalAlignment = GridData.FILL;
		span.grabExcessHorizontalSpace = true;
		span.grabExcessVerticalSpace = true;
		span.verticalAlignment = GridData.FILL;
		span.heightHint = 150;

		fTraceActions.getTable().setLayoutData(span);
		fTraceImplementations.getTable().setLayoutData(span);

		GridData span2 = new GridData();
		span2.horizontalAlignment = GridData.FILL;
		span2.grabExcessHorizontalSpace = true;
		span2.grabExcessVerticalSpace = true;
		span2.verticalAlignment = GridData.FILL;
		span2.heightHint = 80;
		fDescription.setLayoutData(span2);

		// ruleGroup.setLayout(new RowLayout (SWT.VERTICAL));
		parent.setLayout(new GridLayout(1, false));
		// parent.setLayoutData(groupGridData);
		return contents;
	}

	// obtain name and explicit/implicit node Allocation
	protected void setTextFromData(TreeItem ti) {
		Object data = ti.getData();
		if(data instanceof InstanceSpecification) {
			// ti.setText(new String[]{ name, nodeName, "[" + list + "]" });
		}
	}

	protected void refreshTree(TreeItem ti) {
		setTextFromData(ti);
		for(TreeItem subItem : ti.getItems()) {
			refreshTree(subItem);
		}
	}
}
