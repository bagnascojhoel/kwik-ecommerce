import 'package:kwik_ecommerce_management_ui/domain/product.dart';

abstract class ProductRepository {
  Future<void> saveProduct();

  Future<List<Product>> findProducts();
}