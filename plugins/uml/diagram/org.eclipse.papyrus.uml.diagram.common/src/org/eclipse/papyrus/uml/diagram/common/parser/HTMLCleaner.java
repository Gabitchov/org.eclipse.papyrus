/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that provides a html cleaner.
 */
public class HTMLCleaner {

	/** map of special html strings and their real value */
	protected static final Map<String, String> specials = new HashMap<String, String>();

	/** symbol requiring new lines */
	protected static final List<String> newLine = new ArrayList<String>();
	
	/** map of special html strings and their real value */
	protected static final Map<String, String> xmlSpecials = new HashMap<String, String>();

	protected static List<String> htmlTags = new ArrayList<String>();
	
	static {
		// initialize the special character map
		specials.put("nbsp", " "); // no-break space
		specials.put("iexcl", "¡"); //inverted exclamation mark
		specials.put("cent", "¢"); //cent sign
		specials.put("pound", "£"); //pound sign
		specials.put("curren", "¤"); //currency sign
		specials.put("yen", "¥"); //yen sign = yuan sign
		specials.put("brvbar", "¦"); //broken bar = brolen vertical bar
		specials.put("sect", "§"); //	section sign
		specials.put("uml", "¨"); //diaeresis = spacing diaeresis
		specials.put("copy", "©"); //copyright sign
		specials.put("ordf", "ª"); //feminine ordinal indicator
		specials.put("laquo", "«"); //left-pointing double angle quotation mark = left pointing guillemet
		specials.put("not", "¬"); //not sign = discretionary hyphen
		specials.put("shy", "­"); //soft hyphen = discretionary hyphen
		specials.put("reg", "®"); //registered sign = registered trade mark sign
		specials.put("macr", "¯"); //macron = spacing macron = overline = APL overbar
		specials.put("deg", "°"); //degree sign
		specials.put("plusmn", "±"); //plus-minus sign = plus-or-minus sign
		specials.put("sup2", "²"); //	superscript two = superscript digit two = squared
		specials.put("sup3", "³"); //	superscript three = superscript digit three = cubed
		specials.put("acute", "´"); //	acute accent = spacing acute
		specials.put("micro", "µ"); //	micro sign
		specials.put("para", "¶"); //	pilcrow sign = paragraph sign
		specials.put("middot", "·"); //	middle dot = Georgian comma = Greek middle dot
		specials.put("ccedil", "¸"); //	cedilla = spacing cedilla
		specials.put("sup1", "¹"); //	superscript one = superscript digit one
		specials.put("ordm", "º"); //	masculine ordinal indicator
		specials.put("raquo", "»"); //	right-pointing double angle quotation mark = right pointing guillemet
		specials.put("frac14", "¼"); //	vulgar fraction one quarter = fraction one quarter
		specials.put("frac12", "½"); //	vulgar fraction one half = fraction one half
		specials.put("frac34", "¾"); //	vulgar fraction three quarters = fraction three quarters
		specials.put("iquest", "¿"); //	inverted question mark = turned question mark
		specials.put("Agrave", "À"); //	latin capital letter A with grave = latin capital letter A grave
		specials.put("Aacute", "Á"); //	latin capital letter A with acute
		specials.put("Acirc", "Â"); //	latin capital letter A with circumflex
		specials.put("Atilde", "Ã"); //	latin capital letter A with tilde
		specials.put("Auml", "Ä"); //	latin capital letter A with diaeresis
		specials.put("Aring", "Å"); //	latin capital letter A with ring above = latin capital letter A ring
		specials.put("AElig", "Æ"); //	latin capital letter AE = latin capital ligature AE
		specials.put("Ccedil", "Ç"); //	latin capital letter C with cedilla
		specials.put("Egrave", "È"); //	latin capital letter E with grave
		specials.put("Eacute", "É"); //	latin capital letter E with acute
		specials.put("Ecirc", "Ê"); //	latin capital letter E with circumflex
		specials.put("Euml", "Ë"); //latin capital letter E with diaeresis
		specials.put("Igrave", "Ì"); //latin capital letter I with grave
		specials.put("Iacute", "Í"); //latin capital letter I with acute
		specials.put("Icirc", "Î"); //latin capital letter I with circumflex
		specials.put("Iuml", "Ï"); //	latin capital letter I with diaeresis
		specials.put("ETH", "Ð"); //latin capital letter ETH
		specials.put("Ntilde", "Ñ"); //latin capital letter N with tilde
		specials.put("Ograve", "Ò"); //latin capital letter O with grave
		specials.put("Oacute", "Ó"); //latin capital letter O with acute
		specials.put("Ocirc", "Ô"); //latin capital letter O with circumflex
		specials.put("Otilde", "Õ"); //latin capital letter O with tilde
		specials.put("Ouml", "Ö"); //latin capital letter O with diaeresis
		specials.put("times", "×"); //multiplication sign
		specials.put("Oslash", "Ø"); //latin capital letter O with stroke = latin capital letter O slash
		specials.put("Ugrave", "Ù"); //latin capital letter U with grave
		specials.put("Uacute", "Ú"); //latin capital letter U with acute
		specials.put("Ucirc", "Û"); //latin capital letter U with circumflex
		specials.put("Uuml", "Ü"); //	latin capital letter U with diaeresis
		specials.put("Yacute", "Ý"); //	latin capital letter Y with acute
		specials.put("THORN", "Þ"); //	latin capital letter THORN
		specials.put("szlig", "ß"); //	latin small letter sharp s = ess-zed
		specials.put("agrave", "à"); //	latin small letter a with grave = latin small letter a grave
		specials.put("aacute", "á"); //	latin small letter a with acute
		specials.put("acirc", "â"); //	latin small letter a with circumflex
		specials.put("atilde", "ã"); //	latin small letter a with tilde
		specials.put("auml", "ä"); //latin small letter a with diaeresis
		specials.put("aring", "å"); //	latin small letter a with ring above = latin small letter a ring
		specials.put("aelig", "æ"); //	latin small letter ae = latin small ligature ae
		specials.put("ccedil", "ç"); //	latin small letter c with cedilla
		specials.put("egrave", "è"); //	latin small letter e with grave
		specials.put("eacute", "é"); //	latin small letter e with acute
		specials.put("ecirc", "ê"); //	latin small letter e with circumflex
		specials.put("euml", "ë"); //	latin small letter e with diaeresis
		specials.put("igrave", "ì"); //	latin small letter i with grave
		specials.put("iacute", "í"); //	latin small letter i with acute
		specials.put("icirc", "î"); //	latin small letter i with circumflex
		specials.put("iuml", "ï"); //latin small letter i with diaeresis
		specials.put("eth", "ð"); //	latin small letter eth
		specials.put("ntilde", "ñ"); //	latin small letter n with tilde
		specials.put("ograve", "ò"); //	latin small letter o with grave
		specials.put("oacute", "ó"); //	latin small letter o with acute
		specials.put("ocirc", "ô"); //	latin small letter o with circumflex
		specials.put("otilde", "õ"); //	latin small letter o with tilde
		specials.put("ouml", "ö"); //latin small letter o with diaeresis
		specials.put("divide", "÷"); //	division sign
		specials.put("oslash", "ø"); //	latin small letter o with stroke = latin small letter o slash
		specials.put("ugrave", "ù"); //	latin small letter u with grave
		specials.put("uacute", "ú"); //	latin small letter u with acute
		specials.put("ucirc", "û"); //	latin small letter u with circumflex
		specials.put("uuml", "ü"); //	latin small letter u with diaeresis
		specials.put("yacute", "ý"); //	latin small letter y with acute
		specials.put("thorn", "þ"); //	latin small letter thorn with
		specials.put("yuml", "ÿ"); //	latin small letter y with diaeresis 
		specials.put("quot", "\""); //quotation mark = APL quote
		specials.put("radic", "√"); //square root = radical sign
		specials.put("infin", "∞"); //infinity
		specials.put("cap", "∩"); //intersection = cap
		specials.put("int", "∫"); //integral 
		xmlSpecials.put("amp", "&"); //ampersand
		xmlSpecials.put("lt", "<"); //less-than sign
		xmlSpecials.put("gt", ">"); //greater-than sign 
		// new line list
		newLine.add("BR"); // new line request
		newLine.add("br");
		newLine.add("BR/");
		newLine.add("br/");
		newLine.add("br /");
		newLine.add("BR /");
		newLine.add("/H1"); // end of header
		newLine.add("/H2");
		newLine.add("/H3");
		newLine.add("/h1");
		newLine.add("/h2");
		newLine.add("/h3");
		newLine.add("/p"); // end of paragraph
		newLine.add("/P");
		newLine.add("/li"); // end of item list
		
		htmlTags.add("h1");
		htmlTags.add("H1");
		htmlTags.add("h2");
		htmlTags.add("H2");
		htmlTags.add("h3");
		htmlTags.add("H3");
		htmlTags.add("BR");
		htmlTags.add("/BR");
		htmlTags.add("br");
		htmlTags.add("/br");
		htmlTags.add("strong");
		htmlTags.add("/strong");
		htmlTags.add("b");
		htmlTags.add("/b");
		htmlTags.add("u");
		htmlTags.add("/u");
		htmlTags.add("i");
		htmlTags.add("/i");
		htmlTags.add("ul");
		htmlTags.add("/ul");
		htmlTags.add("li");
		htmlTags.add("/li");
		htmlTags.add("p");
		htmlTags.add("/p");
		
	}

