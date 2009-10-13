/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.parsers.texteditor.completionproposals;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.papyrus.parsers.messages.NFPMessages;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Property;

public class VSL_Tuple_CompletionProposal implements ICompletionProposalComputer {

	private static DataType dataType;

	private static String tupleTypeString;

	public void setDataType(DataType datatype) {
		dataType = datatype;
	}

	/**
	 * 
	 * @return returns the string containing properties of the data type for completion
	 */
	public static String computeTVL_Tuple_String() {
		String tupleString = "(";
		tupleTypeString = "(";
		// if datatype is defined
		if (dataType != null) {
			if (dataType.getOwnedAttributes().size() > 0) {
				Iterator<Property> propIter = dataType.getAllAttributes().iterator();
				while (propIter.hasNext()) {
					Property prop = propIter.next();
					DataType propType = (DataType) prop.getType();
					tupleString += prop.getName() + "=";
					if (prop.getDefault() != null)
						tupleString += prop.getDefault();
					tupleString += " , ";
					tupleTypeString += prop.getName() + ": " + propType.getName() + ", ";
				}
			} else {
				tupleString = dataType.getName();
			}
		}

		tupleString = tupleString.substring(0, tupleString.length() - 3);
		tupleString += ")";
		tupleTypeString = tupleTypeString.substring(0, tupleTypeString.length() - 2);
		tupleTypeString += ")";
		return tupleString;
	}

	/** Text inserted in the editor */
	/*
	 * final static private String[] TVL_Tuple_Strings = { computeTVL_Tuple_String(), };
	 */

	/** Text displayed in the information window */
	final static private String[] TVL_Tuple_StringsInfo = { NFPMessages.Tuple_StringsInfo, };

	/** Text displayed in the completion area window */
	final static private String[] TVL_Tuple_StringName = { NFPMessages.Tuple_StringName, };

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.classdiagram.parsers.texteditor.completionproposals.ICompletionProposalComputer
	 * #generateCompletionProposals(int, int, java.lang.String)
	 */
	public List<ICompletionProposal> generateCompletionProposals(int documentOffset, int selectionRange, String prefix) {
		Vector<ICompletionProposal> v = new Vector<ICompletionProposal>();

		// adds each Completion proposal
		ICompletionProposal proposal = null;
		String tupleString = computeTVL_Tuple_String();
		if (tupleString.startsWith(prefix)) {
			proposal = new CompletionProposal(tupleString, documentOffset - prefix.length(), prefix.length()
					+ selectionRange, tupleString.length() - 1, null, tupleTypeString, null, TVL_Tuple_StringsInfo[0]);
			v.add(proposal);
		}
		return v;
	}
}
