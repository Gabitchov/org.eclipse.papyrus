/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;

// TODO: Auto-generated Javadoc
/**
 * Command to remove the value of a collection feature of a model element.
 * 
 * @author <a href="mailto:fjcano@prodevelop.es">Francisco Javier Cano Muñoz</a>
 */
public class RemoveValueCommand extends EditElementCommand {

	/** The feature whose value should be removed. */
	private final EStructuralFeature feature;

	/** The value. */
	private final Object value;

	/**
	 * Constructs a new command to remove the value of a feature of a model element.
	 * 
	 * @param request
	 *        the set value request
	 */
	public RemoveValueCommand(RemoveValueRequest request) {
		super(request.getLabel(), request.getElementToEdit(), request);

		this.feature = request.getFeature();
		this.value = request.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.gmf.runtime.emf.commands.core.command. AbstractTransactionalCommand#
	 * doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 * org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// TODO

		EObject elementToEdit = getElementToEdit();
		boolean many = FeatureMapUtil.isMany(elementToEdit, feature);
		if(many) {
			Collection collection = ((Collection)elementToEdit.eGet(feature));
			if(value instanceof List) {
				List values = (List)value;

				for(Object o : values) {
					if(collection.contains(o)) {
						collection.remove(o);
					}
				}
			} else {
				collection.remove(value);
			}
		} else {
			return CommandResult.newErrorCommandResult("Feature " + feature.getName() + " is not a collection");
		}
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Checks that the feature is a modifiable feature of the element whose value will be removed by
	 * this command. Also checks that the value is of the correct type for the feature.
	 * 
	 * @return true, if can execute
	 */
	@Override
	public boolean canExecute() {

		EObject elementToEdit = getElementToEdit();
		if(elementToEdit == null || !super.canExecute()) {
			return false;
		}
		boolean many = FeatureMapUtil.isMany(elementToEdit, feature);
		if(value == null && many) {
			return false;
		}
		List allFeatures = getElementToEdit().eClass().getEAllStructuralFeatures();
		if(allFeatures.contains(feature) && feature.isChangeable()) {
			return verifyMany();
		}
		return false;
	}

	/**
	 * Verify many.
	 * 
	 * @return true, if successful
	 */
	private boolean verifyMany() {
		if(value instanceof List) {
			List values = (List)value;
			for(Iterator iter = values.iterator(); iter.hasNext();) {
				Object element = iter.next();
				if(!feature.getEType().isInstance(element)) {
					return false;
				}
			}
			return true;
		}
		return false;
		// return feature.getEType().isInstance(value);
	}

}
