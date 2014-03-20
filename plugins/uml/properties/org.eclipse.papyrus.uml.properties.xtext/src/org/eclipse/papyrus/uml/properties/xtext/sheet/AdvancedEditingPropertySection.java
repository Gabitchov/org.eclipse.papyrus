/*****************************************************************************
 * Copyright (c) 2013, 2014 Itemis AG, CEA LIST, and others.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Itemis -  Initial API and implementation
 *  Ansgar Radermacher - added undo/redo support (inspired by code from Petr Bodnar)
 *  Christian W. Damus (CEA) - bug 323802
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.properties.xtext.sheet;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.properties.xtext.UndoRedoStack;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.StyledTextXtextAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ExtendedModifyEvent;
import org.eclipse.swt.custom.ExtendedModifyListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * Attention: class has been deactivated, since the additional tab is redundant with the
 * body editor in the standard UML property tab.
 */
public class AdvancedEditingPropertySection extends
		AbstractModelerPropertySection implements IContextElementProvider {

	private FormToolkit toolkit;

	private Form form;

	private StyledText textControl;

	private DefaultXtextDirectEditorConfiguration configuration;

	private StyledTextXtextAdapter xtextAdapter;

	final private ContextElementAdapter contextElementAdapter = new ContextElementAdapter(
			this);

	UndoRedoStack<ExtendedModifyEvent> undoRedoStack;
	
	protected boolean isUndo;

	protected boolean isRedo;

	protected EObject currentEObj;
	
	public AdvancedEditingPropertySection() {
		undoRedoStack = new UndoRedoStack<ExtendedModifyEvent>();
		ModelListener.currentEditor = this;
	}
	
	@Override
	public void refresh() {
		updateXtextAdapters(textControl);

		IParser parser = getParser();
		if (parser != null) {
			String printString = parser.getEditString(null, 0);
			textControl.setText(printString);
		}

		if (textControl != null) {
			textControl.setEnabled(!isReadOnly());
		}
	}

	@Override
	public void aboutToBeHidden() {
		super.aboutToBeHidden();
		if (xtextAdapter != null) {
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.remove(contextElementAdapter);
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		ModelListener.currentEditor = null;
		if (toolkit != null)
			toolkit.dispose();
	}

	@Override
	public final void createControls(Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.setBorderStyle(SWT.BORDER);
		super.createControls(parent, aTabbedPropertySheetPage);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(parent);
		parent.setLayout(new GridLayout(1, true));
		form = toolkit.createForm(parent);
		toolkit.decorateFormHeading(form);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(form);
		form.getBody().setLayout(new GridLayout(1, false));
		createTextControl(form.getBody());
	}

	
	protected void createTextControl(final Composite parent) {

		textControl = new StyledText(parent, SWT.MULTI | SWT.BORDER
				| SWT.V_SCROLL | SWT.WRAP);

		textControl.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				IParser parser = getParser();
				if (xtextAdapter.getCompletionProposalAdapter().delayedIsPopupOpen()) {
					// ignore focus lost
					return;
				}
				if ((parser != null) &&	!parser.getEditString(null, 0).equals(textControl.getText())) {
					ICommand command = parser.getParseCommand(
							new EObjectAdapter(getEObject()),
							textControl.getText(), 0);

					getEditingDomain().getCommandStack().execute(
							new GMFtoEMFCommandWrapper(command));
				}
			}

			public void focusGained(FocusEvent e) {
			}
		});
		
		textControl.setAlwaysShowScrollBars(false);
		GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize())
				.applyTo(textControl);
		textControl.addExtendedModifyListener(new ExtendedModifyListener() {
			
			public void modifyText(ExtendedModifyEvent event) {
				if (isUndo) {
					undoRedoStack.pushRedo(event);
				} else { // is Redo or a normal user action
					undoRedoStack.pushUndo(event);
					if (!isRedo) {
						undoRedoStack.clearRedo();
						// TODO Switch to treat consecutive characters as one event?
					}
				}
			}
		});

		textControl.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				boolean isCtrl = (e.stateMask & SWT.CTRL) > 0;
				boolean isAlt = (e.stateMask & SWT.ALT) > 0;
				if (isCtrl && !isAlt) {
					boolean isShift = (e.stateMask & SWT.SHIFT) > 0;
					if (e.keyCode == 'z') {
						if (isShift) {
							redo();
		            	}
						else {
							undo();
						}
					}
				}
			}
		});
	}

	protected void undo() {
		if (undoRedoStack.hasUndo()) {
			isUndo = true;
			revertEvent(undoRedoStack.popUndo());
			isUndo = false;
		}
	}

	protected void redo() {
		if (undoRedoStack.hasRedo()) {
			isRedo = true;
			revertEvent(undoRedoStack.popRedo());
			isRedo = false;
		}
	}

	/**
	 * Reverts the given modify event, in the way as the Eclipse text editor
	 * does it.
	 * 
	 * @param event
	 */
	private void revertEvent(ExtendedModifyEvent event) {
		textControl.replaceTextRange(event.start, event.length, event.replacedText);
		// (causes the modifyText() listener method to be called)
		
		textControl.setSelectionRange(event.start, event.replacedText.length());
	}
	
	 
	protected DefaultXtextDirectEditorConfiguration getConfigurationFromSelection() {
		EObject semanticElement = getSemanticObjectFromSelection();
		if (semanticElement != null) {
			IPreferenceStore store = Activator.getDefault()
					.getPreferenceStore();
			String semanticClassName = semanticElement.eClass()
					.getInstanceClassName();
			String key = IDirectEditorsIds.EDITOR_FOR_ELEMENT
					+ semanticClassName;
			String languagePreferred = store.getString(key);

			if (languagePreferred != null && !languagePreferred.equals("")) { //$NON-NLS-1$
				IDirectEditorConfiguration configuration = DirectEditorsUtil
						.findEditorConfiguration(languagePreferred,
								semanticClassName);
				if (configuration instanceof DefaultXtextDirectEditorConfiguration) {
					
					DefaultXtextDirectEditorConfiguration xtextConfiguration = (DefaultXtextDirectEditorConfiguration) configuration;
					xtextConfiguration.preEditAction(semanticElement);
					return xtextConfiguration;
				}
			}
		}
		return null;
	}

	protected EObject getSemanticObjectFromSelection() {
		Object selection = getPrimarySelection();
		if (selection instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart) selection).resolveSemanticElement();
		}
		else if (selection instanceof IAdaptable) {
			return (EObject) ((IAdaptable) selection).getAdapter(EObject.class);
		}
		return null;
	}

	protected IParser getParser() {
		final EObject semanticElement = getSemanticObjectFromSelection();
		if (configuration != null && semanticElement != null) {
			return configuration.createParser(semanticElement);
		}
		return null;
	}

	protected void updateXtextAdapters(Control styledText) {
		final Object oldObjectToEdit = configuration != null ? configuration.getObjectToEdit() : null;
		
		final DefaultXtextDirectEditorConfiguration newConfiguration = getConfigurationFromSelection();
		// Check if configuration has changed and update adapters
		if (newConfiguration != null && newConfiguration != configuration) {
			if (xtextAdapter != null) {
				xtextAdapter.getFakeResourceContext().getFakeResource()
						.eAdapters().remove(contextElementAdapter);
			}
			configuration = newConfiguration;
			xtextAdapter = new StyledTextXtextAdapter(
					configuration.getInjector());
			
			EObject semanticElement = getSemanticObjectFromSelection();
			if (semanticElement != null) {
				newConfiguration.preEditAction(semanticElement);	
			}
			
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.add(contextElementAdapter);
			xtextAdapter.adapt((StyledText) styledText);
		}
		
		if (configuration.getObjectToEdit() != oldObjectToEdit) {
			IContextElementProvider provider = configuration.getContextProvider();
			if (provider instanceof IContextElementProviderWithInit) {
				// update resource, if required by text editor
				if (xtextAdapter != null) {
					((IContextElementProviderWithInit) provider).initResource(
						xtextAdapter.getFakeResourceContext().getFakeResource());
				}
			}
			Object semanticObject = configuration.getObjectToEdit();
			if (semanticObject instanceof EObject) {
				currentEObj = (EObject) semanticObject;
			}
		}
	}

	public EObject getContextObject() {
		return getEObject();
	}
	
	@Override
	protected boolean isReadOnly() {
		EObject context = getContextObject();
		return (context == null) || EMFHelper.isReadOnly(context) || super.isReadOnly();
	}
}