/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.uml.widgets;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.properties.modelelement.DataSource;
import org.eclipse.papyrus.properties.uml.expression.ExpressionList;
import org.eclipse.papyrus.properties.uml.expression.ExpressionList.Expression;
import org.eclipse.papyrus.properties.uml.messages.Messages;
import org.eclipse.papyrus.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


public class ExpressionEditor extends AbstractPropertyEditor implements Listener, ISelectionChangedListener {

	private final ExpressionLanguageEditor languageEditor;

	private final Composite bodyEditorContainer;

	private IObservableList bodies;

	private Expression currentExpression = null;

	private DynamicBodyEditor bodyEditor;

	public ExpressionEditor(Composite parent, int style) {

		languageEditor = new ExpressionLanguageEditor(parent, SWT.NONE);

		bodyEditorContainer = new Composite(parent, SWT.NONE);
		bodyEditorContainer.setLayout(new FillLayout());

		bodyEditor = new DynamicBodyEditor(bodyEditorContainer, style);
		bodyEditor.setLabel(Messages.ExpressionEditor_BodyLabel);
		bodyEditor.addChangeListener(this);

		languageEditor.getViewer().addSelectionChangedListener(this);

		setEditor(languageEditor);
	}

	@Override
	public void setInput(DataSource input) {
		bodies = (IObservableList)input.getObservable("UML:OpaqueExpression:body"); //$NON-NLS-1$
		super.setInput(input);
	}

	@Override
	protected void doBinding() {
		super.doBinding();
		languageEditor.addCommitListener((ExpressionList)observableList);
		bodyEditor.setContext(input.getModelElement(propertyPath));

		if(languageEditor.getViewer().getList().getItemCount() > 0) {
			Object firstItem = languageEditor.getViewer().getElementAt(0);
			StructuredSelection selection = new StructuredSelection(firstItem);
			languageEditor.getViewer().setSelection(selection);
		}
	}

	/**
	 * @return the IObservableList for this propertyEditor, or null if it is not
	 *         available
	 */
	@Override
	protected IObservableList getInputObservableList() {
		if(observableList == null) {
			observableList = new ExpressionList(super.getInputObservableList(), bodies);
		}

		return observableList;
	}

	public void handleEvent(Event event) {
		String newValue = bodyEditor.getValue();
		if(newValue == null) {
			return;
		}

		currentExpression.setBody(newValue);
		((ExpressionList)observableList).commit(bodyEditor);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection selection = event.getSelection();

		if(!selection.isEmpty() && selection instanceof IStructuredSelection) {
			IStructuredSelection sSelection = (IStructuredSelection)selection;
			currentExpression = (Expression)sSelection.getFirstElement();

			bodyEditor.display(currentExpression);
		}
	}

	@Override
	protected void applyReadOnly(boolean readOnly) {
		languageEditor.setReadOnly(readOnly);
		bodyEditor.setReadOnly(readOnly);
	}
}
