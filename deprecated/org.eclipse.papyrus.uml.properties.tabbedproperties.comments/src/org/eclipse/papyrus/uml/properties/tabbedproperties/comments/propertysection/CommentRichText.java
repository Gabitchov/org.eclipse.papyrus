//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.papyrus.uml.properties.tabbedproperties.comments.propertysection;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epf.richtext.RichText;
import org.eclipse.epf.richtext.RichTextListener;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.LocationAdapter;
import org.eclipse.swt.browser.LocationEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.uml2.uml.Comment;

/**
 * A Method Editor Rich Text control.
 * 
 * @author Kelvin Low
 * @author Jeff Hardy
 * @since 1.0
 */
public class CommentRichText extends RichText {

	// The method element associated with this rich text control.
	private Comment comment;

	// The modal object associated with this rich text control.
	private EObject modalObject;

	// The modal object feature associated with this rich text control.
	private EStructuralFeature modalObjectFeature;

	// The resource being edited
	protected Resource resource;

	// the decoratedField label
	protected Label label;

	protected ControlDecoration controlDecoration;

	protected final Image errorFieldDecorationImage = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage();

	// Field name being edited
	protected String fieldName = ""; //$NON-NLS-1$

	// Field name being edited with the trailing : removed
	protected String fieldNameTrim;

	// marker helper
	// protected MethodRichTextMarkerHelper markerHelper;

	// // marker attribute
	// private static String METHOD_FIELDNAME = "MethodFieldName";

	// // marker ID
	//	protected static final String MARKER_ID = "org.eclipse.epf.authoring.ui.methodRichText"; //$NON-NLS-1$

	/**
	 * Creates a new instance.
	 * 
	 * @param parent
	 *        The parent control.
	 * @param style
	 *        The initial style for the editor.
	 * @param basePath
	 *        The base path used for resolving hrefs.
	 */
	public CommentRichText(Composite parent, int style, String basePath) {
		super(parent, style, basePath);
	}

	/**
	 * Updates the presentation names of all element links.
	 * 
	 * @param text
	 *        Rich text encoded in HTML format.
	 */
	@Override
	protected String tidyText(String text) {
		/*
		 * this will do the following to the HTML: 1. update Element Links 2. change <A ..> to <a
		 * ..> 3. change </A> to </a> 4. add double-quotes (") around all attribute values if they
		 * are missing
		 */

		// return ResourceHelper.validateRichTextContent(comment, text, new
		// RichTextContentValidator());
		return text;
	}

