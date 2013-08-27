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

package org.eclipse.papyrus.qompass.designer.validation.constraints;

/**
 * Check whether two operations have the same name *and* have indistinguishable parameter lists
 * 
 * While UML demands that all members of a name-space have a unique name, this is more strict than
 * the requirements of programming languages. Many OO languages allow for identical operation names
 * if the operation can be uniquely identified via the type and number of parameters.
 *
 */
public class DuplicateOperation {

}
