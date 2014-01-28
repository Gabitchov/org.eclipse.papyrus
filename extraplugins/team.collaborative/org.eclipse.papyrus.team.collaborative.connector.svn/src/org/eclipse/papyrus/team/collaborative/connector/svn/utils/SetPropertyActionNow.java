/*******************************************************************************
 * Copyright (c) 2013 Atos
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Arthur Daussy - initial implementation
 *******************************************************************************/
package org.eclipse.papyrus.team.collaborative.connector.svn.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.team.svn.core.IStateFilter;
import org.eclipse.team.svn.core.connector.SVNProperty;
import org.eclipse.team.svn.core.extension.CoreExtensionsManager;
import org.eclipse.team.svn.core.extension.properties.IPredefinedPropertySet;
import org.eclipse.team.svn.core.extension.properties.PredefinedProperty;
import org.eclipse.team.svn.core.operation.AbstractActionOperation;
import org.eclipse.team.svn.core.operation.CompositeOperation;
import org.eclipse.team.svn.core.operation.IActionOperation;
import org.eclipse.team.svn.core.operation.local.RefreshResourcesOperation;
import org.eclipse.team.svn.core.operation.local.property.IPropertyProvider;
import org.eclipse.team.svn.core.operation.local.property.SetMultiPropertiesOperation;
import org.eclipse.team.svn.core.operation.local.property.SetPropertiesOperation;
import org.eclipse.team.svn.core.resource.ILocalResource;
import org.eclipse.team.svn.core.utility.FileUtility;
import org.eclipse.team.svn.core.utility.StringMatcher;
import org.eclipse.team.svn.ui.SVNUIMessages;
import org.eclipse.team.svn.ui.action.local.SetPropertyAction;
import org.eclipse.team.svn.ui.composite.PropertiesComposite;
import org.eclipse.team.svn.ui.properties.ResourcePropertyEditPanel;
import org.eclipse.team.svn.ui.utility.UIMonitorUtility;


/**
 * The Class SetPropertyActionNow.
 * Util class used to set SVN property. This implementation set the property immediatly
 */
public class SetPropertyActionNow {

	/**
	 * Do set property.
	 * 
	 * @param resources
	 *        the resources
	 * @param panel
	 *        the panel
	 * @param addOn
	 *        the add on
	 */
	public static void doSetProperty(final IResource[] resources, ResourcePropertyEditPanel panel, IActionOperation addOn) {
		SetPropertyAction.doSetProperty(resources, panel.getPropertyName(), panel.getPropertyValue(), panel.getPropertyFile(), panel.isFileSelected(), panel.isRecursiveSelected(), panel.getApplyMethod(), panel.useMask(), panel.getFilterMask(), panel.isStrict(), addOn);
	}

	/**
	 * Do set property now.
	 * 
	 * @param resources
	 *        the resources
	 * @param propertyName
	 *        the property name
	 * @param value
	 *        the value
	 * @param fileName
	 *        the file name
	 * @param isFileSelected
	 *        the is file selected
	 * @param isRecursive
	 *        the is recursive
	 * @param applyMethod
	 *        the apply method
	 * @param useMask
	 *        the use mask
	 * @param filterMask
	 *        the filter mask
	 * @param strict
	 *        the strict
	 * @param addOn
	 *        the add on
	 */
	public static void doSetPropertyNow(final IResource[] resources, String propertyName, String value, String fileName, boolean isFileSelected, boolean isRecursive, final int applyMethod, boolean useMask, String filterMask, boolean strict, IActionOperation addOn) {
		final SVNProperty[] data = new SVNProperty[]{ new SVNProperty(propertyName, value) };
		IActionOperation loadOp = null;
		if(isFileSelected) {
			final File f = new File(fileName);
			loadOp = new AbstractActionOperation("Operation_SLoadFileContent", SVNUIMessages.class) { //$NON-NLS-1$

				protected void runImpl(IProgressMonitor monitor) throws Exception {
					FileInputStream input = null;
					try {
						input = new FileInputStream(f);
						byte[] binary = new byte[(int)f.length()];
						input.read(binary);
						data[0] = new SVNProperty(data[0].name, new String(binary));
					} finally {
						if(input != null) {
							input.close();
						}
					}
				}
			};
		}
		doSetPropertyNow(resources, data, loadOp, isRecursive, applyMethod, useMask, filterMask, strict, addOn);
	}

