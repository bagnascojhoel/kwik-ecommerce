import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:kwik_ecommerce_management_ui/domain/product.dart';
import 'package:kwik_ecommerce_management_ui/infrastructure/app_configuration.dart';
import 'package:kwik_ecommerce_management_ui/infrastructure/http/product_collection_response.dart';

import '../../domain/product_repository.dart';

class ProductRepositoryHttp implements ProductRepository {
  static Uri baseUrl =
      Uri.parse("${AppConfiguration.kwikEcommerceApiUrl}/products");

  @override
  Future<List<Product>> findProducts() async {
    final response = await http.get(baseUrl);

    if (response.statusCode == 200) {
      final ProductCollectionResponse productCollection =
          ProductCollectionResponse.fromMap(json.decode(response.body));
      return productCollection.products;
    } else {
      // TODO: handle error
      // TODO: add global timeout
      throw UnsupportedError("error handling not implemented");
    }
  }

  @override
  Future<void> saveProduct() {
    // TODO: implement saveProduct
    throw UnimplementedError();
  }
}