	public static String removeHTMLTags(String htmlString) throws Exception {
		StringBuffer buffer = new StringBuffer();
		// indicating if parser is in tag
		boolean inTag = false;
		// indicating if parser is in special character
		boolean inSpecial = false;
		// skip the next character
		boolean skip = false;
		// ignore or keep whitespace ?
		boolean keepWhitespace = true;
		// ignore or keep whitespace ?
		boolean keepCarriageReturn = false;
		int length = htmlString.length();
		for(int i = 0; i < length; i++) {
			skip = false;
			char c = htmlString.charAt(i);
			if(c == '<') { // opening a new tag...
				
				// should do specific check for new lines (<BR>, <P>, <H1>,
				// <H2>, etc..)
				// get tag value
				int closingTagIndex =  htmlString.indexOf('>', i);
				if(closingTagIndex > i+1) {
					String tagValue = htmlString.substring(i + 1, closingTagIndex);
					
					if(tagValue !=null) {
						if(htmlTags.contains(tagValue.toLowerCase()) || newLine.contains(tagValue.toLowerCase())) {
							inTag = true;
							if(newLine.contains(tagValue)) {
								if(keepCarriageReturn) {
									buffer.append("\n");
									keepCarriageReturn = false;
								}
								keepWhitespace = false;
							}
						} else {
							buffer.append('<');
						}
					} else {
						buffer.append('<');
					}
				} else {
					buffer.append('<');
				}
				
			} else if(c == '>' && inTag) { // closing tag. must be in tag to
											// close it...
				inTag = false;
				skip = true;
				keepWhitespace = true;
			} else if(c == '&') {
				// this is a special character
				// look for next ';', which closes the special character
				int nextSemiColonIndex = htmlString.indexOf(';', i);
				if(nextSemiColonIndex > i + 1) {
					String specialCharacter = htmlString.substring(i + 1, htmlString.indexOf(';', i));
					String replacement = specials.get(specialCharacter);
					if(replacement == null) {
						replacement = xmlSpecials.get(specialCharacter);
					}
					if(replacement != null) {
						inSpecial = true;
						buffer.append(replacement);
					} else {
						// simple '&' in a non html comment => keep it
						buffer.append('&');
						keepWhitespace = true;
					}
				} else {
					// simple '&' in a non html comment => keep it
					buffer.append('&');
					keepWhitespace = true;
				}
			} else if(c == ';' && inSpecial) {
				inSpecial = false;
				skip = true;
				keepWhitespace = true;
			} else if(c == ' ' || c == '\t') {
				if(keepWhitespace) {
					buffer.append(" ");
				}
				keepWhitespace = false;
			} else if(c == '\n' || c == '\r') {
				if(keepCarriageReturn) {
					buffer.append("\n");
					keepCarriageReturn = false;
					keepWhitespace = false;
				}
			} else if(!skip && !inSpecial && !inTag) {
				buffer.append(c);
				keepWhitespace = true;
				keepCarriageReturn = true;
			}
		}
		return buffer.toString();
	}

