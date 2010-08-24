/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.service.creation;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/***
 * this is a filter to add as an editHelper advice.
 * this filter can be activated to take account the condition of the filter or deactivated
 * 
 * the filter consists of writing a condition  into the validateRequest method.
 * 
 *
 */
public abstract class PapyrusEditHelperFilter extends AbstractEditHelperAdvice {
	protected boolean active=true;
	protected String goal="";

	/**
	 * 
	 * @return true if this filter is active
	 */
	public boolean isActivated(){return active;}
	/**
	 * set the activation of this filter
	 * @param activated true to activate
	 */
	public void setActivated(boolean activated){
		this.active=activated;
	}

	/**
	 * set a goal for this filter, example: do not allow creation of operation into requirement class
	 * @param goal
	 */
	public void setGoal(String goal){
		this.goal= goal;
	}
	/**
	 * 
	 * @return the goal of this filter, example: do not allow creation of operation into requirement class
	 */
	public String getGoal(){
		return goal;
	}
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		if(active){
		return validateRequest(request);}
		else return super.approveRequest(request);
	}
	/**
	 * indicate is the request is valid, if no the command will not returned
	 * @param request the request to validate
	 * @return true or false
	 */
	public abstract boolean validateRequest (IEditCommandRequest request) ;
}
