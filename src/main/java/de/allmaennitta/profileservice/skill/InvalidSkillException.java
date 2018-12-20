package de.allmaennitta.profileservice.skill;

import org.springframework.validation.BindingResult;

public class InvalidSkillException extends RuntimeException {
  private BindingResult bindingResult;

  public InvalidSkillException(BindingResult bindingResult) {
    super(bindingResult.toString());
    this.bindingResult = bindingResult;
  }

  public BindingResult getBindingResult() {
    return bindingResult;
  }

  public void setBindingResult(BindingResult bindingResult) {
    this.bindingResult = bindingResult;
  }
}
