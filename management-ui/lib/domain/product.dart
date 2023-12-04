import 'package:get/get.dart';

class Product {
  final String productId;
  final ProductState productState;
  final String productName;
  final String productDescription;
  final double priceInBrl;
  final String imageUrl;

  Product({
    required this.productId,
    required this.productState,
    required this.productName,
    required this.productDescription,
    required this.priceInBrl,
    required this.imageUrl,
  });

  factory Product.fromMap(Map<String, dynamic> map) {
    return Product(
      productId: map['productId'],
      productState: ProductState.fromMap(map['productState']),
      productName: map['productName'],
      productDescription: map['productDescription'],
      priceInBrl: map['priceInBrl'],
      imageUrl: map['imageUrl'],
    );
  }
}

enum ProductState {
  archived("product-state-archived"),
  shown("product-state-shown"),
  hidden("product-state-hidden"),
  unknown("product-state-out-of-stic");

  final String code;

  const ProductState(this.code);

  static ProductState fromMap(Map<String, dynamic> map) {
    final resolvedState = ProductState.values.firstWhereOrNull(
      (ps) => ps.code == map['code'],
    );

    if (resolvedState == null) {
      return ProductState.unknown;
    } else {
      return resolvedState;
    }
  }
}
