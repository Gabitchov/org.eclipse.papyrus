/*******************************************************************************
 * Copyright (c) 2009, 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Nicolas Bros (Mia-Software) - initial API and implementation
 *     Nicolas Guyomar (Mia-Software) - Bug 333652 Extension point offering the possibility to declare an EPackage browser
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.core.internal.utils;

import java.util.Vector;

import com.ibm.icu.lang.UCharacter;

/**
 * A string pattern matcher. Supports '*' and '?' wildcards.
 * 
 * FIXME yet another duplicated version of StringMatcher (Bug 269424)
 */
public class StringMatcher {
	private final String fPattern;

	private final int fLength; // pattern length

	private final boolean fIgnoreWildCards;

	private final boolean fIgnoreCase;

	private boolean fHasLeadingStar;

	private boolean fHasTrailingStar;

	private String[] fSegments; // the given pattern is split into * separated
	// segments

	/* boundary value beyond which we don't need to search in the text */
	private int fBound = 0;

	private static final char SINGLE_WILD_CARD = '\u0000';

	public static class Position {
		private final int start; // inclusive
		private final int end; // exclusive

		public Position(final int start, final int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return this.start;
		}

		public int getEnd() {
			return this.end;
		}
	}

	/**
	 * StringMatcher constructor takes in a String object that is a simple
	 * pattern which may contain '*' for 0 and many characters and '?' for
	 * exactly one character.
	 * 
	 * Literal '*' and '?' characters must be escaped in the pattern e.g.,
	 * "\*" means literal "*", etc.
	 * 
	 * Escaping any other character (including the escape character itself),
	 * just results in that character in the pattern. e.g., "\a" means "a" and
	 * "\\" means "\"
	 * 
	 * If invoking the StringMatcher with string literals in Java, don't forget
	 * escape characters are represented by "\\".
	 * 
	 * @param pattern
	 *            the pattern to match text against
	 * @param ignoreCase
	 *            if true, case is ignored
	 * @param ignoreWildCards
	 *            if true, wild cards and their escape sequences are ignored
	 *            (everything is taken literally).
	 */
	public StringMatcher(final String pattern, final boolean ignoreCase,
			final boolean ignoreWildCards) {
		if (pattern == null) {
			throw new IllegalArgumentException();
		}
		this.fIgnoreCase = ignoreCase;
		this.fIgnoreWildCards = ignoreWildCards;
		this.fPattern = pattern;
		this.fLength = pattern.length();

		if (this.fIgnoreWildCards) {
			parseNoWildCards();
		} else {
			parseWildCards();
		}
	}

	/**
	 * Find the first occurrence of the pattern between <code>start</code>
	 * )(inclusive) and <code>end</code>(exclusive).
	 * 
	 * @param text
	 *            the String object to search in
	 * @param start
	 *            the starting index of the search range, inclusive
	 * @param end
	 *            the ending index of the search range, exclusive
	 * @return a <code>StringMatcher.Position</code> object that keeps the
	 *         starting (inclusive) and ending positions (exclusive) of the
	 *         first occurrence of the pattern in the specified range of the
	 *         text; return null if not found or subtext is empty (start==end).
	 *         A pair of zeros is returned if pattern is empty string Note that
	 *         for pattern like "*abc*" with leading and trailing stars,
	 *         position of "abc" is returned. For a pattern like"*??*" in text
	 *         "abcdf", (1,3) is returned
	 */
	public StringMatcher.Position find(final String text, final int start,
			final int end) {
		int newStart = start;
		int newEnd = end;

		if (text == null) {
			throw new IllegalArgumentException();
		}

		int tlen = text.length();
		if (newStart < 0) {
			newStart = 0;
		}
		if (newEnd > tlen) {
			newEnd = tlen;
		}
		if (newEnd < 0 || newStart >= newEnd) {
			return null;
		}
		if (this.fLength == 0) {
			return new Position(newStart, newStart);
		}
		if (this.fIgnoreWildCards) {
			int x = posIn(text, newStart, newEnd);
			if (x < 0) {
				return null;
			}
			return new Position(x, x + this.fLength);
		}

		int segCount = this.fSegments.length;
		if (segCount == 0) {
			// pattern contains only '*'(s)
			return new Position(newStart, newEnd);
		}

		int curPos = newStart;
		int matchStart = -1;
		int i;
		for (i = 0; i < segCount && curPos < newEnd; ++i) {
			String current = this.fSegments[i];
			int nextMatch = regExpPosIn(text, curPos, newEnd, current);
			if (nextMatch < 0) {
				return null;
			}
			if (i == 0) {
				matchStart = nextMatch;
			}
			curPos = nextMatch + current.length();
		}
		if (i < segCount) {
			return null;
		}
		return new Position(matchStart, curPos);
	}

