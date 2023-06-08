import { FormGroup, FormControl, AbstractControl } from '@angular/forms';

export default class ValidateForm {
  static validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach((field) => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsDirty({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
}

export function passwordMatch(
  password: AbstractControl,
  repPassword: AbstractControl
) {
  return () => {
    if (password.value === repPassword.value) {
      return null;
    }
    return { passwordMismatchError: true };
  };
}
