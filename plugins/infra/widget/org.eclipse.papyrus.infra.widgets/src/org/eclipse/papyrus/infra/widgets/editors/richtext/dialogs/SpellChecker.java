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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.papyrus.infra.widgets.editors.richtext.RichPlugin;
import org.osgi.framework.Bundle;

class SpellChecker {

	private final HashMap<String, Integer> nWords = new HashMap<String, Integer>();

	public SpellChecker() throws URISyntaxException, IOException {
		Bundle bundle = RichPlugin.getDefault().getBundle();
		URL fileURL = bundle.getEntry("files/dictionary.txt");
		File file = null;
		file = new File(FileLocator.resolve(fileURL).toURI());

		BufferedReader in = new BufferedReader(new FileReader(file));
		Pattern p = Pattern.compile("\\w+");
		for(String temp = ""; temp != null; temp = in.readLine()) {
			Matcher m = p.matcher(temp.toLowerCase());
			while(m.find())
				nWords.put((temp = m.group()), nWords.containsKey(temp) ? nWords.get(temp) + 1 : 1);
		}
		in.close();
	}

	public boolean isInDictionary(String word) {
		return nWords.containsKey(word) ? true : false;
	}

	private final ArrayList<String> edits(String word) {
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < word.length(); ++i)
			result.add(word.substring(0, i) + word.substring(i + 1));
		for(int i = 0; i < word.length() - 1; ++i)
			result.add(word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + word.substring(i + 2));
		for(int i = 0; i < word.length(); ++i)
			for(char c = 'a'; c <= 'z'; ++c)
				result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i + 1));
		for(int i = 0; i <= word.length(); ++i)
			for(char c = 'a'; c <= 'z'; ++c)
				result.add(word.substring(0, i) + String.valueOf(c) + word.substring(i));
		return result;
	}

	public final String correct(String word) {
		if(nWords.containsKey(word))
			return word;
		ArrayList<String> list = edits(word);
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		for(String s : list)
			if(nWords.containsKey(s))
				candidates.put(nWords.get(s), s);
		if(candidates.size() > 0)
			return candidates.get(Collections.max(candidates.keySet()));
		for(String s : list)
			for(String w : edits(s))
				if(nWords.containsKey(w))
					candidates.put(nWords.get(w), w);
		return candidates.size() > 0 ? candidates.get(Collections.max(candidates.keySet())) : word;
	}

	public final HashMap<Integer, String> suggestions(String word) {
		if(nWords.containsKey(word)) {
			HashMap<Integer, String> wordMap = new HashMap<Integer, String>();
			wordMap.put(1, word);
			return wordMap;
		}
		ArrayList<String> list = edits(word);
		HashMap<Integer, String> candidates = new HashMap<Integer, String>();
		for(String s : list)
			if(nWords.containsKey(s))
				candidates.put(nWords.get(s), s);
		if(candidates.size() > 0)
			return candidates;
		for(String s : list)
			for(String w : edits(s))
				if(nWords.containsKey(w))
					candidates.put(nWords.get(w), w);
		return candidates;
	}

}