	/**
	 * match the given <code>text</code> with the pattern
	 * 
	 * @return true if matched otherwise false
	 * @param text
	 *            a String object
	 */
	public boolean match(final String text) {
		return match(text, 0, text.length());
	}

	/**
	 * Given the starting (inclusive) and the ending (exclusive) positions in
	 * the <code>text</code>, determine if the given substring matches with
	 * aPattern
	 * 
	 * @return true if the specified portion of the text matches the pattern
	 * @param text
	 *            a String object that contains the substring to match
	 * @param start
	 *            marks the starting position (inclusive) of the substring
	 * @param end
	 *            marks the ending index (exclusive) of the substring
	 */
	public boolean match(final String text, final int start, final int end) {
		int newStart = start;
		int newEnd = end;

		if (null == text) {
			throw new IllegalArgumentException();
		}

		if (newStart > newEnd) {
			return false;
		}

		if (this.fIgnoreWildCards) {
			return (newEnd - newStart == this.fLength)
					&& this.fPattern.regionMatches(this.fIgnoreCase, 0, text,
							newStart, this.fLength);
		}
		int segCount = this.fSegments.length;
		if (segCount == 0 && (this.fHasLeadingStar || this.fHasTrailingStar)) {
			// pattern contains only '*'(s)
			return true;
		}
		if (newStart == newEnd) {
			return this.fLength == 0;
		}
		if (this.fLength == 0) {
			return newStart == newEnd;
		}

		int tlen = text.length();
		if (newStart < 0) {
			newStart = 0;
		}
		if (newEnd > tlen) {
			newEnd = tlen;
		}

		int tCurPos = newStart;
		int bound = newEnd - this.fBound;
		if (bound < 0) {
			return false;
		}
		int i = 0;
		String current = this.fSegments[i];
		int segLength = current.length();

		/* process first segment */
		if (!this.fHasLeadingStar) {
			if (!regExpRegionMatches(text, newStart, current, 0, segLength)) {
				return false;
			}
			++i;
			tCurPos = tCurPos + segLength;
		}
		if ((this.fSegments.length == 1) && (!this.fHasLeadingStar)
				&& (!this.fHasTrailingStar)) {
			// only one segment to match, no wildcards specified
			return tCurPos == newEnd;
		}
		/* process middle segments */
		for (; i < segCount && tCurPos <= bound; ++i) {
			current = this.fSegments[i];
			int currentMatch;
			int k = current.indexOf(StringMatcher.SINGLE_WILD_CARD);
			if (k < 0) {
				currentMatch = textPosIn(text, tCurPos, newEnd, current);
				if (currentMatch < 0) {
					return false;
				}
			} else {
				currentMatch = regExpPosIn(text, tCurPos, newEnd, current);
				if (currentMatch < 0) {
					return false;
				}
			}
			tCurPos = currentMatch + current.length();
		}

		/* process final segment */
		if (!this.fHasTrailingStar && tCurPos != newEnd) {
			int clen = current.length();
			return regExpRegionMatches(text, newEnd - clen, current, 0, clen);
		}
		return i == segCount;
	}

	/**
	 * This method parses the given pattern into segments seperated by wildcard
	 * '*' characters. Since wildcards are not being used in this case, the
	 * pattern consists of a single segment.
	 */
	private void parseNoWildCards() {
		this.fSegments = new String[1];
		this.fSegments[0] = this.fPattern;
		this.fBound = this.fLength;
	}

