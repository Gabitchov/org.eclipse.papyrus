/*****************************************************************************
 * Copyright (c) 2012, 2014 CEA LIST and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 402525
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.nattable.manager.cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.commands.wrappers.EMFtoGMFCommandWrapper;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattablecell.Cell;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.Problem;
import org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem;
import org.eclipse.papyrus.infra.nattable.paste.PastePostActionRegistry;
import org.eclipse.papyrus.infra.nattable.utils.AxisUtils;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.infra.tools.converter.AbstractStringValueConverter;
import org.eclipse.papyrus.infra.tools.converter.ConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.MultiConvertedValueContainer;
import org.eclipse.papyrus.infra.tools.converter.StringValueConverterStatus;
import org.eclipse.papyrus.uml.nattable.Activator;
import org.eclipse.papyrus.uml.nattable.messages.Messages;
import org.eclipse.papyrus.uml.nattable.paste.StereotypeApplicationStructure;
import org.eclipse.papyrus.uml.nattable.utils.Constants;
import org.eclipse.papyrus.uml.nattable.utils.UMLTableUtils;
import org.eclipse.papyrus.uml.tools.commands.ApplyStereotypeCommand;
import org.eclipse.papyrus.uml.tools.utils.CustomElementOperations;
import org.eclipse.papyrus.uml.tools.utils.EnumerationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;

/**
 * The cell manager used for Property of stereotypes
 * 
 * @author vl222926
 * 
 */
public class StereotypePropertyCellManager extends UMLFeatureCellManager {

