import 'package:flutter/material.dart';

class ProductStateDataCell extends DataCell {
  ProductStateDataCell({required String state})
      : super(_ProductState(
          state: state,
        ));
}

// TODO: Use or discard this widget
class _ProductState extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Placeholder();
  }

  _ProductState({required String state});
}
