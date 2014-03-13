package org.eclipse.papyrus.uml.properties.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.extensionpoints.editors.Activator;
import org.eclipse.papyrus.extensionpoints.editors.configuration.IDirectEditorConfiguration;
import org.eclipse.papyrus.extensionpoints.editors.utils.DirectEditorsUtil;
import org.eclipse.papyrus.extensionpoints.editors.utils.IDirectEditorsIds;
import org.eclipse.papyrus.infra.emf.dialog.NestedEditingDialogContext;
import org.eclipse.papyrus.uml.properties.modelelement.UMLModelElement;
import org.eclipse.papyrus.uml.properties.widgets.BodyEditor;
import org.eclipse.papyrus.uml.xtext.integration.DefaultXtextDirectEditorConfiguration;
import org.eclipse.papyrus.uml.xtext.integration.StyledTextXtextAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProvider;
import org.eclipse.papyrus.uml.xtext.integration.core.ContextElementAdapter.IContextElementProviderWithInit;
import org.eclipse.papyrus.views.properties.modelelement.ModelElement;
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
import org.eclipse.swt.widgets.Listener;

public class XtextLanguageEditor implements BodyEditor, IContextElementProvider {

	protected StyledText textControl;

	UndoRedoStack<ExtendedModifyEvent> undoRedoStack;
	
	protected boolean isUndo;

	protected boolean isRedo;
	
	private DefaultXtextDirectEditorConfiguration configuration;

	private StyledTextXtextAdapter xtextAdapter;

	protected EObject currentEObj;

	final private ContextElementAdapter contextElementAdapter = new ContextElementAdapter(
			this);

	public void createWidget(Composite parent, int style) {
		undoRedoStack = new UndoRedoStack<ExtendedModifyEvent>();
		createTextControl(parent);
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

					TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(getEObject());
					if (domain == null) {
						// can be null for opaque expression that have been created but have not been added to parent
						// try to get resource set from nested dialog context
						ResourceSet rs = NestedEditingDialogContext.getInstance().getResourceSet();
						domain = TransactionUtil.getEditingDomain(rs);
					}
					if (domain != null) {
						domain.getCommandStack().execute(new GMFtoEMFCommandWrapper(command));
					}
				}
			}

			public void focusGained(FocusEvent e) {
			}
		});
		
		textControl.setAlwaysShowScrollBars(false);
		textControl.setLayout(new GridLayout());
	
		// GridDataFactory.fillDefaults().grab(true, true).hint(parent.getSize()).applyTo(textControl);
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
	protected void revertEvent(ExtendedModifyEvent event) {
		textControl.replaceTextRange(event.start, event.length, event.replacedText);
		// (causes the modifyText() listener method to be called)
		
		textControl.setSelectionRange(event.start, event.replacedText.length());
	}
	
	protected IParser getParser() {
		final EObject semanticElement = getEObject();
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
			
			EObject semanticElement = getEObject();
			if (semanticElement != null) {
				newConfiguration.preEditAction(semanticElement);	
			}
			
			xtextAdapter.getFakeResourceContext().getFakeResource().eAdapters()
					.add(contextElementAdapter);
			xtextAdapter.adapt((StyledText) styledText);
		}
		
		if (configuration != null && configuration.getObjectToEdit() != oldObjectToEdit) {
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

	protected DefaultXtextDirectEditorConfiguration getConfigurationFromSelection() {
		EObject semanticElement = getEObject();
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
	
	public EObject getContextObject() {
		return getEObject();
	}
	
	public void setInput(String value) {
		if (value != null) {
			textControl.setText(value);
		}
	}

	public void dispose() {
	}

	public void addChangeListener(Listener listener) {
	}

	public void removeChangeListener(Listener listener) {
	}

	public String getValue() {
		return null;
	}

	public void setReadOnly(boolean readOnly) {
	}

	public void setContext(ModelElement context) {
		if (context instanceof UMLModelElement) {
			currentEObj = ((UMLModelElement) context).getSource();
			updateXtextAdapters(textControl);
		}
	}

	/**
	 * @return Returns the eObject.
	 */
	protected EObject getEObject() {
		return currentEObj;
	}
}
