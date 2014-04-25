/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors.richtext.dialogs;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import org.eclipse.epf.richtext.IRichText;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.widgets.editors.richtext.dialogs.BaseDialog;
import org.eclipse.papyrus.infra.widgets.editors.richtext.dialogs.SpellChecker;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CheckSpellDialog extends BaseDialog {

	private SpellChecker spellChecker;

	private Queue<String> misspelledWords = new LinkedList<String>();

	private Text wrongWord;

	private List suggestedWords;

	private Button ignoreButton;

	private Button changeButton;

	private IgnoreButtonListener ignoreButtonListener = new IgnoreButtonListener();

	private ChangeButtonListener changeButtonListener = new ChangeButtonListener();

	private ModifiedChangeButtonListener modifiedChangeButtonListener = new ModifiedChangeButtonListener();

	private ModifiedIgnoreButtonListener modifiedIgnoreButtonListener = new ModifiedIgnoreButtonListener();

	private String oldWrongWord;

	private int currentWord = 1;

	private int totalWords;

	private IRichText richText;

	private String noHTMLString;

	public CheckSpellDialog(Shell parent, IRichText richText) {
		super(parent);
		setShellStyle(SWT.DIALOG_TRIM | SWT.MODELESS | getDefaultOrientation());

		this.richText = richText;

		if(richText != null) {
			/* Instantiate spell checker */
			try {
				spellChecker = new SpellChecker();
				findMisspelledWords();
			} catch (URISyntaxException e) {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Dictionary file for rich text editor not found", e.getMessage());
				e.printStackTrace();
			} catch (IOException e) {
				MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Dictionary file for rich text editor not found", e.getMessage());
				e.printStackTrace();
			}
		}
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite)super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		/** Not in dictionary label */
		new Label(composite, SWT.NONE).setText("Not in Dictionary:");
		new Label(composite, SWT.NONE);

		/** Current Misspelled Word */
		wrongWord = new Text(composite, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.heightHint = 75;
		gd.minimumHeight = 75;
		wrongWord.setLayoutData(gd);
		wrongWord.addKeyListener(new WrongWordKeyListener());
		wrongWord.addFocusListener(new WrongWordFocusListener());

		/** Ignore Button Actions */
		GridData buttonCompositeGridData = new GridData(SWT.FILL, SWT.FILL, false, true);
		buttonCompositeGridData.widthHint = 125;
		Composite topButtonActionsComposite = new Composite(composite, SWT.NONE);
		topButtonActionsComposite.setLayout(new GridLayout());
		topButtonActionsComposite.setLayoutData(buttonCompositeGridData);
		ignoreButton = new Button(topButtonActionsComposite, SWT.PUSH);
		ignoreButton.setText("Ignore");
		ignoreButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		ignoreButton.addSelectionListener(ignoreButtonListener);

		/** Suggestions label */
		new Label(composite, SWT.NONE).setText("Suggestions:");
		new Label(composite, SWT.NONE);

		/** Suggested Words */
		suggestedWords = new List(composite, SWT.BORDER | SWT.V_SCROLL | SWT.SINGLE);
		suggestedWords.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		/** Change Button Actions */
		Composite bottomButtonActionsComposite = new Composite(composite, SWT.NONE);
		bottomButtonActionsComposite.setLayout(new GridLayout());
		bottomButtonActionsComposite.setLayoutData(buttonCompositeGridData);
		changeButton = new Button(bottomButtonActionsComposite, SWT.PUSH);
		changeButton.setText("Change");
		changeButton.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		changeButton.addSelectionListener(changeButtonListener);

		startSpellChecking();
		return composite;
	}

	private void startSpellChecking() {
		if(!misspelledWords.isEmpty()) {
			super.getShell().setText("Spell Checker (" + currentWord + "/" + totalWords + ")");
			String firstWord = misspelledWords.poll();
			HashMap<Integer, String> suggestions = spellChecker.suggestions(firstWord);

			/** get order of suggestions */
			java.util.List<Integer> sortedKeys = asSortedList(suggestions.keySet());

			wrongWord.setText(firstWord);

			suggestedWords.removeAll();
			for(Integer i : sortedKeys) {
				suggestedWords.add(suggestions.get(i));
			}

			/** if there are no suggestions */
			if(suggestions.size() == 0) {
				suggestedWords.add("No Suggestions");
				changeButton.setEnabled(false);
			} else {
				changeButton.setEnabled(true);
			}

			suggestedWords.select(0);
			currentWord++;
		} else {
			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "No Misspellings", "There were no more misspelled words found.");
			super.close();
		}
	}

	private void findMisspelledWords() {
		misspelledWords.clear();

		/** Get all words in textfield */
		String[] cleanWords = cleanText(richText.getText());
		for(String word : cleanWords) {
			if(!word.equals(" ") && !word.isEmpty()) {
				if(!spellChecker.isInDictionary(word)) {
					misspelledWords.add(word);
				}
			}
		}
		totalWords = misspelledWords.size();
	}

	/**
	 * removes html content, new line characters, white spaces at the beginning
	 * or end of words, punctuation or non-letters, makes lowercase because that
	 * is what the dictionary works with
	 * 
	 * @param text
	 * @return
	 */
	private String[] cleanText(String text) {
		/* Remove html */
		noHTMLString = text.replaceAll("\\<.*?>", "");
		noHTMLString = noHTMLString.replaceAll("&.*?;", "");
		if(noHTMLString.contains("<")) {
			int length = 0;
			while(noHTMLString.length() != length) {
				length = htmlTagRemoval(noHTMLString);
			}
//			System.out.println("after manual removal noHTMLString: " + noHTMLString);
		}

		/** Remove New Lines */
		noHTMLString = noHTMLString.replaceAll("[\\t\\n\\r]", " ");

		String[] allWords = noHTMLString.split(" ");
		java.util.List<String> cleanedAllWords = new ArrayList<String>();

		for(String word : allWords) {
			/** remove white spaces */
			word = word.trim();
			/** remove non letters */
			if(!containsOnlyLetters(word)) {
				word = removeNonLetters(word);
			}
			cleanedAllWords.add(word);
		}

		/** Make all lowercase */
		for(int i = 0; i < cleanedAllWords.size(); i++) {
			cleanedAllWords.set(i, cleanedAllWords.get(i).toLowerCase());
		}

		return cleanedAllWords.toArray(new String[cleanedAllWords.size()]);
	}

	private int htmlTagRemoval(String string) {
		int i = 0;
		Integer start = null, end = null;
		for(i = 0; i < string.length(); i++) {
			if(string.toCharArray()[i] == '<') {
				start = i;
			}
			if(start != null && string.toCharArray()[i] == '>') {
				end = i;
				noHTMLString = string.replace(string.subSequence(start, end + 1), "");
				break;
			}
		}
		return i;
	}

	private boolean containsOnlyLetters(String s) {
		if(Pattern.matches("[a-zA-Z]+", s)) {
			return true;
		} else {
			return false;
		}
	}

	private String removeNonLetters(String s) {
		StringBuffer sb = new StringBuffer();

		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i)) || s.charAt(i) == '\'') {
				sb = sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	private class WrongWordKeyListener extends KeyAdapter {

		@Override
		public void keyReleased(KeyEvent e) {

			/**
			 * Disable suggested words and change ignore button to undo button
			 * and the change button listener
			 */
			suggestedWords.setEnabled(false);

			ignoreButton.setEnabled(true);
			ignoreButton.setText("Undo Edit");
			ignoreButton.removeSelectionListener(ignoreButtonListener);
			ignoreButton.addSelectionListener(modifiedIgnoreButtonListener);

			changeButton.setEnabled(true);
			changeButton.removeSelectionListener(changeButtonListener);
			changeButton.addSelectionListener(modifiedChangeButtonListener);

			wrongWord.removeKeyListener(this);

		}
	}

	/**
	 * This stors the old word incase the user wants to undo the edit later.
	 * 
	 * @author Will
	 * 
	 */
	private class WrongWordFocusListener extends FocusAdapter {

		@Override
		public void focusGained(FocusEvent e) {
			oldWrongWord = wrongWord.getText();
			super.focusGained(e);
		}
	}

	private class IgnoreButtonListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			// go to next word
			startSpellChecking();
		}
	}

	private class ChangeButtonListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			String newWord = suggestedWords.getSelection()[0];

			// change old word
			String correctedChanges = richText.getText().replace(wrongWord.getText(), newWord);
			richText.setText(correctedChanges);

			// next word
			startSpellChecking();

		}
	}

	/**
	 * This is used when the user manually edits the misspelled word and changes
	 * it
	 * 
	 * @author Will
	 * 
	 */
	private class ModifiedChangeButtonListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			String newWord = wrongWord.getText();

			// change old word
			String correctedChanges = richText.getText().replace(oldWrongWord, newWord);
			richText.setText(correctedChanges);

			ignoreButton.setText("Ignore");
			ignoreButton.removeSelectionListener(modifiedIgnoreButtonListener);
			ignoreButton.addSelectionListener(ignoreButtonListener);

			changeButton.removeSelectionListener(modifiedChangeButtonListener);
			changeButton.addSelectionListener(changeButtonListener);

			suggestedWords.setEnabled(true);

			wrongWord.addKeyListener(new WrongWordKeyListener());

			// next word
			startSpellChecking();

		}
	}

	/**
	 * This is used when the user manually edits the misspelled word and wants
	 * to undo changes
	 * 
	 * @author Will
	 * 
	 */
	private class ModifiedIgnoreButtonListener extends SelectionAdapter {

		@Override
		public void widgetSelected(SelectionEvent e) {
			/**
			 * rename ignore button, fix listeners on both buttons, enable
			 * suggested words, undo edit, add modify listener back
			 */
			ignoreButton.setText("Ignore");
			ignoreButton.removeSelectionListener(modifiedIgnoreButtonListener);
			ignoreButton.addSelectionListener(ignoreButtonListener);

			changeButton.removeSelectionListener(modifiedChangeButtonListener);
			changeButton.addSelectionListener(changeButtonListener);

			suggestedWords.setEnabled(true);

			wrongWord.setText(oldWrongWord);
			wrongWord.addKeyListener(new WrongWordKeyListener());

			if(suggestedWords.getItem(0).equals("No Suggestions")) {
				changeButton.setEnabled(false);
			}

		}
	}

	private static <T extends Comparable<? super T>> java.util.List<T> asSortedList(Collection<T> c) {
		java.util.List<T> list = new ArrayList<T>(c);
		java.util.Collections.sort(list);
		java.util.Collections.reverse(list);
		return list;
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		return null;
	}

	@Override
	protected Point getInitialSize() {
		Point size = super.getInitialSize();
		size.x = 500;
		size.y = 350;
		return size;
	}
}
