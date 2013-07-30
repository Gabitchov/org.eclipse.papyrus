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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.nebula.widgets.nattable.ui.NatEventData;
import org.eclipse.papyrus.infra.nattable.manager.axis.AbstractSynchronizedOnFeatureAxisManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.manager.table.NattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisconfiguration.AxisManagerRepresentation;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxisprovider.AbstractAxisProvider;
import org.eclipse.papyrus.infra.widgets.providers.IRestrictedContentProvider;
import org.eclipse.papyrus.uml.nattable.ws.preferences.utils.Constants;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

//FIXME : all input and output steam must be closed in this plugin!!! VERIFY THEM
public class PropertyFileAxisManager extends AbstractSynchronizedOnFeatureAxisManager {

	@Override
	public void init(INattableModelManager manager, AxisManagerRepresentation rep, AbstractAxisProvider provider) {
		super.init(manager, rep, provider);
	}

	/**
	 * add a listener on the table context to listen the required feature
	 */
	protected void addContextFeatureValueListener() {
		this.featureListener = new AdapterImpl() {

			@Override
			public void notifyChanged(Notification msg) {
				if(getListenFeatures().contains(msg.getFeature())) {//FIXME : create our own adapter for derived/subset feature
					getTableManager().updateAxisContents(getRepresentedContentProvider());
					if(getRepresentedContentProvider() == getTableManager().getHorizontalAxisProvider()) {
						getTableManager().updateAxisContents(getTableManager().getVerticalAxisProvider());
					} else {
						getTableManager().updateAxisContents(getTableManager().getHorizontalAxisProvider());
					}

				}
			};
		};

		getTableContext().eAdapters().add(this.featureListener);
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
	public Command getAddAxisCommand(TransactionalEditingDomain domain, Collection<Object> objectToAdd) {
		return super.getAddAxisCommand(domain, objectToAdd);
	}

	@Override
	public Command getInsertAxisCommand(Collection<Object> objectsToAdd, int index) {
		return super.getInsertAxisCommand(objectsToAdd, index);
	}

	@Override
	public Command getComplementaryAddAxisCommand(TransactionalEditingDomain domain, Collection<Object> objectToAdd) {
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
		return true;
	}

	@Override
	public IRestrictedContentProvider createPossibleAxisContentProvider(boolean isRestricted) {
		return super.createPossibleAxisContentProvider(isRestricted);
	}

	@Override
	public Command getDestroyAxisCommand(TransactionalEditingDomain domain, Collection<Object> objectToDestroy) {
		return super.getDestroyAxisCommand(domain, objectToDestroy);
	}

	@Override
	public Collection<Object> getAllManagedAxis() {
		final Element el = (Element)getTableContext();
		List<Object> comments = new ArrayList<Object>();
		Collection<Object> prop = new HashSet<Object>();
		Properties properties = new Properties();
		for(final Comment current : el.getOwnedComments()) {
			String body = current.getBody();
			if(body.startsWith(Constants.WORKSPACE_PREFIX)) {

				//				Properties currentProp = new Properties();
				//				try {
				//					currentProp.load(new FileInputStream(filePath));
				//				} catch (FileNotFoundException e) {
				//					e.printStackTrace();
				//				} catch (IOException e) {
				//					e.printStackTrace();
				//				}
				//				//				comments.add(current);
				//				prop.add(currentProp);
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(body.replace(Constants.WORKSPACE_PREFIX, ""));
					properties.load(fis);
					prop.add(body);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(fis != null) {
						try {
							fis.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					prop.clear();
				}

			} else if(body.startsWith(Constants.FOLDER)) {
				//				String path = body.replace(Constants.FOLDER, newChar)
				File folder = new File(body.replace(Constants.FOLDER, ""));
				File[] listOfFiles = folder.listFiles();

				for(int i = 0; i < listOfFiles.length; i++) {
					if(listOfFiles[i].isFile()) {
						prop.add(Constants.WORKSPACE_PREFIX + listOfFiles[i].getAbsolutePath());
						//						System.out.println("File " + listOfFiles[i].getAbsolutePath());
						//						prop.add(e)
					} else if(listOfFiles[i].isDirectory()) {
						System.out.println("Directory " + listOfFiles[i].getName());
					}
				}
			}
		}

		properties.clear();
		return prop;
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
	public Command getDestroyAxisElementCommand(TransactionalEditingDomain domain, Integer axisPosition) {
		return null;
	}

}
