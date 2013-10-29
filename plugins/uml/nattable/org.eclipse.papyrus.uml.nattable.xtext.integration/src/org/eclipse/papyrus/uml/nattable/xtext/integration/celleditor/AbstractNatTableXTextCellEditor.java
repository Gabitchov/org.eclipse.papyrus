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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.xtext.integration.celleditor;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.extensionpoints.editors.configuration.ICustomDirectEditorConfiguration;
import org.eclipse.papyrus.infra.nattable.celleditor.AbstractPapyrusStyledTextCellEditor;
import org.eclipse.papyrus.infra.nattable.manager.table.ITableAxisElementProvider;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;
import org.eclipse.papyrus.uml.nattable.xtext.integration.util.XTextEditorResultWrapper;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.XtextFakeResourceContext;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author vl222926
 * 
 */
public abstract class AbstractNatTableXTextCellEditor extends AbstractPapyrusStyledTextCellEditor {

	protected DefaultXtextDirectEditorConfiguration xTextConfiguration;

	/**
	 * the JFace cellEditor
	 */
	protected CellEditor jfaceCellEditor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 * @param moveSelectionOnEnter
	 */
	public AbstractNatTableXTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider, final boolean commitOnUpDown, final boolean moveSelectionOnEnter) {
		super(table, axisElement, elementProvider, commitOnUpDown, moveSelectionOnEnter);
		this.commitOnEnter = false;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 * @param commitOnUpDown
	 */
	public AbstractNatTableXTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider, boolean commitOnUpDown) {
		this(table, axisElement, elementProvider, commitOnUpDown, false);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param table
	 * @param axisElement
	 * @param elementProvider
	 */
	public AbstractNatTableXTextCellEditor(final Table table, final Object axisElement, final ITableAxisElementProvider elementProvider) {
		this(table, axisElement, elementProvider, false);
	}

	/**
	 * 
	 * @return
	 *         the XText DirectEditor Configuration
	 */
	protected abstract DefaultXtextDirectEditorConfiguration createXTextEditorConfiguration();

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#activateCell(org.eclipse.swt.widgets.Composite,
	 *      java.lang.Object)
	 * 
	 * @param parent
	 * @param originalCanonicalValue
	 * @return
	 */
	protected Control activateCell(final Composite parent, final Object originalCanonicalValue) {
		//we display the full string which have a problem to display it in the Xtext Editor
		Object value = originalCanonicalValue;
		if(originalCanonicalValue instanceof List<?>) {
			if(((List<?>)originalCanonicalValue).size() > 0) {
				final Object firstValue = ((List<?>)originalCanonicalValue).get(0);
				if(firstValue instanceof StringResolutionProblem) {
					value = ((StringResolutionProblem)firstValue).getValueAsString();
				}
			}
		}
		return super.activateCell(parent, value);
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#createStyledText(org.eclipse.swt.widgets.Composite, int)
	 * 
	 * @param parent
	 * @param style
	 * @return
	 */
	@Override
	protected StyledText createStyledText(Composite parent, int style) {
		//add me as parameter!
		this.xTextConfiguration = createXTextEditorConfiguration();

		final EObject editedObject = getEditedEObject();

		//must be done here!
		XtextFakeResourceContext context = new XtextFakeResourceContext(xTextConfiguration.getInjector());
		IContextElementProvider provider = new IContextElementProvider() {

			public EObject getContextObject() {
				return editedObject;
			}
		};
		context.getFakeResource().eAdapters().add(new ContextElementAdapter(provider));
		jfaceCellEditor = xTextConfiguration.createCellEditor(parent, editedObject);
		return (StyledText)jfaceCellEditor.getControl();
	}

	/**
	 * Creates the editor control that is wrapped by this ICellEditor.
	 * Will use the style configurations in ConfigRegistry for styling the control.
	 * 
	 * @param parent
	 *        The Composite that will be the parent of the new editor control.
	 *        Can not be <code>null</code>
	 * @param style
	 *        The SWT style of the text control to create.
	 * @return The created editor control that is wrapped by this ICellEditor.
	 */
	protected StyledText createEditorControl(final Composite parent, int style) {
		final StyledText textControl = super.createEditorControl(parent, style);
		textControl.setVisible(true);
		return textControl;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.celleditor.AbstractStyledTextCellEditor#getEditorValue()
	 * 
	 * @return
	 */
	@Override
	public Object getEditorValue() {
		final IParser parser = ((ICustomDirectEditorConfiguration)xTextConfiguration).createParser(getEditedEObject());
		final StyledText styledText = ((StyledText)jfaceCellEditor.getControl());
		ICommand parseCommand = null;
		String typedString = "";
		if(styledText != null) {
			typedString = styledText.getText();
			final IParserEditStatus result = parser.isValidEditString(null, typedString);
			if(result!=null && result.isOK()) {
				parseCommand = parser.getParseCommand(null, typedString, 0);
			}
		}
		return new XTextEditorResultWrapper(typedString, parseCommand);
	}

	@Override
	public void close() {
		//TODO requred?
//		jfaceCellEditor.deactivate();
//		jfaceCellEditor.dispose();
	}

}
