/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

/**
 * Generic class for Aspect Element types
 */
public class ComposedEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * List of composed advices
	 */
	private final List<IEditHelperAdvice> composedAdvices;

	/**
	 * Creates a composed edit helper advice from an ordered list of advices
	 */
	public ComposedEditHelperAdvice(List<IEditHelperAdvice> composedAdvices) {
		this.composedAdvices = composedAdvices;
	}

	/**
	 * Returns the list of composed advices for this edit helper advice.
	 * 
	 * @return the list of composed advices
	 */
	protected List<IEditHelperAdvice> getComposedAdvices() {
		return composedAdvices;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			// each composed advice should approve the request
			if(!advice.approveRequest(request)) {
				return false;
			}
		}
		return super.approveRequest(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getBeforeEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getAfterEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getBeforeEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getAfterEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateRelationshipCommand(CreateRelationshipRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getBeforeEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterCreateRelationshipCommand(CreateRelationshipRequest request) {
		ICommand resultCommand = null;
		for(IEditHelperAdvice advice : getComposedAdvices()) {
			ICommand command = advice.getAfterEditCommand(request);
			if(command != null) {
				if(resultCommand != null) {
					resultCommand = resultCommand.compose(command);
				} else {
					resultCommand = command;
				}
			}
		}
		return resultCommand;
	}
}