	/**
	 * the error message
	 */
	public static final String SEVERAL_STEREOTYPES_WITH_THIS_FEATURE_ARE_APPLIED = Messages.StereotypePropertyCellManager_SeveralStereotypesWithThisFeatureAreApplied;

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.UMLFeatureCellManager#handles(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean handles(final Object columnElement, final Object rowElement) {
		return organizeAndResolvedObjects(columnElement, rowElement, null) != null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#doGetValue(java.lang.Object, java.lang.Object,
	 *      org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param tableManager
	 * @return
	 */
	@Override
	protected Object doGetValue(final Object columnElement, final Object rowElement, final INattableModelManager tableManager) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, null);
		if(umlObjects.size() == 2) {
			final Element el = (Element)umlObjects.get(0);
			final String id = (String)umlObjects.get(1);
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
			final List<Stereotype> stereotypesWithThisProperty = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id);
			if(stereotypesWithThisProperty.size() == 1) {
				return el.getValue(stereotypesWithThisProperty.get(0), prop.getName());
			} else if(stereotypesWithThisProperty.size() > 1) {
				return SEVERAL_STEREOTYPES_WITH_THIS_FEATURE_ARE_APPLIED;
			}
		}
		return NOT_AVALAIBLE;
	}

	/**
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 *         a list with 2 elements : the first one is the Element and the second one the string representing the property of stereotypes
	 */
	@Override
	protected List<Object> organizeAndResolvedObjects(final Object columnElement, final Object rowElement, final Map<?, ?> sharedMap) {
		List<Object> objects = null;
		final Object column = AxisUtils.getRepresentedElement(columnElement);
		final Object row = AxisUtils.getRepresentedElement(rowElement);
		if(column instanceof String && ((String)column).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX) && row instanceof Element) {
			objects = new ArrayList<Object>();
			objects.add(row);
			objects.add(column);
		}
		if(row instanceof String && ((String)row).startsWith(Constants.PROPERTY_OF_STEREOTYPE_PREFIX) && column instanceof Element) {
			objects = new ArrayList<Object>();
			objects.add(column);
			objects.add(row);
		}
		return objects;
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.uml.nattable.manager.cell.UMLFeatureCellManager#isCellEditable(java.lang.Object, java.lang.Object)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
		switch(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id).size()) {
		case 0:
			// to apply required stereotype before edition
			// see bug 426709: [Table 2][Stereotype] Papyrus Table must allows to edit stereotype properties even if the required stereotypes is not yet applied
			//  https://bugs.eclipse.org/bugs/show_bug.cgi?id=426709
			final int nbApplicablesSte = UMLTableUtils.getApplicableStereotypesWithThisProperty(el, id).size();
			return nbApplicablesSte == 1 && !prop.isDerived() && !prop.isReadOnly();
		case 1:
			return !prop.isDerived() && !prop.isReadOnly();
		default:
			return false;
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.nattable.manager.cell.AbstractCellManager#isCellEditable(java.lang.Object, java.lang.Object, java.util.Map)
	 * 
	 * @param columnElement
	 * @param rowElement
	 * @param sharedMap
	 * @return
	 */
	@Override
	public boolean isCellEditable(final Object columnElement, final Object rowElement, final Map<?, ?> sharedMap) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, sharedMap);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);

		switch(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id, sharedMap).size()) {
		case 0:
			//the element is not yet in the resource, and the stereotype required by a column is not yet applied
			//see bug 431691: [Table 2] Paste from Spreadsheet must be able to apply required stereotypes for column properties in all usecases
			//https://bugs.eclipse.org/bugs/show_bug.cgi?id=431691
			final Object container = sharedMap.get(org.eclipse.papyrus.infra.nattable.utils.Constants.PASTED_ELEMENT_CONTAINER_KEY);
			if(container instanceof Element) {
				Element parent = (Element)container;
				Property prop1 = UMLTableUtils.getRealStereotypeProperty(parent, id);
				if(prop1 != null && prop1.getOwner() instanceof Stereotype) {
					return CustomElementOperations.isStereotypeApplicable(parent, el, (Stereotype)prop1.eContainer());
				}
			}
			break;

		case 1:
			final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id, sharedMap);
			return !prop.isDerived() && !prop.isReadOnly();
		default:
			return false;
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetValueCommand(org.eclipse.emf.transaction.TransactionalEditingDomain,
	 *      java.lang.Object, java.lang.Object, java.lang.Object, org.eclipse.papyrus.infra.nattable.manager.table.INattableModelManager)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param tableManager
	 * @return
	 */
	@Override
	public Command getSetValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final Object newValue, final INattableModelManager tableManager) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		final Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
		final List<Stereotype> stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id);
		if(prop != null) {
			if(stereotypes.isEmpty()) {
				// Must first apply the stereotype
				return new RecordingCommand(domain, "Set Value") { //$NON-NLS-1$

					@Override
					protected void doExecute() {
						if(!applyRequiredStereotype(domain, el, id)) {
							throw new OperationCanceledException();
						} else {
							// Now recursively execute the set-string-value command
							Command command = getSetValueCommand(domain, columnElement, rowElement, newValue, tableManager);
							if(command == null || !command.canExecute()) {
								throw new OperationCanceledException();
							} else {
								domain.getCommandStack().execute(command);
							}
						}
					}
				};
			}

			if(stereotypes.size() == 1) {
				final EObject stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
				final EStructuralFeature steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
				return getSetValueCommand(domain, stereotypeApplication, steApFeature, newValue, columnElement, rowElement, tableManager);
			} else {
				//TODO : not yet managed
			}
		}
		return null;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.emf.nattable.manager.cell.EMFFeatureValueCellManager#getSetStringValueCommand(org.eclipse.emf.edit.domain.EditingDomain,
	 *      EObject, java.lang.Object, java.lang.Object, java.lang.String, java.util.Map)
	 * 
	 * @param domain
	 * @param columnElement
	 * @param rowElement
	 * @param newValue
	 * @param stringResolvers
	 * @return
	 */
	@Override
	public Command getSetStringValueCommand(final TransactionalEditingDomain domain, final Object columnElement, final Object rowElement, final String newValue, final AbstractStringValueConverter valueSolver, final INattableModelManager tableManager) {
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, null);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		Property prop = UMLTableUtils.getRealStereotypeProperty(el, id);
		List<Stereotype> stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id);
		ConvertedValueContainer<?> solvedValue = null;
		EObject stereotypeApplication = null;
		EStructuralFeature steApFeature = null;
		if(prop != null) {
			if(stereotypes.isEmpty()) {
				// Must first apply the stereotype
				return new RecordingCommand(domain, "Set Value") { //$NON-NLS-1$

					@Override
					protected void doExecute() {
						if(!applyRequiredStereotype(domain, el, id)) {
							throw new OperationCanceledException();
						} else {
							// Now recursively execute the set-string-value command
							Command command = getSetStringValueCommand(domain, columnElement, rowElement, newValue, valueSolver, tableManager);
							if(command == null || !command.canExecute()) {
								throw new OperationCanceledException();
							} else {
								domain.getCommandStack().execute(command);
							}
						}
					}
				};
			}

			if(stereotypes.size() == 1) {
				stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
				switch(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id).size()) {
				case 1:
					stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id);
					prop = UMLTableUtils.getRealStereotypeProperty(el, id);
					break;
				default:
					prop = null;
					stereotypes = Collections.emptyList();
					break;
				}
			}
		}
		//if the stereotype is not applied, we return null.
		if(stereotypeApplication == null) {
			return null;
		}
		solvedValue = valueSolver.deduceValueFromString(prop, newValue);
		steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
		if(prop.getType() instanceof Enumeration) {//Enumeration AND not EnumerationLiteral
			EEnum eenum = (EEnum)steApFeature.getEType();
			Object value = solvedValue.getConvertedValue();
			if(value instanceof Collection<?>) {
				final Collection<Enumerator> enumeratorList = EnumerationUtil.adaptToEnumeratorList(eenum, (Collection<?>)value);
				if(enumeratorList.size() == ((Collection<?>)value).size()) {
					solvedValue = new MultiConvertedValueContainer<Enumerator>(enumeratorList, solvedValue.getStatus());
				} else {
					IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, "Some enumeration literal can't be resolved", Collections.<String> emptyList()); //$NON-NLS-1$
					solvedValue = new ConvertedValueContainer<Object>(enumeratorList, status);
				}
			} else if(value instanceof EnumerationLiteral) {
				if(value != null) {
					final Enumerator enumerator = EnumerationUtil.adaptToEnumerator(eenum, (EnumerationLiteral)value);
					if(enumerator != null) {
						solvedValue = new ConvertedValueContainer<Enumerator>(enumerator, solvedValue.getStatus());
					} else {
						IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The enumeration literal represented by {0} can be resolved", newValue), Collections.singletonList(newValue)); //$NON-NLS-1$
						solvedValue = new ConvertedValueContainer<Object>(null, status);
					}
				}
			}
		}

		final CompositeCommand cmd = new CompositeCommand("Set Value As String Command"); //$NON-NLS-1$
		if(steApFeature == null || stereotypes.size() != 1) {
			IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, "The property of stereotype to use to do the set value can't be resolved", Collections.singletonList(newValue)); //$NON-NLS-1$
			solvedValue = new ConvertedValueContainer<Object>(null, status);
		} else {

			Object value = solvedValue.getConvertedValue();
			if((value != null) || (value == null && !(prop.getType() instanceof PrimitiveType))) {
				//we want avoid set null on element which doesn't allow it (FlowPort#direction) when the enum has not been properly resolved
				final Command setValueCommand = getSetValueCommand(domain, stereotypeApplication, steApFeature, value, columnElement, rowElement, tableManager);
				if(setValueCommand != null) {
					cmd.add(new EMFtoGMFCommandWrapper(setValueCommand));
				}
			}
		}
		final Command createProblemCommand = getCreateStringResolutionProblemCommand(domain, tableManager, columnElement, rowElement, newValue, solvedValue);
		if(createProblemCommand != null) {
			cmd.add(new EMFtoGMFCommandWrapper(createProblemCommand));
		} else {
			//we need to destroy associated cell problem 
			final Cell cell = tableManager.getCell(columnElement, rowElement);
			StringResolutionProblem stringPb = null;//we assume that there is only one string resolution problem for a cell
			if(cell != null && cell.getProblems().size() > 0) {
				for(final Problem current : cell.getProblems()) {
					if(current instanceof StringResolutionProblem) {
						stringPb = (StringResolutionProblem)current;
						break;
					}
				}
			}
			if(stringPb != null) {
				final DestroyElementRequest destroyRequest = new DestroyElementRequest(domain, stringPb, false);
				final IElementEditService commandProvider2 = ElementEditServiceUtils.getCommandProvider(stringPb);
				cmd.add(commandProvider2.getEditCommand(destroyRequest));
			}
		}
		if(cmd.isEmpty()) {
			return null;
		}
		return new GMFtoEMFCommandWrapper(cmd);
	}

	/**
	 * This method is used when we are pasting elements in detached mode
	 * 
	 * @param columnElement
	 *        the column element
	 * @param rowElement
	 *        the row element
	 * @param valueAsString
	 *        the value as string
	 * @param valueConverter
	 *        the value converter to use
	 * @param tableManager
	 *        the table manager
	 * @param sharedMap
	 *        a map with shared elements. The method may read/add elements to the shared map. These contributions will be managed by a paste post
	 *        action or by the paste manager itself
	 */
	@Override
	public void setStringValue(Object columnElement, Object rowElement, String valueAsString, AbstractStringValueConverter valueSolver, INattableModelManager tableManager, Map<?, ?> sharedMap) {
		if(valueAsString ==null || valueAsString.isEmpty()){
			return;
		}
		final List<Object> umlObjects = organizeAndResolvedObjects(columnElement, rowElement, sharedMap);
		final Element el = (Element)umlObjects.get(0);
		final String id = (String)umlObjects.get(1);
		Property prop = UMLTableUtils.getRealStereotypeProperty(el, id, sharedMap);
		List<Stereotype> stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id, sharedMap);

		if(stereotypes.size() == 0) {
			Object parentElement = sharedMap.get(org.eclipse.papyrus.infra.nattable.utils.Constants.PASTED_ELEMENT_CONTAINER_KEY);
			final Element element = prop.getOwner();
			if(element instanceof Stereotype && parentElement instanceof Element) {
				boolean isApplicable = CustomElementOperations.isStereotypeApplicable(((Element)parentElement).getNearestPackage(), el, (Stereotype)element);
				if(isApplicable) {
					//apply stereotype required by the column property using post actions mecanism
					final String postActionId = Constants.POST_ACTION_APPLY_STEREOTYPE_PREFIX + ((NamedElement)element).getQualifiedName();

					//we register a special post actions to conclude the stereotype application
					@SuppressWarnings("unchecked")
					final Collection<String> postActionIds = (Collection<String>)sharedMap.get(org.eclipse.papyrus.infra.nattable.utils.Constants.ADDITIONAL_POST_ACTIONS_TO_CONCLUDE_PASTE_KEY);
					postActionIds.add(postActionId);
					//we do the post action : we apply the streotype
					PastePostActionRegistry.INSTANCE.doPostAction(tableManager, postActionId, (EObject)parentElement, el, (Map<Object, Object>)sharedMap, id);
					stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id, sharedMap);
				}
			}
		}


		ConvertedValueContainer<?> solvedValue = null;
		EObject stereotypeApplication = null;
		EStructuralFeature steApFeature = null;
		if(sharedMap != null) {
			List<StereotypeApplicationStructure> struct = UMLTableUtils.findStereotypeApplicationDataStructure(el, id, sharedMap);
			//TODO : size > 1 not yet managed
			StereotypeApplicationStructure current = struct.get(0);
			stereotypeApplication = current.getStereotypeApplication();
			steApFeature = current.getFeature();
			prop = current.getProperty();
		} else {
			if(prop != null) {
				if(stereotypes.size() == 1) {
					stereotypeApplication = el.getStereotypeApplication(stereotypes.get(0));
					switch(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id, sharedMap).size()) {
					case 1:
						stereotypes = UMLTableUtils.getAppliedStereotypesWithThisProperty(el, id, sharedMap);
						prop = UMLTableUtils.getRealStereotypeProperty(el, id, sharedMap);
						break;
					default:
						prop = null;
						stereotypes = Collections.emptyList();
					}
				}
			}
			steApFeature = stereotypeApplication.eClass().getEStructuralFeature(prop.getName());
		}
		solvedValue = valueSolver.deduceValueFromString(prop, valueAsString);


		if(prop.getType() instanceof Enumeration) {//TODO : this case must be managed by the converter!
			EEnum eenum = (EEnum)steApFeature.getEType();
			Object value = solvedValue.getConvertedValue();
			if(value instanceof Collection<?>) {
				final Collection<Enumerator> enumeratorList = EnumerationUtil.adaptToEnumeratorList(eenum, (Collection<?>)value);
				if(enumeratorList.size() == ((Collection<?>)value).size()) {
					solvedValue = new MultiConvertedValueContainer<Enumerator>(enumeratorList, solvedValue.getStatus());
				} else {
					IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, "Some enumeration literal can't be resolved", Collections.<String> emptyList()); //$NON-NLS-1$
					solvedValue = new ConvertedValueContainer<Object>(enumeratorList, status);
				}
			} else if(value instanceof EnumerationLiteral) {
				if(value != null) {
					final Enumerator enumerator = EnumerationUtil.adaptToEnumerator(eenum, (EnumerationLiteral)value);
					if(enumerator != null) {
						solvedValue = new ConvertedValueContainer<Enumerator>(enumerator, solvedValue.getStatus());
					} else {
						IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind("The enumeration literal represented by {0} can be resolved", valueAsString), Collections.singletonList(valueAsString)); //$NON-NLS-1$
						solvedValue = new ConvertedValueContainer<Object>(null, status);
					}
				}
			}
		}

		//		final CompositeCommand cmd = new CompositeCommand("Set Value As String Command"); //$NON-NLS-1$
		if(steApFeature == null || stereotypes.size() != 1) {
			IStatus status = new StringValueConverterStatus(IStatus.ERROR, Activator.PLUGIN_ID, "The property of stereotype to use to do the set value can't be resolved", Collections.singletonList(valueAsString)); //$NON-NLS-1$
			solvedValue = new ConvertedValueContainer<Object>(null, status);
		} else {

			Object value = solvedValue.getConvertedValue();
			if((value != null) || (value == null && !(prop.getType() instanceof PrimitiveType))) {
				//we want avoid set null on element which doesn't allow it (FlowPort#direction) when the enum has not been properly resolved
				stereotypeApplication.eSet(steApFeature, value);
			}
		}

		createStringResolutionProblem(tableManager, columnElement, rowElement, valueAsString, solvedValue, sharedMap);

	}

	/**
	 * 
	 * @param el
	 *        an element of the model
	 * @param propertyId
	 *        the id of the edited property
	 * @return <code>true</code> if a stereotype has been applied
	 */
	private static boolean applyRequiredStereotype(TransactionalEditingDomain domain, final Element el, final String propertyId) {
		if(UMLTableUtils.getAppliedStereotypesWithThisProperty(el, propertyId).size() == 0) {
			final List<Stereotype> stereotypesList = UMLTableUtils.getApplicableStereotypesWithThisProperty(el, propertyId);
			if(stereotypesList.size() == 1) {
				final ApplyStereotypeCommand applyCommand = new ApplyStereotypeCommand(el, stereotypesList.get(0), domain);
				domain.getCommandStack().execute(applyCommand);
				return true;
			}
		}
		return false;
	}
}