	/**
	 * Returns a string derived from the specified string. It removes htlm tags,
	 * adding new line separator when useful.
	 * 
	 * @param htmlString
	 *        the string to clean. It should be neither <code>null</code>,
	 *        nor empty
	 * @return a cleaned string.
	 */
	public static String cleanHTMLTags(String htmlString) {
		StringBuffer buffer = new StringBuffer();
		// indicating if parser is in tag
		boolean inTag = false;
		// indicating if parser is in special character
		boolean inSpecial = false;
		// skip the next character
		boolean skip = false;
		// ignore or keep whitespace ?
		boolean keepWhitespace = true;
		// ignore or keep whitespace ?
		boolean keepCarriageReturn = false;
		int length = htmlString.length();
		for(int i = 0; i < length; i++) {
			skip = false;
			char c = htmlString.charAt(i);
			if(c == ' ' || c == '\t') {
				if(keepWhitespace) {
					buffer.append(" ");
				}
				keepWhitespace = false;
			} else if(c == '\n' || c == '\r') {
				if(keepCarriageReturn) {
					buffer.append("\n");
					keepCarriageReturn = false;
					keepWhitespace = false;
				}
			} else if(!skip && !inSpecial && !inTag) {
				buffer.append(c);
				keepWhitespace = true;
				keepCarriageReturn = true;
			}
		}
		return buffer.toString();
	}

	/**
	 * Pre-clean the specified string
	 * 
	 * @param htmlString
	 *        the string to clean
	 * @return the cleaned string
	 */
	public static String preClean(String htmlString) throws Exception {
		if(htmlString == null) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		// indicating if parser is in special character
		boolean inSpecial = false;
		// skip the next character
		boolean skip = false;
		int length = htmlString.length();
		for(int i = 0; i < length; i++) {
			skip = false;
			char c = htmlString.charAt(i);
			if(c == '&') {
				int nextSemicolon = htmlString.indexOf(';', i);
				// this is a special character
				// look for next ';', which closes the special character
				if(nextSemicolon > i + 1) {
					inSpecial = true;
					String specialCharacter = htmlString.substring(i + 1, nextSemicolon);
					// replace the value with the specified
					String replacement = specials.get(specialCharacter);
					if(replacement != null) {
						buffer.append(replacement);
					} else if(xmlSpecials.get(specialCharacter) != null) {
						buffer.append("&" + specialCharacter + ";");
					}
				} else {
					inSpecial = false;
					buffer.append('&');
				}
			} else if(c == ';' && inSpecial) {
				inSpecial = false;
				skip = true;
			} else if(!skip && !inSpecial) {
				buffer.append(c);
			}
		}
		return buffer.toString();
	}
}
