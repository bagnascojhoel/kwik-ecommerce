import '../../domain/product.dart';

class ProductCollectionResponse {
  final List<Product> products;

  ProductCollectionResponse({required this.products});

  factory ProductCollectionResponse.fromMap(Map<String, dynamic> map) {
    List<dynamic> productsJson = map['products'];
    List<Product> products = productsJson.map((productJson) => Product.fromMap(productJson)).toList();

    return ProductCollectionResponse(products: products);
  }
}