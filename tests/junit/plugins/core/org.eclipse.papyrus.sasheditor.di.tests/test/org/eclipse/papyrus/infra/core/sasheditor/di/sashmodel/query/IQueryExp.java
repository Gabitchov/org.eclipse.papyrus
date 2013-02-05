/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.sasheditor.di.sashmodel.query;

/**
 * A Query Expression represent an expression used to query a SashModel.
 * Term implementing this interface can be used as starting point of expression.
 * <br>
 * Following classses are expressions: {@link PanelTerm}, {@link WindowTerm}.
 * 
 * @author cedric dumoulin
 *
 */
public interface IQueryExp extends IQueryTerm {

}
