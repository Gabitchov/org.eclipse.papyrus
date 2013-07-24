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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.nattable.handler;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.nebula.widgets.nattable.coordinate.PositionCoordinate;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.NattablecellPackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * 
 * @author VL222926
 * 
 */
//FIXME : we must replace this handler by a dynamic menu to be able to remove several problems in the same cell

public class ResolvedProblemHandler extends AbstractTableHandler {

	/**
	 * the problem to destroy
	 */
	private Problem problemToDestroy;

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		final TransactionalEditingDomain domain = (TransactionalEditingDomain)getTableEditingDomain();
		DestroyElementRequest request = new DestroyElementRequest(domain, problemToDestroy, false);
		final Cell cell = (Cell)problemToDestroy.eContainer();
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cell);
		CompositeCommand composite = new CompositeCommand("Destroy Problem Command"); //$NON-NLS-1$
		composite.add(provider.getEditCommand(request));

		//FIXME : improve me and move me into an edit helper when we will have customization for the cell
		composite.add(new AbstractTransactionalCommand(domain, "Clean Table Model : remove empty Cell", null) { //$NON-NLS-1$

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				boolean isEmpty = true;
				if(cell.getProblems().size() == 0) {
					Collection<EStructuralFeature> featureToIgnore = new ArrayList<EStructuralFeature>();
					featureToIgnore.add(EcorePackage.eINSTANCE.getEModelElement_EAnnotations());
					featureToIgnore.add(NattablecellPackage.eINSTANCE.getCell_ColumnWrapper());
					featureToIgnore.add(NattablecellPackage.eINSTANCE.getCell_RowWrapper());
					Collection<EStructuralFeature> allFeatures = new ArrayList<EStructuralFeature>(cell.eClass().getEAllStructuralFeatures());
					allFeatures.removeAll(featureToIgnore);
					for(EStructuralFeature eStructuralFeature : allFeatures) {
						if(eStructuralFeature.isMany()) {
							if(!((Collection<?>)cell.eGet(eStructuralFeature)).isEmpty()) {
								isEmpty = false;
							}
						} else {
							if(cell.eGet(eStructuralFeature) != eStructuralFeature.getDefaultValue()) {
								isEmpty = false;
							}
						}

					}
				}
				if(isEmpty) {
					DestroyElementRequest request = new DestroyElementRequest(domain, cell, false);
					//					final Cell cell = (Cell)problemToDestroy.eContainer();
					IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cell.eContainer());
					provider.getEditCommand(request).execute(null, null);
				}
				return null;
			}
		});
		Command cmd = new GMFtoEMFCommandWrapper(composite);
		domain.getCommandStack().execute(cmd);
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.handler.AbstractTableHandler#setEnabled(java.lang.Object)
	 * 
	 * @param evaluationContext
	 */
	@Override
	public void setEnabled(Object evaluationContext) {
		super.setEnabled(evaluationContext);
		problemToDestroy = null;
		if(isEnabled() && wrapper != null) {
			Collection<PositionCoordinate> selectionCells = wrapper.getSelectedCells();
			if(selectionCells.size() == 1) {
				final PositionCoordinate positionCoordinate = selectionCells.iterator().next();
				final INattableModelManager nattableManager = getCurrentNattableModelManager();
				final Object rowElement;
				final Object columnElement;
				if(!nattableManager.getTable().isInvertAxis()) {
					rowElement = nattableManager.getRowElement(positionCoordinate.getRowPosition());
					columnElement = nattableManager.getColumnElement(positionCoordinate.getColumnPosition());
				} else {
					columnElement = nattableManager.getRowElement(positionCoordinate.getRowPosition());
					rowElement = nattableManager.getColumnElement(positionCoordinate.getColumnPosition());
				}

				final Cell cell = nattableManager.getCell(columnElement, rowElement);
				if(cell != null) {
					final Collection<Problem> problems = cell.getProblems();
					if(problems.size() == 1) {
						problemToDestroy = problems.iterator().next();
					}
				}
			}
		}
		setBaseEnabled(problemToDestroy != null);
	}

}
