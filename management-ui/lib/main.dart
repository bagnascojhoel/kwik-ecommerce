import 'package:flutter/material.dart';
import 'package:get/get.dart';
import 'package:kwik_ecommerce_management_ui/domain/product_repository.dart';
import 'package:kwik_ecommerce_management_ui/infrastructure/http/product_repository_http.dart';
import 'package:kwik_ecommerce_management_ui/ui/material/material_styled_ui.dart';

void main() {
  /* TODO: Maybe will need to add logic to switch between
         Material (Android) and Cupertino (iOS)
  */
  // TODO: Why the dev.env files are not being loaded?
  Get.lazyPut<ProductRepository>(
    () => ProductRepositoryHttp(),
  );

  runApp(MaterialStyledUi());
}
