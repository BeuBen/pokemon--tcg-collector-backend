package com.beuben.pokemontcgcollectorbackend.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ImplementMethodCondition extends ArchCondition<JavaClass> {
  private final String methodName;

  public ImplementMethodCondition(final String methodName) {
    super("Implement %s method".formatted(methodName));
    this.methodName = methodName;
  }

  public static ImplementMethodCondition implementMethod(final String methodName) {
    return new ImplementMethodCondition(methodName);
  }

  @Override
  public void check(JavaClass javaClass, ConditionEvents conditionEvents) {
    final var methods = javaClass.getMethods();

    if (methods.stream().noneMatch(method -> method.getName().equals(methodName))) {
      final var message = String.format("Class %s does not implement %s method",
          javaClass.getName(), methodName);
      conditionEvents.add(SimpleConditionEvent.violated(javaClass, message));
    }
  }
}