	/**
	 * Parses the given pattern into segments separated by wildcard '*'
	 * characters.
	 */
	private void parseWildCards() {
		if (this.fPattern.startsWith("*")) { //$NON-NLS-1$
			this.fHasLeadingStar = true;
		}
		if (this.fPattern.endsWith("*")) { //$NON-NLS-1$
			/* make sure it's not an escaped wildcard */
			if (this.fLength > 1
					&& this.fPattern.charAt(this.fLength - 2) != '\\') {
				this.fHasTrailingStar = true;
			}
		}

		Vector<String> temp = new Vector<String>();

		int pos = 0;
		StringBuffer buf = new StringBuffer();
		while (pos < this.fLength) {
			char c = this.fPattern.charAt(pos++);
			switch (c) {
			case '\\':
				if (pos >= this.fLength) {
					buf.append(c);
				} else {
					char next = this.fPattern.charAt(pos++);
					/* if it's an escape sequence */
					if (next == '*' || next == '?' || next == '\\') {
						buf.append(next);
					} else {
						/* not an escape sequence, just insert literally */
						buf.append(c);
						buf.append(next);
					}
				}
				break;
			case '*':
				if (buf.length() > 0) {
					/* new segment */
					temp.addElement(buf.toString());
					this.fBound += buf.length();
					buf.setLength(0);
				}
				break;
			case '?':
				/* append special character representing single match wildcard */
				buf.append(StringMatcher.SINGLE_WILD_CARD);
				break;
			default:
				buf.append(c);
			}
		}

		/* add last buffer to segment list */
		if (buf.length() > 0) {
			temp.addElement(buf.toString());
			this.fBound += buf.length();
		}

		this.fSegments = new String[temp.size()];
		temp.copyInto(this.fSegments);
	}

	/**
	 * @param text
	 *            a string which contains no wildcard
	 * @param start
	 *            the starting index in the text for search, inclusive
	 * @param end
	 *            the stopping point of search, exclusive
	 * @return the starting index in the text of the pattern , or -1 if not
	 *         found
	 */
	protected int posIn(final String text, final int start, final int end) {
		int max = end - this.fLength;

		if (!this.fIgnoreCase) {
			int i = text.indexOf(this.fPattern, start);
			if (i == -1 || i > max) {
				return -1;
			}
			return i;
		}

		for (int i = start; i <= max; ++i) {
			if (text.regionMatches(true, i, this.fPattern, 0, this.fLength)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * @param text
	 *            a simple regular expression that may only contain '?'(s)
	 * @param start
	 *            the starting index in the text for search, inclusive
	 * @param end
	 *            the stopping point of search, exclusive
	 * @param p
	 *            a simple regular expression that may contains '?'
	 * @return the starting index in the text of the pattern , or -1 if not
	 *         found
	 */
	protected int regExpPosIn(final String text, final int start,
			final int end, final String p) {
		int plen = p.length();

		int max = end - plen;
		for (int i = start; i <= max; ++i) {
			if (regExpRegionMatches(text, i, p, 0, plen)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return boolean
	 * @param text
	 *            a String to match
	 * @param tStart
	 *            indicates the starting index of match, inclusive
	 * @param p
	 *            a simple regular expression that may contain '?'
	 */
	protected boolean regExpRegionMatches(final String text, final int tStart,
			final String p, final int pStart, final int plen) {
		int curTStart = tStart;
		int curPStart = pStart;
		int curPlen = plen;

		while (curPlen-- > 0) {
			char tchar = text.charAt(curTStart++);
			char pchar = p.charAt(curPStart++);

			/* process wild cards */
			if (!this.fIgnoreWildCards) {
				/* skip single wild cards */
				if (pchar == StringMatcher.SINGLE_WILD_CARD) {
					continue;
				}
			}
			if (pchar == tchar) {
				continue;
			}
			if (this.fIgnoreCase) {
				if (UCharacter.toUpperCase(tchar) == UCharacter
						.toUpperCase(pchar)) {
					continue;
				}
				// comparing after converting to upper case doesn't handle all
				// cases;
				// also compare after converting to lower case
				if (UCharacter.toLowerCase(tchar) == UCharacter
						.toLowerCase(pchar)) {
					continue;
				}
			}
			return false;
		}
		return true;
	}

	/**
	 * @param text
	 *            the string to match
	 * @param start
	 *            the starting index in the text for search, inclusive
	 * @param end
	 *            the stopping point of search, exclusive
	 * @param p
	 *            a string that has no wildcard
	 * @return the starting index in the text of the pattern , or -1 if not
	 *         found
	 */
	protected int textPosIn(final String text, final int start, final int end,
			final String p) {

		int plen = p.length();
		int max = end - plen;

		if (!this.fIgnoreCase) {
			int i = text.indexOf(p, start);
			if (i == -1 || i > max) {
				return -1;
			}
			return i;
		}

		for (int i = start; i <= max; ++i) {
			if (text.regionMatches(true, i, p, 0, plen)) {
				return i;
			}
		}

		return -1;
	}
}
