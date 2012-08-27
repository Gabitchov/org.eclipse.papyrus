/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdiagram.providers;

import org.eclipse.papyrus.sysml.diagram.blockdiagram.expressions.SYSMLOCLFactory;
import org.eclipse.papyrus.sysml.diagram.blockdiagram.part.SysmlDiagramEditorPlugin;
import org.eclipse.uml2.uml.NamedElement;

/**
 * @generated
 */
public class ElementInitializers {


	/**
	 * Initialize the name of a namedElement
	 * 
	 * @param namedElement
	 *        the namedElement
	 */
	public static void init_NamedElement(NamedElement namedElement) {
		init_NamedElement(namedElement, "", namedElement.eClass().getName(), "");
	}

	/**
	 * Initialize the name of a namedElement
	 * 
	 * @param namedElement
	 *        the namedElement
	 * @param body
	 *        the text that will be used for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String body) {
		init_NamedElement(namedElement, "", body, "");
	}

	/**
	 * Initialize the name of a namedElement with a given suffix
	 * 
	 * @param namedElement
	 *        the namedElement
	 * @param prefix
	 *        the prefix for the name
	 * @param body
	 *        the body used for the name
	 * @param suffix
	 *        a suffix for the name
	 */
	public static void init_NamedElement(NamedElement namedElement, String prefix, String body, String suffix) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("let base : String = \'"); //$NON-NLS-1$
			sb.append(prefix);
			sb.append(body);
			sb.append(suffix);
			sb.append("\' in\r\nlet suffixes : Sequence(String) = Sequence {\'\', \'1\', \'2\', \'3\', \'4\', \'5\', \'6\', \'7\', \'8\', \'9\', \'10\'} in \r\nlet space : Namespace = self.namespace in\r\nlet allMissed : Sequence(String) = suffixes->\r\n    select(s : String | not space.member->exists(e : NamedElement | e.name = base.concat(s))\r\n    ) in\r\nlet firstMissed : String = allMissed->first() in \r\nlet noMisses : Boolean = firstMissed.oclIsUndefined() in\r\nlet allNames : Set(String) = \r\n    if noMisses \r\n    then \r\n    space.member->collect(e : NamedElement | \r\n         if e = self or e.name.oclIsUndefined() or e.name.substring(1, e.name.size().min(base.size())) <> base\r\n         then \'\' \r\n         else e.name \r\n         endif)->asSet()->excluding(\'\') else Set{\'not in use\'} \r\n    endif in \r\nlet longestName : String = \r\n    if noMisses\r\n    then allNames->select(n : String | not allNames->exists(nn : String | nn.size() > n.size()))->asSequence()->first() \r\n    else \'not in use\' \r\n    endif in \r\nif noMisses then \r\n    if longestName.oclIsUndefined() \r\n    then base \r\n    else longestName.concat(\'1\') \r\n    endif \r\nelse \r\n    base.concat(firstMissed) \r\nendif "); //$NON-NLS-1$

			Object value_0 = SYSMLOCLFactory.getExpression(sb.toString(), namedElement.eClass()).evaluate(namedElement);
			namedElement.setName((String)value_0);
		} catch (RuntimeException e) {
			SysmlDiagramEditorPlugin.getInstance().logError("Element initialization failed", e); //$NON-NLS-1$						
		}
	}
}
