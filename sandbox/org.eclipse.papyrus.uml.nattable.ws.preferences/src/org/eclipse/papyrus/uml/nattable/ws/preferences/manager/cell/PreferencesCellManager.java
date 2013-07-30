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
package org.eclipse.papyrus.uml.nattable.ws.preferences.manager.cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.uml.nattable.ws.preferences.Activator;
import org.eclipse.papyrus.uml.nattable.ws.preferences.utils.Constants;


public class PreferencesCellManager extends AbstractCellManager {

	@Override
	public boolean handles(Object columnElement, Object rowElement) {
		return organizedAndResolvedValue(columnElement, rowElement) != null;
	}

	@Override
	protected Object doGetValue(Object columnElement, Object rowElement, INattableModelManager tableManager) {
		final List<Object> elements = organizedAndResolvedValue(columnElement, rowElement);
		Properties prop = new Properties();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(new File((String)elements.get(0)));

		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		}
		try {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		}

		String propName = (String)elements.get(1);
		try {
			fis.close();
		} catch (IOException e) {
			Activator.log.error(e);
		}
		if(prop.containsKey(propName)) {
			return prop.getProperty(propName);
		}
		return NOT_AVALAIBLE;
	}

	@Override
	public void setValue(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {
		final List<Object> elements = organizedAndResolvedValue(columnElement, rowElement);
		Properties prop = new Properties();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(new File((String)elements.get(0)));
			fos = new FileOutputStream(new File((String)elements.get(0)));
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		}
		if(fis != null) {
			//			try {
			try {
				prop.load(fis);
				String propName = (String)elements.get(1);
				prop.put(propName, newValue);

				prop.store(fos, "");
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
		if(fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
		if(fos != null) {
			try {
				fos.close();
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
		prop.clear();
	}

	@Override
	public boolean isCellEditable(Object columnElement, Object rowElement) {
		final List<Object> elements = organizedAndResolvedValue(columnElement, rowElement);
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(new File((String)elements.get(0)));
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		}
		try {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			Activator.log.error(e);
		} catch (IOException e) {
			Activator.log.error(e);
		}
		try {
			fis.close();
		} catch (IOException e) {
			Activator.log.error(e);
		}
		String propName = (String)elements.get(1);

		return prop.containsKey(propName);
	}

	@Override
	public Command getSetValueCommand(TransactionalEditingDomain domain, Object columnElement, Object rowElement, Object newValue, INattableModelManager tableManager) {
		return super.getSetValueCommand(domain, columnElement, rowElement, newValue, tableManager);
	}

	protected List<Object> organizedAndResolvedValue(final Object columnlement, final Object rowElement) {
		List<Object> elements = null;
		if(columnlement instanceof String && ((String)columnlement).startsWith(Constants.PROPERTY_PREFIX) && rowElement instanceof String && ((String)rowElement).startsWith(Constants.WORKSPACE_PREFIX)) {
			elements = new ArrayList<Object>();
			elements.add(((String)rowElement).replace(Constants.WORKSPACE_PREFIX, ""));
			elements.add(((String)columnlement).replace(Constants.PROPERTY_PREFIX, ""));
		} else if(rowElement instanceof String && ((String)rowElement).startsWith(Constants.PROPERTY_PREFIX) && columnlement instanceof String && ((String)columnlement).startsWith(Constants.WORKSPACE_PREFIX)) {
			elements = new ArrayList<Object>();
			elements.add(((String)columnlement).replace(Constants.WORKSPACE_PREFIX, ""));
			elements.add(((String)rowElement).replace(Constants.PROPERTY_PREFIX, ""));

		}

		return elements;

	}
}
