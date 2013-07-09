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
package org.eclipse.papyrus.uml.nattable.manager.cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager;
import org.eclipse.papyrus.infra.emf.utils.EMFStringValueConverter;
import org.eclipse.papyrus.infra.emf.utils.MultiConvertedValueContainer;
import org.eclipse.papyrus.infra.emf.utils.ConvertedValueContainer;
import org.eclipse.papyrus.infra.emf.utils.StringValueConverterStatus;
import org.eclipse.papyrus.infra.nattable.model.nattable.EObjectCell;
import org.eclipse.papyrus.infra.nattable.model.nattable.ICell;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattableFactory;
import org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage;
import org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem;
import org.eclipse.papyrus.infra.nattable.model.nattable.Table;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.EStructuralFeatureAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IAxis;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableaxis.IdAxis;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.nattable.Activator;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.utils.EnumerationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * 
 * @author Vincent Lorenzo
 *         This cell manager allows to display properties of stereotypes and execute the set value command
 */
public class UMLFeatureCellManager extends EMFFeatureValueCellManager {

	/**
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         2 objects if this manager is able to manage it : the first one is the edited EObject, the 2nd one is the edited feature (or a string
	 *         representing it)
	 */
	protected List<Object> organizeUMLObject(Object obj1, Object obj2) {
		final List<Object> objects = new ArrayList<Object>();
		if(obj1 instanceof IAxis) {
			obj1 = ((IAxis)obj1).getElement();
		}
		if(obj2 instanceof IAxis) {
			obj2 = ((IAxis)obj2).getElement();
		}
		if(obj2 instanceof Element) {
			objects.add(obj2);
			objects.add(obj1);
		} else if(obj1 instanceof Element) {
			objects.add(obj1);
			objects.add(obj2);
		}

		if(objects.size() == 2) {
			final Object property = objects.get(1);
			String id = "";
			if(property instanceof IdAxis) {
				id = ((IdAxis)property).getElement();
				objects.remove(property);
				objects.add(id);
			} else if(property instanceof String) {
				id = (String)property;
			}
			if(!id.startsWith(UMLTableUtils.PROPERTY_OF_STEREOTYPE_PREFIX)) {
				return Collections.emptyList();
			}
		} else {
			return Collections.emptyList();
		}
		return objects;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public boolean handles(Object obj1, Object obj2) {
		final List<EObject> objects = organizeObject(obj1, obj2);
		if(objects.size() == 2) {
			final EStructuralFeature feature = (EStructuralFeature)objects.get(1);
			final EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return organizeUMLObject(obj1, obj2).size() == 2;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#handlesAxisElement(java.lang.Object)
	 * 
	 * @param obj
	 * @return
	 */
	@Override
	public boolean handlesAxisElement(Object obj) {
		if(super.handlesAxisElement(obj)) {
			if(obj instanceof EStructuralFeatureAxis) {
				obj = ((EStructuralFeatureAxis)obj).getElement();
			}
			final EStructuralFeature feature = (EStructuralFeature)obj;
			EObject featureContainer = feature.eContainer();
			if(UMLPackage.eINSTANCE.eContents().contains(featureContainer)) {
				return true;
			}
		}
		return false;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getValue(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	@Override
	public Object getValue(Object obj1, Object obj2) {
		if(super.handles(obj1, obj2)) {
			return super.getValue(obj1, obj2);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			if(umlObjects.size() == 2) {
				final Element el = (Element)umlObjects.get(0);
				final String id = (String)umlObjects.get(1);
				final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
				final List<Stereotype> stereotypesWithThisProperty = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
				if(stereotypesWithThisProperty.size() == 1) {
					return el.getValue(stereotypesWithThisProperty.get(0), prop.getName());
				} else if(stereotypesWithThisProperty.size() > 1) {
					return "Several stereotypes with this feature are applied -> not yet managed";
				}
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#setValue(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 */
	@Override
	public void setValue(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		if(super.handles(obj1, obj2)) {
			super.setValue(domain, obj1, obj2, newValue);
		} else {
			final Command cmd = getSetValueCommand(domain, obj1, obj2, newValue);
			if(cmd != null) {
				domain.getCommandStack().execute(cmd);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object)
	 * 
	 * @param domain
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 * @return
	 */
	@Override
	public Command getSetValueCommand(EditingDomain domain, Object obj1, Object obj2, Object newValue) {
		if(super.handles(obj1, obj2)) {
			return super.getSetValueCommand(domain, obj1, obj2, newValue);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
			List<Stereotype> stereotypes = UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id);
			if(prop != null) {
				if(stereotypes.size() == 1) {
					final EObject stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
					final EStructuralFeature steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
					final EClassifier eType = steApFeature.getEType();
					if(eType instanceof EDataType && newValue == null) {
						return null;
					}

					final AbstractEditCommandRequest request = new SetRequest((TransactionalEditingDomain)domain, stereotypeApplication, steApFeature, newValue);
					final IElementEditService provider = ElementEditServiceUtils.getCommandProvider(stereotypeApplication);
					final ICommand editCommand = provider.getEditCommand(request);
					System.out.println(editCommand.canExecute());
					return new GMFtoEMFCommandWrapper(editCommand);
				} else {
					//FIXME : not yet managed
				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 *         if the edited feature is an EMF feature -> see {@link EMFFeatureValueCellManager} else if the edited feature is a stereotype property :
	 *         return true if the stereotype is applied on the edited element AND if only one stereotype with this property is applied on the element
	 */
	@Override
	public boolean isCellEditable(Object obj1, Object obj2) {
		if(super.handles(obj1, obj2)) {
			return super.isCellEditable(obj1, obj2);
		} else {
			final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			switch(UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id).size()) {
			case 1:
				final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
				return !prop.isDerived();
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetStringValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      EObject, java.lang.Object, java.lang.Object, java.lang.String, java.util.Map)
	 * 
	 * @param domain
	 * @param tableContext
	 * @param obj1
	 * @param obj2
	 * @param newValue
	 * @param stringResolvers
	 * @return
	 */
	@Override
	public ICommand getSetStringValueCommand(final EditingDomain domain, final Table table, EObject tableContext, final Object obj1, final Object obj2, final String newValue, final EMFStringValueConverter valueSolver) {
		final Object editedObject;
		final Object editedFeature;
		final List<EObject> objects = organizeObject(obj1, obj2);
		final List<Object> umlObjects = organizeUMLObject(obj1, obj2);
		boolean stereotypePropertyCase = false;
		if(objects.size() == 2) {
			editedObject = objects.get(0);
			editedFeature = objects.get(1);
		} else {
			Assert.isTrue(umlObjects.size() == 2);
			editedObject = umlObjects.get(0);
			editedFeature = umlObjects.get(1);
			stereotypePropertyCase = true;
		}
		final TransactionalEditingDomain editingDomain = (TransactionalEditingDomain)domain;

		ConvertedValueContainer<?> solvedValue;
		if(stereotypePropertyCase) {
			final Property prop;
			final List<Stereotype> stereotypes;
			//FIXME faire en sorte de ne pas résoudre plusieurs fois la propriété de stéréotype
			Assert.isTrue(editedFeature instanceof String);
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			switch(UMLTableUtils.getAppliedSteretoypesWithThisProperty(el, id).size()) {
			case 1:
				stereotypes = UMLTableUtils.getAppliedSteretoypesWithThisProperty(((Element)editedObject), (String)editedFeature);
				prop = UMLTableUtils.getRealStereotypeProperty(el, id);
				break;
			default:
				prop = null;
				stereotypes = Collections.emptyList();
			}
			solvedValue = valueSolver.deduceValueFromString(prop, newValue);

			if(prop.getType() instanceof EnumerationLiteral) {
				final EObject stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
				final EStructuralFeature steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
				EEnum eenum = (EEnum)steApFeature.getEType();
				Object value = solvedValue.getConvertedValue();

				if(value instanceof Collection<?>) {
					final Collection<Enumerator> enumeratorList = EnumerationUtil.adaptToEnumeratorList(eenum, (Collection<?>)value);
					if(enumeratorList.size() == ((Collection<?>)value).size()) {
						solvedValue = new MultiConvertedValueContainer<Enumerator>(enumeratorList, solvedValue.getStatus());
					} else {
						IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, "Some enumeration literal can't be resolved", Collections.<String> emptyList());
						solvedValue = new ConvertedValueContainer<Object>(enumeratorList, status);
					}
				} else if(value instanceof EnumerationLiteral) {
					if(value != null) {
						final Enumerator enumerator = EnumerationUtil.adaptToEnumerator(eenum, (EnumerationLiteral)value);
						if(enumerator != null) {
							solvedValue = new ConvertedValueContainer<Enumerator>(enumerator, solvedValue.getStatus());
						} else {
							IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The enumeration literal represented by {0} can be resolved", newValue), Collections.singletonList(newValue));
							solvedValue = new ConvertedValueContainer<Object>(null, status);
						}
					}
				}
			}
		} else {
			solvedValue = valueSolver.deduceValueFromString(editedFeature, newValue);
		}




		final CompositeCommand cmd = new CompositeCommand("Set Value As String Command");
		Object value = solvedValue.getConvertedValue();
		Command setValueCommand = getSetValueCommand(domain, obj1, obj2, value);
		if(setValueCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(setValueCommand));
		}
		final IStatus status = solvedValue.getStatus();
		if(!status.isOK()) {
			if(status.matches(IStatus.ERROR)) {
				cmd.add(new EMFtoGMFCommandWrapper(getCreatePasteErrorCellCommand(editingDomain, table, (EObject)obj1, (EObject)obj2, newValue, status)));
			} else {
				throw new UnsupportedOperationException("The status {0} is not managed");
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return cmd;
	}

	protected Command getCreatePasteErrorCellCommand(final TransactionalEditingDomain domain, final Table table, final EObject rowElement, final EObject columnElement, final String pastedText, final IStatus status) {
		final CompositeCommand command = new CompositeCommand("Create Cell For Error Command");
		EObjectCell cell = null;
		for(final ICell current : table.getCells()) {
			if(current.getRowElement() == rowElement && current.getColumnElement() == columnElement && current instanceof EObjectCell) {
				cell = (EObjectCell)current;
				break;
			}
		}
		//FIXME : find existing cell

		if(cell == null) {
			cell = NattableFactory.eINSTANCE.createEObjectCell();
			SetRequest setRequest = new SetRequest(domain, table, NattablePackage.eINSTANCE.getTable_Cells(), cell);
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(table);
			command.add(provider.getEditCommand(setRequest));

			provider = ElementEditServiceUtils.getCommandProvider(cell);

			setRequest = new SetRequest(domain, cell, NattablePackage.eINSTANCE.getEObjectCell_RowElement(), rowElement);
			command.add(provider.getEditCommand(setRequest));

			setRequest = new SetRequest(domain, cell, NattablePackage.eINSTANCE.getEObjectCell_ColumnElement(), columnElement);
			command.add(provider.getEditCommand(setRequest));
		}

		final PasteProblem problem = NattableFactory.eINSTANCE.createPasteProblem();
		problem.setName("Paste Problem");
		problem.setDescription(status.getMessage());
		problem.setPastedText(pastedText);

		if(status instanceof StringValueConverterStatus) {
			problem.getUnresolvedText().addAll(((StringValueConverterStatus)status).getUnresolvedString());
		}

		SetRequest setProblemRequest = new SetRequest(domain, cell, NattablePackage.eINSTANCE.getICell_Problems(), problem);
		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(cell);
		command.add(provider.getEditCommand(setProblemRequest));
		return new GMFtoEMFCommandWrapper(command);
	}



}
