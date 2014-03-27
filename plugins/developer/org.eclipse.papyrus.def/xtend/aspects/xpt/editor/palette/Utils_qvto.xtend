/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package aspects.xpt.editor.palette

import com.google.inject.Singleton
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.ToolEntry

@Singleton class Utils_qvto extends xpt.editor.palette.Utils_qvto {

	/**
	 * collect all tools availables and valid to generate the palette. A tool is not valid when it does not create either a link or a node 
	 */
	override Iterable<AbstractToolEntry> collectTools(Palette palette) {
		return collectGroups(palette).map[g|g.entries.filter(typeof(AbstractToolEntry))].flatten.filter[tool|isValidTool(tool)]
	}

	def boolean isValidTool(AbstractToolEntry entry) {

		if(entry instanceof ToolEntry) {
			val nodes = (entry as ToolEntry).genNodes.size;
			val links = (entry as ToolEntry).genLinks.size;

			return nodes + links != 0;
		} else {
			return true;
		}
	}

	def String getToolPath(String it) {
		var String result = null

		/** returns the '/' separator and then the id of the parent group path */
		if(isQuoted(it,'"')) {
			result = it.substring(1, it.length - 1)
		} else {
			result = it
		}

		return "/" + result;
	}

	def boolean isQuoted(String source, String quoteStr) {

		if(quoteStr == null) {
			return false;
		}

		return source.length() >= (quoteStr.length() * 2) && source.startsWith(quoteStr) && source.endsWith(quoteStr);

	}

	def getConstantIDName(String it) {
		if(isQuoted(it,'"')) {
			return getUpperAndUnderscoreString(it.substring(1, it.length() - 1))
		} else {
			return getUpperAndUnderscoreString(it)
		}
	}

	def String getUpperAndUnderscoreString(String value) {
		return value.toUpperCase.replace(".", "_")
	}

}
