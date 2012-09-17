/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from Class Diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.helper;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.uml.diagram.profile.custom.commands.PropertyCommandForAssociation;
import org.eclipse.papyrus.uml.diagram.profile.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * this is an helper that is specific for the class diagram
 */
public class ProfileDiagramAssociationHelper {

	/**
	 * Returns the created Association corresponding to these parameters
	 * 
	 * @param domain
	 *        the {@link TransactionalEditingDomain}
	 * @param source
	 *        the source of the {@link Association}
	 * @param target
	 *        the target of the {@link Association}
	 * @param container
	 *        the {@link Container} of the {@link Association}
	 * @return
	 *         The created Association corresponding to these parameters
	 */
	public static EObject createAssociation(TransactionalEditingDomain domain, Type source, Type target, Package container) {

		Association association = UMLFactory.eINSTANCE.createAssociation();
		String targetString = target.getName().substring(0, 1).toLowerCase() + target.getName().substring(1, target.getName().length());
		String sourceString = source.getName().substring(0, 1).toLowerCase() + source.getName().substring(1, source.getName().length());
		// create target property
		CreateElementRequest request = new CreateElementRequest(domain, association, UMLElementTypes.Property_3002, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
		EditElementCommand c = new PropertyCommandForAssociation(request);
		try {
			c.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property targetProperty = (Property)c.getCommandResult().getReturnValue();
		targetProperty.setType(target);
		targetProperty.setName(targetString);
		targetProperty.setLower(1);
		targetProperty.setUpper(1);

		//put the property in the class
		if(source instanceof StructuredClassifier) {
			((StructuredClassifier)source).getOwnedAttributes().add(targetProperty);
		}
		// create source property

		request = new CreateElementRequest(domain, association, UMLElementTypes.Property_3002, UMLPackage.eINSTANCE.getAssociation_OwnedEnd());
		c = new PropertyCommandForAssociation(request);
		try {
			c.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert (c.getCommandResult() == null);
		assert (c.getCommandResult().getReturnValue() == null);
		Property sourceProperty = (Property)c.getCommandResult().getReturnValue();
		sourceProperty.setType(source);
		sourceProperty.setName(sourceString);
		sourceProperty.setLower(1);
		sourceProperty.setUpper(1);
		List<Property> memberEnds = association.getMemberEnds();

		if((memberEnds.indexOf((sourceProperty)) >= 0)) {
			association.getMemberEnds().move(0, (sourceProperty));
		} else {
			association.getMemberEnds().add(0, (sourceProperty));
		}
		if((memberEnds.indexOf((targetProperty)) >= 0)) {
			association.getMemberEnds().move(1, (targetProperty));
		} else {
			association.getMemberEnds().add(1, (targetProperty));
		}

		container.getPackagedElements().add(association);
		ElementInitializers.getInstance().init_Association_4001(association);
		String associationName = NamedElementHelper.EINSTANCE.getNewUMLElementName(container, sourceString + "_" + targetString + "_"); //$NON-NLS-1$ //$NON-NLS-2$
		association.setName(associationName);
		return association;
	}
}
