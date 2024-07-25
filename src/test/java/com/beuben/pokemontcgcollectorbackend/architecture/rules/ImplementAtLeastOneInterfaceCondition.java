package com.beuben.pokemontcgcollectorbackend.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ImplementAtLeastOneInterfaceCondition extends ArchCondition<JavaClass> {
  public ImplementAtLeastOneInterfaceCondition() {
    super("Implement at least one interface");
  }

  public static ImplementAtLeastOneInterfaceCondition implementAtLeastOneInterface() {
    return new ImplementAtLeastOneInterfaceCondition();
  }

  @Override
  public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
    if (javaClass.getInterfaces().isEmpty()) {
      final var message = String.format("Class %s does not implement any interface", javaClass.getName());
      conditionEvents.add(SimpleConditionEvent.violated(javaClass, message));
    }
  }
}
