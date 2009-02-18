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

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.jface.action.IAction;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.definition.DirectEditorExtensionPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

/**
 * This action implementation is an abstract implementation of an object
 * contribution action that opens a TEF editor window within a host editor.
 * Inheriting concrete implementations have to provide the EMF object to be
 * edited, the position of the editor window, access to the hosting GUI control
 * and edit part.
 */
public abstract class OpenEmbeddedTextEditorObjectActionDelegate implements IObjectActionDelegate {

	/** part in which the editor is embedded */
	protected IWorkbenchPart part = null;
	
	/** the configuration for the embedded editor */
	private DirectEditorExtensionPoint directEditorExtensionPoint;

	/** 
	 * Returns the edited EObject
	 * @return the EObject edited in the editor. It should never be <code>null</code>.
	 */
	protected abstract EObject getEditedObject();

	/** 
	 * Retrieves the position where the editor should be opened.
	 * @return the position of the shell containing the editor
	 */
	protected abstract Point getPosition();

	/**
	 * Retrieves the editor context 
	 * @return the context for the current editor
	 */
	// protected abstract IEditorContext getEditorContext();

	/** 
	 * Returns the editor's main control
	 * @return the editor's main control
	 */
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
		try {
			// retrieves graphical context (in which shell it should open for exemple)
			final Shell fShell = part.getSite().getShell();
			
			IDirectEditorConfiguration configuration = directEditorExtensionPoint.getDirectEditorConfiguration();
			configuration.preEditAction(getEditedObject());
			
			// creates new editor
			EmbeddedTextEditor editor = createEditor(null);
			
			// init before display
			editor.init(
					(IEditorSite)part.getSite(), 
					new EmbeddedEditorInput(((URIEditorInput)((IEditorPart)part).getEditorInput()).getURI(), getEditedObject())
			);
			// creates displays part
			
			// creates a new shell 
			Shell hostShell = new Shell(fShell, SWT.RESIZE);
			hostShell.setLayout(new FillLayout());
			Point position = getPosition();
			hostShell.setLocation(position.x, position.y+50);
			
			editor.createPartControl(hostShell);
			hostShell.pack();
			hostShell.setSize(300, 22);

			// displays the shell and set focus
			hostShell.setVisible(true);
			hostShell.setFocus();
			
			// finally, listens now to modification to the parent editor control to know when to close the embedded editor
			IDiagramGraphicalViewer viewer = ((DiagramEditor)part).getDiagramGraphicalViewer();
			if(viewer !=null) {
				editor.setCloseListener(new CloseListener(viewer.getControl(), editor, hostShell));
			} else {
				Activator.log("Could not get the parent control of the current parent editor. The embedded editor will probavly won't close");
			}
			
			// fix for a bug that makes the first input key not taken into account
			editor.validateEditorInputState();
			
		} catch (PartInitException e) {
			Activator.log(e);
		}
	}
	
	/**
	 * Sets the configuration for the editor 
	 * @param configuration the configuration for the specified editor
	 */
	public void setExtensionPointConfiguration(DirectEditorExtensionPoint directEditorExtensionPoint) {
		this.directEditorExtensionPoint = directEditorExtensionPoint;
	}

	/**
	 * Returns the parent composite for the new embedded editor
	 * @return the parent composite for the new embedded editor
	 */
	protected abstract Composite getParentComposite();

	/**
	 * Creates the editor in the given shell
	 * @param shell the shell parent of the editor composite
	 * @return the created EmbeddedTextEditor
	 */
	protected EmbeddedTextEditor createEditor(Composite composite) {
		// retrieves the source viewer configuration
		final CoreMultiDiagramEditor multiDiagramEditor = (CoreMultiDiagramEditor)part.getSite().getPage().getActiveEditor();
		TransactionalEditingDomain domain = multiDiagramEditor.getDefaultContext().getTransactionalEditingDomain();
		DiagramCommandStack diagramCommandStack = multiDiagramEditor.getDiagramEditDomain().getDiagramCommandStack();
		return new EmbeddedTextEditor(directEditorExtensionPoint.getDirectEditorConfiguration(), diagramCommandStack, domain );
	}	

	/**
	 * Returns whether the widget is <code>null</code> or disposed or active.
	 * @param widget the widget to check
	 * @return <code>true</code> if the widget can be used
	 */
	public static boolean isValid(Widget widget) {
		return (widget != null && !widget.isDisposed());
	}
	
}

