/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.eclipse.papyrus.uml.xtext.integration;

import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.papyrus.uml.xtext.integration.core.IXtextFakeContextResourcesProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Injector;

/**
 * This class integrates Xtext features into a {@link CellEditor} and can be
 * used e.g. in jFace {@link StructuredViewer}s or in GMF EditParts via
 * DirectEditManager.
 * 
 * The current implementation supports, code completion, syntax highlighting and
 * validation
 * 
 * @see XtextStyledTextProvider
 * 
 * @author andreas.muelder@itemis.de
 * @author alexander.nyssen@itemis.de
 * @author patrick.koenemann@itemis.de
 */
public class XtextStyledTextCellEditor extends StyledTextCellEditor {

	public static final String GTK = "gtk"; //$NON-NLS-1$
	
	protected Injector injector;
	protected StyledTextXtextAdapter xtextAdapter;
	protected StyledText styledText;
	
	protected IXtextFakeContextResourcesProvider contextFakeResourceProvider;
	protected IContextElementProvider provider;
	protected Shell startingShell;
	
	public XtextStyledTextCellEditor(int style, Injector injector,
			IXtextFakeContextResourcesProvider contextFakeResourceProvider) {
		this(style, injector);
		this.contextFakeResourceProvider = contextFakeResourceProvider;
	}

	public XtextStyledTextCellEditor(int style, Injector injector) {
		setStyle(style);
		this.injector = injector;
	}

	public XtextStyledTextCellEditor(int style, Injector injector, IContextElementProvider provider) {
		setStyle(style);
		this.provider = provider;
		this.injector = injector;
	}

	/**
	 * Creates an {@link SourceViewer} and returns the {@link StyledText} widget
	 * of the viewer as the cell editors control. Some code is copied from
	 * {@link XtextEditor}.
	 */
	@Override
	protected Control createControl(Composite parent) {
		styledText = (StyledText) super.createControl(parent);
		// a focus lost listener is already registered by the super-class, so no need to do this

		startingShell = styledText.getDisplay().getActiveShell();

		// adapt to xtext
		xtextAdapter = new StyledTextXtextAdapter(injector,
				contextFakeResourceProvider == null ? IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER
						: contextFakeResourceProvider);
		xtextAdapter.adapt(styledText);
		// adapt has created a completion proposal adapter. Retrieve this instead of creating a new one.
		completionProposalAdapter = xtextAdapter.getCompletionProposalAdapter();
		
		if (provider != null) {
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.add(new ContextElementAdapter(provider));
			if (provider instanceof IContextElementProviderWithInit) {
				// update resource, if required by text editor
				((IContextElementProviderWithInit) provider).initResource(
						xtextAdapter.getFakeResourceContext().getFakeResource());
			}
		}
		
		// This listener notifies the modification, when text is selected via
		// proposal. A ModifyEvent is not thrown by the StyledText in this case.
		xtextAdapter.getXtextSourceviewer().addTextListener(new ITextListener() {
			public void textChanged(TextEvent event) {
				editOccured(null);
			}
		});

		if ((styledText.getStyle() & SWT.SINGLE) != 0) {
			// The regular key down event is too late (after popup is closed
			// again).
			// when using the StyledText.VerifyKey event (3005), we get the
			// event early enough!
			styledText.addListener(3005, new Listener() {
				public void handleEvent(Event event) {
					if (event.character == SWT.CR && !completionProposalAdapter.isProposalPopupOpen()) {
						focusLost();
					}
				}
			});
		}
		final Listener cancelListener = new Listener() {
			public void handleEvent(Event event) {
				if (event.character == '\u001b' // ESC
						&& !completionProposalAdapter.delayedIsPopupOpen()) {
					XtextStyledTextCellEditor.this.fireCancelEditor();
				}
			}
		};

		styledText.addListener(3005, cancelListener);

		return styledText;
	}

	protected void keyReleaseOccured(KeyEvent keyEvent) {
		if (keyEvent.character == '\u001b') { // ESC
			return;
		}
		super.keyReleaseOccured(keyEvent);
	}

	@Override
	protected void doSetValue(Object value) {
		super.doSetValue(value);
		// Reset the undo manager to prevent deletion of complete text if the
		// user hits ctrl+z after cell editor opens
		xtextAdapter.sourceviewer.getUndoManager().reset();
	}

	@Override
	public boolean isUndoEnabled() {
		return true;
	}

	@Override
	public void performUndo() {
		xtextAdapter.sourceviewer.getUndoManager().undo();
	}

	@Override
	public boolean isRedoEnabled() {
		return true;
	}

	@Override
	public void performRedo() {
		xtextAdapter.sourceviewer.getUndoManager().redo();
	}

	@Override
	public boolean isFindEnabled() {
		return true;
	}

	// in gtk, we need this flag to let one focus lost event pass. See
	// focusLost() for details.
	boolean ignoreNextFocusLost = false;
	
	protected CompletionProposalAdapter completionProposalAdapter;

	/*
	 * In gtk, the focus lost event is fired _after_ the CR event, so we need to
	 * remember the state when the proposal popup window is open.
	 */
	@Override
	protected void focusLost() {
		if (completionProposalAdapter == null) {
			super.focusLost();
			return;
		}
		if (SWT.getPlatform().equals(GTK)) {
			if (ignoreNextFocusLost) {
				ignoreNextFocusLost = false;
				return;
			}

			if (completionProposalAdapter.isProposalPopupOpen()) {
				ignoreNextFocusLost = true;
				return;
			}
		}

		if (!completionProposalAdapter.isProposalPopupOpen()) {
			super.focusLost();
		}
	}

	@Override
	public void dispose() {
		xtextAdapter.dispose();
		super.dispose();
	}

	/*
	 * This is damn important! If we don't return false here, the
	 * ColumnEditorViewer calls applyEditorValue on FocusLostEvents!
	 */
	@Override
	protected boolean dependsOnExternalFocusListener() {
		return false;
	}

	public void setVisibleRegion(int start, int length) {
		xtextAdapter.setVisibleRegion(start, length);
	}

}
