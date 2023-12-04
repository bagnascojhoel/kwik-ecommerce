import 'package:flutter/material.dart';

class ProductStateDataCell extends DataCell {
  ProductStateDataCell({required String state})
      : super(_ProductState(
          state: state,
        ));
}

class _ProductState extends StatelessWidget {
  @override
  Widget build(BuildContext context) {}

  _ProductState({required String state});
}
