import 'package:get/get.dart';

// TODO: Remove this if StateMixin is powerful enough
mixin ExternallyDependentController<T> {
  RxBool _isLoading = false.obs;
  RxBool _hasError = false.obs;
  Rx<Exception> _error = Exception().obs;

  bool get isLoading => _isLoading.isTrue;

  bool get hasError => _hasError.isTrue;

  Exception get error => _error.value;

  // Set loading state
  void startLoad({bool clearErrors = true}) {
    _isLoading.value = true;

    if (clearErrors) _hasError.value = false;
  }

  void completeLoad({Exception? error}) {
    _isLoading.value = false;

    if (error != null) {
      _error.value = error;
      _hasError.value = true;
    }
  }
}