	/**
	 * Adds listeners to manage the activation and focus events.
	 */
	protected void addListeners() {
		editorControl = getControlSite(editor);
		if(editorControl != null) {
			if(debug) {
				printDebugMessage("init", "editorControl=" + editorControl.getClass().getName()); //$NON-NLS-1$ //$NON-NLS-2$
			}

			// only IE (win32) has the editorControl != null
			isIE = true;

			editorControl.addListener(SWT.Activate, new Listener() {

				public void handleEvent(Event event) {
					if(debug) {
						printDebugMessage("activateListener"); //$NON-NLS-1$
					}
					// setFocus();	//NOTE (RS): this is removed because of the dialog flashing from the workbench to this dialog window
					notifyListeners(SWT.Activate, event);
				}
			});

			editorControl.addListener(SWT.Deactivate, new Listener() {

				public void handleEvent(Event event) {
					if(debug) {
						printDebugMessage("deactivateListener"); //$NON-NLS-1$
					}
					setBlur();
					notifyListeners(SWT.Deactivate, event);
				}
			});

			editorControl.addListener(SWT.FocusIn, new Listener() {

				public void handleEvent(Event event) {
					if(debug) {
						printDebugMessage("focusInListener"); //$NON-NLS-1$
					}
					executeCommand("updateSelection"); //$NON-NLS-1$					
					notifyListeners(SWT.FocusIn, event);
				}
			});

			editorControl.addListener(SWT.KeyUp, new Listener() {

				public void handleEvent(Event event) {
					int keyCode = event.keyCode;
					int stateMask = event.stateMask;
					if(debug) {
						printDebugMessage("keyUpListener", "keyCode=" + keyCode //$NON-NLS-1$ //$NON-NLS-2$
							+ ", stateMask=" + stateMask + ", editable=" + editable); //$NON-NLS-1$ //$NON-NLS-2$
					}
					if((stateMask & SWT.CTRL) > 0 || (stateMask & SWT.ALT) > 0 || ((stateMask & SWT.SHIFT) > 0 && keyCode == stateMask)) {
						return;
					}
					if(editable) {
						switch(event.keyCode) {
						case SWT.ARROW_DOWN:
						case SWT.ARROW_LEFT:
						case SWT.ARROW_RIGHT:
						case SWT.ARROW_UP:
						case SWT.END:
						case SWT.HOME:
						case SWT.PAGE_DOWN:
						case SWT.PAGE_UP:
						case SWT.TAB:
							return;
						default:
							checkModify();
							break;
						}
					}
				}
			});

			editor.addLocationListener(new LocationAdapter() {

				public void changing(LocationEvent event) {
					// Deactivate the links in the content page in readonly
					// mode.
					event.doit = editable;
				}
			});
		} else {
			editor.addListener(SWT.Activate, new Listener() {

				public void handleEvent(Event event) {
					if(debug) {
						printDebugMessage("activateListener"); //$NON-NLS-1$
					}
					setFocus();
				}
			});

			editor.addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent e) {
					if(e.keyCode == SWT.TAB) {
						if((e.stateMask & SWT.SHIFT) != 0) {
							editor.traverse(SWT.TRAVERSE_TAB_PREVIOUS);
						} else {
							editor.traverse(SWT.TRAVERSE_TAB_NEXT);
						}
						return;
					}
					if(!editable) {
						e.doit = false;
					}
				}

				public void keyReleased(KeyEvent e) {
					if((e.stateMask & SWT.CTRL) > 0 || (e.stateMask & SWT.ALT) > 0)
						return;
					if(editable) {
						switch(e.keyCode) {
						case SWT.ARROW_DOWN:
						case SWT.ARROW_LEFT:
						case SWT.ARROW_RIGHT:
						case SWT.ARROW_UP:
						case SWT.END:
						case SWT.HOME:
						case SWT.PAGE_DOWN:
						case SWT.PAGE_UP:
						case SWT.SHIFT:
						case SWT.TAB:
							break;
						default:
							checkModify();
							break;
						}
					}
				}
			});
		}

		editor.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if(debug) {
					printDebugMessage("disposeListener"); //$NON-NLS-1$						
				}
				dispose();
			}
		});

		listeners = new Hashtable<Listener, RichTextListener>();
		modifyListeners = new ArrayList<ModifyListener>();
	}

	/**
	 * Sets the method element associated with this rich text control.
	 * 
	 * @param comment
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	/**
	 * Returns the method element associated with this rich text control.
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * Returns the modal object associated with this rich text control.
	 */
	public EObject getModalObject() {
		return modalObject;
	}

	/**
	 * Sets the modal object associated with this rich text control.
	 */
	public void setModalObject(EObject modalObject) {
		this.modalObject = modalObject;
	}

	/**
	 * Returns modal object feature associated with this rich text control.
	 */
	public EStructuralFeature getModalObjectFeature() {
		return modalObjectFeature;
	}

	/**
	 * Sets the modal object feature associated with this rich text control.
	 */
	public void setModalObjectFeature(EStructuralFeature modalObjectFeature) {
		this.modalObjectFeature = modalObjectFeature;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setDecoratedFieldLabel(Label label) {
		this.label = label;
		if(label != null) {
			// Object data = label.getData(BaseFormPage.LABEL_DECORATOR_KEY);
			// if (data instanceof ControlDecoration) {
			// controlDecoration = (ControlDecoration) data;
			// controlDecoration.setImage(errorFieldDecorationImage);
			// controlDecoration.hide();
			// }
			updateFieldNameFromLabel(label);
		}
	}

	private boolean updateFieldNameFromLabel(Label label) {
		if(label != null) {
			String fieldName = label.getText();
			if(!this.fieldName.equals(fieldName)) {
				this.fieldName = fieldName;
				int colonIndex = fieldName.indexOf(':');
				if(colonIndex == -1)
					colonIndex = fieldName.length();
				this.fieldNameTrim = fieldName.substring(0, colonIndex).trim();
				return true;
			}
		}
		return false;
	}

	public void init(Comment comment, Label label) {
		setComment(comment);
		setDecoratedFieldLabel(label);
		// markerHelper = MethodRichTextMarkerHelper.INSTANCE;
	}

	@Override
	protected String formatHTML(String text) {
		String formattedText;
		try {
			// clear markers first
			clearMarkers();
			// Call JTidy to format the source to XHTML.
			formattedText = htmlFormatter.formatHTML(text);
			// if (htmlFormatter.getLastErrorStr() != null) {
			// String errorString = htmlFormatter.getLastErrorStr();
			// // create markers
			// try {
			// createMarker(errorString);
			// } catch (CoreException cex) {
			// logger.logError(cex);
			// }
			// }
			return formattedText;
		} catch (UnsupportedEncodingException e) {
			logger.logError(e);
		}
		return text;
	}

	protected void clearMarkers() {
		// markerHelper.deleteMarkers(contentDescription, fieldNameTrim);
		setErrorDescription(""); //$NON-NLS-1$
		hideErrorDecoration();
		refreshDecorators();
	}

	protected void setErrorDescription(String text) {
		if(controlDecoration != null) {
			controlDecoration.setDescriptionText(text);
		}
	}

	protected void refreshDecorators() {
		// refresh
		// PlatformUI.getWorkbench().getDecoratorManager().update(MethodElementLightweightLabelDecorator.DECORATOR_ID);
	}

	@Override
	public void dispose() {
		super.dispose();
		clearMarkers();
		refreshDecorators();
	}

	public void showErrorDecoration() {
		if(controlDecoration != null) {
			controlDecoration.show();
		}
	}

	public void hideErrorDecoration() {
		if(controlDecoration != null) {
			controlDecoration.hide();
		}
	}

	@Override
	public void setText(String text) {
		// check if label text was changed (this happens when RTE is expanded)
		// this is called when RTE is toggled in editor - read new fieldName
		if(updateFieldNameFromLabel(label))
			hideErrorDecoration();
		super.setText(text);
	}
}