	/**
	 * Do set property now.
	 * 
	 * @param resources
	 *        the resources
	 * @param data
	 *        the data
	 * @param loadOp
	 *        the load op
	 * @param isRecursive
	 *        the is recursive
	 * @param applyMethod
	 *        the apply method
	 * @param useMask
	 *        the use mask
	 * @param filterMask
	 *        the filter mask
	 * @param strict
	 *        the strict
	 * @param addOn
	 *        the add on
	 */
	public static void doSetPropertyNow(final IResource[] resources, SVNProperty[] data, IActionOperation loadOp, boolean isRecursive, final int applyMethod, boolean useMask, String filterMask, boolean strict, IActionOperation addOn) {
		ArrayList<SVNProperty> folderPropsList = new ArrayList<SVNProperty>();
		ArrayList<SVNProperty> filePropsList = new ArrayList<SVNProperty>();
		IPredefinedPropertySet set = CoreExtensionsManager.instance().getPredefinedPropertySet();
		for(SVNProperty prop : data) {
			int type = PredefinedProperty.TYPE_COMMON;
			PredefinedProperty pProp = set.getPredefinedProperty(prop.name);
			if(pProp != null) {
				type = pProp.type;
			}
			if(type == PredefinedProperty.TYPE_FILE) {
				filePropsList.add(prop);
			} else if(type == PredefinedProperty.TYPE_FOLDER) {
				folderPropsList.add(prop);
			} else if(type == PredefinedProperty.TYPE_COMMON) {
				filePropsList.add(prop);
				folderPropsList.add(prop);
			}
		}
		final SVNProperty[] folderProps = folderPropsList.toArray(new SVNProperty[folderPropsList.size()]);
		final SVNProperty[] fileProps = filePropsList.toArray(new SVNProperty[filePropsList.size()]);

		final StringMatcher matcher = useMask ? new StringMatcher(filterMask) : null;
		IStateFilter filter = new IStateFilter.AbstractStateFilter() {

			protected boolean allowsRecursionImpl(ILocalResource local, IResource resource, String state, int mask) {
				return IStateFilter.SF_EXCLUDE_PREREPLACED_AND_DELETED.allowsRecursion(resource, state, mask) || state == IStateFilter.ST_ADDED;
			}

			protected boolean acceptImpl(ILocalResource local, IResource resource, String state, int mask) {
				if(applyMethod == PropertiesComposite.APPLY_TO_FILES && resource.getType() != IResource.FILE || applyMethod == PropertiesComposite.APPLY_TO_FOLDERS && resource.getType() == IResource.FILE || !IStateFilter.SF_EXCLUDE_PREREPLACED_AND_DELETED.accept(resource, state, mask) || matcher != null && !matcher.match(resource.getName())) {
					return false;
				}
				return true;
			}
		};

		IActionOperation mainOp;
		if((!isRecursive || applyMethod == PropertiesComposite.APPLY_TO_ALL && !useMask) && folderProps.length == fileProps.length) {
			// use faster version
			mainOp = new SetPropertiesOperation(FileUtility.getResourcesRecursive(resources, filter, IResource.DEPTH_ZERO), data, isRecursive & !strict);
		} else {
			IPropertyProvider propertyProvider = new IPropertyProvider() {

				public SVNProperty[] getProperties(IResource resource) {
					return resource.getType() == IResource.FILE ? fileProps : folderProps;
				}
			};
			mainOp = new SetMultiPropertiesOperation(resources, propertyProvider, filter, isRecursive && !strict ? IResource.DEPTH_INFINITE : IResource.DEPTH_ZERO);
		}
		CompositeOperation composite = new CompositeOperation(mainOp.getId(), mainOp.getMessagesClass());
		if(loadOp != null) {
			composite.add(loadOp);
			composite.add(mainOp, new IActionOperation[]{ loadOp });
		} else {
			composite.add(mainOp);
		}
		if(addOn != null) {
			composite.add(addOn);
		}
		composite.add(new RefreshResourcesOperation(resources, IResource.DEPTH_INFINITE, RefreshResourcesOperation.REFRESH_ALL), new IActionOperation[]{ mainOp });
		UIMonitorUtility.doTaskNowDefault(composite, false);
	}

}
