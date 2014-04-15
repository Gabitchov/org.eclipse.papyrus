/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ansgar Radermacher  ansgar.radermacher@cea.fr  
 *
 *****************************************************************************/

package org.eclipse.papyrus.qompass.designer.core;

import java.util.Iterator;

import org.eclipse.papyrus.qompass.designer.core.transformations.LazyCopier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.Type;

public class OperationUtils {

	/**
	 * Search an identical operation within a class.
	 * This function is useful to identify (and synchronize) operations.
	 * 
	 * @param op
	 *        The operation that should be compared.
	 * @param owner
	 * @return
	 */
	public static Operation getSameOperation(Operation op, Class owner) {
		for(Operation ownedOp : owner.getOwnedOperations()) {
			if(isSameOperation(op, ownedOp)) {
				return ownedOp;
			}
		}
		return null;
	}

	/**
	 * Returns true, if two operations are identical.
	 * An operation is considered identical, if the operation name as well as all
	 * parameter names and types are equal. Type equality is checked via names only, to
	 * avoid that identical types within a source and a copy model would yield false.
	 * 
	 * @param op1 first operation
	 * @param op2 second operation
	 * @return true, if operations are identical
	 */
	public static boolean isSameOperation(Operation op1, Operation op2) {
		return isSameOperation(op1, op2, true);
	}
	
	
	/**
	 * Returns true, if two operations are identical with optional name check.
	 * An operation is considered identical, if the operation name (optional) as well as all
	 * parameter names and types are equal. Type equality is checked via names only, to
	 * avoid that identical types within a source and a copy model would yield false.
	 * 
	 * @param op1 first operation
	 * @param op2 second operation
	 * @param checkName if true, require that operation names are identical
	 * @return true, if operations are identical
	 */
	public static boolean isSameOperation(Operation op1, Operation op2, boolean checkName) {

		if (checkName) {
			String op1Name = op1.getName();
			String op2Name = op2.getName();
			// 	one of the names might be null
			if(op1Name == null) {
				if(op2Name != null) {
					return false;
				}
			} else if(!op1Name.equals(op2Name)) {
				return false;
			}
		}
		Iterator<Parameter> parameters1 = op1.getOwnedParameters().iterator();
		Iterator<Parameter> parameters2 = op2.getOwnedParameters().iterator();
		while(parameters1.hasNext() && parameters2.hasNext()) {
			Parameter parameter1 = parameters1.next();
			Parameter parameter2 = parameters2.next();
			String par1Name = parameter1.getName();
			Type par1Type = parameter1.getType();
			String par2Name = parameter2.getName();
			Type par2Type = parameter2.getType();

			// one of the names might be null
			if(par1Name == null) {
				if(par2Name != null) {
					return false;
				}
			} else if(!par1Name.equals(par2Name)) {
				return false;
			}
			if((par1Type != null) && (par2Type != null)) {
				// the names might be null. Return false, if only one of these is set
				if(par1Type.getName() == null) {
					if(par2Type.getName() != null) {
						return false;
					}
				}
				else if(!par1Type.getName().equals(par2Type.getName())) {
					return false;
				}
			} else if(par1Type != par2Type) {
				// at least one of the two must be null due to earlier check
				// return false, if they are different, i.e. not both null
				return false;
			}
			if((parameter1.getUpper() != parameter2.getUpper()) ||
				(parameter1.getLower() != parameter2.getLower())) {
				return false;
			}
		}
		// true, if operations have same number of parameters
		return (parameters1.hasNext() == parameters2.hasNext());
	}


	/**
	 * synchronize source and target operation
	 * (remove all parameters, copy afterwards)
	 * 
	 * @param sourceOp
	 *        the source operation
	 * @param targetOp
	 *        the target operation
	 * @param newRoot
	 *        a new root package (e.g. another model). Ensure that types referenced by the
	 *        parameter exist within this root package (copy, if not). Null indicates that no copying
	 *        should be done.
	 * @return
	 */
	public static void syncOperation(Operation sourceOp, Operation targetOp) {
		if(targetOp != null) {
			LazyCopier.copyFeatureModifiers(sourceOp, targetOp);
			// ordered and unique are derived from ret-parameter
			targetOp.setIsQuery(sourceOp.isQuery());
			targetOp.setIsAbstract(sourceOp.isAbstract());
			targetOp.setName(sourceOp.getName());
			targetOp.getOwnedParameters().clear();
			for(Parameter parameter : sourceOp.getOwnedParameters()) {
				Type type = parameter.getType();
				Parameter newParameter =
					targetOp.createOwnedParameter(parameter.getLabel(), type);
				newParameter.setDirection(parameter.getDirection());
				LazyCopier.copyMultElemModifiers(parameter, newParameter);
				StUtils.copyStereotypes(parameter, newParameter);
			}
		}
		StUtils.copyStereotypes(sourceOp, targetOp);
	}
}
