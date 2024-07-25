package com.beuben.pokemontcgcollectorbackend.architecture.rules;

import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.beuben.pokemontcgcollectorbackend.architecture.ArchUnitConstants.MAX_METHOD_PARAMETERS_NUMBER;

public class HaveThreeParametersMaxCondition extends ArchCondition<JavaMethod> {
  public HaveThreeParametersMaxCondition() {
    super("Have three parameters max");
  }

  public static HaveThreeParametersMaxCondition haveThreeParametersMax() {
    return new HaveThreeParametersMaxCondition();
  }

  @Override
  public void check(JavaMethod method, ConditionEvents conditionEvents) {
    if (method.getParameters().size() > MAX_METHOD_PARAMETERS_NUMBER) {
      final var message = String.format("Method %s in class %s has %d parameters which is more than %d",
          method.getName(),
          method.getOwner().getName(),
          method.getParameters().size(),
          MAX_METHOD_PARAMETERS_NUMBER);

      conditionEvents.add(SimpleConditionEvent.violated(method, message));
    }
  }
}
