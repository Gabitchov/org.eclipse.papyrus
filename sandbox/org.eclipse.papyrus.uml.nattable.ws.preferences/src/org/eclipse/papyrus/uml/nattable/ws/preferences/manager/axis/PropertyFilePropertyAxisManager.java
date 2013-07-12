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
package org.eclipse.papyrus.uml.nattable.ws.preferences.manager.axis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.ws.preferences.utils.Constants;


public class PropertyFilePropertyAxisManager extends AbstractAxisManager {

	@Override
	public void init(INattableModelManager manager, AxisManagerRepresentation rep, AbstractAxisProvider provider) {
		super.init(manager, rep, provider);
	}

	@Override
	public NattableModelManager getTableManager() {
		return super.getTableManager();
	}

	@Override
	public boolean canInsertAxis(Collection<Object> objectsToAdd, int index) {
		return super.canInsertAxis(objectsToAdd, index);
	}

	@Override
	public boolean canCreateAxisElement(String elementId) {
		return super.canCreateAxisElement(elementId);
	}

	@Override
	public boolean canDropAxisElement(Collection<Object> objectsToAdd) {
		return super.canDropAxisElement(objectsToAdd);
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public boolean canBeUsedAsRowManager() {
		return super.canBeUsedAsRowManager();
	}

	@Override
	public boolean canBeUsedAsColumnManager() {
		return super.canBeUsedAsColumnManager();
	}

	@Override
	public Command getAddAxisCommand(EditingDomain domain, Collection<Object> objectToAdd) {
		return super.getAddAxisCommand(domain, objectToAdd);
	}

	@Override
	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index) {
		return super.getInsertAxisCommand(objectsToAdd, index);
	}

	@Override
	public Command getComplementaryAddAxisCommand(EditingDomain domain, Collection<Object> objectToAdd) {
		return super.getComplementaryAddAxisCommand(domain, objectToAdd);
	}

	@Override
	public AbstractAxisProvider getRepresentedContentProvider() {
		return super.getRepresentedContentProvider();
	}

	@Override
	public void setHeaderDataValue(int columnIndex, int rowIndex, Object newValue) {
		super.setHeaderDataValue(columnIndex, rowIndex, newValue);
	}

	@Override
	public boolean isAllowedContents(Object object) {
		return super.isAllowedContents(object);
	}

	@Override
	public boolean canMoveAxis() {
		return super.canMoveAxis();
	}

	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {
		return super.createPossibleAxisContentProvider(isRestricted);
	}

	@Override
	public Command getDestroyAxisCommand(EditingDomain domain, Collection<Object> objectToDestroy) {
		return super.getDestroyAxisCommand(domain, objectToDestroy);
	}

	@Override
	public Collection<Object> getAllManagedAxis() {
		List<Object> rowElements = getTableManager().getRowElementsList();//FIXME use the best way for that!
		Collection<Object> values = new ArrayList<Object>();
		for(final Object current : rowElements) {
			if(current instanceof String) {
				//				String filePath = body.replace("wsPref:/", "");
				Properties currentProp = new Properties();
				try {
					currentProp.load(new FileInputStream(((String)current).replace(Constants.WORKSPACE_PREFIX, "")));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Set<Entry<Object, Object>> entrySet = ((Properties)currentProp).entrySet();
				for(Entry<Object, Object> entry : entrySet) {
					values.add(Constants.PROPERTY_PREFIX + entry.getKey());
				}
				currentProp.clear();
				//				Enumeration<Object> elements = currentProp.elements();
				//				while(elements.hasMoreElements()) {
				//					values.add(elements.nextElement());
				//				}
				//				int i = 0;
				//				i++;
				//				//				comments.add(current);
				//				prop.add(currentProp);
			}
			//			if(current instanceof Properties) {
			//				values.addAll(((Properties)current).entrySet());
			//				Enumeration<Object> el = ((Properties)current).elements();
			//				while(el.hasMoreElements()) {
			//					System.out.println(((Properties)current).get(el.nextElement()));
			//
			//					//					System.out.println(((Properties)current).getProperty(el.nextElement()));
			//					//					System.out.println(el.nextElement());
			//				}
			//				//				Object next = el.nextElement();
			//				//				int i = 0;
			//				//				i++;
			//			}
		}
		return values;
	}

	@Override
	protected EditingDomain getTableEditingDomain() {
		return super.getTableEditingDomain();
	}

	@Override
	protected EditingDomain getContextEditingDomain() {
		return super.getContextEditingDomain();
	}

	@Override
	public void moveAxis(Object elementToMove, int newIndex) {
		super.moveAxis(elementToMove, newIndex);
	}

	@Override
	public void openEditAxisAliasDialog(NatEventData event, int axisPosition) {
		super.openEditAxisAliasDialog(event, axisPosition);
	}

	@Override
	public String getElementAxisName(IAxis axis) {
		return super.getElementAxisName(axis);
	}

	@Override
	public AxisManagerRepresentation getAxisManagerRepresentation() {
		return super.getAxisManagerRepresentation();
	}

	@Override
	public boolean canDestroyAxis(List<Integer> axisPositions) {
		return super.canDestroyAxis(axisPositions);
	}

	@Override
	public boolean canDestroyAxisElement(List<Integer> axisPositions) {
		return super.canDestroyAxisElement(axisPositions);
	}

	@Override
	public void destroyAxis(List<Integer> axisPositions) {
		super.destroyAxis(axisPositions);
	}

	@Override
	public boolean canDestroyAxis(Integer axisPosition) {
		return super.canDestroyAxis(axisPosition);
	}

	@Override
	protected List<Object> getElements(List<Integer> axisPositions) {
		return super.getElements(axisPositions);
	}

	@Override
	public void destroyAxisElement(List<Integer> axisPosition) {
		super.destroyAxisElement(axisPosition);
	}

	@Override
	protected List<Object> getElements() {
		return super.getElements();
	}

	@Override
	public boolean isSlave() {
		return false;
	}

	//	@Override
	//	public boolean isDynamic() {
	//		return true;
	//	}

	@Override
	public boolean canEditAxisHeader() {
		return false;
	}

	@Override
	public boolean canDestroyAxisElement(Integer axisIndex) {
		return false;
	}

	@Override
	public Command getDestroyAxisElementCommand(EditingDomain domain, Integer axisPosition) {
		return null;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

}
