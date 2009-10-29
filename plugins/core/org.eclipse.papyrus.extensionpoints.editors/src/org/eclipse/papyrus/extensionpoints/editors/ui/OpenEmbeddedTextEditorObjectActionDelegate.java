/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * This action implementation is an abstract implementation of an object contribution action that
 * opens a TEF editor window within a host editor. Inheriting concrete implementations have to
 * provide the EMF object to be edited, the position of the editor window, access to the hosting GUI
 * control and edit part.
 */
public abstract class OpenEmbeddedTextEditorObjectActionDelegate implements IObjectActionDelegate {

	/** part in which the editor is embedded */
	protected IWorkbenchPart part = null;

	/** the configuration for the embedded editor */
	private DirectEditorExtensionPoint directEditorExtensionPoint;

	/**
	 * Returns the edited EObject
	 * 
	 * @return the EObject edited in the editor. It should never be <code>null</code>.
	 */
	protected abstract EObject getEditedObject();

	/**
	 * Retrieves the position where the editor should be opened.
	 * 
	 * @return the position of the shell containing the editor
	 */
	// @unused
	protected abstract Point getPosition();

	/**
	 * Retrieves the editor context
	 * 
	 * @return the context for the current editor
	 */
	// protected abstract IEditorContext getEditorContext();

	/**
	 * Returns the editor's main control
	 * 
	 * @return the editor's main control
	 */
	// @unused
	protected abstract Control getControl();

	/**
	 * {@inheritDoc}
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		part = targetPart;
	}

	/**
	 * {@inheritDoc}
	 */
	public void run(IAction action) {
		// retrieves graphical context (in which shell it should open for
		// exemple)

		final IDirectEditorConfiguration configuration = directEditorExtensionPoint.getDirectEditorConfiguration();
		configuration.preEditAction(getEditedObject());

		final ExtendedDirectEditionDialog dialog = new ExtendedDirectEditionDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell(), getEditedObject(), configuration
				.getTextToEdit(getEditedObject()), configuration);
		if (Window.OK == dialog.open()) {
			TransactionalEditingDomain domain = ((DiagramEditor) part).getEditingDomain();
			RecordingCommand command = new RecordingCommand(domain, "Edit Label") {

				@Override
				protected void doExecute() {
					configuration.postEditAction(getEditedObject(), dialog.getValue());

				}
			};
			domain.getCommandStack().execute(command);
		}
	}

	/**
	 * Sets the configuration for the editor
	 * 
	 * @param configuration
	 *            the configuration for the specified editor
	 */
	public void setExtensionPointConfiguration(DirectEditorExtensionPoint directEditorExtensionPoint) {
		this.directEditorExtensionPoint = directEditorExtensionPoint;
	}

	/**
	 * Returns the parent composite for the new embedded editor
	 * 
	 * @return the parent composite for the new embedded editor
	 */
	// @unused
	protected abstract Composite getParentComposite();

	/**
	 * Creates the editor in the given shell
	 * 
	 * @param shell
	 *            the shell parent of the editor composite
	 * @return the created EmbeddedTextEditor
	 */
	// @unused
	protected EmbeddedTextEditor createEditor(Composite composite) {
		// retrieves the source viewer configuration
		final CoreMultiDiagramEditor multiDiagramEditor = (CoreMultiDiagramEditor) part.getSite().getPage()
				.getActiveEditor();
		TransactionalEditingDomain domain = multiDiagramEditor.getDefaultContext().getTransactionalEditingDomain();
		DiagramCommandStack diagramCommandStack = multiDiagramEditor.getDiagramEditDomain().getDiagramCommandStack();
		return new EmbeddedTextEditor(directEditorExtensionPoint.getDirectEditorConfiguration(), diagramCommandStack,
				domain);
	}

	/**
	 * Returns whether the widget is <code>null</code> or disposed or active.
	 * 
	 * @param widget
	 *            the widget to check
	 * @return <code>true</code> if the widget can be used
	 */
	// @unused
	public static boolean isValid(Widget widget) {
		return (widget != null && !widget.isDisposed());
	}

}
