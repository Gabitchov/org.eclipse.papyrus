/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;

/**
 * Main class for embedded editors.
 */
public class EmbeddedTextEditor extends TextEditor {

	/** Close listener for this embedded editor */
	protected CloseListener closeListener;

	/** save site selection provider( bug with multi-page editor...) */
	private ISelectionProvider provider;

	/** editor configuration */
	private final IDirectEditorConfiguration directEditorConfiguration;

	/** nested editor command stack */
	private final DiagramCommandStack diagramCommandStack;

	/** transactional editing domain from the backbone */
	private final TransactionalEditingDomain transactionalEditingDomain;

	/**
	 * Creates a new EmbeddedTextEditor.
	 */
	public EmbeddedTextEditor(IDirectEditorConfiguration directEditorConfiguration,
			DiagramCommandStack diagramCommandStack, TransactionalEditingDomain transactionalEditingDomain) {
		super();
		this.directEditorConfiguration = directEditorConfiguration;
		this.diagramCommandStack = diagramCommandStack;
		this.transactionalEditingDomain = transactionalEditingDomain;
		initialiseSourceViewerConfiguration();
		initialiseDocumentProvider();
	}

	/**
	 * Returns the configuration for this editor
	 * 
	 * @return the configuration for this editor
	 */
	public IDirectEditorConfiguration getDirectEditorConfiguration() {
		return directEditorConfiguration;
	}

	private void initialiseCompletionListener(SourceViewer sourceViewer) {
		sourceViewer.prependVerifyKeyListener(new LabelKeyListener(sourceViewer));
		sourceViewer.getControl().addTraverseListener(new ControlListener(sourceViewer));
	}

	/**
	 * Sets the source viewer configuration for this editor
	 */
	protected void initialiseSourceViewerConfiguration() {
		setSourceViewerConfiguration(directEditorConfiguration.getSourceViewerConfiguration());
	}

	/**
	 * Sets the document provider for this editor
	 */
	protected void initialiseDocumentProvider() {
		setDocumentProvider(new EmbeddedEditorDocumentProvider(this));
	}

	/**
	 * Adds a close listener to the editor, i.e. when the editor should be closed
	 */
	// @unused
	public void setCloseListener(CloseListener closeListener) {
		this.closeListener = closeListener;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close(boolean save) {
		// restore saved previous provider
		getSite().setSelectionProvider(provider);

		closeListener.close();

		if(save) {
			// get command stack of the 'parent' editor
			Command command = new ICommandProxy(new AbstractTransactionalCommand(transactionalEditingDomain,
					"Edit property", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
						throws ExecutionException {
					return CommandResult.newOKCommandResult(((EmbeddedEditorDocumentProvider)getDocumentProvider())
							.applyChanges(getEditorInput()));
				}
			});
			diagramCommandStack.execute(command, new NullProgressMonitor());
		}

		super.close(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ISourceViewer createSourceViewer(Composite parent, IVerticalRuler ruler, int styles) {
		// overrides styles
		fAnnotationAccess = getAnnotationAccess();
		fOverviewRuler = createOverviewRuler(getSharedColors());

		SourceViewer viewer = new SourceViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(),
				SWT.FULL_SELECTION | SWT.BORDER);
		// ensure decoration support has been created and configured.
		getSourceViewerDecorationSupport(viewer);

		initialiseCompletionListener(viewer);

		return viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		provider = site.getSelectionProvider();
		super.init(site, input);
	}

	/**
	 * Listener to process completion
	 */
	private class LabelKeyListener implements VerifyKeyListener {

		/**
		 * the viewer to listen
		 */
		SourceViewer viewer;

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 *        the viewer to listen
		 */
		public LabelKeyListener(SourceViewer viewer) {
			this.viewer = viewer;
		}

		/**
		 * {@inheritDoc}
		 */
		public void verifyKey(VerifyEvent event) {
			if(event.stateMask == SWT.CTRL) {
				switch(event.character) {
				case ' ':
					callOperation(event, ISourceViewer.CONTENTASSIST_PROPOSALS);
					break;
				case '1':
					callOperation(event, ISourceViewer.QUICK_ASSIST);
					break;
				// case 'c':
				// callOperation(event, SourceViewer.COPY);
				// break;
				// case 'x':
				// callOperation(event, SourceViewer.CUT);
				// break;
				// case 'v':
				// callOperation(event, SourceViewer.PASTE);
				// break;
				// case 'y':
				// callOperation(event, SourceViewer.REDO);
				// break;
				default:
					// no success using key event 'z' or 'y' : using keycode
					// instead...
					switch(event.keyCode) {
					case 122: // z
						callOperation(event, ITextOperationTarget.UNDO);
						break;
					case 121: // y
						callOperation(event, ITextOperationTarget.REDO);
						break;
					default:
						break;
					}
				}
			} else if(event.character == SWT.CR) {
				EmbeddedTextEditor.this.close(true);
				event.doit = false;
			} else if(event.character == SWT.DEL) {
				if(viewer.canDoOperation(ITextOperationTarget.DELETE)) {
					viewer.doOperation(ITextOperationTarget.DELETE);
				}
			}
		}

		/**
		 * Try to call the specified operation on the viewer
		 * 
		 * @param event
		 *        the event to check
		 * @param code
		 *        the code of the operation to call
		 */
		private void callOperation(VerifyEvent event, int code) {
			if(viewer.canDoOperation(code)) {
				viewer.doOperation(code);
			}
			event.doit = false;
		}
	}

	/**
	 * Listener to process completion
	 */
	private class ControlListener implements TraverseListener {

		/**
		 * the viewer to listen
		 */
		SourceViewer viewer;

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 *        the viewer to listen
		 */
		public ControlListener(SourceViewer viewer) {
			this.viewer = viewer;
		}

		/**
		 * {@inheritDoc}
		 */
		public void keyTraversed(TraverseEvent e) {
			EmbeddedTextEditor.this.closeListener.keyTraversed(e);
		}
	}

}
