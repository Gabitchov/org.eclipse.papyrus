/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		 Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.wizard.pages;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.papyrus.infra.nattable.messages.Messages;
import org.eclipse.papyrus.infra.nattable.paste.PasteSeparator;
import org.eclipse.papyrus.infra.nattable.paste.TextDelimiter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * The page to configure the separator used in the CSV file
 * 
 * @author VL222926
 * 
 */
public class ImportCSVConfigurationPage extends WizardPage {

	/**
	 * the paste separator
	 */
	private PasteSeparator separator;

	/**
	 * the text delimiter
	 */
	private TextDelimiter textDelimiter;

	/**
	 * the specific seaprator
	 */
	private char[] textChar = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param pageName
	 *        the name of the import page
	 * @param title
	 *        the title of the page
	 * @param titleImage
	 *        the image for this page
	 * @param tableManager
	 *        the table manager where the import will be done
	 */
	public ImportCSVConfigurationPage(final String pageName, final String title, final ImageDescriptor titleImage, final PasteSeparator defaultSeparator, final TextDelimiter defaultDelimiter) {
		super(pageName, title, titleImage);
		setDescription(Messages.ImportFilePage_SelectTheFileToImport);
		this.separator = defaultSeparator;
		this.textDelimiter = defaultDelimiter;
	}

	/**
	 * 
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param parent
	 */
	@Override
	public void createControl(final Composite parent1) {
		final Composite pageComposite = new Composite(parent1, SWT.NONE);
		setControl(pageComposite);
		pageComposite.setLayout(new GridLayout(2, true));
		final Group separatorGroup = new Group(pageComposite, SWT.NONE);
		separatorGroup.setText(Messages.ImportCSVConfigurationPage_Separators);
		separatorGroup.setLayout(new GridLayout(2, false));

		for(final PasteSeparator current : PasteSeparator.values()) {
			final Button button = new Button(separatorGroup, SWT.RADIO);
			button.setText(current.getName());
			button.addSelectionListener(new SelectionListener() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					if(button.isEnabled()) {
						separator = current;
					}
					setPageComplete(validate());
				}

				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					//nothing to do
				}
			});
			button.setSelection(current == separator);
			final GridData data = new GridData();
			if(current == PasteSeparator.OTHER) {
				final Text text = new Text(separatorGroup, SWT.BORDER);
				text.addKeyListener(new org.eclipse.swt.events.KeyListener() {

					@Override
					public void keyReleased(KeyEvent e) {
						textChar = text.getTextChars();
						setPageComplete(validate());
					}

					@Override
					public void keyPressed(KeyEvent e) {
						//nothing to do
					}
				});
				button.addSelectionListener(new SelectionListener() {

					@Override
					public void widgetSelected(SelectionEvent e) {
						text.setEnabled(button.getSelection());
						setPageComplete(validate());
					}

					@Override
					public void widgetDefaultSelected(SelectionEvent e) {
					}
				});
				text.setEnabled(this.separator == PasteSeparator.OTHER);
			} else {
				data.horizontalSpan = 2;
			}
			button.setLayoutData(data);
		}

		final Composite textDelimiterComp = new Composite(pageComposite, SWT.NONE);
		textDelimiterComp.setLayout(new GridLayout(2, false));
		textDelimiterComp.setLayoutData(new GridData());
		final Label label2 = new Label(textDelimiterComp, SWT.NONE);
		label2.setText(Messages.ImportCSVConfigurationPage_SelectTheTextDelimiter);
		final Combo combo = new Combo(textDelimiterComp, SWT.DROP_DOWN | SWT.READ_ONLY);

		for(int i = 0; i < TextDelimiter.values().length; i++) {
			final TextDelimiter current = TextDelimiter.values()[i];
			combo.add(String.valueOf(current.getDelimiter()), i);
			if(this.textDelimiter == current) {
				combo.select(i);
			}
		}
		combo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				textDelimiter = TextDelimiter.values()[combo.getSelectionIndex()];
				setPageComplete(validate());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				//nothing to do
			}
		});

		setPageComplete(validate());
	}

	/**
	 * 
	 * @return
	 */
	private boolean validate() {
		if(this.separator == PasteSeparator.OTHER) {
			if(this.textChar == null || this.textChar.length == 0) {
				setErrorMessage(Messages.ImportCSVConfigurationPage_TheCellSeparatorIsNotDefined);
				return false;
			} else if(this.textChar.length > 1) {
				setErrorMessage(Messages.ImportCSVConfigurationPage_TheCellSeparatorMustBeExcatlyOneChar);
				return false;
			}
		}
		setErrorMessage(null);
		return true;
	}

	/**
	 * 
	 * @return
	 *         the selected separator
	 */
	public char getSeparator() {
		if(this.separator == PasteSeparator.OTHER) {
			return textChar[0];
		}
		return this.separator.getSeparator();
	}

	/**
	 * 
	 * @return
	 *         the selected text delimiter
	 */
	public char getTextDelimiter() {
		return this.textDelimiter.getDelimiter();
	}



}
