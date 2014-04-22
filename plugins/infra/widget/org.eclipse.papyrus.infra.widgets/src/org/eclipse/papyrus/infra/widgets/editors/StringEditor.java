/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Thibault Le Ouay t.leouay@sherpa-eng.com - Add binding implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.papyrus.infra.widgets.databinding.TextObservableValue;
import org.eclipse.papyrus.infra.widgets.selectors.StringSelector;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Text;

/**
 * A Property Editor representing a single-line or multi-line String value as a
 * Text. This editor's content is validated when the focus is lost, or, if the
 * editor is single-line, when the Carriage Return is pressed. For a multi-line
 * editor, ctrl+enter will also validate the editor's content.
 *
 * @see SWT#MULTI
 *
 * @author Camille Letavernier
 */
public class StringEditor extends AbstractValueEditor implements KeyListener, ModifyListener {

	/**
	 * The text box for editing this editor's value
	 */
	protected final Text text;

	private int delay = 600;

	private boolean validateOnDelay = false;

	private Timer timer;

	private TimerTask currentValidateTask;

	private TimerTask changeColorTask;

	private final static int DEFAULT_HEIGHT_HINT = 55;

	private final static int DEFAULT_WIDTH_HINT = 100;


	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 */
	public StringEditor(Composite parent, int style) {
		this(parent, style, null, DEFAULT_HEIGHT_HINT, DEFAULT_WIDTH_HINT);

	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 * @param label
	 *        The label for this editor
	 */
	public StringEditor(Composite parent, int style, String label) {
		this(parent, style, label, DEFAULT_HEIGHT_HINT, DEFAULT_WIDTH_HINT);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 * @param heighHint
	 *        Height hint of the text area in multiline mode
	 * @param widthHint
	 *        Width hint of the text area in multiline mode
	 */
	public StringEditor(Composite parent, int style, int heighHint, int widthHint) {
		this(parent, style, null, heighHint, widthHint);
	}

	/**
	 *
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which this editor should be displayed
	 * @param style
	 *        The style for this editor's text box
	 * @param label
	 *        The label for this editor
	 * @param heighHint
	 *        Height hint of the text area in multiline mode
	 * @param widthHint
	 *        Width hint of the text area in multiline mode
	 */
	public StringEditor(Composite parent, int style, String label, int heighHint, int widthHint) {
		super(parent, label);

		GridData data = getDefaultLayoutData();
		data.grabExcessVerticalSpace = true;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = SWT.FILL;

		if((style & SWT.MULTI) != 0) {
			data.minimumHeight = heighHint;
			data.minimumWidth = widthHint;
			style = style | SWT.V_SCROLL;
		}

		text = factory.createText(this, null, style);
		text.setLayoutData(data);

		if(label != null) {
			super.label.setLayoutData(getLabelLayoutData());

		}
		text.addKeyListener(this);
		text.addModifyListener(this);
		setCommitOnFocusLost(text);
		controlDecoration = new ControlDecoration(text, SWT.LEFT | SWT.TOP);
		controlDecoration.hide();
		data.horizontalIndent = FieldDecorationRegistry.getDefault().getMaximumDecorationWidth();
		pack();

	}

	@Override
	protected GridData getLabelLayoutData() {
		GridData result = super.getLabelLayoutData();
		if(text != null) {
			if((text.getStyle() & SWT.MULTI) != 0) {
				result.verticalAlignment = SWT.BEGINNING;
			}
		}
		return result;
	}

	/**
	 * Ignored
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// Nothing



	}

	/**
	 * Validates this editor when one of the following events occur : - CR
	 * released - Keypad CR released - Ctrl + [CR | Keypad CR] released
	 *
	 * @see org.eclipse.swt.events.KeyListener#keyReleased(org.eclipse.swt.events.KeyEvent)
	 *
	 * @param e
	 */
	// TODO : we should prevent the \n from being written when validating the
	// multi-line field with Ctrl + CR
	@Override
	public void keyReleased(KeyEvent e) {
		// We listen on Carriage Return or Ctrl+ Carriage return, depending on
		// whether the editor is single- or multi-line
		if(e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
			if((text.getStyle() & SWT.MULTI) == 0) { // Single-line : Enter
				if(e.stateMask == SWT.NONE) {
					notifyChange();
				}
			} else { // Multi-line : Ctrl+Enter
				if(e.stateMask == SWT.CTRL) {
					String str = text.getText();
					if(str.endsWith(StringSelector.LINE_SEPARATOR)) {
						int newLength = str.length() - StringSelector.LINE_SEPARATOR.length();
						text.setText(str.substring(0, newLength));
						text.setSelection(newLength);
					}
					notifyChange();
				}
			}
		}


	}

	@Override
	public void setModelObservable(IObservableValue observable) {
		setWidgetObservable(new TextObservableValue(text, observable, SWT.FocusOut), true);
		super.setModelObservable(observable);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getEditableType() {
		return String.class;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object getValue() {
		return text.getText();
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		text.setEnabled(!readOnly);
	}

	@Override
	public boolean isReadOnly() {
		return !text.isEnabled();
	}

	protected void notifyChange() {

		text.notifyListeners(SWT.FocusOut, new Event());
		commit();
		changeColorField();
	}

	@Override
	public void setToolTipText(String tooltip) {
		text.setToolTipText(tooltip);
		super.setLabelToolTipText(tooltip);
	}

	/**
	 * Sets the current text value for this editor
	 *
	 * @param value
	 */
	public void setValue(Object value) {
		if(value instanceof String) {
			this.text.setText((String)value);
		} else {
			this.text.setText(""); //$NON-NLS-1$;
		}
	}

	/**
	 * Indicates that this editor should be automatically validated after a
	 * timer.
	 *
	 * @param validateOnDelay
	 */
	public void setValidateOnDelay(boolean validateOnDelay) {
		this.validateOnDelay = validateOnDelay;

		if(validateOnDelay) {
			text.addModifyListener(this);
		} else {
			text.removeModifyListener(this);
			cancelCurrentTask();
		}
	}

	/**
	 * Indicates that this editor should be automatically validated after the
	 * given timer
	 *
	 * @param millis
	 *        The delay after which the editor should be automatically
	 *        validated, in milliseconds. The default is 600ms
	 */
	public void setValidateOnDelay(int millis) {
		this.delay = millis;
		setValidateOnDelay(true);
		if(delay == 0) {
			cancelCurrentTask();
		}
	}

	private void cancelCurrentTask() {
		if(currentValidateTask != null) {
			currentValidateTask.cancel();
			currentValidateTask = null;
		}
	}

	/**
	 * {@inheritDoc}
	 */

	@Override
	public void modifyText(ModifyEvent e) {

		// SWT Thread
		if(validateOnDelay) {
			if(delay == 0) {
				commit(); // Direct commit on edition, to avoid creating useless
				// threads

				return;
			}

			if(timer == null) {
				timer = new Timer(true);
			}

			cancelCurrentTask();
			currentValidateTask = new TimerTask() {

				// Timer thread
				@Override
				public void run() {
					StringEditor.this.getDisplay().syncExec(new Runnable() {

						// SWT Thread
						@Override
						public void run() {

							commit();
						}
					});
				}
			};
			timer.schedule(currentValidateTask, delay);
		}
		if(targetValidator != null) {
			IStatus status = targetValidator.validate(text.getText());
			updateStatus(status);
		}
		if(modelValidator != null) {
			IStatus status = modelValidator.validate(text.getText());
			updateStatus(status);
			if(binding == null) {
				update();
			}
		}

		if(modelProperty.getValue() != null) {
			if(!isReadOnly() && !modelProperty.getValue().toString().equals(text.getText())) {
				text.setBackground(EDIT);
			} else {
				text.setBackground(DEFAULT);
			}
		} else {
			if(text.getText().equals("")) {
				text.setBackground(DEFAULT);
			} else {
				text.setBackground(EDIT);
			}
		}

	}

	@Override
	public void dispose() {
		cancelCurrentTask();
		cancelChangeColorTask();
		if(timer != null) {
			timer.cancel();
			timer = null;
		}
		super.dispose();
	}

	public Text getText() {
		return text;
	}

	@Override
	public void updateStatus(IStatus status) {
		switch(status.getSeverity()) {
		case IStatus.OK:
			controlDecoration.hide();
			break;
		case IStatus.WARNING:
			FieldDecoration warning = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_WARNING);
			controlDecoration.setImage(warning.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		case IStatus.ERROR:
			FieldDecoration error = FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
			controlDecoration.setImage(error.getImage());
			controlDecoration.showHoverText(status.getMessage());
			controlDecoration.setDescriptionText(status.getMessage());
			controlDecoration.show();
			break;
		default:
			controlDecoration.hide();
			break;
		}

	}

	@Override
	public void changeColorField() {
		if(binding != null) {

			if(timer == null) {
				timer = new Timer(true);
			}

			cancelChangeColorTask();
			changeColorTask = new TimerTask() {

				@Override
				public void run() {
					StringEditor.this.getDisplay().syncExec(new Runnable() {

						@Override
						public void run() {
							text.setBackground(DEFAULT);
							text.update();
						}
					});
				}
			};
			if(errorBinding) {
				text.setBackground(ERROR);
				text.update();
			} else {
				IStatus status = (IStatus)binding.getValidationStatus().getValue();
				switch(status.getSeverity()) {
				case IStatus.OK:
				case IStatus.WARNING:
					timer.schedule(changeColorTask, 600);
					text.setBackground(VALID);
					text.update();
					break;
				case IStatus.ERROR:
					text.setBackground(ERROR);
					text.update();
					break;

				}
			}
		}
	}

	private void cancelChangeColorTask() {
		if(changeColorTask != null) {
			changeColorTask.cancel();
			changeColorTask = null;
		}
	}

}
