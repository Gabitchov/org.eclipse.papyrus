package org.eclipse.papyrus.infra.core.sasheditor.tests.utils.memoryleak;

import java.util.HashMap;
import java.util.Map;

/**
 * For testing purpose
 * @copyright http://www.forkcan.com/viewcode/215/Detecting-memory-leak-in-unit-test
 *
 */
public class LeakingObject {

  static Map<LeakingObject, Object> leakingMap = new HashMap<LeakingObject, Object>();

  public LeakingObject() {
    leakingMap.put(this, System.currentTimeMillis());
  }

}